package com.baidu.tieba.recommend;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.MediaData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.GuessListModel;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.ReadThreadHistory;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsImageView;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class GuessActivity extends BaseActivity {
    private static final int UPDATA_TYPE_NEXT = 1;
    private static final int UPDATA_TYPE_PREVIOUS = 2;
    private static final int UPDATA_TYPE_REFRESH = 3;
    private static final String URL_FROM = "from";
    private static volatile long mPbLoadTime = 0;
    private static volatile long mPbLoadDataSize = 0;
    private static volatile int mNetError = 0;
    private int mType = 3;
    private int mPn = 1;
    private String mThreadId = null;
    private boolean mIsRefresh = false;
    private String mSource = null;
    private ListView mListGuess = null;
    private GuessAdapter mAdapterGuess = null;
    private GuessAsyncTask mGuessTask = null;
    private GuessListModel mModel = null;
    private ProgressBar mProgress = null;
    AlertDialog mMenuGuess = null;
    private Handler mHandler = null;
    private AsyncImageLoader mBigImageLoader = null;
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.recommend.GuessActivity.1
        @Override // java.lang.Runnable
        public void run() {
            boolean supportHold;
            try {
                int start = GuessActivity.this.mListGuess.getFirstVisiblePosition();
                int end = GuessActivity.this.mListGuess.getLastVisiblePosition();
                int image_num = 0;
                NetWorkCore.NetworkStateInfo info = NetWorkCore.getStatusInfo(GuessActivity.this);
                GuessActivity.this.mAdapterGuess.getImageLoader().clearHoldUrl();
                if (info == NetWorkCore.NetworkStateInfo.WIFI || info == NetWorkCore.NetworkStateInfo.ThreeG) {
                    supportHold = true;
                } else {
                    supportHold = false;
                }
                GuessActivity.this.mAdapterGuess.getImageLoader().setSupportHoldUrl(supportHold);
                for (int i = start; i < GuessActivity.this.mAdapterGuess.getCount(); i++) {
                    if (supportHold || i <= end) {
                        ThreadData data = (ThreadData) GuessActivity.this.mAdapterGuess.getItem(i);
                        if (data != null) {
                            ArrayList<MediaData> content = data.getMedias();
                            int contentSize = content.size();
                            if (image_num < 13) {
                                for (int j = 0; j < contentSize; j++) {
                                    if (content.get(j).getType() == 3) {
                                        if (image_num >= 13) {
                                            break;
                                        }
                                        image_num++;
                                        GuessActivity.this.mAdapterGuess.getImageLoader().loadImage(content.get(j).getPicUrl(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.recommend.GuessActivity.1.1
                                            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                                FrsImageView view;
                                                if (bitmap != null && (view = (FrsImageView) GuessActivity.this.mListGuess.findViewWithTag(imageUrl)) != null) {
                                                    view.invalidate();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                            if (supportHold && image_num >= 13 && 0 >= 30) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("GuessActivity", "mGetImageRunnble.run", "error = " + ex.getMessage());
            }
        }
    };
    private AdapterView.OnItemLongClickListener guessItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.recommend.GuessActivity.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            ListView tmpList = (ListView) arg0;
            GuessAdapter adapter = (GuessAdapter) tmpList.getAdapter();
            long index = adapter.getItemId(arg2);
            if (index != -1 && index != -2) {
                ThreadData data = (ThreadData) adapter.getItem(arg2);
                GuessActivity.this.mThreadId = data.getTid();
                GuessActivity.this.prepareGuessMenuDialog(data);
                GuessActivity.this.mMenuGuess.show();
                return false;
            }
            return false;
        }
    };

    private void initBigImageLoader() {
        this.mBigImageLoader = new AsyncImageLoader(this);
        this.mBigImageLoader.setIsPv(true);
        int width = UtilHelper.dip2px(this, 234.0f);
        if (width > 350) {
            width = Config.PB_IMAGE_NEW_MAX_WIDTH;
        }
        this.mBigImageLoader.setImagesize(width, (int) (width * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_activity);
        this.mHandler = new Handler();
        initBigImageLoader();
        initUI();
        refresh();
    }

    public void closeDialog() {
        if (this.mMenuGuess != null) {
            this.mMenuGuess.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mGetImageRunnble);
        }
        super.onDestroy();
        try {
            if (this.mGuessTask != null) {
                this.mGuessTask.cancel();
                this.mGuessTask = null;
            }
            if (this.mAdapterGuess != null) {
                this.mAdapterGuess.releaseProgressBar();
            }
            if (this.mProgress != null) {
                this.mProgress.setVisibility(8);
            }
            System.gc();
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "onDestroy", ex.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Long lastTime = Long.valueOf(TiebaApplication.app.getRefreshGuessTime());
        if (!this.mIsRefresh && System.currentTimeMillis() - lastTime.longValue() > Config.REFRESH_GUESS_INTERVAL.longValue()) {
            refresh();
        } else {
            this.mGetImageRunnble.run();
        }
    }

    private void initUI() {
        this.mPn = 1;
        this.mType = 3;
        this.mListGuess = (ListView) findViewById(R.id.home_lv_guess);
        this.mAdapterGuess = new GuessAdapter(this, null, UtilHelper.getEquipmentWidth(this));
        this.mAdapterGuess.setForumNameOnclickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommend.GuessActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.getTag() != null && (v.getTag() instanceof String)) {
                    String name = (String) v.getTag();
                    if (StringHelper.isForumName(name)) {
                        FrsActivity.startAcitivity(GuessActivity.this, name, null);
                    }
                }
            }
        });
        this.mAdapterGuess.setImageOnclickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommend.GuessActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (((FrsImageView) v).isLoaded()) {
                    GuessActivity.this.mBigImageLoader.cancelAllAsyncTask();
                    if (v.getTag() != null && (v.getTag() instanceof String)) {
                        Bitmap bm = GuessActivity.this.mBigImageLoader.loadImage((String) v.getTag(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.recommend.GuessActivity.4.1
                            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
                                MainTabActivity mainTab = null;
                                if (GuessActivity.this.getParent() != null && GuessActivity.this.getParent().getParent() != null) {
                                    Context parent = GuessActivity.this.getParent().getParent();
                                    if (parent instanceof MainTabActivity) {
                                        mainTab = (MainTabActivity) parent;
                                    }
                                }
                                if (bitmap == null) {
                                    if (GuessActivity.this.mBigImageLoader != null) {
                                        GuessActivity.this.mBigImageLoader.cancelAllAsyncTask();
                                    }
                                    if (mainTab != null) {
                                        mainTab.errorBigImageDialog();
                                    }
                                } else if (mainTab != null) {
                                    mainTab.showBigImageDialog(bitmap, false);
                                }
                            }
                        });
                        MainTabActivity mainTab = null;
                        if (GuessActivity.this.getParent() != null && GuessActivity.this.getParent().getParent() != null) {
                            Context parent = GuessActivity.this.getParent().getParent();
                            if (parent instanceof MainTabActivity) {
                                mainTab = (MainTabActivity) parent;
                            }
                        }
                        if (bm == null || mainTab == null) {
                            Bitmap small = GuessActivity.this.mAdapterGuess.getImageLoader().getPic(String.valueOf((String) v.getTag()) + AsyncImageLoader.SMALL);
                            if (small != null && mainTab != null) {
                                mainTab.showBigImageDialog(small, true);
                                return;
                            }
                            return;
                        }
                        mainTab.showBigImageDialog(bm, false);
                    }
                }
            }
        });
        this.mListGuess.setAdapter((ListAdapter) this.mAdapterGuess);
        this.mListGuess.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.recommend.GuessActivity.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                GuessAdapter adapter = (GuessAdapter) tmpList.getAdapter();
                long index = adapter.getItemId(arg2);
                if (index == -1) {
                    if (GuessActivity.this.mPn > 1) {
                        GuessActivity guessActivity = GuessActivity.this;
                        guessActivity.mPn--;
                        GuessActivity.this.mType = 2;
                        GuessActivity.this.exec();
                    }
                } else if (index == -2) {
                    GuessActivity.this.mPn++;
                    GuessActivity.this.mType = 1;
                    GuessActivity.this.exec();
                } else {
                    ThreadData data = (ThreadData) adapter.getItem(arg2);
                    if (data != null) {
                        boolean isAd = false;
                        final String adUrl = data.getAd_url();
                        if (adUrl != null && !adUrl.equals("")) {
                            isAd = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.recommend.GuessActivity.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NetWorkCore adNetwork = new NetWorkCore(adUrl);
                                    adNetwork.getNetData();
                                }
                            }).start();
                        }
                        ReadThreadHistory history = TiebaApplication.app.getReadGuessHistory();
                        if (history != null && !history.getThread(data.getTid())) {
                            history.addThread(data.getTid());
                        }
                        adapter.notifyDataSetChanged();
                        PbActivity.startAcitivity(GuessActivity.this, data.getTid(), data.getFrom(), isAd);
                    }
                }
            }
        });
        this.mListGuess.setOnItemLongClickListener(this.guessItemLongClickListener);
        this.mProgress = (ProgressBar) findViewById(R.id.recommend_progress);
        setIsRefresh(false);
        this.mListGuess.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.recommend.GuessActivity.6
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                GuessActivity.this.mHandler.removeCallbacks(GuessActivity.this.mGetImageRunnble);
                GuessActivity.this.mHandler.postDelayed(GuessActivity.this.mGetImageRunnble, 300L);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState != 0) {
                    GuessActivity.this.mListGuess.setOnItemLongClickListener(null);
                } else {
                    GuessActivity.this.mListGuess.setOnItemLongClickListener(GuessActivity.this.guessItemLongClickListener);
                }
            }
        });
    }

    private boolean isAnonymityUser(ThreadData thread) {
        String id;
        return thread == null || thread.getAuthor() == null || (id = thread.getAuthor().getId()) == null || id.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareGuessMenuDialog(final ThreadData thread) {
        boolean isAnonymous = isAnonymityUser(thread);
        DialogInterface.OnClickListener menuGuessListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.recommend.GuessActivity.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        if (GuessActivity.this.mThreadId != null) {
                            PbActivity.startAcitivity(GuessActivity.this, GuessActivity.this.mThreadId, null);
                            return;
                        }
                        return;
                    case 1:
                        GuessActivity.this.gotoPbHost(thread);
                        return;
                    case 2:
                        GuessActivity.this.gotoPbReverse();
                        return;
                    default:
                        return;
                }
            }
        };
        String menuView = getString(R.string.view);
        String menuHost = getString(R.string.view_host);
        String menuReverse = getString(R.string.view_reverse);
        AlertDialog.Builder builderLike = new AlertDialog.Builder(getParent());
        builderLike.setTitle(R.string.operation);
        if (isAnonymous) {
            builderLike.setItems(new String[]{menuView, menuReverse}, menuGuessListener);
        } else {
            builderLike.setItems(new String[]{menuView, menuHost, menuReverse}, menuGuessListener);
        }
        this.mMenuGuess = builderLike.create();
        this.mMenuGuess.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoPbHost(ThreadData thread) {
        boolean isAnonymous = isAnonymityUser(thread);
        if (this.mThreadId != null) {
            if (!isAnonymous) {
                PbActivity.startAcitivity(this, this.mThreadId, true, true, null, false);
            } else {
                PbActivity.startAcitivity(this, this.mThreadId, false, false, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoPbReverse() {
        if (this.mThreadId != null) {
            PbActivity.startAcitivity(this, this.mThreadId, false, false, null, false);
        }
    }

    public void refresh() {
        this.mPn = 1;
        this.mType = 3;
        exec();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsRefresh(boolean b) {
        this.mIsRefresh = b;
        if (b) {
            this.mProgress.setVisibility(0);
        } else {
            this.mProgress.setVisibility(8);
        }
    }

    private boolean getIsRefresh() {
        return this.mIsRefresh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exec() {
        switch (this.mType) {
            case 1:
                if (this.mAdapterGuess.getIsProcessNext()) {
                    return;
                }
                break;
            case 2:
                if (this.mAdapterGuess.getIsProcessPre()) {
                    return;
                }
                break;
            case 3:
                if (getIsRefresh()) {
                    return;
                }
                break;
        }
        StringBuffer address = new StringBuffer(30);
        address.append(Config.SERVER_ADDRESS);
        address.append(Config.GET_HOT_FEED_ADDRESS);
        ArrayList<BasicNameValuePair> param = new ArrayList<>();
        BasicNameValuePair tmp = new BasicNameValuePair(PersonListActivity.TAG_PAGE, String.valueOf(this.mPn));
        param.add(tmp);
        BasicNameValuePair tmp2 = new BasicNameValuePair("rn", String.valueOf(35));
        param.add(tmp2);
        if (this.mSource != null) {
            BasicNameValuePair from = new BasicNameValuePair("from", this.mSource);
            param.add(from);
        }
        cancelAsyncTask();
        this.mGuessTask = new GuessAsyncTask(address.toString(), param, this.mType);
        this.mGuessTask.execute(address.toString(), param);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshGuess() {
        ArrayList<ThreadData> list;
        this.mListGuess.setVisibility(0);
        try {
            if (this.mModel != null && (list = this.mModel.getGuess_list()) != null) {
                this.mAdapterGuess.setData(list);
                if (this.mPn > 1) {
                    this.mAdapterGuess.setHaveHeader(true);
                } else {
                    this.mAdapterGuess.setHaveHeader(false);
                }
                if (this.mModel.getPage().getHave_more() == 1) {
                    this.mAdapterGuess.setHaveFooter(true);
                } else {
                    this.mAdapterGuess.setHaveFooter(false);
                }
                this.mAdapterGuess.setIsProcessNext(false);
                this.mAdapterGuess.setIsProcessPre(false);
                this.mAdapterGuess.notifyDataSetInvalidated();
                if (this.mType == 1) {
                    this.mListGuess.setSelection(1);
                } else {
                    this.mListGuess.setSelection(0);
                }
                setIsRefresh(false);
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "", "GuessActivity.refreshGuess error = " + ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mAdapterGuess.getImageLoader().cancelAllAsyncTask();
    }

    private void cancelAsyncTask() {
        if (this.mGuessTask != null) {
            this.mGuessTask.cancel();
            this.mGuessTask = null;
        }
        setIsRefresh(false);
        this.mAdapterGuess.setIsProcessNext(false);
        this.mAdapterGuess.setIsProcessPre(false);
        this.mAdapterGuess.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GuessAsyncTask extends AsyncTask<Object, Integer, GuessListModel> {
        ArrayList<BasicNameValuePair> mParams;
        private int mUpdateType;
        private String mUrl;
        private NetWork mNetwork = null;
        private volatile long mStartTime = 0;

        public GuessAsyncTask(String url, ArrayList<BasicNameValuePair> param, int type) {
            this.mUrl = null;
            this.mUpdateType = 3;
            this.mParams = null;
            this.mUrl = url;
            this.mParams = param;
            this.mUpdateType = type;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.mStartTime = System.nanoTime();
            switch (this.mUpdateType) {
                case 1:
                    GuessActivity.this.mAdapterGuess.setIsProcessNext(true);
                    GuessActivity.this.mAdapterGuess.notifyDataSetChanged();
                    return;
                case 2:
                    GuessActivity.this.mAdapterGuess.setIsProcessPre(true);
                    GuessActivity.this.mAdapterGuess.notifyDataSetChanged();
                    return;
                case 3:
                    GuessActivity.this.setIsRefresh(true);
                    return;
                default:
                    return;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public GuessListModel doInBackground(Object... params) {
            GuessListModel guessData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParams);
                if (GuessActivity.mPbLoadTime != 0) {
                    this.mNetwork.addPostData("ctime", String.valueOf(GuessActivity.mPbLoadTime));
                }
                if (GuessActivity.mPbLoadDataSize != 0) {
                    this.mNetwork.addPostData("data_size", String.valueOf(GuessActivity.mPbLoadDataSize));
                }
                if (GuessActivity.mNetError != 0) {
                    this.mNetwork.addPostData("net_error", String.valueOf(GuessActivity.mNetError));
                }
                this.mNetwork.setContext(GuessActivity.this);
                String data = this.mNetwork.postNetData();
                if (this.mNetwork.isRequestSuccess()) {
                    GuessListModel guessData2 = new GuessListModel();
                    try {
                        guessData2.parserJson(data);
                        TiebaLog.i(getClass().getName(), "doInBackground", data);
                        guessData = guessData2;
                    } catch (Exception e) {
                        ex = e;
                        guessData = guessData2;
                        TiebaLog.e(getClass().getName(), "", "GuessAsyncTask.doInBackground error = " + ex.getMessage());
                        return guessData;
                    }
                }
                if (this.mNetwork.isNetSuccess()) {
                    GuessActivity.mPbLoadTime = 0L;
                    GuessActivity.mPbLoadDataSize = 0L;
                    GuessActivity.mNetError = 0;
                } else {
                    GuessActivity.mNetError = 1;
                }
            } catch (Exception e2) {
                ex = e2;
            }
            return guessData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(GuessListModel data) {
            switch (this.mUpdateType) {
                case 1:
                    GuessActivity.this.mAdapterGuess.setIsProcessNext(false);
                    GuessActivity.this.mAdapterGuess.notifyDataSetChanged();
                    break;
                case 2:
                    GuessActivity.this.mAdapterGuess.setIsProcessPre(false);
                    GuessActivity.this.mAdapterGuess.notifyDataSetChanged();
                    break;
                case 3:
                    GuessActivity.this.setIsRefresh(false);
                    break;
            }
            if (data != null) {
                GuessActivity.this.mModel = data;
                GuessActivity.this.refreshGuess();
                long end_time = System.nanoTime();
                GuessActivity.mPbLoadTime = (end_time - this.mStartTime) / 1000000;
                if (this.mNetwork != null) {
                    GuessActivity.mPbLoadDataSize = this.mNetwork.getNetDataSize();
                }
                TiebaApplication.app.setRefreshGuessTime(System.currentTimeMillis());
            } else {
                processError();
            }
            GuessActivity.this.mGuessTask = null;
            GuessActivity.this.mSource = null;
            System.gc();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }

        private void processError() {
            GuessActivity.this.showToast(this.mNetwork.getErrorString());
        }
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return getParent() instanceof ActivityGroup ? getParent().onSearchRequested() : super.onSearchRequested();
    }
}
