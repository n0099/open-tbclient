package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.FeedData;
import com.baidu.tieba.data.PbData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.data.SubPbData;
import com.baidu.tieba.model.MentionModel;
import com.baidu.tieba.model.SubPbModel;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.pb.SubPbActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class MentionView {
    private static final int MENU_ID_REPLY = 1;
    private static final int MENU_ID_VIEW_PB = 2;
    private static final int MENU_ID_VIEW_POST = 0;
    public static final int UPDATA_TYPE_ENTER = 1;
    public static final int UPDATA_TYPE_ENTER_HASNEW = 2;
    public static final int UPDATA_TYPE_MORE = 4;
    public static final int UPDATA_TYPE_POST = 5;
    public static final int UPDATA_TYPE_REFRESH = 3;
    private MentionActivity mActivity;
    private CacheCallback mCache;
    private int mPageType;
    private int mUpdateType;
    private FrameLayout mLayout = null;
    private ListView mList = null;
    private MentionAdapter mAdapter = null;
    private MentionModel mModel = null;
    private int mPn = 1;
    private int mNoDataText = 0;
    private MentionAsyncTask mTask = null;
    private ProgressBar mProgress = null;
    private PostAsyncTask mPostTask = null;
    private TextView mTextNoData = null;
    private String mURL = null;
    AlertDialog mDialogMenu = null;
    private DialogMenuListener mDialogMenuListener = null;
    private Handler mHandler = new Handler();
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.mention.MentionView.1
        @Override // java.lang.Runnable
        public void run() {
            String authorPhoto;
            try {
                int start = MentionView.this.mList.getFirstVisiblePosition();
                int end = MentionView.this.mList.getLastVisiblePosition();
                for (int i = start; i <= end; i++) {
                    if (i < MentionView.this.mAdapter.getCount()) {
                        FeedData data = (FeedData) MentionView.this.mAdapter.getItem(i);
                        if (data != null && (authorPhoto = data.getReplyer().getPortrait()) != null && authorPhoto.length() > 0) {
                            MentionView.this.mAdapter.getImageLoader().loadPbPhoto(authorPhoto, new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.mention.MentionView.1.1
                                @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                    ImageView view = (ImageView) MentionView.this.mList.findViewWithTag(imageUrl);
                                    while (view != null) {
                                        view.setTag(null);
                                        if (view != null && bitmap != null) {
                                            view.setImageBitmap(bitmap);
                                        }
                                        view = (ImageView) MentionView.this.mList.findViewWithTag(imageUrl);
                                    }
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("MentionView", "mGetImageRunnble.run", "error = " + ex.getMessage());
            }
        }
    };

    /* loaded from: classes.dex */
    public interface CacheCallback {
        void delete();

        String get();

        void set(String str);
    }

    /* loaded from: classes.dex */
    public class DialogMenuListener implements DialogInterface.OnClickListener {
        private FeedData data = null;

        public DialogMenuListener() {
        }

        public void setData(FeedData d) {
            this.data = d;
        }

        public FeedData getData() {
            return this.data;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            if (this.data != null) {
                switch (which) {
                    case 0:
                        if (!this.data.getIsFloor()) {
                            PostActivity.startAcitivity(MentionView.this.mActivity, this.data.getThread_id(), this.data.getPost_id());
                            return;
                        } else {
                            MentionView.this.viewFloorPage(this.data);
                            return;
                        }
                    case 1:
                        if (this.data.getIsFloor()) {
                            MentionView.this.reply(this.data.getThread_id(), this.data.getPost_id(), 2);
                            return;
                        } else {
                            MentionView.this.reply(this.data.getThread_id(), this.data.getPost_id(), 1);
                            return;
                        }
                    case 2:
                        PbActivity.startAcitivity(MentionView.this.mActivity, this.data.getThread_id(), null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public MentionView(MentionActivity activity, int pageType, CacheCallback cache) {
        this.mActivity = null;
        this.mPageType = 0;
        this.mCache = null;
        this.mActivity = activity;
        this.mPageType = pageType;
        this.mCache = cache;
    }

    public void setNoDataText(int resid) {
        this.mNoDataText = resid;
    }

    public int getNoDataText() {
        return this.mNoDataText;
    }

    public void setUpdateType(int type) {
        this.mUpdateType = type;
    }

    public int getUpdateType() {
        return this.mUpdateType;
    }

    public void setListView(ListView lv) {
        this.mList = lv;
    }

    public ListView getListView() {
        return this.mList;
    }

    public void setLayout(FrameLayout layout) {
        this.mLayout = layout;
    }

    public FrameLayout getLayout() {
        return this.mLayout;
    }

    public void setProgressBar(ProgressBar p) {
        this.mProgress = p;
    }

    public void setURL(String url) {
        this.mURL = url;
    }

    public void setTextNoData(TextView text) {
        this.mTextNoData = text;
    }

    public void releaseProgressBar() {
        this.mAdapter.releaseProgressBar();
        this.mProgress.setVisibility(8);
    }

    public void closeMenuDialog() {
        if (this.mDialogMenu != null) {
            this.mDialogMenu.dismiss();
        }
    }

    public void init() {
        this.mPn = 1;
        this.mAdapter = new MentionAdapter(this.mActivity, null);
        this.mAdapter.setType(this.mPageType);
        this.mAdapter.setTextConfig(TiebaApplication.app.getFontSize());
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.mention.MentionView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                MentionAdapter adapter = (MentionAdapter) tmpList.getAdapter();
                long index = adapter.getItemId(arg2);
                if (index == -1) {
                    MentionView.this.mPn = 1;
                    MentionView.this.mUpdateType = 3;
                    MentionView.this.show();
                } else if (index == -2) {
                    MentionView.this.mPn++;
                    MentionView.this.mUpdateType = 4;
                    MentionView.this.show();
                } else {
                    FeedData data = (FeedData) adapter.getItem(arg2);
                    if (data != null) {
                        MentionView.this.mDialogMenuListener.setData(data);
                        MentionView.this.showMenu(data);
                    }
                }
            }
        });
        this.mDialogMenuListener = new DialogMenuListener();
        this.mList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.mention.MentionView.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                FeedData data = (FeedData) tmpList.getAdapter().getItem(arg2);
                if (data != null) {
                    MentionView.this.mDialogMenuListener.setData(data);
                    MentionView.this.showMenu(data);
                    return true;
                }
                return true;
            }
        });
        this.mList.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.mention.MentionView.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                MentionView.this.mHandler.removeCallbacks(MentionView.this.mGetImageRunnble);
                MentionView.this.mHandler.postDelayed(MentionView.this.mGetImageRunnble, 300L);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
        this.mProgress.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMenu(FeedData data) {
        String menu = data.getIsFloor() ? this.mActivity.getString(R.string.view_souce_post) : this.mActivity.getString(R.string.view_post);
        CharSequence[] itemsDialogMenu = {menu, this.mActivity.getString(R.string.reply), this.mActivity.getString(R.string.view_pb)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity);
        builder.setTitle(this.mActivity.getString(R.string.operation));
        builder.setItems(itemsDialogMenu, this.mDialogMenuListener);
        this.mDialogMenu = builder.create();
        this.mDialogMenu.setCanceledOnTouchOutside(true);
        this.mDialogMenu.show();
    }

    public void show() {
        ArrayList<FeedData> list;
        this.mActivity.showButton();
        Boolean isNeedNetwork = false;
        switch (this.mUpdateType) {
            case 2:
                isNeedNetwork = true;
                break;
            case 3:
                isNeedNetwork = true;
                if (this.mAdapter.getIsRefresh()) {
                    return;
                }
                break;
            case 4:
                isNeedNetwork = true;
                if (this.mAdapter.getIsGetmore()) {
                    return;
                }
                break;
        }
        if (!isNeedNetwork.booleanValue()) {
            if (this.mModel != null) {
                refresh(this.mModel);
                return;
            }
            String data = this.mCache.get();
            if (data != null && data.length() > 0) {
                MentionModel model = new MentionModel();
                model.parserJson(data);
                if (!model.isSucc()) {
                    TiebaLog.i("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                    this.mCache.delete();
                } else {
                    TiebaLog.i("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(data.length()));
                    refresh(model);
                    return;
                }
            }
        }
        if (this.mUpdateType != 4) {
            this.mPn = 1;
        }
        StringBuffer address = new StringBuffer(30);
        address.append(Config.SERVER_ADDRESS);
        address.append(this.mURL);
        ArrayList<BasicNameValuePair> params = new ArrayList<>();
        BasicNameValuePair tmp = new BasicNameValuePair("uid", TiebaApplication.getCurrentAccount());
        params.add(tmp);
        BasicNameValuePair tmp2 = new BasicNameValuePair(PersonListActivity.TAG_PAGE, String.valueOf(this.mPn));
        params.add(tmp2);
        if (this.mUpdateType == 4 && this.mModel != null && (list = this.mModel.getFeed_list()) != null && list.size() > 0) {
            int size = list.size();
            FeedData last = list.get(size - 1);
            String ids = String.format("%s,%s", last.getThread_id(), last.getPost_id());
            BasicNameValuePair tmp3 = new BasicNameValuePair("ids", ids);
            params.add(tmp3);
        }
        cancelUpdate();
        this.mTask = new MentionAsyncTask(address.toString(), params, this.mAdapter);
        this.mTask.execute(address.toString(), params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(MentionModel model) {
        if (model != null && model.getFeed_list() != null) {
            if (this.mUpdateType == 4 && this.mModel != null) {
                ArrayList<FeedData> list = this.mModel.getFeed_list();
                list.addAll(model.getFeed_list());
                model.setFeed_list(list);
                this.mModel = null;
                this.mModel = model;
            } else {
                this.mModel = model;
            }
            if (this.mModel != null) {
                if (this.mModel.getPage().getHave_more() == 1) {
                    this.mAdapter.setHaveMore(true);
                } else {
                    this.mAdapter.setHaveMore(false);
                }
                ArrayList<FeedData> list2 = this.mModel.getFeed_list();
                if (list2 != null) {
                    this.mAdapter.setData(list2);
                    this.mAdapter.notifyDataSetInvalidated();
                    if (list2.size() == 0) {
                        this.mTextNoData.setVisibility(0);
                        this.mTextNoData.setText(this.mNoDataText);
                    } else {
                        this.mTextNoData.setVisibility(8);
                    }
                }
            }
            if (this.mUpdateType == 3 || this.mUpdateType == 2) {
                this.mActivity.showMsg(this.mPageType, true);
            } else {
                this.mActivity.showMsg(this.mPageType, false);
            }
        }
    }

    public void checkFontConfig() {
        if (this.mAdapter != null && this.mAdapter.getTextConfig() != TiebaApplication.app.getFontSize()) {
            this.mAdapter.setTextConfig(TiebaApplication.app.getFontSize());
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void cancelAsyncTask() {
        cancelImageLoader();
        cancelUpdate();
    }

    private void cancelUpdate() {
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        if (this.mPostTask != null) {
            this.mPostTask.cancel();
            this.mPostTask = null;
        }
        this.mProgress.setVisibility(8);
        this.mAdapter.setIsRefresh(false);
        this.mAdapter.setIsGetmore(false);
        this.mAdapter.notifyDataSetChanged();
    }

    private void cancelImageLoader() {
        this.mHandler.removeCallbacks(this.mGetImageRunnble);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MentionAsyncTask extends AsyncTask<Object, Integer, MentionModel> {
        private MentionAdapter mAdapter;
        private NetWork mNetwork = null;
        private ArrayList<BasicNameValuePair> mParams;
        private String mUrl;

        public MentionAsyncTask(String url, ArrayList<BasicNameValuePair> params, MentionAdapter adapter) {
            this.mUrl = null;
            this.mParams = null;
            this.mAdapter = null;
            this.mUrl = url;
            this.mParams = params;
            this.mAdapter = adapter;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            switch (MentionView.this.mUpdateType) {
                case 1:
                case 2:
                    MentionView.this.mProgress.setVisibility(0);
                    return;
                case 3:
                    this.mAdapter.setIsRefresh(true);
                    this.mAdapter.notifyDataSetChanged();
                    return;
                case 4:
                    this.mAdapter.setIsGetmore(true);
                    this.mAdapter.notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public MentionModel doInBackground(Object... params) {
            MentionModel model = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParams);
                this.mNetwork.setContext(MentionView.this.mActivity);
                String data = this.mNetwork.postNetData();
                TiebaLog.i("MentionAsyncTask", "doInBackground", "net data.size: " + String.valueOf(data.length()));
                if (!this.mNetwork.isRequestSuccess() || data == null) {
                    return null;
                }
                MentionModel model2 = new MentionModel();
                try {
                    model2.parserJson(data);
                    if (model2.isSucc()) {
                        if (MentionView.this.mUpdateType != 4) {
                            MentionView.this.mCache.set(data);
                            return model2;
                        }
                        return model2;
                    }
                    return null;
                } catch (Exception e) {
                    ex = e;
                    model = model2;
                    TiebaLog.e(getClass().getName(), "", "doInBackground error = " + ex.getMessage());
                    return model;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(MentionModel model) {
            switch (MentionView.this.mUpdateType) {
                case 1:
                case 2:
                    MentionView.this.mProgress.setVisibility(8);
                    break;
                case 3:
                    this.mAdapter.setIsRefresh(false);
                    this.mAdapter.notifyDataSetChanged();
                    break;
                case 4:
                    this.mAdapter.setIsGetmore(false);
                    this.mAdapter.notifyDataSetChanged();
                    break;
            }
            if (model == null && this.mNetwork != null) {
                if (this.mNetwork.isNetSuccess()) {
                    MentionView.this.mActivity.showToast(this.mNetwork.getErrorString());
                } else if (MentionView.this.mModel == null) {
                    MentionView.this.mActivity.showToast(this.mNetwork.getErrorString());
                    model = new MentionModel();
                    this.mAdapter.setHaveMore(false);
                    ArrayList<FeedData> list = model.getFeed_list();
                    if (list != null) {
                        this.mAdapter.setData(list);
                        this.mAdapter.notifyDataSetInvalidated();
                    }
                    MentionView.this.mModel = model;
                } else {
                    MentionView.this.mActivity.showToast(this.mNetwork.getErrorString());
                }
            }
            MentionView.this.refresh(model);
            MentionView.this.mTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reply(String threadId, String postId, int type) {
        StringBuffer address = new StringBuffer(30);
        address.append(Config.SERVER_ADDRESS);
        ArrayList<BasicNameValuePair> param = new ArrayList<>();
        if (type == 1) {
            address.append(Config.PB_ADDRESS);
            BasicNameValuePair theme = new BasicNameValuePair("kz", threadId);
            param.add(theme);
            BasicNameValuePair theme2 = new BasicNameValuePair("pid", postId);
            param.add(theme2);
            BasicNameValuePair theme3 = new BasicNameValuePair("mark", String.valueOf(1));
            param.add(theme3);
            BasicNameValuePair theme4 = new BasicNameValuePair("rn", String.valueOf(1));
            param.add(theme4);
        }
        if (type == 2) {
            address.append(Config.FLOOR_ADDRESS);
            BasicNameValuePair theme5 = new BasicNameValuePair("kz", threadId);
            param.add(theme5);
            BasicNameValuePair theme6 = new BasicNameValuePair("spid", postId);
            param.add(theme6);
        }
        cancelUpdate();
        this.mPostTask = new PostAsyncTask(address.toString(), param, type);
        this.mPostTask.execute(address.toString(), param);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewFloorPage(FeedData data) {
        String threadId = data.getThread_id();
        String postId = data.getPost_id();
        Intent intent = new Intent(this.mActivity, SubPbActivity.class);
        intent.putExtra("themeId", threadId);
        intent.putExtra("postId", postId);
        intent.putExtra("isFromMention", true);
        this.mActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostAsyncTask extends AsyncTask<Object, Integer, String> {
        static final int TYPE_REPLY = 1;
        static final int TYPE_REPLY_FLOOR = 2;
        private NetWork mNetwork = null;
        ArrayList<BasicNameValuePair> mParam;
        private int mRequestType;
        private String mUrl;

        public PostAsyncTask(String url, ArrayList<BasicNameValuePair> param, int type) {
            this.mUrl = null;
            this.mParam = null;
            this.mUrl = url;
            this.mParam = param;
            this.mRequestType = type;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            MentionView.this.mProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Object... params) {
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParam);
                String data = this.mNetwork.postNetData();
                return data;
            } catch (Exception ex) {
                TiebaLog.e("PostAsyncTask", "doInBackground", "error = " + ex.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String data) {
            try {
                MentionView.this.mProgress.setVisibility(8);
                if (this.mNetwork.isRequestSuccess()) {
                    if (this.mRequestType == 1) {
                        PbData pbData = new PbData();
                        pbData.parserJson(data);
                        PostData post = pbData.getPost_list().get(0);
                        if (post != null) {
                            WriteActivity.startAcitivity(MentionView.this.mActivity, pbData.getForum().getId(), pbData.getForum().getName(), pbData.getThread().getId(), post.getId(), post.getFloor_num(), pbData.getAnti(), pbData.getIsHasFloor());
                        } else {
                            return;
                        }
                    }
                    if (this.mRequestType == 2) {
                        SubPbData subPbData = new SubPbModel(MentionView.this.mActivity, data).getSubPbData();
                        String forumId = subPbData.getForumData().getId();
                        String forumName = subPbData.getForumData().getName();
                        String threadId = subPbData.getThreadData().getId();
                        AntiData antiData = subPbData.getAntiData();
                        String postId = subPbData.getPostData().getId();
                        int floorNum = subPbData.getPostData().getFloor_num();
                        WriteActivity.startAcitivity(MentionView.this.mActivity, forumId, forumName, threadId, postId, floorNum, antiData, true);
                    }
                } else if (this.mNetwork != null) {
                    MentionView.this.mActivity.showToast(this.mNetwork.getErrorString());
                }
            } catch (Exception e) {
            }
            MentionView.this.mPostTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            MentionView.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
