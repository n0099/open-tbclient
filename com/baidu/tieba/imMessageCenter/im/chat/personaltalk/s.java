package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class s {
    private final BlackListModel bpP;
    private PersonalTalkSettingActivity bpQ;
    private x bpR;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a bpM = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean abf = false;
    private boolean bpN = false;
    private boolean bpO = false;
    private com.baidu.adp.framework.listener.e mListener = new t(this, 0);
    private CustomMessageListener mCustomListener = new u(this, 0);

    public boolean TY() {
        return this.bpO;
    }

    public void df(boolean z) {
        this.bpO = z;
    }

    public DataRes TZ() {
        return this.data;
    }

    public boolean Ua() {
        return this.bpN;
    }

    public s(PersonalTalkSettingActivity personalTalkSettingActivity, x xVar, long j) {
        this.bpQ = personalTalkSettingActivity;
        this.bpR = xVar;
        this.bpP = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.l.a(new v(this, j), new w(this, j, personalTalkSettingActivity));
    }

    public void dg(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void dh(boolean z) {
        this.bpQ.showLoadingDialog(null);
        if (z) {
            this.bpP.addToBlackList(this.data.id.longValue());
        } else {
            this.bpP.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bpM != null) {
            this.bpM.cancel();
        }
        if (this.bpP != null) {
            this.bpP.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e Ub() {
        return this.mListener;
    }

    public CustomMessageListener Uc() {
        return this.mCustomListener;
    }
}
