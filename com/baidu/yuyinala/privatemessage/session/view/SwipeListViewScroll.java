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
    private boolean oPE;
    private boolean oYo;
    private SwipeRefreshLayout oYp;
    private SwipeListView oYq;
    private int oYr;
    private boolean oYs;
    private int oYt;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.oYo = false;
        this.isOpen = false;
        this.oPE = true;
        this.oYp = null;
        this.oYq = null;
        this.oYs = false;
        this.oYt = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oYo = false;
        this.isOpen = false;
        this.oPE = true;
        this.oYp = null;
        this.oYq = null;
        this.oYs = false;
        this.oYt = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oYo = false;
        this.isOpen = false;
        this.oPE = true;
        this.oYp = null;
        this.oYq = null;
        this.oYs = false;
        this.oYt = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.width = i3 - i;
            PG(this.width);
            measureChildren(this.width, i4 - i2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCanSwipe(boolean z) {
        this.oPE = z;
        if (!z && this.isOpen) {
            close();
        }
    }

    private void PG(int i) {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        try {
            this.oYq = (SwipeListView) getParent().getParent();
            this.oYq.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.oYq.oYn != null) {
                        SwipeListViewScroll.this.oYq.oYn.s(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.oYq.oYn != null) {
                        return SwipeListViewScroll.this.oYq.oYn.G(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.oYq.oYm != null) {
                for (int i2 = 0; i2 < this.oYq.oYm.length; i2++) {
                    final int i3 = this.oYq.oYm[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.oYq.oYn != null) {
                                SwipeListViewScroll.this.oYq.oYn.a(i3, view, SwipeListViewScroll.this.index);
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
        this.oYp = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.oPE) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.oYq != null) {
                    this.oYq.eop();
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
        if (this.oPE) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.oYt) {
                    close();
                } else if (this.oYs) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.oYr - scrollX) >= 0) {
                if (this.oYs) {
                    if (this.oYr < scrollX) {
                        this.oYs = false;
                    }
                } else if (this.oYr > scrollX) {
                    this.oYs = true;
                }
                this.oYr = scrollX;
            }
            if (this.oYp != null) {
                if (motionEvent.getAction() != 2) {
                    this.oYp.setEnabled(true);
                } else {
                    this.oYp.setEnabled(false);
                }
            }
            if (!this.oYo) {
                this.oYo = true;
            }
            if (motionEvent.getAction() != 2) {
                this.oYo = false;
                this.oYr = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
