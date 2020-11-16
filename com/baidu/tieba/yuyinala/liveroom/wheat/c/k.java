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
    private static k ofQ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g ofL;
    private a ofR;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d ofS;
    private i ofT;

    /* loaded from: classes4.dex */
    public interface a {
        void dZs();

        void dZt();

        void dZu();
    }

    private k() {
    }

    public static k dZq() {
        if (ofQ == null) {
            ofQ = new k();
        }
        return ofQ;
    }

    public boolean aC(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (o.dZz().iP(encryptionUserId)) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (o.dZz().isApplying()) {
                a(activity, activity.getString(a.h.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.ofL != null) {
            return this.ofL.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.ofL = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.ofL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    k.this.hide();
                    if (k.this.ofR != null) {
                        k.this.ofR.dZs();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (k.this.ofR != null) {
                            k.this.ofR.dZt();
                        }
                    } else if (z) {
                        k.this.Vy(str2);
                    } else {
                        k.this.dZr();
                    }
                }
            });
            this.ofL.show();
            if (!TextUtils.isEmpty(str)) {
                this.ofL.setText(str);
            }
        }
    }

    public void hide() {
        if (this.ofL != null) {
            this.ofL.dismiss();
            this.ofL = null;
        }
    }

    public void a(a aVar) {
        this.ofR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vy(String str) {
        if (this.ofT == null) {
            this.ofT = new i();
        }
        this.ofT.Vw(str);
        this.ofT.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void Vx(String str2) {
                k.this.hide();
                if (k.this.ofR != null) {
                    k.this.ofR.dZt();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZr() {
        if (this.ofS == null) {
            this.ofS = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.k.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        k.this.hide();
                        if (k.this.ofR != null) {
                            k.this.ofR.dZt();
                        }
                        o.dZz().zk(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                    if (k.this.ofR != null) {
                        k.this.ofR.dZu();
                    }
                }
            });
        }
        this.ofS.gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), "1");
    }
}
