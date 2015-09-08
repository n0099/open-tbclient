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
    private CustomViewPager YD;
    private NoNetworkView aKO;
    private List<String> cAW;
    private e cBD;
    private a cBE;
    private FrameLayout cBF;
    private h cBG;
    private View.OnClickListener cBH;
    private h.a cBI;
    private Context mContext;

    public boolean anY() {
        return this.cBG != null && this.cBG.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cBH = new c(this);
        this.cBI = new d(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cBH = new c(this);
        this.cBI = new d(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aKO = (NoNetworkView) findViewById(i.f.view_no_network);
        this.cBD = new e(context, findViewById(i.f.tab_container));
        this.cBD.G(this.cBH);
        this.cBF = (FrameLayout) findViewById(i.f.tab_widget_content_container);
    }

    public void anZ() {
        if (this.cBG == null) {
            this.cBG = new h(this.cBF);
            this.cBG.a(this.cBI);
        }
        if (!this.cBG.isShowing()) {
            this.cBG.a(this.mContext, this.cAW, this.YD.getCurrentItem());
            if (this.cBD != null) {
                this.cBD.aod();
            }
        }
    }

    public void aoa() {
        if (this.cBG != null) {
            this.cBG.aL(this.mContext);
        }
    }

    public void bm(List<String> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.e(str));
                }
            }
            this.cAW = list;
            if (this.cBE != null) {
                this.cBE.q(arrayList);
                if (this.cBD != null) {
                    this.cBD.setViewPager(this.YD);
                }
            }
        }
    }

    public void b(boolean z, String str, com.baidu.tieba.recommendfrs.data.g gVar, boolean z2) {
        if (!StringUtils.isNull(str) && this.cBE != null) {
            this.cBE.a(z, str, gVar, z2);
        }
    }

    public void i(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && this.YD != null) {
            this.cBE.i(str, str2, i);
        }
    }

    public void b(com.baidu.tieba.recommendfrs.a aVar) {
        this.YD = (CustomViewPager) findViewById(i.f.tab_widget_view_pager);
        this.cBE = new a(this.mContext, aVar);
        this.YD.setAdapter(this.cBE);
    }

    public boolean aob() {
        return this.cBE != null && this.cBE.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.cBE.getCount()) {
            this.YD.setCurrentItem(i, false);
        }
    }

    public int kD(String str) {
        if (StringUtils.isNull(str) || this.cBE == null) {
            return -1;
        }
        return this.cBE.kC(UtilHelper.getFixedText(str, 4));
    }

    public void reset() {
        if (this.cBE != null) {
            this.cBE.clear();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cBD != null) {
            this.cBD.onChangeSkinType(i);
        }
        al.d(this, i.c.cp_bg_line_d, i);
        if (this.cBE != null) {
            this.cBE.cO(i);
        }
        if (this.aKO != null) {
            this.aKO.onChangeSkinType(l.C(getContext()), i);
        }
        if (this.cBG != null) {
            this.cBG.cO(i);
        }
    }
}
