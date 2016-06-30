package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel cZr;
    private PersonalTalkSettingActivity cZs;
    private a cZt;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a aes = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean ahd = false;
    private boolean cZp = false;
    private boolean cZq = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e bBq = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void uY();
    }

    public boolean arz() {
        return this.cZq;
    }

    public void fN(boolean z) {
        this.cZq = z;
    }

    public DataRes arA() {
        return this.data;
    }

    public boolean arB() {
        return this.cZp;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.cZs = personalTalkSettingActivity;
        this.cZt = aVar;
        this.cZr = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.t.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void fO(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void fP(boolean z) {
        this.cZs.showLoadingDialog(null);
        if (z) {
            this.cZr.addToBlackList(this.data.id.longValue());
        } else {
            this.cZr.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aes != null) {
            this.aes.cancel();
        }
        if (this.cZr != null) {
            this.cZr.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e arC() {
        return this.bBq;
    }

    public CustomMessageListener arD() {
        return this.mCustomListener;
    }
}
