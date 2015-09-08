package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel bHk;
    private PersonalTalkSettingActivity bHl;
    private a bHm;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a bHh = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean ahK = false;
    private boolean bHi = false;
    private boolean bHj = false;
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void vE();
    }

    public boolean Xm() {
        return this.bHj;
    }

    public void dx(boolean z) {
        this.bHj = z;
    }

    public DataRes Xn() {
        return this.data;
    }

    public boolean Xo() {
        return this.bHi;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.bHl = personalTalkSettingActivity;
        this.bHm = aVar;
        this.bHk = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.l.a(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void dy(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void dz(boolean z) {
        this.bHl.showLoadingDialog(null);
        if (z) {
            this.bHk.addToBlackList(this.data.id.longValue());
        } else {
            this.bHk.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bHh != null) {
            this.bHh.cancel();
        }
        if (this.bHk != null) {
            this.bHk.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e Xp() {
        return this.mListener;
    }

    public CustomMessageListener Xq() {
        return this.mCustomListener;
    }
}
