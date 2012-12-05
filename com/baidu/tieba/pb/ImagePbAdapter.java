package com.baidu.tieba.pb;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.ImageData;
import com.baidu.tieba.data.ImageSubPbData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.ContentHelper;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ImagePbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ImagePbAdapter extends BaseAdapter {
    private static final int FOOTER_TYPE = 1;
    private static final int HEADER_TYPE = 2;
    private static final int NORMAL_TYPE = 0;
    private int equipWidth;
    private Context mContext;
    private ImageData mImageData;
    private boolean mIsProcessMore;
    private ImageSubPbData mData = null;
    private boolean isReplyed = true;
    private int lastCount = 0;
    private int minHeight = 0;
    private int maxHeight = 0;
    private View.OnClickListener mImageClickListener = null;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    public ImagePbAdapter(Context context, ImageData data) {
        this.mImageData = null;
        this.mContext = null;
        this.equipWidth = 0;
        this.mContext = context;
        this.mImageData = data;
        this.equipWidth = UtilHelper.getEquipmentWidth(this.mContext);
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

    public boolean hasNext() {
        if (this.mData == null || !this.isReplyed) {
            return false;
        }
        return this.mData.hasNext();
    }

    public boolean isLast() {
        return !this.isReplyed || this.mData == null || this.mData.isLast();
    }

    public int getPageNum() {
        if (this.mData == null || this.mData.getData() == null) {
            return 1;
        }
        return (this.mData.getData().size() / 10) + 1;
    }

    public ImageData getImageData() {
        return this.mImageData;
    }

    public void setDatas(ImageSubPbData data) {
        this.mData = data;
    }

    public void setIsProcessMore(boolean isProcessMore) {
        this.mIsProcessMore = isProcessMore;
    }

    public boolean isProcessMore() {
        return this.mIsProcessMore;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        this.isReplyed = true;
        if (this.mImageData == null) {
            return 0;
        }
        if (this.mData == null || this.mData.getData() == null) {
            return 1;
        }
        if (this.mData.getData().size() != this.lastCount) {
            this.lastCount = this.mData.getData().size();
            notifyDataSetChanged();
            return 0;
        } else if (this.mData.getData().size() == 0 || this.mData.getCommentAmount() == 0) {
            this.isReplyed = false;
            return 2;
        } else if (hasNext()) {
            return this.mData.getData().size() + 2;
        } else {
            return this.mData.getData().size() + 1;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int arg0) {
        if (this.mData == null || this.mData.getData() == null || arg0 >= this.mData.getData().size()) {
            return null;
        }
        return this.mData.getData().get(arg0 + 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 2;
        }
        if (position == this.mData.getDataNum() + 1 || !this.isReplyed) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LinearLayout.LayoutParams imageViewParams;
        int type = getItemViewType(position);
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(this.mContext);
            if (type == 0) {
                convertView = mInflater.inflate(R.layout.image_pb_list_item, (ViewGroup) null);
                holder = new ViewHolder(this, null);
                holder.commentText = (TextView) convertView.findViewById(R.id.image_pb_item_comment);
                holder.authorText = (TextView) convertView.findViewById(R.id.image_pb_item_auther);
                holder.timeText = (TextView) convertView.findViewById(R.id.image_pb_item_time);
                holder.mSeg = (LinearLayout) convertView.findViewById(R.id.seg);
            } else if (type == 2) {
                convertView = mInflater.inflate(R.layout.image_pb_list_header, (ViewGroup) null);
                holder = new ViewHolder(this, null);
                holder.imageText = (TextView) convertView.findViewById(R.id.image_pb_comment);
                holder.imageAuthorText = (TextView) convertView.findViewById(R.id.image_pb_author);
                holder.imageReplyText = (TextView) convertView.findViewById(R.id.image_pb_reply_number);
                holder.imageSeg = (LinearLayout) convertView.findViewById(R.id.seg);
                holder.image = (ImagePbImageView) convertView.findViewById(R.id.image_pb_image);
            } else {
                convertView = mInflater.inflate(R.layout.page_item, (ViewGroup) null);
                holder = new ViewHolder(this, null);
                holder.mPageText = (TextView) convertView.findViewById(R.id.page_text);
                holder.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                this.mProgressbars.add(holder.mProgress);
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (type == 0) {
            holder.commentText.setGravity(3);
            holder.commentText.setMovementMethod(LinkMovementMethod.getInstance());
            holder.commentText.setTextColor(this.mContext.getResources().getColor(R.color.reg_font_color));
            PostData posts = this.mData.getData().get(position - 1);
            holder.timeText.setVisibility(0);
            holder.authorText.setVisibility(0);
            holder.authorText.setText(posts.getAuthor().getName());
            final String authorId = posts.getAuthor().getId();
            final String authorName = posts.getAuthor().getName();
            holder.authorText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    PersonInfoActivity.startActivity(ImagePbAdapter.this.mContext, String.valueOf(authorId), authorName);
                }
            });
            holder.timeText.setText(StringHelper.getTimeString(posts.getTime()));
            holder.mSeg.setVisibility(8);
            holder.mSeg.removeAllViews();
            ArrayList<ContentData> content = posts.getUnite_content();
            new ContentHelper(this.mContext).setContent(holder.commentText, holder.mSeg, content, false);
            holder.commentText.setTextSize(2, 13.0f);
        } else if (type == 1) {
            if (holder.mProgress != null && holder.mPageText != null) {
                holder.mPageText.setTextSize(2, 13.0f);
                if (this.mIsProcessMore) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.data_loading_1);
                } else {
                    holder.mProgress.setVisibility(8);
                    holder.mPageText.setTextColor(this.mContext.getResources().getColor(R.color.gray));
                    if (!this.isReplyed) {
                        holder.mPageText.setText(this.mContext.getString(R.string.image_pb_noreply));
                        holder.mPageText.setFocusable(true);
                    } else {
                        holder.mPageText.setText(R.string.load_more);
                    }
                }
            }
        } else if (type == 2) {
            ArrayList<ContentData> content2 = this.mImageData.getImageDescribe().getUnite_content();
            ContentHelper helper = new ContentHelper(this.mContext);
            holder.imageText.setMovementMethod(LinkMovementMethod.getInstance());
            helper.setIsEllipsized(true);
            helper.setContent(holder.imageText, holder.imageSeg, content2, false);
            holder.imageText.setTextSize(2, 13.0f);
            if (holder.imageText.getText().toString().trim().length() == 0) {
                holder.imageText.setVisibility(8);
            }
            holder.imageAuthorText.setText(this.mImageData.getUserName());
            final String userID = this.mImageData.getUserID();
            final String userName = this.mImageData.getUserName();
            holder.imageAuthorText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    PersonInfoActivity.startActivity(ImagePbAdapter.this.mContext, userID, userName);
                }
            });
            holder.image.setTag(this.mImageData.getImageUrl());
            if (this.mImageClickListener != null) {
                holder.image.setOnClickListener(this.mImageClickListener);
            }
            if (this.mData != null) {
                showCommentNum(this.mData.getCommentAmount(), holder.imageReplyText);
            }
            int height = this.mImageData.getHeight();
            if (this.mImageData.getWidth() > this.equipWidth) {
                height = (this.equipWidth * height) / this.mImageData.getWidth();
            }
            if (height >= this.maxHeight) {
                holder.image.setScale(1);
                imageViewParams = new LinearLayout.LayoutParams(this.equipWidth, this.maxHeight);
            } else if (height <= this.minHeight) {
                holder.image.setScale(0);
                imageViewParams = new LinearLayout.LayoutParams(this.equipWidth, this.minHeight);
            } else {
                holder.image.setScale(1);
                imageViewParams = new LinearLayout.LayoutParams(this.equipWidth, height);
            }
            holder.image.setLayoutParams(imageViewParams);
        }
        return convertView;
    }

    private void showCommentNum(int num, TextView text) {
        if (num == 0) {
            text.setVisibility(8);
            return;
        }
        text.setText(String.valueOf(String.valueOf(num)) + this.mContext.getString(R.string.comment_number));
        text.setVisibility(0);
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView authorText;
        TextView commentText;
        ImagePbImageView image;
        TextView imageAuthorText;
        TextView imageReplyText;
        LinearLayout imageSeg;
        TextView imageText;
        TextView mPageText;
        ProgressBar mProgress;
        LinearLayout mSeg;
        TextView timeText;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(ImagePbAdapter imagePbAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    public void setImageHeight(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public void setImageClickListener(View.OnClickListener mImageClickListener) {
        this.mImageClickListener = mImageClickListener;
    }
}
