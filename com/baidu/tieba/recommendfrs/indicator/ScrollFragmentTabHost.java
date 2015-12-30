package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.l;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.indicator.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager ZP;
    private NoNetworkView aRg;
    private FrameLayout dpA;
    private h dpB;
    public boolean dpC;
    private View.OnClickListener dpD;
    private h.a dpE;
    private List<TagInfo> dpo;
    private BdUniqueId dpv;
    private e dpy;
    private a dpz;
    private Context mContext;

    public boolean ayB() {
        return this.dpB != null && this.dpB.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.dpC = true;
        this.dpD = new c(this);
        this.dpE = new d(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpC = true;
        this.dpD = new c(this);
        this.dpE = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aRg = (NoNetworkView) findViewById(n.g.view_no_network);
        this.dpy = new e(context, findViewById(n.g.tab_container));
        this.dpy.L(this.dpD);
        this.dpA = (FrameLayout) findViewById(n.g.tab_widget_content_container);
    }

    public void ayC() {
        if (this.dpB == null) {
            this.dpB = new h(this.dpA);
            this.dpB.a(this.dpE);
        }
        if (!this.dpB.isShowing()) {
            this.dpB.a(this.mContext, this.dpo, this.ZP.getCurrentItem());
            if (this.dpy != null) {
                this.dpy.ayH();
            }
        }
    }

    public void ayD() {
        if (this.dpB != null) {
            this.dpB.aJ(this.mContext);
        }
    }

    public boolean ayE() {
        return y.l(this.dpo) <= 0;
    }

    public void bH(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.f(tagInfo));
                }
            }
            this.dpo = list;
            if (this.dpz != null) {
                this.dpz.an(arrayList);
                if (this.dpy != null) {
                    this.dpy.setViewPager(this.ZP);
                }
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.dpz != null) {
            this.dpz.c(j, dataRes, z);
        }
    }

    public void axX() {
        if (this.dpz != null) {
            this.dpz.axX();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.recommendfrs.data.h hVar, boolean z2) {
        if (this.dpz != null) {
            this.dpz.a(z, j, hVar, z2);
        }
    }

    public void b(long j, String str, int i) {
        if (this.ZP != null) {
            this.dpz.b(j, str, i);
        }
    }

    public void a(com.baidu.tieba.recommendfrs.a aVar, com.baidu.tieba.recommendfrs.b bVar) {
        this.ZP = (CustomViewPager) findViewById(n.g.tab_widget_view_pager);
        this.dpz = new a(this.mContext, aVar, bVar, this.dpv);
        this.ZP.setAdapter(this.dpz);
    }

    public boolean ayF() {
        return this.dpz != null && this.dpz.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.dpz.getCount()) {
            this.ZP.setCurrentItem(i, false);
        }
    }

    public int bJ(long j) {
        if (this.dpz == null) {
            return -1;
        }
        return this.dpz.bI(j);
    }

    public int getCurrentItem() {
        return this.ZP.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.dpy != null) {
            this.dpy.onChangeSkinType(i);
        }
        as.d(this, n.d.cp_bg_line_d, i);
        if (this.dpz != null) {
            this.dpz.cR(i);
        }
        if (this.aRg != null) {
            this.aRg.onChangeSkinType(l.C(getContext()), i);
        }
        if (this.dpB != null) {
            this.dpB.cR(i);
        }
    }

    public void setItemForeGround(int i) {
        this.dpz.setItemForeGround(i);
    }

    public void onDestroy() {
        this.dpz.onDestroy();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dpv = bdUniqueId;
    }

    public void ayA() {
        if (this.dpz != null) {
            this.dpz.ayA();
        }
    }
}
