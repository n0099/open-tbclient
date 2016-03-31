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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.recommendfrs.control.a.q;
import com.baidu.tieba.recommendfrs.indicator.l;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends LinearLayout {
    private CustomViewPager Zy;
    private BdUniqueId aSu;
    private NoNetworkView aWZ;
    private NoNetworkView.a bfk;
    private FrameLayout cIg;
    private i dXk;
    private a dXl;
    private List<TagInfo> dXm;
    private l dXn;
    public boolean dXo;
    private CustomMessageListener dXp;
    private View.OnClickListener dXq;
    private l.a dXr;
    private Context mContext;

    public boolean aof() {
        return this.dXn != null && this.dXn.isShowing();
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.dXo = true;
        this.dXp = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.dXq = new f(this);
        this.bfk = new g(this);
        this.dXr = new h(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXo = true;
        this.dXp = new e(this, CmdConfigCustom.CMD_RECOMMEND_FRS_GOD_FEED_TAB_TIP_SHOW);
        this.dXq = new f(this);
        this.bfk = new g(this);
        this.dXr = new h(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.aWZ = (NoNetworkView) findViewById(t.g.view_no_network);
        this.aWZ.a(this.bfk);
        this.dXk = new i(context, findViewById(t.g.tab_container));
        this.dXk.x(this.dXq);
        this.cIg = (FrameLayout) findViewById(t.g.tab_widget_content_container);
    }

    public void aog() {
        if (this.dXn == null) {
            this.dXn = new l(this.cIg);
            this.dXn.a(this.dXr);
        }
        if (!this.dXn.isShowing()) {
            this.dXn.a(this.mContext, this.dXm, this.Zy.getCurrentItem());
            if (this.dXk != null) {
                this.dXk.aol();
            }
        }
    }

    public void aoh() {
        if (this.dXn != null) {
            this.dXn.ay(this.mContext);
        }
    }

    public boolean aoi() {
        return y.p(this.dXm) <= 0;
    }

    public void bw(List<TagInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (TagInfo tagInfo : list) {
                if (tagInfo != null) {
                    arrayList.add(new com.baidu.tieba.recommendfrs.data.l(tagInfo));
                }
            }
            q.aMe().cj(list);
            this.dXm = list;
            if (this.dXl != null) {
                this.dXl.ap(arrayList);
                if (this.dXk != null) {
                    this.dXk.setViewPager(this.Zy);
                }
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        if (this.dXl != null) {
            this.dXl.c(j, dataRes, z);
        }
    }

    public void aLK() {
        if (this.dXl != null) {
            this.dXl.aLK();
        }
    }

    public void b(boolean z, long j, com.baidu.tieba.recommendfrs.data.n nVar, boolean z2) {
        if (this.dXl != null) {
            this.dXl.a(z, j, nVar, z2);
        }
    }

    public void b(long j, String str, int i) {
        if (this.Zy != null) {
            this.dXl.b(j, str, i);
        }
    }

    public void a(com.baidu.tieba.recommendfrs.b bVar, com.baidu.tieba.recommendfrs.c cVar) {
        this.Zy = (CustomViewPager) findViewById(t.g.tab_widget_view_pager);
        this.dXl = new a(this.mContext, bVar, cVar, this.aSu);
        this.Zy.setAdapter(this.dXl);
    }

    public boolean aoj() {
        return this.dXl != null && this.dXl.getCount() > 0;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.dXl.getCount()) {
            this.Zy.setCurrentItem(i, false);
        }
    }

    public int bW(long j) {
        if (this.dXl == null) {
            return -1;
        }
        return this.dXl.bV(j);
    }

    public int getCurrentItem() {
        return this.Zy.getCurrentItem();
    }

    public void onChangeSkinType(int i) {
        if (this.dXk != null) {
            this.dXk.onChangeSkinType(i);
        }
        if (this.dXl != null) {
            this.dXl.dn(i);
        }
        if (this.aWZ != null) {
            this.aWZ.onChangeSkinType(com.baidu.adp.base.l.s(getContext()), i);
        }
        if (this.dXn != null) {
            this.dXn.dn(i);
        }
    }

    public void setItemForeGround(int i) {
        this.dXl.setItemForeGround(i);
    }

    public void onDestroy() {
        this.dXl.onDestroy();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
        this.dXp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dXp);
    }

    public void aMy() {
        if (this.dXl != null) {
            this.dXl.ic(false);
        }
    }

    public int bX(long j) {
        if (this.dXm == null || this.dXm.size() == 0) {
            return 0;
        }
        for (TagInfo tagInfo : this.dXm) {
            if (tagInfo != null && tagInfo.tag_code.longValue() == j) {
                return tagInfo.tag_type.intValue();
            }
        }
        return 0;
    }

    public void ib(boolean z) {
        this.dXl.ib(z);
    }

    public void aMx() {
        this.dXl.aMx();
    }

    public List<String> getNextPageSourceKeyList() {
        if (this.dXl != null) {
            return this.dXl.getNextPageSourceKeyList();
        }
        return null;
    }

    public String getCurrentPageKey() {
        if (this.dXl != null) {
            return this.dXl.getCurrentPageKey();
        }
        return null;
    }

    public boolean cl(List<TagInfo> list) {
        if (y.q(list) || y.q(this.dXm) || y.p(list) != y.p(this.dXm)) {
            return false;
        }
        for (int i = 0; i < y.p(list); i++) {
            TagInfo tagInfo = (TagInfo) y.b(this.dXm, i);
            TagInfo tagInfo2 = (TagInfo) y.b(list, i);
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
}
