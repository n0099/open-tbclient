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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
/* loaded from: classes10.dex */
public class k {
    private static k owY;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g owS;
    private a owZ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oxa;
    private i oxb;

    /* loaded from: classes10.dex */
    public interface a {
        void ebh();

        void ebi();

        void ebj();
    }

    private k() {
    }

    public static k ebf() {
        if (owY == null) {
            owY = new k();
        }
        return owY;
    }

    public boolean aH(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (o.ebo().ib(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (o.ebo().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.owS != null) {
            return this.owS.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.owS = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.owS.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    k.this.hide();
                    if (k.this.owZ != null) {
                        k.this.owZ.ebh();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (k.this.owZ != null) {
                            k.this.owZ.ebi();
                        }
                    } else if (z) {
                        k.this.Vo(str2);
                    } else {
                        k.this.ebg();
                    }
                }
            });
            this.owS.show();
            if (!TextUtils.isEmpty(str)) {
                this.owS.setText(str);
            }
        }
    }

    public void hide() {
        if (this.owS != null) {
            this.owS.dismiss();
            this.owS = null;
        }
    }

    public void a(a aVar) {
        this.owZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo(String str) {
        if (this.oxb == null) {
            this.oxb = new i();
        }
        this.oxb.Vm(str);
        this.oxb.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void Vn(String str2) {
                k.this.hide();
                if (k.this.owZ != null) {
                    k.this.owZ.ebi();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebg() {
        if (this.oxa == null) {
            this.oxa = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        k.this.hide();
                        if (k.this.owZ != null) {
                            k.this.owZ.ebi();
                        }
                        o.ebo().zM(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                    if (k.this.owZ != null) {
                        k.this.owZ.ebj();
                    }
                }
            });
        }
        this.oxa.gR(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), "1");
    }
}
