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
    private static b oud;
    private TbPageContext otA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a oue;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h ouf;
    private String oug = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f ouh;

    public static b eeJ() {
        if (oud == null) {
            oud = new b();
        }
        return oud;
    }

    private b() {
    }

    public b g(TbPageContext tbPageContext) {
        this.otA = tbPageContext;
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
            this.oug = jSONObject.optString("invite_uk");
            String optString = jSONObject.optString("type");
            str2 = jSONObject.optString("pushUrl");
            str3 = jSONObject.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.WB(optString);
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            o.efe().zQ(true);
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                        if (eer != null) {
                            eer.Wx("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    l.efa().i(b.this.otA).NQ(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
                    if (eer != null) {
                        eer.Wx("上麦CallBack回调失败onFail");
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
        if (this.ouh != null && this.ouh.isShowing()) {
            this.ouh.dismiss();
        }
        this.ouh = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.ouh.show();
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd();
        if (Zd != null && Zd.aKW >= 0) {
            i = Zd.aKW;
        }
        this.ouh.NS(i * 1000);
        this.ouh.WS(str);
        this.ouh.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eeK() {
                d.eeN().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                    public void zK(boolean z) {
                        AccountData currentAccountInfo;
                        if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                            o.efe().zQ(true);
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("click_accept_invite_anchor_9", false);
                            b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        }
                    }
                });
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eeL() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oug);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void amS() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oug);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        if (this.oue == null) {
            this.oue = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0944a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
                public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                        l.efa().i(b.this.otA).NQ(3);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.efL(), false, true);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
                public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
        }
        this.oue.aQ(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oug);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oug);
        }
    }

    public void onDestroy() {
        if (this.ouf != null) {
            this.ouf.onDestroy();
            this.ouf = null;
        }
    }
}
