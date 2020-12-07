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
    private static c otw;
    private Activity mActivity;
    private HashMap<String, b> otu = new HashMap<>();
    private HashMap<String, List<d>> otv = new HashMap<>();
    private w otx;
    private TbPageContext oty;

    /* loaded from: classes4.dex */
    public interface a {
        void zJ(boolean z);
    }

    public static c eeo() {
        if (otw == null) {
            otw = new c();
            eep();
        }
        return otw;
    }

    public static void eep() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, TbConfig.SERVER_ADDRESS + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b eeq() {
        return a(CZ(), (d) null);
    }

    public b b(d dVar) {
        return a(CZ(), dVar);
    }

    public b WC(String str) {
        return a(str, (d) null);
    }

    public b a(String str, d dVar) {
        return a(str, eeu(), dVar);
    }

    public b a(final String str, String str2, d dVar) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dVar != null) {
            if (this.otv.containsKey(str) && this.otv.get(str) != null) {
                List<d> list = this.otv.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.otv.put(str, arrayList);
            }
        }
        if (this.otu.containsKey(str) && this.otu.get(str) != null) {
            return this.otu.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.otu.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.Df();
                }
            }
        }
        this.otu.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2);
        this.otu.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i, int i2, String str3) {
                List list2 = (List) c.this.otv.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.onError(i, i2, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i2 != -4 && !o.efd().efk()) {
                        if (i == 1) {
                            if (i2 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 2) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Zf();
                            } else if (i2 == 3) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_invite_text)).show();
                                c.this.Zf();
                            } else if (i2 == 4) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_apply_text)).show();
                                c.this.Zf();
                            } else if (i2 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_drops_text)).show();
                                c.this.Zf();
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
                                c.this.Zf();
                            } else if (i2 == 7) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 6) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                c.this.Zf();
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void NN(int i) {
                if (i != 5) {
                    List list2 = (List) c.this.otv.get(str);
                    for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                        d dVar2 = (d) list2.get(i2);
                        if (dVar2 != null) {
                            dVar2.NN(i);
                        }
                    }
                    if (i == 2) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("join_rtc_room_succ_host_4", true);
                    } else if (i == 3) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("join_rtc_room_succ_anchor_7", false);
                    } else if (i == 4) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("join_rtc_room_succ_anchor_7", false);
                    }
                } else if (!o.efd().jt(o.efd().Zc()) && bVar != null) {
                    bVar.edY();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void NO(int i) {
                AlaWheatInfoData jw;
                List list2 = (List) c.this.otv.get(str);
                for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.NO(i);
                    }
                }
                if (i == 2) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_shut_up_text)).show();
                    c.this.eer();
                } else if (i == 3) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_diss_shut_up_text)).show();
                    c.this.eer();
                } else if (i == 1) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_host_kick_off_text)).show();
                    h.eeS().zM(true).zL(true);
                    c.this.eer();
                } else if (i == 7) {
                    h.eeS().zM(true).zL(false);
                    c.this.eer();
                } else if ((i == 4 || i == 5) && (jw = o.efd().jw(o.efd().Zc())) != null && jw.isOpenMike()) {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        HttpMessage httpMessage = new HttpMessage(1031077);
                        httpMessage.addParam("status", i == 4 ? 1 : 0);
                        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        httpMessage.addParam("room_id", c.this.CZ());
                        httpMessage.addParam("live_id", c.this.Ze());
                        httpMessage.addParam("open_rtc_mode", 1);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (currentAccountInfo != null) {
                        try {
                            jSONObject.put("content_type", "sync_audio_speeker_status");
                            jSONObject.put("status", i != 4 ? 0 : 1);
                            jSONObject.put("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                            jSONObject.put("room_id", c.this.CZ());
                            jSONObject.put("live_id", c.this.Ze());
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
            public void Ss() {
                List list2 = (List) c.this.otv.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eer();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.Ss();
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hR(long j) {
                List list2 = (List) c.this.otv.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eer();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.hR(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void hS(long j) {
                List list2 = (List) c.this.otv.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eer();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.hS(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void bL(long j) {
                List list2 = (List) c.this.otv.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eer();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.bL(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void t(long j, boolean z) {
                List list2 = (List) c.this.otv.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.eer();
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
                if (c.this.otx != null && c.this.otx.aKL != null && TextUtils.equals(c.this.otx.aKL.aUh, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.otv.get(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ListUtils.getCount(list2)) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eeI().g(c.this.oty).a(c.this.mActivity, bIMInviteSyncRtcInfo);
                            c.this.eer();
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
                if (c.this.otx != null && c.this.otx.aKL != null && TextUtils.equals(c.this.otx.aKL.aUh, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.otv.get(str);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= ListUtils.getCount(list2)) {
                            c.this.eer();
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
                List list2 = (List) c.this.otv.get(str);
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
                        if (TextUtils.equals("sync_audio_speeker_status", new JSONObject(str3).optString("content_type")) && com.baidu.live.ap.b.YX().jt(com.baidu.live.ap.b.YX().Zc())) {
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
    public void Zf() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            b eeq = eeq();
            if (eeq != null) {
                eeq.edY();
            }
            if (o.efd().jt(o.efd().Zc())) {
                o.efd().zR(false);
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
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(o.efd().Zc(), optString2)) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), String.format(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_reject_invite_text), optString)).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eer() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    public c aC(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public c f(TbPageContext tbPageContext) {
        this.oty = tbPageContext;
        return this;
    }

    public void aO(String str, String str2, String str3) {
        b a2 = eeo().a(str, str2, (d) null);
        if (a2 != null) {
            a2.Wy(str3);
        }
    }

    public void ag(w wVar) {
        if (wVar != null && wVar.aKL != null && wVar.aKL.aUg != null) {
            this.otx = wVar;
            b a2 = eeo().a(wVar.aKL.aUg, (d) null);
            String str = wVar.mLiveInfo.session_info.flvUrl;
            if (eev()) {
                a2.aN(eeo().eet(), TbadkCoreApplication.getCurrentAccountName(), str);
            } else {
                a2.gN(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void ees() {
        b eeq = eeq();
        if (eeq != null) {
            eeq.Df();
        }
    }

    public void onDestroy() {
        ees();
        if (this.otu != null) {
            this.otu.clear();
        }
        if (this.otv != null) {
            this.otv.clear();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eeI().onDestroy();
    }

    public String Ze() {
        if (this.otx == null || this.otx.aKL == null) {
            return null;
        }
        return this.otx.aKL.live_id;
    }

    public String CZ() {
        if (this.otx == null || this.otx.aKL == null) {
            return null;
        }
        return this.otx.aKL.aUg;
    }

    public String getCustomRoomId() {
        if (this.otx == null || this.otx.aKL == null) {
            return null;
        }
        return this.otx.aKL.croom_id;
    }

    public String Zb() {
        if (this.otx == null || this.otx.mLiveInfo == null) {
            return null;
        }
        return this.otx.mLiveInfo.user_uk;
    }

    public String eet() {
        if (this.otx == null || this.otx.aKL == null) {
            return null;
        }
        return this.otx.aKL.aUh;
    }

    public String eeu() {
        if (this.otx == null || this.otx.mLiveInfo == null || this.otx.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.otx.mLiveInfo.mCastIds.chatMCastId;
    }

    private boolean eev() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.otx == null || this.otx.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.otx.mLiveInfo.user_uk)) ? false : true;
    }

    public w Zd() {
        return this.otx;
    }

    public synchronized void a(String str, final boolean z, final a aVar) {
        if (eeq() != null) {
            eeq().a(str, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
                public void B(int i, long j) {
                    boolean hO = c.this.eeq().hO(j);
                    if (!hO && z) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_leave_room_txt)).show();
                    }
                    if (aVar != null) {
                        aVar.zJ(hO);
                    }
                }
            });
        }
    }

    public synchronized void a(String str, a aVar) {
        a(str, false, aVar);
    }
}
