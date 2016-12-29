package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel dac;
    private PersonalTalkSettingActivity dad;
    private a dae;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a ahS = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean akY = false;
    private boolean daa = false;
    private boolean dab = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e bUf = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wg();
    }

    public boolean atV() {
        return this.dab;
    }

    public void gt(boolean z) {
        this.dab = z;
    }

    public DataRes atW() {
        return this.data;
    }

    public boolean atX() {
        return this.daa;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dad = personalTalkSettingActivity;
        this.dae = aVar;
        this.dac = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.t.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gu(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gv(boolean z) {
        this.dad.showLoadingDialog(null);
        if (z) {
            this.dac.addToBlackList(this.data.id.longValue());
        } else {
            this.dac.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.ahS != null) {
            this.ahS.cancel();
        }
        if (this.dac != null) {
            this.dac.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e atY() {
        return this.bUf;
    }

    public CustomMessageListener atZ() {
        return this.mCustomListener;
    }
}
