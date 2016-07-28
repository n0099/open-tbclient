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
    private final BlackListModel dco;
    private PersonalTalkSettingActivity dcp;
    private a dcq;
    private com.baidu.tbadk.coreExtra.d.a afg = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean ahS = false;
    private boolean dcm = false;
    private boolean dcn = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e bYf = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void uY();
    }

    public boolean asl() {
        return this.dcn;
    }

    public void fQ(boolean z) {
        this.dcn = z;
    }

    public DataRes asm() {
        return this.data;
    }

    public boolean asn() {
        return this.dcm;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dcp = personalTalkSettingActivity;
        this.dcq = aVar;
        this.dco = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.u.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void fR(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void fS(boolean z) {
        this.dcp.showLoadingDialog(null);
        if (z) {
            this.dco.addToBlackList(this.data.id.longValue());
        } else {
            this.dco.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.afg != null) {
            this.afg.cancel();
        }
        if (this.dco != null) {
            this.dco.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e aso() {
        return this.bYf;
    }

    public CustomMessageListener asp() {
        return this.mCustomListener;
    }
}
