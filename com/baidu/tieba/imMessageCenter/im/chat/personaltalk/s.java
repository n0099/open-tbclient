package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class s {
    private final BlackListModel bqf;
    private PersonalTalkSettingActivity bqg;
    private x bqh;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a bqc = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean abn = false;
    private boolean bqd = false;
    private boolean bqe = false;
    private com.baidu.adp.framework.listener.e mListener = new t(this, 0);
    private CustomMessageListener mCustomListener = new u(this, 0);

    public boolean Ul() {
        return this.bqe;
    }

    public void dd(boolean z) {
        this.bqe = z;
    }

    public DataRes Um() {
        return this.data;
    }

    public boolean Un() {
        return this.bqd;
    }

    public s(PersonalTalkSettingActivity personalTalkSettingActivity, x xVar, long j) {
        this.bqg = personalTalkSettingActivity;
        this.bqh = xVar;
        this.bqf = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.l.a(new v(this, j), new w(this, j, personalTalkSettingActivity));
    }

    public void de(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void df(boolean z) {
        this.bqg.showLoadingDialog(null);
        if (z) {
            this.bqf.addToBlackList(this.data.id.longValue());
        } else {
            this.bqf.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bqc != null) {
            this.bqc.cancel();
        }
        if (this.bqf != null) {
            this.bqf.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e Uo() {
        return this.mListener;
    }

    public CustomMessageListener Up() {
        return this.mCustomListener;
    }
}
