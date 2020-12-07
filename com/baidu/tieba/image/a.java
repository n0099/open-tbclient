package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.r;
/* loaded from: classes21.dex */
public class a implements ImagePagerAdapter.a {
    private TbPageContext<?> eNx;
    private boolean fpu;
    private DragImageView.d frg;
    private int kKX = 0;
    private AdvertAppInfo kKY;
    private boolean kKZ;
    private com.baidu.tieba.recapp.h kLa;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fpu = false;
        this.kKZ = false;
        this.fpu = z;
        this.kKZ = z2;
        this.eNx = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kKY = advertAppInfo;
        this.kKY.page = "PIC_PAGE";
        this.kKX = i;
    }

    public boolean dbS() {
        if (!this.kKZ || this.kKY == null) {
            return false;
        }
        return this.kKY.bmF() || this.kKY.bmE();
    }

    public String getAdId() {
        if (this.kKY != null) {
            return this.kKY.eEd;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View l(ViewGroup viewGroup, int i) {
        if (this.eNx == null || this.kKY == null) {
            return null;
        }
        if (EZ(i)) {
            this.kLa = r.dFf().a(this.eNx, this.kKY.legoCard, 99, this.fpu, this.mForumId, this.mPostId);
            if (this.kLa == null) {
                return null;
            }
            this.kLa.setDragToExitListener(this.frg);
            View deE = this.kLa.deE();
            viewGroup.addView(deE);
            return deE;
        }
        return null;
    }

    private boolean EZ(int i) {
        return dbS() && this.kKX != 0 && i == this.kKX;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.frg = dVar;
    }

    public void onDestroy() {
        if (this.kLa != null) {
            this.kLa.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kLa != null) {
            this.kLa.onAdShow();
        }
    }
}
