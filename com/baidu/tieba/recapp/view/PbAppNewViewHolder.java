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
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends PbAppNewBaseViewHolder {
    private final int bft;
    private final int bfu;
    protected TbImageView dnT;
    private final int maxHeight;
    private final int maxWidth;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.dnT = (TbImageView) view.findViewById(n.g.recommend_img);
        Resources resources = view.getResources();
        this.bfu = (int) (resources.getDimension(n.e.ds594) - resources.getDimension(n.e.ds20));
        this.bft = (int) (resources.getDimension(n.e.ds260) - resources.getDimension(n.e.ds10));
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst().getContext()) - TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.e.ds96);
        this.maxHeight = resources.getDimensionPixelSize(n.e.ds321);
    }

    @Override // com.baidu.tieba.recapp.view.PbAppNewBaseViewHolder, com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        super.update(qVar, i, z);
        boolean a = a(this.dnT, qVar);
        if (!StringUtils.isNull(qVar.aFi()) && m.qQ().qW() && a) {
            this.dnT.setVisibility(0);
            this.dnT.d(qVar.aFi(), z ? 17 : 18, false);
            return;
        }
        this.dnT.setVisibility(8);
    }

    private boolean a(TbImageView tbImageView, q qVar) {
        if (qVar == null || qVar.aFf() == null || qVar.aFf().dGx == null || tbImageView == null) {
            a(tbImageView, this.bft, this.bfu);
            return true;
        }
        d.a aVar = qVar.aFf().dGx;
        int i = this.maxWidth;
        if (!aVar.Vn) {
            a(tbImageView, (this.bft * i) / this.bfu, i);
            return true;
        }
        int i2 = aVar.height;
        int i3 = aVar.width;
        if (i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.bft, this.bfu);
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
