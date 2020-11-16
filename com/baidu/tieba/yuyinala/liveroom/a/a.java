package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aMS;
    private String aMT;
    private boolean aRw;
    private CustomMessageListener bMq;
    private long bmk;
    private long fXY;
    private Activity mActivity;
    private b nVx;

    public a(Activity activity) {
        this.mActivity = activity;
        Wp();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aRw = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fXY = j;
        this.aMS = str;
        if (this.aMS == null) {
            this.aMS = "";
        }
        this.aMT = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.bmk = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void bR(String str, int i) {
        this.nVx = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.bmk);
        alaLastLiveroomInfo.setLastAnchorUname(this.aMS);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fXY));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aMT);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.x(this.mActivity).a(this.nVx).a(this.nVx.Wq().getSchemeCallback()).bc(this.fXY).iM(this.aMS).dm(this.aRw).bd(this.bmk).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.nVx.Wq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.nVx.aG(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.nVx != null && this.nVx.isShowing() && this.nVx.Wq() != null) {
            this.nVx.Wq().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.nVx != null && this.nVx.isShowing() && this.nVx.Wq() != null) {
            this.nVx.Wq().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.fXY = 0L;
        this.aMS = "";
        MessageManager.getInstance().unRegisterListener(this.bMq);
        if (this.nVx != null) {
            this.nVx.Wr();
            if (this.nVx.Wq() != null) {
                this.nVx.Wq().release();
            }
        }
    }

    private void Wp() {
        this.bMq = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.nVx != null && a.this.nVx.isShowing()) {
                    a.this.nVx.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bMq);
    }
}
