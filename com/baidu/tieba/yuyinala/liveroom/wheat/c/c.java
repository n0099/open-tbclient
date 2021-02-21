package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaApplyWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c oGj;
    private a oGk;

    /* loaded from: classes11.dex */
    public interface a {
        void ddy();

        void edk();
    }

    public static c edo() {
        if (oGj == null) {
            oGj = new c();
        }
        return oGj;
    }

    private c() {
    }

    public void a(Context context, Activity activity, String str, String str2) {
        if (Ws(str)) {
            a(context, activity, str);
        } else {
            b(context, activity, str, str2);
        }
    }

    private void a(Context context, Activity activity, final String str) {
        if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecY()) {
            if (context != null) {
                BdToast.makeText(context, context.getString(a.h.yuyin_ala_relogin_join_chat)).show();
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
            }
            jSONObject.put("uid", q.edM().Yp());
            jSONObject.put("error_code", 0);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_clk").setContentExt(jSONObject));
        d.edp().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void Ab(boolean z) {
                if (z) {
                    if (c.this.oGk != null) {
                        c.this.oGk.ddy();
                    }
                    UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "hostJoinMic", null);
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "hostJoinMic");
                            n.edF().Mw(2);
                            c.this.a(alaApplyWheatHttpResponseMessage);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                ab Yq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
                                if (Yq2 != null && Yq2.aIU != null) {
                                    jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq2.aIU.live_id);
                                }
                                jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                                jSONObject2.put("error_code", alaApplyWheatHttpResponseMessage.getErrno());
                                jSONObject2.put("error_msg", alaApplyWheatHttpResponseMessage.getErrorString() + "|" + alaApplyWheatHttpResponseMessage.getErrmsg() + "|" + alaApplyWheatHttpResponseMessage.getUserMsg());
                            } catch (JSONException e2) {
                                BdLog.e(e2);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject2));
                        }
                    }).a(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), str, "", com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT() != null ? com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().ecM() : 0L, 0L, "");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    ab Yq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
                    if (Yq2 != null && Yq2.aIU != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq2.aIU.live_id);
                    }
                    jSONObject2.put("error_code", 10001);
                    jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 4);
                    jSONObject2.put("error_msg", "拒绝开启麦克风权限");
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject2));
            }
        });
    }

    private void b(Context context, Activity activity, final String str, final String str2) {
        d.edp().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void Ab(boolean z) {
                if (z) {
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            if (!alaApplyWheatHttpResponseMessage.isError() && c.this.oGk != null) {
                                c.this.oGk.edk();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                        }
                    }).a(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), str, str2, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT() != null ? com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().ecM() : 0L, 0L, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
        if (alaApplyWheatHttpResponseMessage.eeA() == 1) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().J(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecW(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaApplyWheatHttpResponseMessage.getPushUrl(), alaApplyWheatHttpResponseMessage.eez());
        }
    }

    private boolean Ws(String str) {
        return "1".equals(str);
    }

    public void onDestroy() {
        oGj = null;
    }

    public c a(a aVar) {
        this.oGk = aVar;
        return this;
    }
}
