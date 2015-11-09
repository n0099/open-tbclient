package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.indicator.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager YA;
    private NoNetworkView aIM;
    private List<String> cJT;
    private a cKA;
    private FrameLayout cKB;
    private h cKC;
    private View.OnClickListener cKD;
    private h.a cKE;
    private e cKz;
    private Context mContext;

    public boolean aqY() {
        return this.cKC != null && this.cKC.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cKD = new c(this);
        this.cKE = new d(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKD = new c(this);
        this.cKE = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aIM = (NoNetworkView) findViewById(i.f.view_no_network);
        this.cKz = new e(context, findViewById(i.f.tab_container));
        this.cKz.H(this.cKD);
        this.cKB = (FrameLayout) findViewById(i.f.tab_widget_content_container);
    }

    public void aqZ() {
        if (this.cKC == null) {
            this.cKC = new h(this.cKB);
            this.cKC.a(this.cKE);
        }
        if (!this.cKC.isShowing()) {
            this.cKC.a(this.mContext, this.cJT, this.YA.getCurrentItem());
            if (this.cKz != null) {
                this.cKz.ard();
            }
        }
    }

    public void ara() {
        if (this.cKC != null) {
            this.cKC.aJ(this.mContext);
        }
    }

    public void bt(List<String> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.e(str));
                }
            }
            this.cJT = list;
            if (this.cKA != null) {
                this.cKA.ah(arrayList);
                if (this.cKz != null) {
                    this.cKz.setViewPager(this.YA);
                }
            }
        }
    }

    public void b(boolean z, String str, com.baidu.tieba.recommendfrs.data.g gVar, boolean z2) {
        if (!StringUtils.isNull(str) && this.cKA != null) {
            this.cKA.a(z, str, gVar, z2);
        }
    }

    public void j(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && this.YA != null) {
            this.cKA.j(str, str2, i);
        }
    }

    public void b(com.baidu.tieba.recommendfrs.a aVar) {
        this.YA = (CustomViewPager) findViewById(i.f.tab_widget_view_pager);
        this.cKA = new a(this.mContext, aVar);
        this.YA.setAdapter(this.cKA);
    }

    public boolean arb() {
        return this.cKA != null && this.cKA.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cKA.getCount()) {
            this.YA.setCurrentItem(i, false);
        }
    }

    public int li(String str) {
        if (StringUtils.isNull(str) || this.cKA == null) {
            return -1;
        }
        return this.cKA.lh(UtilHelper.getFixedText(str, 4));
    }

    public void reset() {
        if (this.cKA != null) {
            this.cKA.clear();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cKz != null) {
            this.cKz.onChangeSkinType(i);
        }
        an.d(this, i.c.cp_bg_line_d, i);
        if (this.cKA != null) {
            this.cKA.cP(i);
        }
        if (this.aIM != null) {
            this.aIM.onChangeSkinType(l.C(getContext()), i);
        }
        if (this.cKC != null) {
            this.cKC.cP(i);
        }
    }
}
