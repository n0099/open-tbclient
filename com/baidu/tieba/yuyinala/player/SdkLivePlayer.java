package com.baidu.tieba.yuyinala.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bm;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.r.c;
import com.baidu.live.r.f;
import com.baidu.live.r.g;
import com.baidu.live.r.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aEQ;
    private com.baidu.live.r.b bET;
    private String bEU;
    private ArrayList<d> hDu;
    private ArrayList<AlaLiveInfoData> hDv;
    private g hDx;
    private c hDz;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d ay;
        d ay2;
        this.bEU = "";
        this.aEQ = false;
        this.hDz = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hDu = new ArrayList<>();
        boolean z = com.baidu.live.z.a.Pq().bmJ.aKA;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ay = i.Ns().ay(context);
            ay2 = i.Ns().ay(context);
        } else if (z) {
            ay = i.Ns().az(context);
            ay2 = i.Ns().az(context);
        } else {
            ay = i.Ns().ay(context);
            ay2 = i.Ns().ay(context);
        }
        this.hDu.add(ay);
        this.hDu.add(ay2);
        com.baidu.live.r.d Nv = i.Ns().Nv();
        if (Nv != null && !Nv.Op()) {
            Nv.a(this.hDz);
        }
        this.hDx = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hDv;
    }

    @Override // com.baidu.live.r.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        ciq();
        ak(arrayList);
    }

    public void ak(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bm bmVar;
        this.hDv = arrayList;
        LinearLayout.LayoutParams ciu = ciu();
        if (ListUtils.getCount(arrayList) == 2) {
            ciu = cit();
        }
        if (arrayList == null || arrayList.size() != 1 || (bmVar = com.baidu.live.z.a.Pq().bsy) == null || bmVar.aOH == null || ((i = bmVar.aOH.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, ciu, i, i2);
            }
        }
        this.aEQ = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bEU = d;
            }
            if (this.hDu != null && this.hDu.size() > 0) {
                final d dVar = this.hDu.get(i);
                if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.z.a.Pq().bmJ.clientIP);
                    jSONObject.put("level", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("sessionLine", 1);
                    dVar.b(i + 1, jSONObject);
                } catch (Exception e) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e);
                    }
                }
                dVar.setPlayerCallback(null);
                dVar.d(this.mContext, Uri.parse(d));
                if ("ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                dVar.setDecodeMode(i2);
                dVar.eQ(8);
                dVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.getPlayerView(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bET != null) {
                                SdkLivePlayer.this.bET.dM(((Integer) dVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            dVar.eQ(0);
                        }
                    }
                });
                dVar.c(Uri.parse(d));
                dVar.start();
                dVar.setVideoScalingMode(i3);
                a(dVar, alaLiveInfoData);
            }
        }
    }

    private void a(d dVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.z.a.Pq().bmJ.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void TS() {
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<d> it = this.hDu.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void ciq() {
        cn(true);
    }

    @Override // com.baidu.live.r.f
    public void cn(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            TS();
        }
        this.bEU = "";
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<d> it = this.hDu.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.hDv != null) {
            this.hDv.clear();
        }
        this.aEQ = false;
    }

    @Override // com.baidu.live.r.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.r.f
    public String getVideoPath() {
        return this.bEU;
    }

    public void setIPlayerCallBack(com.baidu.live.r.b bVar) {
        this.bET = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.r.a aVar) {
        if (this.hDx != null) {
            this.hDx.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hDv = arrayList;
        cis();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hDv = arrayList;
        cis();
    }

    private void cis() {
        if (this.hDv != null && this.hDu != null && this.hDv.size() > 0 && this.hDu.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hDv.size(); i2++) {
                if (this.hDv.get(i2) != null && this.hDu.get(i2) != null) {
                    if (this.hDv.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hDu.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cit() {
        int aC = com.baidu.live.utils.h.aC(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aC;
        return layoutParams;
    }

    private LinearLayout.LayoutParams ciu() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hDx != null) {
            this.hDx.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hDx != null) {
            this.hDx.abandonAudioFocus();
        }
    }
}
