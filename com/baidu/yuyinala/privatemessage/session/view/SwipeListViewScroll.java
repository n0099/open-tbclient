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
    private boolean oPG;
    private boolean oYq;
    private SwipeRefreshLayout oYr;
    private SwipeListView oYs;
    private int oYt;
    private boolean oYu;
    private int oYv;
    private int width;

    public SwipeListViewScroll(Context context) {
        super(context);
        this.oYq = false;
        this.isOpen = false;
        this.oPG = true;
        this.oYr = null;
        this.oYs = null;
        this.oYu = false;
        this.oYv = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oYq = false;
        this.isOpen = false;
        this.oPG = true;
        this.oYr = null;
        this.oYs = null;
        this.oYu = false;
        this.oYv = (int) (20.0f * getResources().getDisplayMetrics().density);
        this.width = 0;
        this.index = -1;
    }

    public SwipeListViewScroll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oYq = false;
        this.isOpen = false;
        this.oPG = true;
        this.oYr = null;
        this.oYs = null;
        this.oYu = false;
        this.oYv = (int) (20.0f * getResources().getDisplayMetrics().density);
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
        this.oPG = z;
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
            this.oYs = (SwipeListView) getParent().getParent();
            this.oYs.a(this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.contentView = linearLayout.getChildAt(0);
            this.contentView.setFocusable(true);
            this.contentView.setClickable(true);
            this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwipeListViewScroll.this.oYs.oYp != null) {
                        SwipeListViewScroll.this.oYs.oYp.s(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                }
            });
            this.contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (SwipeListViewScroll.this.oYs.oYp != null) {
                        return SwipeListViewScroll.this.oYs.oYp.G(SwipeListViewScroll.this, SwipeListViewScroll.this.index);
                    }
                    return false;
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
            layoutParams.width = i;
            this.contentView.setLayoutParams(layoutParams);
            if (this.oYs.oYo != null) {
                for (int i2 = 0; i2 < this.oYs.oYo.length; i2++) {
                    final int i3 = this.oYs.oYo[i2];
                    linearLayout.findViewById(i3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (SwipeListViewScroll.this.oYs.oYp != null) {
                                SwipeListViewScroll.this.oYs.oYp.a(i3, view, SwipeListViewScroll.this.index);
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
        this.oYr = swipeRefreshLayout;
    }

    public void close() {
        smoothScrollTo(0, 0);
        this.isOpen = false;
    }

    public void open() {
        if (!this.oPG) {
            this.isOpen = false;
        } else if (this.contentView != null) {
            try {
                if (this.oYs != null) {
                    this.oYs.eoq();
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
        if (this.oPG) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            int scrollX = getScrollX();
            if (motionEvent.getAction() != 2) {
                if (scrollX < this.oYv) {
                    close();
                } else if (this.oYu) {
                    close();
                } else {
                    open();
                }
            }
            if (Math.abs(this.oYt - scrollX) >= 0) {
                if (this.oYu) {
                    if (this.oYt < scrollX) {
                        this.oYu = false;
                    }
                } else if (this.oYt > scrollX) {
                    this.oYu = true;
                }
                this.oYt = scrollX;
            }
            if (this.oYr != null) {
                if (motionEvent.getAction() != 2) {
                    this.oYr.setEnabled(true);
                } else {
                    this.oYr.setEnabled(false);
                }
            }
            if (!this.oYq) {
                this.oYq = true;
            }
            if (motionEvent.getAction() != 2) {
                this.oYq = false;
                this.oYt = scrollX;
            }
            return onTouchEvent;
        }
        return false;
    }
}
