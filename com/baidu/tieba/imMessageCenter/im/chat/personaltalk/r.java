package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel cuc;
    private PersonalTalkSettingActivity cud;
    private a cue;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a adU = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean agz = false;
    private boolean cua = false;
    private boolean cub = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e bfe = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void uY();
    }

    public boolean ajl() {
        return this.cub;
    }

    public void eZ(boolean z) {
        this.cub = z;
    }

    public DataRes ajm() {
        return this.data;
    }

    public boolean ajn() {
        return this.cua;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.cud = personalTalkSettingActivity;
        this.cue = aVar;
        this.cuc = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.t.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void fa(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void fb(boolean z) {
        this.cud.showLoadingDialog(null);
        if (z) {
            this.cuc.addToBlackList(this.data.id.longValue());
        } else {
            this.cuc.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.adU != null) {
            this.adU.cancel();
        }
        if (this.cuc != null) {
            this.cuc.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e ajo() {
        return this.bfe;
    }

    public CustomMessageListener ajp() {
        return this.mCustomListener;
    }
}
