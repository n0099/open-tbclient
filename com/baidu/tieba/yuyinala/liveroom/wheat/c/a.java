package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaAcceptConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static a oAJ;
    private InterfaceC0955a oAI;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e oAK = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.oAI != null) {
                a.this.oAI.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void NE(int i) {
            if (a.this.oAI != null) {
                a.this.oAI.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0955a {
        void Wp(String str);

        void onFail();

        void onSuccess();
    }

    public static a eeJ() {
        if (oAJ == null) {
            oAJ = new a();
        }
        return oAJ;
    }

    public void b(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0958a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0958a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                    a.this.b(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.efV());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0958a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.oAI != null) {
                    a.this.oAI.onFail();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
                    if (aat != null && aat.aLl != null) {
                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                    }
                    jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                    jSONObject.put("error_code", alaAcceptConnectionWheatHttpResponseMessage.getErrno());
                    jSONObject.put("error_msg", alaAcceptConnectionWheatHttpResponseMessage.getErrorString() + "|" + alaAcceptConnectionWheatHttpResponseMessage.getErrmsg() + "|" + alaAcceptConnectionWheatHttpResponseMessage.getUserMsg());
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_result").setContentExt(jSONObject));
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), str, str4);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5) {
        if (o.efg().Wc(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().b(this.oAK).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eeu(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eeu(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i != 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
                        if (aat != null && aat.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject.put("error_code", i);
                        jSONObject.put("error_msg", "主持接受发送信令邀请失败：" + str6 + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eeo());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_result").setContentExt(jSONObject));
                    if (a.this.oAI != null) {
                        a.this.oAI.onFail();
                    }
                }
            }
        });
        if (this.oAI != null) {
            this.oAI.Wp(str);
        }
    }

    public void a(InterfaceC0955a interfaceC0955a) {
        this.oAI = interfaceC0955a;
    }
}
