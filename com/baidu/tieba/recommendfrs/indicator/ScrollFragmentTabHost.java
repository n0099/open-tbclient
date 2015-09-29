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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.indicator.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager Yu;
    private NoNetworkView aJH;
    private List<String> cHY;
    private e cIE;
    private a cIF;
    private FrameLayout cIG;
    private h cIH;
    private View.OnClickListener cII;
    private h.a cIJ;
    private Context mContext;

    public boolean aqq() {
        return this.cIH != null && this.cIH.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cII = new c(this);
        this.cIJ = new d(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cII = new c(this);
        this.cIJ = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aJH = (NoNetworkView) findViewById(i.f.view_no_network);
        this.cIE = new e(context, findViewById(i.f.tab_container));
        this.cIE.H(this.cII);
        this.cIG = (FrameLayout) findViewById(i.f.tab_widget_content_container);
    }

    public void aqr() {
        if (this.cIH == null) {
            this.cIH = new h(this.cIG);
            this.cIH.a(this.cIJ);
        }
        if (!this.cIH.isShowing()) {
            this.cIH.a(this.mContext, this.cHY, this.Yu.getCurrentItem());
            if (this.cIE != null) {
                this.cIE.aqv();
            }
        }
    }

    public void aqs() {
        if (this.cIH != null) {
            this.cIH.aK(this.mContext);
        }
    }

    public void bo(List<String> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.e(str));
                }
            }
            this.cHY = list;
            if (this.cIF != null) {
                this.cIF.ad(arrayList);
                if (this.cIE != null) {
                    this.cIE.setViewPager(this.Yu);
                }
            }
        }
    }

    public void b(boolean z, String str, com.baidu.tieba.recommendfrs.data.g gVar, boolean z2) {
        if (!StringUtils.isNull(str) && this.cIF != null) {
            this.cIF.a(z, str, gVar, z2);
        }
    }

    public void j(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && this.Yu != null) {
            this.cIF.j(str, str2, i);
        }
    }

    public void b(com.baidu.tieba.recommendfrs.a aVar) {
        this.Yu = (CustomViewPager) findViewById(i.f.tab_widget_view_pager);
        this.cIF = new a(this.mContext, aVar);
        this.Yu.setAdapter(this.cIF);
    }

    public boolean aqt() {
        return this.cIF != null && this.cIF.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cIF.getCount()) {
            this.Yu.setCurrentItem(i, false);
        }
    }

    public int lb(String str) {
        if (StringUtils.isNull(str) || this.cIF == null) {
            return -1;
        }
        return this.cIF.la(UtilHelper.getFixedText(str, 4));
    }

    public void reset() {
        if (this.cIF != null) {
            this.cIF.clear();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cIE != null) {
            this.cIE.onChangeSkinType(i);
        }
        am.d(this, i.c.cp_bg_line_d, i);
        if (this.cIF != null) {
            this.cIF.cP(i);
        }
        if (this.aJH != null) {
            this.aJH.onChangeSkinType(l.C(getContext()), i);
        }
        if (this.cIH != null) {
            this.cIH.cP(i);
        }
    }
}
