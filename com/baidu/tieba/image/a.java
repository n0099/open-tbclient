package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.s;
/* loaded from: classes8.dex */
public class a implements ImagePagerAdapter.a {
    private TbPageContext<?> eUY;
    private boolean fwJ;
    private DragImageView.d fyu;
    private int kTU = 0;
    private AdvertAppInfo kTV;
    private boolean kTW;
    private com.baidu.tieba.recapp.i kTX;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fwJ = false;
        this.kTW = false;
        this.fwJ = z;
        this.kTW = z2;
        this.eUY = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kTV = advertAppInfo;
        this.kTV.page = "PIC_PAGE";
        this.kTU = i;
    }

    public boolean cZL() {
        if (!this.kTW || this.kTV == null) {
            return false;
        }
        return this.kTV.blF() || this.kTV.blE();
    }

    public String getAdId() {
        if (this.kTV != null) {
            return this.kTV.eLt;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.eUY == null || this.kTV == null) {
            return null;
        }
        if (DC(i)) {
            this.kTX = s.dDt().a(this.eUY, this.kTV.legoCard, 99, this.fwJ, this.mForumId, this.mPostId);
            if (this.kTX == null) {
                return null;
            }
            this.kTX.setDragToExitListener(this.fyu);
            View dcE = this.kTX.dcE();
            viewGroup.addView(dcE);
            return dcE;
        }
        return null;
    }

    private boolean DC(int i) {
        return cZL() && this.kTU != 0 && i == this.kTU;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fyu = dVar;
    }

    public void onDestroy() {
        if (this.kTX != null) {
            this.kTX.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kTX != null) {
            this.kTX.onAdShow();
        }
    }
}
