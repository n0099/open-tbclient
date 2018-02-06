package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes3.dex */
public class FriendAndStrangerReqMsg extends HttpMessage {
    public static final int MASK_ALL = 3;
    public static final int MASK_STRANGER = 1;
    private static final String MASK_TYPE = "maskType";
    public static final int NO_MASK = 0;
    public int mMaskType;
    public int mRequestType;

    public FriendAndStrangerReqMsg(int i, int i2) {
        super(CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.mMaskType = 0;
        this.mRequestType = 0;
        this.mMaskType = i;
        this.mRequestType = i2;
        addParam("maskType", i);
    }
}
