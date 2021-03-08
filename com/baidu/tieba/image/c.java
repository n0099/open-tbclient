package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
/* loaded from: classes7.dex */
public class c implements ImagePagerAdapter.a {
    private DragImageView.d fzT;
    private ViewGroup gmh;
    private boolean kVY;
    private ImageViewerActivity kWa;
    private RelativeLayout mRootView;
    private TbPageContext mTbPageContext;
    private int mCount = 0;
    private int kVW = 0;
    private boolean kWb = false;
    private boolean kWc = false;
    private boolean kWd = false;
    private final a.d kWe = new a.d() { // from class: com.baidu.tieba.image.c.2
        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdClose(String str) {
            if (c.this.kWa != null) {
                c.this.kWa.finish();
            }
        }

        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdShow(String str) {
            c.this.kWb = true;
        }

        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdError(String str) {
            c.this.setAddSize(0);
            c.this.DI(1);
        }

        @Override // com.baidu.tieba.h.a.d, com.baidu.tieba.h.a.c
        public void onAdClicked(String str) {
            c.this.cZW();
        }
    };

    public void cS(int i, int i2) {
        this.kVW = i;
        this.mCount = i2;
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.kWa = imageViewerActivity;
        this.mTbPageContext = imageViewerActivity.getPageContext();
        this.kVY = z;
        this.mRootView = new RelativeLayout(this.kWa);
        this.gmh = com.baidu.tieba.h.a.cNx().g(imageViewerActivity, "6051001774-1519133515");
        if (this.gmh != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kWa), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.mRootView.addView(this.gmh, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.mTbPageContext != null && this.gmh != null && this.kVY && DF(i) && cZT()) {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            viewGroup.addView(this.mRootView);
            return this.mRootView;
        }
        return null;
    }

    public boolean DG(int i) {
        if (this.mTbPageContext == null || this.gmh == null || !this.kVY || this.kWb || !DF(i) || !cZT()) {
            return false;
        }
        com.baidu.tieba.h.a.cNx().a(this.mTbPageContext.getPageActivity(), "6051001774-1519133515", this.gmh, this.kWe);
        ap.setBackgroundColor(this.gmh, R.color.CAM_X0101, 0);
        DI(0);
        return true;
    }

    public boolean cZT() {
        return this.kWc;
    }

    public boolean cZU() {
        return this.kWb;
    }

    public boolean cZV() {
        return this.kVY && this.gmh != null && this.kWc;
    }

    private boolean DF(int i) {
        return this.kVW != 0 && i == this.kVW;
    }

    public boolean U(int i, int i2, int i3) {
        return i == 1;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fzT = dVar;
    }

    public void onDestroy() {
        com.baidu.tieba.h.a.cNx().destroyAd("6051001774-1519133515");
    }

    public void onAdShow() {
    }

    public void setAddSize(int i) {
        if (this.kWa != null) {
            this.kWa.setAddSize(i);
        }
    }

    public void V(int i, int i2, final int i3) {
        if (this.kVY && this.gmh != null && !this.kWd && !this.kWc && U(i, i2, i3)) {
            this.kWd = true;
            com.baidu.tieba.h.a.cNx().a(this.kWa, "6051001774-1519133515", new a.b() { // from class: com.baidu.tieba.image.c.1
                @Override // com.baidu.tieba.h.a.b
                public void aE(String str, int i4) {
                    c.this.kWd = false;
                    c.this.kWc = true;
                    if (com.baidu.tieba.h.a.cNx().isAdReady(str)) {
                        c.this.setAddSize(1);
                        c.this.DG(i3);
                        c.this.DH(0);
                        return;
                    }
                    c.this.setAddSize(0);
                    c.this.DH(1);
                }

                @Override // com.baidu.tieba.h.a.b
                public void onError(String str) {
                    c.this.kWd = false;
                    c.this.setAddSize(0);
                    c.this.DH(1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZW() {
        ar.Bk("c14053").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bsR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DH(int i) {
        ar.Bk("c14005").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).aq("obj_locate", i).bsR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DI(int i) {
        ar.Bk("c14006").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).aq("obj_locate", i).bsR();
    }
}
