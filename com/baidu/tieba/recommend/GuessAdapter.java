package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.MediaData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.ReadThreadHistory;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsImageView;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class GuessAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<ThreadData> mData;
    private boolean mHaveFooter;
    private boolean mHaveHeader;
    private AsyncImageLoader mImageLoader;
    private boolean mIsProcessNext;
    private boolean mIsProcessPre;
    private int mScreenWidth;
    private View.OnClickListener mImageOnClickListener = null;
    private View.OnClickListener mForumNameOnClickListener = null;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    private LinearLayout createImageView(final MediaData media, int n) {
        if (media.getVideoUrl() != null && (media.getVideoUrl().length() < 1 || media.getVideoUrl().endsWith("swf"))) {
            return null;
        }
        FrsImageView imageView = new FrsImageView(this.mContext, media.getType());
        LinearLayout mLinearLayout = new LinearLayout(this.mContext);
        if (n == 3) {
            imageView.setIsThree(true);
        }
        LinearLayout.LayoutParams imageViewparams = new LinearLayout.LayoutParams((this.mScreenWidth - UtilHelper.dip2px(this.mContext, (n * 2) + 30)) / n, (this.mScreenWidth - UtilHelper.px2dip(this.mContext, 30.0f)) / 4);
        LinearLayout.LayoutParams layoutViewparams = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) imageViewparams);
        int px_v = UtilHelper.dip2px(this.mContext, 10.0f);
        layoutViewparams.rightMargin = UtilHelper.dip2px(this.mContext, 2.0f);
        layoutViewparams.topMargin = px_v;
        layoutViewparams.bottomMargin = 0;
        imageView.setTag(media.getPicUrl());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setLayoutParams(imageViewparams);
        mLinearLayout.setLayoutParams(layoutViewparams);
        mLinearLayout.addView(imageView);
        if (media.getType() == 5) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommend.GuessAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    UtilHelper.startWebActivity(GuessAdapter.this.mContext, media.getVideoUrl());
                }
            });
            return mLinearLayout;
        } else if (media.getType() == 3) {
            imageView.setOnClickListener(this.mImageOnClickListener);
            return mLinearLayout;
        } else {
            return mLinearLayout;
        }
    }

    public void setImageOnclickListener(View.OnClickListener listener) {
        this.mImageOnClickListener = listener;
    }

    public void setForumNameOnclickListener(View.OnClickListener listener) {
        this.mForumNameOnClickListener = listener;
    }

    public GuessAdapter(Context context, ArrayList<ThreadData> data, int imageMaxWidth) {
        this.mContext = context;
        this.mData = data;
        this.mImageLoader = new AsyncImageLoader(this.mContext);
        this.mImageLoader.setSuffix(AsyncImageLoader.SMALL);
        this.mScreenWidth = imageMaxWidth;
        imageMaxWidth = imageMaxWidth > Config.THREAD_IMAGE_MAX_WIDTH ? Config.THREAD_IMAGE_MAX_WIDTH : imageMaxWidth;
        this.mImageLoader.setImagesize(imageMaxWidth, (imageMaxWidth - UtilHelper.dip2px(this.mContext, 6.0f)) / 4);
    }

    public AsyncImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public void setIsProcessNext(boolean b) {
        this.mIsProcessNext = b;
    }

    public boolean getIsProcessNext() {
        return this.mIsProcessNext;
    }

    public void setIsProcessPre(boolean b) {
        this.mIsProcessPre = b;
    }

    public boolean getIsProcessPre() {
        return this.mIsProcessPre;
    }

    public void setHaveHeader(boolean b) {
        this.mHaveHeader = b;
    }

    public boolean getHaveHeader() {
        return this.mHaveHeader;
    }

    public void setHaveFooter(boolean b) {
        this.mHaveFooter = b;
    }

    public boolean getHaveFooter() {
        return this.mHaveFooter;
    }

    public void setData(ArrayList<ThreadData> data) {
        this.mData = data;
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
        ViewHolder holder;
        View temp;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.guess_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder(this, null);
                try {
                    holder2.mContent = (LinearLayout) convertView.findViewById(R.id.guess_list_item);
                    holder2.mReplyNum = (TextView) convertView.findViewById(R.id.guess_lv_reply_num);
                    holder2.mReplyTime = (TextView) convertView.findViewById(R.id.guess_lv_reply_time);
                    holder2.mTitle = (TextView) convertView.findViewById(R.id.guess_lv_title);
                    holder2.mForumName = (TextView) convertView.findViewById(R.id.guess_lv_forum_name);
                    holder2.abstractLayout = (LinearLayout) convertView.findViewById(R.id.guess_lv_abstract);
                    holder2.abstractTextView = (TextView) convertView.findViewById(R.id.guess_abstract_text);
                    holder2.mSeg = (LinearLayout) convertView.findViewById(R.id.guess_abstract_img_layout);
                    holder2.mReplayIcon = (ImageView) convertView.findViewById(R.id.guess_lv_autor_icon);
                    holder2.mControl = (RelativeLayout) convertView.findViewById(R.id.guess_list_control);
                    holder2.mCtlText = (TextView) convertView.findViewById(R.id.list_control_tv);
                    holder2.mCtlProg = (ProgressBar) convertView.findViewById(R.id.list_control_progress);
                    holder2.mSeperator1 = convertView.findViewById(R.id.seperator1);
                    holder2.mSeperator2 = convertView.findViewById(R.id.seperator2);
                    holder2.mForumName.setOnClickListener(this.mForumNameOnClickListener);
                    convertView.setTag(holder2);
                    this.mProgressbars.add(holder2.mCtlProg);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "", "FrsAdapter.getView error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            long data_index = getItemId(position);
            if (data_index == -1) {
                holder.mContent.setVisibility(8);
                holder.mControl.setVisibility(0);
                holder.mSeperator1.setVisibility(8);
                holder.mSeperator2.setVisibility(0);
                if (this.mIsProcessPre) {
                    holder.mCtlText.setText(R.string.loading);
                    holder.mCtlProg.setVisibility(0);
                } else {
                    holder.mCtlText.setText(R.string.click_look_pre);
                    holder.mCtlProg.setVisibility(8);
                }
            } else if (data_index == -2) {
                holder.mContent.setVisibility(8);
                holder.mControl.setVisibility(0);
                holder.mSeperator1.setVisibility(0);
                holder.mSeperator2.setVisibility(8);
                if (this.mIsProcessNext) {
                    holder.mCtlText.setText(R.string.loading);
                    holder.mCtlProg.setVisibility(0);
                } else {
                    holder.mCtlText.setText(R.string.click_look_next);
                    holder.mCtlProg.setVisibility(8);
                }
            } else {
                holder.mContent.setVisibility(0);
                holder.mControl.setVisibility(8);
                holder.mCtlProg.setVisibility(8);
                ThreadData data = (ThreadData) getItem(position);
                int replyNum = data.getReply_num();
                if (replyNum <= 999) {
                    if (replyNum > 0) {
                        holder.mReplayIcon.setVisibility(0);
                        holder.mReplyNum.setText(String.valueOf(replyNum));
                    } else {
                        holder.mReplayIcon.setVisibility(8);
                        holder.mReplyNum.setText((CharSequence) null);
                    }
                } else {
                    holder.mReplyNum.setText("999+");
                }
                Date tmpDate = new Date();
                tmpDate.setTime(data.getLast_time_int() * 1000);
                String d = StringHelper.GetTimeString(tmpDate);
                holder.mReplyTime.setText(d);
                holder.mTitle.setText(data.getSpan_str());
                holder.mTitle.setTextColor(-16777216);
                ReadThreadHistory history = TiebaApplication.app.getReadGuessHistory();
                if (history != null && history.getThread(data.getTid())) {
                    holder.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.read_thread_color));
                }
                Resources rs = this.mContext.getResources();
                holder.mForumName.setText(String.valueOf(data.getForum_name()) + rs.getString(R.string.forum));
                holder.mForumName.setTag(data.getForum_name());
                if (data.getIs_top() != 1) {
                    holder.abstractLayout.setVisibility(0);
                    holder.mSeg.setVisibility(0);
                    holder.abstractTextView.setVisibility(0);
                    ArrayList<MediaData> medias = data.getMedias();
                    String abstractText = "";
                    if (data.getAbstract() != null) {
                        abstractText = String.valueOf("") + data.getAbstract();
                    }
                    if (medias != null) {
                        for (int i = 0; i < medias.size(); i++) {
                            if (medias.get(i).getVideoUrl() != null && medias.get(i).getVideoUrl().endsWith("swf")) {
                                abstractText = String.valueOf(abstractText) + medias.get(i).getVideoUrl();
                            }
                        }
                        if (abstractText != null && abstractText.length() > 1) {
                            holder.abstractTextView.setText(abstractText);
                        } else {
                            holder.abstractTextView.setVisibility(8);
                        }
                        if (medias.size() > 0) {
                            holder.mSeg.removeAllViews();
                            int picNum = 0;
                            for (int i2 = 0; i2 < medias.size(); i2++) {
                                if (medias.get(i2) != null && (medias.get(i2).getType() == 3 || medias.get(i2).getType() == 5)) {
                                    picNum++;
                                }
                            }
                            if (picNum > 3) {
                                picNum = 3;
                            }
                            int j = 0;
                            for (int i3 = 0; i3 < medias.size() && j < picNum; i3++) {
                                if ((medias.get(i3).getType() == 3 || medias.get(i3).getType() == 5) && (temp = createImageView(medias.get(i3), picNum)) != null) {
                                    holder.mSeg.addView(temp);
                                    j++;
                                }
                            }
                        } else {
                            holder.mSeg.setVisibility(8);
                        }
                    }
                } else {
                    holder.abstractLayout.setVisibility(8);
                }
            }
        } catch (Exception e2) {
            ex = e2;
        }
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        LinearLayout abstractLayout;
        TextView abstractTextView;
        LinearLayout mContent;
        RelativeLayout mControl;
        ProgressBar mCtlProg;
        TextView mCtlText;
        TextView mForumName;
        ImageView mReplayIcon;
        TextView mReplyNum;
        TextView mReplyTime;
        LinearLayout mSeg;
        View mSeperator1;
        View mSeperator2;
        TextView mTitle;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(GuessAdapter guessAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
