package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.r;
/* loaded from: classes7.dex */
public class a implements ImagePagerAdapter.a {
    private TbPageContext<?> eSJ;
    private boolean fut;
    private DragImageView.d fwe;
    private int kLD = 0;
    private AdvertAppInfo kLE;
    private boolean kLF;
    private com.baidu.tieba.recapp.h kLG;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fut = false;
        this.kLF = false;
        this.fut = z;
        this.kLF = z2;
        this.eSJ = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kLE = advertAppInfo;
        this.kLE.page = "PIC_PAGE";
        this.kLD = i;
    }

    public boolean cXG() {
        if (!this.kLF || this.kLE == null) {
            return false;
        }
        return this.kLE.bln() || this.kLE.blm();
    }

    public String getAdId() {
        if (this.kLE != null) {
            return this.kLE.eJi;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.eSJ == null || this.kLE == null) {
            return null;
        }
        if (Dl(i)) {
            this.kLG = r.dBe().a(this.eSJ, this.kLE.legoCard, 99, this.fut, this.mForumId, this.mPostId);
            if (this.kLG == null) {
                return null;
            }
            this.kLG.setDragToExitListener(this.fwe);
            View daz = this.kLG.daz();
            viewGroup.addView(daz);
            return daz;
        }
        return null;
    }

    private boolean Dl(int i) {
        return cXG() && this.kLD != 0 && i == this.kLD;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fwe = dVar;
    }

    public void onDestroy() {
        if (this.kLG != null) {
            this.kLG.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kLG != null) {
            this.kLG.onAdShow();
        }
    }
}
