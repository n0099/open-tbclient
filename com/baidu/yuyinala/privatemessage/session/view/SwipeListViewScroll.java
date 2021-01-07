package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* loaded from: classes11.dex */
public class SwipeListViewScroll extends HorizontalScrollView {
    private View contentView;
    private int index;
    private boolean isOpen;
    private boolean oVQ;
    private SwipeRefreshLayout peA;
    private SwipeListView peB;
    private int peC;
    private boolean peD;
    private int peE;
    private boolean pez;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.pez = false;
        this.isOpen = false;
        this.oVQ = true;
        this.peA = null;
        this.peB = null;
        this.peD = false;
        this.peE = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pez = false;
        this.isOpen = false;
        this.oVQ = true;
        this.peA = null;
        this.peB = null;
        this.peD = false;
        this.peE = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pez = false;
        this.isOpen = false;
        this.oVQ = true;
        this.peA = null;
        this.peB = null;
        this.peD = false;
        this.peE = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.width = i3 - i;
            Pu(this.width);
            measureChildren(this.width, i4 - i2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCanSwipe(boolean z) {
        this.oVQ = z;
        if (!z && this.isOpen) {
            close();
        }
    }

    private void Pu(int i) {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        try {
            this.peB = (SwipeListView) getParent().getParent();
            this.peB.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.peB.pey != null) {
                        SwipeListViewScroll.this.peB.pey.v(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.peB.pey != null) {
                        return SwipeListViewScroll.this.peB.pey.L(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.peB.pex != null) {
                for (int i2 = 0; i2 < this.peB.pex.length; i2++) {
                    final int i3 = this.peB.pex[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.peB.pey != null) {
                                SwipeListViewScroll.this.peB.pey.a(i3, view, SwipeListViewScroll.this.index);
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
        this.peA = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.oVQ) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.peB != null) {
                    this.peB.eoz();
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
        if (this.oVQ) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.peE) {
                    close();
                } else if (this.peD) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.peC - scrollX) >= 0) {
                if (this.peD) {
                    if (this.peC < scrollX) {
                        this.peD = false;
                    }
                } else if (this.peC > scrollX) {
                    this.peD = true;
                }
                this.peC = scrollX;
            }
            if (this.peA != null) {
                if (motionEvent.getAction() != 2) {
                    this.peA.setEnabled(true);
                } else {
                    this.peA.setEnabled(false);
                }
            }
            if (!this.pez) {
                this.pez = true;
            }
            if (motionEvent.getAction() != 2) {
                this.pez = false;
                this.peC = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
