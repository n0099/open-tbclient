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
    private final BlackListModel dnW;
    private PersonalTalkSettingActivity dnX;
    private a dnY;
    private com.baidu.tbadk.coreExtra.d.a aib = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean akW = false;
    private boolean dnU = false;
    private boolean dnV = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cjp = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wc();
    }

    public boolean awZ() {
        return this.dnV;
    }

    public void gm(boolean z) {
        this.dnV = z;
    }

    public DataRes axa() {
        return this.data;
    }

    public boolean axb() {
        return this.dnU;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dnX = personalTalkSettingActivity;
        this.dnY = aVar;
        this.dnW = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.u.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gn(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void go(boolean z) {
        this.dnX.showLoadingDialog(null);
        if (z) {
            this.dnW.addToBlackList(this.data.id.longValue());
        } else {
            this.dnW.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aib != null) {
            this.aib.cancel();
        }
        if (this.dnW != null) {
            this.dnW.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e axc() {
        return this.cjp;
    }

    public CustomMessageListener axd() {
        return this.mCustomListener;
    }
}
