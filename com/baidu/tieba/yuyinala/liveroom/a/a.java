package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes10.dex */
public class a implements c {
    private String aQq;
    private String aQr;
    private boolean aVI;
    private CustomMessageListener bXL;
    private long bwn;
    private long gqI;
    private Activity mActivity;
    private b ouf;

    public a(Activity activity) {
        this.mActivity = activity;
        Yc();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aVI = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void g(long j, String str, String str2) {
        this.gqI = j;
        this.aQq = str;
        if (this.aQq == null) {
            this.aQq = "";
        }
        this.aQr = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.bwn = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void cc(String str, int i) {
        this.ouf = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.bwn);
        alaLastLiveroomInfo.setLastAnchorUname(this.aQq);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gqI));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aQr);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.t(this.mActivity).a(this.ouf).a(this.ouf.getWebView().getSchemeCallback()).bE(this.gqI).iE(this.aQq).dH(this.aVI).bF(this.bwn).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Yb = gVar.Yb();
        for (com.baidu.live.view.web.a aVar : Yb) {
            this.ouf.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.ouf.cd(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.ouf != null && this.ouf.isShowing() && this.ouf.getWebView() != null) {
            this.ouf.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.ouf != null && this.ouf.isShowing() && this.ouf.getWebView() != null) {
            this.ouf.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.gqI = 0L;
        this.aQq = "";
        MessageManager.getInstance().unRegisterListener(this.bXL);
        if (this.ouf != null) {
            this.ouf.Yf();
            if (this.ouf.getWebView() != null) {
                this.ouf.getWebView().release();
            }
        }
    }

    private void Yc() {
        this.bXL = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.ouf != null && a.this.ouf.isShowing()) {
                    a.this.ouf.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bXL);
    }
}
