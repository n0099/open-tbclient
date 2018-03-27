package com.baidu.tieba.pb.pb.main;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.widget.richText.a {
    private static double fKK = 0.5d;

    public b(com.baidu.tbadk.widget.richText.a aVar) {
        super(aVar);
        cM(true);
        Rh();
        setLineSpacing(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds15), 1.0f);
        iP(0);
        iQ(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        iR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        aR(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        aS(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds30), com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds10));
        iS(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds14));
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.pb.pb.main.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mx().gP(com.baidu.adp.lib.f.c.nm().g(tbImageView.getUrl(), b.this.mIsFromCDN ? 17 : 18));
                    if (gP != null) {
                        i2 = gP.getWidth();
                        i = gP.getHeight();
                    } else {
                        i = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        if (i2 * height > width * i) {
                            f = height / i;
                        } else {
                            f = width / i2;
                        }
                        imageMatrix.setScale(f, f);
                        imageMatrix.postTranslate(0.0f, 0.0f);
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
    }

    @Override // com.baidu.tbadk.widget.richText.a
    public int[] t(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
            return null;
        }
        if (!this.bKy || bKi <= 1.0f) {
            i3 = i;
        } else {
            if (i * bKi <= i3 * fKK) {
                i3 = (int) (i * bKi);
            }
            i2 = (i3 * i2) / i;
            if (i2 > 4096) {
                this.bKw = ImageView.ScaleType.MATRIX;
                i2 = 4096;
            } else {
                this.bKw = ImageView.ScaleType.CENTER_CROP;
            }
        }
        return new int[]{i3, i2};
    }
}
