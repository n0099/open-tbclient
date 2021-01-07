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
    private static c oAY;
    private a oAZ;

    /* loaded from: classes11.dex */
    public interface a {
        void dfl();

        void eeI();
    }

    public static c eeN() {
        if (oAY == null) {
            oAY = new c();
        }
        return oAY;
    }

    private c() {
    }

    public void a(Context context, Activity activity, String str, String str2) {
        if (Wq(str)) {
            a(context, activity, str);
        } else {
            b(context, activity, str, str2);
        }
    }

    private void a(Context context, Activity activity, final String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
            if (aat != null && aat.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
            }
            jSONObject.put("uid", o.efg().aas());
            jSONObject.put("error_code", 0);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_clk").setContentExt(jSONObject));
        d.eeO().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zM(boolean z) {
                if (z) {
                    if (c.this.oAZ != null) {
                        c.this.oAZ.dfl();
                    }
                    UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "hostJoinMic", null);
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "hostJoinMic");
                            l.efc().NG(2);
                            c.this.a(alaApplyWheatHttpResponseMessage);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                x aat2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
                                if (aat2 != null && aat2.aLl != null) {
                                    jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat2.aLl.live_id);
                                }
                                jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                                jSONObject2.put("error_code", alaApplyWheatHttpResponseMessage.getErrno());
                                jSONObject2.put("error_msg", alaApplyWheatHttpResponseMessage.getErrorString() + "|" + alaApplyWheatHttpResponseMessage.getErrmsg() + "|" + alaApplyWheatHttpResponseMessage.getUserMsg());
                            } catch (JSONException e2) {
                                BdLog.e(e2);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject2));
                        }
                    }).K(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), str, "", "");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x aat2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
                    if (aat2 != null && aat2.aLl != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat2.aLl.live_id);
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
        d.eeO().a(context, activity, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zM(boolean z) {
                if (z) {
                    new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(null, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.c.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void b(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                            if (!alaApplyWheatHttpResponseMessage.isError() && c.this.oAZ != null) {
                                c.this.oAZ.eeI();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                        public void c(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
                        }
                    }).K(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), str, str2, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaApplyWheatHttpResponseMessage alaApplyWheatHttpResponseMessage) {
        if (alaApplyWheatHttpResponseMessage.efW() == 1) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eeu(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), alaApplyWheatHttpResponseMessage.getPushUrl(), alaApplyWheatHttpResponseMessage.efV());
        }
    }

    private boolean Wq(String str) {
        return "1".equals(str);
    }

    public void onDestroy() {
        oAY = null;
    }

    public c a(a aVar) {
        this.oAZ = aVar;
        return this;
    }
}
