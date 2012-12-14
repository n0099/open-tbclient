package com.baidu.tieba.view;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ImageData;
import com.baidu.tieba.data.ImagePbData;
import com.baidu.tieba.data.ImageSubPbData;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.pb.ImagePbAdapter;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImagePbPagerAdapter extends PagerAdapter {
    public static final int COMMENT_BLOCK = 10;
    private static final int COMMENT_CACHE_SIZE = 5;
    private static final int MAX_COMMENT_TASK = 3;
    private static final int MAX_LISTVIEW_NUM = 5;
    private Context mContext;
    private AsyncImageLoader mImageLoader;
    private String mTid = null;
    private String forum = null;
    private ImagePbData mImagePbData = null;
    private LinkedList<ImageData> mDatas = null;
    private HashMap<String, ImageSubPbData> postDataCache = null;
    private ImagePbActivity.OnPreLoading loadingCallBack = null;
    private ArrayList<ImagePbCommentAsyncTask> commentTasks = null;
    private boolean firstIsShowed = false;
    private ImagePbAdapter currentAdapter = null;
    private int equipWidth = 0;
    private int maxHeight = 0;
    private int minHeight = 0;
    private boolean mHasNext = true;
    private int mIndex = 0;
    private ArrayList<View> mListViews = null;
    private ArrayList<View> mUsedListViews = null;
    LayoutInflater mInflater = null;
    private View.OnClickListener mImageClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImagePbPagerAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ImagePbPagerAdapter.this.startImageView(ImagePbPagerAdapter.this.mIndex);
        }
    };

    public ImagePbPagerAdapter(Context context) {
        this.mContext = null;
        this.mContext = context;
        init();
    }

    public HashMap<String, ImageSubPbData> getComments() {
        return this.postDataCache;
    }

    public void clearComments() {
        this.postDataCache.clear();
    }

    public void setHasNext(boolean hasNext) {
        this.mHasNext = hasNext;
    }

    public void reset() {
        this.firstIsShowed = false;
        this.mHasNext = false;
        onDestroy();
    }

    public void setTid(String tid) {
        this.mTid = tid;
    }

    public void setDatas(ImagePbData datas) {
        if (datas != null) {
            this.mHasNext = datas.hasNext();
            this.mImagePbData = datas;
            this.mDatas = datas.getImageInfo();
            this.forum = datas.getForum();
        }
    }

    public void onDestroy() {
        if (this.commentTasks != null) {
            Iterator<ImagePbCommentAsyncTask> iterator = this.commentTasks.iterator();
            if (iterator.hasNext()) {
                ImagePbCommentAsyncTask task = iterator.next();
                task.cancel();
            }
            this.commentTasks.clear();
        }
        if (this.currentAdapter != null) {
            this.currentAdapter.notifyDataSetChanged();
        }
        if (this.mImageLoader != null) {
            this.mImageLoader.cancelAllAsyncTask();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mImagePbData == null) {
            return 0;
        }
        if (this.mHasNext) {
            return this.mImagePbData.getImageNum() + 1;
        }
        return this.mImagePbData.getImageNum();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        ListView listView = (ListView) ((View) object).findViewById(R.id.image_pb_listview);
        if (listView != null && listView.getTag() != null && (listView.getTag() instanceof ImagePbAdapter)) {
            ((ImagePbAdapter) listView.getTag()).releaseProgressBar();
            listView.setAdapter((ListAdapter) null);
            if (this.mListViews.size() < 5) {
                this.mListViews.add((View) object);
            }
            this.mUsedListViews.remove(object);
            TiebaLog.i(getClass().getName(), "destroyItem", String.valueOf(this.mUsedListViews.size()));
        }
        container.removeView((View) object);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object object) {
        return -2;
    }

    public void setOnPreLodingCallBack(ImagePbActivity.OnPreLoading loadingCallBack) {
        this.loadingCallBack = loadingCallBack;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View listView;
        if (position == this.mImagePbData.getImageNum()) {
            View nextView = this.mInflater.inflate(R.layout.image_pb_next, (ViewGroup) null);
            TextView threadText = (TextView) nextView.findViewById(R.id.thread_name);
            threadText.setText(this.mImagePbData.getNextTitle());
            container.addView(nextView);
            return nextView;
        }
        ImageData imageData = null;
        if (position < this.mDatas.size()) {
            ImageData imageData2 = this.mDatas.get(position);
            imageData = imageData2;
        }
        if (this.mListViews.size() > 0) {
            View listView2 = this.mListViews.get(0);
            listView = listView2;
            this.mListViews.remove(0);
        } else {
            listView = this.mInflater.inflate(R.layout.image_pb_list, (ViewGroup) null);
        }
        if (this.mUsedListViews.size() > 5) {
            this.mUsedListViews.clear();
        }
        this.mUsedListViews.add(listView);
        TiebaLog.i(getClass().getName(), "instantiateItem", String.valueOf(this.mUsedListViews.size()));
        ListView commentList = (ListView) listView.findViewById(R.id.image_pb_listview);
        commentList.setAdapter((ListAdapter) null);
        if (imageData == null) {
            if (this.loadingCallBack != null) {
                this.loadingCallBack.startPreLoad(position, 0, 0);
            }
            if (listView.getParent() == container) {
                container.removeView(listView);
            }
            container.addView(listView);
            return listView;
        }
        final ImagePbAdapter tempAdapter = new ImagePbAdapter(this.mContext, imageData);
        tempAdapter.setImageHeight(this.minHeight, this.maxHeight);
        tempAdapter.setImageClickListener(this.mImageClickListener);
        commentList.setAdapter((ListAdapter) tempAdapter);
        commentList.setVerticalScrollBarEnabled(false);
        commentList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.view.ImagePbPagerAdapter.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (tempAdapter == null || !tempAdapter.hasNext() || arg3 != tempAdapter.getCount() - 1) {
                    return;
                }
                ImagePbPagerAdapter.this.startCommentTask(tempAdapter.getPageNum(), tempAdapter.getImageData().getImageID(), 10, tempAdapter);
            }
        });
        if (this.postDataCache.get(imageData.getCommentID()) != null) {
            tempAdapter.setDatas(this.postDataCache.get(imageData.getCommentID()));
        } else {
            ImageSubPbData datas = new ImageSubPbData(this.mContext);
            if (this.postDataCache.size() >= 5) {
                this.postDataCache.clear();
            }
            this.postDataCache.put(imageData.getCommentID(), datas);
            startCommentTask(1, imageData.getImageID(), 10, tempAdapter);
        }
        listView.setTag(tempAdapter);
        if (listView.getParent() == container) {
            container.removeView(listView);
        }
        container.addView(listView);
        return listView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageView(int index) {
        if (index < this.mDatas.size()) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageData imageItem = this.mDatas.get(i);
                StringBuffer buffer = new StringBuffer(100);
                if (imageItem.getHeight() * imageItem.getWidth() > Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH) {
                    double a = Math.sqrt((Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH) / (imageItem.getHeight() * imageItem.getWidth()));
                    buffer.append("width=");
                    buffer.append(String.valueOf((int) (imageItem.getWidth() * a)));
                    buffer.append("&height=");
                    buffer.append(String.valueOf((int) (imageItem.getHeight() * a)));
                } else {
                    buffer.append("width=");
                    buffer.append(String.valueOf(imageItem.getWidth()));
                    buffer.append("&height=");
                    buffer.append(String.valueOf(imageItem.getHeight()));
                }
                buffer.append("&src=");
                String encode = StringHelper.getUrlEncode(imageItem.getImageUrl());
                buffer.append(encode);
                list.add(buffer.toString());
            }
            boolean hasNext = false;
            if (this.mImagePbData.getImageNum() == list.size() && this.mImagePbData.hasNext()) {
                hasNext = true;
            }
            ImageActivity.startActivityForResult(this.mContext, list, index, this.mImagePbData.getImageNum(), hasNext, this.mImagePbData);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        this.mIndex = position;
        if (this.mDatas != null) {
            ImageData imageData = null;
            if (position < this.mDatas.size()) {
                ImageData imageData2 = this.mDatas.get(position);
                imageData = imageData2;
            }
            if (imageData != null) {
                ListView currentListView = (ListView) ((View) object).findViewById(R.id.image_pb_listview);
                currentListView.setVerticalScrollBarEnabled(true);
                this.currentAdapter = (ImagePbAdapter) currentListView.getTag();
                ImagePbImageView image = (ImagePbImageView) ((View) object).findViewById(R.id.image_pb_image);
                if (image != null) {
                    if (position == 0 && !this.firstIsShowed) {
                        image.setFirst(true);
                        return;
                    }
                    this.firstIsShowed = true;
                    image.setFirst(false);
                }
            }
        }
    }

    public AsyncImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public void loadMoreComment() {
        if (this.currentAdapter != null && this.currentAdapter.isLast()) {
            startCommentTask(this.currentAdapter.getPageNum(), this.currentAdapter.getImageData().getImageID(), 10, this.currentAdapter);
        }
    }

    private void init() {
        this.mImageLoader = new AsyncImageLoader(this.mContext);
        this.mImageLoader.setSuffix(AsyncImageLoader.BIG);
        this.equipWidth = UtilHelper.getEquipmentWidth(this.mContext);
        this.maxHeight = (UtilHelper.getEquipmentHeight(this.mContext) * 3) / 5;
        this.minHeight = this.maxHeight >> 1;
        int maxWidth = Config.THREAD_IMAGE_MAX_WIDTH < this.equipWidth ? Config.THREAD_IMAGE_MAX_WIDTH : this.equipWidth;
        this.maxHeight = Config.THREAD_IMAGE_MAX_WIDTH < this.maxHeight ? Config.THREAD_IMAGE_MAX_WIDTH : this.maxHeight;
        this.mImageLoader.setImagesize(maxWidth - UtilHelper.dip2px(this.mContext, 8.0f), this.maxHeight);
        this.mInflater = LayoutInflater.from(this.mContext);
        this.commentTasks = new ArrayList<>();
        this.postDataCache = new HashMap<>();
        this.mListViews = new ArrayList<>();
        this.mUsedListViews = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentTask(int pn, String imageId, int commentNumber, ImagePbAdapter adapter) {
        if (this.commentTasks.size() > 3) {
            ImagePbCommentAsyncTask commentTask = this.commentTasks.get(0);
            this.commentTasks.remove(commentTask);
            commentTask.cancel();
        }
        ImagePbCommentAsyncTask commentTask2 = new ImagePbCommentAsyncTask(adapter, pn, commentNumber, this.mTid, imageId);
        commentTask2.execute(new String[0]);
        this.commentTasks.add(commentTask2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImagePbCommentAsyncTask extends AsyncTask<String, Integer, String> {
        private String commentID;
        private ImagePbAdapter mAdapter;
        private NetWork mNetwork = null;
        private int mNumPerPage;
        private String mPicId;
        private int mRequestPage;
        private String mTid;

        public ImagePbCommentAsyncTask(ImagePbAdapter adapter, int requestPage, int numPerPage, String tid, String picId) {
            this.mRequestPage = 0;
            this.mNumPerPage = 10;
            this.mTid = null;
            this.mPicId = null;
            this.mAdapter = null;
            this.commentID = null;
            this.mRequestPage = requestPage;
            this.mNumPerPage = numPerPage;
            this.mTid = tid;
            this.mPicId = picId;
            this.mAdapter = adapter;
            this.commentID = adapter.getImageData().getCommentID();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (this.mAdapter != null) {
                this.mAdapter.setIsProcessMore(true);
                this.mAdapter.notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/f/pb/piccomment");
            this.mNetwork.addPostData("kw", ImagePbPagerAdapter.this.forum);
            this.mNetwork.addPostData("pic_id", this.mPicId);
            this.mNetwork.addPostData("tid", this.mTid);
            this.mNetwork.addPostData(PersonListActivity.TAG_PAGE, String.valueOf(this.mRequestPage));
            this.mNetwork.addPostData("rn", String.valueOf(this.mNumPerPage));
            this.mNetwork.addPostData("alt", "json");
            this.mNetwork.setIsNeedTbs(true);
            return this.mNetwork.postNetData();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            if (this.mAdapter != null) {
                this.mAdapter.setIsProcessMore(false);
                this.mAdapter.notifyDataSetChanged();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ImagePbCommentAsyncTask) result);
            try {
                if (this.mAdapter != null) {
                    this.mAdapter.setIsProcessMore(false);
                }
                if (this.mNetwork != null) {
                    if (!this.mNetwork.isRequestSuccess() || this.mAdapter == null) {
                        ((BaseActivity) ImagePbPagerAdapter.this.mContext).showToast(ImagePbPagerAdapter.this.mContext.getString(R.string.image_pb_comment_fail));
                        return;
                    }
                    ImageSubPbData datas = null;
                    if (this.mAdapter != null) {
                        this.mAdapter.setDatas(null);
                        this.mAdapter.notifyDataSetChanged();
                    }
                    if (ImagePbPagerAdapter.this.postDataCache.get(this.mAdapter.getImageData().getCommentID()) != null) {
                        datas = (ImageSubPbData) ImagePbPagerAdapter.this.postDataCache.get(this.mAdapter.getImageData().getCommentID());
                        datas.paserJson(result);
                    }
                    if (this.mAdapter != null) {
                        this.mAdapter.setDatas(datas);
                        this.mAdapter.notifyDataSetChanged();
                        this.mAdapter = null;
                    }
                    for (int i = 0; i < ImagePbPagerAdapter.this.mUsedListViews.size(); i++) {
                        if (((View) ImagePbPagerAdapter.this.mUsedListViews.get(i)).getTag() instanceof ImagePbAdapter) {
                            ImagePbAdapter temp = (ImagePbAdapter) ((View) ImagePbPagerAdapter.this.mUsedListViews.get(i)).getTag();
                            if (temp.getImageData() != null && this.commentID.equals(temp.getImageData().getCommentID())) {
                                temp.notifyDataSetChanged();
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "onPostExecute", ex.getMessage());
            }
        }
    }
}
