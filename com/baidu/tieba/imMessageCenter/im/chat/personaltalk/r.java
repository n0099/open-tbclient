package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel bKA;
    private PersonalTalkSettingActivity bKB;
    private a bKC;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a bKx = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean agI = false;
    private boolean bKy = false;
    private boolean bKz = false;
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void vt();
    }

    public boolean XQ() {
        return this.bKz;
    }

    public void dx(boolean z) {
        this.bKz = z;
    }

    public DataRes XR() {
        return this.data;
    }

    public boolean XS() {
        return this.bKy;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.bKB = personalTalkSettingActivity;
        this.bKC = aVar;
        this.bKA = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.m.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void dy(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void dz(boolean z) {
        this.bKB.showLoadingDialog(null);
        if (z) {
            this.bKA.addToBlackList(this.data.id.longValue());
        } else {
            this.bKA.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bKx != null) {
            this.bKx.cancel();
        }
        if (this.bKA != null) {
            this.bKA.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e XT() {
        return this.mListener;
    }

    public CustomMessageListener XU() {
        return this.mCustomListener;
    }
}
