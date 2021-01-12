package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes7.dex */
public class c implements ImagePagerAdapter.a {
    private DragImageView.d fwe;
    private boolean kLF;
    private ImageViewerActivity kLH;
    private View kLI;
    private RelativeLayout mRootView;
    private TbPageContext mTbPageContext;
    private int mCount = 0;
    private int kLD = 0;
    private boolean kLJ = false;
    private boolean kLK = false;
    private final a.f kLL = new a.f() { // from class: com.baidu.tieba.image.c.2
        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.c
        public void onAdClose(String str) {
            if (c.this.kLH != null) {
                c.this.kLH.finish();
            }
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdShow(String str) {
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdError(String str, int i, String str2) {
            c.this.setAddSize(0);
            c.this.Dn(1);
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdClicked(String str) {
            c.this.cXI();
        }
    };

    public void cU(int i, int i2) {
        this.kLD = i;
        this.mCount = i2;
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.kLH = imageViewerActivity;
        this.mTbPageContext = imageViewerActivity.getPageContext();
        this.kLF = z;
        this.mRootView = new RelativeLayout(this.kLH);
        this.kLI = com.baidu.tieba.h.a.cLv().g(imageViewerActivity, "6051001536-500920287");
        if (this.kLI != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kLH), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.mRootView.addView(this.kLI, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.mTbPageContext != null && this.kLI != null && this.kLF && Dl(i) && cXH()) {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            viewGroup.addView(this.mRootView);
            return this.mRootView;
        }
        return null;
    }

    public boolean Dm(int i) {
        if (this.mTbPageContext != null && this.kLI != null && this.kLF && Dl(i) && cXH()) {
            com.baidu.tieba.h.a.cLv().a(this.mTbPageContext.getPageActivity(), "6051001536-500920287", this.kLI, this.kLL);
            ao.setBackgroundColor(this.kLI, R.color.CAM_X0101, 0);
            Dn(0);
            return true;
        }
        return false;
    }

    public boolean cXH() {
        return this.kLJ;
    }

    public boolean cXG() {
        return this.kLF && this.kLI != null && this.kLJ;
    }

    private boolean Dl(int i) {
        return this.kLD != 0 && i == this.kLD;
    }

    public boolean W(int i, int i2, int i3) {
        return i == 1;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fwe = dVar;
    }

    public void onDestroy() {
        com.baidu.tieba.h.a.cLv().destroyAd("6051001536-500920287");
    }

    public void onAdShow() {
    }

    public void setAddSize(int i) {
        if (this.kLH != null) {
            this.kLH.setAddSize(i);
        }
    }

    public void X(int i, int i2, final int i3) {
        if (this.kLF && this.kLI != null && !this.kLK && !this.kLJ && W(i, i2, i3)) {
            this.kLK = true;
            com.baidu.tieba.h.a.cLv().a(this.kLH, "6051001536-500920287", new a.d() { // from class: com.baidu.tieba.image.c.1
                @Override // com.baidu.tieba.h.a.d
                public void a(String str, n nVar) {
                    c.this.kLK = false;
                    c.this.kLJ = true;
                    if (com.baidu.tieba.h.a.cLv().isAdReady(str)) {
                        c.this.setAddSize(1);
                        c.this.Dm(i3);
                        c.this.AR(0);
                        return;
                    }
                    c.this.setAddSize(0);
                    c.this.AR(1);
                }

                @Override // com.baidu.tieba.h.a.d
                public void onError(String str) {
                    c.this.kLK = false;
                    c.this.kLJ = true;
                    c.this.setAddSize(0);
                    c.this.AR(1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXI() {
        aq.AM("c14053").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bsu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR(int i) {
        aq.AM("c14005").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).an("obj_locate", i).bsu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn(int i) {
        aq.AM("c14006").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).an("obj_locate", i).bsu();
    }
}
