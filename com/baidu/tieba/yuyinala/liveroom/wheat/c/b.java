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
    private static b ofb;
    private TbPageContext oey;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a ofc;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.h ofd;
    private String ofe = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f ofg;

    public static b dZe() {
        if (ofb == null) {
            ofb = new b();
        }
        return ofb;
    }

    private b() {
    }

    public b g(TbPageContext tbPageContext) {
        this.oey = tbPageContext;
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
            this.ofe = jSONObject.optString("invite_uk");
            String optString = jSONObject.optString("type");
            str2 = jSONObject.optString("pushUrl");
            str3 = jSONObject.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.Vm(optString);
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            o.dZz().zm(true);
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                        if (dYM != null) {
                            dYM.Vi("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    l.dZv().i(b.this.oey).MY(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
                    if (dYM != null) {
                        dYM.Vi("上麦CallBack回调失败onFail");
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
        if (this.ofg != null && this.ofg.isShowing()) {
            this.ofg.dismiss();
        }
        this.ofg = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.ofg.show();
        w WE = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WE();
        if (WE != null && WE.aIk >= 0) {
            i = WE.aIk;
        }
        this.ofg.Na(i * 1000);
        this.ofg.VD(str);
        this.ofg.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void dZf() {
                d.dZi().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                    public void zg(boolean z) {
                        AccountData currentAccountInfo;
                        if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                            o.dZz().zm(true);
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_accept_invite_anchor_9", false);
                            b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        }
                    }
                });
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void dZg() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.ofe);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void ajK() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.ofe);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        if (this.ofc == null) {
            this.ofc = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0927a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0927a
                public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                        l.dZv().i(b.this.oey).MY(3);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eaf(), false, true);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0927a
                public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
        }
        this.ofc.aN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.ofe);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.ofe);
        }
    }

    public void onDestroy() {
        if (this.ofd != null) {
            this.ofd.onDestroy();
            this.ofd = null;
        }
    }
}
