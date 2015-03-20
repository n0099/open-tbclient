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
    private int Hm;
    private float bGH;
    private float bGI;
    private float bGJ;
    private boolean bGK;
    private int bGL;
    private boolean bGM;
    T bGN;
    private boolean bGO;
    private a bGP;
    private a bGQ;
    private int bGR;
    private c bGS;
    private b<T>.d bGT;
    private final Handler handler;
    private int mode;
    private int state;

    protected abstract boolean YI();

    protected abstract boolean YJ();

    protected abstract T c(Context context, AttributeSet attributeSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d implements Runnable {
        private final int bGU;
        private final int bGV;
        private final Handler handler;
        private boolean bGW = true;
        private long startTime = -1;
        private int bGX = -1;
        private final Interpolator bGE = new AccelerateDecelerateInterpolator();

        public d(Handler handler, int i, int i2) {
            this.handler = handler;
            this.bGV = i;
            this.bGU = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                this.bGX = this.bGV - Math.round(this.bGE.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L)) / 1000.0f) * (this.bGV - this.bGU));
                b.this.setHeaderScroll(this.bGX);
            }
            if (this.bGW && this.bGU != this.bGX) {
                this.handler.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.bGW = false;
            this.handler.removeCallbacks(this);
        }
    }

    public b(Context context) {
        super(context);
        this.bGK = false;
        this.state = 0;
        this.mode = 1;
        this.bGM = true;
        this.bGO = true;
        this.handler = new Handler();
        init(context, null);
    }

    public b(Context context, int i) {
        super(context);
        this.bGK = false;
        this.state = 0;
        this.mode = 1;
        this.bGM = true;
        this.bGO = true;
        this.handler = new Handler();
        this.mode = i;
        init(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGK = false;
        this.state = 0;
        this.mode = 1;
        this.bGM = true;
        this.bGO = true;
        this.handler = new Handler();
        init(context, attributeSet);
    }

    public final T getAdapterView() {
        return this.bGN;
    }

    public final T getRefreshableView() {
        return this.bGN;
    }

    public final boolean YG() {
        return this.state == 2 || this.state == 3;
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        this.bGM = z;
    }

    public final void YH() {
        if (this.state != 0) {
            YK();
        }
    }

    public final void setOnRefreshListener(c cVar) {
        this.bGS = cVar;
    }

    public final void setPullToRefreshEnabled(boolean z) {
        this.bGO = z;
    }

    public void setReleaseLabel(String str) {
        if (this.bGP != null) {
            this.bGP.setReleaseLabel(str);
        }
        if (this.bGQ != null) {
            this.bGQ.setReleaseLabel(str);
        }
    }

    public void setPullLabel(String str) {
        if (this.bGP != null) {
            this.bGP.setPullLabel(str);
        }
        if (this.bGQ != null) {
            this.bGQ.setPullLabel(str);
        }
    }

    public void setRefreshingLabel(String str) {
        if (this.bGP != null) {
            this.bGP.setRefreshingLabel(str);
        }
        if (this.bGQ != null) {
            this.bGQ.setRefreshingLabel(str);
        }
    }

    public final void setRefreshing(boolean z) {
        if (!YG()) {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bGO) {
            if (YG() && this.bGM) {
                return true;
            }
            if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (nj()) {
                            float y = motionEvent.getY();
                            this.bGH = y;
                            this.bGJ = y;
                            return true;
                        }
                        return false;
                    case 1:
                    case 3:
                        if (this.bGK) {
                            this.bGK = false;
                            if (this.state == 1 && this.bGS != null) {
                                setRefreshingInternal(true);
                                this.bGS.hb(this.bGL);
                            } else {
                                he(0);
                            }
                            return true;
                        }
                        return false;
                    case 2:
                        if (this.bGK) {
                            this.bGJ = motionEvent.getY();
                            YL();
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
        if (this.bGO) {
            if (YG() && this.bGM) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.bGK = false;
                return false;
            } else if (action == 0 || !this.bGK) {
                switch (action) {
                    case 0:
                        if (nj()) {
                            float y = motionEvent.getY();
                            this.bGH = y;
                            this.bGJ = y;
                            this.bGI = motionEvent.getX();
                            this.bGK = false;
                            break;
                        }
                        break;
                    case 2:
                        if (nj()) {
                            float y2 = motionEvent.getY();
                            float f = y2 - this.bGJ;
                            float abs = Math.abs(f);
                            float abs2 = Math.abs(motionEvent.getX() - this.bGI);
                            if (abs > this.Hm && abs > abs2) {
                                if ((this.mode == 1 || this.mode == 3) && f >= 1.0E-4f && YI()) {
                                    this.bGJ = y2;
                                    this.bGK = true;
                                    if (this.mode == 3) {
                                        this.bGL = 1;
                                        break;
                                    }
                                } else if ((this.mode == 2 || this.mode == 3) && f <= 1.0E-4f && YJ()) {
                                    this.bGJ = y2;
                                    this.bGK = true;
                                    if (this.mode == 3) {
                                        this.bGL = 2;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
                return this.bGK;
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
        return this.bGL;
    }

    protected final a getFooterLayout() {
        return this.bGQ;
    }

    protected final a getHeaderLayout() {
        return this.bGP;
    }

    protected final int getHeaderHeight() {
        return this.bGR;
    }

    protected final int getMode() {
        return this.mode;
    }

    protected void YK() {
        this.state = 0;
        this.bGK = false;
        if (this.bGP != null) {
            this.bGP.reset();
        }
        if (this.bGQ != null) {
            this.bGQ.reset();
        }
        he(0);
    }

    protected void setRefreshingInternal(boolean z) {
        this.state = 2;
        if (this.bGP != null) {
            this.bGP.mP();
        }
        if (this.bGQ != null) {
            this.bGQ.mP();
        }
        if (z) {
            he(this.bGL == 1 ? -this.bGR : this.bGR);
        }
    }

    protected final void setHeaderScroll(int i) {
        scrollTo(0, i);
    }

    public final void he(int i) {
        if (this.bGT != null) {
            this.bGT.stop();
        }
        if (getScrollY() != i) {
            this.bGT = new d(this.handler, getScrollY(), i);
            this.handler.post(this.bGT);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        this.Hm = ViewConfiguration.getTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.PullToRefresh);
        if (obtainStyledAttributes.hasValue(3)) {
            this.mode = obtainStyledAttributes.getInteger(3, 1);
        }
        this.bGN = c(context, attributeSet);
        f(context, this.bGN);
        String string = context.getString(y.chosen_pull_refresh);
        String string2 = context.getString(y.chosen_drag_refresh);
        String string3 = context.getString(y.chosen_release_refresh);
        if (this.mode == 1 || this.mode == 3) {
            this.bGP = new a(context, 1, string3, string, string2);
            addView(this.bGP, 0, new LinearLayout.LayoutParams(-1, -2));
            e(this.bGP);
            this.bGR = this.bGP.getMeasuredHeight();
        }
        if (this.mode == 2 || this.mode == 3) {
            this.bGQ = new a(context, 2, string3, string, string2);
            addView(this.bGQ, new LinearLayout.LayoutParams(-1, -2));
            e(this.bGQ);
            this.bGR = this.bGQ.getMeasuredHeight();
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
            if (this.bGP != null) {
                this.bGP.setTextColor(color);
            }
            if (this.bGQ != null) {
                this.bGQ.setTextColor(color);
            }
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setBackgroundResource(obtainStyledAttributes.getResourceId(1, -1));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.bGN.setBackgroundResource(obtainStyledAttributes.getResourceId(0, -1));
        }
        obtainStyledAttributes.recycle();
        switch (this.mode) {
            case 2:
                setPadding(0, 0, 0, -this.bGR);
                break;
            case 3:
                setPadding(0, -this.bGR, 0, -this.bGR);
                break;
            default:
                setPadding(0, -this.bGR, 0, 0);
                break;
        }
        if (this.mode != 3) {
            this.bGL = this.mode;
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

    private boolean YL() {
        int round;
        int scrollY = getScrollY();
        switch (this.bGL) {
            case 2:
                round = Math.round(Math.max(this.bGH - this.bGJ, 0.0f) / 2.0f);
                break;
            default:
                round = Math.round(Math.min(this.bGH - this.bGJ, 0.0f) / 2.0f);
                break;
        }
        setHeaderScroll(round);
        if (round != 0) {
            if (this.state == 0 && this.bGR < Math.abs(round)) {
                this.state = 1;
                switch (this.bGL) {
                    case 1:
                        this.bGP.mO();
                        break;
                    case 2:
                        this.bGQ.mO();
                        break;
                }
                return true;
            } else if (this.state == 1 && this.bGR >= Math.abs(round)) {
                this.state = 0;
                switch (this.bGL) {
                    case 1:
                        this.bGP.ne();
                        break;
                    case 2:
                        this.bGQ.ne();
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
                return YI();
            case 2:
                return YJ();
            case 3:
                return YJ() || YI();
            default:
                return false;
        }
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public void YM() {
        if (this.bGP != null) {
            this.bGP.rk();
        }
        if (this.bGQ != null) {
            this.bGQ.rk();
        }
    }
}
