package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes10.dex */
public class RedPacketView extends View {
    private static final Random olm = new Random();
    private ValueAnimator animator;
    private int count;
    private int mWidth;
    private int[] oln;
    private float olo;
    private float olp;
    private long olq;
    private ArrayList<c> olr;
    private a ols;
    private Paint paint;
    private int speed;

    /* loaded from: classes10.dex */
    public interface a {
        void a(c cVar);
    }

    public RedPacketView(Context context) {
        super(context);
        this.oln = new int[]{a.e.ic_red_packet_middle};
        this.olr = new ArrayList<>();
        init();
    }

    public RedPacketView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oln = new int[]{a.e.ic_red_packet_middle};
        this.olr = new ArrayList<>();
        this.count = 9;
        this.speed = 300;
        this.olp = 0.7f;
        this.olo = 0.7f;
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
        this.paint.setAntiAlias(true);
        this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        setLayerType(2, null);
        VR();
    }

    private void VR() {
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((float) (currentTimeMillis - RedPacketView.this.olq)) / 1000.0f;
                RedPacketView.this.olq = currentTimeMillis;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < RedPacketView.this.olr.size()) {
                        c cVar = (c) RedPacketView.this.olr.get(i2);
                        cVar.y += cVar.speed * f;
                        if (cVar.y > RedPacketView.this.getHeight()) {
                            cVar.y = 0 - cVar.height;
                            cVar.okV = cVar.dYQ();
                        }
                        cVar.rotation += cVar.okU * f;
                        i = i2 + 1;
                    } else {
                        RedPacketView.this.invalidate();
                        return;
                    }
                }
            }
        });
        this.animator.setRepeatCount(-1);
        this.animator.setDuration(100L);
    }

    public void dYV() {
        clear();
        invalidate();
        this.animator.cancel();
    }

    public void dYW() {
        clear();
        setRedpacketCount(this.count);
        this.olq = System.currentTimeMillis();
        this.animator.start();
    }

    public void setRedpacketCount(int i) {
        if (this.oln != null && this.oln.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.olr.add(new c(getContext(), BitmapFactory.decodeResource(getResources(), this.oln[olm.nextInt(this.oln.length)]), this.speed, this.olo, this.olp, this.mWidth));
            }
        }
    }

    private void clear() {
        Iterator<c> it = this.olr.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.olr.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.olr.size()) {
                c cVar = this.olr.get(i2);
                Matrix matrix = new Matrix();
                matrix.setTranslate((-cVar.width) / 2, (-cVar.height) / 2);
                matrix.postRotate(cVar.rotation);
                matrix.postTranslate((cVar.width / 2) + cVar.x, (cVar.height / 2) + cVar.y);
                canvas.drawBitmap(cVar.bitmap, matrix, this.paint);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                c I = I(motionEvent.getX(), motionEvent.getY());
                if (I != null) {
                    I.y = 0 - I.height;
                    I.okV = I.dYQ();
                    if (this.ols != null) {
                        this.ols.a(I);
                        return true;
                    }
                    return true;
                }
                return true;
            case 1:
            case 2:
            default:
                return true;
        }
    }

    private c I(float f, float f2) {
        for (int size = this.olr.size() - 1; size >= 0; size--) {
            if (this.olr.get(size).H(f, f2)) {
                return this.olr.get(size);
            }
        }
        return null;
    }

    public void setOnRedPacketClickListener(a aVar) {
        this.ols = aVar;
    }
}
