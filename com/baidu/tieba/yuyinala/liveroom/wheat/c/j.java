package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaInviteConnectionWheatHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j {
    public void a(final com.baidu.live.data.n nVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
            if (aas != null && aas.aLl != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
            }
            jSONObject.put("uid", nVar.uk);
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_clk").setContentExt(jSONObject));
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.h(null, new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
            public void a(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
                if (alaInviteConnectionWheatHttpResponseMessage.egd()) {
                    a.eeI().b(nVar.uk, nVar.cuid, nVar.aJi, nVar.aJk, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.efU());
                    return;
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_anchor_2", false);
                j.this.a(nVar, alaInviteConnectionWheatHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.h.a
            public void b(AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    x aas2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                    if (aas2 != null && aas2.aLl != null) {
                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas2.aLl.live_id);
                    }
                    jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                    jSONObject2.put("error_code", alaInviteConnectionWheatHttpResponseMessage.getErrno());
                    jSONObject2.put("error_msg", alaInviteConnectionWheatHttpResponseMessage.getErrorString() + "|" + alaInviteConnectionWheatHttpResponseMessage.getErrmsg() + "|" + alaInviteConnectionWheatHttpResponseMessage.getUserMsg());
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_fail").setContentExt(jSONObject2));
            }
        }).aU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), nVar.uk, String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.n nVar, AlaInviteConnectionWheatHttpResponseMessage alaInviteConnectionWheatHttpResponseMessage) {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().a(nVar.uk, nVar.cuid, nVar.aJi, nVar.aJk, com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eet(), false, alaInviteConnectionWheatHttpResponseMessage.getPushUrl(), alaInviteConnectionWheatHttpResponseMessage.efU(), new IStatusListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (i == 0) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("invite_succ_anchor_4", false);
                }
                j.this.R(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(final int i, final String str) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.j.3
            @Override // java.lang.Runnable
            public void run() {
                if (i != 0) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_error_text)).show();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                        if (aas != null && aas.aLl != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                        }
                        jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 1);
                        jSONObject.put("error_code", i);
                        jSONObject.put("error_msg", "主持发送信令邀请失败：" + str + "|" + com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().een());
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_fail").setContentExt(jSONObject));
                }
            }
        });
    }
}
