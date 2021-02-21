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
/* loaded from: classes9.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager eZd;
    private BdUniqueId fGZ;
    private NoNetworkView gVO;
    private FrameLayout kwH;
    private a lfX;
    private ScrollFragmentAdapter lfY;
    private c lfZ;
    private View.OnClickListener lga;
    private c.a lgb;
    private Context mContext;
    private List<e> tagList;

    public boolean cTB() {
        return this.lfZ != null && this.lfZ.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.lga = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cTB()) {
                    ScrollFragmentTabHost.this.bKq();
                } else {
                    ScrollFragmentTabHost.this.ctO();
                }
            }
        };
        this.lgb = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cTG() {
                if (ScrollFragmentTabHost.this.lfX != null) {
                    ScrollFragmentTabHost.this.lfX.cTY();
                }
                if (ScrollFragmentTabHost.this.lfZ != null) {
                    ScrollFragmentTabHost.this.lfZ.a((c.a) null);
                    ScrollFragmentTabHost.this.lfZ = null;
                }
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lga = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cTB()) {
                    ScrollFragmentTabHost.this.bKq();
                } else {
                    ScrollFragmentTabHost.this.ctO();
                }
            }
        };
        this.lgb = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cTG() {
                if (ScrollFragmentTabHost.this.lfX != null) {
                    ScrollFragmentTabHost.this.lfX.cTY();
                }
                if (ScrollFragmentTabHost.this.lfZ != null) {
                    ScrollFragmentTabHost.this.lfZ.a((c.a) null);
                    ScrollFragmentTabHost.this.lfZ = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gVO = (NoNetworkView) findViewById(R.id.view_no_network);
        this.lfX = new a(context, findViewById(R.id.tab_container));
        this.lfX.G(this.lga);
        this.kwH = (FrameLayout) findViewById(R.id.tab_widget_content_container);
    }

    public void ctO() {
        if (this.lfZ == null) {
            this.lfZ = new c(this.kwH);
            this.lfZ.a(this.lgb);
        }
        if (!this.lfZ.isShowing()) {
            this.lfZ.a(this.mContext, this.tagList, this.eZd.getCurrentItem());
            if (this.lfX != null) {
                this.lfX.bkE();
            }
        }
    }

    public void bKq() {
        if (this.lfZ != null) {
            this.lfZ.gn(this.mContext);
        }
    }

    public boolean dcZ() {
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
            if (this.lfY != null) {
                this.lfY.ei(arrayList);
                if (this.lfX != null) {
                    this.lfX.setViewPager(this.eZd, i);
                }
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (this.lfY != null) {
            this.lfY.a(j, str, dataRes, z);
        }
    }

    public void q(long j, String str) {
        if (this.lfY != null) {
            this.lfY.q(j, str);
        }
    }

    public void setFirstPosition(int i) {
        this.lfY.setFirstPosition(i);
    }

    public void b(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        if (this.lfY != null) {
            this.lfY.a(z, j, str, dataRes, z2, i);
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (this.eZd != null) {
            this.lfY.c(j, str, str2, i);
        }
    }

    public void a(d dVar, com.baidu.tieba.lego.c cVar) {
        this.eZd = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.lfY = new ScrollFragmentAdapter(this.mContext, dVar, cVar, this.fGZ);
        this.eZd.setAdapter(this.lfY);
    }

    public boolean cPT() {
        return this.lfY != null && this.lfY.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.lfY.getCount()) {
            this.eZd.setCurrentItem(i, false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lfX != null) {
            this.lfX.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201, i);
        if (this.lfY != null) {
            this.lfY.onChangeSkin(i);
        }
        if (this.gVO != null) {
            this.gVO.onChangeSkinType(j.K(getContext()), i);
        }
        if (this.lfZ != null) {
            this.lfZ.onChangeSkin(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fGZ = bdUniqueId;
    }
}
