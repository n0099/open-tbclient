package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private PersonalTalkSettingActivity ciA;
    private a ciB;
    private final BlackListModel ciz;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a aPE = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean akv = false;
    private boolean cix = false;
    private boolean ciy = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e ber = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void wV();
    }

    public boolean afJ() {
        return this.ciy;
    }

    public void eb(boolean z) {
        this.ciy = z;
    }

    public DataRes afK() {
        return this.data;
    }

    public boolean afL() {
        return this.cix;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.ciA = personalTalkSettingActivity;
        this.ciB = aVar;
        this.ciz = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.n.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void ec(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void ed(boolean z) {
        this.ciA.showLoadingDialog(null);
        if (z) {
            this.ciz.addToBlackList(this.data.id.longValue());
        } else {
            this.ciz.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aPE != null) {
            this.aPE.cancel();
        }
        if (this.ciz != null) {
            this.ciz.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e afM() {
        return this.ber;
    }

    public CustomMessageListener afN() {
        return this.mCustomListener;
    }
}
