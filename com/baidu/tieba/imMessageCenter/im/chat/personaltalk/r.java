package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel bKV;
    private PersonalTalkSettingActivity bKW;
    private a bKX;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a bKS = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean agO = false;
    private boolean bKT = false;
    private boolean bKU = false;
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void vx();
    }

    public boolean Yl() {
        return this.bKU;
    }

    public void dz(boolean z) {
        this.bKU = z;
    }

    public DataRes Ym() {
        return this.data;
    }

    public boolean Yn() {
        return this.bKT;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.bKW = personalTalkSettingActivity;
        this.bKX = aVar;
        this.bKV = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.m.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void dA(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void dB(boolean z) {
        this.bKW.showLoadingDialog(null);
        if (z) {
            this.bKV.addToBlackList(this.data.id.longValue());
        } else {
            this.bKV.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bKS != null) {
            this.bKS.cancel();
        }
        if (this.bKV != null) {
            this.bKV.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e Yo() {
        return this.mListener;
    }

    public CustomMessageListener Yp() {
        return this.mCustomListener;
    }
}
