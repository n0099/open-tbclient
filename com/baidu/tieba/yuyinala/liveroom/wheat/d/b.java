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
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout;
/* loaded from: classes4.dex */
public class b extends a {
    private WheatCommonLayout oxy;

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    View efU() {
        this.oxy = new WheatCommonLayout(this.mActivity);
        this.oxy.setTbPageContext(this.otA);
        return this.oxy;
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
        return this.oxy;
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
        this.oxy.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                b.this.oxq = i;
                b.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.ouF : g.ouG);
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public AlaWheatInfoData WX(String str) {
        if (this.oxy != null) {
            return this.oxy.jw(str);
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void aP(String str, String str2, String str3) {
        super.aP(str, str2, str3);
        if (this.oxy != null && !efl()) {
            this.oxy.aP(str, str2, str3);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void WY(String str) {
        super.WY(str);
        if (this.oxy != null) {
            this.oxy.WY(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void WZ(String str) {
        super.WZ(str);
        if (this.oxy != null) {
            this.oxy.WZ(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void efW() {
        super.efW();
        try {
            if (this.oxy != null) {
                if (BdUtilHelper.isMainThread()) {
                    this.oxy.a(this.oxk, this.oxl, this.bur);
                } else {
                    this.oxy.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oxy.a(b.this.oxk, b.this.oxl, b.this.bur);
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
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
            E(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void l(w wVar) {
        super.l(wVar);
        if ((wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) && this.oxy != null && this.oxy.getVisibility() != 0) {
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
        if (this.oxy != null) {
            this.oxy.setMaskBg(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setVisible(boolean z) {
        super.setVisible(z);
        if (this.oxy != null) {
            this.oxy.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public int getWheatHeight() {
        if (this.oxy != null) {
            return this.oxy.getWheatHeight();
        }
        return 0;
    }
}
