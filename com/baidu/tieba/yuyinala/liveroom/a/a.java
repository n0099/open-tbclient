package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes10.dex */
public class a implements c {
    private String aLT;
    private String aLU;
    private boolean aRd;
    private CustomMessageListener bSr;
    private long brk;
    private long gmc;
    private Activity mActivity;
    private b ohG;

    public a(Activity activity) {
        this.mActivity = activity;
        Wn();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aRd = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void g(long j, String str, String str2) {
        this.gmc = j;
        this.aLT = str;
        if (this.aLT == null) {
            this.aLT = "";
        }
        this.aLU = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.brk = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void cc(String str, int i) {
        this.ohG = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.brk);
        alaLastLiveroomInfo.setLastAnchorUname(this.aLT);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gmc));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aLU);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.w(this.mActivity).a(this.ohG).a(this.ohG.getWebView().getSchemeCallback()).bA(this.gmc).hY(this.aLT).dz(this.aRd).bB(this.brk).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Wm = gVar.Wm();
        for (com.baidu.live.view.web.a aVar : Wm) {
            this.ohG.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.ohG.aJ(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.ohG != null && this.ohG.isShowing() && this.ohG.getWebView() != null) {
            this.ohG.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.ohG != null && this.ohG.isShowing() && this.ohG.getWebView() != null) {
            this.ohG.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.gmc = 0L;
        this.aLT = "";
        MessageManager.getInstance().unRegisterListener(this.bSr);
        if (this.ohG != null) {
            this.ohG.Wo();
            if (this.ohG.getWebView() != null) {
                this.ohG.getWebView().release();
            }
        }
    }

    private void Wn() {
        this.bSr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.ohG != null && a.this.ohG.isShowing()) {
                    a.this.ohG.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bSr);
    }
}
