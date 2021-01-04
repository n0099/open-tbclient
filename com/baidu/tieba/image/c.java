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
/* loaded from: classes8.dex */
public class c implements ImagePagerAdapter.a {
    private DragImageView.d fAM;
    private boolean kQk;
    private ImageViewerActivity kQm;
    private View kQn;
    private RelativeLayout mRootView;
    private TbPageContext mTbPageContext;
    private int mCount = 0;
    private int kQi = 0;
    private boolean kQo = false;
    private boolean kQp = false;
    private final a.f kQq = new a.f() { // from class: com.baidu.tieba.image.c.2
        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.c
        public void onAdClose(String str) {
            if (c.this.kQm != null) {
                c.this.kQm.finish();
            }
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdShow(String str) {
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdError(String str, int i, String str2) {
            c.this.setAddSize(0);
            c.this.ET(1);
        }

        @Override // com.baidu.tieba.h.a.f, com.baidu.tieba.h.a.e
        public void onAdClicked(String str) {
            c.this.dbz();
        }
    };

    public void cU(int i, int i2) {
        this.kQi = i;
        this.mCount = i2;
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.kQm = imageViewerActivity;
        this.mTbPageContext = imageViewerActivity.getPageContext();
        this.kQk = z;
        this.mRootView = new RelativeLayout(this.kQm);
        this.kQn = com.baidu.tieba.h.a.cPm().g(imageViewerActivity, "6051001309-133086300");
        if (this.kQn != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.kQm), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.mRootView.addView(this.kQn, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.mTbPageContext != null && this.kQn != null && this.kQk && ER(i) && dby()) {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            viewGroup.addView(this.mRootView);
            return this.mRootView;
        }
        return null;
    }

    public boolean ES(int i) {
        if (this.mTbPageContext != null && this.kQn != null && this.kQk && ER(i) && dby()) {
            com.baidu.tieba.h.a.cPm().a(this.mTbPageContext.getPageActivity(), "6051001309-133086300", this.kQn, this.kQq);
            ao.setBackgroundColor(this.kQn, R.color.CAM_X0101, 0);
            ET(0);
            return true;
        }
        return false;
    }

    public boolean dby() {
        return this.kQo;
    }

    public boolean dbx() {
        return this.kQk && this.kQn != null && this.kQo;
    }

    private boolean ER(int i) {
        return this.kQi != 0 && i == this.kQi;
    }

    public boolean W(int i, int i2, int i3) {
        return i == 1;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fAM = dVar;
    }

    public void onDestroy() {
        com.baidu.tieba.h.a.cPm().destroyAd("6051001309-133086300");
    }

    public void onAdShow() {
    }

    public void setAddSize(int i) {
        if (this.kQm != null) {
            this.kQm.setAddSize(i);
        }
    }

    public void X(int i, int i2, final int i3) {
        if (this.kQk && this.kQn != null && !this.kQp && !this.kQo && W(i, i2, i3)) {
            this.kQp = true;
            com.baidu.tieba.h.a.cPm().a(this.kQm, "6051001309-133086300", new a.d() { // from class: com.baidu.tieba.image.c.1
                @Override // com.baidu.tieba.h.a.d
                public void a(String str, n nVar) {
                    c.this.kQp = false;
                    c.this.kQo = true;
                    if (com.baidu.tieba.h.a.cPm().isAdReady(str)) {
                        c.this.setAddSize(1);
                        c.this.ES(i3);
                        c.this.Cx(0);
                        return;
                    }
                    c.this.setAddSize(0);
                    c.this.Cx(1);
                }

                @Override // com.baidu.tieba.h.a.d
                public void onError(String str) {
                    c.this.kQp = false;
                    c.this.kQo = true;
                    c.this.setAddSize(0);
                    c.this.Cx(1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbz() {
        aq.BY("c14053").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bwn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cx(int i) {
        aq.BY("c14005").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).an("obj_locate", i).bwn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ET(int i) {
        aq.BY("c14006").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).an("obj_locate", i).bwn();
    }
}
