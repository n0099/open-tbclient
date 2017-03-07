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
    private final BlackListModel djJ;
    private PersonalTalkSettingActivity djK;
    private a djL;
    private com.baidu.tbadk.coreExtra.c.a amC = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean djH = false;
    private boolean djI = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cOh = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wy();
    }

    public boolean auw() {
        return this.djI;
    }

    public void gn(boolean z) {
        this.djI = z;
    }

    public DataRes aux() {
        return this.data;
    }

    public boolean auy() {
        return this.djH;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.djK = personalTalkSettingActivity;
        this.djL = aVar;
        this.djJ = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.t.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void go(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gp(boolean z) {
        this.djK.showLoadingDialog(null);
        if (z) {
            this.djJ.addToBlackList(this.data.id.longValue());
        } else {
            this.djJ.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.amC != null) {
            this.amC.cancel();
        }
        if (this.djJ != null) {
            this.djJ.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e auz() {
        return this.cOh;
    }

    public CustomMessageListener auA() {
        return this.mCustomListener;
    }
}
