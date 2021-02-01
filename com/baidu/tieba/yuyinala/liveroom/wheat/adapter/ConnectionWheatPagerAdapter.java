package com.baidu.tieba.yuyinala.liveroom.wheat.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class ConnectionWheatPagerAdapter extends PagerAdapter {
    private List<View> bas;

    public ConnectionWheatPagerAdapter(List<View> list) {
        this.bas = new ArrayList();
        this.bas = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.bas == null) {
            return 0;
        }
        return this.bas.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            View view = this.bas.get(i);
            P(view);
            viewGroup.removeView(view);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.bas.get(i);
        viewGroup.addView(view);
        return view;
    }

    private void P(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i);
                    for (int i2 = 0; i2 < gridView.getChildCount(); i2++) {
                        View childAt = gridView.getChildAt(i2);
                        if (childAt != null) {
                            childAt.getTag();
                        }
                    }
                    return;
                }
            }
        }
    }
}
