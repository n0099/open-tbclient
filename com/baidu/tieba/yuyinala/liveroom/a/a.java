package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes11.dex */
public class a implements c {
    private String aQG;
    private String aQH;
    private boolean aVQ;
    private CustomMessageListener bXd;
    private long bvY;
    private long gqJ;
    private Activity mActivity;
    private b omk;

    public a(Activity activity) {
        this.mActivity = activity;
        aag();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aVQ = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void g(long j, String str, String str2) {
        this.gqJ = j;
        this.aQG = str;
        if (this.aQG == null) {
            this.aQG = "";
        }
        this.aQH = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.bvY = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void cb(String str, int i) {
        this.omk = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.bvY);
        alaLastLiveroomInfo.setLastAnchorUname(this.aQG);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gqJ));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aQH);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.w(this.mActivity).a(this.omk).a(this.omk.getWebView().getSchemeCallback()).bA(this.gqJ).jj(this.aQG).dD(this.aVQ).bB(this.bvY).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] aaf = gVar.aaf();
        for (com.baidu.live.view.web.a aVar : aaf) {
            this.omk.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.omk.aJ(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.omk != null && this.omk.isShowing() && this.omk.getWebView() != null) {
            this.omk.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.omk != null && this.omk.isShowing() && this.omk.getWebView() != null) {
            this.omk.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.gqJ = 0L;
        this.aQG = "";
        MessageManager.getInstance().unRegisterListener(this.bXd);
        if (this.omk != null) {
            this.omk.aah();
            if (this.omk.getWebView() != null) {
                this.omk.getWebView().release();
            }
        }
    }

    private void aag() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.omk != null && a.this.omk.isShowing()) {
                    a.this.omk.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bXd);
    }
}
