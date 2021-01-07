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
    private TbPageContext<?> eXu;
    private DragImageView.d fAM;
    private boolean fzb;
    private int kQi = 0;
    private AdvertAppInfo kQj;
    private boolean kQk;
    private com.baidu.tieba.recapp.h kQl;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fzb = false;
        this.kQk = false;
        this.fzb = z;
        this.kQk = z2;
        this.eXu = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kQj = advertAppInfo;
        this.kQj.page = "PIC_PAGE";
        this.kQi = i;
    }

    public boolean dby() {
        if (!this.kQk || this.kQj == null) {
            return false;
        }
        return this.kQj.bph() || this.kQj.bpg();
    }

    public String getAdId() {
        if (this.kQj != null) {
            return this.kQj.eNT;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View p(ViewGroup viewGroup, int i) {
        if (this.eXu == null || this.kQj == null) {
            return null;
        }
        if (ER(i)) {
            this.kQl = r.dEW().a(this.eXu, this.kQj.legoCard, 99, this.fzb, this.mForumId, this.mPostId);
            if (this.kQl == null) {
                return null;
            }
            this.kQl.setDragToExitListener(this.fAM);
            View der = this.kQl.der();
            viewGroup.addView(der);
            return der;
        }
        return null;
    }

    private boolean ER(int i) {
        return dby() && this.kQi != 0 && i == this.kQi;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fAM = dVar;
    }

    public void onDestroy() {
        if (this.kQl != null) {
            this.kQl.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kQl != null) {
            this.kQl.onAdShow();
        }
    }
}
