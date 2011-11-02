package com.baidu.tieba.model;

import com.baidu.tieba.data.InfoData;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteModel implements Serializable {
    public static int NEW = 0;
    public static int REPLY = 1;
    public static int REPLY_FLOOR = 2;
    private static final long serialVersionUID = 3754223209695592335L;
    private InfoData mBitmapId;
    private String mContent;
    private String mFloor;
    private int mFloorNum;
    private String mForumId;
    private String mForumName;
    private boolean mHaveDraft;
    private String mThreadId;
    private String mTitle;
    private int mType;
    private String mVcode;
    private String mVcodeMD5;
    private String mVcodeUrl;

    public WriteModel() {
        this.mType = NEW;
        this.mForumId = null;
        this.mForumName = null;
        this.mThreadId = null;
        this.mFloor = null;
        this.mFloorNum = 0;
        this.mTitle = null;
        this.mContent = null;
        this.mVcode = null;
        this.mVcodeMD5 = null;
        this.mVcodeUrl = null;
        this.mBitmapId = null;
        this.mHaveDraft = false;
    }

    public WriteModel(int type) {
        this.mType = type;
        this.mTitle = null;
        this.mContent = null;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public void setThreadId(String threadId) {
        this.mThreadId = threadId;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void setFloor(String floor) {
        this.mFloor = floor;
    }

    public String getFloor() {
        return this.mFloor;
    }

    public void setForumId(String forumId) {
        this.mForumId = forumId;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumName(String forumName) {
        this.mForumName = forumName;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setFloorNum(int floorNum) {
        this.mFloorNum = floorNum;
    }

    public int getFloorNum() {
        return this.mFloorNum;
    }

    public void setVcode(String vcode) {
        this.mVcode = vcode;
    }

    public String getVcode() {
        return this.mVcode;
    }

    public void setBitmapId(InfoData bitmapId) {
        this.mBitmapId = bitmapId;
    }

    public InfoData getBitmapId() {
        return this.mBitmapId;
    }

    public void setVcodeMD5(String vcodeMD5) {
        this.mVcodeMD5 = vcodeMD5;
    }

    public String getVcodeMD5() {
        return this.mVcodeMD5;
    }

    public String getVcodeUrl() {
        return this.mVcodeUrl;
    }

    public void setVcodeUrl(String vcodeUrl) {
        this.mVcodeUrl = vcodeUrl;
    }

    public void setHaveDraft(boolean haveDraft) {
        this.mHaveDraft = haveDraft;
    }

    public boolean getHaveDraft() {
        return this.mHaveDraft;
    }
}
