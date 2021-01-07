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
/* loaded from: classes11.dex */
public class k {
    private static k oBD;
    private a oBE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oBF;
    private i oBG;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oBx;

    /* loaded from: classes11.dex */
    public interface a {
        void eeZ();

        void efa();

        void efb();
    }

    private k() {
    }

    public static k eeX() {
        if (oBD == null) {
            oBD = new k();
        }
        return oBD;
    }

    public boolean aH(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (o.efg().jm(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (o.efg().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.oBx != null) {
            return this.oBx.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.oBx = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.oBx.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    k.this.hide();
                    if (k.this.oBE != null) {
                        k.this.oBE.eeZ();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (k.this.oBE != null) {
                            k.this.oBE.efa();
                        }
                    } else if (z) {
                        k.this.Ww(str2);
                    } else {
                        k.this.eeY();
                    }
                }
            });
            this.oBx.show();
            if (!TextUtils.isEmpty(str)) {
                this.oBx.setText(str);
            }
        }
    }

    public void hide() {
        if (this.oBx != null) {
            this.oBx.dismiss();
            this.oBx = null;
        }
    }

    public void a(a aVar) {
        this.oBE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ww(String str) {
        if (this.oBG == null) {
            this.oBG = new i();
        }
        this.oBG.Wu(str);
        this.oBG.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void Wv(String str2) {
                k.this.hide();
                if (k.this.oBE != null) {
                    k.this.oBE.efa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeY() {
        if (this.oBF == null) {
            this.oBF = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        k.this.hide();
                        if (k.this.oBE != null) {
                            k.this.oBE.efa();
                        }
                        o.efg().zQ(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                    if (k.this.oBE != null) {
                        k.this.oBE.efb();
                    }
                }
            });
        }
        this.oBF.gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), "1");
    }
}
