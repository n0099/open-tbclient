package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* loaded from: classes10.dex */
public class SwipeListViewScroll extends HorizontalScrollView {
    private View contentView;
    private int index;
    private boolean isOpen;
    private boolean oRo;
    private boolean oZU;
    private SwipeRefreshLayout oZV;
    private SwipeListView oZW;
    private int oZX;
    private boolean oZY;
    private int oZZ;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.oZU = false;
        this.isOpen = false;
        this.oRo = true;
        this.oZV = null;
        this.oZW = null;
        this.oZY = false;
        this.oZZ = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oZU = false;
        this.isOpen = false;
        this.oRo = true;
        this.oZV = null;
        this.oZW = null;
        this.oZY = false;
        this.oZZ = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oZU = false;
        this.isOpen = false;
        this.oRo = true;
        this.oZV = null;
        this.oZW = null;
        this.oZY = false;
        this.oZZ = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.width = i3 - i;
            NN(this.width);
            measureChildren(this.width, i4 - i2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCanSwipe(boolean z) {
        this.oRo = z;
        if (!z && this.isOpen) {
            close();
        }
    }

    private void NN(int i) {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        try {
            this.oZW = (SwipeListView) getParent().getParent();
            this.oZW.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.oZW.oZT != null) {
                        SwipeListViewScroll.this.oZW.oZT.v(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.oZW.oZT != null) {
                        return SwipeListViewScroll.this.oZW.oZT.L(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.oZW.oZS != null) {
                for (int i2 = 0; i2 < this.oZW.oZS.length; i2++) {
                    final int i3 = this.oZW.oZS[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.oZW.oZT != null) {
                                SwipeListViewScroll.this.oZW.oZT.a(i3, view, SwipeListViewScroll.this.index);
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setSwipe(SwipeRefreshLayout swipeRefreshLayout) {
        this.oZV = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.oRo) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.oZW != null) {
                    this.oZW.ekD();
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
        if (this.oRo) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.oZZ) {
                    close();
                } else if (this.oZY) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.oZX - scrollX) >= 0) {
                if (this.oZY) {
                    if (this.oZX < scrollX) {
                        this.oZY = false;
                    }
                } else if (this.oZX > scrollX) {
                    this.oZY = true;
                }
                this.oZX = scrollX;
            }
            if (this.oZV != null) {
                if (motionEvent.getAction() != 2) {
                    this.oZV.setEnabled(true);
                } else {
                    this.oZV.setEnabled(false);
                }
            }
            if (!this.oZU) {
                this.oZU = true;
            }
            if (motionEvent.getAction() != 2) {
                this.oZU = false;
                this.oZX = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
