package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.r;
/* loaded from: classes8.dex */
public class a implements ImagePagerAdapter.a {
    private TbPageContext<?> eUY;
    private boolean fwJ;
    private DragImageView.d fyu;
    private int kTG = 0;
    private AdvertAppInfo kTH;
    private boolean kTI;
    private com.baidu.tieba.recapp.h kTJ;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fwJ = false;
        this.kTI = false;
        this.fwJ = z;
        this.kTI = z2;
        this.eUY = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kTH = advertAppInfo;
        this.kTH.page = "PIC_PAGE";
        this.kTG = i;
    }

    public boolean cZE() {
        if (!this.kTI || this.kTH == null) {
            return false;
        }
        return this.kTH.blF() || this.kTH.blE();
    }

    public String getAdId() {
        if (this.kTH != null) {
            return this.kTH.eLu;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.eUY == null || this.kTH == null) {
            return null;
        }
        if (DC(i)) {
            this.kTJ = r.dDm().a(this.eUY, this.kTH.legoCard, 99, this.fwJ, this.mForumId, this.mPostId);
            if (this.kTJ == null) {
                return null;
            }
            this.kTJ.setDragToExitListener(this.fyu);
            View dcx = this.kTJ.dcx();
            viewGroup.addView(dcx);
            return dcx;
        }
        return null;
    }

    private boolean DC(int i) {
        return cZE() && this.kTG != 0 && i == this.kTG;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fyu = dVar;
    }

    public void onDestroy() {
        if (this.kTJ != null) {
            this.kTJ.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kTJ != null) {
            this.kTJ.onAdShow();
        }
    }
}
