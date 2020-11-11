package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaLinkCallBackHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static b ody;
    private TbPageContext ocV;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h odA;
    private String odB = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f odC;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a odz;

    public static b dZf() {
        if (ody == null) {
            ody = new b();
        }
        return ody;
    }

    private b() {
    }

    public b g(TbPageContext tbPageContext) {
        this.ocV = tbPageContext;
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
            this.odB = jSONObject.optString("invite_uk");
            String optString = jSONObject.optString("type");
            str2 = jSONObject.optString("pushUrl");
            str3 = jSONObject.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.VB(optString);
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            o.dZA().zf(true);
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                        if (dYN != null) {
                            dYN.Vx("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    l.dZw().i(b.this.ocV).Mv(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
                    if (dYN != null) {
                        dYN.Vx("上麦CallBack回调失败onFail");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            }).request("online");
            return;
        }
        a(activity, str, bIMInviteSyncRtcInfo);
    }

    private void a(final Activity activity, String str, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        int i = 6;
        if (this.odC != null && this.odC.isShowing()) {
            this.odC.dismiss();
        }
        this.odC = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.odC.show();
        w Xn = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn();
        if (Xn != null && Xn.aJV >= 0) {
            i = Xn.aJV;
        }
        this.odC.Mx(i * 1000);
        this.odC.VS(str);
        this.odC.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void dZg() {
                d.dZj().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                    public void yZ(boolean z) {
                        AccountData currentAccountInfo;
                        if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                            o.dZA().zf(true);
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_accept_invite_anchor_9", false);
                            b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        }
                    }
                });
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void dZh() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.odB);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void aks() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.odB);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        if (this.odz == null) {
            this.odz = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0924a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0924a
                public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                        l.dZw().i(b.this.ocV).Mv(3);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eag(), false, true);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0924a
                public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
        }
        this.odz.aN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.odB);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.odB);
        }
    }

    public void onDestroy() {
        if (this.odA != null) {
            this.odA.onDestroy();
            this.odA = null;
        }
    }
}
