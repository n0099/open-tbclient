package com.baidu.tieba.recommend;

import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.HotspotData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.SearchActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.service.MyReceiver;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.view.BaseWebView;
import com.baidu.tieba.view.CustomScrollView;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RecommendActivity extends BaseActivity implements BaseWebView.OnLoadUrlListener, AsyncImageLoader.ImageCallback {
    private static final int FLIP_INTERVAL = 2000;
    private static final int IMAGE_NUM = 3;
    private TextView bannerText;
    private HotspotData[] currentHotspot;
    private HotspotPagerAdapter hotspotAdapter;
    private HashMap<String, Bitmap> hotspotBitmap;
    private HotspotData[] hotspotInfo;
    private ViewPager hotspotPager;
    private View hotspotView;
    private View hotspotWebView;
    private Button loginButton;
    private HotspotAsyncTask mHotspotAsyncTask;
    private List<View> mHotspotViews;
    private AsyncImageLoader mImageLoader;
    private MyOnPageChangeListener mOnPageChangeListener;
    private ProgressBar mProgressBar;
    private RecommendAsyncTask mRecommendAsyncTask;
    private CustomScrollView mScrollView;
    private ImageView radioButton0;
    private ImageView radioButton1;
    private ImageView radioButton2;
    MyReceiver receiver;
    private Button refreshButton;
    private Button searchButton;
    private BaseWebView webview;
    private ImageView webviewFailImageView;
    private int position = 1073741823;
    Handler mHandler = new Handler();
    private boolean webviewCached = false;
    private boolean refreshHotspot = false;
    private boolean refreshWebview = false;
    private boolean webviewSucess = true;
    private boolean hotspotSucess = true;
    private boolean isRefreshing = false;
    private Runnable playRunnable = new Runnable() { // from class: com.baidu.tieba.recommend.RecommendActivity.1
        @Override // java.lang.Runnable
        public void run() {
            RecommendActivity.this.position++;
            RecommendActivity.this.hotspotPager.setCurrentItem(RecommendActivity.this.position, true);
            RecommendActivity.this.mHandler.postDelayed(this, 2000L);
        }
    };
    private View.OnClickListener mOncClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recommend.RecommendActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login /* 2131230785 */:
                    LoginActivity.startActivityNoExitDialog(RecommendActivity.this);
                    return;
                case R.id.search /* 2131230809 */:
                    SearchActivity.startActivity(RecommendActivity.this, RecommendActivity.this.getString(R.string.recommend_title));
                    return;
                case R.id.refresh /* 2131230871 */:
                case R.id.hotspot_webview_item /* 2131231008 */:
                    RecommendActivity.this.refresh();
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnClickListener hotspotClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recommend.RecommendActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            String id = (String) arg0.getTag(R.id.pburl_id);
            if (id != null) {
                PbActivity.startActivityToFrs(RecommendActivity.this, id, "image_pblist");
            }
        }
    };

    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_activity);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        this.mHandler.removeCallbacks(this.playRunnable);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.app.stopLocationServer();
        if (this.receiver != null) {
            unregisterReceiver(this.receiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        this.mHandler.removeCallbacks(this.playRunnable);
        this.mHandler.postDelayed(this.playRunnable, 2000L);
        String id = TiebaApplication.getCurrentAccount();
        if (id != null && id.length() > 0) {
            this.loginButton.setVisibility(4);
            this.loginButton.setClickable(false);
        } else {
            this.loginButton.setVisibility(0);
            this.loginButton.setClickable(true);
        }
        super.onResume();
    }

    private void init() {
        this.mScrollView = (CustomScrollView) findViewById(R.id.mScrollView);
        this.hotspotView = findViewById(R.id.hotspot_item);
        this.hotspotWebView = findViewById(R.id.hotspot_webview_item);
        this.bannerText = (TextView) this.hotspotView.findViewById(R.id.banner_text);
        this.hotspotPager = (ViewPager) this.hotspotView.findViewById(R.id.pagerview);
        this.webview = (BaseWebView) this.hotspotWebView.findViewById(R.id.recommend_webView);
        this.webview.setOnLoadUrlListener(this);
        this.webviewFailImageView = (ImageView) this.hotspotWebView.findViewById(R.id.webview_fail_imageview);
        this.loginButton = (Button) findViewById(R.id.login);
        this.searchButton = (Button) findViewById(R.id.search);
        this.refreshButton = (Button) findViewById(R.id.refresh);
        this.mProgressBar = (ProgressBar) findViewById(R.id.recommend_progress);
        ViewGroup.LayoutParams hotspotLayout = this.hotspotPager.getLayoutParams();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        hotspotLayout.height = (dm.widthPixels * 25) / 64;
        this.hotspotPager.setLayoutParams(hotspotLayout);
        this.hotspotBitmap = new HashMap<>();
        this.mImageLoader = new AsyncImageLoader(this);
        this.currentHotspot = new HotspotData[3];
        this.radioButton0 = (ImageView) this.hotspotView.findViewById(R.id.tag_view0);
        this.radioButton1 = (ImageView) this.hotspotView.findViewById(R.id.tag_view1);
        this.radioButton2 = (ImageView) this.hotspotView.findViewById(R.id.tag_view2);
        this.hotspotInfo = new HotspotData[3];
        for (int i = 0; i < 3; i++) {
            this.currentHotspot[i] = new HotspotData();
            this.hotspotInfo[i] = new HotspotData();
        }
        this.loginButton.setOnClickListener(this.mOncClickListener);
        this.searchButton.setOnClickListener(this.mOncClickListener);
        this.refreshButton.setOnClickListener(this.mOncClickListener);
        this.hotspotAdapter = new HotspotPagerAdapter(this, null);
        this.hotspotPager.setAdapter(this.hotspotAdapter);
        this.hotspotPager.setCurrentItem(this.position);
        this.mHotspotViews = new ArrayList();
        View tempView = this.hotspotPager.findViewById(R.id.recommend_hotspot0);
        tempView.setOnClickListener(this.hotspotClickListener);
        tempView.setBackgroundResource(R.drawable.image_fail);
        this.mHotspotViews.add(0, tempView);
        View tempView2 = this.hotspotPager.findViewById(R.id.recommend_hotspot1);
        tempView2.setOnClickListener(this.hotspotClickListener);
        tempView2.setBackgroundResource(R.drawable.image_fail);
        this.mHotspotViews.add(1, tempView2);
        View tempView3 = this.hotspotPager.findViewById(R.id.recommend_hotspot2);
        tempView3.setOnClickListener(this.hotspotClickListener);
        tempView3.setBackgroundResource(R.drawable.image_fail);
        this.mHotspotViews.add(2, tempView3);
        this.mOnPageChangeListener = new MyOnPageChangeListener();
        this.hotspotPager.setOnPageChangeListener(this.mOnPageChangeListener);
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.receiver = new MyReceiver(this);
        registerReceiver(this.receiver, filter);
        refresh();
    }

    private void cancelTask() {
        if (this.mRecommendAsyncTask != null) {
            this.mRecommendAsyncTask.cancel();
        }
        if (this.mHotspotAsyncTask != null) {
            this.mHotspotAsyncTask.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class HotspotPagerAdapter extends PagerAdapter {
        int tag;

        private HotspotPagerAdapter() {
            this.tag = 0;
        }

        /* synthetic */ HotspotPagerAdapter(RecommendActivity recommendActivity, HotspotPagerAdapter hotspotPagerAdapter) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View collection, int position) {
            if (position >= RecommendActivity.this.mHotspotViews.size()) {
                position %= RecommendActivity.this.mHotspotViews.size();
            }
            if (position < 0) {
                position = (-position) % RecommendActivity.this.mHotspotViews.size();
            }
            this.tag = position;
            if (((View) RecommendActivity.this.mHotspotViews.get(position)).getParent() == collection) {
                ((ViewPager) collection).removeView((View) RecommendActivity.this.mHotspotViews.get(position));
            }
            ((ViewPager) collection).addView((View) RecommendActivity.this.mHotspotViews.get(position), 0);
            return RecommendActivity.this.mHotspotViews.get(position);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(View collection, int position, Object view) {
            if (position >= RecommendActivity.this.mHotspotViews.size()) {
                position %= RecommendActivity.this.mHotspotViews.size();
            }
            if (position < 0) {
                position = (-position) % RecommendActivity.this.mHotspotViews.size();
            }
            if (this.tag != position) {
                ((ViewPager) collection).removeView((View) RecommendActivity.this.mHotspotViews.get(position));
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void finishUpdate(View arg0) {
        }

        @Override // android.support.v4.view.PagerAdapter
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override // android.support.v4.view.PagerAdapter
        public Parcelable saveState() {
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void startUpdate(View arg0) {
        }
    }

    /* loaded from: classes.dex */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public MyOnPageChangeListener() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int arg0) {
            if (arg0 == 1) {
                RecommendActivity.this.mHandler.removeCallbacks(RecommendActivity.this.playRunnable);
            } else if (arg0 == 0) {
                RecommendActivity.this.mHandler.removeCallbacks(RecommendActivity.this.playRunnable);
                RecommendActivity.this.mHandler.postDelayed(RecommendActivity.this.playRunnable, 2000L);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int arg0) {
            RecommendActivity.this.position = arg0;
            String title = (String) ((View) RecommendActivity.this.mHotspotViews.get(RecommendActivity.this.position % 3)).getTag(R.id.title_id);
            RecommendActivity.this.bannerText.setText(title);
            RecommendActivity.this.radioButton0.setBackgroundResource(R.drawable.banner_dot);
            RecommendActivity.this.radioButton1.setBackgroundResource(R.drawable.banner_dot);
            RecommendActivity.this.radioButton2.setBackgroundResource(R.drawable.banner_dot);
            if (arg0 % 3 == 0) {
                RecommendActivity.this.radioButton0.setBackgroundResource(R.drawable.banner_dot_hl);
            } else if (arg0 % 3 == 1) {
                RecommendActivity.this.radioButton1.setBackgroundResource(R.drawable.banner_dot_hl);
            } else if (arg0 % 3 == 2) {
                RecommendActivity.this.radioButton2.setBackgroundResource(R.drawable.banner_dot_hl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RecommendAsyncTask extends AsyncTask<Object, Integer, String> {
        private String data;
        private NetWork mNetWork;

        private RecommendAsyncTask() {
            this.mNetWork = null;
        }

        /* synthetic */ RecommendAsyncTask(RecommendActivity recommendActivity, RecommendAsyncTask recommendAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Object... arg0) {
            this.mNetWork = new NetWork(Config.RECOMMEND_ADDRESS);
            this.mNetWork.addPostData("_version_more", NetWorkCore.NET_TYPE_NET);
            BDLocation mLocation = TiebaApplication.app.getLocation();
            if (mLocation != null) {
                this.mNetWork.addPostData("lbs", String.valueOf(String.valueOf(mLocation.getLatitude())) + "," + String.valueOf(mLocation.getLongitude()));
            }
            try {
                this.data = this.mNetWork.postNetData();
                if (this.mNetWork.isNetSuccess()) {
                    return this.data;
                }
            } catch (Exception ex) {
                TiebaLog.e("RecommendAsyncTask", "doInBackground", "error = " + ex.getMessage());
            }
            return null;
        }

        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            RecommendActivity.this.isRefreshing = false;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            RecommendActivity.this.hotspotWebView.setOnClickListener(null);
            if (this.mNetWork == null || !this.mNetWork.isNetSuccess() || result == null) {
                RecommendActivity.this.webviewSucess = false;
                String data = DatabaseService.getNoAccountData(6);
                if (data != null && data.length() > 1) {
                    RecommendActivity.this.webviewCached = true;
                    RecommendActivity.this.webview.loadDataWithBaseURL("", data, "text/html", "utf-8", "");
                }
                if (!RecommendActivity.this.webviewCached) {
                    RecommendActivity.this.webviewFailImageView.setVisibility(0);
                    RecommendActivity.this.webview.setVisibility(8);
                    RecommendActivity.this.hotspotWebView.setOnClickListener(RecommendActivity.this.mOncClickListener);
                }
            } else {
                DatabaseService.cashNoAccountData(result, 6);
                RecommendActivity.this.webview.loadDataWithBaseURL("", result, "text/html", "utf-8", "");
                RecommendActivity.this.webviewCached = true;
                RecommendActivity.this.webviewFailImageView.setVisibility(8);
                RecommendActivity.this.webview.setVisibility(0);
            }
            RecommendActivity.this.refreshWebview = true;
            RecommendActivity.this.onRefreshFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class HotspotAsyncTask extends AsyncTask<Object, Integer, Boolean> {
        private String data;
        private NetWork mNetWork;

        private HotspotAsyncTask() {
            this.mNetWork = null;
            this.data = null;
        }

        /* synthetic */ HotspotAsyncTask(RecommendActivity recommendActivity, HotspotAsyncTask hotspotAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Object... arg0) {
            this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/s/recommendPic/");
            RecommendActivity.this.hotspotSucess = false;
            try {
                this.data = new String(this.mNetWork.postNetData());
                if (!this.mNetWork.isRequestSuccess()) {
                    this.data = null;
                }
            } catch (Exception ex) {
                TiebaLog.e("HotspotAsyncTask", "doInBackground", "error = " + ex.getMessage());
            }
            if (this.mNetWork == null || !this.mNetWork.isRequestSuccess() || this.data == null) {
                this.data = DatabaseService.getNoAccountData(5);
            }
            if (this.data != null) {
                try {
                    JSONObject json = new JSONObject(this.data);
                    JSONArray jlist = json.optJSONArray("recommend_pic");
                    if (jlist != null && jlist.length() >= 3) {
                        for (int i = 0; i < 3; i++) {
                            RecommendActivity.this.hotspotInfo[i].parserJson(jlist.getJSONObject(i));
                        }
                        RecommendActivity.this.hotspotSucess = true;
                        DatabaseService.cashNoAccountData(this.data, 5);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (RecommendActivity.this.hotspotSucess) {
                try {
                    File file = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + Config.TMP_HOTSPOT_DIR_NAME + "/");
                    File[] list = file.listFiles();
                    if (list != null) {
                        for (int i2 = 0; i2 < list.length; i2++) {
                            boolean needCached = false;
                            int j = 0;
                            while (true) {
                                if (j >= 3) {
                                    break;
                                }
                                String name = StringHelper.getNameFromUrl(RecommendActivity.this.hotspotInfo[j].getBitmap());
                                String cachename = StringHelper.getNameFromUrl(list[i2].getPath());
                                if (!name.equals(cachename)) {
                                    j++;
                                } else {
                                    needCached = true;
                                    break;
                                }
                            }
                            if (!needCached) {
                                list[i2].delete();
                            }
                        }
                    }
                    File[] fileArr = null;
                } catch (Exception ex2) {
                    TiebaLog.e(getClass().getName(), "run", ex2.getMessage());
                }
            }
            return Boolean.valueOf(RecommendActivity.this.hotspotSucess);
        }

        public void cancel() {
            RecommendActivity.this.isRefreshing = false;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            Bitmap bitmap;
            if (result.booleanValue()) {
                for (int i = 0; i < 3; i++) {
                    if (((Bitmap) RecommendActivity.this.hotspotBitmap.get(RecommendActivity.this.hotspotInfo[i].getBitmap())) == null && (bitmap = RecommendActivity.this.mImageLoader.loadHotspotImage(RecommendActivity.this.hotspotInfo[i].getBitmap(), RecommendActivity.this)) != null) {
                        RecommendActivity.this.hotspotBitmap.put(RecommendActivity.this.hotspotInfo[i].getBitmap(), bitmap);
                    }
                }
            }
            RecommendActivity.this.refreshHotspot = true;
            RecommendActivity.this.onRefreshFinish();
        }
    }

    private void refreshImage() {
        for (int i = 0; i < 3; i++) {
            View temp = this.mHotspotViews.get(i);
            if (this.hotspotBitmap.get(this.hotspotInfo[i].getBitmap()) != null) {
                temp.setBackgroundDrawable(new BitmapDrawable(this.hotspotBitmap.get(this.hotspotInfo[i].getBitmap())));
            } else {
                temp.setBackgroundResource(R.drawable.image_fail);
            }
        }
    }

    @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
    public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
        this.hotspotBitmap.put(imageUrl, bitmap);
        refreshImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (!this.isRefreshing) {
            this.isRefreshing = true;
            this.mProgressBar.setVisibility(0);
            this.mImageLoader.cancelAllAsyncTask();
            this.refreshHotspot = false;
            this.refreshWebview = false;
            this.webviewSucess = true;
            this.hotspotSucess = true;
            cancelTask();
            this.mRecommendAsyncTask = new RecommendAsyncTask(this, null);
            this.mRecommendAsyncTask.execute(new Object[0]);
            this.mHotspotAsyncTask = new HotspotAsyncTask(this, null);
            this.mHotspotAsyncTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefreshFinish() {
        if (this.refreshHotspot && this.refreshWebview) {
            if (!this.webviewSucess || !this.hotspotSucess) {
                showToast(getResources().getString(R.string.neterror));
            }
            if (this.hotspotSucess) {
                for (int i = 0; i < 3; i++) {
                    View temp = this.mHotspotViews.get(i);
                    if (this.hotspotBitmap.get(this.hotspotInfo[i].getBitmap()) != null) {
                        temp.setBackgroundDrawable(new BitmapDrawable(this.hotspotBitmap.get(this.hotspotInfo[i].getBitmap())));
                    } else {
                        temp.setBackgroundResource(R.drawable.image_fail);
                    }
                    temp.setTag(R.id.title_id, this.hotspotInfo[i].getTitle());
                    temp.setTag(R.id.pburl_id, this.hotspotInfo[i].getPbKey());
                }
                this.bannerText.setText(this.hotspotInfo[this.position % 3].getTitle());
                this.radioButton0.setBackgroundResource(R.drawable.banner_dot_hl);
                this.radioButton1.setBackgroundResource(R.drawable.banner_dot);
                this.radioButton2.setBackgroundResource(R.drawable.banner_dot);
            }
            for (String value : this.hotspotBitmap.keySet()) {
                boolean needCached = false;
                int j = 0;
                while (true) {
                    if (j < 3) {
                        if (!value.equals(this.hotspotInfo[j].getBitmap())) {
                            j++;
                        } else {
                            needCached = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!needCached) {
                    if (this.hotspotBitmap.get(value) != null) {
                        this.hotspotBitmap.get(value).recycle();
                    }
                    this.hotspotBitmap.remove(value);
                }
            }
            this.isRefreshing = false;
            this.mProgressBar.setVisibility(8);
            this.mScrollView.setVisibility(0);
        }
    }

    public void resetProxy() {
        try {
            BaseWebView.disablePlatformNotifications();
            BaseWebView.enablePlatformNotifications();
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "resetProxy", e.getMessage());
        }
    }

    @Override // com.baidu.tieba.view.BaseWebView.OnLoadUrlListener
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        int start = url.indexOf("kz=") + 3;
        if (start > 2) {
            int end = start;
            while (end < url.length() && url.charAt(end) != '&') {
                end++;
            }
            String id = url.substring(start, end);
            if (id != null && id != "") {
                PbActivity.startActivityToFrs(this, id, "hot_pblist");
            }
        }
        int start2 = url.indexOf("kw=") + 3;
        if (start2 > 2) {
            int end2 = start2;
            while (end2 < url.length() && url.charAt(end2) != '&') {
                end2++;
            }
            String id2 = URLDecoder.decode(url.substring(start2, end2));
            if (id2 != null && id2 != "") {
                FrsActivity.startAcitivity(this, id2, null);
                return true;
            }
            return true;
        }
        return true;
    }
}
