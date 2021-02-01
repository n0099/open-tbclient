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
    private String oFA = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f oFB;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a oFC;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.j oFD;

    public void a(Activity activity, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
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
            this.oFA = jSONObject2.optString("invite_uk");
            String optString = jSONObject2.optString("type");
            str2 = jSONObject2.optString("pushUrl");
            str3 = jSONObject2.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.VZ(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            z = false;
        }
        if (z) {
            if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecQ()) {
                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_relogin_join_chat)).show();
                return;
            }
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
            q.edE().Ah(true);
            this.oFD = new com.baidu.tieba.yuyinala.liveroom.wheat.model.j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                        if (ecL != null) {
                            ecL.VW("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    n.edx().Mv(5);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
                    if (ecL != null) {
                        ecL.VW("上麦CallBack回调失败onFail");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                }
            });
            this.oFD.request("online");
            return;
        }
        a(activity, str, bIMInviteSyncRtcInfo);
    }

    private void a(final Activity activity, String str, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        int i = 6;
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put("uid", q.edE().Yp());
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_receive_invite").setContentExt(jSONObject));
        this.oFB = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.oFB.show();
        ab Yq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
        if (Yq2 != null && Yq2.aJe >= 0) {
            i = Yq2.aJe;
        }
        this.oFB.My(i * 1000);
        this.oFB.Wt(str);
        this.oFB.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void ede() {
                if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecQ()) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_relogin_join_chat)).show();
                } else {
                    d.edh().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                        public void Ab(boolean z) {
                            if (z) {
                                UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                                UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
                                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                                if (currentAccountInfo != null) {
                                    q.edE().Ah(true);
                                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_accept_invite_anchor_9", false);
                                    b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void edf() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oFA);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void akH() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oFA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        this.oFC = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0945a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0945a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    n.edx().Mv(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.eer(), false, true);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0945a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
            }
        });
        this.oFC.aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ym(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oFA);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oFA);
        }
    }

    public void onDestroy() {
        if (this.oFD != null) {
            this.oFD.onDestroy();
            this.oFD = null;
        }
        if (this.oFC != null) {
            this.oFC.onDestroy();
            this.oFC = null;
        }
        if (this.oFB != null && this.oFB.isShowing()) {
            this.oFB.dismiss();
            this.oFB = null;
        }
    }
}
