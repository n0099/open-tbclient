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
    private static a oAK;
    private InterfaceC0917a oAJ;
    com.baidu.tieba.yuyinala.liveroom.wheat.a.e oAL = new com.baidu.tieba.yuyinala.liveroom.wheat.a.e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void onError(int i, int i2, String str) {
            if (a.this.oAJ != null) {
                a.this.oAJ.onFail();
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
        public void NE(int i) {
            if (a.this.oAJ != null) {
                a.this.oAJ.onSuccess();
            }
        }
    };

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0917a {
        void Wq(String str);

        void onFail();

        void onSuccess();
    }

    public static a eeI() {
        if (oAK == null) {
            oAK = new a();
        }
        return oAK;
    }

    public void b(final String str, final String str2, final String str3, final long j, String str4) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.a(null, new a.InterfaceC0920a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0920a
            public void a(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (!alaAcceptConnectionWheatHttpResponseMessage.isError()) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                    a.this.b(str, str2, str3, j, alaAcceptConnectionWheatHttpResponseMessage.getPushUrl(), alaAcceptConnectionWheatHttpResponseMessage.efU());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.a.InterfaceC0920a
            public void b(AlaAcceptConnectionWheatHttpResponseMessage alaAcceptConnectionWheatHttpResponseMessage) {
                if (a.this.oAJ != null) {
                    a.this.oAJ.onFail();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                    if (aas != null && aas.aLl != null) {
                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                    }
                    jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                    jSONObject.put("error_code", alaAcceptConnectionWheatHttpResponseMessage.getErrno());
                    jSONObject.put("error_msg", alaAcceptConnectionWheatHttpResponseMessage.getErrorString() + "|" + alaAcceptConnectionWheatHttpResponseMessage.getErrmsg() + "|" + alaAcceptConnectionWheatHttpResponseMessage.getUserMsg());
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_fail").setContentExt(jSONObject));
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), str, str4);
    }

    public void b(String str, String str2, String str3, long j, String str4, String str5) {
        if (o.eff().Wd(str)) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().b(this.oAL).L(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eet(), TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow(), str4, str5);
            return;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(str, str2, str3, j, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eet(), true, str4, str5, new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str6) {
                if (i != 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                        if (aas != null && aas.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                        jSONObject.put("error_code", i);
                        jSONObject.put("error_msg", "主持接受发送信令邀请失败：" + str6 + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().een());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_fail").setContentExt(jSONObject));
                    if (a.this.oAJ != null) {
                        a.this.oAJ.onFail();
                    }
                }
            }
        });
        if (this.oAJ != null) {
            this.oAJ.Wq(str);
        }
    }

    public void a(InterfaceC0917a interfaceC0917a) {
        this.oAJ = interfaceC0917a;
    }
}
