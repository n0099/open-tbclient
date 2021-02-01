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
    private NoNetworkView gVA;
    private FrameLayout kwt;
    private a lfJ;
    private ScrollFragmentAdapter lfK;
    private c lfL;
    private View.OnClickListener lfM;
    private c.a lfN;
    private Context mContext;
    private List<e> tagList;

    public boolean cTu() {
        return this.lfL != null && this.lfL.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.lfM = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cTu()) {
                    ScrollFragmentTabHost.this.bKl();
                } else {
                    ScrollFragmentTabHost.this.ctH();
                }
            }
        };
        this.lfN = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cTz() {
                if (ScrollFragmentTabHost.this.lfJ != null) {
                    ScrollFragmentTabHost.this.lfJ.cTR();
                }
                if (ScrollFragmentTabHost.this.lfL != null) {
                    ScrollFragmentTabHost.this.lfL.a((c.a) null);
                    ScrollFragmentTabHost.this.lfL = null;
                }
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lfM = new View.OnClickListener() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.cTu()) {
                    ScrollFragmentTabHost.this.bKl();
                } else {
                    ScrollFragmentTabHost.this.ctH();
                }
            }
        };
        this.lfN = new c.a() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.lego.indicator.c.a
            public void cTz() {
                if (ScrollFragmentTabHost.this.lfJ != null) {
                    ScrollFragmentTabHost.this.lfJ.cTR();
                }
                if (ScrollFragmentTabHost.this.lfL != null) {
                    ScrollFragmentTabHost.this.lfL.a((c.a) null);
                    ScrollFragmentTabHost.this.lfL = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gVA = (NoNetworkView) findViewById(R.id.view_no_network);
        this.lfJ = new a(context, findViewById(R.id.tab_container));
        this.lfJ.G(this.lfM);
        this.kwt = (FrameLayout) findViewById(R.id.tab_widget_content_container);
    }

    public void ctH() {
        if (this.lfL == null) {
            this.lfL = new c(this.kwt);
            this.lfL.a(this.lfN);
        }
        if (!this.lfL.isShowing()) {
            this.lfL.a(this.mContext, this.tagList, this.eZd.getCurrentItem());
            if (this.lfJ != null) {
                this.lfJ.bkE();
            }
        }
    }

    public void bKl() {
        if (this.lfL != null) {
            this.lfL.gn(this.mContext);
        }
    }

    public boolean dcS() {
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
            if (this.lfK != null) {
                this.lfK.ei(arrayList);
                if (this.lfJ != null) {
                    this.lfJ.setViewPager(this.eZd, i);
                }
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (this.lfK != null) {
            this.lfK.a(j, str, dataRes, z);
        }
    }

    public void q(long j, String str) {
        if (this.lfK != null) {
            this.lfK.q(j, str);
        }
    }

    public void setFirstPosition(int i) {
        this.lfK.setFirstPosition(i);
    }

    public void b(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        if (this.lfK != null) {
            this.lfK.a(z, j, str, dataRes, z2, i);
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (this.eZd != null) {
            this.lfK.c(j, str, str2, i);
        }
    }

    public void a(d dVar, com.baidu.tieba.lego.c cVar) {
        this.eZd = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.lfK = new ScrollFragmentAdapter(this.mContext, dVar, cVar, this.fGZ);
        this.eZd.setAdapter(this.lfK);
    }

    public boolean cPM() {
        return this.lfK != null && this.lfK.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.lfK.getCount()) {
            this.eZd.setCurrentItem(i, false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lfJ != null) {
            this.lfJ.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.CAM_X0201, i);
        if (this.lfK != null) {
            this.lfK.onChangeSkin(i);
        }
        if (this.gVA != null) {
            this.gVA.onChangeSkinType(j.K(getContext()), i);
        }
        if (this.lfL != null) {
            this.lfL.onChangeSkin(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fGZ = bdUniqueId;
    }
}
