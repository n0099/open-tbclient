package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel bKp;
    private PersonalTalkSettingActivity bKq;
    private a bKr;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a bKm = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean agH = false;
    private boolean bKn = false;
    private boolean bKo = false;
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void vw();
    }

    public boolean XU() {
        return this.bKo;
    }

    public void dx(boolean z) {
        this.bKo = z;
    }

    public DataRes XV() {
        return this.data;
    }

    public boolean XW() {
        return this.bKn;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.bKq = personalTalkSettingActivity;
        this.bKr = aVar;
        this.bKp = new BlackListModel(personalTalkSettingActivity);
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
        this.bKq.showLoadingDialog(null);
        if (z) {
            this.bKp.addToBlackList(this.data.id.longValue());
        } else {
            this.bKp.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bKm != null) {
            this.bKm.cancel();
        }
        if (this.bKp != null) {
            this.bKp.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e XX() {
        return this.mListener;
    }

    public CustomMessageListener XY() {
        return this.mCustomListener;
    }
}
