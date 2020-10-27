package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
/* loaded from: classes4.dex */
public class j {
    private static j nWN;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g nWI;
    private a nWO;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.d nWP;
    private h nWQ;

    /* loaded from: classes4.dex */
    public interface a {
        void dWu();

        void dWv();

        void dWw();
    }

    private j() {
    }

    public static j dWs() {
        if (nWN == null) {
            nWN = new j();
        }
        return nWN;
    }

    public boolean aB(Activity activity) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && !TextUtils.isEmpty(currentAccountInfo.getID())) {
            String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
            if (n.dWB().iI(encryptionUserId)) {
                a(activity, activity.getString(a.i.yuyin_ala_connection_wheat_close_room_remind_1_text), true, encryptionUserId);
                return false;
            } else if (n.dWB().UI()) {
                a(activity, activity.getString(a.i.yuyin_ala_connection_wheat_close_room_remind_2_text), false, encryptionUserId);
                return false;
            }
        }
        return true;
    }

    public boolean isShowing() {
        if (this.nWI != null) {
            return this.nWI.isShowing();
        }
        return false;
    }

    private void a(Activity activity, String str, final boolean z, final String str2) {
        if (activity != null) {
            hide();
            this.nWI = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
            this.nWI.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.j.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    j.this.hide();
                    if (j.this.nWO != null) {
                        j.this.nWO.dWu();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        if (j.this.nWO != null) {
                            j.this.nWO.dWv();
                        }
                    } else if (z) {
                        j.this.Vq(str2);
                    } else {
                        j.this.dWt();
                    }
                }
            });
            this.nWI.show();
            if (!TextUtils.isEmpty(str)) {
                this.nWI.setText(str);
            }
        }
    }

    public void hide() {
        if (this.nWI != null) {
            this.nWI.dismiss();
            this.nWI = null;
        }
    }

    public void a(a aVar) {
        this.nWO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq(String str) {
        if (this.nWQ == null) {
            this.nWQ = new h();
        }
        this.nWQ.Vo(str);
        this.nWQ.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.j.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.h.a
            public void Vp(String str2) {
                j.this.hide();
                if (j.this.nWO != null) {
                    j.this.nWO.dWv();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWt() {
        if (this.nWP == null) {
            this.nWP = new com.baidu.tieba.yuyinala.liveroom.wheat.c.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.j.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        j.this.hide();
                        if (j.this.nWO != null) {
                            j.this.nWO.dWv();
                        }
                        n.dWB().yW(false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                public void onFail(int i, String str) {
                    if (j.this.nWO != null) {
                        j.this.nWO.dWw();
                    }
                }
            });
        }
        this.nWP.gN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), "1");
    }
}
