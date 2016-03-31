package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel cte;
    private PersonalTalkSettingActivity ctf;
    private a ctg;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.d.a ahY = new com.baidu.tbadk.coreExtra.d.a(null);
    private boolean akM = false;
    private boolean ctc = false;
    private boolean ctd = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.e bje = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    /* loaded from: classes.dex */
    public interface a {
        void xo();
    }

    public boolean ajd() {
        return this.ctd;
    }

    public void ex(boolean z) {
        this.ctd = z;
    }

    public DataRes aje() {
        return this.data;
    }

    public boolean ajf() {
        return this.ctc;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, long j) {
        this.ctf = personalTalkSettingActivity;
        this.ctg = aVar;
        this.cte = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tbadk.util.q.b(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void ey(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void ez(boolean z) {
        this.ctf.showLoadingDialog(null);
        if (z) {
            this.cte.addToBlackList(this.data.id.longValue());
        } else {
            this.cte.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.ahY != null) {
            this.ahY.cancel();
        }
        if (this.cte != null) {
            this.cte.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e ajg() {
        return this.bje;
    }

    public CustomMessageListener ajh() {
        return this.mCustomListener;
    }
}
