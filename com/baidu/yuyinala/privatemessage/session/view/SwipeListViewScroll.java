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
    private boolean oHE;
    private SwipeRefreshLayout oHF;
    private SwipeListView oHG;
    private int oHH;
    private boolean oHI;
    private int oHJ;
    private boolean oyU;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.oHE = false;
        this.isOpen = false;
        this.oyU = true;
        this.oHF = null;
        this.oHG = null;
        this.oHI = false;
        this.oHJ = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oHE = false;
        this.isOpen = false;
        this.oyU = true;
        this.oHF = null;
        this.oHG = null;
        this.oHI = false;
        this.oHJ = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oHE = false;
        this.isOpen = false;
        this.oyU = true;
        this.oHF = null;
        this.oHG = null;
        this.oHI = false;
        this.oHJ = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.width = i3 - i;
            Of(this.width);
            measureChildren(this.width, i4 - i2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCanSwipe(boolean z) {
        this.oyU = z;
        if (!z && this.isOpen) {
            close();
        }
    }

    private void Of(int i) {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        try {
            this.oHG = (SwipeListView) getParent().getParent();
            this.oHG.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.oHG.oHD != null) {
                        SwipeListViewScroll.this.oHG.oHD.p(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.oHG.oHD != null) {
                        return SwipeListViewScroll.this.oHG.oHD.E(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.oHG.oHC != null) {
                for (int i2 = 0; i2 < this.oHG.oHC.length; i2++) {
                    final int i3 = this.oHG.oHC[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.oHG.oHD != null) {
                                SwipeListViewScroll.this.oHG.oHD.a(i3, view, SwipeListViewScroll.this.index);
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
        this.oHF = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.oyU) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.oHG != null) {
                    this.oHG.eiB();
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
        if (this.oyU) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.oHJ) {
                    close();
                } else if (this.oHI) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.oHH - scrollX) >= 0) {
                if (this.oHI) {
                    if (this.oHH < scrollX) {
                        this.oHI = false;
                    }
                } else if (this.oHH > scrollX) {
                    this.oHI = true;
                }
                this.oHH = scrollX;
            }
            if (this.oHF != null) {
                if (motionEvent.getAction() != 2) {
                    this.oHF.setEnabled(true);
                } else {
                    this.oHF.setEnabled(false);
                }
            }
            if (!this.oHE) {
                this.oHE = true;
            }
            if (motionEvent.getAction() != 2) {
                this.oHE = false;
                this.oHH = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
