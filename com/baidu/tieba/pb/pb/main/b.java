package com.baidu.tieba.pb.pb.main;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.widget.richText.a {
    private static double fuJ = 0.5d;

    public b(com.baidu.tbadk.widget.richText.a aVar) {
        super(aVar);
        cm(true);
        setSupportNoImage();
        setLineSpacing(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds15), 1.0f);
        fS(0);
        fT(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        fU(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        O(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds48), com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds48));
        P(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds30), com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds10));
        fV(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds14));
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.pb.pb.main.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    com.baidu.adp.widget.ImageView.a hi = com.baidu.tbadk.imageManager.c.IV().hi(com.baidu.adp.lib.f.c.ig().f(tbImageView.getUrl(), b.this.mIsFromCDN ? 17 : 18));
                    if (hi != null) {
                        i2 = hi.getWidth();
                        i = hi.getHeight();
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
    public int[] k(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
            return null;
        }
        if (!this.beH || ber <= 1.0f) {
            i3 = i;
        } else {
            if (i * ber <= i3 * fuJ) {
                i3 = (int) (i * ber);
            }
            i2 = (i3 * i2) / i;
            if (i2 > 4096) {
                this.beF = ImageView.ScaleType.MATRIX;
                i2 = 4096;
            } else {
                this.beF = ImageView.ScaleType.CENTER_CROP;
            }
        }
        return new int[]{i3, i2};
    }
}
