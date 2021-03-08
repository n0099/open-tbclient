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
import com.baidu.live.data.bv;
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
/* loaded from: classes10.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aFs;
    private com.baidu.live.u.b bTp;
    private String bTq;
    private ArrayList<d> igR;
    private ArrayList<AlaLiveInfoData> igS;
    private g igU;
    private c igW;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d aZ;
        d aZ2;
        this.bTq = "";
        this.aFs = false;
        this.igW = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.igR = new ArrayList<>();
        boolean z = com.baidu.live.ae.a.Qm().bwx.aML;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            aZ = i.MW().aZ(context);
            aZ2 = i.MW().aZ(context);
        } else if (z) {
            aZ = i.MW().ba(context);
            aZ2 = i.MW().ba(context);
        } else {
            aZ = i.MW().aZ(context);
            aZ2 = i.MW().aZ(context);
        }
        this.igR.add(aZ);
        this.igR.add(aZ2);
        com.baidu.live.u.d MZ = i.MW().MZ();
        if (MZ != null && !MZ.Pn()) {
            MZ.a(this.igW);
        }
        this.igU = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.igS;
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cot();
        af(arrayList);
    }

    public void af(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bv bvVar;
        this.igS = arrayList;
        LinearLayout.LayoutParams cox = cox();
        if (ListUtils.getCount(arrayList) == 2) {
            cox = cow();
        }
        if (arrayList == null || arrayList.size() != 1 || (bvVar = com.baidu.live.ae.a.Qm().bCs) == null || bvVar.aRt == null || ((i = bvVar.aRt.aSl) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, cox, i, i2);
            }
        }
        this.aFs = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bTq = d;
            }
            if (this.igR != null && this.igR.size() > 0) {
                final d dVar = this.igR.get(i);
                if (dVar.MV() != null && dVar.MV().getParent() != null) {
                    ((ViewGroup) dVar.MV().getParent()).removeView(dVar.MV());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.ae.a.Qm().bwx.clientIP);
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
                dVar.dI(8);
                dVar.MV().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.MV(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bTp != null) {
                                SdkLivePlayer.this.bTp.cw(((Integer) dVar.MV().getTag(a.f.live_player_id)).intValue());
                            }
                            dVar.dI(0);
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
        hashMap.put("clientIp", com.baidu.live.ae.a.Qm().bwx.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Xl() {
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<d> it = this.igR.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.MV() != null && next.MV().getParent() != null) {
                    ((ViewGroup) next.MV().getParent()).removeView(next.MV());
                }
            }
        }
        removeAllViews();
    }

    public void cot() {
        cM(true);
    }

    @Override // com.baidu.live.u.f
    public void cM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Xl();
        }
        this.bTq = "";
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<d> it = this.igR.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.igS != null) {
            this.igS.clear();
        }
        this.aFs = false;
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.u.f
    public void setVideoMode(int i) {
        if (this.igS != null && this.igR != null && this.igS.size() > 0 && this.igR.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.igS.size()) {
                    if (this.igS.get(i3) != null && this.igR.get(i3) != null) {
                        if (this.igS.get(i3).screen_direction == 2) {
                            i = 2;
                        }
                        this.igR.get(i3).setVideoScalingMode(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.live.u.f
    public String getVideoPath() {
        return this.bTq;
    }

    public void setIPlayerCallBack(com.baidu.live.u.b bVar) {
        this.bTp = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.u.a aVar) {
        if (this.igU != null) {
            this.igU.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.igS = arrayList;
        cov();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.igS = arrayList;
        cov();
    }

    private void cov() {
        if (this.igS != null && this.igR != null && this.igS.size() > 0 && this.igR.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.igS.size(); i2++) {
                if (this.igS.get(i2) != null && this.igR.get(i2) != null) {
                    if (this.igS.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.igR.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cow() {
        int bl = com.baidu.live.utils.h.bl(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = bl;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cox() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.igU != null) {
            this.igU.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.igU != null) {
            this.igU.abandonAudioFocus();
        }
    }
}
