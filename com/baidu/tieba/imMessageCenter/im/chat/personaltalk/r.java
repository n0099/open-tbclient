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
    private final BlackListModel dpv;
    private PersonalTalkSettingActivity dpw;
    private a dpx;
    private com.baidu.tbadk.coreExtra.d.a ahJ = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean akC = false;
    private boolean dpt = false;
    private boolean dpu = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e cjN = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void ws();
    }

    public boolean axy() {
        return this.dpu;
    }

    public void gp(boolean z) {
        this.dpu = z;
    }

    public DataRes axz() {
        return this.data;
    }

    public boolean axA() {
        return this.dpt;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.dpw = personalTalkSettingActivity;
        this.dpx = aVar;
        this.dpv = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.u.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void gq(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gr(boolean z) {
        this.dpw.showLoadingDialog(null);
        if (z) {
            this.dpv.addToBlackList(this.data.id.longValue());
        } else {
            this.dpv.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.ahJ != null) {
            this.ahJ.cancel();
        }
        if (this.dpv != null) {
            this.dpv.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e axB() {
        return this.cjN;
    }

    public CustomMessageListener axC() {
        return this.mCustomListener;
    }
}
