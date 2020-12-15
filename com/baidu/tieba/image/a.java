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
    private int kKZ = 0;
    private AdvertAppInfo kLa;
    private boolean kLb;
    private com.baidu.tieba.recapp.h kLc;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fpu = false;
        this.kLb = false;
        this.fpu = z;
        this.kLb = z2;
        this.eNx = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kLa = advertAppInfo;
        this.kLa.page = "PIC_PAGE";
        this.kKZ = i;
    }

    public boolean dbT() {
        if (!this.kLb || this.kLa == null) {
            return false;
        }
        return this.kLa.bmF() || this.kLa.bmE();
    }

    public String getAdId() {
        if (this.kLa != null) {
            return this.kLa.eEd;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View l(ViewGroup viewGroup, int i) {
        if (this.eNx == null || this.kLa == null) {
            return null;
        }
        if (EZ(i)) {
            this.kLc = r.dFg().a(this.eNx, this.kLa.legoCard, 99, this.fpu, this.mForumId, this.mPostId);
            if (this.kLc == null) {
                return null;
            }
            this.kLc.setDragToExitListener(this.frg);
            View deF = this.kLc.deF();
            viewGroup.addView(deF);
            return deF;
        }
        return null;
    }

    private boolean EZ(int i) {
        return dbT() && this.kKZ != 0 && i == this.kKZ;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.frg = dVar;
    }

    public void onDestroy() {
        if (this.kLc != null) {
            this.kLc.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kLc != null) {
            this.kLc.onAdShow();
        }
    }
}
