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
    private final BlackListModel djW;
    private PersonalTalkSettingActivity djX;
    private a djY;
    private com.baidu.tbadk.coreExtra.c.a amR = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean djU = false;
    private boolean djV = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cOw = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes2.dex */
    public interface a {
        void we();
    }

    public boolean ati() {
        return this.djV;
    }

    public void gl(boolean z) {
        this.djV = z;
    }

    public DataRes atj() {
        return this.data;
    }

    public boolean atk() {
        return this.djU;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.djX = personalTalkSettingActivity;
        this.djY = aVar;
        this.djW = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.w.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gm(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gn(boolean z) {
        this.djX.showLoadingDialog(null);
        if (z) {
            this.djW.addToBlackList(this.data.id.longValue());
        } else {
            this.djW.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.amR != null) {
            this.amR.cancel();
        }
        if (this.djW != null) {
            this.djW.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e atl() {
        return this.cOw;
    }

    public CustomMessageListener atm() {
        return this.mCustomListener;
    }
}
