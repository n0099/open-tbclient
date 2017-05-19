package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes2.dex */
public class r {
    private DataRes data;
    private final BlackListModel deC;
    private PersonalTalkSettingActivity deD;
    private a deE;
    private com.baidu.tbadk.coreExtra.c.a amV = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean deA = false;
    private boolean deB = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cIY = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes2.dex */
    public interface a {
        void wh();
    }

    public boolean asl() {
        return this.deB;
    }

    public void fY(boolean z) {
        this.deB = z;
    }

    public DataRes asm() {
        return this.data;
    }

    public boolean asn() {
        return this.deA;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.deD = personalTalkSettingActivity;
        this.deE = aVar;
        this.deC = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.w.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void fZ(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void ga(boolean z) {
        this.deD.showLoadingDialog(null);
        if (z) {
            this.deC.addToBlackList(this.data.id.longValue());
        } else {
            this.deC.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.amV != null) {
            this.amV.cancel();
        }
        if (this.deC != null) {
            this.deC.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e aso() {
        return this.cIY;
    }

    public CustomMessageListener asp() {
        return this.mCustomListener;
    }
}
