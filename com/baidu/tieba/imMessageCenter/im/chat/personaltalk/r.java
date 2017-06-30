package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes2.dex */
public class r {
    private DataRes data;
    private final BlackListModel drS;
    private PersonalTalkSettingActivity drT;
    private a drU;
    private com.baidu.tbadk.coreExtra.c.a anR = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean drQ = false;
    private boolean drR = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cWs = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes2.dex */
    public interface a {
        void ww();
    }

    public boolean awQ() {
        return this.drR;
    }

    public void gD(boolean z) {
        this.drR = z;
    }

    public DataRes awR() {
        return this.data;
    }

    public boolean awS() {
        return this.drQ;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.drT = personalTalkSettingActivity;
        this.drU = aVar;
        this.drS = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        x.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gE(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gF(boolean z) {
        this.drT.showLoadingDialog(null);
        if (z) {
            this.drS.addToBlackList(this.data.id.longValue());
        } else {
            this.drS.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.anR != null) {
            this.anR.cancel();
        }
        if (this.drS != null) {
            this.drS.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e awT() {
        return this.cWs;
    }

    public CustomMessageListener awU() {
        return this.mCustomListener;
    }
}
