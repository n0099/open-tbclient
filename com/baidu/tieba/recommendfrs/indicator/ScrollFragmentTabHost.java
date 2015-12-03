package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.base.l;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.indicator.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager Zm;
    private NoNetworkView aNn;
    private e diU;
    private a diV;
    private FrameLayout diW;
    private h diX;
    public boolean diY;
    private View.OnClickListener diZ;
    private List<ExcellentTagInfo> dix;
    private h.a dja;
    private Context mContext;

    public boolean aww() {
        return this.diX != null && this.diX.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.diY = true;
        this.diZ = new c(this);
        this.dja = new d(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diY = true;
        this.diZ = new c(this);
        this.dja = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.g.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aNn = (NoNetworkView) findViewById(n.f.view_no_network);
        this.diU = new e(context, findViewById(n.f.tab_container));
        this.diU.L(this.diZ);
        this.diW = (FrameLayout) findViewById(n.f.tab_widget_content_container);
    }

    public void awx() {
        if (this.diX == null) {
            this.diX = new h(this.diW);
            this.diX.a(this.dja);
        }
        if (!this.diX.isShowing()) {
            this.diX.a(this.mContext, this.dix, this.Zm.getCurrentItem());
            if (this.diU != null) {
                this.diU.awB();
            }
        }
    }

    public void awy() {
        if (this.diX != null) {
            this.diX.aJ(this.mContext);
        }
    }

    public void bF(List<ExcellentTagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (ExcellentTagInfo excellentTagInfo : list) {
                if (excellentTagInfo != null) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.a(excellentTagInfo));
                }
            }
            this.dix = list;
            if (this.diV != null) {
                this.diV.an(arrayList);
                if (this.diU != null) {
                    this.diU.setViewPager(this.Zm);
                }
            }
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.recommendfrs.data.c cVar, boolean z2) {
        if (this.diV != null) {
            this.diV.a(z, j, cVar, z2);
        }
    }

    public void b(long j, String str, int i) {
        if (this.Zm != null) {
            this.diV.b(j, str, i);
        }
    }

    public void b(com.baidu.tieba.recommendfrs.a aVar) {
        this.Zm = (CustomViewPager) findViewById(n.f.tab_widget_view_pager);
        this.diV = new a(this.mContext, aVar);
        this.Zm.setAdapter(this.diV);
    }

    public boolean awz() {
        return this.diV != null && this.diV.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.diV.getCount()) {
            this.Zm.setCurrentItem(i, false);
        }
    }

    public int bA(long j) {
        if (this.diV == null) {
            return -1;
        }
        return this.diV.bz(j);
    }

    public void reset() {
        if (this.diV != null) {
            this.diV.clear();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.diU != null) {
            this.diU.onChangeSkinType(i);
        }
        as.d(this, n.c.cp_bg_line_d, i);
        if (this.diV != null) {
            this.diV.cX(i);
        }
        if (this.aNn != null) {
            this.aNn.onChangeSkinType(l.C(getContext()), i);
        }
        if (this.diX != null) {
            this.diX.cX(i);
        }
    }
}
