package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
    private static c oAZ;
    private a oBa;

    /* loaded from: classes11.dex */
    public interface a {
        void dfk();

        void eeH();
    }

    public static c eeM() {
        if (oAZ == null) {
            oAZ = new c();
        }
        return oAZ;
    }

    private c() {
    }

    public void a(Context context, Activity activity, String str, String str2) {
        if (Wr(str)) {
            a(context, activity, str);
        } else {
            b(context, activity, str, str2);
        }
    }

    private void a(Context context, Activity activity, final String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
            if (aas != null && aas.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
            }
            jSONObject.put("uid", o.eff().aar());
            jSONObject.put("error_code", 0);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_clk").setContentExt(jSONObject));
        d.eeN().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zM(boolean z) {
                if (z) {
                    if (c.this.oBa != null) {
                        c.this.oBa.dfk();
                    }
                    UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "hostJoinMic", null);
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "hostJoinMic");
                            l.efb().NG(2);
                            c.this.a(alaApplyWheatHttpResponseMessage);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                x aas2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                                if (aas2 != null && aas2.aLl != null) {
                                    jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas2.aLl.live_id);
                                }
                                jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                                jSONObject2.put("error_code", alaApplyWheatHttpResponseMessage.getErrno());
                                jSONObject2.put("error_msg", alaApplyWheatHttpResponseMessage.getErrorString() + "|" + alaApplyWheatHttpResponseMessage.getErrmsg() + "|" + alaApplyWheatHttpResponseMessage.getUserMsg());
                            } catch (JSONException e2) {
                                BdLog.e(e2);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_fail").setContentExt(jSONObject2));
                        }
                    }).K(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), str, "", "");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x aas2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                    if (aas2 != null && aas2.aLl != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas2.aLl.live_id);
                    }
                    jSONObject2.put("error_code", 10001);
                    jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 4);
                    jSONObject2.put("error_msg", "拒绝开启麦克风权限");
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_fail").setContentExt(jSONObject2));
            }
        });
    }

    private void b(Context context, Activity activity, final String str, final String str2) {
        d.eeN().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zM(boolean z) {
                if (z) {
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            if (!alaApplyWheatHttpResponseMessage.isError() && c.this.oBa != null) {
                                c.this.oBa.eeH();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                        }
                    }).K(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), str, str2, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
        if (alaApplyWheatHttpResponseMessage.efV() == 1) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eet(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaApplyWheatHttpResponseMessage.getPushUrl(), alaApplyWheatHttpResponseMessage.efU());
        }
    }

    private boolean Wr(String str) {
        return "1".equals(str);
    }

    public void onDestroy() {
        oAZ = null;
    }

    public c a(a aVar) {
        this.oBa = aVar;
        return this;
    }
}
