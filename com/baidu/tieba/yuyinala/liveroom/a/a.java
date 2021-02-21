package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes11.dex */
public class a implements c {
    private String aOQ;
    private String aOR;
    private boolean aUi;
    private CustomMessageListener bWl;
    private long buN;
    private long goZ;
    private Activity mActivity;
    private b osa;

    public a(Activity activity) {
        this.mActivity = activity;
        XZ();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aUi = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void g(long j, String str, String str2) {
        this.goZ = j;
        this.aOQ = str;
        if (this.aOQ == null) {
            this.aOQ = "";
        }
        this.aOR = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.buN = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void cc(String str, int i) {
        this.osa = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.buN);
        alaLastLiveroomInfo.setLastAnchorUname(this.aOQ);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.goZ));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aOR);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.t(this.mActivity).a(this.osa).a(this.osa.getWebView().getSchemeCallback()).bE(this.goZ).iy(this.aOQ).dH(this.aUi).bF(this.buN).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] XY = gVar.XY();
        for (com.baidu.live.view.web.a aVar : XY) {
            this.osa.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.osa.cd(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.osa != null && this.osa.isShowing() && this.osa.getWebView() != null) {
            this.osa.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.osa != null && this.osa.isShowing() && this.osa.getWebView() != null) {
            this.osa.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.goZ = 0L;
        this.aOQ = "";
        MessageManager.getInstance().unRegisterListener(this.bWl);
        if (this.osa != null) {
            this.osa.Yc();
            if (this.osa.getWebView() != null) {
                this.osa.getWebView().release();
            }
        }
    }

    private void XZ() {
        this.bWl = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.osa != null && a.this.osa.isShowing()) {
                    a.this.osa.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bWl);
    }
}
