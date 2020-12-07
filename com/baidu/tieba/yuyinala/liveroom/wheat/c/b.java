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
    private static b oub;
    private TbPageContext oty;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a ouc;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h oud;
    private String oue = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f ouf;

    public static b eeI() {
        if (oub == null) {
            oub = new b();
        }
        return oub;
    }

    private b() {
    }

    public b g(TbPageContext tbPageContext) {
        this.oty = tbPageContext;
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
            this.oue = jSONObject.optString("invite_uk");
            String optString = jSONObject.optString("type");
            str2 = jSONObject.optString("pushUrl");
            str3 = jSONObject.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.WB(optString);
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            o.efd().zQ(true);
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                        if (eeq != null) {
                            eeq.Wx("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    l.eeZ().i(b.this.oty).NQ(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                    if (eeq != null) {
                        eeq.Wx("上麦CallBack回调失败onFail");
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
        if (this.ouf != null && this.ouf.isShowing()) {
            this.ouf.dismiss();
        }
        this.ouf = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.ouf.show();
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
        if (Zd != null && Zd.aKW >= 0) {
            i = Zd.aKW;
        }
        this.ouf.NS(i * 1000);
        this.ouf.WS(str);
        this.ouf.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eeJ() {
                d.eeM().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                    public void zK(boolean z) {
                        AccountData currentAccountInfo;
                        if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                            o.efd().zQ(true);
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("click_accept_invite_anchor_9", false);
                            b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        }
                    }
                });
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eeK() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oue);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void amS() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        if (this.ouc == null) {
            this.ouc = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0944a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
                public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                        l.eeZ().i(b.this.oty).NQ(3);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.efK(), false, true);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0944a
                public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
        }
        this.ouc.aQ(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oue);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oue);
        }
    }

    public void onDestroy() {
        if (this.oud != null) {
            this.oud.onDestroy();
            this.oud = null;
        }
    }
}
