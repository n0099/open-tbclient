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
    private static final Random ovf = new Random();
    private ValueAnimator animator;
    private int count;
    private int mWidth;
    private int[] ovg;
    private float ovh;
    private float ovi;
    private long ovj;
    private ArrayList<c> ovk;
    private a ovl;
    private Paint paint;
    private int speed;

    /* loaded from: classes11.dex */
    public interface a {
        void a(c cVar);
    }

    public RedPacketView(Context context) {
        super(context);
        this.ovg = new int[]{a.e.ic_red_packet_middle};
        this.ovk = new ArrayList<>();
        init();
    }

    public RedPacketView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ovg = new int[]{a.e.ic_red_packet_middle};
        this.ovk = new ArrayList<>();
        this.count = 9;
        this.speed = 300;
        this.ovi = 0.7f;
        this.ovh = 0.7f;
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
                float f = ((float) (currentTimeMillis - RedPacketView.this.ovj)) / 1000.0f;
                RedPacketView.this.ovj = currentTimeMillis;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < RedPacketView.this.ovk.size()) {
                        c cVar = (c) RedPacketView.this.ovk.get(i2);
                        cVar.y += cVar.speed * f;
                        if (cVar.y > RedPacketView.this.getHeight()) {
                            cVar.y = 0 - cVar.height;
                            cVar.ouO = cVar.ebc();
                        }
                        cVar.rotation += cVar.ouN * f;
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

    public void ebh() {
        clear();
        invalidate();
        this.animator.cancel();
    }

    public void ebi() {
        clear();
        setRedpacketCount(this.count);
        this.ovj = System.currentTimeMillis();
        this.animator.start();
    }

    public void setRedpacketCount(int i) {
        if (this.ovg != null && this.ovg.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ovk.add(new c(getContext(), BitmapFactory.decodeResource(getResources(), this.ovg[ovf.nextInt(this.ovg.length)]), this.speed, this.ovh, this.ovi, this.mWidth));
            }
        }
    }

    private void clear() {
        Iterator<c> it = this.ovk.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.ovk.clear();
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
            if (i2 < this.ovk.size()) {
                c cVar = this.ovk.get(i2);
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
                    I.ouO = I.ebc();
                    if (this.ovl != null) {
                        this.ovl.a(I);
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
        for (int size = this.ovk.size() - 1; size >= 0; size--) {
            if (this.ovk.get(size).H(f, f2)) {
                return this.ovk.get(size);
            }
        }
        return null;
    }

    public void setOnRedPacketClickListener(a aVar) {
        this.ovl = aVar;
    }
}
