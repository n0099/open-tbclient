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
/* loaded from: classes10.dex */
public class c {
    private static c oHE;
    private Activity mActivity;
    private HashMap<String, b> oHC = new HashMap<>();
    private HashMap<String, List<d>> oHD = new HashMap<>();
    private ab oHF;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.b oHG;

    public static c ecZ() {
        if (oHE == null) {
            oHE = new c();
            eda();
        }
        return oHE;
    }

    public static void eda() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, com.baidu.live.a.axj + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b edb() {
        return a(yp(), (d) null);
    }

    public b b(d dVar) {
        return a(yp(), dVar);
    }

    public b Wt(String str) {
        return a(str, (d) null);
    }

    public b a(String str, d dVar) {
        return a(str, edf(), ecV(), false, dVar);
    }

    public b a(final String str, String str2, int i, boolean z, d dVar) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dVar != null) {
            if (this.oHD.containsKey(str) && this.oHD.get(str) != null) {
                List<d> list = this.oHD.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.oHD.put(str, arrayList);
            }
        }
        if (this.oHC.containsKey(str) && this.oHC.get(str) != null) {
            return this.oHC.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.oHC.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.yr();
                }
            }
        }
        this.oHC.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2, i, z);
        this.oHC.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i2, int i3, String str3) {
                List list2 = (List) c.this.oHD.get(str);
                for (int i4 = 0; i4 < ListUtils.getCount(list2); i4++) {
                    d dVar2 = (d) list2.get(i4);
                    if (dVar2 != null) {
                        dVar2.onError(i2, i3, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i3 != -4 && !q.edU().eec()) {
                        if (i2 == 1) {
                            if (i3 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i3 == 2) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Wu("RTC_LOGIN_TYPE_OWNER_CHAT");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    ab Yt = c.ecZ().Yt();
                                    if (Yt != null && Yt.aKu != null) {
                                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
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
                                c.this.Wu("RTC_LOGIN_TYPE_INVITE");
                            } else if (i3 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_apply_text)).show();
                                c.this.Wu("RTC_LOGIN_TYPE_APPLY");
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
                                c.this.Wu("IMRTC_ERROR_ONLINE");
                            } else if (i3 == 7) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i3 == 6) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Wu("IMRTC_ERROR_OWNER_JOINCHAT");
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    ab Yt2 = c.ecZ().Yt();
                                    if (Yt2 != null && Yt2.aKu != null) {
                                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt2.aKu.live_id);
                                    }
                                    jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                                    jSONObject2.put("error_code", i3);
                                    jSONObject2.put("error_msg", "主持麦加入信令失败：" + str3 + "|" + c.this.edb().ecY());
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
            public void My(int i2) {
                List list2 = (List) c.this.oHD.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.My(i2);
                    }
                }
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        ab Yt = c.ecZ().Yt();
                        if (Yt != null && Yt.aKu != null) {
                            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
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
            public void Mz(int i2) {
                AlaWheatInfoData iQ;
                List list2 = (List) c.this.oHD.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.Mz(i2);
                    }
                }
                if (i2 == 2) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_shut_up_text)).show();
                    c.this.edc();
                } else if (i2 == 3) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_diss_shut_up_text)).show();
                    c.this.edc();
                } else if (i2 == 1) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_kick_off_text)).show();
                    i.edF().Ac(true).Ab(false);
                    c.this.edc();
                } else if (i2 == 7) {
                    i.edF().Ac(true).Ab(false);
                    c.this.edc();
                } else if ((i2 == 4 || i2 == 5) && (iQ = q.edU().iQ(q.edU().Ys())) != null && iQ.isOpenMike()) {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        HttpMessage httpMessage = new HttpMessage(1031077);
                        httpMessage.addParam("status", i2 == 4 ? 1 : 0);
                        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        httpMessage.addParam("room_id", c.this.yp());
                        httpMessage.addParam("live_id", c.this.Yu());
                        httpMessage.addParam("open_rtc_mode", 1);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (currentAccountInfo != null) {
                        try {
                            jSONObject.put("content_type", "sync_audio_speeker_status");
                            jSONObject.put("status", i2 != 4 ? 0 : 1);
                            jSONObject.put("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                            jSONObject.put("room_id", c.this.yp());
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
            public void Ro() {
                List list2 = (List) c.this.oHD.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.edc();
                        return;
                    }
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.Ro();
                    }
                    i2 = i3 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hO(long j) {
                List list2 = (List) c.this.oHD.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.edc();
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
                List list2 = (List) c.this.oHD.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.edc();
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
                List list2 = (List) c.this.oHD.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.edc();
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
                List list2 = (List) c.this.oHD.get(str);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ListUtils.getCount(list2)) {
                        c.this.edc();
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
                if (c.this.oHF != null && c.this.oHF.aKu != null && TextUtils.equals(c.this.oHF.aKu.aVl, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.oHD.get(str);
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
                    if (c.this.oHG != null) {
                        c.this.oHG.onDestroy();
                        c.this.oHG = null;
                    }
                    c.this.oHG = new com.baidu.tieba.yuyinala.liveroom.wheat.c.b();
                    c.this.oHG.a(c.this.mActivity, bIMInviteSyncRtcInfo);
                    c.this.edc();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void b(BIMRtcInfo bIMRtcInfo, int i2) {
                if (c.this.oHF != null && c.this.oHF.aKu != null && TextUtils.equals(c.this.oHF.aKu.aVl, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.oHD.get(str);
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= ListUtils.getCount(list2)) {
                            c.this.edc();
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
            public void e(int i2, long j, String str3) {
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        if (TextUtils.equals("sync_audio_speeker_status", new JSONObject(str3).optString("content_type"))) {
                            if (com.baidu.live.ao.a.Ym().iN(com.baidu.live.ao.a.Ym().Ys()) || com.baidu.live.ao.a.Ym().Yn()) {
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
    public void Wu(String str) {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            b edb = edb();
            if (edb != null) {
                edb.Wr(str);
            }
            if (q.edU().iN(q.edU().Ys())) {
                q.edU().R(true, str);
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
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(q.edU().Ys(), optString2)) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_reject_invite_text), optString)).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    public c aA(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public void aS(String str, String str2, String str3) {
        b a2 = ecZ().a(str, str2, 0, true, null);
        if (a2 != null) {
            a2.Wq(str3);
        }
    }

    public void ak(ab abVar) {
        if (abVar != null && abVar.aKu != null && abVar.aKu.aVk != null) {
            this.oHF = abVar;
            b a2 = ecZ().a(abVar.aKu.aVk, (d) null);
            String str = abVar.mLiveInfo.session_info.flvUrl;
            if (Yn()) {
                a2.gR(ecZ().ede(), TbadkCoreApplication.getCurrentAccountName());
            } else {
                a2.gS(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void edd() {
        b edb = edb();
        if (edb != null) {
            edb.yr();
        }
    }

    public void onDestroy() {
        edd();
        if (this.oHC != null) {
            this.oHC.clear();
        }
        if (this.oHD != null) {
            this.oHD.clear();
        }
        if (this.oHG != null) {
            this.oHG.onDestroy();
            this.oHG = null;
        }
    }

    public String Yu() {
        if (this.oHF == null || this.oHF.aKu == null) {
            return null;
        }
        return this.oHF.aKu.live_id;
    }

    public String yp() {
        if (this.oHF == null || this.oHF.aKu == null) {
            return null;
        }
        return this.oHF.aKu.aVk;
    }

    public String getCustomRoomId() {
        if (this.oHF == null || this.oHF.aKu == null) {
            return null;
        }
        return this.oHF.aKu.croom_id;
    }

    public String Yr() {
        if (this.oHF == null || this.oHF.mLiveInfo == null) {
            return null;
        }
        return this.oHF.mLiveInfo.user_uk;
    }

    public String ede() {
        if (this.oHF == null || this.oHF.aKu == null) {
            return null;
        }
        return this.oHF.aKu.aVl;
    }

    public String edf() {
        if (this.oHF == null || this.oHF.mLiveInfo == null || this.oHF.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.oHF.mLiveInfo.mCastIds.chatMCastId;
    }

    public int ecV() {
        if (this.oHF == null || this.oHF.aKu == null) {
            return 0;
        }
        return this.oHF.aKu.aVv;
    }

    private boolean Yn() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.oHF == null || this.oHF.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.oHF.mLiveInfo.user_uk)) ? false : true;
    }

    public ab Yt() {
        return this.oHF;
    }

    public long ecU() {
        b edb = ecZ().edb();
        if (edb != null) {
            return edb.ecU();
        }
        return 0L;
    }

    public boolean edg() {
        ab Yt = Yt();
        b edb = ecZ().edb();
        return (Yt == null || Yt.aKu == null || edb == null || Yt.aKu.aVv != edb.ecV()) ? false : true;
    }
}
