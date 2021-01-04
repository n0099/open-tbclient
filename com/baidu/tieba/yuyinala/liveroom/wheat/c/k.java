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
    private static k oBE;
    private a oBF;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oBG;
    private i oBH;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oBy;

    /* loaded from: classes11.dex */
    public interface a {
        void eeY();

        void eeZ();

        void efa();
    }

    private k() {
    }

    public static k eeW() {
        if (oBE == null) {
            oBE = new k();
        }
        return oBE;
    }

    public boolean aH(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (o.eff().jm(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (o.eff().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.oBy != null) {
            return this.oBy.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.oBy = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.oBy.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    k.this.hide();
                    if (k.this.oBF != null) {
                        k.this.oBF.eeY();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (k.this.oBF != null) {
                            k.this.oBF.eeZ();
                        }
                    } else if (z) {
                        k.this.Wx(str2);
                    } else {
                        k.this.eeX();
                    }
                }
            });
            this.oBy.show();
            if (!TextUtils.isEmpty(str)) {
                this.oBy.setText(str);
            }
        }
    }

    public void hide() {
        if (this.oBy != null) {
            this.oBy.dismiss();
            this.oBy = null;
        }
    }

    public void a(a aVar) {
        this.oBF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wx(String str) {
        if (this.oBH == null) {
            this.oBH = new i();
        }
        this.oBH.Wv(str);
        this.oBH.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void Ww(String str2) {
                k.this.hide();
                if (k.this.oBF != null) {
                    k.this.oBF.eeZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeX() {
        if (this.oBG == null) {
            this.oBG = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        k.this.hide();
                        if (k.this.oBF != null) {
                            k.this.oBF.eeZ();
                        }
                        o.eff().zQ(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                    if (k.this.oBF != null) {
                        k.this.oBF.efa();
                    }
                }
            });
        }
        this.oBG.gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), "1");
    }
}
