package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.FeedData;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MentionAdapter extends BaseAdapter {
    private static final int LIST_TYPE_CONTENT = 0;
    private static final int LIST_TYPE_CONTROL = 1;
    private Context mContext;
    private ArrayList<FeedData> mData;
    private String mForumSuf;
    private AsyncImageLoader mImageLoader;
    private int mType;
    private boolean mHaveMore = false;
    private boolean mIsRefresh = false;
    private boolean mIsGetmore = false;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    public MentionAdapter(Context context, ArrayList<FeedData> data) {
        this.mContext = context;
        this.mData = data;
        this.mForumSuf = this.mContext.getText(R.string.forum).toString();
        this.mImageLoader = new AsyncImageLoader(this.mContext);
    }

    public void releaseProgressBar() {
        if (this.mProgressbars != null) {
            for (int i = 0; i < this.mProgressbars.size(); i++) {
                try {
                    this.mProgressbars.get(i).setVisibility(8);
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "releaseProgressBar", ex.getMessage());
                }
            }
            this.mProgressbars.clear();
        }
    }

    public void setData(ArrayList<FeedData> data) {
        this.mData = data;
    }

    public ArrayList<FeedData> getData() {
        return this.mData;
    }

    public void setHaveMore(boolean b) {
        this.mHaveMore = b;
    }

    public boolean getHaveMore() {
        return this.mHaveMore;
    }

    public void setIsRefresh(boolean b) {
        this.mIsRefresh = b;
    }

    public boolean getIsRefresh() {
        return this.mIsRefresh;
    }

    public void setIsGetmore(boolean b) {
        this.mIsGetmore = b;
    }

    public boolean getIsGetmore() {
        return this.mIsGetmore;
    }

    public void setType(int t) {
        this.mType = t;
    }

    public int getType() {
        return this.mType;
    }

    public AsyncImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return getItemId(position) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            int count = this.mData.size() + 1;
            if (this.mHaveMore) {
                count++;
            }
            return count;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int index = (int) getItemId(position);
        if (index < 0 || index >= this.mData.size()) {
            return null;
        }
        Object item = this.mData.get(index);
        return item;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        int index = position - 1;
        if (this.mHaveMore && position == getCount() - 1) {
            index = -2;
        }
        return index;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        try {
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "", "ReplymeAdapter.getView error = " + ex.getMessage());
        }
        if (this.mData == null) {
            return convertView;
        }
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(this.mContext);
            if (getItemViewType(position) == 0) {
                if (this.mType == 0) {
                    convertView = mInflater.inflate(R.layout.mention_replyme_item, (ViewGroup) null);
                } else {
                    convertView = mInflater.inflate(R.layout.mention_atme_item, (ViewGroup) null);
                }
                holder = new ViewHolder();
                holder.mPhoto = (ImageView) convertView.findViewById(R.id.photo);
                holder.mUserName = (TextView) convertView.findViewById(R.id.user_name);
                holder.mUserName.getPaint().setFakeBoldText(true);
                holder.mTime = (TextView) convertView.findViewById(R.id.time);
                holder.mContent = (TextView) convertView.findViewById(R.id.content);
                if (this.mType == 0) {
                    holder.mTitle = (TextView) convertView.findViewById(R.id.title);
                    holder.mForumName = (TextView) convertView.findViewById(R.id.forum);
                    holder.mQuoteContent = (TextView) convertView.findViewById(R.id.quote_content);
                    holder.mReplymeThread = (LinearLayout) convertView.findViewById(R.id.replyme_thread);
                    holder.mReplymePost = (LinearLayout) convertView.findViewById(R.id.replyme_post);
                }
                holder.mPhotoClick = new PhotoOnClickListener();
                holder.mPhoto.setOnClickListener(holder.mPhotoClick);
            } else {
                convertView = mInflater.inflate(R.layout.page_item, (ViewGroup) null);
                holder = new ViewHolder();
                holder.mPageText = (TextView) convertView.findViewById(R.id.page_text);
                holder.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                this.mProgressbars.add(holder.mProgress);
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (getItemViewType(position) == 1) {
            long data_index = getItemId(position);
            if (data_index == -1) {
                if (this.mIsRefresh) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.loading);
                } else {
                    holder.mProgress.setVisibility(8);
                    holder.mPageText.setText(R.string.refresh);
                }
            } else if (data_index == -2) {
                if (this.mIsGetmore) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.loading);
                } else {
                    holder.mProgress.setVisibility(8);
                    holder.mPageText.setText(R.string.more);
                }
            }
            return convertView;
        }
        FeedData data = (FeedData) getItem(position);
        if (data == null) {
            return convertView;
        }
        holder.mUserName.setText(data.getReplyer().getName_show());
        holder.mTime.setText(StringHelper.getTimeString(data.getTime()));
        holder.mContent.setText(data.getContent());
        if (this.mType == 0) {
            int type = data.getType();
            if (type == 1) {
                holder.mReplymeThread.setVisibility(8);
                holder.mReplymePost.setVisibility(0);
                holder.mQuoteContent.setText(data.getQuote_content());
            } else {
                holder.mReplymeThread.setVisibility(0);
                holder.mReplymePost.setVisibility(8);
                holder.mTitle.setText(data.getTitle());
                holder.mForumName.setText(">" + StringHelper.cutString(data.getFname(), 12).concat(this.mForumSuf));
            }
        }
        holder.mPhoto.setVisibility(0);
        String portrait = data.getReplyer().getPortrait();
        holder.mPhoto.setTag(null);
        if (portrait != null && portrait.length() > 0) {
            Bitmap bm = this.mImageLoader.getPhoto(portrait);
            if (bm != null) {
                holder.mPhoto.setImageBitmap(bm);
            } else {
                holder.mPhoto.setTag(portrait);
                holder.mPhoto.setImageResource(R.drawable.photo);
            }
        } else {
            holder.mPhoto.setImageResource(R.drawable.photo);
        }
        holder.mPhotoClick.setId(data.getReplyer().getId());
        holder.mPhotoClick.setName(data.getReplyer().getName());
        holder.mPhoto.setOnClickListener(holder.mPhotoClick);
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mContent;
        TextView mForumName;
        TextView mPageText;
        ImageView mPhoto;
        PhotoOnClickListener mPhotoClick;
        ProgressBar mProgress;
        TextView mQuoteContent;
        LinearLayout mReplymePost;
        LinearLayout mReplymeThread;
        TextView mTime;
        TextView mTitle;
        TextView mUserName;

        private ViewHolder() {
        }
    }

    /* loaded from: classes.dex */
    private class PhotoOnClickListener implements View.OnClickListener {
        private String id;
        private String name;

        public PhotoOnClickListener() {
            setId(null);
            setName(null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.id != null && this.id.length() > 0) {
                PersonInfoActivity.startActivity(MentionAdapter.this.mContext, this.id, this.name);
            }
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
