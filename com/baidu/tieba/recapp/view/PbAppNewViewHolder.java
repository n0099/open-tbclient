package com.baidu.tieba.recapp.view;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.d;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends PbAppNewBaseViewHolder {
    protected TbImageView dCX;
    private final int imageHeight;
    private final int imageWidth;
    private final int maxHeight;
    private final int maxWidth;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.dCX = (TbImageView) view.findViewById(t.g.recommend_img);
        Resources resources = view.getResources();
        this.imageWidth = (int) (resources.getDimension(t.e.ds594) - resources.getDimension(t.e.ds20));
        this.imageHeight = (int) (resources.getDimension(t.e.ds260) - resources.getDimension(t.e.ds10));
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst().getContext()) - TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(t.e.ds96);
        this.maxHeight = Math.max(resources.getDimensionPixelSize(t.e.ds321), (int) ((this.maxWidth * 9.0f) / 16.0f));
    }

    @Override // com.baidu.tieba.recapp.view.PbAppNewBaseViewHolder, com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        super.update(qVar, i, z);
        boolean a = a(this.dCX, qVar);
        if (!StringUtils.isNull(qVar.aMo()) && l.rn().rt() && a) {
            this.dCX.setVisibility(0);
            this.dCX.d(qVar.aMo(), z ? 17 : 18, false);
            return;
        }
        this.dCX.setVisibility(8);
    }

    private boolean a(TbImageView tbImageView, q qVar) {
        if (qVar == null || qVar.aMl() == null || qVar.aMl().dWs == null || tbImageView == null) {
            a(tbImageView, this.imageHeight, this.imageWidth);
            return true;
        }
        d.a aVar = qVar.aMl().dWs;
        int i = this.maxWidth;
        if (!aVar.UY) {
            a(tbImageView, (this.imageHeight * i) / this.imageWidth, i);
            return true;
        }
        int i2 = aVar.height;
        int i3 = aVar.width;
        if (i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.imageHeight, this.imageWidth);
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
