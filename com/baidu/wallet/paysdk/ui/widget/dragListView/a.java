package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes5.dex */
public class a extends b implements GestureDetector.OnGestureListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f26216a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26217b;

    /* renamed from: c  reason: collision with root package name */
    public int f26218c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26219d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26220e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f26221f;

    /* renamed from: g  reason: collision with root package name */
    public GestureDetector f26222g;

    /* renamed from: h  reason: collision with root package name */
    public int f26223h;
    public int i;
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
        if (this.f26219d && this.f26218c == 0) {
            this.k = a(motionEvent, this.t);
        }
        int a2 = a(motionEvent);
        this.i = a2;
        if (a2 != -1 && this.f26216a == 0) {
            a(a2, ((int) motionEvent.getX()) - this.m, ((int) motionEvent.getY()) - this.n);
        }
        this.f26220e = false;
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
        if (this.i != -1) {
            this.w.performHapticFeedback(0);
            a(this.i, this.o - this.m, this.p - this.n);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.m;
        int i2 = y2 - this.n;
        if (this.v && !this.q && (this.i != -1 || this.j != -1)) {
            if (this.i != -1) {
                if (this.f26216a == 1 && Math.abs(y2 - y) > this.f26223h && this.f26217b) {
                    a(this.i, i, i2);
                } else if (this.f26216a != 0 && Math.abs(x2 - x) > this.f26223h && this.f26219d) {
                    this.f26220e = true;
                    a(this.j, i, i2);
                }
            } else if (this.j != -1) {
                if (Math.abs(x2 - x) > this.f26223h && this.f26219d) {
                    this.f26220e = true;
                    a(this.j, i, i2);
                } else if (Math.abs(y2 - y) > this.f26223h) {
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
        int i;
        if (this.f26219d && this.f26218c == 0 && (i = this.k) != -1) {
            DragSortListView dragSortListView = this.w;
            dragSortListView.removeItem(i - dragSortListView.getHeaderViewsCount());
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
            this.f26221f.onTouchEvent(motionEvent);
            if (this.f26219d && this.q && this.f26218c == 1) {
                this.f26222g.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1) {
                    if (this.f26219d && this.f26220e) {
                        int i = this.x;
                        if (i < 0) {
                            i = -i;
                        }
                        if (i > this.w.getWidth() / 2) {
                            this.w.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                }
                this.f26220e = false;
                this.q = false;
            } else {
                this.o = (int) motionEvent.getX();
                this.p = (int) motionEvent.getY();
            }
        }
        return false;
    }

    public a(DragSortListView dragSortListView, int i, int i2, int i3) {
        this(dragSortListView, i, i2, i3, 0);
    }

    public void b(int i) {
        this.f26218c = i;
    }

    public void c(int i) {
        this.s = i;
    }

    public int d(MotionEvent motionEvent) {
        return a(motionEvent, this.u);
    }

    public a(DragSortListView dragSortListView, int i, int i2, int i3, int i4) {
        this(dragSortListView, i, i2, i3, i4, 0);
    }

    public void a(int i) {
        this.f26216a = i;
    }

    public void b(boolean z) {
        this.f26219d = z;
    }

    public int c(MotionEvent motionEvent) {
        return a(motionEvent, this.s);
    }

    public a(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.f26216a = 0;
        this.f26217b = true;
        this.f26219d = false;
        this.f26220e = false;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = new int[2];
        this.q = false;
        this.r = 500.0f;
        this.y = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.f26219d && a.this.f26220e) {
                    int width = a.this.w.getWidth() / 5;
                    if (f2 > a.this.r) {
                        if (a.this.x > (-width)) {
                            a.this.w.stopDragWithVelocity(true, f2);
                        }
                    } else if (f2 < (-a.this.r) && a.this.x < width) {
                        a.this.w.stopDragWithVelocity(true, f2);
                    }
                    a.this.f26220e = false;
                }
                return false;
            }
        };
        this.w = dragSortListView;
        this.f26221f = new GestureDetector(dragSortListView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(dragSortListView.getContext(), this.y);
        this.f26222g = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f26223h = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.s = i;
        this.t = i4;
        this.u = i5;
        b(i3);
        a(i2);
    }

    public void a(boolean z) {
        this.f26217b = z;
    }

    public int b(MotionEvent motionEvent) {
        if (this.f26218c == 1) {
            return d(motionEvent);
        }
        return -1;
    }

    public boolean a(int i, int i2, int i3) {
        int i4 = (!this.f26217b || this.f26220e) ? 0 : 12;
        if (this.f26219d && this.f26220e) {
            i4 = i4 | 1 | 2;
        }
        DragSortListView dragSortListView = this.w;
        boolean startDrag = dragSortListView.startDrag(i - dragSortListView.getHeaderViewsCount(), i4, i2, i3);
        this.q = startDrag;
        return startDrag;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.b, com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
        if (this.f26219d && this.f26220e) {
            this.x = point.x;
        }
    }

    public int a(MotionEvent motionEvent) {
        return c(motionEvent);
    }

    public int a(MotionEvent motionEvent, int i) {
        int pointToPosition = this.w.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.w.getHeaderViewsCount();
        int footerViewsCount = this.w.getFooterViewsCount();
        int count = this.w.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.w;
            View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
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
