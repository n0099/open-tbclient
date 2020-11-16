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
    private WheatDatingLayout oiy;

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    View eao() {
        this.oiy = new WheatDatingLayout(this.mActivity);
        this.oiy.setTbPageContext(this.oey);
        return this.oiy;
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
        return this.oiy;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public AlaWheatInfoData VI(String str) {
        if (this.oiy != null) {
            return this.oiy.iS(str);
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
    public void eap() {
        super.eap();
        this.oiy.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.c.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                c.this.oio = i;
                c.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.ofD : g.ofE);
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void aM(String str, String str2, String str3) {
        super.aM(str, str2, str3);
        if (this.oiy != null && !dZG()) {
            this.oiy.aM(str, str2, str3);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void VJ(String str) {
        super.VJ(str);
        if (this.oiy != null) {
            this.oiy.VJ(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void VK(String str) {
        super.VK(str);
        if (this.oiy != null) {
            this.oiy.VK(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void eaq() {
        super.eaq();
        try {
            if (this.oiy != null) {
                if (BdUtilHelper.isMainThread()) {
                    this.oiy.a(this.oii, this.oij, this.oik, this.bph);
                } else {
                    this.oiy.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.oiy.a(c.this.oii, c.this.oij, c.this.oik, c.this.bph);
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
            b(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists(), alaWheatInfoDataWrapper.getXiangqinLists());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void l(w wVar) {
        super.l(wVar);
        if ((wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) && this.oiy != null && this.oiy.getVisibility() != 0) {
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
        if (this.oiy != null) {
            this.oiy.setMaskBg(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setVisible(boolean z) {
        super.setVisible(z);
        if (this.oiy != null) {
            this.oiy.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public int getWheatHeight() {
        if (this.oiy != null) {
            return this.oiy.getWheatHeight();
        }
        return 0;
    }
}
