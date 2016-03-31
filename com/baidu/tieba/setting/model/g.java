package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.setting.more.MsgRemindActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private com.baidu.adp.framework.listener.e csA;
    private MsgRemindActivity ebq;
    private a ebr;
    private com.baidu.adp.framework.listener.e ebs;
    private com.baidu.adp.framework.listener.e ebt;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.ebs = new h(this, 104102);
        this.ebt = new i(this, 104101);
        this.csA = new j(this, 104106);
        this.ebq = msgRemindActivity;
        registerListener(this.ebt);
        registerListener(this.ebs);
        registerListener(this.csA);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(int i, boolean z, a aVar) {
        if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 6 || i == 7) {
            this.ebr = aVar;
            if (i == 4) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                requestUpdateMaskMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskMessage);
            } else if (i == 7) {
                RequestUpdateForumMask requestUpdateForumMask = new RequestUpdateForumMask();
                requestUpdateForumMask.setType(1);
                requestUpdateForumMask.setFlag(z);
                sendMessage(requestUpdateForumMask);
            } else {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage.setMaskType(i);
                requestUpdateMaskInfoMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskInfoMessage);
            }
            this.ebq.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.ebq.showToast(this.ebq.getResources().getString(t.j.success));
            if (this.ebr != null) {
                this.ebr.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zR() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zS() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zT() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ac() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ab() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zQ()) {
                        this.ebr.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.ebr.a(2, true, z2);
                this.ebr.a(3, true, z2);
                this.ebr.a(4, true, z2);
                this.ebr.a(5, true, z2);
                this.ebr.a(1, true, z2);
                this.ebr.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.ebq.showToast(str);
        } else {
            this.ebq.showToast(t.j.bubble_setdefualt_error);
        }
        if (this.ebr != null) {
            this.ebr.a(i, false, z2);
        }
    }
}
