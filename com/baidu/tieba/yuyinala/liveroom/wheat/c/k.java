package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.d;
/* loaded from: classes4.dex */
public class k {
    private static k ouQ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g ouL;
    private a ouR;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d ouS;
    private i ouT;

    /* loaded from: classes4.dex */
    public interface a {
        void eeW();

        void eeX();

        void eeY();
    }

    private k() {
    }

    public static k eeU() {
        if (ouQ == null) {
            ouQ = new k();
        }
        return ouQ;
    }

    public boolean aD(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (o.efd().jt(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (o.efd().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.ouL != null) {
            return this.ouL.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.ouL = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.ouL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    k.this.hide();
                    if (k.this.ouR != null) {
                        k.this.ouR.eeW();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (k.this.ouR != null) {
                            k.this.ouR.eeX();
                        }
                    } else if (z) {
                        k.this.WN(str2);
                    } else {
                        k.this.eeV();
                    }
                }
            });
            this.ouL.show();
            if (!TextUtils.isEmpty(str)) {
                this.ouL.setText(str);
            }
        }
    }

    public void hide() {
        if (this.ouL != null) {
            this.ouL.dismiss();
            this.ouL = null;
        }
    }

    public void a(a aVar) {
        this.ouR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN(String str) {
        if (this.ouT == null) {
            this.ouT = new i();
        }
        this.ouT.WL(str);
        this.ouT.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void WM(String str2) {
                k.this.hide();
                if (k.this.ouR != null) {
                    k.this.ouR.eeX();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeV() {
        if (this.ouS == null) {
            this.ouS = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        k.this.hide();
                        if (k.this.ouR != null) {
                            k.this.ouR.eeX();
                        }
                        o.efd().zO(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                    if (k.this.ouR != null) {
                        k.this.ouR.eeY();
                    }
                }
            });
        }
        this.ouS.gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), "1");
    }
}
