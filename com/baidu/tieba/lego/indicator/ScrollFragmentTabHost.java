package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.d;
import com.baidu.tieba.lego.indicator.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private BdUniqueId fJu;
    private CustomViewPager fbv;
    private NoNetworkView gXw;
    private FrameLayout ksR;
    private a lcl;
    private ScrollFragmentAdapter lcm;
    private c lcn;
    private View.OnClickListener lco;
    private c.a lcp;
    private Context mContext;
    private List<e> tagList;

    public boolean cVn() {
        return this.lcn != null && this.lcn.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.lco = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cVn()) {
                    ScrollFragmentTabHost.this.bNJ();
                } else {
                    ScrollFragmentTabHost.this.cwn();
                }
            }
        };
        this.lcp = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cVs() {
                if (ScrollFragmentTabHost.this.lcl != null) {
                    ScrollFragmentTabHost.this.lcl.cVK();
                }
                if (ScrollFragmentTabHost.this.lcn != null) {
                    ScrollFragmentTabHost.this.lcn.a((c.a) null);
                    ScrollFragmentTabHost.this.lcn = null;
                }
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lco = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cVn()) {
                    ScrollFragmentTabHost.this.bNJ();
                } else {
                    ScrollFragmentTabHost.this.cwn();
                }
            }
        };
        this.lcp = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cVs() {
                if (ScrollFragmentTabHost.this.lcl != null) {
                    ScrollFragmentTabHost.this.lcl.cVK();
                }
                if (ScrollFragmentTabHost.this.lcn != null) {
                    ScrollFragmentTabHost.this.lcn.a((c.a) null);
                    ScrollFragmentTabHost.this.lcn = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gXw = (NoNetworkView) findViewById(R.id.view_no_network);
        this.lcl = new a(context, findViewById(R.id.tab_container));
        this.lcl.G(this.lco);
        this.ksR = (FrameLayout) findViewById(R.id.tab_widget_content_container);
    }

    public void cwn() {
        if (this.lcn == null) {
            this.lcn = new c(this.ksR);
            this.lcn.a(this.lcp);
        }
        if (!this.lcn.isShowing()) {
            this.lcn.a(this.mContext, this.tagList, this.fbv.getCurrentItem());
            if (this.lcl != null) {
                this.lcl.bog();
            }
        }
    }

    public void bNJ() {
        if (this.lcn != null) {
            this.lcn.go(this.mContext);
        }
    }

    public boolean deM() {
        return x.getCount(this.tagList) <= 0;
    }

    public void o(List<e> list, int i) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (e eVar : list) {
                if (eVar != null) {
                    arrayList.add(new com.baidu.tieba.lego.c.c(eVar));
                }
            }
            this.tagList = list;
            if (this.lcm != null) {
                this.lcm.ek(arrayList);
                if (this.lcl != null) {
                    this.lcl.setViewPager(this.fbv, i);
                }
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (this.lcm != null) {
            this.lcm.a(j, str, dataRes, z);
        }
    }

    public void p(long j, String str) {
        if (this.lcm != null) {
            this.lcm.p(j, str);
        }
    }

    public void setFirstPosition(int i) {
        this.lcm.setFirstPosition(i);
    }

    public void b(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        if (this.lcm != null) {
            this.lcm.a(z, j, str, dataRes, z2, i);
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (this.fbv != null) {
            this.lcm.c(j, str, str2, i);
        }
    }

    public void a(d dVar, com.baidu.tieba.lego.c cVar) {
        this.fbv = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.lcm = new ScrollFragmentAdapter(this.mContext, dVar, cVar, this.fJu);
        this.fbv.setAdapter(this.lcm);
    }

    public boolean cRH() {
        return this.lcm != null && this.lcm.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.lcm.getCount()) {
            this.fbv.setCurrentItem(i, false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lcl != null) {
            this.lcl.onChangeSkinType(i);
        }
        ao.setBackgroundColor(this, R.color.CAM_X0201, i);
        if (this.lcm != null) {
            this.lcm.onChangeSkin(i);
        }
        if (this.gXw != null) {
            this.gXw.onChangeSkinType(j.K(getContext()), i);
        }
        if (this.lcn != null) {
            this.lcn.onChangeSkin(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fJu = bdUniqueId;
    }
}
