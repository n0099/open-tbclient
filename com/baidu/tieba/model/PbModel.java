package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.PbData;
/* loaded from: classes.dex */
public class PbModel {
    private int mHaveMore;
    private int mHavePre;
    private PbData mData = null;
    private boolean mIsDisplayPhoto = true;
    private boolean mSequence = true;
    private boolean mHostMode = false;
    private boolean mIsManageMode = false;
    private boolean mIsprogressTip = false;
    private boolean mIsProcessDelPost = false;
    private boolean mIsProcessForbidUser = false;
    private String mMarkId = null;
    private boolean mMarkMode = false;
    private String mForumName = null;
    private String mForumId = null;
    private String mThreadTitle = null;
    private int mBigPageNumber = 1;
    private int mSmallPageNumber = 1;
    private boolean mIsLastPage = false;

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

    public boolean getIsProcessDelPost() {
        return this.mIsProcessDelPost;
    }

    public void setIsProcessDelPost(boolean isProcess) {
        this.mIsProcessDelPost = isProcess;
    }

    public boolean getIsProcessForbidUser() {
        return this.mIsProcessForbidUser;
    }

    public void setIsProcessForbidUser(boolean isProcess) {
        this.mIsProcessForbidUser = isProcess;
    }

    public boolean getManageMode() {
        return this.mIsManageMode;
    }

    public void setManageMode(boolean mode) {
        this.mIsManageMode = mode;
    }

    public void setMarkId(String markId) {
        this.mMarkId = markId;
    }

    public String getMarkId() {
        return this.mMarkId;
    }

    public void setBigPageNumber(int bigPageNumber) {
        this.mBigPageNumber = bigPageNumber;
    }

    public int getBigPageNumber() {
        return this.mBigPageNumber;
    }

    public void setSmallPageNumber(int smallPageNumber) {
        this.mSmallPageNumber = smallPageNumber;
    }

    public int getSmallPageNumber() {
        return this.mSmallPageNumber;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.mIsLastPage = isLastPage;
    }

    public boolean getIsLastPage() {
        return this.mIsLastPage;
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

    public int getMaxShowPageCount() {
        return Config.PB_LIST_ITEM_MAX_NUM / 60;
    }
}
