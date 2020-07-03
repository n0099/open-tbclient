package com.baidu.tieba.pb.pb.main;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.tbadk.widget.richText.a {
    private static double kbC = 0.5d;

    public c(com.baidu.tbadk.widget.richText.a aVar) {
        super(aVar);
        iT(true);
        setSupportNoImage();
        setLineSpacing(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), 1.0f);
        oE(0);
        oF(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        oG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        bf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        bg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        oH(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds14));
        this.eNz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.eNA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.eNB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.ais = new TbImageView.c() { // from class: com.baidu.tieba.pb.pb.main.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    com.baidu.adp.widget.ImageView.a yO = com.baidu.tbadk.imageManager.c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), c.this.mIsFromCDN ? 17 : 18));
                    if (yO != null) {
                        i2 = yO.getWidth();
                        i = yO.getHeight();
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
        if (!this.eNo || eNa <= 1.0f) {
            i3 = i;
        } else {
            if (i * eNa <= i3 * kbC) {
                i3 = (int) (i * eNa);
            }
            i2 = (i3 * i2) / i;
            if (i2 > 4096) {
                this.eNm = ImageView.ScaleType.MATRIX;
                i2 = 4096;
            } else {
                this.eNm = ImageView.ScaleType.CENTER_CROP;
            }
        }
        return new int[]{i3, i2};
    }
}
