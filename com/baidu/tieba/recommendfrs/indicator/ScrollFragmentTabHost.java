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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.indicator.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager Yu;
    private NoNetworkView aKB;
    private List<String> csE;
    private e ctl;
    private a ctm;
    private FrameLayout ctn;
    private h cto;
    private View.OnClickListener ctp;
    private h.a ctq;
    private Context mContext;

    public boolean ajS() {
        return this.cto != null && this.cto.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.ctp = new c(this);
        this.ctq = new d(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctp = new c(this);
        this.ctq = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aKB = (NoNetworkView) findViewById(i.f.view_no_network);
        this.ctl = new e(context, findViewById(i.f.tab_container));
        this.ctl.F(this.ctp);
        this.ctn = (FrameLayout) findViewById(i.f.tab_widget_content_container);
    }

    public void ajT() {
        if (this.cto == null) {
            this.cto = new h(this.ctn);
            this.cto.a(this.ctq);
        }
        if (!this.cto.isShowing()) {
            this.cto.a(this.mContext, this.csE, this.Yu.getCurrentItem());
            if (this.ctl != null) {
                this.ctl.ajX();
            }
        }
    }

    public void ajU() {
        if (this.cto != null) {
            this.cto.aI(this.mContext);
        }
    }

    public void be(List<String> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.e(str));
                }
            }
            this.csE = list;
            if (this.ctm != null) {
                this.ctm.p(arrayList);
                if (this.ctl != null) {
                    this.ctl.setViewPager(this.Yu);
                }
            }
        }
    }

    public void b(boolean z, String str, com.baidu.tieba.recommendfrs.data.g gVar, boolean z2) {
        if (!StringUtils.isNull(str) && this.ctm != null) {
            this.ctm.a(z, str, gVar, z2);
        }
    }

    public void i(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && this.Yu != null) {
            this.ctm.i(str, str2, i);
        }
    }

    public void b(com.baidu.tieba.recommendfrs.a aVar) {
        this.Yu = (CustomViewPager) findViewById(i.f.tab_widget_view_pager);
        this.ctm = new a(this.mContext, aVar);
        this.Yu.setAdapter(this.ctm);
    }

    public boolean ajV() {
        return this.ctm != null && this.ctm.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.ctm.getCount()) {
            this.Yu.setCurrentItem(i, false);
        }
    }

    public int jY(String str) {
        if (StringUtils.isNull(str) || this.ctm == null) {
            return -1;
        }
        return this.ctm.jX(UtilHelper.getFixedText(str, 4));
    }

    public void reset() {
        if (this.ctm != null) {
            this.ctm.clear();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ctl != null) {
            this.ctl.onChangeSkinType(i);
        }
        al.d(this, i.c.cp_bg_line_d, i);
        if (this.ctm != null) {
            this.ctm.cI(i);
        }
        if (this.aKB != null) {
            this.aKB.onChangeSkinType(l.C(getContext()), i);
        }
        if (this.cto != null) {
            this.cto.cI(i);
        }
    }
}
