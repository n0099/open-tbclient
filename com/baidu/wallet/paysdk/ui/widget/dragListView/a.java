package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes5.dex */
public class a extends b implements GestureDetector.OnGestureListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f27018a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27019b;

    /* renamed from: c  reason: collision with root package name */
    public int f27020c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27021d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27022e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f27023f;

    /* renamed from: g  reason: collision with root package name */
    public GestureDetector f27024g;

    /* renamed from: h  reason: collision with root package name */
    public int f27025h;

    /* renamed from: i  reason: collision with root package name */
    public int f27026i;
    public int j;
    public int k;
    public int[] l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public float r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public DragSortListView w;
    public int x;
    public GestureDetector.OnGestureListener y;

    public a(DragSortListView dragSortListView) {
        this(dragSortListView, 0, 0, 1);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.f27021d && this.f27020c == 0) {
            this.k = a(motionEvent, this.t);
        }
        int a2 = a(motionEvent);
        this.f27026i = a2;
        if (a2 != -1 && this.f27018a == 0) {
            a(a2, ((int) motionEvent.getX()) - this.m, ((int) motionEvent.getY()) - this.n);
        }
        this.f27022e = false;
        this.v = true;
        this.x = 0;
        this.j = b(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.f27026i != -1) {
            this.w.performHapticFeedback(0);
            a(this.f27026i, this.o - this.m, this.p - this.n);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i2 = x2 - this.m;
        int i3 = y2 - this.n;
        if (this.v && !this.q && (this.f27026i != -1 || this.j != -1)) {
            if (this.f27026i != -1) {
                if (this.f27018a == 1 && Math.abs(y2 - y) > this.f27025h && this.f27019b) {
                    a(this.f27026i, i2, i3);
                } else if (this.f27018a != 0 && Math.abs(x2 - x) > this.f27025h && this.f27021d) {
                    this.f27022e = true;
                    a(this.j, i2, i3);
                }
            } else if (this.j != -1) {
                if (Math.abs(x2 - x) > this.f27025h && this.f27021d) {
                    this.f27022e = true;
                    a(this.j, i2, i3);
                } else if (Math.abs(y2 - y) > this.f27025h) {
                    this.v = false;
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i2;
        if (this.f27021d && this.f27020c == 0 && (i2 = this.k) != -1) {
            DragSortListView dragSortListView = this.w;
            dragSortListView.removeItem(i2 - dragSortListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r3 != 3) goto L29;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.w.isDragEnabled() && !this.w.listViewIntercepted()) {
            this.f27023f.onTouchEvent(motionEvent);
            if (this.f27021d && this.q && this.f27020c == 1) {
                this.f27024g.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1) {
                    if (this.f27021d && this.f27022e) {
                        int i2 = this.x;
                        if (i2 < 0) {
                            i2 = -i2;
                        }
                        if (i2 > this.w.getWidth() / 2) {
                            this.w.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                }
                this.f27022e = false;
                this.q = false;
            } else {
                this.o = (int) motionEvent.getX();
                this.p = (int) motionEvent.getY();
            }
        }
        return false;
    }

    public a(DragSortListView dragSortListView, int i2, int i3, int i4) {
        this(dragSortListView, i2, i3, i4, 0);
    }

    public void b(int i2) {
        this.f27020c = i2;
    }

    public void c(int i2) {
        this.s = i2;
    }

    public int d(MotionEvent motionEvent) {
        return a(motionEvent, this.u);
    }

    public a(DragSortListView dragSortListView, int i2, int i3, int i4, int i5) {
        this(dragSortListView, i2, i3, i4, i5, 0);
    }

    public void a(int i2) {
        this.f27018a = i2;
    }

    public void b(boolean z) {
        this.f27021d = z;
    }

    public int c(MotionEvent motionEvent) {
        return a(motionEvent, this.s);
    }

    public a(DragSortListView dragSortListView, int i2, int i3, int i4, int i5, int i6) {
        super(dragSortListView);
        this.f27018a = 0;
        this.f27019b = true;
        this.f27021d = false;
        this.f27022e = false;
        this.f27026i = -1;
        this.j = -1;
        this.k = -1;
        this.l = new int[2];
        this.q = false;
        this.r = 500.0f;
        this.y = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.f27021d && a.this.f27022e) {
                    int width = a.this.w.getWidth() / 5;
                    if (f2 > a.this.r) {
                        if (a.this.x > (-width)) {
                            a.this.w.stopDragWithVelocity(true, f2);
                        }
                    } else if (f2 < (-a.this.r) && a.this.x < width) {
                        a.this.w.stopDragWithVelocity(true, f2);
                    }
                    a.this.f27022e = false;
                }
                return false;
            }
        };
        this.w = dragSortListView;
        this.f27023f = new GestureDetector(dragSortListView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(dragSortListView.getContext(), this.y);
        this.f27024g = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f27025h = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.s = i2;
        this.t = i5;
        this.u = i6;
        b(i4);
        a(i3);
    }

    public void a(boolean z) {
        this.f27019b = z;
    }

    public int b(MotionEvent motionEvent) {
        if (this.f27020c == 1) {
            return d(motionEvent);
        }
        return -1;
    }

    public boolean a(int i2, int i3, int i4) {
        int i5 = (!this.f27019b || this.f27022e) ? 0 : 12;
        if (this.f27021d && this.f27022e) {
            i5 = i5 | 1 | 2;
        }
        DragSortListView dragSortListView = this.w;
        boolean startDrag = dragSortListView.startDrag(i2 - dragSortListView.getHeaderViewsCount(), i5, i3, i4);
        this.q = startDrag;
        return startDrag;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.b, com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
        if (this.f27021d && this.f27022e) {
            this.x = point.x;
        }
    }

    public int a(MotionEvent motionEvent) {
        return c(motionEvent);
    }

    public int a(MotionEvent motionEvent, int i2) {
        int pointToPosition = this.w.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.w.getHeaderViewsCount();
        int footerViewsCount = this.w.getFooterViewsCount();
        int count = this.w.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.w;
            View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i2 == 0 ? childAt : childAt.findViewById(i2);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.l);
                int[] iArr = this.l;
                if (rawX > iArr[0] && rawY > iArr[1] && rawX < iArr[0] + findViewById.getWidth() && rawY < this.l[1] + findViewById.getHeight()) {
                    this.m = childAt.getLeft();
                    this.n = childAt.getTop();
                    return pointToPosition;
                }
            }
        }
        return -1;
    }
}
