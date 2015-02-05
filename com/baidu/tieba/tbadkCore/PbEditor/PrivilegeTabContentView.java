package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PrivilegeTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private boolean XW;
    private GridView Yc;
    private int Yd;
    private IndicatorView Ye;
    private final Point Yf;
    private com.baidu.tbadk.editortool.w Yg;
    private int bWE;
    private ViewPager mViewPager;

    public PrivilegeTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yd = -1;
        this.Yf = new Point();
        this.Yg = null;
        this.bWE = 0;
        init(context);
    }

    public PrivilegeTabContentView(Context context) {
        super(context);
        this.Yd = -1;
        this.Yf = new Point();
        this.Yg = null;
        this.bWE = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.privilege_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.w.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.Ye = (IndicatorView) findViewById(com.baidu.tieba.w.privilege_tab_indicator);
    }

    public void a(ao aoVar) {
        int i;
        int i2 = 0;
        if (aoVar != null) {
            int count = aoVar.getCount();
            if (this.mViewPager.getChildCount() <= 0 || this.bWE != count) {
                this.mViewPager.setAdapter(null);
                this.bWE = count;
                int ags = aoVar.ags();
                int row = aoVar.getRow();
                if (count != 0 && ags != 0 && row != 0) {
                    int i3 = count / (ags * row);
                    int i4 = count % (ags * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.Ye.setVisibility(0);
                        this.Ye.setCount(i4);
                        this.Ye.setPosition(0.0f);
                    } else {
                        this.Ye.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(ags);
                        gridView.setVerticalSpacing(aoVar.agt());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(aoVar.agu());
                        gridView.setSelector(com.baidu.tieba.t.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = ags * row;
                        } else {
                            i = count - ((ags * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new am(this, getContext(), i, i5 * ags * row, aoVar.agr()));
                        arrayList.add(gridView);
                    }
                    this.mViewPager.setAdapter(new an(this, arrayList));
                    return;
                }
                return;
            }
            while (true) {
                int i6 = i2;
                if (i6 < this.mViewPager.getChildCount()) {
                    View childAt = this.mViewPager.getChildAt(i6);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                    i2 = i6 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void vh() {
        if (this.XW && this.Yc != null) {
            this.Yc.setSelection(-1);
            if (this.Yd != -1) {
                ((LinearLayout) this.Yc.getChildAt(this.Yd - this.Yc.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.Yd = -1;
            this.Yc = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.Yf.set(x, y);
                break;
            case 1:
            case 3:
                vh();
                break;
            case 2:
                this.Yf.set(x, y);
                if (this.XW && this.Yc != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.Ye != null) {
            this.Ye.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mViewPager.getChildCount()) {
                View childAt = this.mViewPager.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        this.Yg = wVar;
    }
}
