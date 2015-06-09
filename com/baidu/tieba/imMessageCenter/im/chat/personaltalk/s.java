package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class s {
    private final BlackListModel bsL;
    private PersonalTalkSettingActivity bsM;
    private x bsN;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a bsI = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean acr = false;
    private boolean bsJ = false;
    private boolean bsK = false;
    private com.baidu.adp.framework.listener.e mListener = new t(this, 0);
    private CustomMessageListener mCustomListener = new u(this, 0);

    public boolean VD() {
        return this.bsK;
    }

    public void dp(boolean z) {
        this.bsK = z;
    }

    public DataRes VE() {
        return this.data;
    }

    public boolean VF() {
        return this.bsJ;
    }

    public s(PersonalTalkSettingActivity personalTalkSettingActivity, x xVar, long j) {
        this.bsM = personalTalkSettingActivity;
        this.bsN = xVar;
        this.bsL = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.l.a(new v(this, j), new w(this, j, personalTalkSettingActivity));
    }

    public void dq(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void dr(boolean z) {
        this.bsM.showLoadingDialog(null);
        if (z) {
            this.bsL.addToBlackList(this.data.id.longValue());
        } else {
            this.bsL.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bsI != null) {
            this.bsI.cancel();
        }
        if (this.bsL != null) {
            this.bsL.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e VG() {
        return this.mListener;
    }

    public CustomMessageListener VH() {
        return this.mCustomListener;
    }
}
