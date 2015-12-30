package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.more.MsgRemindActivity;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private MsgRemindActivity dsS;
    private a dsT;
    private com.baidu.adp.framework.listener.e dsU;
    private com.baidu.adp.framework.listener.e dsV;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.dsU = new h(this, 104102);
        this.dsV = new i(this, 104101);
        this.dsS = msgRemindActivity;
        registerListener(this.dsV);
        registerListener(this.dsU);
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
            this.dsT = aVar;
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
            this.dsS.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.dsS.showToast(this.dsS.getResources().getString(n.j.success));
            if (this.dsT != null) {
                this.dsT.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().xY() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().xZ() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().yi() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().yh() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().xW()) {
                        this.dsT.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.dsT.a(2, true, z2);
                this.dsT.a(3, true, z2);
                this.dsT.a(4, true, z2);
                this.dsT.a(5, true, z2);
                this.dsT.a(1, true, z2);
                this.dsT.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.dsS.showToast(str);
        } else {
            this.dsS.showToast(n.j.bubble_setdefualt_error);
        }
        if (this.dsT != null) {
            this.dsT.a(i, false, z2);
        }
    }
}
