package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.tieba.R;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WaterFallView extends ScrollView {
    private static final int ITEM_MARGIN = 3;
    private static final int STOP_SCROLL = 101;
    private int mBottomOffset;
    private View mFooter;
    private Handler mHandler;
    private View mHeader;
    private View mHeader2;
    private int mHeight;
    private int mItemMargin;
    private LinearLayout mLine1;
    private LinearLayout mLine2;
    private LineHeight mLineHeight1;
    private LineHeight mLineHeight2;
    private int mLineWidth;
    private OnScrollListener mOnScrollListener;
    private LinearLayout mParentView;
    private int mScrollHeight;

    /* loaded from: classes.dex */
    public interface OnScrollListener {
        void onBottom();

        void onScroll();

        void onStop();

        void onTop();
    }

    public WaterFallView(Context context) {
        super(context);
        this.mItemMargin = 0;
        this.mParentView = null;
        this.mLine1 = null;
        this.mLineHeight1 = null;
        this.mLine2 = null;
        this.mLineHeight2 = null;
        this.mHeader = null;
        this.mHeader2 = null;
        this.mFooter = null;
        this.mLineWidth = 0;
        this.mHandler = null;
        this.mHeight = 0;
        this.mScrollHeight = 0;
        this.mBottomOffset = 20;
        this.mOnScrollListener = null;
        init();
    }

    public WaterFallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mItemMargin = 0;
        this.mParentView = null;
        this.mLine1 = null;
        this.mLineHeight1 = null;
        this.mLine2 = null;
        this.mLineHeight2 = null;
        this.mHeader = null;
        this.mHeader2 = null;
        this.mFooter = null;
        this.mLineWidth = 0;
        this.mHandler = null;
        this.mHeight = 0;
        this.mScrollHeight = 0;
        this.mBottomOffset = 20;
        this.mOnScrollListener = null;
        init();
    }

    public WaterFallView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mItemMargin = 0;
        this.mParentView = null;
        this.mLine1 = null;
        this.mLineHeight1 = null;
        this.mLine2 = null;
        this.mLineHeight2 = null;
        this.mHeader = null;
        this.mHeader2 = null;
        this.mFooter = null;
        this.mLineWidth = 0;
        this.mHandler = null;
        this.mHeight = 0;
        this.mScrollHeight = 0;
        this.mBottomOffset = 20;
        this.mOnScrollListener = null;
        init();
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void addHeader(View view) {
        if (this.mHeader != null) {
            this.mParentView.removeView(this.mHeader);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        this.mParentView.addView(view, 0, params);
        this.mHeader = view;
    }

    public View getHeader() {
        return this.mHeader;
    }

    public void addHeader2(View view) {
        if (this.mHeader2 != null) {
            this.mParentView.removeView(this.mHeader2);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        if (this.mHeader == null) {
            this.mParentView.addView(view, 0, params);
        } else {
            this.mParentView.addView(view, 1, params);
        }
        this.mHeader2 = view;
    }

    public void removeHeader2() {
        if (this.mHeader2 != null) {
            this.mParentView.removeView(this.mHeader2);
            this.mHeader2 = null;
        }
    }

    public View getHeader2() {
        return this.mHeader2;
    }

    public void addFooter(View view) {
        if (this.mFooter != null) {
            this.mParentView.removeView(this.mFooter);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        this.mParentView.addView(view, params);
        this.mFooter = view;
    }

    public View getFooter() {
        return this.mFooter;
    }

    private void init() {
        this.mLineHeight1 = new LineHeight();
        this.mLineHeight2 = new LineHeight();
        this.mBottomOffset = UtilHelper.dip2px(getContext(), 20.0f);
        this.mItemMargin = UtilHelper.dip2px(getContext(), 3.0f);
        LayoutInflater mInflater = LayoutInflater.from(getContext());
        this.mParentView = (LinearLayout) mInflater.inflate(R.layout.water_fall_view, (ViewGroup) null);
        addView(this.mParentView);
        this.mLine1 = (LinearLayout) this.mParentView.findViewById(R.id.line1);
        this.mLine2 = (LinearLayout) this.mParentView.findViewById(R.id.line2);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(UtilHelper.getEquipmentWidth(getContext()), 1073741824);
        measure(widthMeasureSpec, 0);
        this.mLineWidth = this.mLine1.getMeasuredWidth();
        initHandler();
    }

    public int getLineWidth() {
        return this.mLineWidth;
    }

    private void initHandler() {
        this.mHandler = new Handler() { // from class: com.baidu.tieba.view.WaterFallView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 101 && WaterFallView.this.mOnScrollListener != null) {
                    WaterFallView.this.mOnScrollListener.onStop();
                }
            }
        };
    }

    @Override // android.view.View
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        this.mHandler.removeMessages(101);
        boolean stop = false;
        if (this.mScrollHeight - this.mHeight == t) {
            stop = true;
        }
        if (t == 0 || stop) {
            try {
                Field filed = UtilHelper.getDeclaredField(this, "mScroller");
                Object ob = filed.get(this);
                if (ob != null && (ob instanceof Scroller)) {
                    Scroller sc = (Scroller) ob;
                    sc.abortAnimation();
                }
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "onScrollChanged", e.getMessage());
            }
        }
        if (this.mOnScrollListener != null) {
            if (t == 0) {
                this.mOnScrollListener.onTop();
            } else if (this.mParentView.getHeight() - this.mBottomOffset <= getScrollY() + getHeight() && t > oldt && this.mOnScrollListener != null) {
                this.mOnScrollListener.onBottom();
            }
            this.mOnScrollListener.onScroll();
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101), 300L);
        }
    }

    public void addItem(View view, int height) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, height);
        params.topMargin = this.mItemMargin;
        params.bottomMargin = this.mItemMargin;
        if (this.mLineHeight1.getHeight() <= this.mLineHeight2.getHeight()) {
            this.mLine1.addView(view, params);
            this.mLineHeight1.addItem((this.mItemMargin * 2) + height);
            return;
        }
        this.mLine2.addView(view, params);
        this.mLineHeight2.addItem((this.mItemMargin * 2) + height);
    }

    public LinearLayout getLine(int index) {
        return index == 2 ? this.mLine2 : this.mLine1;
    }

    public int getFirstVisibleIndex(int line_index) {
        Rect rect = new Rect();
        if (line_index == 2) {
            this.mLine2.getLocalVisibleRect(rect);
            int index = this.mLineHeight2.getTop(rect.top);
            return index;
        }
        this.mLine1.getLocalVisibleRect(rect);
        int index2 = this.mLineHeight1.getTop(rect.top);
        return index2;
    }

    public int getLastVisibleIndex(int line_index) {
        Rect rect = new Rect();
        if (line_index == 2) {
            this.mLine2.getLocalVisibleRect(rect);
            int index = this.mLineHeight2.getBottom(rect.bottom);
            return index;
        }
        this.mLine1.getLocalVisibleRect(rect);
        int index2 = this.mLineHeight1.getBottom(rect.bottom);
        return index2;
    }

    public void removeAllItems() {
        this.mLine1.removeAllViews();
        this.mLineHeight1.reset();
        this.mLine2.removeAllViews();
        this.mLineHeight2.reset();
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.mScrollHeight = super.computeVerticalScrollRange();
        return this.mScrollHeight;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.mHeight = b - t;
        }
        this.mHandler.removeMessages(101);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101), 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LineHeight {
        int mHeigh = 0;
        ArrayList<int[]> mItemsHeight = new ArrayList<>();

        public LineHeight() {
        }

        public void addItem(int height) {
            this.mHeigh += height;
            int[] sign = {this.mHeigh, this.mHeigh};
            this.mItemsHeight.add(sign);
        }

        public void reset() {
            this.mHeigh = 0;
            this.mItemsHeight.clear();
        }

        public int getHeight() {
            return this.mHeigh;
        }

        public int getTop(int top) {
            int num = this.mItemsHeight.size();
            for (int i = 0; i < num; i++) {
                if (this.mItemsHeight.get(i)[1] > top) {
                    return i;
                }
            }
            return -1;
        }

        public int getBottom(int bottom) {
            int num = this.mItemsHeight.size();
            if (num <= 0) {
                return -1;
            }
            int i = 0;
            while (true) {
                if (i >= num) {
                    break;
                } else if (this.mItemsHeight.get(i)[0] <= bottom) {
                    i++;
                } else {
                    i--;
                    break;
                }
            }
            if (i < 0) {
                i = 0;
            }
            if (i >= num) {
                int i2 = num - 1;
                return i2;
            }
            return i;
        }
    }
}
