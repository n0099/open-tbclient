package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
public class SwipeListViewScroll extends HorizontalScrollView {
    private View contentView;
    private int index;
    private boolean isOpen;
    private boolean opA;
    private boolean oym;
    private SwipeRefreshLayout oyn;
    private SwipeListView oyo;
    private int oyp;
    private boolean oyq;
    private int oyr;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.oym = false;
        this.isOpen = false;
        this.opA = true;
        this.oyn = null;
        this.oyo = null;
        this.oyq = false;
        this.oyr = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oym = false;
        this.isOpen = false;
        this.opA = true;
        this.oyn = null;
        this.oyo = null;
        this.oyq = false;
        this.oyr = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oym = false;
        this.isOpen = false;
        this.opA = true;
        this.oyn = null;
        this.oyo = null;
        this.oyq = false;
        this.oyr = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.width = i3 - i;
            NK(this.width);
            measureChildren(this.width, i4 - i2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCanSwipe(boolean z) {
        this.opA = z;
        if (!z && this.isOpen) {
            close();
        }
    }

    private void NK(int i) {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        try {
            this.oyo = (SwipeListView) getParent().getParent();
            this.oyo.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.oyo.oyl != null) {
                        SwipeListViewScroll.this.oyo.oyl.p(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.oyo.oyl != null) {
                        return SwipeListViewScroll.this.oyo.oyl.E(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.oyo.oyk != null) {
                for (int i2 = 0; i2 < this.oyo.oyk.length; i2++) {
                    final int i3 = this.oyo.oyk[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.oyo.oyl != null) {
                                SwipeListViewScroll.this.oyo.oyl.a(i3, view, SwipeListViewScroll.this.index);
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setSwipe(SwipeRefreshLayout swipeRefreshLayout) {
        this.oyn = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.opA) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.oyo != null) {
                    this.oyo.eeM();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            smoothScrollTo(this.contentView.getWidth(), 0);
            this.isOpen = true;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.opA) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.oyr) {
                    close();
                } else if (this.oyq) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.oyp - scrollX) >= 0) {
                if (this.oyq) {
                    if (this.oyp < scrollX) {
                        this.oyq = false;
                    }
                } else if (this.oyp > scrollX) {
                    this.oyq = true;
                }
                this.oyp = scrollX;
            }
            if (this.oyn != null) {
                if (motionEvent.getAction() != 2) {
                    this.oyn.setEnabled(true);
                } else {
                    this.oyn.setEnabled(false);
                }
            }
            if (!this.oym) {
                this.oym = true;
            }
            if (motionEvent.getAction() != 2) {
                this.oym = false;
                this.oyp = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
