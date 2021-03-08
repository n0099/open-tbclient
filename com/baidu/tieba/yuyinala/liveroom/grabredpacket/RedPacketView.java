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
    private static final Random oxK = new Random();
    private ValueAnimator animator;
    private int count;
    private int mWidth;
    private int[] oxL;
    private float oxM;
    private float oxN;
    private long oxO;
    private ArrayList<c> oxP;
    private a oxQ;
    private Paint paint;
    private int speed;

    /* loaded from: classes10.dex */
    public interface a {
        void a(c cVar);
    }

    public RedPacketView(Context context) {
        super(context);
        this.oxL = new int[]{a.e.ic_red_packet_middle};
        this.oxP = new ArrayList<>();
        init();
    }

    public RedPacketView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oxL = new int[]{a.e.ic_red_packet_middle};
        this.oxP = new ArrayList<>();
        this.count = 9;
        this.speed = 300;
        this.oxN = 0.7f;
        this.oxM = 0.7f;
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
        this.paint.setAntiAlias(true);
        this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        setLayerType(2, null);
        XD();
    }

    private void XD() {
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((float) (currentTimeMillis - RedPacketView.this.oxO)) / 1000.0f;
                RedPacketView.this.oxO = currentTimeMillis;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < RedPacketView.this.oxP.size()) {
                        c cVar = (c) RedPacketView.this.oxP.get(i2);
                        cVar.y += cVar.speed * f;
                        if (cVar.y > RedPacketView.this.getHeight()) {
                            cVar.y = 0 - cVar.height;
                            cVar.oxt = cVar.ebs();
                        }
                        cVar.rotation += cVar.oxs * f;
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

    public void ebx() {
        clear();
        invalidate();
        this.animator.cancel();
    }

    public void eby() {
        clear();
        setRedpacketCount(this.count);
        this.oxO = System.currentTimeMillis();
        this.animator.start();
    }

    public void setRedpacketCount(int i) {
        if (this.oxL != null && this.oxL.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.oxP.add(new c(getContext(), BitmapFactory.decodeResource(getResources(), this.oxL[oxK.nextInt(this.oxL.length)]), this.speed, this.oxM, this.oxN, this.mWidth));
            }
        }
    }

    private void clear() {
        Iterator<c> it = this.oxP.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.oxP.clear();
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
            if (i2 < this.oxP.size()) {
                c cVar = this.oxP.get(i2);
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
                    I.oxt = I.ebs();
                    if (this.oxQ != null) {
                        this.oxQ.a(I);
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
        for (int size = this.oxP.size() - 1; size >= 0; size--) {
            if (this.oxP.get(size).H(f, f2)) {
                return this.oxP.get(size);
            }
        }
        return null;
    }

    public void setOnRedPacketClickListener(a aVar) {
        this.oxQ = aVar;
    }
}
