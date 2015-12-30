package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel cea;
    private PersonalTalkSettingActivity ceb;
    private a cec;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a cdX = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean ajG = false;
    private boolean cdY = false;
    private boolean cdZ = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void vN();
    }

    public boolean acA() {
        return this.cdZ;
    }

    public void dU(boolean z) {
        this.cdZ = z;
    }

    public DataRes acB() {
        return this.data;
    }

    public boolean acC() {
        return this.cdY;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.ceb = personalTalkSettingActivity;
        this.cec = aVar;
        this.cea = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.n.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void dV(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void dW(boolean z) {
        this.ceb.showLoadingDialog(null);
        if (z) {
            this.cea.addToBlackList(this.data.id.longValue());
        } else {
            this.cea.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.cdX != null) {
            this.cdX.cancel();
        }
        if (this.cea != null) {
            this.cea.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e acD() {
        return this.mListener;
    }

    public CustomMessageListener acE() {
        return this.mCustomListener;
    }
}
