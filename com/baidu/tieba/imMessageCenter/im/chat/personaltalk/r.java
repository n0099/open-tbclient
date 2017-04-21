package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private DataRes data;
    private PersonalTalkSettingActivity dkA;
    private a dkB;
    private final BlackListModel dkz;
    private com.baidu.tbadk.coreExtra.c.a amQ = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean dkx = false;
    private boolean dky = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cOV = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wU();
    }

    public boolean avq() {
        return this.dky;
    }

    public void gx(boolean z) {
        this.dky = z;
    }

    public DataRes avr() {
        return this.data;
    }

    public boolean avs() {
        return this.dkx;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dkA = personalTalkSettingActivity;
        this.dkB = aVar;
        this.dkz = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.t.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gy(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gz(boolean z) {
        this.dkA.showLoadingDialog(null);
        if (z) {
            this.dkz.addToBlackList(this.data.id.longValue());
        } else {
            this.dkz.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.amQ != null) {
            this.amQ.cancel();
        }
        if (this.dkz != null) {
            this.dkz.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e avt() {
        return this.cOV;
    }

    public CustomMessageListener avu() {
        return this.mCustomListener;
    }
}
