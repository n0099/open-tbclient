package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class HaloView extends View {
    Runnable a;
    private final Paint b;
    private final Context c;
    private boolean d;
    private int e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(HaloView haloView) {
        int i = haloView.e + 1;
        haloView.e = i;
        return i;
    }

    public HaloView(Context context) {
        this(context, null);
    }

    public HaloView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.e = 0;
        this.f = false;
        this.a = new ax(this);
        this.c = context;
        this.b = new Paint();
        this.b.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.at.HaloView);
        this.d = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (this.d) {
            this.b.setStyle(Paint.Style.FILL);
        } else {
            this.b.setStyle(Paint.Style.STROKE);
        }
        postDelayed(this.a, 800L);
    }

    public void setIsBlack(boolean z) {
        this.d = z;
        if (this.d) {
            this.b.setStyle(Paint.Style.FILL);
        } else {
            this.b.setStyle(Paint.Style.STROKE);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (!this.d) {
            int a = com.baidu.tieba.im.d.c.a(this.c, R.dimen.ds70);
            int a2 = com.baidu.tieba.im.d.c.a(this.c, R.dimen.ds90);
            int a3 = com.baidu.tieba.im.d.c.a(this.c, R.dimen.ds30);
            int a4 = com.baidu.tieba.im.d.c.a(this.c, R.dimen.ds60);
            if (this.e >= 1) {
                this.b.setARGB(25, 255, 255, 255);
                this.b.setStrokeWidth(a3);
                canvas.drawCircle(width, height, a, this.b);
            }
            if (this.e >= 2) {
                this.b.setARGB(20, 255, 255, 255);
                this.b.setStrokeWidth(a4);
                canvas.drawCircle(width, height, (a3 / 2) + a, this.b);
            }
            if (this.e >= 3) {
                this.b.setARGB(15, 255, 255, 255);
                this.b.setStrokeWidth(a2);
                canvas.drawCircle(width, height, a + a3, this.b);
            }
        } else {
            int a5 = com.baidu.tieba.im.d.c.a(this.c, R.dimen.ds120);
            this.b.setARGB(SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY, 0, 0, 0);
            this.b.setStrokeWidth(a5);
            canvas.drawCircle(width, height, a5, this.b);
        }
        super.onDraw(canvas);
    }

    public void a() {
        this.f = true;
    }
}
