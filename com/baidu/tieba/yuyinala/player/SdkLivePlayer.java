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
import com.baidu.live.data.bn;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.s.c;
import com.baidu.live.s.f;
import com.baidu.live.s.g;
import com.baidu.live.s.h;
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
    private boolean aFG;
    private String bKA;
    private com.baidu.live.s.b bKz;
    private ArrayList<d> hJr;
    private ArrayList<AlaLiveInfoData> hJs;
    private g hJu;
    private c hJw;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d ay;
        d ay2;
        this.bKA = "";
        this.aFG = false;
        this.hJw = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hJr = new ArrayList<>();
        boolean z = com.baidu.live.aa.a.PQ().bod.aLA;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ay = i.NS().ay(context);
            ay2 = i.NS().ay(context);
        } else if (z) {
            ay = i.NS().az(context);
            ay2 = i.NS().az(context);
        } else {
            ay = i.NS().ay(context);
            ay2 = i.NS().ay(context);
        }
        this.hJr.add(ay);
        this.hJr.add(ay2);
        com.baidu.live.s.d NV = i.NS().NV();
        if (NV != null && !NV.OP()) {
            NV.a(this.hJw);
        }
        this.hJu = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hJs;
    }

    @Override // com.baidu.live.s.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        ckS();
        ak(arrayList);
    }

    public void ak(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bn bnVar;
        this.hJs = arrayList;
        LinearLayout.LayoutParams ckW = ckW();
        if (ListUtils.getCount(arrayList) == 2) {
            ckW = ckV();
        }
        if (arrayList == null || arrayList.size() != 1 || (bnVar = com.baidu.live.aa.a.PQ().btT) == null || bnVar.aPE == null || ((i = bnVar.aPE.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, ckW, i, i2);
            }
        }
        this.aFG = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bKA = d;
            }
            if (this.hJr != null && this.hJr.size() > 0) {
                final d dVar = this.hJr.get(i);
                if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.aa.a.PQ().bod.clientIP);
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
                dVar.getPlayerView().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.getPlayerView(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bKz != null) {
                                SdkLivePlayer.this.bKz.dM(((Integer) dVar.getPlayerView().getTag(a.f.live_player_id)).intValue());
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
        hashMap.put("clientIp", com.baidu.live.aa.a.PQ().bod.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Ws() {
        if (!ListUtils.isEmpty(this.hJr)) {
            Iterator<d> it = this.hJr.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void ckS() {
        co(true);
    }

    @Override // com.baidu.live.s.f
    public void co(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Ws();
        }
        this.bKA = "";
        if (!ListUtils.isEmpty(this.hJr)) {
            Iterator<d> it = this.hJr.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.hJs != null) {
            this.hJs.clear();
        }
        this.aFG = false;
    }

    @Override // com.baidu.live.s.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.s.f
    public String getVideoPath() {
        return this.bKA;
    }

    public void setIPlayerCallBack(com.baidu.live.s.b bVar) {
        this.bKz = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.s.a aVar) {
        if (this.hJu != null) {
            this.hJu.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hJs = arrayList;
        ckU();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hJs = arrayList;
        ckU();
    }

    private void ckU() {
        if (this.hJs != null && this.hJr != null && this.hJs.size() > 0 && this.hJr.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hJs.size(); i2++) {
                if (this.hJs.get(i2) != null && this.hJr.get(i2) != null) {
                    if (this.hJs.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hJr.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams ckV() {
        int aD = com.baidu.live.utils.h.aD(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aD;
        return layoutParams;
    }

    private LinearLayout.LayoutParams ckW() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hJu != null) {
            this.hJu.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hJu != null) {
            this.hJu.abandonAudioFocus();
        }
    }
}
