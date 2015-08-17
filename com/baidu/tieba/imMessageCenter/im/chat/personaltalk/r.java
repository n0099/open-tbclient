package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel bGD;
    private PersonalTalkSettingActivity bGE;
    private a bGF;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a bGA = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean ahB = false;
    private boolean bGB = false;
    private boolean bGC = false;
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void vz();
    }

    public boolean Xk() {
        return this.bGC;
    }

    public void ds(boolean z) {
        this.bGC = z;
    }

    public DataRes Xl() {
        return this.data;
    }

    public boolean Xm() {
        return this.bGB;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.bGE = personalTalkSettingActivity;
        this.bGF = aVar;
        this.bGD = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.l.a(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void dt(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void du(boolean z) {
        this.bGE.showLoadingDialog(null);
        if (z) {
            this.bGD.addToBlackList(this.data.id.longValue());
        } else {
            this.bGD.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bGA != null) {
            this.bGA.cancel();
        }
        if (this.bGD != null) {
            this.bGD.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e Xn() {
        return this.mListener;
    }

    public CustomMessageListener Xo() {
        return this.mCustomListener;
    }
}
