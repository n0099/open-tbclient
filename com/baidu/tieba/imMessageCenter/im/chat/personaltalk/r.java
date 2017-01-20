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
    private final BlackListModel dhr;
    private PersonalTalkSettingActivity dhs;
    private a dht;
    private com.baidu.tbadk.coreExtra.d.a ahg = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean isAttention = false;
    private boolean dhp = false;
    private boolean dhq = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e caD = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wb();
    }

    public boolean avb() {
        return this.dhq;
    }

    public void gw(boolean z) {
        this.dhq = z;
    }

    public DataRes avc() {
        return this.data;
    }

    public boolean avd() {
        return this.dhp;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dhs = personalTalkSettingActivity;
        this.dht = aVar;
        this.dhr = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.t.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gx(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gy(boolean z) {
        this.dhs.showLoadingDialog(null);
        if (z) {
            this.dhr.addToBlackList(this.data.id.longValue());
        } else {
            this.dhr.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.ahg != null) {
            this.ahg.cancel();
        }
        if (this.dhr != null) {
            this.dhr.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e ave() {
        return this.caD;
    }

    public CustomMessageListener avf() {
        return this.mCustomListener;
    }
}
