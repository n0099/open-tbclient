package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class PbLotteryRequestMessage extends HttpMessage {
    public static final String ACTIVITY_ID = "activity_id";
    public static final int ATTENTION_LOTTERY_TYPE = 1;
    public static final String AWARD_ACT_ID = "award_act_id";
    public static final String COMPONENT_ID = "component_id";
    public static final String FORUM_ID = "forum_id";
    public static final String FROM_TYPE = "from_type";
    public static final int LOTTERY_TYPE = 0;
    public static final String THREAD_ID = "thread_id";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    private int mActivityId;
    private int mAwardActId;
    private int mComponentId;
    private String mForumId;
    private int mFromType;
    private String mThreadId;
    private String mUserId;
    private String mUserName;

    public PbLotteryRequestMessage(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4) {
        super(CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
        this.mUserId = str;
        this.mUserName = str2;
        this.mForumId = str3;
        this.mThreadId = str4;
        this.mFromType = i;
        this.mActivityId = i2;
        this.mAwardActId = i3;
        this.mComponentId = i4;
        addParam("user_id", this.mUserId);
        addParam("user_name", this.mUserName);
        addParam("forum_id", this.mForumId);
        addParam("thread_id", this.mThreadId);
        addParam("from_type", Integer.valueOf(this.mFromType));
        addParam("activity_id", Integer.valueOf(this.mActivityId));
        addParam(AWARD_ACT_ID, Integer.valueOf(this.mAwardActId));
        addParam(COMPONENT_ID, Integer.valueOf(this.mComponentId));
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public int getFromType() {
        return this.mFromType;
    }

    public int getActivityId() {
        return this.mActivityId;
    }

    public int getAwardActId() {
        return this.mAwardActId;
    }

    public int getComponentId() {
        return this.mComponentId;
    }
}
