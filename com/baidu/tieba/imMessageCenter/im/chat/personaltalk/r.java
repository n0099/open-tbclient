package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel bZZ;
    private PersonalTalkSettingActivity caa;
    private a cab;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a bZW = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean aiA = false;
    private boolean bZX = false;
    private boolean bZY = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wd();
    }

    public boolean abr() {
        return this.bZY;
    }

    public void dU(boolean z) {
        this.bZY = z;
    }

    public DataRes abs() {
        return this.data;
    }

    public boolean abt() {
        return this.bZX;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.caa = personalTalkSettingActivity;
        this.cab = aVar;
        this.bZZ = new BlackListModel(personalTalkSettingActivity.getPageContext());
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
        this.caa.showLoadingDialog(null);
        if (z) {
            this.bZZ.addToBlackList(this.data.id.longValue());
        } else {
            this.bZZ.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.bZW != null) {
            this.bZW.cancel();
        }
        if (this.bZZ != null) {
            this.bZZ.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e abu() {
        return this.mListener;
    }

    public CustomMessageListener abv() {
        return this.mCustomListener;
    }
}
