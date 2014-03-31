package com.baidu.tieba.signall;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
public final class n extends Animation {
    private Camera a = new Camera();
    private View b;

    public n(View view) {
        this.b = view;
    }

    @Override // android.view.animation.Animation
    protected final void applyTransformation(float f, Transformation transformation) {
        int width = this.b.getWidth() / 2;
        int height = this.b.getHeight() / 2;
        Matrix matrix = transformation.getMatrix();
        this.a.save();
        this.a.translate(0.0f, 0.0f, (-150.0f) * (1.0f - f));
        this.a.getMatrix(matrix);
        this.a.restore();
        matrix.preTranslate(-width, -height);
        matrix.postTranslate(width, height);
    }
}
