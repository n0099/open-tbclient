package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.R;
import com.baidu.tieba.data.PbData;
/* loaded from: classes.dex */
public class PbModel {
    private int mHaveMore;
    private int mHavePre;
    private PbData mData = null;
    private boolean mIsDisplayPhoto = true;
    private boolean mSequence = true;
    private boolean mHostMode = false;
    private boolean mIsprogressTip = false;
    private String mMarkId = null;
    private boolean mMarkMode = false;
    private String mForumName = null;
    private String mForumId = null;
    private String mThreadTitle = null;

    public void setData(PbData data) {
        this.mData = data;
    }

    public PbData getData() {
        return this.mData;
    }

    public void setIsDisplayPhoto(boolean isDisplayPhoto) {
        this.mIsDisplayPhoto = isDisplayPhoto;
    }

    public boolean getIsDisplayPhoto() {
        return this.mIsDisplayPhoto;
    }

    public void setSequence(boolean sequence) {
        this.mSequence = sequence;
    }

    public boolean getSequence() {
        return this.mSequence;
    }

    public void setHostMode(boolean hostMode) {
        this.mHostMode = hostMode;
    }

    public boolean getHostMode() {
        return this.mHostMode;
    }

    public void setIsprogressTip(boolean isprogressTip) {
        this.mIsprogressTip = isprogressTip;
    }

    public boolean getIsprogressTip() {
        return this.mIsprogressTip;
    }

    public void setMarkId(String markId) {
        this.mMarkId = markId;
    }

    public String getMarkId() {
        return this.mMarkId;
    }

    public boolean isCanTip() {
        return (this.mData == null || this.mData.getThread().getHas_commented() == 1 || this.mIsprogressTip) ? false : true;
    }

    public String getTipString(Context context, boolean displayNum) {
        int num;
        StringBuffer str = new StringBuffer(10);
        if (this.mData != null) {
            if (this.mData.getThread().getHas_commented() == 1) {
                str.append(context.getString(R.string.have));
            }
            str.append(context.getString(R.string.tip));
            if (displayNum && (num = this.mData.getThread().getComment_num()) > 0) {
                str.append(String.valueOf(num));
            }
        } else {
            str = str.append(context.getString(R.string.tip));
        }
        return str.toString();
    }

    public void setMarkMode(boolean markMode) {
        this.mMarkMode = markMode;
    }

    public boolean getMarkMode() {
        return this.mMarkMode;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setForumName(String forumName) {
        this.mForumName = forumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumId(String forumId) {
        this.mForumId = forumId;
    }

    public String getThreadTitle() {
        return this.mThreadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.mThreadTitle = threadTitle;
    }

    public void setHaveMore(int mHaveMore) {
        this.mHaveMore = mHaveMore;
    }

    public int getHaveMore() {
        return this.mHaveMore;
    }

    public void setHavePre(int mHavePre) {
        this.mHavePre = mHavePre;
    }

    public int getHavePre() {
        return this.mHavePre;
    }
}
