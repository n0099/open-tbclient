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
/* loaded from: classes10.dex */
public class m {
    private static m oJf;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oJa;
    private a oJg;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oJh;
    private k oJi;

    /* loaded from: classes10.dex */
    public interface a {
        void edK();

        void edL();

        void edM();
    }

    private m() {
    }

    public static m edI() {
        if (oJf == null) {
            oJf = new m();
        }
        return oJf;
    }

    public boolean aB(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (q.edU().iN(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (q.edU().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.oJa != null) {
            return this.oJa.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.oJa = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.oJa.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    m.this.hide();
                    if (m.this.oJg != null) {
                        m.this.oJg.edK();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (m.this.oJg != null) {
                            m.this.oJg.edL();
                        }
                    } else if (z) {
                        m.this.WF(str2);
                    } else {
                        m.this.edJ();
                    }
                }
            });
            this.oJa.show();
            if (!TextUtils.isEmpty(str)) {
                this.oJa.setText(str);
            }
        }
    }

    public void hide() {
        if (this.oJa != null) {
            this.oJa.dismiss();
            this.oJa = null;
        }
    }

    public void a(a aVar) {
        this.oJg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WF(String str) {
        if (this.oJi == null) {
            this.oJi = new k();
        }
        this.oJi.WD(str);
        this.oJi.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
            public void WE(String str2) {
                m.this.hide();
                if (m.this.oJg != null) {
                    m.this.oJg.edL();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edJ() {
        if (this.oJh == null) {
            this.oJh = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        m.this.hide();
                        if (m.this.oJg != null) {
                            m.this.oJg.edL();
                        }
                        q.edU().Ae(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                    if (m.this.oJg != null) {
                        m.this.oJg.edM();
                    }
                }
            });
        }
        this.oJh.ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), "1");
    }
}
