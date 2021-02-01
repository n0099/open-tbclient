package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c oEZ;
    private Activity mActivity;
    private HashMap<String, b> oEX = new HashMap<>();
    private HashMap<String, List<d>> oEY = new HashMap<>();
    private ab oFa;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.b oFb;

    public static c ecJ() {
        if (oEZ == null) {
            oEZ = new c();
            ecK();
        }
        return oEZ;
    }

    public static void ecK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, com.baidu.live.a.avJ + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b ecL() {
        return a(ym(), (d) null);
    }

    public b b(d dVar) {
        return a(ym(), dVar);
    }

    public b Wa(String str) {
        return a(str, (d) null);
    }

    public b a(String str, d dVar) {
        return a(str, ecP(), ecF(), false, dVar);
    }

    public b a(final String str, String str2, int i, boolean z, d dVar) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dVar != null) {
            if (this.oEY.containsKey(str) && this.oEY.get(str) != null) {
                List<d> list = this.oEY.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.oEY.put(str, arrayList);
            }
        }
        if (this.oEX.containsKey(str) && this.oEX.get(str) != null) {
            return this.oEX.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.oEX.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.yo();
                }
            }
        }
        this.oEX.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2, i, z);
        this.oEX.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i2, int i3, String str3) {
                List list2 = (List) c.this.oEY.get(str);
                for (int i4 = 0; i4 < ListUtils.getCount(list2); i4++) {
                    d dVar2 = (d) list2.get(i4);
                    if (dVar2 != null) {
                        dVar2.onError(i2, i3, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i3 != -4 && !q.edE().edM()) {
                        if (i2 == 1) {
                            if (i3 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i3 == 2) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Wb("RTC_LOGIN_TYPE_OWNER_CHAT");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    ab Yq = c.ecJ().Yq();
                                    if (Yq != null && Yq.aIU != null) {
                                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                                    }
                                    jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 3);
                                    jSONObject.put("error_code", i3);
                                    jSONObject.put("error_msg", "主持麦加入RTC失败：" + str3);
                                } catch (JSONException e) {
                                    BdLog.e(e);
                                }
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject));
                            } else if (i3 == 4) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_invite_text)).show();
                                c.this.Wb("RTC_LOGIN_TYPE_INVITE");
                            } else if (i3 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_apply_text)).show();
                                c.this.Wb("RTC_LOGIN_TYPE_APPLY");
                            }
                        } else if (i2 == 2) {
                            if (i3 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_invite_text)).show();
                            } else if (i3 == 2) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_accept_text)).show();
                            } else if (i3 == 3) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_accept_invite_text)).show();
                            } else if (i3 == 4 || i3 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_operation_text)).show();
                            } else if (i3 == 8) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_drops_text)).show();
                                c.this.Wb("IMRTC_ERROR_ONLINE");
                            } else if (i3 == 7) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i3 == 6) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Wb("IMRTC_ERROR_OWNER_JOINCHAT");
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    ab Yq2 = c.ecJ().Yq();
                                    if (Yq2 != null && Yq2.aIU != null) {
                                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq2.aIU.live_id);
                                    }
                                    jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                                    jSONObject2.put("error_code", i3);
                                    jSONObject2.put("error_msg", "主持麦加入信令失败：" + str3 + "|" + c.this.ecL().ecI());
                                } catch (JSONException e2) {
                                    BdLog.e(e2);
                                }
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject2));
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void Mt(int i2) {
                List list2 = (List) c.this.oEY.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.Mt(i2);
                    }
                }
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        ab Yq = c.ecJ().Yq();
                        if (Yq != null && Yq.aIU != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                        }
                        jSONObject.put("error_code", 0);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject));
                    UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_host_4", true);
                } else if (i2 == 4) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                    UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                } else if (i2 == 5) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                    UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void Mu(int i2) {
                AlaWheatInfoData iK;
                List list2 = (List) c.this.oEY.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.Mu(i2);
                    }
                }
                if (i2 == 2) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_shut_up_text)).show();
                    c.this.ecM();
                } else if (i2 == 3) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_diss_shut_up_text)).show();
                    c.this.ecM();
                } else if (i2 == 1) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_kick_off_text)).show();
                    i.edp().Ad(true).Ac(false);
                    c.this.ecM();
                } else if (i2 == 7) {
                    i.edp().Ad(true).Ac(false);
                    c.this.ecM();
                } else if ((i2 == 4 || i2 == 5) && (iK = q.edE().iK(q.edE().Yp())) != null && iK.isOpenMike()) {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        HttpMessage httpMessage = new HttpMessage(1031077);
                        httpMessage.addParam("status", i2 == 4 ? 1 : 0);
                        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        httpMessage.addParam("room_id", c.this.ym());
                        httpMessage.addParam("live_id", c.this.Yr());
                        httpMessage.addParam("open_rtc_mode", 1);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (currentAccountInfo != null) {
                        try {
                            jSONObject.put("content_type", "sync_audio_speeker_status");
                            jSONObject.put("status", i2 != 4 ? 0 : 1);
                            jSONObject.put("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                            jSONObject.put("room_id", c.this.ym());
                            jSONObject.put("isLocalData", true);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501026, jSONObject.toString()));
                    jSONObject.put("isLocalData", false);
                    if (bVar != null) {
                        bVar.sendMessageToUser(jSONObject.toString(), 0L);
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void Rl() {
                List list2 = (List) c.this.oEY.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.ecM();
                        return;
                    }
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.Rl();
                    }
                    i2 = i3 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hO(long j) {
                List list2 = (List) c.this.oEY.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.ecM();
                        return;
                    }
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.hO(j);
                    }
                    i2 = i3 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hP(long j) {
                List list2 = (List) c.this.oEY.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.ecM();
                        return;
                    }
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.hP(j);
                    }
                    i2 = i3 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void bQ(long j) {
                List list2 = (List) c.this.oEY.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.ecM();
                        return;
                    }
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.bQ(j);
                    }
                    i2 = i3 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void u(long j, boolean z2) {
                List list2 = (List) c.this.oEY.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.ecM();
                        return;
                    }
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.u(j, z2);
                    }
                    i2 = i3 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
                if (c.this.oFa != null && c.this.oFa.aIU != null && TextUtils.equals(c.this.oFa.aIU.aTL, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.oEY.get(str);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= ListUtils.getCount(list2)) {
                            break;
                        }
                        d dVar2 = (d) list2.get(i3);
                        if (dVar2 != null) {
                            dVar2.a(bIMInviteSyncRtcInfo);
                        }
                        i2 = i3 + 1;
                    }
                    if (c.this.oFb != null) {
                        c.this.oFb.onDestroy();
                        c.this.oFb = null;
                    }
                    c.this.oFb = new com.baidu.tieba.yuyinala.liveroom.wheat.c.b();
                    c.this.oFb.a(c.this.mActivity, bIMInviteSyncRtcInfo);
                    c.this.ecM();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void b(BIMRtcInfo bIMRtcInfo, int i2) {
                if (c.this.oFa != null && c.this.oFa.aIU != null && TextUtils.equals(c.this.oFa.aIU.aTL, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.oEY.get(str);
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= ListUtils.getCount(list2)) {
                            c.this.ecM();
                            c.this.a(bIMRtcInfo, i2);
                            return;
                        }
                        d dVar2 = (d) list2.get(i4);
                        if (dVar2 != null) {
                            dVar2.b(bIMRtcInfo, i2);
                        }
                        i3 = i4 + 1;
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void g(int i2, long j, String str3) {
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        if (TextUtils.equals("sync_audio_speeker_status", new JSONObject(str3).optString("content_type"))) {
                            if (com.baidu.live.ao.a.Yj().iH(com.baidu.live.ao.a.Yj().Yp()) || com.baidu.live.ao.a.Yj().Yk()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501026, str3));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wb(String str) {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            b ecL = ecL();
            if (ecL != null) {
                ecL.VY(str);
            }
            if (q.edE().iH(q.edE().Yp())) {
                q.edE().R(true, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMRtcInfo bIMRtcInfo, int i) {
        if (i == 3 || i == 2) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (!TextUtils.isEmpty(rtcExt)) {
                try {
                    JSONObject jSONObject = new JSONObject(rtcExt);
                    String optString = jSONObject.optString("invited_name");
                    String optString2 = jSONObject.optString("invite_uk");
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(q.edE().Yp(), optString2)) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_reject_invite_text), optString)).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    public c az(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public void aS(String str, String str2, String str3) {
        b a2 = ecJ().a(str, str2, 0, true, null);
        if (a2 != null) {
            a2.VX(str3);
        }
    }

    public void ak(ab abVar) {
        if (abVar != null && abVar.aIU != null && abVar.aIU.aTK != null) {
            this.oFa = abVar;
            b a2 = ecJ().a(abVar.aIU.aTK, (d) null);
            String str = abVar.mLiveInfo.session_info.flvUrl;
            if (Yk()) {
                a2.gP(ecJ().ecO(), TbadkCoreApplication.getCurrentAccountName());
            } else {
                a2.gQ(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void ecN() {
        b ecL = ecL();
        if (ecL != null) {
            ecL.yo();
        }
    }

    public void onDestroy() {
        ecN();
        if (this.oEX != null) {
            this.oEX.clear();
        }
        if (this.oEY != null) {
            this.oEY.clear();
        }
        if (this.oFb != null) {
            this.oFb.onDestroy();
            this.oFb = null;
        }
    }

    public String Yr() {
        if (this.oFa == null || this.oFa.aIU == null) {
            return null;
        }
        return this.oFa.aIU.live_id;
    }

    public String ym() {
        if (this.oFa == null || this.oFa.aIU == null) {
            return null;
        }
        return this.oFa.aIU.aTK;
    }

    public String getCustomRoomId() {
        if (this.oFa == null || this.oFa.aIU == null) {
            return null;
        }
        return this.oFa.aIU.croom_id;
    }

    public String Yo() {
        if (this.oFa == null || this.oFa.mLiveInfo == null) {
            return null;
        }
        return this.oFa.mLiveInfo.user_uk;
    }

    public String ecO() {
        if (this.oFa == null || this.oFa.aIU == null) {
            return null;
        }
        return this.oFa.aIU.aTL;
    }

    public String ecP() {
        if (this.oFa == null || this.oFa.mLiveInfo == null || this.oFa.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.oFa.mLiveInfo.mCastIds.chatMCastId;
    }

    public int ecF() {
        if (this.oFa == null || this.oFa.aIU == null) {
            return 0;
        }
        return this.oFa.aIU.aTV;
    }

    private boolean Yk() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.oFa == null || this.oFa.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.oFa.mLiveInfo.user_uk)) ? false : true;
    }

    public ab Yq() {
        return this.oFa;
    }

    public long ecE() {
        b ecL = ecJ().ecL();
        if (ecL != null) {
            return ecL.ecE();
        }
        return 0L;
    }

    public boolean ecQ() {
        ab Yq = Yq();
        b ecL = ecJ().ecL();
        return (Yq == null || Yq.aIU == null || ecL == null || Yq.aIU.aTV != ecL.ecF()) ? false : true;
    }
}
