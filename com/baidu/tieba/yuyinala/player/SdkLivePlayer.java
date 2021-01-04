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
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aGS;
    private com.baidu.live.v.b bSL;
    private String bSM;
    private ArrayList<d> ifh;
    private ArrayList<AlaLiveInfoData> ifi;
    private g ifk;
    private c ifm;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d bb;
        d bb2;
        this.bSM = "";
        this.aGS = false;
        this.ifm = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.ifh = new ArrayList<>();
        boolean z = com.baidu.live.af.a.SE().bwi.aNo;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bb = i.Pq().bb(context);
            bb2 = i.Pq().bb(context);
        } else if (z) {
            bb = i.Pq().bc(context);
            bb2 = i.Pq().bc(context);
        } else {
            bb = i.Pq().bb(context);
            bb2 = i.Pq().bb(context);
        }
        this.ifh.add(bb);
        this.ifh.add(bb2);
        com.baidu.live.v.d Pt = i.Pq().Pt();
        if (Pt != null && !Pt.RD()) {
            Pt.a(this.ifm);
        }
        this.ifk = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.ifi;
    }

    @Override // com.baidu.live.v.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cqZ();
        al(arrayList);
    }

    public void al(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bq bqVar;
        this.ifi = arrayList;
        LinearLayout.LayoutParams crd = crd();
        if (ListUtils.getCount(arrayList) == 2) {
            crd = crc();
        }
        if (arrayList == null || arrayList.size() != 1 || (bqVar = com.baidu.live.af.a.SE().bCb) == null || bqVar.aRI == null || ((i = bqVar.aRI.aSx) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, crd, i, i2);
            }
        }
        this.aGS = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bSM = d;
            }
            if (this.ifh != null && this.ifh.size() > 0) {
                final d dVar = this.ifh.get(i);
                if (dVar.Pp() != null && dVar.Pp().getParent() != null) {
                    ((ViewGroup) dVar.Pp().getParent()).removeView(dVar.Pp());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.af.a.SE().bwi.clientIP);
                    jSONObject.put(MapBundleKey.MapObjKey.OBJ_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
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
                dVar.fh(8);
                dVar.Pp().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.Pp(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bSL != null) {
                                SdkLivePlayer.this.bSL.dY(((Integer) dVar.Pp().getTag(a.f.live_player_id)).intValue());
                            }
                            dVar.fh(0);
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
        hashMap.put("clientIp", com.baidu.live.af.a.SE().bwi.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Zr() {
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<d> it = this.ifh.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.Pp() != null && next.Pp().getParent() != null) {
                    ((ViewGroup) next.Pp().getParent()).removeView(next.Pp());
                }
            }
        }
        removeAllViews();
    }

    public void cqZ() {
        cH(true);
    }

    @Override // com.baidu.live.v.f
    public void cH(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Zr();
        }
        this.bSM = "";
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<d> it = this.ifh.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.ifi != null) {
            this.ifi.clear();
        }
        this.aGS = false;
    }

    @Override // com.baidu.live.v.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.v.f
    public String getVideoPath() {
        return this.bSM;
    }

    public void setIPlayerCallBack(com.baidu.live.v.b bVar) {
        this.bSL = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.v.a aVar) {
        if (this.ifk != null) {
            this.ifk.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.ifi = arrayList;
        crb();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.ifi = arrayList;
        crb();
    }

    private void crb() {
        if (this.ifi != null && this.ifh != null && this.ifi.size() > 0 && this.ifh.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.ifi.size(); i2++) {
                if (this.ifi.get(i2) != null && this.ifh.get(i2) != null) {
                    if (this.ifi.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.ifh.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams crc() {
        int bn = com.baidu.live.utils.h.bn(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = bn;
        return layoutParams;
    }

    private LinearLayout.LayoutParams crd() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ifk != null) {
            this.ifk.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ifk != null) {
            this.ifk.abandonAudioFocus();
        }
    }
}
