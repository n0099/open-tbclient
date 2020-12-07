package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aPR;
    private String aPS;
    private boolean aUy;
    private CustomMessageListener bRw;
    private long brr;
    private long ggj;
    private Activity mActivity;
    private b okv;

    public a(Activity activity) {
        this.mActivity = activity;
        YP();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aUy = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void f(long j, String str, String str2) {
        this.ggj = j;
        this.aPR = str;
        if (this.aPR == null) {
            this.aPR = "";
        }
        this.aPS = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.brr = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void bU(String str, int i) {
        this.okv = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.brr);
        alaLastLiveroomInfo.setLastAnchorUname(this.aPR);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.ggj));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aPS);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.x(this.mActivity).a(this.okv).a(this.okv.getWebView().getSchemeCallback()).bA(this.ggj).jq(this.aPR).dA(this.aUy).bB(this.brr).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.okv.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.okv.aH(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.okv != null && this.okv.isShowing() && this.okv.getWebView() != null) {
            this.okv.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.okv != null && this.okv.isShowing() && this.okv.getWebView() != null) {
            this.okv.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.ggj = 0L;
        this.aPR = "";
        MessageManager.getInstance().unRegisterListener(this.bRw);
        if (this.okv != null) {
            this.okv.YQ();
            if (this.okv.getWebView() != null) {
                this.okv.getWebView().release();
            }
        }
    }

    private void YP() {
        this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.okv != null && a.this.okv.isShowing()) {
                    a.this.okv.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bRw);
    }
}
