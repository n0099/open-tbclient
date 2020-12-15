package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.w;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout;
/* loaded from: classes4.dex */
public class c extends a {
    private WheatDatingLayout oxA;
    private com.baidu.tieba.yuyinala.liveroom.chooselover.b oxB;

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    View efU() {
        this.oxA = new WheatDatingLayout(this.mActivity);
        this.oxA.setTbPageContext(this.otA);
        return this.oxA;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public ViewGroup efg() {
        return this.oxA;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public AlaWheatInfoData WX(String str) {
        if (this.oxA != null) {
            return this.oxA.jw(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void efV() {
        super.efV();
        this.oxA.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                c.this.oxq = i;
                c.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.ouF : g.ouG);
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void aP(String str, String str2, String str3) {
        super.aP(str, str2, str3);
        if (this.oxA != null && !efl()) {
            this.oxA.aP(str, str2, str3);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void WY(String str) {
        super.WY(str);
        if (this.oxA != null) {
            this.oxA.WY(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void WZ(String str) {
        super.WZ(str);
        if (this.oxA != null) {
            this.oxA.WZ(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void efW() {
        super.efW();
        try {
            if (this.oxA != null) {
                if (BdUtilHelper.isMainThread()) {
                    this.oxA.a(this.oxk, this.oxl, this.oxm, this.bur);
                } else {
                    this.oxA.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.oxA.a(c.this.oxk, c.this.oxl, c.this.oxm, c.this.bur);
                        }
                    });
                }
            }
        } catch (Exception e) {
            Log.i("BaseMode", "notifyWheatData crash : " + BdUtilHelper.isMainThread());
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void an(w wVar) {
        super.an(wVar);
        if (wVar != null && wVar.aKQ != null) {
            if ((wVar.aKQ.getRoomMode() == 0 || wVar.aKQ.getActivityStage() != 2) && this.oxB != null) {
                this.oxB.dismiss();
            }
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
            b(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists(), alaWheatInfoDataWrapper.getXiangqinLists());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void l(w wVar) {
        super.l(wVar);
        if ((wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) && this.oxA != null && this.oxA.getVisibility() != 0) {
            setVisible(true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void En() {
        super.En();
        setVisible(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setMaskBg(boolean z) {
        super.setMaskBg(z);
        if (this.oxA != null) {
            this.oxA.setMaskBg(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setVisible(boolean z) {
        super.setVisible(z);
        if (this.oxA != null) {
            this.oxA.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public int getWheatHeight() {
        if (this.oxA != null) {
            return this.oxA.getWheatHeight();
        }
        return 0;
    }
}
