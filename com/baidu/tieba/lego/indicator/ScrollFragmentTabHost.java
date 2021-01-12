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
/* loaded from: classes8.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager eWN;
    private BdUniqueId fEN;
    private NoNetworkView gSQ;
    private a kXF;
    private ScrollFragmentAdapter kXG;
    private c kXH;
    private View.OnClickListener kXI;
    private c.a kXJ;
    private FrameLayout kom;
    private Context mContext;
    private List<e> tagList;

    public boolean cRv() {
        return this.kXH != null && this.kXH.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.kXI = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cRv()) {
                    ScrollFragmentTabHost.this.bJR();
                } else {
                    ScrollFragmentTabHost.this.csv();
                }
            }
        };
        this.kXJ = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cRA() {
                if (ScrollFragmentTabHost.this.kXF != null) {
                    ScrollFragmentTabHost.this.kXF.cRS();
                }
                if (ScrollFragmentTabHost.this.kXH != null) {
                    ScrollFragmentTabHost.this.kXH.a((c.a) null);
                    ScrollFragmentTabHost.this.kXH = null;
                }
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kXI = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cRv()) {
                    ScrollFragmentTabHost.this.bJR();
                } else {
                    ScrollFragmentTabHost.this.csv();
                }
            }
        };
        this.kXJ = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cRA() {
                if (ScrollFragmentTabHost.this.kXF != null) {
                    ScrollFragmentTabHost.this.kXF.cRS();
                }
                if (ScrollFragmentTabHost.this.kXH != null) {
                    ScrollFragmentTabHost.this.kXH.a((c.a) null);
                    ScrollFragmentTabHost.this.kXH = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gSQ = (NoNetworkView) findViewById(R.id.view_no_network);
        this.kXF = new a(context, findViewById(R.id.tab_container));
        this.kXF.G(this.kXI);
        this.kom = (FrameLayout) findViewById(R.id.tab_widget_content_container);
    }

    public void csv() {
        if (this.kXH == null) {
            this.kXH = new c(this.kom);
            this.kXH.a(this.kXJ);
        }
        if (!this.kXH.isShowing()) {
            this.kXH.a(this.mContext, this.tagList, this.eWN.getCurrentItem());
            if (this.kXF != null) {
                this.kXF.bkm();
            }
        }
    }

    public void bJR() {
        if (this.kXH != null) {
            this.kXH.gm(this.mContext);
        }
    }

    public boolean daU() {
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
            if (this.kXG != null) {
                this.kXG.ek(arrayList);
                if (this.kXF != null) {
                    this.kXF.setViewPager(this.eWN, i);
                }
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (this.kXG != null) {
            this.kXG.a(j, str, dataRes, z);
        }
    }

    public void p(long j, String str) {
        if (this.kXG != null) {
            this.kXG.p(j, str);
        }
    }

    public void setFirstPosition(int i) {
        this.kXG.setFirstPosition(i);
    }

    public void b(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        if (this.kXG != null) {
            this.kXG.a(z, j, str, dataRes, z2, i);
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (this.eWN != null) {
            this.kXG.c(j, str, str2, i);
        }
    }

    public void a(d dVar, com.baidu.tieba.lego.c cVar) {
        this.eWN = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.kXG = new ScrollFragmentAdapter(this.mContext, dVar, cVar, this.fEN);
        this.eWN.setAdapter(this.kXG);
    }

    public boolean cNP() {
        return this.kXG != null && this.kXG.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.kXG.getCount()) {
            this.eWN.setCurrentItem(i, false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kXF != null) {
            this.kXF.onChangeSkinType(i);
        }
        ao.setBackgroundColor(this, R.color.CAM_X0201, i);
        if (this.kXG != null) {
            this.kXG.onChangeSkin(i);
        }
        if (this.gSQ != null) {
            this.gSQ.onChangeSkinType(j.K(getContext()), i);
        }
        if (this.kXH != null) {
            this.kXH.onChangeSkin(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fEN = bdUniqueId;
    }
}
