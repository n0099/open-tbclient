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
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.a.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c oAc;
    private Activity mActivity;
    private HashMap<String, b> oAa = new HashMap<>();
    private HashMap<String, List<d>> oAb = new HashMap<>();
    private x oAd;
    private TbPageContext oAe;

    /* loaded from: classes11.dex */
    public interface a {
        void zL(boolean z);
    }

    public static c eep() {
        if (oAc == null) {
            oAc = new c();
            eeq();
        }
        return oAc;
    }

    public static void eeq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, com.baidu.live.a.aAH + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b eer() {
        return a(Cq(), (d) null);
    }

    public b b(d dVar) {
        return a(Cq(), dVar);
    }

    public b Wk(String str) {
        return a(str, (d) null);
    }

    public b a(String str, d dVar) {
        return a(str, eev(), dVar);
    }

    public b a(final String str, String str2, d dVar) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dVar != null) {
            if (this.oAb.containsKey(str) && this.oAb.get(str) != null) {
                List<d> list = this.oAb.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.oAb.put(str, arrayList);
            }
        }
        if (this.oAa.containsKey(str) && this.oAa.get(str) != null) {
            return this.oAa.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.oAa.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.Cw();
                }
            }
        }
        this.oAa.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2);
        this.oAa.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i, int i2, String str3) {
                List list2 = (List) c.this.oAb.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.onError(i, i2, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i2 != -4 && !o.efg().efo()) {
                        if (i == 1) {
                            if (i2 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 2) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Wl("RTC_LOGIN_TYPE_OWNER_CHAT");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    x aat = c.eep().aat();
                                    if (aat != null && aat.aLl != null) {
                                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                                    }
                                    jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 3);
                                    jSONObject.put("error_code", i2);
                                    jSONObject.put("error_msg", "主持麦加入RTC失败：" + str3);
                                } catch (JSONException e) {
                                    BdLog.e(e);
                                }
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject));
                            } else if (i2 == 3) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_invite_text)).show();
                                c.this.Wl("RTC_LOGIN_TYPE_INVITE");
                            } else if (i2 == 4) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_apply_text)).show();
                                c.this.Wl("RTC_LOGIN_TYPE_APPLY");
                            } else if (i2 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_drops_text)).show();
                                c.this.Wl("RTC_LOGIN_TYPE_ENFORE_LOGIN");
                            }
                        } else if (i == 2) {
                            if (i2 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_invite_text)).show();
                            } else if (i2 == 2) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_accept_text)).show();
                            } else if (i2 == 3) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_accept_invite_text)).show();
                            } else if (i2 == 4 || i2 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_operation_text)).show();
                            } else if (i2 == 8) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_drops_text)).show();
                                c.this.Wl("IMRTC_ERROR_ONLINE");
                            } else if (i2 == 7) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 6) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Wl("IMRTC_ERROR_OWNER_JOINCHAT");
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    x aat2 = c.eep().aat();
                                    if (aat2 != null && aat2.aLl != null) {
                                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat2.aLl.live_id);
                                    }
                                    jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                                    jSONObject2.put("error_code", i2);
                                    jSONObject2.put("error_msg", "主持麦加入信令失败：" + str3 + "|" + c.this.eer().eeo());
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
            public void NE(int i) {
                if (i != 5) {
                    List list2 = (List) c.this.oAb.get(str);
                    for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                        d dVar2 = (d) list2.get(i2);
                        if (dVar2 != null) {
                            dVar2.NE(i);
                        }
                    }
                    if (i == 2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            x aat = c.eep().aat();
                            if (aat != null && aat.aLl != null) {
                                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                            }
                            jSONObject.put("error_code", 0);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_join_chat_result").setContentExt(jSONObject));
                        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_host_4", true);
                    } else if (i == 3) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            x aat2 = c.eep().aat();
                            if (aat2 != null && aat2.aLl != null) {
                                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat2.aLl.live_id);
                            }
                            jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 3);
                            jSONObject2.put("error_code", 0);
                        } catch (Exception e2) {
                            BdLog.e(e2);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_invite_join_chat_result").setContentExt(jSONObject2));
                    } else if (i == 4) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_ANCHOR_JOIN_MIC, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            x aat3 = c.eep().aat();
                            if (aat3 != null && aat3.aLl != null) {
                                jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat3.aLl.live_id);
                            }
                            jSONObject3.put(AlaRecorderLog.KEY_CURRENT_STAGE, 3);
                            jSONObject3.put("error_code", 0);
                        } catch (Exception e3) {
                            BdLog.e(e3);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_result").setContentExt(jSONObject3));
                    }
                } else if (!o.efg().jm(o.efg().aas()) && bVar != null) {
                    bVar.Wf("RTC_LOGIN_TYPE_ENFORE_LOGIN");
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void NF(int i) {
                AlaWheatInfoData jp;
                List list2 = (List) c.this.oAb.get(str);
                for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.NF(i);
                    }
                }
                if (i == 2) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_shut_up_text)).show();
                    c.this.ees();
                } else if (i == 3) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_diss_shut_up_text)).show();
                    c.this.ees();
                } else if (i == 1) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_kick_off_text)).show();
                    h.eeV().zO(true).zN(false);
                    c.this.ees();
                } else if (i == 7) {
                    h.eeV().zO(true).zN(false);
                    c.this.ees();
                } else if ((i == 4 || i == 5) && (jp = o.efg().jp(o.efg().aas())) != null && jp.isOpenMike()) {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        HttpMessage httpMessage = new HttpMessage(1031077);
                        httpMessage.addParam("status", i == 4 ? 1 : 0);
                        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        httpMessage.addParam("room_id", c.this.Cq());
                        httpMessage.addParam("live_id", c.this.aau());
                        httpMessage.addParam("open_rtc_mode", 1);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (currentAccountInfo != null) {
                        try {
                            jSONObject.put("content_type", "sync_audio_speeker_status");
                            jSONObject.put("status", i != 4 ? 0 : 1);
                            jSONObject.put("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                            jSONObject.put("room_id", c.this.Cq());
                            jSONObject.put("live_id", c.this.aau());
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
            public void Tw() {
                List list2 = (List) c.this.oAb.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.Tw();
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hL(long j) {
                List list2 = (List) c.this.oAb.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.hL(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hM(long j) {
                List list2 = (List) c.this.oAb.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.hM(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void bM(long j) {
                List list2 = (List) c.this.oAb.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.bM(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void u(long j, boolean z) {
                List list2 = (List) c.this.oAb.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.u(j, z);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
                if (c.this.oAd != null && c.this.oAd.aLl != null && TextUtils.equals(c.this.oAd.aLl.aVv, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.oAb.get(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ListUtils.getCount(list2)) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eeK().g(c.this.oAe).a(c.this.mActivity, bIMInviteSyncRtcInfo);
                            c.this.ees();
                            return;
                        }
                        d dVar2 = (d) list2.get(i2);
                        if (dVar2 != null) {
                            dVar2.a(bIMInviteSyncRtcInfo);
                        }
                        i = i2 + 1;
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void b(BIMRtcInfo bIMRtcInfo, int i) {
                if (c.this.oAd != null && c.this.oAd.aLl != null && TextUtils.equals(c.this.oAd.aLl.aVv, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.oAb.get(str);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= ListUtils.getCount(list2)) {
                            c.this.ees();
                            c.this.a(bIMRtcInfo, i);
                            return;
                        }
                        d dVar2 = (d) list2.get(i3);
                        if (dVar2 != null) {
                            dVar2.b(bIMRtcInfo, i);
                        }
                        i2 = i3 + 1;
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void s(int i, int i2, String str3) {
                List list2 = (List) c.this.oAb.get(str);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < ListUtils.getCount(list2)) {
                        d dVar2 = (d) list2.get(i4);
                        if (dVar2 != null) {
                            dVar2.s(i, i2, str3);
                        }
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void l(int i, long j, String str3) {
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        if (TextUtils.equals("sync_audio_speeker_status", new JSONObject(str3).optString("content_type")) && com.baidu.live.aq.a.aan().jm(com.baidu.live.aq.a.aan().aas())) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501026, str3));
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
    public void Wl(String str) {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            b eer = eer();
            if (eer != null) {
                eer.Wf(str);
            }
            if (o.efg().jm(o.efg().aas())) {
                o.efg().J(true, str);
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
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(o.efg().aas(), optString2)) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_reject_invite_text), optString)).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ees() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    public c aG(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public c f(TbPageContext tbPageContext) {
        this.oAe = tbPageContext;
        return this;
    }

    public void aS(String str, String str2, String str3) {
        b a2 = eep().a(str, str2, (d) null);
        if (a2 != null) {
            a2.Wh(str3);
        }
    }

    public void ak(x xVar) {
        if (xVar != null && xVar.aLl != null && xVar.aLl.aVu != null) {
            this.oAd = xVar;
            b a2 = eep().a(xVar.aLl.aVu, (d) null);
            String str = xVar.mLiveInfo.session_info.flvUrl;
            if (eew()) {
                a2.aR(eep().eeu(), TbadkCoreApplication.getCurrentAccountName(), str);
            } else {
                a2.gK(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void eet() {
        b eer = eer();
        if (eer != null) {
            eer.Cw();
        }
    }

    public void onDestroy() {
        eet();
        if (this.oAa != null) {
            this.oAa.clear();
        }
        if (this.oAb != null) {
            this.oAb.clear();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eeK().onDestroy();
    }

    public String aau() {
        if (this.oAd == null || this.oAd.aLl == null) {
            return null;
        }
        return this.oAd.aLl.live_id;
    }

    public String Cq() {
        if (this.oAd == null || this.oAd.aLl == null) {
            return null;
        }
        return this.oAd.aLl.aVu;
    }

    public String getCustomRoomId() {
        if (this.oAd == null || this.oAd.aLl == null) {
            return null;
        }
        return this.oAd.aLl.croom_id;
    }

    public String aar() {
        if (this.oAd == null || this.oAd.mLiveInfo == null) {
            return null;
        }
        return this.oAd.mLiveInfo.user_uk;
    }

    public String eeu() {
        if (this.oAd == null || this.oAd.aLl == null) {
            return null;
        }
        return this.oAd.aLl.aVv;
    }

    public String eev() {
        if (this.oAd == null || this.oAd.mLiveInfo == null || this.oAd.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.oAd.mLiveInfo.mCastIds.chatMCastId;
    }

    private boolean eew() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.oAd == null || this.oAd.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.oAd.mLiveInfo.user_uk)) ? false : true;
    }

    public x aat() {
        return this.oAd;
    }

    public synchronized void a(String str, final boolean z, final a aVar) {
        if (eer() != null) {
            eer().a(str, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
                public void A(int i, long j) {
                    boolean hI = c.this.eer().hI(j);
                    if (!hI && z) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_leave_room_txt)).show();
                    }
                    if (aVar != null) {
                        aVar.zL(hI);
                    }
                }
            });
        }
    }

    public synchronized void a(String str, a aVar) {
        a(str, false, aVar);
    }
}
