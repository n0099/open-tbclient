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
    private final BlackListModel dii;
    private PersonalTalkSettingActivity dij;
    private a dik;
    private com.baidu.tbadk.coreExtra.c.a amQ = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean dig = false;
    private boolean dih = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cME = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wU();
    }

    public boolean aup() {
        return this.dih;
    }

    public void gn(boolean z) {
        this.dih = z;
    }

    public DataRes auq() {
        return this.data;
    }

    public boolean aur() {
        return this.dig;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dij = personalTalkSettingActivity;
        this.dik = aVar;
        this.dii = new BlackListModel(personalTalkSettingActivity.getPageContext());
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
        this.dij.showLoadingDialog(null);
        if (z) {
            this.dii.addToBlackList(this.data.id.longValue());
        } else {
            this.dii.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.amQ != null) {
            this.amQ.cancel();
        }
        if (this.dii != null) {
            this.dii.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e aus() {
        return this.cME;
    }

    public CustomMessageListener aut() {
        return this.mCustomListener;
    }
}
