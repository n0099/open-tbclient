package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.model.PbModel;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<PostData> mData;
    private boolean mHaveFooter;
    private boolean mHaveHeader;
    private AsyncImageLoader mImageLoader;
    private boolean mIsProcessMore;
    private boolean mIsProcessPre;
    private PbModel mPbModel;
    private ArrayList<ProgressBar> mProgressbars;

    public PbAdapter(Context context, PbModel model) {
        this.mPbModel = model;
        this.mContext = context;
        if (this.mPbModel != null && this.mPbModel.getData() != null) {
            this.mData = this.mPbModel.getData().getPost_list();
        } else {
            this.mData = null;
        }
        this.mHaveHeader = false;
        this.mHaveFooter = false;
        this.mIsProcessMore = false;
        this.mIsProcessPre = false;
        this.mImageLoader = new AsyncImageLoader(this.mContext);
        this.mProgressbars = new ArrayList<>();
    }

    public void setData(PbModel model) {
        this.mPbModel = model;
        if (this.mPbModel != null && this.mPbModel.getData() != null) {
            this.mData = this.mPbModel.getData().getPost_list();
        } else {
            this.mData = null;
        }
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

    public ArrayList<PostData> getData() {
        return this.mData;
    }

    public AsyncImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            int count = this.mData.size();
            if (this.mHaveHeader) {
                count++;
            }
            if (this.mHaveFooter) {
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
        if (this.mHaveHeader) {
            index--;
        }
        if (this.mHaveFooter && position == getCount() - 1) {
            index = -2;
        }
        return index;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Exception ex;
        ViewHolder holder;
        long data_index;
        ViewHolder holder2;
        if (this.mData == null) {
            return convertView;
        }
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                try {
                    if (getItemViewType(position) == 0) {
                        convertView = mInflater.inflate(R.layout.pb_item, (ViewGroup) null);
                        holder2 = new ViewHolder();
                        holder2.mPhoto = (ImageView) convertView.findViewById(R.id.photo);
                        holder2.mUserName = (TextView) convertView.findViewById(R.id.user_name);
                        holder2.mUserName.getPaint().setFakeBoldText(true);
                        holder2.mFloorText = (TextView) convertView.findViewById(R.id.floor);
                        holder2.mRank = (TextView) convertView.findViewById(R.id.rank);
                        holder2.mTime = (TextView) convertView.findViewById(R.id.time);
                        holder2.mText = (TextView) convertView.findViewById(R.id.text);
                        holder2.mSeg = (LinearLayout) convertView.findViewById(R.id.seg);
                        holder2.mMark = (ImageView) convertView.findViewById(R.id.mark);
                        holder2.mPhotoClick = new PhotoOnClickListener();
                        holder2.mPhoto.setOnClickListener(holder2.mPhotoClick);
                        holder = holder2;
                    } else {
                        convertView = mInflater.inflate(R.layout.page_item, (ViewGroup) null);
                        holder2 = new ViewHolder();
                        holder2.mPageText = (TextView) convertView.findViewById(R.id.page_text);
                        holder2.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                        this.mProgressbars.add(holder2.mProgress);
                        holder = holder2;
                    }
                    convertView.setTag(holder);
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e("PbAdapter", "getView", "error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            data_index = getItemId(position);
        } catch (Exception e2) {
            ex = e2;
        }
        if (getItemViewType(position) == 1) {
            if (data_index == -1) {
                if (this.mIsProcessPre) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.loading);
                } else {
                    holder.mProgress.setVisibility(8);
                    holder.mPageText.setText(R.string.load_more);
                }
            } else if (data_index == -2) {
                if (this.mIsProcessMore) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.loading);
                } else {
                    holder.mProgress.setVisibility(8);
                    holder.mPageText.setText(R.string.load_more);
                }
            }
            return convertView;
        }
        holder.mPhoto.setOnClickListener(null);
        holder.mText.setVisibility(8);
        holder.mText.setText((CharSequence) null);
        holder.mText.setMovementMethod(LinkMovementMethod.getInstance());
        holder.mText.setFocusable(false);
        holder.mSeg.setVisibility(8);
        holder.mSeg.removeAllViews();
        holder.mPhoto.setTag(null);
        PostData data = (PostData) getItem(position);
        if (data == null) {
            return convertView;
        }
        String portrait = data.getAuthor().getPortrait();
        holder.mPhoto.setVisibility(0);
        holder.mUserName.setVisibility(0);
        holder.mRank.setVisibility(0);
        if (this.mPbModel.getIsDisplayPhoto()) {
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
            holder.mPhoto.setVisibility(0);
        } else {
            holder.mPhoto.setVisibility(8);
        }
        holder.mPhotoClick.setId(data.getAuthor().getId());
        holder.mPhotoClick.setName(data.getAuthor().getName());
        holder.mPhoto.setOnClickListener(holder.mPhotoClick);
        if (this.mPbModel.getMarkId() != null && data.getId() != null && this.mPbModel.getMarkId().equals(data.getId())) {
            holder.mMark.setVisibility(0);
        } else {
            holder.mMark.setVisibility(8);
        }
        if (data.getAuthor() != null && data.getAuthor().getName_show() != null) {
            holder.mUserName.setText(data.getAuthor().getName_show());
        }
        if (data.getAuthor() != null && data.getAuthor().getLevel_id() != 0) {
            holder.mRank.setText(String.valueOf(data.getAuthor().getLevel_id()) + this.mContext.getString(R.string.grade));
        } else {
            holder.mRank.setText((CharSequence) null);
        }
        holder.mTime.setText(StringHelper.getTimeString(data.getTime()));
        holder.mFloorText.setText(String.valueOf(data.getFloor_num()) + this.mContext.getString(R.string.floor));
        ArrayList<ContentData> content = data.getUnite_content();
        if (content != null && content.size() > 0) {
            int i = 0;
            ContentData seg = content.get(0);
            if (seg != null && seg.getType() == 0) {
                holder.mText.setVisibility(0);
                holder.mText.setText(seg.getUniteString());
                i = 0 + 1;
            }
            int index = -1;
            holder.mSeg.setVisibility(8);
            while (i < content.size()) {
                holder.mSeg.setVisibility(0);
                ContentData seg2 = content.get(i);
                if (seg2.getType() == 3) {
                    index++;
                    ImageView imageView = new ImageView(this.mContext);
                    int height = UtilHelper.dip2px(this.mContext, 80.0f);
                    int width = UtilHelper.dip2px(this.mContext, 140.0f);
                    LinearLayout.LayoutParams imageViewparams = new LinearLayout.LayoutParams(width, height);
                    int px_v = UtilHelper.dip2px(this.mContext, 15.0f);
                    imageViewparams.topMargin = px_v;
                    Bitmap image = this.mImageLoader.getPic(seg2.getLink());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    if (image != null) {
                        imageView.setTag(null);
                        imageView.setImageBitmap(image);
                    } else {
                        imageView.setTag(seg2.getLink());
                        imageView.setImageResource(R.drawable.image_default);
                    }
                    imageView.setClickable(true);
                    imageView.setFocusable(false);
                    ImageOnClickListener listern = new ImageOnClickListener(content, index);
                    imageView.setOnClickListener(listern);
                    holder.mSeg.addView(imageView, imageViewparams);
                } else {
                    CustomTextView textView = new CustomTextView(this.mContext);
                    LinearLayout.LayoutParams textViewparams = new LinearLayout.LayoutParams(-1, -2);
                    int px_v2 = UtilHelper.dip2px(this.mContext, 15.0f);
                    textViewparams.rightMargin = 0;
                    textViewparams.leftMargin = 0;
                    textViewparams.topMargin = px_v2;
                    textView.setTextSize(16.0f);
                    textView.setTextColor(-11974584);
                    textView.setText(seg2.getUniteString());
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setFocusable(false);
                    holder.mSeg.addView(textView, textViewparams);
                }
                i++;
            }
        } else {
            holder.mText.setVisibility(0);
            holder.mText.setText((CharSequence) null);
        }
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return getItemId(position) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void setHaveHeader(boolean haveHeader) {
        this.mHaveHeader = haveHeader;
    }

    public boolean isHaveHeader() {
        return this.mHaveHeader;
    }

    public void setHaveFooter(boolean haveFooter) {
        this.mHaveFooter = haveFooter;
    }

    public boolean isHaveFooter() {
        return this.mHaveFooter;
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

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mFloorText;
        ImageView mMark;
        TextView mPageText;
        ImageView mPhoto;
        PhotoOnClickListener mPhotoClick;
        ProgressBar mProgress;
        TextView mRank;
        LinearLayout mSeg;
        TextView mText;
        TextView mTime;
        TextView mUserName;

        private ViewHolder() {
        }
    }

    /* loaded from: classes.dex */
    private class ImageOnClickListener implements View.OnClickListener {
        private ArrayList<ContentData> mContent;
        private int mIndex;

        public ImageOnClickListener(ArrayList<ContentData> content, int index) {
            this.mContent = content;
            this.mIndex = index;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                ArrayList<String> data = new ArrayList<>();
                for (int i = 0; i < this.mContent.size(); i++) {
                    if (this.mContent.get(i).getType() == 3) {
                        StringBuffer buffer = new StringBuffer(100);
                        buffer.append("size=");
                        buffer.append(Config.THREAD_IMAGE_MAX_WIDTH);
                        buffer.append("&src=");
                        String encode = StringHelper.getUrlEncode(this.mContent.get(i).getLink());
                        buffer.append(encode);
                        data.add(buffer.toString());
                    }
                }
                ImageActivity.startActivity(PbAdapter.this.mContext, data, this.mIndex);
            } catch (Exception ex) {
                TiebaLog.e("PbAdapter", "ImageOnClickListener", "error = " + ex.getMessage());
            }
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
                PersonInfoActivity.startActivity(PbAdapter.this.mContext, this.id, this.name);
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
