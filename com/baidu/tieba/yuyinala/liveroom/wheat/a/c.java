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
import com.baidu.tieba.yuyinala.liveroom.wheat.b.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private static c nVC;
    private Activity mActivity;
    private HashMap<String, b> nVA = new HashMap<>();
    private HashMap<String, List<d>> nVB = new HashMap<>();
    private w nVD;
    private TbPageContext nVE;

    /* loaded from: classes4.dex */
    public interface a {
        void yQ(boolean z);
    }

    public static c dVV() {
        if (nVC == null) {
            nVC = new c();
            dVW();
        }
        return nVC;
    }

    public static void dVW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031077, TbConfig.SERVER_ADDRESS + "/ala/audio/live/synchronization");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b dVX() {
        return a(dWa(), (d) null);
    }

    public b b(d dVar) {
        return a(dWa(), dVar);
    }

    public b Vl(String str) {
        return a(str, (d) null);
    }

    public b a(String str, d dVar) {
        return a(str, dWc(), dVar);
    }

    public b a(final String str, String str2, d dVar) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dVar != null) {
            if (this.nVB.containsKey(str) && this.nVB.get(str) != null) {
                List<d> list = this.nVB.get(str);
                if (!list.contains(dVar)) {
                    list.add(dVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                this.nVB.put(str, arrayList);
            }
        }
        if (this.nVA.containsKey(str) && this.nVA.get(str) != null) {
            return this.nVA.get(str);
        }
        Iterator<Map.Entry<String, b>> it = this.nVA.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next != null && (value = next.getValue()) != null) {
                    value.BP();
                }
            }
        }
        this.nVA.clear();
        final b bVar = new b(TbadkCoreApplication.getInst(), str, str2);
        this.nVA.put(str, bVar);
        bVar.a(new e() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void onError(int i, int i2, String str3) {
                List list2 = (List) c.this.nVB.get(str);
                for (int i3 = 0; i3 < ListUtils.getCount(list2); i3++) {
                    d dVar2 = (d) list2.get(i3);
                    if (dVar2 != null) {
                        dVar2.onError(i, i2, str3);
                    }
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if ((str3 == null || !str3.contains("playererror")) && i2 != -4 && !n.dWB().dWO()) {
                        if (i == 1) {
                            if (i2 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 2) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_login_text)).show();
                            } else if (i2 == 3) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_invite_text)).show();
                            } else if (i2 == 4) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_apply_text)).show();
                            } else if (i2 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_drops_text)).show();
                            }
                        } else if (i == 2) {
                            if (i2 == 1) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_invite_text)).show();
                            } else if (i2 == 2) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_accept_text)).show();
                            } else if (i2 == 3) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_accept_invite_text)).show();
                            } else if (i2 == 4 || i2 == 5) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_operation_text)).show();
                            } else if (i2 == 8) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_drops_text)).show();
                            } else if (i2 == 7) {
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_status_text)).show();
                            } else if (i2 == 6) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, false));
                                BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_error_login_text)).show();
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void Mb(int i) {
                if (i != 5) {
                    List list2 = (List) c.this.nVB.get(str);
                    for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                        d dVar2 = (d) list2.get(i2);
                        if (dVar2 != null) {
                            dVar2.Mb(i);
                        }
                    }
                    if (i == 2) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("join_rtc_room_succ_host_4", true);
                    } else if (i == 3) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("join_rtc_room_succ_anchor_7", false);
                    } else if (i == 4) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("join_rtc_room_succ_anchor_7", false);
                    }
                } else if (!n.dWB().iI(n.dWB().UN()) && bVar != null) {
                    bVar.Vi(bVar.getRoomId());
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void Mc(int i) {
                AlaWheatInfoData iL;
                List list2 = (List) c.this.nVB.get(str);
                for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.Mc(i);
                    }
                }
                if (i == 2) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_host_shut_up_text)).show();
                    c.this.dVY();
                } else if (i == 3) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_host_diss_shut_up_text)).show();
                    c.this.dVY();
                } else if (i == 1) {
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_host_kick_off_text)).show();
                    g.dWq().yT(true).yS(true);
                    c.this.dVY();
                } else if (i == 7) {
                    g.dWq().yT(true).yS(false);
                    c.this.dVY();
                } else if ((i == 4 || i == 5) && (iL = n.dWB().iL(n.dWB().UN())) != null && iL.isOpenMike()) {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        HttpMessage httpMessage = new HttpMessage(1031077);
                        httpMessage.addParam("status", i == 4 ? 1 : 0);
                        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                        httpMessage.addParam("room_id", c.this.dWa());
                        httpMessage.addParam("live_id", c.this.UP());
                        httpMessage.addParam("open_rtc_mode", 1);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (currentAccountInfo != null) {
                        try {
                            jSONObject.put("content_type", "sync_audio_speeker_status");
                            jSONObject.put("status", i != 4 ? 0 : 1);
                            jSONObject.put("uk", ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
                            jSONObject.put("room_id", c.this.dWa());
                            jSONObject.put("live_id", c.this.UP());
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
            public void dWe() {
                List list2 = (List) c.this.nVB.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dVY();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.dWe();
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void gN(long j) {
                List list2 = (List) c.this.nVB.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dVY();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.gN(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void gO(long j) {
                List list2 = (List) c.this.nVB.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dVY();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.gO(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void aQ(long j) {
                List list2 = (List) c.this.nVB.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dVY();
                        return;
                    }
                    d dVar2 = (d) list2.get(i2);
                    if (dVar2 != null) {
                        dVar2.aQ(j);
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.e, com.baidu.tieba.yuyinala.liveroom.wheat.a.d
            public void t(long j, boolean z) {
                List list2 = (List) c.this.nVB.get(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ListUtils.getCount(list2)) {
                        c.this.dVY();
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
                if (TextUtils.equals(c.this.nVD.aIS.aRz, bIMInviteSyncRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.nVB.get(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ListUtils.getCount(list2)) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.b.b.dWg().g(c.this.nVE).a(c.this.mActivity, bIMInviteSyncRtcInfo);
                            c.this.dVY();
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
                if (TextUtils.equals(c.this.nVD.aIS.aRz, bIMRtcInfo.getRtcRoomId())) {
                    List list2 = (List) c.this.nVB.get(str);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= ListUtils.getCount(list2)) {
                            c.this.dVY();
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
                List list2 = (List) c.this.nVB.get(str);
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
            public void e(int i, long j, String str3) {
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        if (TextUtils.equals("sync_audio_speeker_status", new JSONObject(str3).optString("content_type")) && com.baidu.live.aj.b.UH().iI(com.baidu.live.aj.b.UH().UN())) {
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
    public void a(BIMRtcInfo bIMRtcInfo, int i) {
        if (i == 3 || i == 2) {
            String rtcExt = bIMRtcInfo.getRtcExt();
            if (!TextUtils.isEmpty(rtcExt)) {
                try {
                    JSONObject jSONObject = new JSONObject(rtcExt);
                    String optString = jSONObject.optString("invited_name");
                    String optString2 = jSONObject.optString("invite_uk");
                    if (TextUtils.equals(jSONObject.optString("type"), "invite") && !TextUtils.isEmpty(optString) && TextUtils.equals(n.dWB().UN(), optString2)) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), String.format(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_reject_invite_text), optString)).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    public c aA(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public c f(TbPageContext tbPageContext) {
        this.nVE = tbPageContext;
        return this;
    }

    public void aK(String str, String str2, String str3) {
        b a2 = dVV().a(str, str2, (d) null);
        if (a2 != null) {
            a2.Vh(str3);
        }
    }

    public void U(w wVar) {
        if (wVar != null && wVar.aIS != null && wVar.aIS.aRy != null) {
            this.nVD = wVar;
            b a2 = dVV().a(wVar.aIS.aRy, (d) null);
            String str = wVar.mLiveInfo.session_info.flvUrl;
            if (dWd()) {
                a2.aJ(dVV().dWb(), TbadkCoreApplication.getCurrentAccountName(), str);
            } else {
                a2.gI(TbadkCoreApplication.getCurrentAccountName(), str);
            }
        }
    }

    public void dVZ() {
        b dVX = dVX();
        if (dVX != null) {
            dVX.BP();
        }
    }

    public void onDestroy() {
        dVZ();
        if (this.nVA != null) {
            this.nVA.clear();
        }
        if (this.nVB != null) {
            this.nVB.clear();
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.b.b.dWg().onDestroy();
    }

    public String UP() {
        if (this.nVD == null || this.nVD.aIS == null) {
            return null;
        }
        return this.nVD.aIS.live_id;
    }

    public String dWa() {
        if (this.nVD == null || this.nVD.aIS == null) {
            return null;
        }
        return this.nVD.aIS.aRy;
    }

    public String getCustomRoomId() {
        if (this.nVD == null || this.nVD.aIS == null) {
            return null;
        }
        return this.nVD.aIS.croom_id;
    }

    public String UM() {
        if (this.nVD == null || this.nVD.mLiveInfo == null) {
            return null;
        }
        return this.nVD.mLiveInfo.user_uk;
    }

    public String dWb() {
        if (this.nVD == null || this.nVD.aIS == null) {
            return null;
        }
        return this.nVD.aIS.aRz;
    }

    public String dWc() {
        if (this.nVD == null || this.nVD.mLiveInfo == null || this.nVD.mLiveInfo.mCastIds == null) {
            return null;
        }
        return this.nVD.mLiveInfo.mCastIds.chatMCastId;
    }

    private boolean dWd() {
        String encryptionUserId;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        return (currentAccountInfo == null || this.nVD == null || this.nVD.mLiveInfo == null || (encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID())) == null || !encryptionUserId.equals(this.nVD.mLiveInfo.user_uk)) ? false : true;
    }

    public w UO() {
        return this.nVD;
    }

    public synchronized void a(String str, final boolean z, final a aVar) {
        if (dVX() != null) {
            dVX().a(str, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.a.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.a.b.a
                public void C(int i, long j) {
                    boolean gK = c.this.dVX().gK(j);
                    if (!gK && z) {
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_sdk_connect_wheat_leave_room_txt)).show();
                    }
                    if (aVar != null) {
                        aVar.yQ(gK);
                    }
                }
            });
        }
    }

    public synchronized void a(String str, a aVar) {
        a(str, false, aVar);
    }
}
