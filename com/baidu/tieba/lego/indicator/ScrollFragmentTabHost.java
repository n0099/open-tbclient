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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.d;
import com.baidu.tieba.lego.indicator.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private BdUniqueId fIy;
    private CustomViewPager faC;
    private NoNetworkView gXx;
    private FrameLayout kyJ;
    private a lhZ;
    private ScrollFragmentAdapter lia;
    private c lib;
    private View.OnClickListener lic;
    private c.a lid;
    private Context mContext;
    private List<e> tagList;

    public boolean cTI() {
        return this.lib != null && this.lib.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.lic = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cTI()) {
                    ScrollFragmentTabHost.this.bKu();
                } else {
                    ScrollFragmentTabHost.this.ctU();
                }
            }
        };
        this.lid = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cTN() {
                if (ScrollFragmentTabHost.this.lhZ != null) {
                    ScrollFragmentTabHost.this.lhZ.cUf();
                }
                if (ScrollFragmentTabHost.this.lib != null) {
                    ScrollFragmentTabHost.this.lib.a((c.a) null);
                    ScrollFragmentTabHost.this.lib = null;
                }
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lic = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cTI()) {
                    ScrollFragmentTabHost.this.bKu();
                } else {
                    ScrollFragmentTabHost.this.ctU();
                }
            }
        };
        this.lid = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cTN() {
                if (ScrollFragmentTabHost.this.lhZ != null) {
                    ScrollFragmentTabHost.this.lhZ.cUf();
                }
                if (ScrollFragmentTabHost.this.lib != null) {
                    ScrollFragmentTabHost.this.lib.a((c.a) null);
                    ScrollFragmentTabHost.this.lib = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gXx = (NoNetworkView) findViewById(R.id.view_no_network);
        this.lhZ = new a(context, findViewById(R.id.tab_container));
        this.lhZ.H(this.lic);
        this.kyJ = (FrameLayout) findViewById(R.id.tab_widget_content_container);
    }

    public void ctU() {
        if (this.lib == null) {
            this.lib = new c(this.kyJ);
            this.lib.a(this.lid);
        }
        if (!this.lib.isShowing()) {
            this.lib.a(this.mContext, this.tagList, this.faC.getCurrentItem());
            if (this.lhZ != null) {
                this.lhZ.bkG();
            }
        }
    }

    public void bKu() {
        if (this.lib != null) {
            this.lib.gm(this.mContext);
        }
    }

    public boolean ddi() {
        return y.getCount(this.tagList) <= 0;
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
            if (this.lia != null) {
                this.lia.ei(arrayList);
                if (this.lhZ != null) {
                    this.lhZ.setViewPager(this.faC, i);
                }
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (this.lia != null) {
            this.lia.a(j, str, dataRes, z);
        }
    }

    public void q(long j, String str) {
        if (this.lia != null) {
            this.lia.q(j, str);
        }
    }

    public void setFirstPosition(int i) {
        this.lia.setFirstPosition(i);
    }

    public void b(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        if (this.lia != null) {
            this.lia.a(z, j, str, dataRes, z2, i);
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (this.faC != null) {
            this.lia.c(j, str, str2, i);
        }
    }

    public void a(d dVar, com.baidu.tieba.lego.c cVar) {
        this.faC = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.lia = new ScrollFragmentAdapter(this.mContext, dVar, cVar, this.fIy);
        this.faC.setAdapter(this.lia);
    }

    public boolean cQa() {
        return this.lia != null && this.lia.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.lia.getCount()) {
            this.faC.setCurrentItem(i, false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lhZ != null) {
            this.lhZ.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201, i);
        if (this.lia != null) {
            this.lia.onChangeSkin(i);
        }
        if (this.gXx != null) {
            this.gXx.onChangeSkinType(j.J(getContext()), i);
        }
        if (this.lib != null) {
            this.lib.onChangeSkin(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fIy = bdUniqueId;
    }
}
