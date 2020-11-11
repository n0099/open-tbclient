package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aOD;
    private String aOE;
    private boolean aTh;
    private CustomMessageListener bOa;
    private long bnV;
    private long fYr;
    private Activity mActivity;
    private b nTU;

    public a(Activity activity) {
        this.mActivity = activity;
        WY();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aTh = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fYr = j;
        this.aOD = str;
        if (this.aOD == null) {
            this.aOD = "";
        }
        this.aOE = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.bnV = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void bS(String str, int i) {
        this.nTU = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.bnV);
        alaLastLiveroomInfo.setLastAnchorUname(this.aOD);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fYr));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aOE);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.y(this.mActivity).a(this.nTU).a(this.nTU.WZ().getSchemeCallback()).bc(this.fYr).iS(this.aOD).dk(this.aTh).bd(this.bnV).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.nTU.WZ().addJavascriptInterface(aVar, aVar.getName());
        }
        this.nTU.aH(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.nTU != null && this.nTU.isShowing() && this.nTU.WZ() != null) {
            this.nTU.WZ().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.nTU != null && this.nTU.isShowing() && this.nTU.WZ() != null) {
            this.nTU.WZ().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.fYr = 0L;
        this.aOD = "";
        MessageManager.getInstance().unRegisterListener(this.bOa);
        if (this.nTU != null) {
            this.nTU.Xa();
            if (this.nTU.WZ() != null) {
                this.nTU.WZ().release();
            }
        }
    }

    private void WY() {
        this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.nTU != null && a.this.nTU.isShowing()) {
                    a.this.nTU.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bOa);
    }
}
