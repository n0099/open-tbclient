package com.baidu.tieba.pb.pb.main;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.widget.richText.a {
    private static double eJF = 0.5d;

    public b(com.baidu.tbadk.widget.richText.a aVar) {
        super(aVar);
        cb(true);
        IH();
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.pb.pb.main.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                float f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    int loadedWidth = tbImageView.getLoadedWidth();
                    int loadedHeight = tbImageView.getLoadedHeight();
                    if (loadedWidth != 0 && loadedHeight != 0) {
                        int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        if (loadedWidth * height > width * loadedHeight) {
                            f = height / loadedHeight;
                        } else {
                            f = width / loadedWidth;
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
    public int[] l(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
            return null;
        }
        if (!this.aRo || aQZ <= 1.0f) {
            i3 = i;
        } else {
            if (i * aQZ <= i3 * eJF) {
                i3 = (int) (i * aQZ);
            }
            i2 = (i3 * i2) / i;
            if (i2 > 4096) {
                this.aRm = ImageView.ScaleType.MATRIX;
                i2 = 4096;
            } else {
                this.aRm = ImageView.ScaleType.CENTER_CROP;
            }
        }
        return new int[]{i3, i2};
    }
}
