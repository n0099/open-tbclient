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
    private boolean peh;
    private boolean pmR;
    private SwipeRefreshLayout pmS;
    private SwipeListView pmT;
    private int pmU;
    private boolean pmV;
    private int pmW;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.pmR = false;
        this.isOpen = false;
        this.peh = true;
        this.pmS = null;
        this.pmT = null;
        this.pmV = false;
        this.pmW = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pmR = false;
        this.isOpen = false;
        this.peh = true;
        this.pmS = null;
        this.pmT = null;
        this.pmV = false;
        this.pmW = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pmR = false;
        this.isOpen = false;
        this.peh = true;
        this.pmS = null;
        this.pmT = null;
        this.pmV = false;
        this.pmW = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.width = i3 - i;
            On(this.width);
            measureChildren(this.width, i4 - i2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCanSwipe(boolean z) {
        this.peh = z;
        if (!z && this.isOpen) {
            close();
        }
    }

    private void On(int i) {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        try {
            this.pmT = (SwipeListView) getParent().getParent();
            this.pmT.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.pmT.pmQ != null) {
                        SwipeListViewScroll.this.pmT.pmQ.v(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.pmT.pmQ != null) {
                        return SwipeListViewScroll.this.pmT.pmQ.L(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.pmT.pmP != null) {
                for (int i2 = 0; i2 < this.pmT.pmP.length; i2++) {
                    final int i3 = this.pmT.pmP[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.pmT.pmQ != null) {
                                SwipeListViewScroll.this.pmT.pmQ.a(i3, view, SwipeListViewScroll.this.index);
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
        this.pmS = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.peh) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.pmT != null) {
                    this.pmT.eno();
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
        if (this.peh) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.pmW) {
                    close();
                } else if (this.pmV) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.pmU - scrollX) >= 0) {
                if (this.pmV) {
                    if (this.pmU < scrollX) {
                        this.pmV = false;
                    }
                } else if (this.pmU > scrollX) {
                    this.pmV = true;
                }
                this.pmU = scrollX;
            }
            if (this.pmS != null) {
                if (motionEvent.getAction() != 2) {
                    this.pmS.setEnabled(true);
                } else {
                    this.pmS.setEnabled(false);
                }
            }
            if (!this.pmR) {
                this.pmR = true;
            }
            if (motionEvent.getAction() != 2) {
                this.pmR = false;
                this.pmU = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
