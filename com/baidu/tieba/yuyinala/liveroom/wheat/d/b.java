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
    private WheatCommonLayout ogT;

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    View eap() {
        this.ogT = new WheatCommonLayout(this.mActivity);
        this.ogT.setTbPageContext(this.ocV);
        return this.ogT;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public ViewGroup dZC() {
        return this.ogT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void eaq() {
        super.eaq();
        this.ogT.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                b.this.ogL = i;
                b.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.odZ : g.oea);
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public AlaWheatInfoData VX(String str) {
        if (this.ogT != null) {
            return this.ogT.iY(str);
        }
        return null;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void aM(String str, String str2, String str3) {
        super.aM(str, str2, str3);
        if (this.ogT != null && !dZH()) {
            this.ogT.aM(str, str2, str3);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void VY(String str) {
        super.VY(str);
        if (this.ogT != null) {
            this.ogT.VY(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void VZ(String str) {
        super.VZ(str);
        if (this.ogT != null) {
            this.ogT.VZ(str);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void ear() {
        super.ear();
        try {
            if (this.ogT != null) {
                if (BdUtilHelper.isMainThread()) {
                    this.ogT.a(this.ogF, this.ogG, this.bqS);
                } else {
                    this.ogT.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ogT.a(b.this.ogF, b.this.ogG, b.this.bqS);
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
        if (wVar != null && wVar.aJP != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aJP;
            E(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void l(w wVar) {
        super.l(wVar);
        if ((wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) && this.ogT != null && this.ogT.getVisibility() != 0) {
            setVisible(true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void Dm() {
        super.Dm();
        setVisible(false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setMaskBg(boolean z) {
        super.setMaskBg(z);
        if (this.ogT != null) {
            this.ogT.setMaskBg(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void setVisible(boolean z) {
        super.setVisible(z);
        if (this.ogT != null) {
            this.ogT.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public int getWheatHeight() {
        if (this.ogT != null) {
            return this.ogT.getWheatHeight();
        }
        return 0;
    }
}
