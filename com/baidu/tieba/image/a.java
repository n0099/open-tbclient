package com.baidu.tieba.image;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.q;
/* loaded from: classes20.dex */
public class a implements ImagePagerAdapter.a {
    private TbPageContext<?> eGu;
    private boolean fhT;
    private DragImageView.d fjH;
    private int kxF = 0;
    private AdvertAppInfo kxG;
    private boolean kxH;
    private com.baidu.tieba.recapp.g kxI;
    private String mForumId;
    private String mPostId;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fhT = false;
        this.kxH = false;
        this.fhT = z;
        this.kxH = z2;
        this.eGu = tbPageContext;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kxG = advertAppInfo;
        this.kxG.page = "PIC_PAGE";
        this.kxF = i;
    }

    public boolean cWG() {
        if (!this.kxH || this.kxG == null) {
            return false;
        }
        return this.kxG.bjv() || this.kxG.bju();
    }

    public String getAdId() {
        if (this.kxG != null) {
            return this.kxG.exc;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View l(ViewGroup viewGroup, int i) {
        if (this.eGu == null || this.kxG == null) {
            return null;
        }
        if (Ek(i)) {
            this.kxI = q.dzO().a(this.eGu, this.kxG.legoCard, 99, this.fhT, this.mForumId, this.mPostId);
            if (this.kxI == null) {
                return null;
            }
            this.kxI.setDragToExitListener(this.fjH);
            View cZt = this.kxI.cZt();
            viewGroup.addView(cZt);
            return cZt;
        }
        return null;
    }

    private boolean Ek(int i) {
        return cWG() && this.kxF != 0 && i == this.kxF;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fjH = dVar;
    }

    public void onDestroy() {
        if (this.kxI != null) {
            this.kxI.onDestroy();
        }
    }

    public void onAdShow() {
        if (this.kxI != null) {
            this.kxI.onAdShow();
        }
    }
}
