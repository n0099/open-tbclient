package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.recommendfrs.indicator.l;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private BdUniqueId aPF;
    private NoNetworkView aTn;
    private CustomViewPager aam;
    private NoNetworkView.a baA;
    private List<TagInfo> dEX;
    private i dFl;
    private a dFm;
    private FrameLayout dFn;
    private l dFo;
    public boolean dFp;
    private CustomMessageListener dFq;
    private View.OnClickListener dFr;
    private l.a dFs;
    private Context mContext;

    public boolean aFI() {
        return this.dFo != null && this.dFo.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.dFp = true;
        this.dFq = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.dFr = new f(this);
        this.baA = new g(this);
        this.dFs = new h(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dFp = true;
        this.dFq = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.dFr = new f(this);
        this.baA = new g(this);
        this.dFs = new h(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aTn = (NoNetworkView) findViewById(t.g.view_no_network);
        this.aTn.a(this.baA);
        this.dFl = new i(context, findViewById(t.g.tab_container));
        this.dFl.Q(this.dFr);
        this.dFn = (FrameLayout) findViewById(t.g.tab_widget_content_container);
    }

    public void aFJ() {
        if (this.dFo == null) {
            this.dFo = new l(this.dFn);
            this.dFo.a(this.dFs);
        }
        if (!this.dFo.isShowing()) {
            this.dFo.a(this.mContext, this.dEX, this.aam.getCurrentItem());
            if (this.dFl != null) {
                this.dFl.aFP();
            }
        }
    }

    public void aFK() {
        if (this.dFo != null) {
            this.dFo.aL(this.mContext);
        }
    }

    public boolean aFL() {
        return x.o(this.dEX) <= 0;
    }

    public void bT(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.h(tagInfo));
                }
            }
            com.baidu.tieba.recommendfrs.control.a.n.aFn().bR(list);
            this.dEX = list;
            if (this.dFm != null) {
                this.dFm.al(arrayList);
                if (this.dFl != null) {
                    this.dFl.setViewPager(this.aam);
                }
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.dFm != null) {
            this.dFm.c(j, dataRes, z);
        }
    }

    public void aEV() {
        if (this.dFm != null) {
            this.dFm.aEV();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.recommendfrs.data.j jVar, boolean z2) {
        if (this.dFm != null) {
            this.dFm.a(z, j, jVar, z2);
        }
    }

    public void b(long j, String str, int i) {
        if (this.aam != null) {
            this.dFm.b(j, str, i);
        }
    }

    public void a(com.baidu.tieba.recommendfrs.b bVar, com.baidu.tieba.recommendfrs.c cVar) {
        this.aam = (CustomViewPager) findViewById(t.g.tab_widget_view_pager);
        this.dFm = new a(this.mContext, bVar, cVar, this.aPF);
        this.aam.setAdapter(this.dFm);
    }

    public boolean aFM() {
        return this.dFm != null && this.dFm.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.dFm.getCount()) {
            this.aam.setCurrentItem(i, false);
        }
    }

    public int bM(long j) {
        if (this.dFm == null) {
            return -1;
        }
        return this.dFm.bL(j);
    }

    public int getCurrentItem() {
        return this.aam.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.dFl != null) {
            this.dFl.onChangeSkinType(i);
        }
        if (this.dFm != null) {
            this.dFm.dk(i);
        }
        if (this.aTn != null) {
            this.aTn.onChangeSkinType(com.baidu.adp.base.l.C(getContext()), i);
        }
        if (this.dFo != null) {
            this.dFo.dk(i);
        }
    }

    public void setItemForeGround(int i) {
        this.dFm.setItemForeGround(i);
    }

    public void onDestroy() {
        this.dFm.onDestroy();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
        this.dFq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dFq);
    }

    public void aFN() {
        if (this.dFm != null) {
            this.dFm.hp(false);
        }
    }

    public int bN(long j) {
        if (this.dEX == null || this.dEX.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.dEX) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public void aFl() {
        this.dFm.aFl();
    }

    public void aFH() {
        this.dFm.aFH();
    }
}
