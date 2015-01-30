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
    private boolean XZ;
    private GridView Yf;
    private int Yg;
    private IndicatorView Yh;
    private final Point Yi;
    private com.baidu.tbadk.editortool.w Yj;
    private int bWF;
    private ViewPager mViewPager;

    public PrivilegeTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yg = -1;
        this.Yi = new Point();
        this.Yj = null;
        this.bWF = 0;
        init(context);
    }

    public PrivilegeTabContentView(Context context) {
        super(context);
        this.Yg = -1;
        this.Yi = new Point();
        this.Yj = null;
        this.bWF = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.privilege_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.w.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.Yh = (IndicatorView) findViewById(com.baidu.tieba.w.privilege_tab_indicator);
    }

    public void a(ao aoVar) {
        int i;
        int i2 = 0;
        if (aoVar != null) {
            int count = aoVar.getCount();
            if (this.mViewPager.getChildCount() <= 0 || this.bWF != count) {
                this.mViewPager.setAdapter(null);
                this.bWF = count;
                int agx = aoVar.agx();
                int row = aoVar.getRow();
                if (count != 0 && agx != 0 && row != 0) {
                    int i3 = count / (agx * row);
                    int i4 = count % (agx * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.Yh.setVisibility(0);
                        this.Yh.setCount(i4);
                        this.Yh.setPosition(0.0f);
                    } else {
                        this.Yh.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(agx);
                        gridView.setVerticalSpacing(aoVar.agy());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(aoVar.agz());
                        gridView.setSelector(com.baidu.tieba.t.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = agx * row;
                        } else {
                            i = count - ((agx * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new am(this, getContext(), i, i5 * agx * row, aoVar.agw()));
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

    private void vn() {
        if (this.XZ && this.Yf != null) {
            this.Yf.setSelection(-1);
            if (this.Yg != -1) {
                ((LinearLayout) this.Yf.getChildAt(this.Yg - this.Yf.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.Yg = -1;
            this.Yf = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.Yi.set(x, y);
                break;
            case 1:
            case 3:
                vn();
                break;
            case 2:
                this.Yi.set(x, y);
                if (this.XZ && this.Yf != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.Yh != null) {
            this.Yh.setPosition(i + f);
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
        this.Yj = wVar;
    }
}
