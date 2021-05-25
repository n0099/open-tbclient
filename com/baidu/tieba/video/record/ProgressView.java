package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class ProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public a f21319e;

    /* renamed from: f  reason: collision with root package name */
    public int f21320f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f21321g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f21322h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f21323i;
    public Paint j;
    public Paint k;
    public float l;
    public float m;
    public LinkedList<Integer> n;
    public float o;
    public volatile State p;
    public boolean q;
    public float r;
    public float s;
    public float t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;

    /* loaded from: classes5.dex */
    public enum State {
        START(1),
        PAUSE(2),
        ROLLBACK(3),
        DELETE(4);
        
        public int mIntValue;

        State(int i2) {
            this.mIntValue = i2;
        }

        public static State mapIntToValue(int i2) {
            State[] values;
            for (State state : values()) {
                if (i2 == state.getIntValue()) {
                    return state;
                }
            }
            return PAUSE;
        }

        public int getIntValue() {
            return this.mIntValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);
    }

    public ProgressView(Context context) {
        super(context);
        this.n = new LinkedList<>();
        this.o = 0.0f;
        this.p = State.PAUSE;
        this.q = true;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        a(context);
    }

    public final void a(Context context) {
        this.f21321g = new Paint();
        this.f21322h = new Paint();
        this.f21323i = new Paint();
        this.k = new Paint();
        this.j = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.f21321g.setStyle(Paint.Style.FILL);
        this.f21321g.setColor(Color.parseColor("#33aaff"));
        this.f21322h.setStyle(Paint.Style.FILL);
        this.f21322h.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.f21323i.setStyle(Paint.Style.FILL);
        this.f21323i.setColor(Color.parseColor("#FFFFFF"));
        this.k.setStyle(Paint.Style.FILL);
        this.k.setColor(Color.parseColor("#e53917"));
        this.j.setStyle(Paint.Style.FILL);
        this.j.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f2 = displayMetrics.widthPixels / 15000.0f;
        this.o = f2;
        this.t = f2;
    }

    public boolean b() {
        return this.n.isEmpty();
    }

    public void c(int i2) {
        this.n.add(Integer.valueOf(i2));
    }

    public void d() {
        this.n.clear();
        this.p = State.PAUSE;
        this.n.clear();
        this.r = 0.0f;
        this.u = 0L;
        this.w = 0L;
        this.x = 0L;
        this.f21320f = 0;
        this.v = 0L;
    }

    public State getCurrentState() {
        return this.p;
    }

    public int getLastProgress() {
        LinkedList<Integer> linkedList = this.n;
        if (linkedList == null || linkedList.isEmpty()) {
            return 0;
        }
        return this.n.getLast().intValue();
    }

    public LinkedList<Integer> getTimeList() {
        return this.n;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.u == 0) {
            this.u = System.currentTimeMillis();
        }
        if (this.y == 0) {
            this.y = getHeight();
        }
        long j = this.y;
        this.l = (float) j;
        this.m = (float) ((j * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.r = 0.0f;
        if (!this.n.isEmpty()) {
            Iterator<Integer> it = this.n.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                this.w = j2;
                long intValue = it.next().intValue();
                this.x = intValue;
                float f2 = this.r;
                float f3 = (((float) (intValue - j2)) * this.o) + f2;
                this.r = f3;
                float f4 = f3 - this.m;
                if (f4 < 1.0f) {
                    f4 = 1.0f;
                }
                float f5 = f4;
                canvas.drawRect(f2, 0.0f, f5, (float) (this.y - 1), this.f21321g);
                canvas.drawRect(f5, 0.0f, this.r, (float) (this.y - 1), this.f21323i);
                j2 = intValue;
            }
            if (this.n.getLast().intValue() <= 3000.0f) {
                float f6 = this.o;
                canvas.drawRect(f6 * 3000.0f, 0.0f, (f6 * 3000.0f) + this.l, (float) (this.y - 1), this.f21322h);
            }
        } else {
            float f7 = this.o;
            canvas.drawRect(f7 * 3000.0f, 0.0f, (f7 * 3000.0f) + this.l, (float) (this.y - 1), this.f21322h);
        }
        if (this.p == State.ROLLBACK) {
            float f8 = this.r;
            canvas.drawRect(f8 - (((float) (this.x - this.w)) * this.o), 0.0f, f8, (float) this.y, this.k);
        }
        if (this.p == State.START) {
            float f9 = this.s + (this.t * ((float) (currentTimeMillis - this.u)));
            this.s = f9;
            float f10 = this.r + f9;
            if (f10 <= getMeasuredWidth()) {
                float f11 = this.r;
                canvas.drawRect(f11, 0.0f, f11 + this.s, (float) (this.y - 1), this.f21321g);
            } else {
                canvas.drawRect(this.r, 0.0f, getMeasuredWidth(), (float) (this.y - 1), this.f21321g);
            }
            float f12 = f10 - 5.0f;
            long j3 = this.y;
            canvas.drawRect(f12, 0.0f, f12 + ((float) j3), (float) (j3 - 1), this.j);
            if (this.f21319e != null) {
                int measuredWidth = (int) ((f10 / getMeasuredWidth()) * 100.0f);
                i2 = measuredWidth <= 100 ? measuredWidth : 100;
                if (i2 != this.f21320f) {
                    this.f21320f = i2;
                    this.f21319e.a(i2);
                }
            }
        } else {
            if (this.f21319e != null) {
                int measuredWidth2 = (int) ((this.r / getMeasuredWidth()) * 100.0f);
                i2 = measuredWidth2 <= 100 ? measuredWidth2 : 100;
                if (i2 != this.f21320f) {
                    this.f21320f = i2;
                    this.f21319e.a(i2);
                }
            }
            long j4 = this.v;
            if (j4 == 0 || currentTimeMillis - j4 >= 800) {
                this.q = !this.q;
                this.v = System.currentTimeMillis();
            }
            if (this.q) {
                float f13 = this.r;
                long j5 = this.y;
                canvas.drawRect(f13 - 5.0f, 0.0f, (f13 - 5.0f) + ((float) j5), (float) (j5 - 1), this.j);
            }
        }
        this.u = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        LinkedList<Integer> linkedList;
        this.p = state;
        if (state != State.START) {
            this.s = this.t;
        }
        if (state != State.DELETE || (linkedList = this.n) == null || linkedList.isEmpty()) {
            return;
        }
        this.n.removeLast();
    }

    public void setListener(a aVar) {
        this.f21319e = aVar;
    }

    public void setPaintHeight(int i2) {
        this.y = i2;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        this.n = linkedList;
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new LinkedList<>();
        this.o = 0.0f;
        this.p = State.PAUSE;
        this.q = true;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        a(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = new LinkedList<>();
        this.o = 0.0f;
        this.p = State.PAUSE;
        this.q = true;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        a(context);
    }
}
