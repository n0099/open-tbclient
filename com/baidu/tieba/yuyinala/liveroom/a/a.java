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
    private long goL;
    private Activity mActivity;
    private b orA;

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
        this.goL = j;
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
        this.orA = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.buN);
        alaLastLiveroomInfo.setLastAnchorUname(this.aOQ);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.goL));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aOR);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.t(this.mActivity).a(this.orA).a(this.orA.getWebView().getSchemeCallback()).bE(this.goL).iy(this.aOQ).dH(this.aUi).bF(this.buN).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] XY = gVar.XY();
        for (com.baidu.live.view.web.a aVar : XY) {
            this.orA.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.orA.cd(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.orA != null && this.orA.isShowing() && this.orA.getWebView() != null) {
            this.orA.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.orA != null && this.orA.isShowing() && this.orA.getWebView() != null) {
            this.orA.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.goL = 0L;
        this.aOQ = "";
        MessageManager.getInstance().unRegisterListener(this.bWl);
        if (this.orA != null) {
            this.orA.Yc();
            if (this.orA.getWebView() != null) {
                this.orA.getWebView().release();
            }
        }
    }

    private void XZ() {
        this.bWl = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.orA != null && a.this.orA.isShowing()) {
                    a.this.orA.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bWl);
    }
}
