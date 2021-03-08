package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaLinkCallBackHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private String oIf = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f oIg;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a oIh;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.j oIi;

    public void a(Activity activity, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
            }
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_EVENT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_IMRTC, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "receive_im_rtc_invite").setContentExt(jSONObject));
        String str = "";
        final String str2 = "";
        final String str3 = "";
        try {
            JSONObject jSONObject2 = new JSONObject(bIMInviteSyncRtcInfo.getRtcExt());
            str = jSONObject2.optString("invite_name");
            this.oIf = jSONObject2.optString("invite_uk");
            String optString = jSONObject2.optString("type");
            str2 = jSONObject2.optString("pushUrl");
            str3 = jSONObject2.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.Ws(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            z = false;
        }
        if (z) {
            if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edg()) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_relogin_join_chat)).show();
                return;
            }
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
            q.edU().Ag(true);
            this.oIi = new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                        if (edb != null) {
                            edb.Wp("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    n.edN().MA(5);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
                    if (edb != null) {
                        edb.Wp("上麦CallBack回调失败onFail");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
            this.oIi.request("online");
            return;
        }
        a(activity, str, bIMInviteSyncRtcInfo);
    }

    private void a(final Activity activity, String str, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        int i = 6;
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
            }
            jSONObject.put("uid", q.edU().Ys());
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_receive_invite").setContentExt(jSONObject));
        this.oIg = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.oIg.show();
        ab Yt2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
        if (Yt2 != null && Yt2.aKE >= 0) {
            i = Yt2.aKE;
        }
        this.oIg.MD(i * 1000);
        this.oIg.WM(str);
        this.oIg.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void edu() {
                if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edg()) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_relogin_join_chat)).show();
                } else {
                    d.edx().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                        public void Aa(boolean z) {
                            if (z) {
                                UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                                UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
                                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                                if (currentAccountInfo != null) {
                                    q.edU().Ag(true);
                                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_accept_invite_anchor_9", false);
                                    b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void edv() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oIf);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void akK() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oIf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        this.oIh = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0953a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0953a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    n.edN().MA(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eeH(), false, true);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0953a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
            }
        });
        this.oIh.aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oIf);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oIf);
        }
    }

    public void onDestroy() {
        if (this.oIi != null) {
            this.oIi.onDestroy();
            this.oIi = null;
        }
        if (this.oIh != null) {
            this.oIh.onDestroy();
            this.oIh = null;
        }
        if (this.oIg != null && this.oIg.isShowing()) {
            this.oIg.dismiss();
            this.oIg = null;
        }
    }
}
