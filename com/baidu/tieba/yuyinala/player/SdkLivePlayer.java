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
    private boolean aDV;
    private com.baidu.live.s.b bIO;
    private String bIP;
    private ArrayList<d> hIY;
    private ArrayList<AlaLiveInfoData> hIZ;
    private g hJb;
    private c hJd;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d ay;
        d ay2;
        this.bIP = "";
        this.aDV = false;
        this.hJd = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hIY = new ArrayList<>();
        boolean z = com.baidu.live.aa.a.Ph().bms.aJP;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ay = i.Nj().ay(context);
            ay2 = i.Nj().ay(context);
        } else if (z) {
            ay = i.Nj().az(context);
            ay2 = i.Nj().az(context);
        } else {
            ay = i.Nj().ay(context);
            ay2 = i.Nj().ay(context);
        }
        this.hIY.add(ay);
        this.hIY.add(ay2);
        com.baidu.live.s.d Nm = i.Nj().Nm();
        if (Nm != null && !Nm.Og()) {
            Nm.a(this.hJd);
        }
        this.hJb = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hIZ;
    }

    @Override // com.baidu.live.s.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        ckl();
        ak(arrayList);
    }

    public void ak(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bn bnVar;
        this.hIZ = arrayList;
        LinearLayout.LayoutParams ckp = ckp();
        if (ListUtils.getCount(arrayList) == 2) {
            ckp = cko();
        }
        if (arrayList == null || arrayList.size() != 1 || (bnVar = com.baidu.live.aa.a.Ph().bsh) == null || bnVar.aNT == null || ((i = bnVar.aNT.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, ckp, i, i2);
            }
        }
        this.aDV = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bIP = d;
            }
            if (this.hIY != null && this.hIY.size() > 0) {
                final d dVar = this.hIY.get(i);
                if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.aa.a.Ph().bms.clientIP);
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
                dVar.eM(8);
                dVar.getPlayerView().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.getPlayerView(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bIO != null) {
                                SdkLivePlayer.this.bIO.dI(((Integer) dVar.getPlayerView().getTag(a.f.live_player_id)).intValue());
                            }
                            dVar.eM(0);
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
        hashMap.put("clientIp", com.baidu.live.aa.a.Ph().bms.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void VJ() {
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<d> it = this.hIY.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void ckl() {
        cq(true);
    }

    @Override // com.baidu.live.s.f
    public void cq(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            VJ();
        }
        this.bIP = "";
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<d> it = this.hIY.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.hIZ != null) {
            this.hIZ.clear();
        }
        this.aDV = false;
    }

    @Override // com.baidu.live.s.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.s.f
    public String getVideoPath() {
        return this.bIP;
    }

    public void setIPlayerCallBack(com.baidu.live.s.b bVar) {
        this.bIO = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.s.a aVar) {
        if (this.hJb != null) {
            this.hJb.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hIZ = arrayList;
        ckn();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hIZ = arrayList;
        ckn();
    }

    private void ckn() {
        if (this.hIZ != null && this.hIY != null && this.hIZ.size() > 0 && this.hIY.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hIZ.size(); i2++) {
                if (this.hIZ.get(i2) != null && this.hIY.get(i2) != null) {
                    if (this.hIZ.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hIY.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cko() {
        int aD = com.baidu.live.utils.h.aD(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aD;
        return layoutParams;
    }

    private LinearLayout.LayoutParams ckp() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hJb != null) {
            this.hJb.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hJb != null) {
            this.hJb.abandonAudioFocus();
        }
    }
}
