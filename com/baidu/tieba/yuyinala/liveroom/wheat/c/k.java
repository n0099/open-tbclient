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
    private static k oem;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oeh;
    private a oen;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d oeo;
    private i oep;

    /* loaded from: classes4.dex */
    public interface a {
        void dZt();

        void dZu();

        void dZv();
    }

    private k() {
    }

    public static k dZr() {
        if (oem == null) {
            oem = new k();
        }
        return oem;
    }

    public boolean aD(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (o.dZA().iV(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (o.dZA().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.oeh != null) {
            return this.oeh.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.oeh = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.oeh.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    k.this.hide();
                    if (k.this.oen != null) {
                        k.this.oen.dZt();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (k.this.oen != null) {
                            k.this.oen.dZu();
                        }
                    } else if (z) {
                        k.this.VN(str2);
                    } else {
                        k.this.dZs();
                    }
                }
            });
            this.oeh.show();
            if (!TextUtils.isEmpty(str)) {
                this.oeh.setText(str);
            }
        }
    }

    public void hide() {
        if (this.oeh != null) {
            this.oeh.dismiss();
            this.oeh = null;
        }
    }

    public void a(a aVar) {
        this.oen = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VN(String str) {
        if (this.oep == null) {
            this.oep = new i();
        }
        this.oep.VL(str);
        this.oep.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void VM(String str2) {
                k.this.hide();
                if (k.this.oen != null) {
                    k.this.oen.dZu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZs() {
        if (this.oeo == null) {
            this.oeo = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        k.this.hide();
                        if (k.this.oen != null) {
                            k.this.oen.dZu();
                        }
                        o.dZA().zd(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                    if (k.this.oen != null) {
                        k.this.oen.dZv();
                    }
                }
            });
        }
        this.oeo.gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), "1");
    }
}
