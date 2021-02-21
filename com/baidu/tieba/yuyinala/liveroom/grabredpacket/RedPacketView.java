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
/* loaded from: classes11.dex */
public class RedPacketView extends View {
    private static final Random ovF = new Random();
    private ValueAnimator animator;
    private int count;
    private int mWidth;
    private int[] ovG;
    private float ovH;
    private float ovI;
    private long ovJ;
    private ArrayList<c> ovK;
    private a ovL;
    private Paint paint;
    private int speed;

    /* loaded from: classes11.dex */
    public interface a {
        void a(c cVar);
    }

    public RedPacketView(Context context) {
        super(context);
        this.ovG = new int[]{a.e.ic_red_packet_middle};
        this.ovK = new ArrayList<>();
        init();
    }

    public RedPacketView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ovG = new int[]{a.e.ic_red_packet_middle};
        this.ovK = new ArrayList<>();
        this.count = 9;
        this.speed = 300;
        this.ovI = 0.7f;
        this.ovH = 0.7f;
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
        this.paint.setAntiAlias(true);
        this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        setLayerType(2, null);
        XA();
    }

    private void XA() {
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((float) (currentTimeMillis - RedPacketView.this.ovJ)) / 1000.0f;
                RedPacketView.this.ovJ = currentTimeMillis;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < RedPacketView.this.ovK.size()) {
                        c cVar = (c) RedPacketView.this.ovK.get(i2);
                        cVar.y += cVar.speed * f;
                        if (cVar.y > RedPacketView.this.getHeight()) {
                            cVar.y = 0 - cVar.height;
                            cVar.ovo = cVar.ebk();
                        }
                        cVar.rotation += cVar.ovn * f;
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

    public void ebp() {
        clear();
        invalidate();
        this.animator.cancel();
    }

    public void ebq() {
        clear();
        setRedpacketCount(this.count);
        this.ovJ = System.currentTimeMillis();
        this.animator.start();
    }

    public void setRedpacketCount(int i) {
        if (this.ovG != null && this.ovG.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ovK.add(new c(getContext(), BitmapFactory.decodeResource(getResources(), this.ovG[ovF.nextInt(this.ovG.length)]), this.speed, this.ovH, this.ovI, this.mWidth));
            }
        }
    }

    private void clear() {
        Iterator<c> it = this.ovK.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.ovK.clear();
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
            if (i2 < this.ovK.size()) {
                c cVar = this.ovK.get(i2);
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
                    I.ovo = I.ebk();
                    if (this.ovL != null) {
                        this.ovL.a(I);
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
        for (int size = this.ovK.size() - 1; size >= 0; size--) {
            if (this.ovK.get(size).H(f, f2)) {
                return this.ovK.get(size);
            }
        }
        return null;
    }

    public void setOnRedPacketClickListener(a aVar) {
        this.ovL = aVar;
    }
}
