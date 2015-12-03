package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.more.MsgRemindActivity;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private MsgRemindActivity dlL;
    private a dlM;
    private com.baidu.adp.framework.listener.e dlN;
    private com.baidu.adp.framework.listener.e dlO;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.dlN = new h(this, 104102);
        this.dlO = new i(this, 104101);
        this.dlL = msgRemindActivity;
        registerListener(this.dlO);
        registerListener(this.dlN);
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
        if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 6) {
            this.dlM = aVar;
            if (i == 4) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                requestUpdateMaskMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskMessage);
            } else {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage.setMaskType(i);
                requestUpdateMaskInfoMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskInfoMessage);
            }
            this.dlL.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.dlL.showToast(this.dlL.getResources().getString(n.i.success));
            if (this.dlM != null) {
                this.dlM.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yl() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().ym() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yn() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yw() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yv() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yk()) {
                        this.dlM.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.dlM.a(2, true, z2);
                this.dlM.a(3, true, z2);
                this.dlM.a(4, true, z2);
                this.dlM.a(5, true, z2);
                this.dlM.a(1, true, z2);
                this.dlM.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.dlL.showToast(str);
        } else {
            this.dlL.showToast(n.i.bubble_setdefualt_error);
        }
        if (this.dlM != null) {
            this.dlM.a(i, false, z2);
        }
    }
}
