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
/* loaded from: classes10.dex */
public class c {
    private static c ovy;
    private Activity mActivity;
    private TbPageContext ovA;
    private HashMap<String, b> ovw = new HashMap<>();
    private HashMap<String, List<d>> ovx = new HashMap<>();
    private x ovz;

    /* loaded from: classes10.dex */
    public interface a {
        void zH(boolean z);
    }

    public static c eax() {
        if (ovy == null) {
            ovy = new c();
            eay();
        }
        return ovy;
    }

    public static void eay() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, com.baidu.live.a.avU + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b eaz() {
        return a(yv(), (d) null);
    }

    public b b(d dVar) {
        return a(yv(), dVar);
    }

    public b Vd(String str) {
        return a(str, (d) null);
    }

    public b a(String str, d dVar) {
        return a(str, eaD(), dVar);
    }

    public b a(final String str, String str2, d dVar) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dVar != null) {
            if (this.ovx.containsKey(str) && this.ovx.get(str) != null) {
                List<d> list = this.ovx.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.ovx.put(str, arrayList);
            }
        }
        if (this.ovw.containsKey(str) && this.ovw.get(str) != null) {
            return this.ovw.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.ovw.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.yB();
                }
            }
        }
        this.ovw.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2);
        this.ovw.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i, int i2, String str3) {
                List list2 = (List) c.this.ovx.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.onError(i, i2, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i2 != -4 && !o.ebo().ebw()) {
                        if (i == 1) {
                            if (i2 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 2) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Ve("RTC_LOGIN_TYPE_OWNER_CHAT");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    x WA = c.eax().WA();
                                    if (WA != null && WA.aGy != null) {
                                        jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
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
                                c.this.Ve("RTC_LOGIN_TYPE_INVITE");
                            } else if (i2 == 4) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_apply_text)).show();
                                c.this.Ve("RTC_LOGIN_TYPE_APPLY");
                            } else if (i2 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_drops_text)).show();
                                c.this.Ve("RTC_LOGIN_TYPE_ENFORE_LOGIN");
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
                                c.this.Ve("IMRTC_ERROR_ONLINE");
                            } else if (i2 == 7) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 6) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Ve("IMRTC_ERROR_OWNER_JOINCHAT");
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    x WA2 = c.eax().WA();
                                    if (WA2 != null && WA2.aGy != null) {
                                        jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA2.aGy.live_id);
                                    }
                                    jSONObject2.put(AlaRecorderLog.KEY_CURRENT_STAGE, 2);
                                    jSONObject2.put("error_code", i2);
                                    jSONObject2.put("error_msg", "主持麦加入信令失败：" + str3 + "|" + c.this.eaz().eaw());
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
            public void LX(int i) {
                if (i != 5) {
                    List list2 = (List) c.this.ovx.get(str);
                    for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                        d dVar2 = (d) list2.get(i2);
                        if (dVar2 != null) {
                            dVar2.LX(i);
                        }
                    }
                    if (i == 2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            x WA = c.eax().WA();
                            if (WA != null && WA.aGy != null) {
                                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
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
                            x WA2 = c.eax().WA();
                            if (WA2 != null && WA2.aGy != null) {
                                jSONObject2.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA2.aGy.live_id);
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
                            x WA3 = c.eax().WA();
                            if (WA3 != null && WA3.aGy != null) {
                                jSONObject3.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA3.aGy.live_id);
                            }
                            jSONObject3.put(AlaRecorderLog.KEY_CURRENT_STAGE, 3);
                            jSONObject3.put("error_code", 0);
                        } catch (Exception e3) {
                            BdLog.e(e3);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, UbcStatConstant.ContentType.UBC_TYPE_AUDIO_LIVE_CHAT, UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_result").setContentExt(jSONObject3));
                    }
                } else if (!o.ebo().ib(o.ebo().Wz()) && bVar != null) {
                    bVar.UY("RTC_LOGIN_TYPE_ENFORE_LOGIN");
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void LY(int i) {
                AlaWheatInfoData ie;
                List list2 = (List) c.this.ovx.get(str);
                for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.LY(i);
                    }
                }
                if (i == 2) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_shut_up_text)).show();
                    c.this.eaA();
                } else if (i == 3) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_diss_shut_up_text)).show();
                    c.this.eaA();
                } else if (i == 1) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_kick_off_text)).show();
                    h.ebd().zK(true).zJ(false);
                    c.this.eaA();
                } else if (i == 7) {
                    h.ebd().zK(true).zJ(false);
                    c.this.eaA();
                } else if ((i == 4 || i == 5) && (ie = o.ebo().ie(o.ebo().Wz())) != null && ie.isOpenMike()) {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        HttpMessage httpMessage = new HttpMessage(1031077);
                        httpMessage.addParam("status", i == 4 ? 1 : 0);
                        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        httpMessage.addParam("room_id", c.this.yv());
                        httpMessage.addParam("live_id", c.this.WB());
                        httpMessage.addParam("open_rtc_mode", 1);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (currentAccountInfo != null) {
                        try {
                            jSONObject.put("content_type", "sync_audio_speeker_status");
                            jSONObject.put("status", i != 4 ? 0 : 1);
                            jSONObject.put("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                            jSONObject.put("room_id", c.this.yv());
                            jSONObject.put("live_id", c.this.WB());
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
            public void PB() {
                List list2 = (List) c.this.ovx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eaA();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.PB();
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hL(long j) {
                List list2 = (List) c.this.ovx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eaA();
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
                List list2 = (List) c.this.ovx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eaA();
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
                List list2 = (List) c.this.ovx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eaA();
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
            public void v(long j, boolean z) {
                List list2 = (List) c.this.ovx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eaA();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.v(j, z);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
                if (c.this.ovz != null && c.this.ovz.aGy != null && TextUtils.equals(c.this.ovz.aGy.aQI, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.ovx.get(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ListUtils.getCount(list2)) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eaS().g(c.this.ovA).a(c.this.mActivity, bIMInviteSyncRtcInfo);
                            c.this.eaA();
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
                if (c.this.ovz != null && c.this.ovz.aGy != null && TextUtils.equals(c.this.ovz.aGy.aQI, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.ovx.get(str);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= ListUtils.getCount(list2)) {
                            c.this.eaA();
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
                List list2 = (List) c.this.ovx.get(str);
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
                        if (TextUtils.equals("sync_audio_speeker_status", new JSONObject(str3).optString("content_type")) && com.baidu.live.aq.a.Wu().ib(com.baidu.live.aq.a.Wu().Wz())) {
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
    public void Ve(String str) {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            b eaz = eaz();
            if (eaz != null) {
                eaz.UY(str);
            }
            if (o.ebo().ib(o.ebo().Wz())) {
                o.ebo().J(true, str);
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
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(o.ebo().Wz(), optString2)) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_reject_invite_text), optString)).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    public c aG(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public c f(TbPageContext tbPageContext) {
        this.ovA = tbPageContext;
        return this;
    }

    public void aR(String str, String str2, String str3) {
        b a2 = eax().a(str, str2, (d) null);
        if (a2 != null) {
            a2.Va(str3);
        }
    }

    public void ak(x xVar) {
        if (xVar != null && xVar.aGy != null && xVar.aGy.aQH != null) {
            this.ovz = xVar;
            b a2 = eax().a(xVar.aGy.aQH, (d) null);
            String str = xVar.mLiveInfo.session_info.flvUrl;
            if (eaE()) {
                a2.aQ(eax().eaC(), TbadkCoreApplication.getCurrentAccountName(), str);
            } else {
                a2.gJ(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void eaB() {
        b eaz = eaz();
        if (eaz != null) {
            eaz.yB();
        }
    }

    public void onDestroy() {
        eaB();
        if (this.ovw != null) {
            this.ovw.clear();
        }
        if (this.ovx != null) {
            this.ovx.clear();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eaS().onDestroy();
    }

    public String WB() {
        if (this.ovz == null || this.ovz.aGy == null) {
            return null;
        }
        return this.ovz.aGy.live_id;
    }

    public String yv() {
        if (this.ovz == null || this.ovz.aGy == null) {
            return null;
        }
        return this.ovz.aGy.aQH;
    }

    public String getCustomRoomId() {
        if (this.ovz == null || this.ovz.aGy == null) {
            return null;
        }
        return this.ovz.aGy.croom_id;
    }

    public String Wy() {
        if (this.ovz == null || this.ovz.mLiveInfo == null) {
            return null;
        }
        return this.ovz.mLiveInfo.user_uk;
    }

    public String eaC() {
        if (this.ovz == null || this.ovz.aGy == null) {
            return null;
        }
        return this.ovz.aGy.aQI;
    }

    public String eaD() {
        if (this.ovz == null || this.ovz.mLiveInfo == null || this.ovz.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.ovz.mLiveInfo.mCastIds.chatMCastId;
    }

    private boolean eaE() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.ovz == null || this.ovz.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.ovz.mLiveInfo.user_uk)) ? false : true;
    }

    public x WA() {
        return this.ovz;
    }

    public synchronized void a(String str, final boolean z, final a aVar) {
        if (eaz() != null) {
            eaz().a(str, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
                public void A(int i, long j) {
                    boolean hI = c.this.eaz().hI(j);
                    if (!hI && z) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_leave_room_txt)).show();
                    }
                    if (aVar != null) {
                        aVar.zH(hI);
                    }
                }
            });
        }
    }

    public synchronized void a(String str, a aVar) {
        a(str, false, aVar);
    }
}
