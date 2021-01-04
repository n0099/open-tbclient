package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static b oAP;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a oAQ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.i oAR;
    private String oAS = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f oAT;
    private TbPageContext oAf;

    public static b eeJ() {
        if (oAP == null) {
            oAP = new b();
        }
        return oAP;
    }

    private b() {
    }

    public b g(TbPageContext tbPageContext) {
        this.oAf = tbPageContext;
        return this;
    }

    public void a(Activity activity, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
            if (aas != null && aas.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
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
            this.oAS = jSONObject2.optString("invite_uk");
            String optString = jSONObject2.optString("type");
            str2 = jSONObject2.optString("pushUrl");
            str3 = jSONObject2.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.Wk(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            z = false;
        }
        if (z) {
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
            o.eff().zS(true);
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                        if (eeq != null) {
                            eeq.Wh("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    l.efb().i(b.this.oAf).NG(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        x aas2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                        if (aas2 != null && aas2.aLl != null) {
                            jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas2.aLl.live_id);
                        }
                        jSONObject3.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                        jSONObject3.put("error_code", alaLinkCallBackHttpResponseMessage.getErrno());
                        jSONObject3.put("error_msg", "上麦CallBack回调失败onFail：" + alaLinkCallBackHttpResponseMessage.getErrmsg() + "|" + alaLinkCallBackHttpResponseMessage.getErrorString());
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_fail").setContentExt(jSONObject3));
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
                    if (eeq != null) {
                        eeq.Wh("上麦CallBack回调失败onFail");
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
        JSONObject jSONObject = new JSONObject();
        try {
            x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
            if (aas != null && aas.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
            }
            jSONObject.put("uid", o.eff().aar());
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_receive_invite").setContentExt(jSONObject));
        if (this.oAT != null && this.oAT.isShowing()) {
            this.oAT.dismiss();
        }
        this.oAT = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.oAT.show();
        x aas2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
        if (aas2 != null && aas2.aLw >= 0) {
            i = aas2.aLw;
        }
        this.oAT.NJ(i * 1000);
        this.oAT.WC(str);
        this.oAT.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eeK() {
                d.eeN().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                    public void zM(boolean z) {
                        if (!z) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                x aas3 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                                if (aas3 != null && aas3.aLl != null) {
                                    jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas3.aLl.live_id);
                                }
                                jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 4);
                                jSONObject2.put("error_code", 10001);
                                jSONObject2.put("error_msg", "拒绝开启麦克风权限");
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_fail").setContentExt(jSONObject2));
                            return;
                        }
                        UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                        UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        if (currentAccountInfo != null) {
                            o.eff().zS(true);
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_accept_invite_anchor_9", false);
                            b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        }
                    }
                });
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eeL() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oAS);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x aas3 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                    if (aas3 != null && aas3.aLl != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas3.aLl.live_id);
                    }
                    jSONObject2.put("error_code", 10002);
                    jSONObject2.put("error_msg", "拒绝邀请上麦");
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_fail").setContentExt(jSONObject2));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void aoc() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.oAS);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x aas3 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                    if (aas3 != null && aas3.aLl != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas3.aLl.live_id);
                    }
                    jSONObject2.put("error_code", 10003);
                    jSONObject2.put("error_msg", "邀请超时放弃上麦");
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_fail").setContentExt(jSONObject2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        if (this.oAQ == null) {
            this.oAQ = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0920a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0920a
                public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                        l.efb().i(b.this.oAf).NG(3);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.efU(), false, true);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0920a
                public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                        if (aas != null && aas.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                        jSONObject.put("error_code", alaAcceptConnectionWheatHttpResponseMessage.getErrno());
                        jSONObject.put("error_msg", "接受邀请鉴权失败：" + alaAcceptConnectionWheatHttpResponseMessage.getErrmsg() + "|" + alaAcceptConnectionWheatHttpResponseMessage.getErrorString());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_fail").setContentExt(jSONObject));
                }
            });
        }
        this.oAQ.aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oAS);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.oAS);
        }
    }

    public void onDestroy() {
        if (this.oAR != null) {
            this.oAR.onDestroy();
            this.oAR = null;
        }
    }
}
