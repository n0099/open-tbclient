package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.indicator.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager bHL;
    private BdUniqueId cnX;
    private NoNetworkView dok;
    private FrameLayout fXh;
    private a gLc;
    private ScrollFragmentAdapter gLd;
    private c gLe;
    private View.OnClickListener gLf;
    private c.a gLg;
    private Context mContext;
    private List<e> tagList;

    public boolean boI() {
        return this.gLe != null && this.gLe.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gLf = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.boI()) {
                    ScrollFragmentTabHost.this.auV();
                } else {
                    ScrollFragmentTabHost.this.boK();
                }
            }
        };
        this.gLg = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void boO() {
                if (ScrollFragmentTabHost.this.gLc != null) {
                    ScrollFragmentTabHost.this.gLc.bpg();
                }
                if (ScrollFragmentTabHost.this.gLe != null) {
                    ScrollFragmentTabHost.this.gLe.a((c.a) null);
                    ScrollFragmentTabHost.this.gLe = null;
                }
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLf = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.boI()) {
                    ScrollFragmentTabHost.this.auV();
                } else {
                    ScrollFragmentTabHost.this.boK();
                }
            }
        };
        this.gLg = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void boO() {
                if (ScrollFragmentTabHost.this.gLc != null) {
                    ScrollFragmentTabHost.this.gLc.bpg();
                }
                if (ScrollFragmentTabHost.this.gLe != null) {
                    ScrollFragmentTabHost.this.gLe.a((c.a) null);
                    ScrollFragmentTabHost.this.gLe = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dok = (NoNetworkView) findViewById(d.g.view_no_network);
        this.gLc = new a(context, findViewById(d.g.tab_container));
        this.gLc.v(this.gLf);
        this.fXh = (FrameLayout) findViewById(d.g.tab_widget_content_container);
    }

    public void boK() {
        if (this.gLe == null) {
            this.gLe = new c(this.fXh);
            this.gLe.a(this.gLg);
        }
        if (!this.gLe.isShowing()) {
            this.gLe.a(this.mContext, this.tagList, this.bHL.getCurrentItem());
            if (this.gLc != null) {
                this.gLc.VU();
            }
        }
    }

    public void auV() {
        if (this.gLe != null) {
            this.gLe.dQ(this.mContext);
        }
    }

    public boolean bBl() {
        return v.S(this.tagList) <= 0;
    }

    public void m(List<e> list, int i) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (e eVar : list) {
                if (eVar != null) {
                    arrayList.add(new com.baidu.tieba.lego.c.c(eVar));
                }
            }
            this.tagList = list;
            if (this.gLd != null) {
                this.gLd.ax(arrayList);
                if (this.gLc != null) {
                    this.gLc.setViewPager(this.bHL, i);
                }
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (this.gLd != null) {
            this.gLd.a(j, str, dataRes, z);
        }
    }

    public void j(long j, String str) {
        if (this.gLd != null) {
            this.gLd.j(j, str);
        }
    }

    public void setFirstPosition(int i) {
        this.gLd.setFirstPosition(i);
    }

    public void b(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        if (this.gLd != null) {
            this.gLd.a(z, j, str, dataRes, z2, i);
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (this.bHL != null) {
            this.gLd.c(j, str, str2, i);
        }
    }

    public void a(com.baidu.tieba.lego.d dVar, com.baidu.tieba.lego.c cVar) {
        this.bHL = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.gLd = new ScrollFragmentAdapter(this.mContext, dVar, cVar, this.cnX);
        this.bHL.setAdapter(this.gLd);
    }

    public boolean bmg() {
        return this.gLd != null && this.gLd.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.gLd.getCount()) {
            this.bHL.setCurrentItem(i, false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gLc != null) {
            this.gLc.onChangeSkinType(i);
        }
        al.f(this, d.C0236d.cp_bg_line_d, i);
        if (this.gLd != null) {
            this.gLd.ij(i);
        }
        if (this.dok != null) {
            this.dok.onChangeSkinType(i.aK(getContext()), i);
        }
        if (this.gLe != null) {
            this.gLe.ij(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cnX = bdUniqueId;
    }
}
