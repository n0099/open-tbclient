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
    private static m oGA;
    private a oGB;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oGC;
    private k oGD;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g oGv;

    /* loaded from: classes11.dex */
    public interface a {
        void edu();

        void edv();

        void edw();
    }

    private m() {
    }

    public static m eds() {
        if (oGA == null) {
            oGA = new m();
        }
        return oGA;
    }

    public boolean aA(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (q.edE().iH(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (q.edE().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.oGv != null) {
            return this.oGv.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.oGv = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.oGv.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    m.this.hide();
                    if (m.this.oGB != null) {
                        m.this.oGB.edu();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (m.this.oGB != null) {
                            m.this.oGB.edv();
                        }
                    } else if (z) {
                        m.this.Wm(str2);
                    } else {
                        m.this.edt();
                    }
                }
            });
            this.oGv.show();
            if (!TextUtils.isEmpty(str)) {
                this.oGv.setText(str);
            }
        }
    }

    public void hide() {
        if (this.oGv != null) {
            this.oGv.dismiss();
            this.oGv = null;
        }
    }

    public void a(a aVar) {
        this.oGB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wm(String str) {
        if (this.oGD == null) {
            this.oGD = new k();
        }
        this.oGD.Wk(str);
        this.oGD.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
            public void Wl(String str2) {
                m.this.hide();
                if (m.this.oGB != null) {
                    m.this.oGB.edv();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edt() {
        if (this.oGC == null) {
            this.oGC = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(null, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.m.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        m.this.hide();
                        if (m.this.oGB != null) {
                            m.this.oGB.edv();
                        }
                        q.edE().Af(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                    if (m.this.oGB != null) {
                        m.this.oGB.edw();
                    }
                }
            });
        }
        this.oGC.gY(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), "1");
    }
}
