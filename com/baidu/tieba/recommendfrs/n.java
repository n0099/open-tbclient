package com.baidu.tieba.recommendfrs;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class n {
    private final BdTypeListView aVi;
    private final com.baidu.adp.base.h<?> cET;
    private final Animation doA;
    private final TranslateAnimation doB;
    private DataRes.Builder dop;
    private final com.baidu.tieba.recommendfrs.personalize.a.j dou;
    private final FrameLayout dov;
    private a doo = null;
    private final List<com.baidu.adp.widget.ListView.u> aOe = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean doq = false;
    private long dor = 0;
    private int dos = 1;
    private int dot = 0;
    private TextView YB = null;
    private int dow = 2000;
    private AbsListView.OnScrollListener Ik = new o(this);
    private Runnable doy = new p(this);
    private View.OnClickListener doz = new q(this);
    private CustomMessageListener agG = new r(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private final com.baidu.tieba.recommendfrs.control.a.a dox = new com.baidu.tieba.recommendfrs.control.a.a();
    private final long don = com.baidu.tbadk.core.sharedPref.b.tJ().getLong("recommend_frs_cache_time", 43200) * 1000;

    /* loaded from: classes.dex */
    public interface a {
        void K(int i, int i2, int i3);

        void aT(int i, int i2);

        void bD(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();
    }

    public n(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, com.baidu.tieba.recommendfrs.personalize.a.j jVar, FrameLayout frameLayout) {
        this.cET = hVar;
        this.aVi = bdTypeListView;
        this.dov = frameLayout;
        this.dou = jVar;
        bdTypeListView.setOnScrollListener(this.Ik);
        this.doA = AnimationUtils.loadAnimation(hVar.getPageActivity(), n.a.fade_out);
        this.doA.setAnimationListener(new s(this));
        this.doB = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.ds56), 0.0f);
        this.doB.setDuration(400L);
        this.doB.setAnimationListener(new t(this));
    }

    public void update() {
        this.mPn = 1;
        if (this.aOe.size() == 0 && !this.doq) {
            aye();
        } else {
            ayc();
        }
    }

    public void loadMore() {
        if (!isLoading() && this.doo != null) {
            ayd();
            this.mPn++;
            setIsLoading(true);
            this.doo.K(this.mPn, (this.dop == null || this.dop.thread_list == null) ? 0 : this.dop.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.aVi.completePullRefresh();
            com.baidu.tbadk.core.sharedPref.b.tJ().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dop == null || this.dop.thread_list == null) ? 0 : this.dop.thread_list.size();
        if (i != 0 || dataRes == null || !a(z, dataRes)) {
            if (this.aOe.size() > 0) {
                if (this.doo != null) {
                    this.doo.onError(1, str);
                    return;
                }
                return;
            } else if (this.doo != null) {
                this.doo.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.doo != null) {
            this.doo.onSuccess();
        }
        if (z && this.dot > 0) {
            if (gO(false)) {
                aU(3, this.dot);
            } else if (size > 0) {
                aU(2, this.dot);
            }
        } else if (!z && this.dot == 0) {
            aU(2, 0);
        }
        com.baidu.tbadk.core.sharedPref.b.tJ().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
        ayf();
    }

    public void aya() {
        if (!ayb()) {
            ayh();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.doy);
    }

    public boolean ayb() {
        if (ayg()) {
            if (this.aVi != null) {
                this.aVi.setSelection(0);
                this.aVi.nb();
            }
            return true;
        }
        return false;
    }

    private void ayc() {
        if (this.doo != null) {
            this.doo.aT((this.dop == null || this.dop.thread_list == null || ayg()) ? 0 : this.dop.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.doq = true;
        if (dataRes != null) {
            if (a(true, dataRes) && !ayg()) {
                if (this.doo != null) {
                    this.doo.onSuccess();
                }
                ayh();
                return;
            }
            ayc();
            return;
        }
        ayc();
    }

    private boolean a(boolean z, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.u> list;
        if (dataRes == null) {
            return false;
        }
        this.dor = dataRes.sug_seconds.intValue() * 1000;
        if (z && ayg()) {
            this.dop = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.aOe.clear();
        com.baidu.tieba.recommendfrs.control.a.d a2 = this.dox.a(this.dop, builder, z ? 0 : 1);
        if (a2 != null) {
            list = a2.bcS;
            this.dot = a2.doR;
        } else {
            list = null;
        }
        if (list != null) {
            this.aOe.addAll(list);
        }
        if (this.dop == null) {
            this.dop = builder;
        }
        if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.doo != null) {
            ArrayList arrayList = new ArrayList(dataRes.tag_list);
            TagInfo tagInfo = (TagInfo) y.b(arrayList, 0);
            if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                TagInfo.Builder builder2 = new TagInfo.Builder();
                builder2.tag_code = 0L;
                builder2.tag_type = 1;
                builder2.tag_name = this.cET.getString(n.j.default_personalized_name);
                arrayList.add(0, builder2.build(true));
            }
            for (int size = arrayList.size() - 1; size > 0; size--) {
                TagInfo tagInfo2 = (TagInfo) y.b(arrayList, size);
                if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                    arrayList.remove(size);
                }
            }
            this.doo.bD(arrayList);
        }
        if (this.aOe.size() != 0) {
            LinkedList linkedList = new LinkedList(this.aOe);
            this.dou.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dou.bJ(linkedList);
            return true;
        }
        return false;
    }

    private void ayd() {
        int ayj = this.dox.ayj() - 40;
        if (y.l(this.aOe) >= ayj) {
            com.baidu.tieba.recommendfrs.control.a.d a2 = this.dox.a(this.dop, null, 1, ayj);
            List<com.baidu.adp.widget.ListView.u> list = a2 != null ? a2.bcS : null;
            if (list != null) {
                this.aOe.clear();
                this.aOe.addAll(list);
                this.dou.bJ(new LinkedList(this.aOe));
            }
        }
    }

    private void aye() {
        com.baidu.tbadk.util.n.a(new u(this, com.baidu.tbadk.core.b.a.tc().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())), new v(this));
    }

    private void ayf() {
        if (this.dop != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dop.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.core.b.a.tc().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
        }
    }

    private boolean ayg() {
        return gO(true);
    }

    private boolean gO(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.tJ().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.don;
    }

    public void a(a aVar) {
        this.doo = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayh() {
        long j = com.baidu.tbadk.core.sharedPref.b.tJ().getLong("recommend_frs_guide_time", 0L);
        if (this.dor != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dor) {
                aU(1, 0);
            }
        }
    }

    private void aU(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        this.dos = i;
        String str = null;
        if (i == 1) {
            str = TbadkCoreApplication.m411getInst().getString(n.j.recommend_frs_refresh_guide);
        } else if (i == 2) {
            if (i2 > 0) {
                str = String.format(TbadkCoreApplication.m411getInst().getString(n.j.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                str = TbadkCoreApplication.m411getInst().getString(n.j.recommend_frs_refresh_nodata);
            }
        } else if (i == 3) {
            str = TbadkCoreApplication.m411getInst().getString(n.j.recommend_frs_refresh_cache_invalid);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.YB == null) {
                this.YB = new TextView(this.cET.getPageActivity());
                this.YB.setGravity(17);
                this.YB.setOnClickListener(this.doz);
            }
            this.YB.setText(str);
            if (this.dov != null) {
                if (this.YB.getParent() != null) {
                    this.dov.removeView(this.YB);
                }
                if (this.YB.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.iQ()) {
                            int dimensionPixelSize = this.cET.getResources().getDimensionPixelSize(n.e.ds20);
                            int dimensionPixelSize2 = this.cET.getResources().getDimensionPixelSize(n.e.ds40);
                            this.YB.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.YB.setTextSize(0, this.cET.getResources().getDimensionPixelSize(n.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.tJ().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            as.i((View) this.YB, n.f.bg_home_float);
                            as.h((View) this.YB, n.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.cET.getResources().getDimensionPixelSize(n.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.YB.setPadding(0, 0, 0, 0);
                        this.YB.setTextSize(0, this.cET.getResources().getDimensionPixelSize(n.e.fontsize24));
                        as.i((View) this.YB, n.d.cp_link_tip_a_alpha80);
                        as.h((View) this.YB, n.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.dov.addView(this.YB, layoutParams);
                    if (i == 1) {
                        this.dow = 4000;
                    } else {
                        this.dow = 2000;
                    }
                    com.baidu.adp.lib.h.h.hj().removeCallbacks(this.doy);
                    com.baidu.adp.lib.h.h.hj().postDelayed(this.doy, this.dow);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.doy);
        if (this.YB != null && this.YB.getParent() != null) {
            this.YB.startAnimation(this.doA);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.agG != null) {
            this.agG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.agG);
        }
    }
}
