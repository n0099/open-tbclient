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
    private boolean oRp;
    private boolean oZV;
    private SwipeRefreshLayout oZW;
    private SwipeListView oZX;
    private int oZY;
    private boolean oZZ;
    private int paa;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.oZV = false;
        this.isOpen = false;
        this.oRp = true;
        this.oZW = null;
        this.oZX = null;
        this.oZZ = false;
        this.paa = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oZV = false;
        this.isOpen = false;
        this.oRp = true;
        this.oZW = null;
        this.oZX = null;
        this.oZZ = false;
        this.paa = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oZV = false;
        this.isOpen = false;
        this.oRp = true;
        this.oZW = null;
        this.oZX = null;
        this.oZZ = false;
        this.paa = (int) (20.0f * getResources().getDisplayMetrics().density);
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
        this.oRp = z;
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
            this.oZX = (SwipeListView) getParent().getParent();
            this.oZX.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.oZX.oZU != null) {
                        SwipeListViewScroll.this.oZX.oZU.v(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.oZX.oZU != null) {
                        return SwipeListViewScroll.this.oZX.oZU.L(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.oZX.oZT != null) {
                for (int i2 = 0; i2 < this.oZX.oZT.length; i2++) {
                    final int i3 = this.oZX.oZT[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.oZX.oZU != null) {
                                SwipeListViewScroll.this.oZX.oZU.a(i3, view, SwipeListViewScroll.this.index);
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
        this.oZW = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.oRp) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.oZX != null) {
                    this.oZX.ekD();
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
        if (this.oRp) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.paa) {
                    close();
                } else if (this.oZZ) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.oZY - scrollX) >= 0) {
                if (this.oZZ) {
                    if (this.oZY < scrollX) {
                        this.oZZ = false;
                    }
                } else if (this.oZY > scrollX) {
                    this.oZZ = true;
                }
                this.oZY = scrollX;
            }
            if (this.oZW != null) {
                if (motionEvent.getAction() != 2) {
                    this.oZW.setEnabled(true);
                } else {
                    this.oZW.setEnabled(false);
                }
            }
            if (!this.oZV) {
                this.oZV = true;
            }
            if (motionEvent.getAction() != 2) {
                this.oZV = false;
                this.oZY = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
