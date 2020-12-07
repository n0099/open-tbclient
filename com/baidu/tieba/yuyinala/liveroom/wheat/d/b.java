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
    private WheatCommonLayout oxw;

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    View efT() {
        this.oxw = new WheatCommonLayout(this.mActivity);
        this.oxw.setTbPageContext(this.oty);
        return this.oxw;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public ViewGroup eff() {
        return this.oxw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void efU() {
        super.efU();
        this.oxw.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                b.this.oxo = i;
                b.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.ouD : g.ouE);
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public AlaWheatInfoData WX(String str) {
        if (this.oxw != null) {
            return this.oxw.jw(str);
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void aP(String str, String str2, String str3) {
        super.aP(str, str2, str3);
        if (this.oxw != null && !efk()) {
            this.oxw.aP(str, str2, str3);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void WY(String str) {
        super.WY(str);
        if (this.oxw != null) {
            this.oxw.WY(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void WZ(String str) {
        super.WZ(str);
        if (this.oxw != null) {
            this.oxw.WZ(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void efV() {
        super.efV();
        try {
            if (this.oxw != null) {
                if (BdUtilHelper.isMainThread()) {
                    this.oxw.a(this.oxi, this.oxj, this.bur);
                } else {
                    this.oxw.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oxw.a(b.this.oxi, b.this.oxj, b.this.bur);
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
        if ((wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) && this.oxw != null && this.oxw.getVisibility() != 0) {
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
        if (this.oxw != null) {
            this.oxw.setMaskBg(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setVisible(boolean z) {
        super.setVisible(z);
        if (this.oxw != null) {
            this.oxw.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public int getWheatHeight() {
        if (this.oxw != null) {
            return this.oxw.getWheatHeight();
        }
        return 0;
    }
}
