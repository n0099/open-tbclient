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
    private static k ouS;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g ouN;
    private a ouT;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d ouU;
    private i ouV;

    /* loaded from: classes4.dex */
    public interface a {
        void eeX();

        void eeY();

        void eeZ();
    }

    private k() {
    }

    public static k eeV() {
        if (ouS == null) {
            ouS = new k();
        }
        return ouS;
    }

    public boolean aD(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (o.efe().jt(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (o.efe().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.ouN != null) {
            return this.ouN.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.ouN = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.ouN.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    k.this.hide();
                    if (k.this.ouT != null) {
                        k.this.ouT.eeX();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (k.this.ouT != null) {
                            k.this.ouT.eeY();
                        }
                    } else if (z) {
                        k.this.WN(str2);
                    } else {
                        k.this.eeW();
                    }
                }
            });
            this.ouN.show();
            if (!TextUtils.isEmpty(str)) {
                this.ouN.setText(str);
            }
        }
    }

    public void hide() {
        if (this.ouN != null) {
            this.ouN.dismiss();
            this.ouN = null;
        }
    }

    public void a(a aVar) {
        this.ouT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN(String str) {
        if (this.ouV == null) {
            this.ouV = new i();
        }
        this.ouV.WL(str);
        this.ouV.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void WM(String str2) {
                k.this.hide();
                if (k.this.ouT != null) {
                    k.this.ouT.eeY();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeW() {
        if (this.ouU == null) {
            this.ouU = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        k.this.hide();
                        if (k.this.ouT != null) {
                            k.this.ouT.eeY();
                        }
                        o.efe().zO(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                    if (k.this.ouT != null) {
                        k.this.ouT.eeZ();
                    }
                }
            });
        }
        this.ouU.gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), "1");
    }
}
