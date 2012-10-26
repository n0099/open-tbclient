package com.baidu.tieba.pb;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.ContentHelper;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SubPbAdapter extends BaseAdapter {
    private Context mContext;
    private List<PostData> mData;
    private int mHaveFooter;
    private int mHaveHeader;
    private boolean mIsProcessMore;
    private boolean mIsProcessPre;
    private View.OnClickListener mReplyListener = null;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    public SubPbAdapter(Context context, List<PostData> data) {
        this.mContext = context;
        this.mData = data;
    }

    public void setData(List<PostData> data) {
        this.mData = data;
    }

    public void setReplyListener(View.OnClickListener listener) {
        this.mReplyListener = listener;
    }

    public void setIsProcessMore(boolean isProcessMore) {
        this.mIsProcessMore = isProcessMore;
    }

    public boolean isProcessMore() {
        return this.mIsProcessMore;
    }

    public void setIsProcessPre(boolean isProcessPre) {
        this.mIsProcessPre = isProcessPre;
    }

    public boolean isProcessPre() {
        return this.mIsProcessPre;
    }

    public void setHaveHeader(int haveHeader) {
        this.mHaveHeader = haveHeader;
    }

    public boolean isHaveHeader() {
        return this.mHaveHeader != 0;
    }

    public int getHaveHeader() {
        return this.mHaveHeader;
    }

    public void setHaveFooter(int haveFooter) {
        this.mHaveFooter = haveFooter;
    }

    public boolean isHaveFooter() {
        return this.mHaveFooter != 0;
    }

    public int getHaveFooter() {
        return this.mHaveFooter;
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

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            int count = this.mData.size();
            if (this.mHaveHeader != 0) {
                count++;
            }
            if (this.mHaveFooter != 0) {
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
        int index = position;
        if (this.mHaveHeader != 0) {
            index--;
        }
        if (this.mHaveFooter != 0 && position == getCount() - 1) {
            index = -2;
        }
        return index;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        long data_index;
        ViewHolder holder2;
        if (this.mData == null) {
            return convertView;
        }
        try {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(this.mContext);
                try {
                    if (getItemViewType(position) == 0) {
                        convertView = inflater.inflate(R.layout.sub_pb_item, (ViewGroup) null);
                        holder2 = new ViewHolder(this, null);
                        holder2.mUserName = (TextView) convertView.findViewById(R.id.text_user);
                        holder2.mTime = (TextView) convertView.findViewById(R.id.text_time);
                        holder2.mText = (TextView) convertView.findViewById(R.id.text_content);
                        holder2.mText.setLineSpacing(0.0f, 1.2f);
                        holder2.mReply = (Button) convertView.findViewById(R.id.button_reply);
                        holder2.mSeg = (LinearLayout) convertView.findViewById(R.id.seg);
                        holder2.mReply.setOnClickListener(this.mReplyListener);
                        holder2.mPhotoClick = new PhotoOnClickListener();
                        holder2.mUserName.setOnClickListener(holder2.mPhotoClick);
                        holder = holder2;
                    } else {
                        convertView = inflater.inflate(R.layout.page_item, (ViewGroup) null);
                        holder2 = new ViewHolder(this, null);
                        holder2.mPageText = (TextView) convertView.findViewById(R.id.page_text);
                        holder2.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                        this.mProgressbars.add(holder2.mProgress);
                        holder = holder2;
                    }
                    convertView.setTag(holder);
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e("SubPbAdapter", "getView", "error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (holder.mReply != null) {
                holder.mReply.setTag(String.valueOf(position));
            }
            data_index = getItemId(position);
        } catch (Exception e2) {
            ex = e2;
        }
        if (getItemViewType(position) == 1) {
            if (data_index == -1) {
                if (this.mIsProcessPre) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.data_loading_1);
                } else {
                    holder.mProgress.setVisibility(8);
                    if (this.mHaveHeader == 1) {
                        holder.mPageText.setText(R.string.may_have_more);
                    } else if (this.mHaveHeader == 2) {
                        holder.mPageText.setText(R.string.data_more);
                    } else {
                        holder.mPageText.setText((CharSequence) null);
                    }
                }
            } else if (data_index == -2) {
                if (this.mIsProcessMore) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.data_loading_1);
                } else {
                    holder.mProgress.setVisibility(8);
                    if (this.mHaveFooter == 1) {
                        holder.mPageText.setText(R.string.may_have_more);
                    } else if (this.mHaveFooter == 2) {
                        holder.mPageText.setText(R.string.data_more);
                    } else {
                        holder.mPageText.setText((CharSequence) null);
                    }
                }
            }
            return convertView;
        }
        holder.mText.setVisibility(8);
        holder.mText.setText((CharSequence) null);
        holder.mText.setMovementMethod(LinkMovementMethod.getInstance());
        holder.mText.setFocusable(false);
        holder.mSeg.setVisibility(8);
        holder.mSeg.removeAllViews();
        PostData data = (PostData) getItem(position);
        if (data == null) {
            return convertView;
        }
        holder.mUserName.setVisibility(0);
        holder.mUserName.setTextSize(Config.getNameSize());
        if (data.getAuthor() != null) {
            holder.mUserName.setText(data.getAuthor().getName_show());
        } else {
            holder.mUserName.setText((CharSequence) null);
        }
        String id = data.getAuthor().getId();
        holder.mPhotoClick.setId(id);
        holder.mPhotoClick.setName(data.getAuthor().getName());
        if (id == null || id.length() <= 0 || id.equals("0")) {
            holder.mUserName.setTextColor(-16777216);
        } else {
            holder.mUserName.setTextColor(-16749848);
        }
        holder.mTime.setText(StringHelper.getTimeString(data.getTime()));
        ArrayList<ContentData> content = data.getUnite_content();
        ContentHelper helper = new ContentHelper(this.mContext);
        helper.setContent(holder.mText, holder.mSeg, content, false);
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mPageText;
        PhotoOnClickListener mPhotoClick;
        ProgressBar mProgress;
        Button mReply;
        LinearLayout mSeg;
        TextView mText;
        TextView mTime;
        TextView mUserName;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(SubPbAdapter subPbAdapter, ViewHolder viewHolder) {
            this();
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
            PersonInfoActivity.startActivity(SubPbAdapter.this.mContext, this.id, this.name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
