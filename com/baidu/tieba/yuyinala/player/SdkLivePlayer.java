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
import com.baidu.live.data.bo;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.u.c;
import com.baidu.live.u.f;
import com.baidu.live.u.g;
import com.baidu.live.u.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aGB;
    private com.baidu.live.u.b bNW;
    private String bNX;
    private ArrayList<d> hSF;
    private ArrayList<AlaLiveInfoData> hSG;
    private g hSI;
    private c hSK;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d bc;
        d bc2;
        this.bNX = "";
        this.aGB = false;
        this.hSK = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hSF = new ArrayList<>();
        boolean z = com.baidu.live.ae.a.RB().brA.aMK;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bc = i.PB().bc(context);
            bc2 = i.PB().bc(context);
        } else if (z) {
            bc = i.PB().bd(context);
            bc2 = i.PB().bd(context);
        } else {
            bc = i.PB().bc(context);
            bc2 = i.PB().bc(context);
        }
        this.hSF.add(bc);
        this.hSF.add(bc2);
        com.baidu.live.u.d PE = i.PB().PE();
        if (PE != null && !PE.Qz()) {
            PE.a(this.hSK);
        }
        this.hSI = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hSG;
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cog();
        al(arrayList);
    }

    public void al(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bo boVar;
        this.hSG = arrayList;
        LinearLayout.LayoutParams cok = cok();
        if (ListUtils.getCount(arrayList) == 2) {
            cok = coj();
        }
        if (arrayList == null || arrayList.size() != 1 || (boVar = com.baidu.live.ae.a.RB().bxq) == null || boVar.aQT == null || ((i = boVar.aQT.aRI) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, cok, i, i2);
            }
        }
        this.aGB = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bNX = d;
            }
            if (this.hSF != null && this.hSF.size() > 0) {
                final d dVar = this.hSF.get(i);
                if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.ae.a.RB().brA.clientIP);
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
                dVar.fj(8);
                dVar.getPlayerView().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.getPlayerView(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bNW != null) {
                                SdkLivePlayer.this.bNW.eb(((Integer) dVar.getPlayerView().getTag(a.f.live_player_id)).intValue());
                            }
                            dVar.fj(0);
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
        hashMap.put("clientIp", com.baidu.live.ae.a.RB().brA.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Yj() {
        if (!ListUtils.isEmpty(this.hSF)) {
            Iterator<d> it = this.hSF.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void cog() {
        cE(true);
    }

    @Override // com.baidu.live.u.f
    public void cE(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Yj();
        }
        this.bNX = "";
        if (!ListUtils.isEmpty(this.hSF)) {
            Iterator<d> it = this.hSF.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.hSG != null) {
            this.hSG.clear();
        }
        this.aGB = false;
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.u.f
    public String getVideoPath() {
        return this.bNX;
    }

    public void setIPlayerCallBack(com.baidu.live.u.b bVar) {
        this.bNW = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.u.a aVar) {
        if (this.hSI != null) {
            this.hSI.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hSG = arrayList;
        coi();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hSG = arrayList;
        coi();
    }

    private void coi() {
        if (this.hSG != null && this.hSF != null && this.hSG.size() > 0 && this.hSF.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hSG.size(); i2++) {
                if (this.hSG.get(i2) != null && this.hSF.get(i2) != null) {
                    if (this.hSG.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hSF.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams coj() {
        int bh = com.baidu.live.utils.h.bh(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = bh;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cok() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hSI != null) {
            this.hSI.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hSI != null) {
            this.hSI.abandonAudioFocus();
        }
    }
}
