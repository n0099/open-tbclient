package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.k;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
/* loaded from: classes11.dex */
public class m {
    private static m oHa;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oGV;
    private a oHb;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oHc;
    private k oHd;

    /* loaded from: classes11.dex */
    public interface a {
        void edC();

        void edD();

        void edE();
    }

    private m() {
    }

    public static m edA() {
        if (oHa == null) {
            oHa = new m();
        }
        return oHa;
    }

    public boolean aA(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (q.edM().iH(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (q.edM().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.oGV != null) {
            return this.oGV.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.oGV = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.oGV.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    m.this.hide();
                    if (m.this.oHb != null) {
                        m.this.oHb.edC();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (m.this.oHb != null) {
                            m.this.oHb.edD();
                        }
                    } else if (z) {
                        m.this.Wy(str2);
                    } else {
                        m.this.edB();
                    }
                }
            });
            this.oGV.show();
            if (!TextUtils.isEmpty(str)) {
                this.oGV.setText(str);
            }
        }
    }

    public void hide() {
        if (this.oGV != null) {
            this.oGV.dismiss();
            this.oGV = null;
        }
    }

    public void a(a aVar) {
        this.oHb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wy(String str) {
        if (this.oHd == null) {
            this.oHd = new k();
        }
        this.oHd.Ww(str);
        this.oHd.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
            public void Wx(String str2) {
                m.this.hide();
                if (m.this.oHb != null) {
                    m.this.oHb.edD();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edB() {
        if (this.oHc == null) {
            this.oHc = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        m.this.hide();
                        if (m.this.oHb != null) {
                            m.this.oHb.edD();
                        }
                        q.edM().Af(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                    if (m.this.oHb != null) {
                        m.this.oHb.edE();
                    }
                }
            });
        }
        this.oHc.ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), "1");
    }
}
