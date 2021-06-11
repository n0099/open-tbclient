package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class IndexScroller {
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;

    /* renamed from: a  reason: collision with root package name */
    public float f23535a;

    /* renamed from: b  reason: collision with root package name */
    public float f23536b;

    /* renamed from: c  reason: collision with root package name */
    public float f23537c;

    /* renamed from: d  reason: collision with root package name */
    public float f23538d;

    /* renamed from: e  reason: collision with root package name */
    public float f23539e;

    /* renamed from: f  reason: collision with root package name */
    public float f23540f;

    /* renamed from: h  reason: collision with root package name */
    public int f23542h;

    /* renamed from: i  reason: collision with root package name */
    public int f23543i;
    public ListView l;
    public RectF o;

    /* renamed from: g  reason: collision with root package name */
    public int f23541g = 0;
    public int j = -1;
    public boolean k = false;
    public SectionIndexer m = null;
    public String[] n = null;
    public final a t = new a(this);

    /* loaded from: classes5.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IndexScroller> f23544a;

        public a(IndexScroller indexScroller) {
            this.f23544a = new WeakReference<>(indexScroller);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            IndexScroller indexScroller = this.f23544a.get();
            if (indexScroller == null) {
                return;
            }
            int i2 = indexScroller.f23541g;
            if (i2 == 1) {
                indexScroller.f23540f = (float) (indexScroller.f23540f + ((1.0f - indexScroller.f23540f) * 0.2d));
                if (indexScroller.f23540f > 0.9d) {
                    indexScroller.f23540f = 1.0f;
                    indexScroller.a(2);
                }
                indexScroller.l.invalidate();
                indexScroller.a(10L);
            } else if (i2 == 2) {
                indexScroller.a(3);
            } else if (i2 != 3) {
            } else {
                indexScroller.f23540f = (float) (indexScroller.f23540f - (indexScroller.f23540f * 0.2d));
                if (indexScroller.f23540f < 0.1d) {
                    indexScroller.f23540f = 0.0f;
                    indexScroller.a(0);
                }
                indexScroller.l.invalidate();
                indexScroller.a(10L);
            }
        }
    }

    public IndexScroller(Context context, ListView listView) {
        this.l = null;
        this.f23538d = context.getResources().getDisplayMetrics().density;
        this.f23539e = context.getResources().getDisplayMetrics().scaledDensity;
        this.l = listView;
        setAdapter(listView.getAdapter());
        float f2 = this.f23538d;
        this.f23535a = 20.0f * f2;
        this.f23536b = 10.0f * f2;
        this.f23537c = f2 * 5.0f;
    }

    public boolean contains(float f2, float f3) {
        RectF rectF = this.o;
        if (f2 >= rectF.left) {
            float f4 = rectF.top;
            if (f3 >= f4 && f3 <= f4 + rectF.height()) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        String[] strArr = this.n;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = 0;
        if (this.j >= 0) {
            Paint paint = new Paint();
            paint.setColor(-16777216);
            paint.setAlpha(96);
            paint.setAntiAlias(true);
            paint.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            paint2.setAntiAlias(true);
            paint2.setTextSize(this.f23539e * 50.0f);
            float measureText = paint2.measureText(this.n[this.j]);
            float descent = ((this.f23537c * 2.0f) + paint2.descent()) - paint2.ascent();
            int i3 = this.f23542h;
            int i4 = this.f23543i;
            RectF rectF = new RectF((i3 - descent) / 2.0f, (i4 - descent) / 2.0f, ((i3 - descent) / 2.0f) + descent, ((i4 - descent) / 2.0f) + descent);
            float f2 = this.f23538d;
            canvas.drawRoundRect(rectF, f2 * 5.0f, f2 * 5.0f, paint);
            canvas.drawText(this.n[this.j], (rectF.left + ((descent - measureText) / 2.0f)) - 1.0f, ((rectF.top + this.f23537c) - paint2.ascent()) + 1.0f, paint2);
        }
        Paint paint3 = new Paint();
        paint3.setColor(-16099908);
        paint3.setAntiAlias(true);
        paint3.setTextSize(this.f23539e * 14.0f);
        float height = (this.o.height() - (this.f23536b * 2.0f)) / this.n.length;
        float descent2 = (height - (paint3.descent() - paint3.ascent())) / 2.0f;
        while (true) {
            String[] strArr2 = this.n;
            if (i2 >= strArr2.length) {
                return;
            }
            String str = this.n[i2];
            RectF rectF2 = this.o;
            canvas.drawText(str, rectF2.left + ((this.f23535a - paint3.measureText(strArr2[i2])) / 2.0f), (((rectF2.top + this.f23536b) + (i2 * height)) + descent2) - paint3.ascent(), paint3);
            i2++;
        }
    }

    public void hide() {
        if (this.f23541g == 2) {
            a(3);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f23542h = i2;
        this.f23543i = i3;
        float f2 = i2;
        float f3 = this.f23536b;
        this.o = new RectF((f2 - f3) - this.f23535a, f3, f2 - f3, i3 - f3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.k) {
                    if (contains(motionEvent.getX(), motionEvent.getY())) {
                        int a2 = a(motionEvent.getY());
                        this.j = a2;
                        this.l.setSelection(this.m.getPositionForSection(a2));
                    }
                    return true;
                }
            } else {
                if (this.k) {
                    this.k = false;
                    this.j = -1;
                }
                if (this.f23541g == 2) {
                    a(3);
                }
            }
        } else if (contains(motionEvent.getX(), motionEvent.getY())) {
            a(2);
            this.k = true;
            int a3 = a(motionEvent.getY());
            this.j = a3;
            this.l.setSelection(this.m.getPositionForSection(a3));
            return true;
        }
        return false;
    }

    public void setAdapter(Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            this.m = sectionIndexer;
            this.n = (String[]) sectionIndexer.getSections();
        }
    }

    public void show() {
        int i2 = this.f23541g;
        if (i2 == 0) {
            a(1);
        } else if (i2 == 3) {
            a(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (i2 < 0 || i2 > 3) {
            return;
        }
        this.f23541g = i2;
        if (i2 == 0) {
            this.t.removeMessages(0);
        } else if (i2 == 1) {
            this.f23540f = 0.0f;
            a(0L);
        } else if (i2 == 2) {
            this.t.removeMessages(0);
        } else if (i2 != 3) {
        } else {
            this.f23540f = 1.0f;
            a(3000L);
        }
    }

    private int a(float f2) {
        String[] strArr = this.n;
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        RectF rectF = this.o;
        float f3 = rectF.top;
        if (f2 < this.f23536b + f3) {
            return 0;
        }
        float height = f3 + rectF.height();
        float f4 = this.f23536b;
        if (f2 >= height - f4) {
            return this.n.length - 1;
        }
        RectF rectF2 = this.o;
        return (int) (((f2 - rectF2.top) - f4) / ((rectF2.height() - (this.f23536b * 2.0f)) / this.n.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.t.removeMessages(0);
        this.t.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j);
    }
}
