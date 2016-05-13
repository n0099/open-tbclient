package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.recommendfrs.indicator.m;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager UR;
    private final com.baidu.tbadk.widget.layout.h aCJ;
    private BdUniqueId aOT;
    private NoNetworkView aST;
    private PluginErrorTipView aXa;
    private NoNetworkView.a baZ;
    private View bkp;
    private FrameLayout cIK;
    private View.OnClickListener eaA;
    private m.a eaB;
    private j eat;
    private a eau;
    private List<TagInfo> eav;
    private m eaw;
    public boolean eax;
    private com.baidu.tieba.recommendfrs.control.q eay;
    private CustomMessageListener eaz;
    private Context mContext;
    private int topHeight;

    public ViewGroup getContentContainer() {
        return this.cIK;
    }

    public boolean aol() {
        return this.eaw != null && this.eaw.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.eax = true;
        this.bkp = null;
        this.eaz = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.eaA = new f(this);
        this.baZ = new g(this);
        this.eaB = new h(this);
        this.aCJ = new i(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eax = true;
        this.bkp = null;
        this.eaz = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.eaA = new f(this);
        this.baZ = new g(this);
        this.eaB = new h(this);
        this.aCJ = new i(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cIK = (FrameLayout) findViewById(t.g.tab_widget_content_container);
        this.aST = (NoNetworkView) findViewById(t.g.view_no_network);
        this.aST.a(this.baZ);
        this.eat = new j(context, findViewById(t.g.tab_container));
        this.eat.t(this.eaA);
        ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) findViewById(t.g.fragment_tab_layout);
        observedChangeLinearLayout.setOnSizeChangeListener(this.aCJ);
        this.bkp = findViewById(t.g.statebar_view);
        this.eay = new com.baidu.tieba.recommendfrs.control.q(context, this, observedChangeLinearLayout, this.bkp);
        this.aXa = (PluginErrorTipView) observedChangeLinearLayout.findViewById(t.g.view_plugin_error_tip);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.eay != null) {
            this.eay.switchNaviBarStatus(z);
        }
    }

    public void aom() {
        if (this.eaw == null) {
            this.eaw = new m(this.cIK);
            this.eaw.a(this.eaB);
        }
        this.eaw.ow(this.topHeight);
        if (!this.eaw.isShowing()) {
            this.eaw.a(this.mContext, this.eav, this.UR.getCurrentItem());
            if (this.eat != null) {
                this.eat.aor();
            }
        }
    }

    public void aon() {
        if (this.eaw != null) {
            this.eaw.aE(this.mContext);
        }
    }

    public boolean aoo() {
        return y.r(this.eav) <= 0;
    }

    public void bw(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.l(tagInfo));
                }
            }
            com.baidu.tieba.recommendfrs.control.a.q.aMs().cl(list);
            this.eav = list;
            if (this.eau != null) {
                this.eau.an(arrayList);
                if (this.eat != null) {
                    this.eat.setViewPager(this.UR);
                }
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.eau != null) {
            this.eau.c(j, dataRes, z);
        }
    }

    public void aLR() {
        if (this.eau != null) {
            this.eau.aLR();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.recommendfrs.data.n nVar, boolean z2) {
        if (this.eau != null) {
            this.eau.a(z, j, nVar, z2);
        }
    }

    public void b(long j, String str, int i) {
        if (this.UR != null) {
            this.eau.b(j, str, i);
        }
    }

    public void a(com.baidu.tieba.recommendfrs.b bVar, com.baidu.tieba.recommendfrs.c cVar) {
        this.UR = (CustomViewPager) findViewById(t.g.tab_widget_view_pager);
        this.eau = new a(this.mContext, bVar, cVar, this.aOT);
        if (this.eay != null) {
            this.eau.setScrollFragmentTabHost(this);
            this.eau.a(this.eay.aMn(), this.eay.aMo(), this.eay.Mt());
        }
        this.UR.setAdapter(this.eau);
    }

    public boolean aop() {
        return this.eau != null && this.eau.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.eau.getCount()) {
            this.UR.setCurrentItem(i, false);
        }
    }

    public int bW(long j) {
        if (this.eau == null) {
            return -1;
        }
        return this.eau.bV(j);
    }

    public int getCurrentItem() {
        return this.UR.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.eat != null) {
            this.eat.onChangeSkinType(i);
        }
        if (this.eau != null) {
            this.eau.cV(i);
        }
        if (this.eaw != null) {
            this.eaw.cV(i);
        }
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
        if (this.aST != null) {
            this.aST.onChangeSkinType(s, i);
        }
        if (this.eay != null) {
            this.eay.onChangeSkinType(i);
        }
        if (this.aXa != null) {
            this.aXa.onChangeSkinType(s, i);
        }
        UtilHelper.setStatusBarBackground(this.bkp, i);
    }

    public void setItemForeGround(int i) {
        this.eau.setItemForeGround(i);
        if (this.aST != null) {
            if (com.baidu.adp.lib.util.i.fe()) {
                this.aST.setVisibility(8);
            } else {
                this.aST.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.eay != null) {
            this.eay.onDestroy();
        }
        this.eau.onDestroy();
        if (this.bkp != null) {
            this.bkp.setBackgroundDrawable(null);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
        this.eaz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaz);
        if (this.eay != null) {
            this.eay.setPageUniqueId(bdUniqueId);
        }
    }

    public void aMM() {
        if (this.eau != null) {
            this.eau.iR(false);
        }
    }

    public int bX(long j) {
        if (this.eav == null || this.eav.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.eav) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public void iL(boolean z) {
        this.eau.iL(z);
    }

    public void aML() {
        this.eau.aML();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.eau != null) {
            return this.eau.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.eau != null) {
            return this.eau.getCurrentPageKey();
        }
        return null;
    }

    public boolean cn(List<TagInfo> list) {
        if (y.s(list) || y.s(this.eav) || y.r(list) != y.r(this.eav)) {
            return false;
        }
        for (int i = 0; i < y.r(list); i++) {
            TagInfo tagInfo = (TagInfo) y.c(this.eav, i);
            TagInfo tagInfo2 = (TagInfo) y.c(list, i);
            if (tagInfo != null && tagInfo2 != null) {
                if (tagInfo.tag_code == null || tagInfo2.tag_code == null) {
                    return true;
                }
                if (tagInfo.tag_code.longValue() != tagInfo2.tag_code.longValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void onPause() {
        if (this.eau != null) {
            this.eau.jx();
        }
    }
}
