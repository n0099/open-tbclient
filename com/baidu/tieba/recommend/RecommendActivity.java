package com.baidu.tieba.recommend;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseWebView;
import com.baidu.tieba.view.CustomScrollView;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class RecommendActivity extends BaseActivity implements BaseWebView.OnLoadUrlListener {
    public static boolean pvSign = false;
    private View hotspotWebView;
    private ProgressBar mProgressBar;
    private RecommendAsyncTask mRecommendAsyncTask;
    private CustomScrollView mScrollView;
    private BaseWebView webview;
    private ImageView webviewFailImageView;
    private boolean webviewCached = false;
    private boolean refreshWebview = false;
    private boolean webviewSucess = true;
    private boolean isRefreshing = false;
    private String requestPage = "0";
    private View.OnClickListener mOncClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recommend.RecommendActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.hotspot_webview_item /* 2131231110 */:
                    RecommendActivity.this.refresh();
                    return;
                default:
                    return;
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
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.app.stopLocationServer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        Long lastTime = Long.valueOf(TiebaApplication.app.getRefreshRecommendTime());
        if (!this.isRefreshing && System.currentTimeMillis() - lastTime.longValue() > Config.REFRESH_RECOMMEND_INTERVAL.longValue()) {
            refresh();
        }
        super.onResume();
    }

    private void init() {
        this.mScrollView = (CustomScrollView) findViewById(R.id.mScrollView);
        this.hotspotWebView = findViewById(R.id.hotspot_webview_item);
        this.webview = (BaseWebView) this.hotspotWebView.findViewById(R.id.recommend_webView);
        this.webview.setOnLoadUrlListener(this);
        this.webviewFailImageView = (ImageView) this.hotspotWebView.findViewById(R.id.webview_fail_imageview);
        this.mProgressBar = (ProgressBar) findViewById(R.id.recommend_progress);
        refresh();
    }

    private void cancelTask() {
        if (this.mRecommendAsyncTask != null) {
            this.mRecommendAsyncTask.cancel();
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
            this.mNetWork = new NetWork(Config.RECOMMEND_ADDRESS_NEW);
            this.mNetWork.setIsJson(false);
            this.mNetWork.addPostData("_version_more", NetWorkCore.NET_TYPE_NET);
            this.mNetWork.addPostData("platform", "android");
            this.mNetWork.addPostData("page", RecommendActivity.this.requestPage);
            if (RecommendActivity.pvSign) {
                RecommendActivity.pvSign = false;
                this.mNetWork.addPostData("msg_click", NetWorkCore.NET_TYPE_NET);
            }
            Location mLocation = TiebaApplication.app.getLocation();
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
                    RecommendActivity.this.webview.loadDataWithBaseURL(Config.SERVER_ADDRESS, data, "text/html", "utf-8", "");
                }
                if (!RecommendActivity.this.webviewCached) {
                    RecommendActivity.this.webviewFailImageView.setVisibility(0);
                    RecommendActivity.this.webview.setVisibility(8);
                    RecommendActivity.this.hotspotWebView.setOnClickListener(RecommendActivity.this.mOncClickListener);
                }
            } else {
                DatabaseService.cashNoAccountData(result, 6);
                RecommendActivity.this.webview.loadDataWithBaseURL(Config.SERVER_ADDRESS, result, "text/html", "utf-8", "");
                RecommendActivity.this.webviewCached = true;
                RecommendActivity.this.webviewFailImageView.setVisibility(8);
                RecommendActivity.this.webview.setVisibility(0);
            }
            RecommendActivity.this.refreshWebview = true;
            RecommendActivity.this.onRefreshFinish();
        }
    }

    public void refresh() {
        if (!this.isRefreshing) {
            this.isRefreshing = true;
            this.mProgressBar.setVisibility(0);
            this.refreshWebview = false;
            this.webviewSucess = true;
            cancelTask();
            this.mRecommendAsyncTask = new RecommendAsyncTask(this, null);
            this.mRecommendAsyncTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefreshFinish() {
        if (this.refreshWebview) {
            if (!this.webviewSucess) {
                showToast(getResources().getString(R.string.neterror));
            } else {
                TiebaApplication.app.setRefreshRecommendTime(System.currentTimeMillis());
            }
            this.isRefreshing = false;
            this.mProgressBar.setVisibility(8);
            this.mScrollView.setVisibility(0);
            this.mScrollView.scrollTo(0, 0);
        }
    }

    public void resetPage() {
        this.requestPage = "0";
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
            if (id != null && id.length() >= 0) {
                PbActivity.startAcitivity(this, id, "hot_pblist");
            }
        } else {
            int start2 = url.indexOf("kw=") + 3;
            if (start2 > 2) {
                int end2 = start2;
                while (end2 < url.length() && url.charAt(end2) != '&') {
                    end2++;
                }
                String id2 = URLDecoder.decode(url.substring(start2, end2));
                if (id2 != null && id2.length() >= 0) {
                    FrsActivity.startAcitivity(this, id2, null);
                }
            } else if (url.indexOf(Config.RECOMMEND_ADDRESS_NEW) != -1) {
                int start3 = url.indexOf("page=");
                if (start3 != -1) {
                    int start4 = start3 + 5;
                    int end3 = start4;
                    while (end3 < url.length() && url.charAt(end3) != '&') {
                        end3++;
                    }
                    String page = URLDecoder.decode(url.substring(start4, end3));
                    if (page != null && page.length() >= 0) {
                        this.requestPage = page;
                    }
                } else {
                    this.requestPage = "0";
                }
                refresh();
            } else {
                UtilHelper.startWebActivity(this, url);
            }
        }
        return true;
    }
}
