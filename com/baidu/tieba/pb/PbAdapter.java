package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.model.PbModel;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.CustomTextView;
import com.baidu.tieba.view.PbImageView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbAdapter extends BaseAdapter {
    public static final int DONT_HAVE = 0;
    public static final int FOOTER_INDEX = -2;
    public static final int HEADER_INDEX = -1;
    public static final int MAY_HAVE = 1;
    public static final int MUST_HAVE = 2;
    public static final int THREAD_TITLE_INDEX = -3;
    private Context mContext;
    private String mCurrAccount;
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
    private int mUserIdentity;

    public PbAdapter(Context context, PbModel model, int imageMaxWidth) {
        this.mPbModel = model;
        this.mContext = context;
        if (this.mPbModel != null && this.mPbModel.getData() != null) {
            this.mData = this.mPbModel.getData().getPost_list();
            this.mUserIdentity = this.mPbModel.getData().getUserIdentity();
        } else {
            this.mData = null;
            this.mUserIdentity = 0;
        }
        this.mIsShowImage = true;
        this.mHaveHeader = 0;
        this.mHaveFooter = 0;
        this.mIsProcessMore = false;
        this.mIsProcessPre = false;
        this.mTextConfig = 3;
        this.mImageMaxWidth = imageMaxWidth > 350 ? Config.PB_IMAGE_NEW_MAX_WIDTH : imageMaxWidth;
        this.mImageLoader = new AsyncImageLoader(this.mContext);
        this.mImageLoader.setImagesize(this.mImageMaxWidth, (int) (this.mImageMaxWidth * 1.62f));
        this.mProgressbars = new ArrayList<>();
        this.mCurrAccount = TiebaApplication.getCurrentAccount();
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
            this.mUserIdentity = this.mPbModel.getData().getUserIdentity();
            return;
        }
        this.mData = null;
        this.mUserIdentity = 0;
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
            int count = this.mData.size() + 1;
            if (this.mHaveHeader != 0) {
                count++;
            }
            if (this.mHaveFooter != 0) {
                return count + 1;
            }
            return count;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int index = (int) getItemId(position);
        if (this.mData == null || index < 0 || index >= this.mData.size()) {
            return null;
        }
        Object item = this.mData.get(index);
        return item;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        int index;
        if (position == 0) {
            return -3;
        }
        if (this.mHaveHeader != 0) {
            index = position - 2;
        } else {
            index = position - 1;
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

    private ImageView createVideoView(ArrayList<ContentData> content, ContentData seg) {
        ImageView imageView = new ImageView(this.mContext);
        LinearLayout.LayoutParams imageViewparams = new LinearLayout.LayoutParams(-2, -2);
        int px_v = UtilHelper.dip2px(this.mContext, 15.0f);
        imageViewparams.topMargin = px_v;
        imageViewparams.bottomMargin = 0;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setTag(seg.getLink());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.video_pic));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.getTag() != null && (v.getTag() instanceof String)) {
                    UtilHelper.startWebActivity(PbAdapter.this.mContext, (String) v.getTag());
                }
            }
        });
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

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Resources rs;
        int itemViewType;
        ViewHolder holder;
        long data_index;
        ThreadData thread;
        if (this.mData == null) {
            return convertView;
        }
        try {
            rs = this.mContext.getResources();
            itemViewType = getItemViewType(position);
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                if (itemViewType == 0) {
                    if (this.mPbModel.getData().getIsHasFloor()) {
                        convertView = mInflater.inflate(R.layout.pb_item_has_floor, (ViewGroup) null);
                    } else {
                        convertView = mInflater.inflate(R.layout.pb_item, (ViewGroup) null);
                    }
                    holder = new ViewHolder(this, null);
                    holder.mPhoto = (ImageView) convertView.findViewById(R.id.photo);
                    holder.mUserName = (TextView) convertView.findViewById(R.id.user_name);
                    holder.mFloorText = (TextView) convertView.findViewById(R.id.floor);
                    holder.mRank = (TextView) convertView.findViewById(R.id.rank);
                    holder.mTime = (TextView) convertView.findViewById(R.id.time);
                    holder.mText = (TextView) convertView.findViewById(R.id.text);
                    holder.mText.setLineSpacing(0.0f, 1.2f);
                    holder.mSeg = (LinearLayout) convertView.findViewById(R.id.seg);
                    holder.mMark = (ImageView) convertView.findViewById(R.id.mark);
                    holder.mPhotoClick = new PhotoOnClickListener();
                    holder.mDelPostClick = new DelPostClickListener();
                    holder.mForbidUserClick = new ForbidUserClickListener();
                    holder.mPhoto.setOnClickListener(holder.mPhotoClick);
                    holder.mUserName.setOnClickListener(holder.mPhotoClick);
                    holder.mForbidUser = (TextView) convertView.findViewById(R.id.forbid_user);
                    holder.mDelPost = (TextView) convertView.findViewById(R.id.del_post);
                    holder.mManageDivider = convertView.findViewById(R.id.manage_divider);
                    BitmapDrawable dr = new BitmapDrawable(BitmapHelper.getCashBitmap(R.drawable.photo_bg));
                    holder.mPhoto.setBackgroundDrawable(dr);
                    if (this.mPbModel.getData().getIsHasFloor()) {
                        holder.mSubPostNum = (TextView) convertView.findViewById(R.id.text_reply_num);
                        holder.mImageSubPost = (ImageView) convertView.findViewById(R.id.image_reply_num);
                    }
                } else if (itemViewType == 1) {
                    convertView = mInflater.inflate(R.layout.page_item, (ViewGroup) null);
                    holder = new ViewHolder(this, null);
                    holder.mPageText = (TextView) convertView.findViewById(R.id.page_text);
                    holder.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                    this.mProgressbars.add(holder.mProgress);
                } else {
                    convertView = mInflater.inflate(R.layout.pb_thread_name, (ViewGroup) null);
                    holder = new ViewHolder(this, null);
                    holder.mPageText = (TextView) convertView.findViewById(R.id.thread_name);
                    if (this.mPbModel != null && this.mPbModel.getData() != null && (thread = this.mPbModel.getData().getThread()) != null && thread.getTitle() != null && thread.getTitle().length() > 0) {
                        holder.mPageText.setText(thread.getTitle());
                    }
                }
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            data_index = getItemId(position);
            if (this.mPbModel.getData().getIsHasFloor() && itemViewType == 0) {
                if (getItem(position) != null && ((PostData) getItem(position)).getFloor_num() == 1) {
                    holder.mSubPostNum.setVisibility(4);
                    holder.mImageSubPost.setVisibility(4);
                } else {
                    holder.mSubPostNum.setVisibility(0);
                    holder.mImageSubPost.setVisibility(0);
                }
            }
        } catch (Exception ex) {
            TiebaLog.e("PbAdapter", "getView", "error = " + ex.getMessage());
        }
        if (itemViewType == 1 || itemViewType == 2) {
            if (data_index == -1) {
                if (this.mIsProcessPre) {
                    holder.mProgress.setVisibility(0);
                    holder.mPageText.setText(R.string.loading);
                } else {
                    holder.mProgress.setVisibility(8);
                    if (this.mHaveHeader == 1) {
                        if (this.mPbModel.getMarkMode()) {
                            holder.mPageText.setText(R.string.may_have_more);
                        } else if (this.mPbModel.getSequence()) {
                            holder.mPageText.setText(MessageFormat.format(rs.getString(R.string.load_next_page), Integer.valueOf(this.mPbModel.getBigPageNumber())));
                        } else {
                            holder.mPageText.setText(MessageFormat.format(rs.getString(R.string.load_more_atlast), Integer.valueOf(this.mPbModel.getData().getPage().getTotal_page())));
                        }
                    } else if (this.mHaveHeader == 2) {
                        if (this.mPbModel.getMarkMode()) {
                            holder.mPageText.setText(R.string.load_more);
                        } else if (this.mPbModel.getSequence()) {
                            holder.mPageText.setText(MessageFormat.format(rs.getString(R.string.load_prev_page), Integer.valueOf(this.mPbModel.getSmallPageNumber())));
                        } else {
                            holder.mPageText.setText(MessageFormat.format(rs.getString(R.string.load_next_page), Integer.valueOf(this.mPbModel.getBigPageNumber())));
                        }
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
                    if (this.mHaveFooter == 1 || this.mHaveFooter == 2) {
                        if (this.mPbModel.getMarkMode()) {
                            holder.mPageText.setText(R.string.may_have_more);
                        } else if (this.mPbModel.getSequence()) {
                            if (this.mPbModel.getBigPageNumber() == this.mPbModel.getData().getPage().getTotal_page()) {
                                holder.mPageText.setText(MessageFormat.format(rs.getString(R.string.load_more_atlast), Integer.valueOf(this.mPbModel.getData().getPage().getTotal_page())));
                            } else {
                                holder.mPageText.setText(MessageFormat.format(rs.getString(R.string.load_next_page), Integer.valueOf(this.mPbModel.getBigPageNumber())));
                            }
                        } else {
                            holder.mPageText.setText(MessageFormat.format(rs.getString(R.string.load_prev_page), Integer.valueOf(this.mPbModel.getSmallPageNumber())));
                        }
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
        String id = data.getAuthor().getId();
        if (id == null || id.length() <= 0 || id.equals("0")) {
            holder.mUserName.setTextColor(-16777216);
        } else {
            holder.mUserName.setTextColor(-9989158);
        }
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
            int subPostNum = data.getSubPostNum();
            if (subPostNum > 0) {
                holder.mSubPostNum.setText(String.valueOf(data.getSubPostNum()));
            } else {
                holder.mSubPostNum.setText((CharSequence) null);
            }
        }
        holder.mFloorText.setText(String.valueOf(String.valueOf(data.getFloor_num())) + this.mContext.getString(R.string.floor));
        holder.mForbidUser.setVisibility(4);
        holder.mDelPost.setVisibility(4);
        if (this.mUserIdentity != 0 && this.mPbModel.getManageMode()) {
            holder.mForbidUser.setVisibility(0);
            holder.mDelPost.setVisibility(0);
            String authorId = data.getAuthor().getId();
            if (authorId != null && authorId.equals(this.mCurrAccount)) {
                holder.mForbidUser.setVisibility(4);
            }
            if (authorId == null || authorId.equals("0") || authorId.length() == 0) {
                holder.mForbidUser.setVisibility(4);
            }
        } else {
            String authorId2 = this.mPbModel.getData().getThread().getAuthor().getId();
            if (authorId2 != null && authorId2.equals(this.mCurrAccount) && data.getFloor_num() != 1) {
                holder.mDelPost.setVisibility(0);
            }
        }
        holder.mManageDivider.setVisibility(4);
        if (holder.mForbidUser.getVisibility() == 0 && holder.mDelPost.getVisibility() == 0) {
            holder.mManageDivider.setVisibility(0);
        }
        int delType = 0;
        if (data.getFloor_num() == 1) {
            delType = 1;
        }
        holder.mDelPostClick.setDelType(delType);
        holder.mDelPostClick.setPostId(data.getId());
        holder.mDelPostClick.setUserIdentity(this.mUserIdentity);
        holder.mDelPost.setOnClickListener(holder.mDelPostClick);
        holder.mForbidUserClick.setUserName(data.getAuthor().getName());
        holder.mForbidUserClick.setUserIdentity(this.mUserIdentity);
        holder.mForbidUser.setOnClickListener(holder.mForbidUserClick);
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
                } else if (seg2.getType() == 1000) {
                    holder.mSeg.addView(createVideoView(content, seg2));
                    textView_tmp = null;
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
        long id = getItemId(position);
        if (id >= 0) {
            return 0;
        }
        if (getItemId(position) == -1 || getItemId(position) == -2) {
            return 1;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
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
        TextView mDelPost;
        DelPostClickListener mDelPostClick;
        TextView mFloorText;
        TextView mForbidUser;
        ForbidUserClickListener mForbidUserClick;
        ImageView mImageSubPost;
        View mManageDivider;
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
        private int mOriIndex;

        public ImageOnClickListener(ArrayList<ContentData> content, int index) {
            this.mContent = content;
            this.mIndex = index;
            this.mOriIndex = index;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (PbAdapter.this.validImage(this.mContent, this.mIndex)) {
                    boolean index_valid = false;
                    ArrayList<String> data = new ArrayList<>();
                    int num = PbAdapter.this.mData.size();
                    for (int i = 0; i < num; i++) {
                        ArrayList<ContentData> content = ((PostData) PbAdapter.this.mData.get(i)).getUnite_content();
                        if (content == this.mContent) {
                            index_valid = true;
                        }
                        if (content != null) {
                            int content_num = content.size();
                            int pic_index = -1;
                            for (int j = 0; j < content_num; j++) {
                                if (content.get(j) != null && content.get(j).getType() == 3) {
                                    pic_index++;
                                    if (content.get(j).getWidth() < 50 && content.get(j).getHeight() < 50) {
                                        if (content == this.mContent && pic_index <= this.mOriIndex) {
                                            this.mIndex--;
                                        }
                                    } else {
                                        StringBuffer buffer = new StringBuffer(100);
                                        if (content.get(j).getWidth() * content.get(j).getHeight() > Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH) {
                                            double a = Math.sqrt((Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH) / (content.get(j).getWidth() * content.get(j).getHeight()));
                                            buffer.append("width=");
                                            buffer.append(String.valueOf((int) (content.get(j).getWidth() * a)));
                                            buffer.append("&height=");
                                            buffer.append(String.valueOf((int) (content.get(j).getHeight() * a)));
                                        } else {
                                            float f = content.get(j).getWidth() / content.get(j).getHeight();
                                            double a2 = Math.sqrt((Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH) / f);
                                            buffer.append("width=");
                                            buffer.append(String.valueOf((int) (f * a2)));
                                            buffer.append("&height=");
                                            buffer.append(String.valueOf((int) a2));
                                        }
                                        buffer.append("&src=");
                                        String encode = StringHelper.getUrlEncode(content.get(j).getLink());
                                        buffer.append(encode);
                                        data.add(buffer.toString());
                                        if (!index_valid) {
                                            this.mIndex++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ImageActivity.startActivity(PbAdapter.this.mContext, data, this.mIndex, PbAdapter.this.mPbModel);
                }
            } catch (Exception ex) {
                TiebaLog.e("PbAdapter", "ImageOnClickListener", "error = " + ex.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validImage(ArrayList<ContentData> content, int index) {
        if (content == null || index < 0) {
            return false;
        }
        int content_num = content.size();
        int i = -1;
        for (int j = 0; j < content_num; j++) {
            if (content.get(j) != null && content.get(j).getType() == 3) {
                i++;
                if (i == index) {
                    return content.get(j).getWidth() >= 50 || content.get(j).getHeight() >= 50;
                } else if (i > index) {
                    return false;
                }
            }
        }
        return false;
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
            PersonInfoActivity.startActivity(PbAdapter.this.mContext, this.id, this.name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    /* loaded from: classes.dex */
    private class DelPostClickListener implements View.OnClickListener {
        private String postId = null;
        private int delType = 0;
        private int userIdentity = 0;

        public DelPostClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ((PbActivity) PbAdapter.this.mContext).openDelPostDialog(this.delType, this.postId, this.userIdentity);
        }

        public void setPostId(String id) {
            this.postId = id;
        }

        public void setDelType(int type) {
            this.delType = type;
        }

        public void setUserIdentity(int identity) {
            this.userIdentity = identity;
        }
    }

    /* loaded from: classes.dex */
    private class ForbidUserClickListener implements View.OnClickListener {
        private String userName = null;
        private int userIdentity = 0;

        public ForbidUserClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ((PbActivity) PbAdapter.this.mContext).openForbidUserDialog(this.userName, this.userIdentity);
        }

        public void setUserName(String name) {
            this.userName = name;
        }

        public void setUserIdentity(int identity) {
            this.userIdentity = identity;
        }
    }
}
