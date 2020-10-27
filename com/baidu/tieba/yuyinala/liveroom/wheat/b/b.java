package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.app.Activity;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaLinkCallBackHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static b nVX;
    private TbPageContext nVE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.a nVY;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.h nVZ;
    private String nWa = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f nWb;

    public static b dWg() {
        if (nVX == null) {
            nVX = new b();
        }
        return nVX;
    }

    private b() {
    }

    public b g(TbPageContext tbPageContext) {
        this.nVE = tbPageContext;
        return this;
    }

    public void a(Activity activity, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        boolean z;
        String str = "";
        final String str2 = "";
        final String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(bIMInviteSyncRtcInfo.getRtcExt());
            str = jSONObject.optString("invite_name");
            this.nWa = jSONObject.optString("invite_uk");
            String optString = jSONObject.optString("type");
            str2 = jSONObject.optString("pushUrl");
            str3 = jSONObject.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.Vk(optString);
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            n.dWB().yY(true);
            new com.baidu.tieba.yuyinala.liveroom.wheat.c.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (!alaLinkCallBackHttpResponseMessage.isError()) {
                        k.dWx().i(b.this.nVE).Me(4);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.h.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            }).request("online");
            return;
        }
        a(activity, str, bIMInviteSyncRtcInfo);
    }

    private void a(final Activity activity, String str, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        int i = 6;
        if (this.nWb != null && this.nWb.isShowing()) {
            this.nWb.dismiss();
        }
        this.nWb = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.nWb.show();
        w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
        if (UO != null && UO.aJc >= 0) {
            i = UO.aJc;
        }
        this.nWb.Mg(i * 1000);
        this.nWb.Vw(str);
        this.nWb.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void dWh() {
                d.dWl().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.b.2.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a
                    public void yR(boolean z) {
                        AccountData currentAccountInfo;
                        if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                            n.dWB().yY(true);
                            com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("click_accept_invite_anchor_9", false);
                            b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        }
                    }
                });
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void dWi() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.nWa);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void ahS() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.nWa);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        if (this.nVY == null) {
            this.nVY = new com.baidu.tieba.yuyinala.liveroom.wheat.c.a(null, new a.InterfaceC0908a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0908a
                public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                        k.dWx().i(b.this.nVE).Me(3);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.dWW(), false, true);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0908a
                public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
        }
        this.nVY.aL(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.nWa);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.nWa);
        }
    }

    public void onDestroy() {
        if (this.nVZ != null) {
            this.nVZ.onDestroy();
            this.nVZ = null;
        }
    }
}
