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
    private static c oty;
    private Activity mActivity;
    private TbPageContext otA;
    private HashMap<String, b> otw = new HashMap<>();
    private HashMap<String, List<d>> otx = new HashMap<>();
    private w otz;

    /* loaded from: classes4.dex */
    public interface a {
        void zJ(boolean z);
    }

    public static c eep() {
        if (oty == null) {
            oty = new c();
            eeq();
        }
        return oty;
    }

    public static void eeq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, TbConfig.SERVER_ADDRESS + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b eer() {
        return a(CZ(), (d) null);
    }

    public b b(d dVar) {
        return a(CZ(), dVar);
    }

    public b WC(String str) {
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
            if (this.otx.containsKey(str) && this.otx.get(str) != null) {
                List<d> list = this.otx.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.otx.put(str, arrayList);
            }
        }
        if (this.otw.containsKey(str) && this.otw.get(str) != null) {
            return this.otw.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.otw.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.Df();
                }
            }
        }
        this.otw.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2);
        this.otw.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i, int i2, String str3) {
                List list2 = (List) c.this.otx.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.onError(i, i2, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i2 != -4 && !o.efe().efl()) {
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
                    List list2 = (List) c.this.otx.get(str);
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
                } else if (!o.efe().jt(o.efe().Zc()) && bVar != null) {
                    bVar.edZ();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void NO(int i) {
                AlaWheatInfoData jw;
                List list2 = (List) c.this.otx.get(str);
                for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.NO(i);
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
                    h.eeT().zM(true).zL(true);
                    c.this.ees();
                } else if (i == 7) {
                    h.eeT().zM(true).zL(false);
                    c.this.ees();
                } else if ((i == 4 || i == 5) && (jw = o.efe().jw(o.efe().Zc())) != null && jw.isOpenMike()) {
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
                List list2 = (List) c.this.otx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
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
                List list2 = (List) c.this.otx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
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
                List list2 = (List) c.this.otx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
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
                List list2 = (List) c.this.otx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
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
                List list2 = (List) c.this.otx.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.ees();
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
                if (c.this.otz != null && c.this.otz.aKL != null && TextUtils.equals(c.this.otz.aKL.aUh, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.otx.get(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ListUtils.getCount(list2)) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eeJ().g(c.this.otA).a(c.this.mActivity, bIMInviteSyncRtcInfo);
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
                if (c.this.otz != null && c.this.otz.aKL != null && TextUtils.equals(c.this.otz.aKL.aUh, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.otx.get(str);
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
            public void r(int i, int i2, String str3) {
                List list2 = (List) c.this.otx.get(str);
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
            b eer = eer();
            if (eer != null) {
                eer.edZ();
            }
            if (o.efe().jt(o.efe().Zc())) {
                o.efe().zR(false);
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
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(o.efe().Zc(), optString2)) {
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

    public c aC(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public c f(TbPageContext tbPageContext) {
        this.otA = tbPageContext;
        return this;
    }

    public void aO(String str, String str2, String str3) {
        b a2 = eep().a(str, str2, (d) null);
        if (a2 != null) {
            a2.Wy(str3);
        }
    }

    public void ag(w wVar) {
        if (wVar != null && wVar.aKL != null && wVar.aKL.aUg != null) {
            this.otz = wVar;
            b a2 = eep().a(wVar.aKL.aUg, (d) null);
            String str = wVar.mLiveInfo.session_info.flvUrl;
            if (eew()) {
                a2.aN(eep().eeu(), TbadkCoreApplication.getCurrentAccountName(), str);
            } else {
                a2.gN(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void eet() {
        b eer = eer();
        if (eer != null) {
            eer.Df();
        }
    }

    public void onDestroy() {
        eet();
        if (this.otw != null) {
            this.otw.clear();
        }
        if (this.otx != null) {
            this.otx.clear();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.b.eeJ().onDestroy();
    }

    public String Ze() {
        if (this.otz == null || this.otz.aKL == null) {
            return null;
        }
        return this.otz.aKL.live_id;
    }

    public String CZ() {
        if (this.otz == null || this.otz.aKL == null) {
            return null;
        }
        return this.otz.aKL.aUg;
    }

    public String getCustomRoomId() {
        if (this.otz == null || this.otz.aKL == null) {
            return null;
        }
        return this.otz.aKL.croom_id;
    }

    public String Zb() {
        if (this.otz == null || this.otz.mLiveInfo == null) {
            return null;
        }
        return this.otz.mLiveInfo.user_uk;
    }

    public String eeu() {
        if (this.otz == null || this.otz.aKL == null) {
            return null;
        }
        return this.otz.aKL.aUh;
    }

    public String eev() {
        if (this.otz == null || this.otz.mLiveInfo == null || this.otz.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.otz.mLiveInfo.mCastIds.chatMCastId;
    }

    private boolean eew() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.otz == null || this.otz.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.otz.mLiveInfo.user_uk)) ? false : true;
    }

    public w Zd() {
        return this.otz;
    }

    public synchronized void a(String str, final boolean z, final a aVar) {
        if (eer() != null) {
            eer().a(str, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
                public void B(int i, long j) {
                    boolean hO = c.this.eer().hO(j);
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
