package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.more.MsgRemindActivity;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private com.baidu.adp.framework.listener.e cEA;
    private com.baidu.adp.framework.listener.e cEB;
    private MsgRemindActivity cEy;
    private a cEz;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cEA = new h(this, 104102);
        this.cEB = new i(this, 104101);
        this.cEy = msgRemindActivity;
        registerListener(this.cEB);
        registerListener(this.cEA);
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
            this.cEz = aVar;
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
            this.cEy.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cEy.showToast(this.cEy.getResources().getString(i.h.success));
            if (this.cEz != null) {
                this.cEz.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xB() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xC() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xD() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xM() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xL() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xA()) {
                        this.cEz.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cEz.a(2, true, z2);
                this.cEz.a(3, true, z2);
                this.cEz.a(4, true, z2);
                this.cEz.a(5, true, z2);
                this.cEz.a(1, true, z2);
                this.cEz.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cEy.showToast(str);
        } else {
            this.cEy.showToast(i.h.bubble_setdefualt_error);
        }
        if (this.cEz != null) {
            this.cEz.a(i, false, z2);
        }
    }
}
