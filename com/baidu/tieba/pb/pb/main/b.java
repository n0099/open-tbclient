package com.baidu.tieba.pb.pb.main;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.widget.richText.a {
    private static double fSw = 0.5d;

    public b(com.baidu.tbadk.widget.richText.a aVar) {
        super(aVar);
        da(true);
        setSupportNoImage();
        setLineSpacing(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds15), 1.0f);
        gP(0);
        gQ(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30));
        gR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds12));
        T(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48), com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds48));
        U(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds30), com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds10));
        gS(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds14));
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.pb.pb.main.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    com.baidu.adp.widget.ImageView.a ih = com.baidu.tbadk.imageManager.c.Nu().ih(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), b.this.mIsFromCDN ? 17 : 18));
                    if (ih != null) {
                        i2 = ih.getWidth();
                        i = ih.getHeight();
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
        if (!this.bqB || bqm <= 1.0f) {
            i3 = i;
        } else {
            if (i * bqm <= i3 * fSw) {
                i3 = (int) (i * bqm);
            }
            i2 = (i3 * i2) / i;
            if (i2 > 4096) {
                this.bqz = ImageView.ScaleType.MATRIX;
                i2 = 4096;
            } else {
                this.bqz = ImageView.ScaleType.CENTER_CROP;
            }
        }
        return new int[]{i3, i2};
    }
}
