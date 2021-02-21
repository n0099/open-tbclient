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
    private boolean pcb;
    private boolean pkM;
    private SwipeRefreshLayout pkN;
    private SwipeListView pkO;
    private int pkP;
    private boolean pkQ;
    private int pkR;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.pkM = false;
        this.isOpen = false;
        this.pcb = true;
        this.pkN = null;
        this.pkO = null;
        this.pkQ = false;
        this.pkR = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pkM = false;
        this.isOpen = false;
        this.pcb = true;
        this.pkN = null;
        this.pkO = null;
        this.pkQ = false;
        this.pkR = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pkM = false;
        this.isOpen = false;
        this.pcb = true;
        this.pkN = null;
        this.pkO = null;
        this.pkQ = false;
        this.pkR = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.width = i3 - i;
            Oj(this.width);
            measureChildren(this.width, i4 - i2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCanSwipe(boolean z) {
        this.pcb = z;
        if (!z && this.isOpen) {
            close();
        }
    }

    private void Oj(int i) {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        try {
            this.pkO = (SwipeListView) getParent().getParent();
            this.pkO.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.pkO.pkL != null) {
                        SwipeListViewScroll.this.pkO.pkL.v(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.pkO.pkL != null) {
                        return SwipeListViewScroll.this.pkO.pkL.L(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.pkO.pkK != null) {
                for (int i2 = 0; i2 < this.pkO.pkK.length; i2++) {
                    final int i3 = this.pkO.pkK[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.pkO.pkL != null) {
                                SwipeListViewScroll.this.pkO.pkL.a(i3, view, SwipeListViewScroll.this.index);
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
        this.pkN = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.pcb) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.pkO != null) {
                    this.pkO.ene();
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
        if (this.pcb) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.pkR) {
                    close();
                } else if (this.pkQ) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.pkP - scrollX) >= 0) {
                if (this.pkQ) {
                    if (this.pkP < scrollX) {
                        this.pkQ = false;
                    }
                } else if (this.pkP > scrollX) {
                    this.pkQ = true;
                }
                this.pkP = scrollX;
            }
            if (this.pkN != null) {
                if (motionEvent.getAction() != 2) {
                    this.pkN.setEnabled(true);
                } else {
                    this.pkN.setEnabled(false);
                }
            }
            if (!this.pkM) {
                this.pkM = true;
            }
            if (motionEvent.getAction() != 2) {
                this.pkM = false;
                this.pkP = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
