package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.s;
/* loaded from: classes7.dex */
public class a implements ImagePagerAdapter.a {
    private TbPageContext<?> eWx;
    private boolean fyi;
    private DragImageView.d fzT;
    private int kVW = 0;
    private AdvertAppInfo kVX;
    private boolean kVY;
    private com.baidu.tieba.recapp.i kVZ;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fyi = false;
        this.kVY = false;
        this.fyi = z;
        this.kVY = z2;
        this.eWx = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kVX = advertAppInfo;
        this.kVX.page = "PIC_PAGE";
        this.kVW = i;
    }

    public boolean cZS() {
        if (!this.kVY || this.kVX == null) {
            return false;
        }
        return this.kVX.blH() || this.kVX.blG();
    }

    public String getAdId() {
        if (this.kVX != null) {
            return this.kVX.eMU;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.eWx == null || this.kVX == null) {
            return null;
        }
        if (DF(i)) {
            this.kVZ = s.dDB().a(this.eWx, this.kVX.legoCard, 99, this.fyi, this.mForumId, this.mPostId);
            if (this.kVZ == null) {
                return null;
            }
            this.kVZ.setDragToExitListener(this.fzT);
            View dcN = this.kVZ.dcN();
            viewGroup.addView(dcN);
            return dcN;
        }
        return null;
    }

    private boolean DF(int i) {
        return cZS() && this.kVW != 0 && i == this.kVW;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fzT = dVar;
    }

    public void onDestroy() {
        if (this.kVZ != null) {
            this.kVZ.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kVZ != null) {
            this.kVZ.onAdShow();
        }
    }
}
