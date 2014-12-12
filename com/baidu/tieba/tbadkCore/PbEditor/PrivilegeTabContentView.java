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
    private int XA;
    private IndicatorView XB;
    private final Point XC;
    private com.baidu.tbadk.editortool.w XD;
    private boolean Xt;
    private GridView Xz;
    private int bUM;
    private ViewPager mViewPager;

    public PrivilegeTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XA = -1;
        this.XC = new Point();
        this.XD = null;
        this.bUM = 0;
        init(context);
    }

    public PrivilegeTabContentView(Context context) {
        super(context);
        this.XA = -1;
        this.XC = new Point();
        this.XD = null;
        this.bUM = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.privilege_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.w.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.XB = (IndicatorView) findViewById(com.baidu.tieba.w.privilege_tab_indicator);
    }

    public void a(ao aoVar) {
        int i;
        int i2 = 0;
        if (aoVar != null) {
            int count = aoVar.getCount();
            if (this.mViewPager.getChildCount() <= 0 || this.bUM != count) {
                this.mViewPager.setAdapter(null);
                this.bUM = count;
                int afT = aoVar.afT();
                int row = aoVar.getRow();
                if (count != 0 && afT != 0 && row != 0) {
                    int i3 = count / (afT * row);
                    int i4 = count % (afT * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.XB.setVisibility(0);
                        this.XB.setCount(i4);
                        this.XB.setPosition(0.0f);
                    } else {
                        this.XB.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(afT);
                        gridView.setVerticalSpacing(aoVar.afU());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(aoVar.afV());
                        gridView.setSelector(com.baidu.tieba.t.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = afT * row;
                        } else {
                            i = count - ((afT * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new am(this, getContext(), i, i5 * afT * row, aoVar.afS()));
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

    private void uW() {
        if (this.Xt && this.Xz != null) {
            this.Xz.setSelection(-1);
            if (this.XA != -1) {
                ((LinearLayout) this.Xz.getChildAt(this.XA - this.Xz.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.XA = -1;
            this.Xz = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.XC.set(x, y);
                break;
            case 1:
            case 3:
                uW();
                break;
            case 2:
                this.XC.set(x, y);
                if (this.Xt && this.Xz != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.XB != null) {
            this.XB.setPosition(i + f);
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
        this.XD = wVar;
    }
}
