package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class s {
    private final BlackListModel bsK;
    private PersonalTalkSettingActivity bsL;
    private x bsM;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a bsH = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean acr = false;
    private boolean bsI = false;
    private boolean bsJ = false;
    private com.baidu.adp.framework.listener.e mListener = new t(this, 0);
    private CustomMessageListener mCustomListener = new u(this, 0);

    public boolean VC() {
        return this.bsJ;
    }

    public void dp(boolean z) {
        this.bsJ = z;
    }

    public DataRes VD() {
        return this.data;
    }

    public boolean VE() {
        return this.bsI;
    }

    public s(PersonalTalkSettingActivity personalTalkSettingActivity, x xVar, long j) {
        this.bsL = personalTalkSettingActivity;
        this.bsM = xVar;
        this.bsK = new BlackListModel(personalTalkSettingActivity);
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
        this.bsL.showLoadingDialog(null);
        if (z) {
            this.bsK.addToBlackList(this.data.id.longValue());
        } else {
            this.bsK.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bsH != null) {
            this.bsH.cancel();
        }
        if (this.bsK != null) {
            this.bsK.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e VF() {
        return this.mListener;
    }

    public CustomMessageListener VG() {
        return this.mCustomListener;
    }
}
