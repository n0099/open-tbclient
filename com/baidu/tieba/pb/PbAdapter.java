package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.CustomTextView;
import com.baidu.tieba.view.PbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbAdapter extends BaseAdapter {
    public static final int DONT_HAVE = 0;
    public static final int MAY_HAVE = 1;
    public static final int MUST_HAVE = 2;
    private Context mContext;
    private ArrayList<PostData> mData;
    private int mFontHeight;
    private int mHaveFooter;
    private int mHaveHeader;
    private AsyncImageLoader mImageLoader;
    private int mImageMaxWidth;
    private boolean mIsProcessMore;
    private boolean mIsProcessPre;
    private boolean mIsShowImage;
    private int mLineHeight;
    private PbModel mPbModel;
    private ArrayList<ProgressBar> mProgressbars;
    private int mTextConfig;

    public PbAdapter(Context context, PbModel model, int imageMaxWidth) {
        this.mPbModel = model;
        this.mContext = context;
        if (this.mPbModel != null && this.mPbModel.getData() != null) {
            this.mData = this.mPbModel.getData().getPost_list();
        } else {
            this.mData = null;
        }
        this.mIsShowImage = true;
        this.mHaveHeader = 0;
        this.mHaveFooter = 0;
        this.mIsProcessMore = false;
        this.mIsProcessPre = false;
        this.mTextConfig = 3;
        this.mImageMaxWidth = imageMaxWidth;
        this.mImageLoader = new AsyncImageLoader(this.mContext);
        this.mImageLoader.setImagesize(this.mImageMaxWidth, (int) (this.mImageMaxWidth * 1.62f));
        this.mProgressbars = new ArrayList<>();
    }

    private void initHeight() {
        TextView textView = new TextView(this.mContext);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(Config.getContentSize());
        this.mLineHeight = textView.getLineHeight();
        this.mFontHeight = (int) textView.getTextSize();
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

    private ImageView createImageView(ArrayList<ContentData> content, ContentData seg, int index, int max_width) {
        ImageView imageView = new PbImageView(this.mContext);
        int[] size = UtilHelper.getPbImageSize(seg, max_width);
        LinearLayout.LayoutParams imageViewparams = new LinearLayout.LayoutParams(size[0], size[1]);
        int px_v = UtilHelper.dip2px(this.mContext, 15.0f);
        imageViewparams.topMargin = px_v;
        imageViewparams.bottomMargin = 0;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setTag(seg.getLink());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        ImageOnClickListener listern = new ImageOnClickListener(content, index);
        imageView.setOnClickListener(listern);
        imageView.setLayoutParams(imageViewparams);
        return imageView;
    }

    private TextView createTextView(ContentData seg) {
        CustomTextView textView = new CustomTextView(this.mContext);
        LinearLayout.LayoutParams textViewparams = new LinearLayout.LayoutParams(-1, -2);
        int px_v = UtilHelper.dip2px(this.mContext, 15.0f);
        textViewparams.rightMargin = 0;
        textViewparams.leftMargin = 0;
        textViewparams.topMargin = px_v;
        textViewparams.bottomMargin = 0;
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(Config.getContentSize());
        textView.setTextColor(-11974584);
        setTextForView(textView, seg);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(textViewparams);
        return textView;
    }

    private void setTextForView(TextView view, ContentData seg) {
        if (view != null && seg != null) {
            if (seg.getType() == 2) {
                view.setText(seg.getSpannableString(this.mContext, this.mLineHeight, this.mFontHeight));
            } else {
                view.setText(seg.getUniteString());
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0641: MOVE  (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY] A[D('holder' com.baidu.tieba.pb.PbAdapter$ViewHolder)]), block:B:134:0x0641 */
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
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                try {
                    if (getItemViewType(position) == 0) {
                        if (this.mPbModel.getData().getIsHasFloor()) {
                            convertView = mInflater.inflate(R.layout.pb_item_has_floor, (ViewGroup) null);
                        } else {
                            convertView = mInflater.inflate(R.layout.pb_item, (ViewGroup) null);
                        }
                        holder2 = new ViewHolder(this, null);
                        holder2.mPhoto = (ImageView) convertView.findViewById(R.id.photo);
                        holder2.mUserName = (TextView) convertView.findViewById(R.id.user_name);
                        holder2.mUserName.getPaint().setFakeBoldText(true);
                        holder2.mFloorText = (TextView) convertView.findViewById(R.id.floor);
                        holder2.mRank = (TextView) convertView.findViewById(R.id.rank);
                        holder2.mTime = (TextView) convertView.findViewById(R.id.time);
                        holder2.mText = (TextView) convertView.findViewById(R.id.text);
                        holder2.mText.setLineSpacing(0.0f, 1.2f);
                        holder2.mSeg = (LinearLayout) convertView.findViewById(R.id.seg);
                        holder2.mMark = (ImageView) convertView.findViewById(R.id.mark);
                        holder2.mPhotoClick = new PhotoOnClickListener();
                        holder2.mPhoto.setOnClickListener(holder2.mPhotoClick);
                        BitmapDrawable dr = new BitmapDrawable(BitmapHelper.getCashBitmap(R.drawable.photo_bg));
                        holder2.mPhoto.setBackgroundDrawable(dr);
                        if (this.mPbModel.getData().getIsHasFloor()) {
                            holder2.mSubPostNum = (TextView) convertView.findViewById(R.id.text_reply_num);
                            holder2.mImageSubPost = (ImageView) convertView.findViewById(R.id.image_reply_num);
                            holder = holder2;
                            convertView.setTag(holder);
                        }
                    } else {
                        convertView = mInflater.inflate(R.layout.page_item, (ViewGroup) null);
                        holder2 = new ViewHolder(this, null);
                        holder2.mPageText = (TextView) convertView.findViewById(R.id.page_text);
                        holder2.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                        this.mProgressbars.add(holder2.mProgress);
                    }
                    holder = holder2;
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
            if (this.mPbModel.getData().getIsHasFloor() && getItemViewType(position) == 0) {
                if (getItem(position) != null && ((PostData) getItem(position)).getFloor_num() == 1) {
                    holder.mSubPostNum.setVisibility(4);
                    holder.mImageSubPost.setVisibility(4);
                } else {
                    holder.mSubPostNum.setVisibility(0);
                    holder.mImageSubPost.setVisibility(0);
                }
            }
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
                    if (this.mHaveHeader == 1) {
                        holder.mPageText.setText(R.string.may_have_more);
                    } else if (this.mHaveHeader == 2) {
                        holder.mPageText.setText(R.string.load_more);
                    } else {
                        holder.mPageText.setText((CharSequence) null);
                    }
                }
            } else if (data_index == -2) {
                if (this.mIsProcessMore) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.loading);
                } else {
                    holder.mProgress.setVisibility(8);
                    if (this.mHaveFooter == 1) {
                        holder.mPageText.setText(R.string.may_have_more);
                    } else if (this.mHaveFooter == 2) {
                        holder.mPageText.setText(R.string.load_more);
                    } else {
                        holder.mPageText.setText((CharSequence) null);
                    }
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
            Bitmap bm = null;
            if (portrait != null && portrait.length() > 0) {
                bm = this.mImageLoader.getPhoto(portrait);
                if (bm != null) {
                    holder.mPhoto.setImageBitmap(bm);
                } else {
                    holder.mPhoto.setTag(portrait);
                }
            }
            if (bm == null) {
                Bitmap photo = BitmapHelper.getCashBitmap(R.drawable.photo);
                holder.mPhoto.setImageBitmap(photo);
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
        holder.mUserName.setTextSize(Config.getNameSize());
        if (data.getAuthor() != null) {
            holder.mUserName.setText(data.getAuthor().getName_show());
        } else {
            holder.mUserName.setText((CharSequence) null);
        }
        if (data.getAuthor() != null && data.getAuthor().getLevel_id() != 0) {
            holder.mRank.setText(String.valueOf(String.valueOf(data.getAuthor().getLevel_id())) + this.mContext.getString(R.string.grade));
        } else {
            holder.mRank.setText((CharSequence) null);
        }
        holder.mTime.setText(StringHelper.getTimeString(data.getTime()));
        if (this.mPbModel.getData().getIsHasFloor()) {
            holder.mSubPostNum.setText(String.valueOf(data.getSubPostNum()));
        }
        holder.mFloorText.setText(String.valueOf(String.valueOf(data.getFloor_num())) + this.mContext.getString(R.string.floor));
        ArrayList<ContentData> content = data.getUnite_content();
        if (content != null && content.size() > 0) {
            int i = 0;
            TextView textView_tmp = null;
            ContentData seg = content.get(0);
            if (seg != null && (seg.getType() == 0 || seg.getType() == 2)) {
                holder.mText.setTextSize(Config.getContentSize());
                holder.mText.setVisibility(0);
                setTextForView(holder.mText, seg);
                textView_tmp = holder.mText;
                i = 0 + 1;
            }
            int index = -1;
            holder.mSeg.setVisibility(8);
            while (i < content.size()) {
                holder.mSeg.setVisibility(0);
                ContentData seg2 = content.get(i);
                if (seg2.getType() == 3) {
                    if (this.mIsShowImage) {
                        index++;
                        holder.mSeg.addView(createImageView(content, seg2, index, this.mImageMaxWidth));
                        textView_tmp = null;
                    }
                } else if (textView_tmp != null) {
                    if (seg2.getType() == 2) {
                        textView_tmp.append(seg2.getSpannableString(this.mContext, this.mLineHeight, this.mFontHeight));
                    } else {
                        textView_tmp.append(seg2.getUniteString());
                    }
                } else {
                    TextView view = createTextView(seg2);
                    holder.mSeg.addView(view);
                    textView_tmp = view;
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

    public void setIsShowImage(boolean isShowImage) {
        this.mIsShowImage = isShowImage;
    }

    public boolean isShowImage() {
        return this.mIsShowImage;
    }

    public void setTextConfig(int textConfig) {
        this.mTextConfig = textConfig;
        initHeight();
    }

    public int getTextConfig() {
        return this.mTextConfig;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mFloorText;
        ImageView mImageSubPost;
        ImageView mMark;
        TextView mPageText;
        ImageView mPhoto;
        PhotoOnClickListener mPhotoClick;
        ProgressBar mProgress;
        TextView mRank;
        LinearLayout mSeg;
        TextView mSubPostNum;
        TextView mText;
        TextView mTime;
        TextView mUserName;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(PbAdapter pbAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageOnClickListener implements View.OnClickListener {
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
