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
    private final BlackListModel dvc;
    private PersonalTalkSettingActivity dvd;
    private a dve;
    private com.baidu.tbadk.coreExtra.d.a air = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean alx = false;
    private boolean dva = false;
    private boolean dvb = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e coV = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void ww();
    }

    public boolean azv() {
        return this.dvb;
    }

    public void gJ(boolean z) {
        this.dvb = z;
    }

    public DataRes azw() {
        return this.data;
    }

    public boolean azx() {
        return this.dva;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dvd = personalTalkSettingActivity;
        this.dve = aVar;
        this.dvc = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.t.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gK(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gL(boolean z) {
        this.dvd.showLoadingDialog(null);
        if (z) {
            this.dvc.addToBlackList(this.data.id.longValue());
        } else {
            this.dvc.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.air != null) {
            this.air.cancel();
        }
        if (this.dvc != null) {
            this.dvc.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e azy() {
        return this.coV;
    }

    public CustomMessageListener azz() {
        return this.mCustomListener;
    }
}
