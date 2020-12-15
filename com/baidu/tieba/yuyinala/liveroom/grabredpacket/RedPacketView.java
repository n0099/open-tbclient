package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes4.dex */
public class RedPacketView extends View {
    private static final Random omS = new Random();
    private int count;
    private ValueAnimator gKa;
    private int mWidth;
    private int[] omT;
    private float omU;
    private float omV;
    private long omW;
    private ArrayList<c> omX;
    private a omY;
    private Paint paint;
    private int speed;

    /* loaded from: classes4.dex */
    public interface a {
        void a(c cVar);
    }

    public RedPacketView(Context context) {
        super(context);
        this.omT = new int[]{a.e.ic_red_packet_middle};
        this.omX = new ArrayList<>();
        init();
    }

    public RedPacketView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.omT = new int[]{a.e.ic_red_packet_middle};
        this.omX = new ArrayList<>();
        this.count = 9;
        this.speed = 300;
        this.omV = 0.7f;
        this.omU = 0.7f;
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
        this.paint.setAntiAlias(true);
        this.gKa = ValueAnimator.ofFloat(0.0f, 1.0f);
        setLayerType(2, null);
        Yz();
    }

    private void Yz() {
        this.gKa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((float) (currentTimeMillis - RedPacketView.this.omW)) / 1000.0f;
                RedPacketView.this.omW = currentTimeMillis;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < RedPacketView.this.omX.size()) {
                        c cVar = (c) RedPacketView.this.omX.get(i2);
                        cVar.y += cVar.speed * f;
                        if (cVar.y > RedPacketView.this.getHeight()) {
                            cVar.y = 0 - cVar.height;
                            cVar.omB = cVar.edw();
                        }
                        cVar.omz += cVar.omA * f;
                        i = i2 + 1;
                    } else {
                        RedPacketView.this.invalidate();
                        return;
                    }
                }
            }
        });
        this.gKa.setRepeatCount(-1);
        this.gKa.setDuration(100L);
    }

    public void edA() {
        clear();
        invalidate();
        this.gKa.cancel();
    }

    public void edB() {
        clear();
        setRedpacketCount(this.count);
        this.omW = System.currentTimeMillis();
        this.gKa.start();
    }

    public void setRedpacketCount(int i) {
        if (this.omT != null && this.omT.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.omX.add(new c(getContext(), BitmapFactory.decodeResource(getResources(), this.omT[omS.nextInt(this.omT.length)]), this.speed, this.omU, this.omV, this.mWidth));
            }
        }
    }

    private void clear() {
        Iterator<c> it = this.omX.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.omX.clear();
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
            if (i2 < this.omX.size()) {
                c cVar = this.omX.get(i2);
                Matrix matrix = new Matrix();
                matrix.setTranslate((-cVar.width) / 2, (-cVar.height) / 2);
                matrix.postRotate(cVar.omz);
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
                c H = H(motionEvent.getX(), motionEvent.getY());
                if (H != null) {
                    H.y = 0 - H.height;
                    H.omB = H.edw();
                    if (this.omY != null) {
                        this.omY.a(H);
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

    private c H(float f, float f2) {
        for (int size = this.omX.size() - 1; size >= 0; size--) {
            if (this.omX.get(size).G(f, f2)) {
                return this.omX.get(size);
            }
        }
        return null;
    }

    public void setOnRedPacketClickListener(a aVar) {
        this.omY = aVar;
    }
}
