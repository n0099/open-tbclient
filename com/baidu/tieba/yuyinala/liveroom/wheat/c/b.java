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
/* loaded from: classes11.dex */
public class b {
    private String oGa = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f oGb;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a oGc;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.j oGd;

    public void a(Activity activity, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
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
            this.oGa = jSONObject2.optString("invite_uk");
            String optString = jSONObject2.optString("type");
            str2 = jSONObject2.optString("pushUrl");
            str3 = jSONObject2.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.Wl(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            z = false;
        }
        if (z) {
            if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecY()) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_relogin_join_chat)).show();
                return;
            }
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
            q.edM().Ah(true);
            this.oGd = new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                        if (ecT != null) {
                            ecT.Wi("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    n.edF().Mw(5);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
                    if (ecT != null) {
                        ecT.Wi("上麦CallBack回调失败onFail");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
            this.oGd.request("online");
            return;
        }
        a(activity, str, bIMInviteSyncRtcInfo);
    }

    private void a(final Activity activity, String str, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        int i = 6;
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put("uid", q.edM().Yp());
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_receive_invite").setContentExt(jSONObject));
        this.oGb = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.oGb.show();
        ab Yq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
        if (Yq2 != null && Yq2.aJe >= 0) {
            i = Yq2.aJe;
        }
        this.oGb.Mz(i * 1000);
        this.oGb.WF(str);
        this.oGb.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void edm() {
                if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecY()) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_relogin_join_chat)).show();
                } else {
                    d.edp().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                        public void Ab(boolean z) {
                            if (z) {
                                UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                                UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
                                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                                if (currentAccountInfo != null) {
                                    q.edM().Ah(true);
                                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_accept_invite_anchor_9", false);
                                    b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void edn() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oGa);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void akH() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oGa);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        this.oGc = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0947a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0947a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    n.edF().Mw(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eez(), false, true);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0947a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
            }
        });
        this.oGc.aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oGa);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oGa);
        }
    }

    public void onDestroy() {
        if (this.oGd != null) {
            this.oGd.onDestroy();
            this.oGd = null;
        }
        if (this.oGc != null) {
            this.oGc.onDestroy();
            this.oGc = null;
        }
        if (this.oGb != null && this.oGb.isShowing()) {
            this.oGb.dismiss();
            this.oGb = null;
        }
    }
}
