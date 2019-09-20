package com.baidu.tieba.pb.pb.main;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.tbadk.widget.richText.a {
    private static double hMO = 0.5d;

    public b(com.baidu.tbadk.widget.richText.a aVar) {
        super(aVar);
        fX(true);
        setSupportNoImage();
        setLineSpacing(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), 1.0f);
        lE(0);
        lF(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        lG(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        av(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        aw(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30), com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        lH(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds14));
        this.cMQ = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.cMR = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.cMS = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.pb.pb.main.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    com.baidu.adp.widget.ImageView.a qS = com.baidu.tbadk.imageManager.c.atK().qS(com.baidu.adp.lib.f.c.iE().e(tbImageView.getUrl(), b.this.mIsFromCDN ? 17 : 18));
                    if (qS != null) {
                        i2 = qS.getWidth();
                        i = qS.getHeight();
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
    public int[] s(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
            return null;
        }
        if (!this.cMG || cMr <= 1.0f) {
            i3 = i;
        } else {
            if (i * cMr <= i3 * hMO) {
                i3 = (int) (i * cMr);
            }
            i2 = (i3 * i2) / i;
            if (i2 > 4096) {
                this.cME = ImageView.ScaleType.MATRIX;
                i2 = 4096;
            } else {
                this.cME = ImageView.ScaleType.CENTER_CROP;
            }
        }
        return new int[]{i3, i2};
    }
}
