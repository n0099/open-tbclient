package com.baidu.tieba.yuyinala.liveroom.wheat.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
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
/* loaded from: classes4.dex */
public class c {
    private static c ocT;
    private Activity mActivity;
    private HashMap<String, b> ocR = new HashMap<>();
    private HashMap<String, List<d>> ocS = new HashMap<>();
    private w ocU;
    private TbPageContext ocV;

    /* loaded from: classes4.dex */
    public interface a {
        void yY(boolean z);
    }

    public static c dYL() {
        if (ocT == null) {
            ocT = new c();
            dYM();
        }
        return ocT;
    }

    public static void dYM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, TbConfig.SERVER_ADDRESS + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b dYN() {
        return a(Ca(), (d) null);
    }

    public b b(d dVar) {
        return a(Ca(), dVar);
    }

    public b VC(String str) {
        return a(str, (d) null);
    }

    public b a(String str, d dVar) {
        return a(str, dYR(), dVar);
    }

    public b a(final String str, String str2, d dVar) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dVar != null) {
            if (this.ocS.containsKey(str) && this.ocS.get(str) != null) {
                List<d> list = this.ocS.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.ocS.put(str, arrayList);
            }
        }
        if (this.ocR.containsKey(str) && this.ocR.get(str) != null) {
            return this.ocR.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.ocR.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.Cf();
                }
            }
        }
        this.ocR.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2);
        this.ocR.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i, int i2, String str3) {
                List list2 = (List) c.this.ocS.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.onError(i, i2, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i2 != -4 && !o.dZA().dZH()) {
                        if (i == 1) {
                            if (i2 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 2) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Xp();
                            } else if (i2 == 3) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_invite_text)).show();
                                c.this.Xp();
                            } else if (i2 == 4) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_apply_text)).show();
                                c.this.Xp();
                            } else if (i2 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_drops_text)).show();
                                c.this.Xp();
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
                                c.this.Xp();
                            } else if (i2 == 7) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 6) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Xp();
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void Ms(int i) {
                if (i != 5) {
                    List list2 = (List) c.this.ocS.get(str);
                    for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                        d dVar2 = (d) list2.get(i2);
                        if (dVar2 != null) {
                            dVar2.Ms(i);
                        }
                    }
                    if (i == 2) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_host_4", true);
                    } else if (i == 3) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                    } else if (i == 4) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("join_rtc_room_succ_anchor_7", false);
                    }
                } else if (!o.dZA().iV(o.dZA().Xm()) && bVar != null) {
                    bVar.dYv();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void Mt(int i) {
                AlaWheatInfoData iY;
                List list2 = (List) c.this.ocS.get(str);
                for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.Mt(i);
                    }
                }
                if (i == 2) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_shut_up_text)).show();
                    c.this.dYO();
                } else if (i == 3) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_diss_shut_up_text)).show();
                    c.this.dYO();
                } else if (i == 1) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_kick_off_text)).show();
                    h.dZp().zb(true).za(true);
                    c.this.dYO();
                } else if (i == 7) {
                    h.dZp().zb(true).za(false);
                    c.this.dYO();
                } else if ((i == 4 || i == 5) && (iY = o.dZA().iY(o.dZA().Xm())) != null && iY.isOpenMike()) {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        HttpMessage httpMessage = new HttpMessage(1031077);
                        httpMessage.addParam("status", i == 4 ? 1 : 0);
                        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        httpMessage.addParam("room_id", c.this.Ca());
                        httpMessage.addParam("live_id", c.this.Xo());
                        httpMessage.addParam("open_rtc_mode", 1);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (currentAccountInfo != null) {
                        try {
                            jSONObject.put("content_type", "sync_audio_speeker_status");
                            jSONObject.put("status", i != 4 ? 0 : 1);
                            jSONObject.put("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                            jSONObject.put("room_id", c.this.Ca());
                            jSONObject.put("live_id", c.this.Xo());
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
            public void QD() {
                List list2 = (List) c.this.ocS.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dYO();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.QD();
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hj(long j) {
                List list2 = (List) c.this.ocS.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dYO();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.hj(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hk(long j) {
                List list2 = (List) c.this.ocS.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dYO();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.hk(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void bm(long j) {
                List list2 = (List) c.this.ocS.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dYO();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.bm(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void t(long j, boolean z) {
                List list2 = (List) c.this.ocS.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dYO();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.t(j, z);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void a(BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo) {
                if (c.this.ocU != null && c.this.ocU.aJK != null && TextUtils.equals(c.this.ocU.aJK.aSQ, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.ocS.get(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ListUtils.getCount(list2)) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.c.b.dZf().g(c.this.ocV).a(c.this.mActivity, bIMInviteSyncRtcInfo);
                            c.this.dYO();
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
                if (c.this.ocU != null && c.this.ocU.aJK != null && TextUtils.equals(c.this.ocU.aJK.aSQ, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.ocS.get(str);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= ListUtils.getCount(list2)) {
                            c.this.dYO();
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
            public void r(int i, int i2, String str3) {
                List list2 = (List) c.this.ocS.get(str);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < ListUtils.getCount(list2)) {
                        d dVar2 = (d) list2.get(i4);
                        if (dVar2 != null) {
                            dVar2.r(i, i2, str3);
                        }
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void j(int i, long j, String str3) {
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        if (TextUtils.equals("sync_audio_speeker_status", new JSONObject(str3).optString("content_type")) && com.baidu.live.al.b.Xh().iV(com.baidu.live.al.b.Xh().Xm())) {
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
    public void Xp() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            b dYN = dYN();
            if (dYN != null) {
                dYN.dYv();
            }
            if (o.dZA().iV(o.dZA().Xm())) {
                o.dZA().zg(false);
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
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(o.dZA().Xm(), optString2)) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_reject_invite_text), optString)).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    public c aC(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public c f(TbPageContext tbPageContext) {
        this.ocV = tbPageContext;
        return this;
    }

    public void aL(String str, String str2, String str3) {
        b a2 = dYL().a(str, str2, (d) null);
        if (a2 != null) {
            a2.Vy(str3);
        }
    }

    public void ab(w wVar) {
        if (wVar != null && wVar.aJK != null && wVar.aJK.aSP != null) {
            this.ocU = wVar;
            b a2 = dYL().a(wVar.aJK.aSP, (d) null);
            String str = wVar.mLiveInfo.session_info.flvUrl;
            if (dYS()) {
                a2.aK(dYL().dYQ(), TbadkCoreApplication.getCurrentAccountName(), str);
            } else {
                a2.gI(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void dYP() {
        b dYN = dYN();
        if (dYN != null) {
            dYN.Cf();
        }
    }

    public void onDestroy() {
        dYP();
        if (this.ocR != null) {
            this.ocR.clear();
        }
        if (this.ocS != null) {
            this.ocS.clear();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.b.dZf().onDestroy();
    }

    public String Xo() {
        if (this.ocU == null || this.ocU.aJK == null) {
            return null;
        }
        return this.ocU.aJK.live_id;
    }

    public String Ca() {
        if (this.ocU == null || this.ocU.aJK == null) {
            return null;
        }
        return this.ocU.aJK.aSP;
    }

    public String getCustomRoomId() {
        if (this.ocU == null || this.ocU.aJK == null) {
            return null;
        }
        return this.ocU.aJK.croom_id;
    }

    public String Xl() {
        if (this.ocU == null || this.ocU.mLiveInfo == null) {
            return null;
        }
        return this.ocU.mLiveInfo.user_uk;
    }

    public String dYQ() {
        if (this.ocU == null || this.ocU.aJK == null) {
            return null;
        }
        return this.ocU.aJK.aSQ;
    }

    public String dYR() {
        if (this.ocU == null || this.ocU.mLiveInfo == null || this.ocU.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.ocU.mLiveInfo.mCastIds.chatMCastId;
    }

    private boolean dYS() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.ocU == null || this.ocU.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.ocU.mLiveInfo.user_uk)) ? false : true;
    }

    public w Xn() {
        return this.ocU;
    }

    public synchronized void a(String str, final boolean z, final a aVar) {
        if (dYN() != null) {
            dYN().a(str, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
                public void B(int i, long j) {
                    boolean hg = c.this.dYN().hg(j);
                    if (!hg && z) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_leave_room_txt)).show();
                    }
                    if (aVar != null) {
                        aVar.yY(hg);
                    }
                }
            });
        }
    }

    public synchronized void a(String str, a aVar) {
        a(str, false, aVar);
    }
}
