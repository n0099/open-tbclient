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
import com.baidu.live.data.bq;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.v.c;
import com.baidu.live.v.f;
import com.baidu.live.v.g;
import com.baidu.live.v.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aCf;
    private com.baidu.live.v.b bNZ;
    private String bOa;
    private c iaB;
    private ArrayList<d> iaw;
    private ArrayList<AlaLiveInfoData> iax;
    private g iaz;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d ba;
        d ba2;
        this.bOa = "";
        this.aCf = false;
        this.iaB = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.iaw = new ArrayList<>();
        boolean z = com.baidu.live.af.a.OJ().bru.aIB;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ba = i.Lv().ba(context);
            ba2 = i.Lv().ba(context);
        } else if (z) {
            ba = i.Lv().bb(context);
            ba2 = i.Lv().bb(context);
        } else {
            ba = i.Lv().ba(context);
            ba2 = i.Lv().ba(context);
        }
        this.iaw.add(ba);
        this.iaw.add(ba2);
        com.baidu.live.v.d Ly = i.Lv().Ly();
        if (Ly != null && !Ly.NI()) {
            Ly.a(this.iaB);
        }
        this.iaz = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.iax;
    }

    @Override // com.baidu.live.v.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cni();
        ag(arrayList);
    }

    public void ag(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bq bqVar;
        this.iax = arrayList;
        LinearLayout.LayoutParams cnm = cnm();
        if (ListUtils.getCount(arrayList) == 2) {
            cnm = cnl();
        }
        if (arrayList == null || arrayList.size() != 1 || (bqVar = com.baidu.live.af.a.OJ().bxp) == null || bqVar.aMV == null || ((i = bqVar.aMV.aNK) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, cnm, i, i2);
            }
        }
        this.aCf = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bOa = d;
            }
            if (this.iaw != null && this.iaw.size() > 0) {
                final d dVar = this.iaw.get(i);
                if (dVar.Lu() != null && dVar.Lu().getParent() != null) {
                    ((ViewGroup) dVar.Lu().getParent()).removeView(dVar.Lu());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.af.a.OJ().bru.clientIP);
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
                dVar.dB(8);
                dVar.Lu().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.Lu(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bNZ != null) {
                                SdkLivePlayer.this.bNZ.cs(((Integer) dVar.Lu().getTag(a.f.live_player_id)).intValue());
                            }
                            dVar.dB(0);
                        }
                    }
                });
                dVar.e(Uri.parse(d));
                dVar.start();
                dVar.setVideoScalingMode(i3);
                a(dVar, alaLiveInfoData);
            }
        }
    }

    private void a(d dVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.af.a.OJ().bru.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Vz() {
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<d> it = this.iaw.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.Lu() != null && next.Lu().getParent() != null) {
                    ((ViewGroup) next.Lu().getParent()).removeView(next.Lu());
                }
            }
        }
        removeAllViews();
    }

    public void cni() {
        cD(true);
    }

    @Override // com.baidu.live.v.f
    public void cD(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Vz();
        }
        this.bOa = "";
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<d> it = this.iaw.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.iax != null) {
            this.iax.clear();
        }
        this.aCf = false;
    }

    @Override // com.baidu.live.v.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.v.f
    public String getVideoPath() {
        return this.bOa;
    }

    public void setIPlayerCallBack(com.baidu.live.v.b bVar) {
        this.bNZ = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.v.a aVar) {
        if (this.iaz != null) {
            this.iaz.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.iax = arrayList;
        cnk();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.iax = arrayList;
        cnk();
    }

    private void cnk() {
        if (this.iax != null && this.iaw != null && this.iax.size() > 0 && this.iaw.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.iax.size(); i2++) {
                if (this.iax.get(i2) != null && this.iaw.get(i2) != null) {
                    if (this.iax.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.iaw.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cnl() {
        int bm = com.baidu.live.utils.h.bm(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = bm;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cnm() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.iaz != null) {
            this.iaz.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iaz != null) {
            this.iaz.abandonAudioFocus();
        }
    }
}
