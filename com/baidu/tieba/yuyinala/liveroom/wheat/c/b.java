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
/* loaded from: classes10.dex */
public class b {
    private static b owk;
    private TbPageContext ovA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.a owl;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.i owm;
    private String own = "";
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f owo;

    public static b eaS() {
        if (owk == null) {
            owk = new b();
        }
        return owk;
    }

    private b() {
    }

    public b g(TbPageContext tbPageContext) {
        this.ovA = tbPageContext;
        return this;
    }

    public void a(Activity activity, final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
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
            this.own = jSONObject2.optString("invite_uk");
            String optString = jSONObject2.optString("type");
            str2 = jSONObject2.optString("pushUrl");
            str3 = jSONObject2.optString("pushSingleUrl");
            z = com.baidu.tieba.yuyinala.liveroom.wheat.a.b.Vc(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            z = false;
        }
        if (z) {
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
            o.ebo().zO(true);
            new com.baidu.tieba.yuyinala.liveroom.wheat.model.i(null, new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                public void a(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    if (alaLinkCallBackHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                        if (eaz != null) {
                            eaz.UZ("上麦CallBack回调失败onSucc");
                            return;
                        }
                        return;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                    l.ebk().i(b.this.ovA).LZ(4);
                    b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str2, str3, true, false);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.i.a
                public void b(AlaLinkCallBackHttpResponseMessage alaLinkCallBackHttpResponseMessage) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        x WA2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
                        if (WA2 != null && WA2.aGy != null) {
                            jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA2.aGy.live_id);
                        }
                        jSONObject3.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                        jSONObject3.put("error_code", alaLinkCallBackHttpResponseMessage.getErrno());
                        jSONObject3.put("error_msg", "上麦CallBack回调失败onFail：" + alaLinkCallBackHttpResponseMessage.getErrmsg() + "|" + alaLinkCallBackHttpResponseMessage.getErrorString());
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_result").setContentExt(jSONObject3));
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
                    if (eaz != null) {
                        eaz.UZ("上麦CallBack回调失败onFail");
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
            x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
            }
            jSONObject.put("uid", o.ebo().Wz());
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_receive_invite").setContentExt(jSONObject));
        if (this.owo != null && this.owo.isShowing()) {
            this.owo.dismiss();
        }
        this.owo = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f(activity);
        this.owo.show();
        x WA2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
        if (WA2 != null && WA2.aGJ >= 0) {
            i = WA2.aGJ;
        }
        this.owo.Mc(i * 1000);
        this.owo.Vu(str);
        this.owo.a(new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eaT() {
                d.eaW().a(activity, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.2.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                    public void zI(boolean z) {
                        if (!z) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                x WA3 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
                                if (WA3 != null && WA3.aGy != null) {
                                    jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA3.aGy.live_id);
                                }
                                jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 4);
                                jSONObject2.put("error_code", 10001);
                                jSONObject2.put("error_msg", "拒绝开启麦克风权限");
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_result").setContentExt(jSONObject2));
                            return;
                        }
                        UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                        UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi", null);
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        if (currentAccountInfo != null) {
                            o.ebo().zO(true);
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_accept_invite_anchor_9", false);
                            b.this.a(bIMInviteSyncRtcInfo, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        }
                    }
                });
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void eaU() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.own);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x WA3 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
                    if (WA3 != null && WA3.aGy != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA3.aGy.live_id);
                    }
                    jSONObject2.put("error_code", 10002);
                    jSONObject2.put("error_msg", "拒绝邀请上麦");
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_result").setContentExt(jSONObject2));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.a
            public void akj() {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().a(bIMInviteSyncRtcInfo, 2, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), null, null, false, b.this.own);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x WA3 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
                    if (WA3 != null && WA3.aGy != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA3.aGy.live_id);
                    }
                    jSONObject2.put("error_code", 10003);
                    jSONObject2.put("error_msg", "邀请超时放弃上麦");
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_result").setContentExt(jSONObject2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, String str) {
        if (this.owl == null) {
            this.owl = new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0941a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0941a
                public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micAuthApi");
                        l.ebk().i(b.this.ovA).LZ(3);
                        b.this.a(bIMInviteSyncRtcInfo, 1, TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.ecd(), false, true);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0941a
                public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
                        if (WA != null && WA.aGy != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                        jSONObject.put("error_code", alaAcceptConnectionWheatHttpResponseMessage.getErrno());
                        jSONObject.put("error_msg", "接受邀请鉴权失败：" + alaAcceptConnectionWheatHttpResponseMessage.getErrmsg() + "|" + alaAcceptConnectionWheatHttpResponseMessage.getErrorString());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_result").setContentExt(jSONObject));
                }
            });
        }
        this.owl.aT(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), str, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo, int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.own);
        } else {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().a(bIMInviteSyncRtcInfo, i, str, str2, str3, z, this.own);
        }
    }

    public void onDestroy() {
        if (this.owm != null) {
            this.owm.onDestroy();
            this.owm = null;
        }
    }
}
