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
    private long ggl;
    private Activity mActivity;
    private b okx;

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
        this.ggl = j;
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
        this.okx = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.brr);
        alaLastLiveroomInfo.setLastAnchorUname(this.aPR);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.ggl));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aPS);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.x(this.mActivity).a(this.okx).a(this.okx.getWebView().getSchemeCallback()).bA(this.ggl).jq(this.aPR).dA(this.aUy).bB(this.brr).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.okx.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.okx.aH(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.okx != null && this.okx.isShowing() && this.okx.getWebView() != null) {
            this.okx.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.okx != null && this.okx.isShowing() && this.okx.getWebView() != null) {
            this.okx.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.ggl = 0L;
        this.aPR = "";
        MessageManager.getInstance().unRegisterListener(this.bRw);
        if (this.okx != null) {
            this.okx.YQ();
            if (this.okx.getWebView() != null) {
                this.okx.getWebView().release();
            }
        }
    }

    private void YP() {
        this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.okx != null && a.this.okx.isShowing()) {
                    a.this.okx.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bRw);
    }
}
