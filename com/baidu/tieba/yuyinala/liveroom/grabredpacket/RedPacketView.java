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
    private static final Random omQ = new Random();
    private int count;
    private ValueAnimator gJY;
    private int mWidth;
    private int[] omR;
    private float omS;
    private float omT;
    private long omU;
    private ArrayList<c> omV;
    private a omW;
    private Paint paint;
    private int speed;

    /* loaded from: classes4.dex */
    public interface a {
        void a(c cVar);
    }

    public RedPacketView(Context context) {
        super(context);
        this.omR = new int[]{a.e.ic_red_packet_middle};
        this.omV = new ArrayList<>();
        init();
    }

    public RedPacketView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.omR = new int[]{a.e.ic_red_packet_middle};
        this.omV = new ArrayList<>();
        this.count = 9;
        this.speed = 300;
        this.omT = 0.7f;
        this.omS = 0.7f;
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
        this.paint.setAntiAlias(true);
        this.gJY = ValueAnimator.ofFloat(0.0f, 1.0f);
        setLayerType(2, null);
        Yz();
    }

    private void Yz() {
        this.gJY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((float) (currentTimeMillis - RedPacketView.this.omU)) / 1000.0f;
                RedPacketView.this.omU = currentTimeMillis;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < RedPacketView.this.omV.size()) {
                        c cVar = (c) RedPacketView.this.omV.get(i2);
                        cVar.y += cVar.speed * f;
                        if (cVar.y > RedPacketView.this.getHeight()) {
                            cVar.y = 0 - cVar.height;
                            cVar.omz = cVar.edv();
                        }
                        cVar.omx += cVar.omy * f;
                        i = i2 + 1;
                    } else {
                        RedPacketView.this.invalidate();
                        return;
                    }
                }
            }
        });
        this.gJY.setRepeatCount(-1);
        this.gJY.setDuration(100L);
    }

    public void edz() {
        clear();
        invalidate();
        this.gJY.cancel();
    }

    public void edA() {
        clear();
        setRedpacketCount(this.count);
        this.omU = System.currentTimeMillis();
        this.gJY.start();
    }

    public void setRedpacketCount(int i) {
        if (this.omR != null && this.omR.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.omV.add(new c(getContext(), BitmapFactory.decodeResource(getResources(), this.omR[omQ.nextInt(this.omR.length)]), this.speed, this.omS, this.omT, this.mWidth));
            }
        }
    }

    private void clear() {
        Iterator<c> it = this.omV.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.omV.clear();
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
            if (i2 < this.omV.size()) {
                c cVar = this.omV.get(i2);
                Matrix matrix = new Matrix();
                matrix.setTranslate((-cVar.width) / 2, (-cVar.height) / 2);
                matrix.postRotate(cVar.omx);
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
                    H.omz = H.edv();
                    if (this.omW != null) {
                        this.omW.a(H);
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
        for (int size = this.omV.size() - 1; size >= 0; size--) {
            if (this.omV.get(size).G(f, f2)) {
                return this.omV.get(size);
            }
        }
        return null;
    }

    public void setOnRedPacketClickListener(a aVar) {
        this.omW = aVar;
    }
}
