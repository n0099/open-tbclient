package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a implements c {
    private String aNA;
    private String aNB;
    private boolean aRP;
    private CustomMessageListener bIu;
    private long bmB;
    private long fSB;
    private Activity mActivity;
    private b nNY;

    public a(Activity activity) {
        this.mActivity = activity;
        Uy();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setHost(boolean z) {
        this.aRP = z;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void e(long j, String str, String str2) {
        this.fSB = j;
        this.aNA = str;
        if (this.aNA == null) {
            this.aNA = "";
        }
        this.aNB = str2;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void setLiveId(long j) {
        this.bmB = j;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void bQ(String str, int i) {
        this.nNY = new b(this.mActivity);
        g gVar = new g();
        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
        alaLastLiveroomInfo.setLastLiveId(this.bmB);
        alaLastLiveroomInfo.setLastAnchorUname(this.aNA);
        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fSB));
        alaLastLiveroomInfo.setLastAnchorPortrait(this.aNB);
        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HALF_WEBVIEW);
        alaLastLiveroomInfo.setIsAudio(1);
        gVar.x(this.mActivity).a(this.nNY).a(this.nNY.Uz().getSchemeCallback()).aG(this.fSB).iF(this.aNA).dd(this.aRP).aH(this.bmB).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.nNY.Uz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.nNY.aF(str, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void resume() {
        if (this.nNY != null && this.nNY.isShowing() && this.nNY.Uz() != null) {
            this.nNY.Uz().onResume();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void pause() {
        if (this.nNY != null && this.nNY.isShowing() && this.nNY.Uz() != null) {
            this.nNY.Uz().onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a.c
    public void release() {
        this.fSB = 0L;
        this.aNA = "";
        MessageManager.getInstance().unRegisterListener(this.bIu);
        if (this.nNY != null) {
            this.nNY.UA();
            if (this.nNY.Uz() != null) {
                this.nNY.Uz().release();
            }
        }
    }

    private void Uy() {
        this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.nNY != null && a.this.nNY.isShowing()) {
                    a.this.nNY.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bIu);
    }
}
