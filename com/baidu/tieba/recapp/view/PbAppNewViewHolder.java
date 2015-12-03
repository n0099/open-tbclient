package com.baidu.tieba.recapp.view;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.data.d;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends PbAppNewBaseViewHolder {
    private final int bbu;
    private final int bbv;
    protected TbImageView dim;
    private final int maxHeight;
    private final int maxWidth;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.dim = (TbImageView) view.findViewById(n.f.recommend_img);
        Resources resources = view.getResources();
        this.bbv = (int) (resources.getDimension(n.d.ds594) - resources.getDimension(n.d.ds20));
        this.bbu = (int) (resources.getDimension(n.d.ds260) - resources.getDimension(n.d.ds10));
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst().getContext()) - TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.d.ds96);
        this.maxHeight = resources.getDimensionPixelSize(n.d.ds321);
    }

    @Override // com.baidu.tieba.recapp.view.PbAppNewBaseViewHolder, com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(com.baidu.tieba.tbadkCore.data.n nVar, int i, boolean z) {
        super.update(nVar, i, z);
        boolean a = a(this.dim, nVar);
        if (!StringUtils.isNull(nVar.aCV()) && m.rh().rn() && a) {
            this.dim.setVisibility(0);
            this.dim.d(nVar.aCV(), z ? 17 : 18, false);
            return;
        }
        this.dim.setVisibility(8);
    }

    private boolean a(TbImageView tbImageView, com.baidu.tieba.tbadkCore.data.n nVar) {
        if (nVar == null || nVar.aCS() == null || nVar.aCS().dzd == null || tbImageView == null) {
            a(tbImageView, this.bbu, this.bbv);
            return true;
        }
        d.a aVar = nVar.aCS().dzd;
        int i = this.maxWidth;
        if (!aVar.UM) {
            a(tbImageView, (this.bbu * i) / this.bbv, i);
            return true;
        }
        int i2 = aVar.height;
        int i3 = aVar.width;
        if (i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.bbu, this.bbv);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.maxHeight) {
            return false;
        }
        a(tbImageView, i4, i);
        return true;
    }

    private void a(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i);
            } else {
                layoutParams.height = i;
                layoutParams.width = i2;
            }
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
