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
    private static final Random nWo = new Random();
    private int count;
    private ValueAnimator gBu;
    private int mWidth;
    private int[] nWp;
    private float nWq;
    private float nWr;
    private long nWs;
    private ArrayList<c> nWt;
    private a nWu;
    private Paint paint;
    private int speed;

    /* loaded from: classes4.dex */
    public interface a {
        void a(c cVar);
    }

    public RedPacketView(Context context) {
        super(context);
        this.nWp = new int[]{a.e.ic_red_packet_middle};
        this.nWt = new ArrayList<>();
        init();
    }

    public RedPacketView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWp = new int[]{a.e.ic_red_packet_middle};
        this.nWt = new ArrayList<>();
        this.count = 9;
        this.speed = 300;
        this.nWr = 0.7f;
        this.nWq = 0.7f;
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
        this.paint.setAntiAlias(true);
        this.gBu = ValueAnimator.ofFloat(0.0f, 1.0f);
        setLayerType(2, null);
        WI();
    }

    private void WI() {
        this.gBu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((float) (currentTimeMillis - RedPacketView.this.nWs)) / 1000.0f;
                RedPacketView.this.nWs = currentTimeMillis;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < RedPacketView.this.nWt.size()) {
                        c cVar = (c) RedPacketView.this.nWt.get(i2);
                        cVar.y += cVar.speed * f;
                        if (cVar.y > RedPacketView.this.getHeight()) {
                            cVar.y = 0 - cVar.height;
                            cVar.nVX = cVar.dXS();
                        }
                        cVar.rotation += cVar.nVW * f;
                        i = i2 + 1;
                    } else {
                        RedPacketView.this.invalidate();
                        return;
                    }
                }
            }
        });
        this.gBu.setRepeatCount(-1);
        this.gBu.setDuration(100L);
    }

    public void dXW() {
        clear();
        invalidate();
        this.gBu.cancel();
    }

    public void dXX() {
        clear();
        setRedpacketCount(this.count);
        this.nWs = System.currentTimeMillis();
        this.gBu.start();
    }

    public void setRedpacketCount(int i) {
        if (this.nWp != null && this.nWp.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.nWt.add(new c(getContext(), BitmapFactory.decodeResource(getResources(), this.nWp[nWo.nextInt(this.nWp.length)]), this.speed, this.nWq, this.nWr, this.mWidth));
            }
        }
    }

    private void clear() {
        Iterator<c> it = this.nWt.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.nWt.clear();
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
            if (i2 < this.nWt.size()) {
                c cVar = this.nWt.get(i2);
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
                c H = H(motionEvent.getX(), motionEvent.getY());
                if (H != null) {
                    H.y = 0 - H.height;
                    H.nVX = H.dXS();
                    if (this.nWu != null) {
                        this.nWu.a(H);
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
        for (int size = this.nWt.size() - 1; size >= 0; size--) {
            if (this.nWt.get(size).G(f, f2)) {
                return this.nWt.get(size);
            }
        }
        return null;
    }

    public void setOnRedPacketClickListener(a aVar) {
        this.nWu = aVar;
    }
}
