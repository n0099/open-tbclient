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
/* loaded from: classes8.dex */
public class c implements ImagePagerAdapter.a {
    private DragImageView.d fyu;
    private boolean kTI;
    private ImageViewerActivity kTK;
    private View kTL;
    private RelativeLayout mRootView;
    private TbPageContext mTbPageContext;
    private int mCount = 0;
    private int kTG = 0;
    private boolean kTM = false;
    private boolean kTN = false;
    private final a.f kTO = new a.f() { // from class: com.baidu.tieba.image.c.2
        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.c
        public void onAdClose(String str) {
            if (c.this.kTK != null) {
                c.this.kTK.finish();
            }
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdShow(String str) {
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdError(String str, int i, String str2) {
            c.this.setAddSize(0);
            c.this.DF(1);
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdClicked(String str) {
            c.this.cZG();
        }
    };

    public void cR(int i, int i2) {
        this.kTG = i;
        this.mCount = i2;
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.kTK = imageViewerActivity;
        this.mTbPageContext = imageViewerActivity.getPageContext();
        this.kTI = z;
        this.mRootView = new RelativeLayout(this.kTK);
        this.kTL = com.baidu.tieba.h.a.cNj().g(imageViewerActivity, "6051001643-679358748");
        if (this.kTL != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kTK), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.mRootView.addView(this.kTL, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.mTbPageContext != null && this.kTL != null && this.kTI && DC(i) && cZF()) {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            viewGroup.addView(this.mRootView);
            return this.mRootView;
        }
        return null;
    }

    public boolean DD(int i) {
        if (this.mTbPageContext != null && this.kTL != null && this.kTI && DC(i) && cZF()) {
            com.baidu.tieba.h.a.cNj().a(this.mTbPageContext.getPageActivity(), "6051001643-679358748", this.kTL, this.kTO);
            ap.setBackgroundColor(this.kTL, R.color.CAM_X0101, 0);
            DF(0);
            return true;
        }
        return false;
    }

    public boolean cZF() {
        return this.kTM;
    }

    public boolean cZE() {
        return this.kTI && this.kTL != null && this.kTM;
    }

    private boolean DC(int i) {
        return this.kTG != 0 && i == this.kTG;
    }

    public boolean U(int i, int i2, int i3) {
        return i == 1;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fyu = dVar;
    }

    public void onDestroy() {
        com.baidu.tieba.h.a.cNj().destroyAd("6051001643-679358748");
    }

    public void onAdShow() {
    }

    public void setAddSize(int i) {
        if (this.kTK != null) {
            this.kTK.setAddSize(i);
        }
    }

    public void V(int i, int i2, final int i3) {
        if (this.kTI && this.kTL != null && !this.kTN && !this.kTM && U(i, i2, i3)) {
            this.kTN = true;
            com.baidu.tieba.h.a.cNj().a(this.kTK, "6051001643-679358748", new a.d() { // from class: com.baidu.tieba.image.c.1
                @Override // com.baidu.tieba.h.a.d
                public void bb(String str, int i4) {
                    c.this.kTN = false;
                    c.this.kTM = true;
                    if (com.baidu.tieba.h.a.cNj().isAdReady(str)) {
                        c.this.setAddSize(1);
                        c.this.DD(i3);
                        c.this.DE(0);
                        return;
                    }
                    c.this.setAddSize(0);
                    c.this.DE(1);
                }

                @Override // com.baidu.tieba.h.a.d
                public void onError(String str) {
                    c.this.kTN = false;
                    c.this.kTM = true;
                    c.this.setAddSize(0);
                    c.this.DE(1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZG() {
        ar.Bd("c14053").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bsO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE(int i) {
        ar.Bd("c14005").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).ap("obj_locate", i).bsO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF(int i) {
        ar.Bd("c14006").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).ap("obj_locate", i).bsO();
    }
}
