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
/* loaded from: classes11.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aDS;
    private com.baidu.live.u.b bRP;
    private String bRQ;
    private ArrayList<d> ieU;
    private ArrayList<AlaLiveInfoData> ieV;
    private g ieX;
    private c ieZ;
    private Context mContext;

    public SdkLivePlayer(Context context) {
        super(context);
        d ba;
        d ba2;
        this.bRQ = "";
        this.aDS = false;
        this.ieZ = new c() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.ieU = new ArrayList<>();
        boolean z = com.baidu.live.ae.a.Qj().buX.aLl;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ba = i.MT().ba(context);
            ba2 = i.MT().ba(context);
        } else if (z) {
            ba = i.MT().bb(context);
            ba2 = i.MT().bb(context);
        } else {
            ba = i.MT().ba(context);
            ba2 = i.MT().ba(context);
        }
        this.ieU.add(ba);
        this.ieU.add(ba2);
        com.baidu.live.u.d MW = i.MT().MW();
        if (MW != null && !MW.Pk()) {
            MW.a(this.ieZ);
        }
        this.ieX = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.ieV;
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cog();
        af(arrayList);
    }

    public void af(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bv bvVar;
        this.ieV = arrayList;
        LinearLayout.LayoutParams cok = cok();
        if (ListUtils.getCount(arrayList) == 2) {
            cok = coj();
        }
        if (arrayList == null || arrayList.size() != 1 || (bvVar = com.baidu.live.ae.a.Qj().bAS) == null || bvVar.aPT == null || ((i = bvVar.aPT.aQL) != 1 && i != 2)) {
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
        this.aDS = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bRQ = d;
            }
            if (this.ieU != null && this.ieU.size() > 0) {
                final d dVar = this.ieU.get(i);
                if (dVar.MS() != null && dVar.MS().getParent() != null) {
                    ((ViewGroup) dVar.MS().getParent()).removeView(dVar.MS());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.ae.a.Qj().buX.clientIP);
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
                dVar.dH(8);
                dVar.MS().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.MS(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.yuyinala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bRP != null) {
                                SdkLivePlayer.this.bRP.cv(((Integer) dVar.MS().getTag(a.f.live_player_id)).intValue());
                            }
                            dVar.dH(0);
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
        hashMap.put("clientIp", com.baidu.live.ae.a.Qj().buX.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Xi() {
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<d> it = this.ieU.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.MS() != null && next.MS().getParent() != null) {
                    ((ViewGroup) next.MS().getParent()).removeView(next.MS());
                }
            }
        }
        removeAllViews();
    }

    public void cog() {
        cM(true);
    }

    @Override // com.baidu.live.u.f
    public void cM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Xi();
        }
        this.bRQ = "";
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<d> it = this.ieU.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                }
            }
        }
        if (this.ieV != null) {
            this.ieV.clear();
        }
        this.aDS = false;
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    @Override // com.baidu.live.u.f
    public void setVideoMode(int i) {
        if (this.ieV != null && this.ieU != null && this.ieV.size() > 0 && this.ieU.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.ieV.size()) {
                    if (this.ieV.get(i3) != null && this.ieU.get(i3) != null) {
                        if (this.ieV.get(i3).screen_direction == 2) {
                            i = 2;
                        }
                        this.ieU.get(i3).setVideoScalingMode(i);
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
        return this.bRQ;
    }

    public void setIPlayerCallBack(com.baidu.live.u.b bVar) {
        this.bRP = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.u.a aVar) {
        if (this.ieX != null) {
            this.ieX.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.ieV = arrayList;
        coi();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.ieV = arrayList;
        coi();
    }

    private void coi() {
        if (this.ieV != null && this.ieU != null && this.ieV.size() > 0 && this.ieU.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.ieV.size(); i2++) {
                if (this.ieV.get(i2) != null && this.ieU.get(i2) != null) {
                    if (this.ieV.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.ieU.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams coj() {
        int bm = com.baidu.live.utils.h.bm(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = bm;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cok() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ieX != null) {
            this.ieX.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ieX != null) {
            this.ieX.abandonAudioFocus();
        }
    }
}
