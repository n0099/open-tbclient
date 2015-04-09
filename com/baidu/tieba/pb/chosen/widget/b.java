package com.baidu.tieba.pb.chosen.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.baidu.tieba.aa;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public abstract class b<T extends View> extends LinearLayout {
    private int Ho;
    private float bGU;
    private float bGV;
    private float bGW;
    private boolean bGX;
    private int bGY;
    private boolean bGZ;
    T bHa;
    private boolean bHb;
    private a bHc;
    private a bHd;
    private int bHe;
    private c bHf;
    private b<T>.d bHg;
    private final Handler handler;
    private int mode;
    private int state;

    protected abstract boolean YU();

    protected abstract boolean YV();

    protected abstract T c(Context context, AttributeSet attributeSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d implements Runnable {
        private final int bHh;
        private final int bHi;
        private final Handler handler;
        private boolean bHj = true;
        private long startTime = -1;
        private int bHk = -1;
        private final Interpolator bGR = new AccelerateDecelerateInterpolator();

        public d(Handler handler, int i, int i2) {
            this.handler = handler;
            this.bHi = i;
            this.bHh = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                this.bHk = this.bHi - Math.round(this.bGR.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L)) / 1000.0f) * (this.bHi - this.bHh));
                b.this.setHeaderScroll(this.bHk);
            }
            if (this.bHj && this.bHh != this.bHk) {
                this.handler.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bHj = false;
            this.handler.removeCallbacks(this);
        }
    }

    public b(Context context) {
        super(context);
        this.bGX = false;
        this.state = 0;
        this.mode = 1;
        this.bGZ = true;
        this.bHb = true;
        this.handler = new Handler();
        init(context, null);
    }

    public b(Context context, int i) {
        super(context);
        this.bGX = false;
        this.state = 0;
        this.mode = 1;
        this.bGZ = true;
        this.bHb = true;
        this.handler = new Handler();
        this.mode = i;
        init(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGX = false;
        this.state = 0;
        this.mode = 1;
        this.bGZ = true;
        this.bHb = true;
        this.handler = new Handler();
        init(context, attributeSet);
    }

    public final T getAdapterView() {
        return this.bHa;
    }

    public final T getRefreshableView() {
        return this.bHa;
    }

    public final boolean YS() {
        return this.state == 2 || this.state == 3;
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        this.bGZ = z;
    }

    public final void YT() {
        if (this.state != 0) {
            YW();
        }
    }

    public final void setOnRefreshListener(c cVar) {
        this.bHf = cVar;
    }

    public final void setPullToRefreshEnabled(boolean z) {
        this.bHb = z;
    }

    public void setReleaseLabel(String str) {
        if (this.bHc != null) {
            this.bHc.setReleaseLabel(str);
        }
        if (this.bHd != null) {
            this.bHd.setReleaseLabel(str);
        }
    }

    public void setPullLabel(String str) {
        if (this.bHc != null) {
            this.bHc.setPullLabel(str);
        }
        if (this.bHd != null) {
            this.bHd.setPullLabel(str);
        }
    }

    public void setRefreshingLabel(String str) {
        if (this.bHc != null) {
            this.bHc.setRefreshingLabel(str);
        }
        if (this.bHd != null) {
            this.bHd.setRefreshingLabel(str);
        }
    }

    public final void setRefreshing(boolean z) {
        if (!YS()) {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bHb) {
            if (YS() && this.bGZ) {
                return true;
            }
            if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (nj()) {
                            float y = motionEvent.getY();
                            this.bGU = y;
                            this.bGW = y;
                            return true;
                        }
                        return false;
                    case 1:
                    case 3:
                        if (this.bGX) {
                            this.bGX = false;
                            if (this.state == 1 && this.bHf != null) {
                                setRefreshingInternal(true);
                                this.bHf.hd(this.bGY);
                            } else {
                                hg(0);
                            }
                            return true;
                        }
                        return false;
                    case 2:
                        if (this.bGX) {
                            this.bGW = motionEvent.getY();
                            YX();
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.bHb) {
            if (YS() && this.bGZ) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.bGX = false;
                return false;
            } else if (action == 0 || !this.bGX) {
                switch (action) {
                    case 0:
                        if (nj()) {
                            float y = motionEvent.getY();
                            this.bGU = y;
                            this.bGW = y;
                            this.bGV = motionEvent.getX();
                            this.bGX = false;
                            break;
                        }
                        break;
                    case 2:
                        if (nj()) {
                            float y2 = motionEvent.getY();
                            float f = y2 - this.bGW;
                            float abs = Math.abs(f);
                            float abs2 = Math.abs(motionEvent.getX() - this.bGV);
                            if (abs > this.Ho && abs > abs2) {
                                if ((this.mode == 1 || this.mode == 3) && f >= 1.0E-4f && YU()) {
                                    this.bGW = y2;
                                    this.bGX = true;
                                    if (this.mode == 3) {
                                        this.bGY = 1;
                                        break;
                                    }
                                } else if ((this.mode == 2 || this.mode == 3) && f <= 1.0E-4f && YV()) {
                                    this.bGW = y2;
                                    this.bGX = true;
                                    if (this.mode == 3) {
                                        this.bGY = 2;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
                return this.bGX;
            } else {
                return true;
            }
        }
        return false;
    }

    protected void f(Context context, T t) {
        addView(t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    protected final int getCurrentMode() {
        return this.bGY;
    }

    protected final a getFooterLayout() {
        return this.bHd;
    }

    protected final a getHeaderLayout() {
        return this.bHc;
    }

    protected final int getHeaderHeight() {
        return this.bHe;
    }

    protected final int getMode() {
        return this.mode;
    }

    protected void YW() {
        this.state = 0;
        this.bGX = false;
        if (this.bHc != null) {
            this.bHc.reset();
        }
        if (this.bHd != null) {
            this.bHd.reset();
        }
        hg(0);
    }

    protected void setRefreshingInternal(boolean z) {
        this.state = 2;
        if (this.bHc != null) {
            this.bHc.mP();
        }
        if (this.bHd != null) {
            this.bHd.mP();
        }
        if (z) {
            hg(this.bGY == 1 ? -this.bHe : this.bHe);
        }
    }

    protected final void setHeaderScroll(int i) {
        scrollTo(0, i);
    }

    public final void hg(int i) {
        if (this.bHg != null) {
            this.bHg.stop();
        }
        if (getScrollY() != i) {
            this.bHg = new d(this.handler, getScrollY(), i);
            this.handler.post(this.bHg);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        this.Ho = ViewConfiguration.getTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.PullToRefresh);
        if (obtainStyledAttributes.hasValue(3)) {
            this.mode = obtainStyledAttributes.getInteger(3, 1);
        }
        this.bHa = c(context, attributeSet);
        f(context, this.bHa);
        String string = context.getString(y.chosen_pull_refresh);
        String string2 = context.getString(y.chosen_drag_refresh);
        String string3 = context.getString(y.chosen_release_refresh);
        if (this.mode == 1 || this.mode == 3) {
            this.bHc = new a(context, 1, string3, string, string2);
            addView(this.bHc, 0, new LinearLayout.LayoutParams(-1, -2));
            e(this.bHc);
            this.bHe = this.bHc.getMeasuredHeight();
        }
        if (this.mode == 2 || this.mode == 3) {
            this.bHd = new a(context, 2, string3, string, string2);
            addView(this.bHd, new LinearLayout.LayoutParams(-1, -2));
            e(this.bHd);
            this.bHe = this.bHd.getMeasuredHeight();
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
            if (this.bHc != null) {
                this.bHc.setTextColor(color);
            }
            if (this.bHd != null) {
                this.bHd.setTextColor(color);
            }
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setBackgroundResource(obtainStyledAttributes.getResourceId(1, -1));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.bHa.setBackgroundResource(obtainStyledAttributes.getResourceId(0, -1));
        }
        obtainStyledAttributes.recycle();
        switch (this.mode) {
            case 2:
                setPadding(0, 0, 0, -this.bHe);
                break;
            case 3:
                setPadding(0, -this.bHe, 0, -this.bHe);
                break;
            default:
                setPadding(0, -this.bHe, 0, 0);
                break;
        }
        if (this.mode != 3) {
            this.bGY = this.mode;
        }
    }

    private void e(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private boolean YX() {
        int round;
        int scrollY = getScrollY();
        switch (this.bGY) {
            case 2:
                round = Math.round(Math.max(this.bGU - this.bGW, 0.0f) / 2.0f);
                break;
            default:
                round = Math.round(Math.min(this.bGU - this.bGW, 0.0f) / 2.0f);
                break;
        }
        setHeaderScroll(round);
        if (round != 0) {
            if (this.state == 0 && this.bHe < Math.abs(round)) {
                this.state = 1;
                switch (this.bGY) {
                    case 1:
                        this.bHc.mO();
                        break;
                    case 2:
                        this.bHd.mO();
                        break;
                }
                return true;
            } else if (this.state == 1 && this.bHe >= Math.abs(round)) {
                this.state = 0;
                switch (this.bGY) {
                    case 1:
                        this.bHc.ne();
                        break;
                    case 2:
                        this.bHd.ne();
                        break;
                }
                return true;
            }
        }
        return scrollY != round;
    }

    private boolean nj() {
        switch (this.mode) {
            case 1:
                return YU();
            case 2:
                return YV();
            case 3:
                return YV() || YU();
            default:
                return false;
        }
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public void YY() {
        if (this.bHc != null) {
            this.bHc.rk();
        }
        if (this.bHd != null) {
            this.bHd.rk();
        }
    }
}
