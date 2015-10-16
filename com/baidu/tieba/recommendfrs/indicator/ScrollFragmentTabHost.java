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
    private CustomViewPager Yw;
    private NoNetworkView aJS;
    private List<String> cIx;
    private e cJd;
    private a cJe;
    private FrameLayout cJf;
    private h cJg;
    private View.OnClickListener cJh;
    private h.a cJi;
    private Context mContext;

    public boolean aqw() {
        return this.cJg != null && this.cJg.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cJh = new c(this);
        this.cJi = new d(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJh = new c(this);
        this.cJi = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aJS = (NoNetworkView) findViewById(i.f.view_no_network);
        this.cJd = new e(context, findViewById(i.f.tab_container));
        this.cJd.H(this.cJh);
        this.cJf = (FrameLayout) findViewById(i.f.tab_widget_content_container);
    }

    public void aqx() {
        if (this.cJg == null) {
            this.cJg = new h(this.cJf);
            this.cJg.a(this.cJi);
        }
        if (!this.cJg.isShowing()) {
            this.cJg.a(this.mContext, this.cIx, this.Yw.getCurrentItem());
            if (this.cJd != null) {
                this.cJd.aqB();
            }
        }
    }

    public void aqy() {
        if (this.cJg != null) {
            this.cJg.aK(this.mContext);
        }
    }

    public void bp(List<String> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.e(str));
                }
            }
            this.cIx = list;
            if (this.cJe != null) {
                this.cJe.ad(arrayList);
                if (this.cJd != null) {
                    this.cJd.setViewPager(this.Yw);
                }
            }
        }
    }

    public void b(boolean z, String str, com.baidu.tieba.recommendfrs.data.g gVar, boolean z2) {
        if (!StringUtils.isNull(str) && this.cJe != null) {
            this.cJe.a(z, str, gVar, z2);
        }
    }

    public void j(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && this.Yw != null) {
            this.cJe.j(str, str2, i);
        }
    }

    public void b(com.baidu.tieba.recommendfrs.a aVar) {
        this.Yw = (CustomViewPager) findViewById(i.f.tab_widget_view_pager);
        this.cJe = new a(this.mContext, aVar);
        this.Yw.setAdapter(this.cJe);
    }

    public boolean aqz() {
        return this.cJe != null && this.cJe.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cJe.getCount()) {
            this.Yw.setCurrentItem(i, false);
        }
    }

    public int le(String str) {
        if (StringUtils.isNull(str) || this.cJe == null) {
            return -1;
        }
        return this.cJe.ld(UtilHelper.getFixedText(str, 4));
    }

    public void reset() {
        if (this.cJe != null) {
            this.cJe.clear();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cJd != null) {
            this.cJd.onChangeSkinType(i);
        }
        an.d(this, i.c.cp_bg_line_d, i);
        if (this.cJe != null) {
            this.cJe.cP(i);
        }
        if (this.aJS != null) {
            this.aJS.onChangeSkinType(l.C(getContext()), i);
        }
        if (this.cJg != null) {
            this.cJg.cP(i);
        }
    }
}
