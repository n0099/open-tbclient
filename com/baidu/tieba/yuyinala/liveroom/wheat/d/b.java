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
    private WheatCommonLayout oiw;

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    View eao() {
        this.oiw = new WheatCommonLayout(this.mActivity);
        this.oiw.setTbPageContext(this.oey);
        return this.oiw;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public ViewGroup dZB() {
        return this.oiw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void eap() {
        super.eap();
        this.oiw.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                b.this.oio = i;
                b.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.ofD : g.ofE);
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public AlaWheatInfoData VI(String str) {
        if (this.oiw != null) {
            return this.oiw.iS(str);
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void aM(String str, String str2, String str3) {
        super.aM(str, str2, str3);
        if (this.oiw != null && !dZG()) {
            this.oiw.aM(str, str2, str3);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void VJ(String str) {
        super.VJ(str);
        if (this.oiw != null) {
            this.oiw.VJ(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void VK(String str) {
        super.VK(str);
        if (this.oiw != null) {
            this.oiw.VK(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void eaq() {
        super.eaq();
        try {
            if (this.oiw != null) {
                if (BdUtilHelper.isMainThread()) {
                    this.oiw.a(this.oii, this.oij, this.bph);
                } else {
                    this.oiw.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oiw.a(b.this.oii, b.this.oij, b.this.bph);
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
    public void ai(w wVar) {
        super.ai(wVar);
        if (wVar != null && wVar.aIe != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aIe;
            E(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void l(w wVar) {
        super.l(wVar);
        if ((wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) && this.oiw != null && this.oiw.getVisibility() != 0) {
            setVisible(true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void CD() {
        super.CD();
        setVisible(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setMaskBg(boolean z) {
        super.setMaskBg(z);
        if (this.oiw != null) {
            this.oiw.setMaskBg(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setVisible(boolean z) {
        super.setVisible(z);
        if (this.oiw != null) {
            this.oiw.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public int getWheatHeight() {
        if (this.oiw != null) {
            return this.oiw.getWheatHeight();
        }
        return 0;
    }
}
