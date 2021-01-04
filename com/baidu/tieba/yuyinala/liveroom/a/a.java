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
    private b oml;

    public a(Activity activity) {
        this.mActivity = activity;
        aaf();
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
        this.oml = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.bvY);
        alaLastLiveroomInfo.setLastAnchorUname(this.aQG);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.gqJ));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aQH);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.w(this.mActivity).a(this.oml).a(this.oml.getWebView().getSchemeCallback()).bA(this.gqJ).jj(this.aQG).dD(this.aVQ).bB(this.bvY).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] aae = gVar.aae();
        for (com.baidu.live.view.web.a aVar : aae) {
            this.oml.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.oml.aJ(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.oml != null && this.oml.isShowing() && this.oml.getWebView() != null) {
            this.oml.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.oml != null && this.oml.isShowing() && this.oml.getWebView() != null) {
            this.oml.getWebView().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.gqJ = 0L;
        this.aQG = "";
        MessageManager.getInstance().unRegisterListener(this.bXd);
        if (this.oml != null) {
            this.oml.aag();
            if (this.oml.getWebView() != null) {
                this.oml.getWebView().release();
            }
        }
    }

    private void aaf() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.oml != null && a.this.oml.isShowing()) {
                    a.this.oml.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bXd);
    }
}
