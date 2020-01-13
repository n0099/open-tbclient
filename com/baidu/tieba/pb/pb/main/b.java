package com.baidu.tieba.pb.pb.main;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends com.baidu.tbadk.widget.richText.a {
    private static double iCt = 0.5d;

    public b(com.baidu.tbadk.widget.richText.a aVar) {
        super(aVar);
        he(true);
        setSupportNoImage();
        setLineSpacing(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), 1.0f);
        mX(0);
        mY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        mZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        aS(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        aT(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        na(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds14));
        this.dJT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.dJU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.dJV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.Nr = new TbImageView.c() { // from class: com.baidu.tieba.pb.pb.main.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    com.baidu.adp.widget.ImageView.a vg = com.baidu.tbadk.imageManager.c.aNs().vg(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), b.this.mIsFromCDN ? 17 : 18));
                    if (vg != null) {
                        i2 = vg.getWidth();
                        i = vg.getHeight();
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

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
    }

    @Override // com.baidu.tbadk.widget.richText.a
    public int[] u(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
            return null;
        }
        if (!this.dJJ || dJv <= 1.0f) {
            i3 = i;
        } else {
            if (i * dJv <= i3 * iCt) {
                i3 = (int) (i * dJv);
            }
            i2 = (i3 * i2) / i;
            if (i2 > 4096) {
                this.dJH = ImageView.ScaleType.MATRIX;
                i2 = 4096;
            } else {
                this.dJH = ImageView.ScaleType.CENTER_CROP;
            }
        }
        return new int[]{i3, i2};
    }
}
