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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class p {
    private final BdTypeListView aXu;
    private com.baidu.tieba.tbadkCore.data.e bfA;
    private final com.baidu.adp.base.h<?> cMk;
    private DataRes.Builder dDC;
    private final com.baidu.tieba.recommendfrs.personalize.a.l dDH;
    private final FrameLayout dDI;
    private final Animation dDO;
    private final TranslateAnimation dDP;
    private a dDB = null;
    private final List<com.baidu.adp.widget.ListView.u> aQh = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dDD = false;
    private long dDE = 0;
    private int dDF = 1;
    private int dDG = 0;
    private TextView YY = null;
    private int dDJ = 2000;
    private final List<com.baidu.adp.widget.ListView.u> dDL = new LinkedList();
    private HashSet<String> dDM = new HashSet<>();
    public com.baidu.tbadk.performanceLog.m dDx = null;
    private AbsListView.OnScrollListener Ix = new q(this);
    private Runnable cSv = new r(this);
    private View.OnClickListener dDN = new s(this);
    private CustomMessageListener ahv = new t(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private final com.baidu.tieba.recommendfrs.control.a.a dDK = new com.baidu.tieba.recommendfrs.control.a.a();
    private final long dDA = com.baidu.tbadk.core.sharedPref.b.uO().getLong("recommend_frs_cache_time", 43200) * 1000;

    /* loaded from: classes.dex */
    public interface a {
        void J(int i, int i2, int i3);

        void aS(int i, int i2);

        void bN(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();
    }

    public p(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, com.baidu.tieba.recommendfrs.personalize.a.l lVar, FrameLayout frameLayout) {
        this.cMk = hVar;
        this.aXu = bdTypeListView;
        this.dDI = frameLayout;
        this.dDH = lVar;
        bdTypeListView.setOnScrollListener(this.Ix);
        this.dDO = AnimationUtils.loadAnimation(hVar.getPageActivity(), t.a.fade_out);
        this.dDO.setAnimationListener(new u(this));
        this.dDP = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds56), 0.0f);
        this.dDP.setDuration(400L);
        this.dDP.setAnimationListener(new v(this));
        aFi();
    }

    public void update() {
        this.mPn = 1;
        boolean z = com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("key_recommend_page_first_load", true);
        if (this.aQh.size() == 0 && !this.dDD && !z) {
            aFe();
            return;
        }
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("key_recommend_page_first_load", false);
        }
        aFc();
    }

    public void OB() {
        if (!isLoading() && this.dDB != null) {
            aFd();
            this.mPn++;
            setIsLoading(true);
            this.dDB.J(this.mPn, (this.dDC == null || this.dDC.thread_list == null) ? 0 : this.dDC.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.aXu.nr();
            com.baidu.tbadk.core.sharedPref.b.uO().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dDC == null || this.dDC.thread_list == null) ? 0 : this.dDC.thread_list.size();
        if (i != 0 || dataRes == null || !a(z, dataRes)) {
            if (this.aQh.size() > 0) {
                if (this.dDB != null) {
                    this.dDB.onError(1, str);
                    return;
                }
                return;
            } else if (this.dDB != null) {
                this.dDB.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.dDB != null) {
            this.dDB.onSuccess();
        }
        if (z && this.dDG > 0) {
            if (hn(false)) {
                aT(3, this.dDG);
            } else if (size > 0) {
                aT(2, this.dDG);
            }
        } else if (!z && this.dDG == 0) {
            aT(2, 0);
        }
        com.baidu.tbadk.core.sharedPref.b.uO().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
        aFf();
    }

    public void hm(boolean z) {
        if (z) {
            this.dDH.notifyDataSetChanged();
        }
        if (!aFb()) {
            aFh();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.hr().removeCallbacks(this.cSv);
        if (this.dDx != null) {
            this.dDx.onDestroy();
        }
    }

    public boolean aFb() {
        if (aFg()) {
            if (this.aXu != null) {
                this.aXu.setSelection(0);
                this.aXu.ns();
            }
            return true;
        }
        return false;
    }

    private void aFc() {
        if (this.dDB != null) {
            this.dDB.aS((this.dDC == null || this.dDC.thread_list == null || aFg()) ? 0 : this.dDC.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dDD = true;
        if (dataRes != null) {
            if (a(true, dataRes) && !aFg()) {
                Rb();
                if (this.dDB != null) {
                    this.dDB.onSuccess();
                }
                aFh();
                return;
            }
            aFc();
            return;
        }
        aFc();
    }

    private void Rb() {
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aER().nq(1);
        com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
        nVar.eZ(1005);
        nVar.pageType = 1;
        nVar.aAE = com.baidu.tieba.recommendfrs.a.aER().getCreateTime();
        nVar.aAL = currentTimeMillis;
        nVar.FS();
        com.baidu.tieba.recommendfrs.a.aER().setCreateTime(0L);
    }

    private boolean a(boolean z, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.u> list = null;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.dDE = dataRes.sug_seconds.intValue() * 1000;
        if (z && aFg()) {
            this.dDC = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        a(z ? 0 : 1, builder.banner_list);
        this.aQh.clear();
        com.baidu.tieba.recommendfrs.control.a.d a2 = this.dDK.a(this.dDC, builder, z ? 0 : 1);
        if (a2 != null) {
            List<com.baidu.adp.widget.ListView.u> list2 = a2.bfi;
            this.dDG = a2.dEk;
            list = list2;
        }
        if (list != null) {
            this.aQh.addAll(list);
            d(z ? 0 : 1, list);
        }
        if (this.dDC == null) {
            this.dDC = builder;
        }
        if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.dDB != null) {
            ArrayList arrayList = new ArrayList(dataRes.tag_list);
            TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.b(arrayList, 0);
            if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                TagInfo.Builder builder2 = new TagInfo.Builder();
                builder2.tag_code = 0L;
                builder2.tag_type = 1;
                builder2.tag_name = this.cMk.getString(t.j.default_personalized_name);
                arrayList.add(0, builder2.build(true));
            }
            for (int size = arrayList.size() - 1; size > 0; size--) {
                TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.x.b(arrayList, size);
                if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                    arrayList.remove(size);
                }
            }
            this.dDB.bN(arrayList);
        }
        if (this.aQh.size() == 0) {
            com.baidu.tieba.recommendfrs.a.aER().f(System.currentTimeMillis() - currentTimeMillis, 1);
            return false;
        }
        LinkedList linkedList = new LinkedList(this.aQh);
        this.dDH.setFromCDN(dataRes.is_new_url.intValue() == 1);
        this.dDH.bV(linkedList);
        com.baidu.tieba.recommendfrs.a.aER().f(System.currentTimeMillis() - currentTimeMillis, 1);
        return true;
    }

    private void aFd() {
        int aFm = this.dDK.aFm() - 40;
        if (com.baidu.tbadk.core.util.x.o(this.aQh) >= aFm) {
            com.baidu.tieba.recommendfrs.control.a.d a2 = this.dDK.a(this.dDC, null, 1, aFm);
            List<com.baidu.adp.widget.ListView.u> list = a2 != null ? a2.bfi : null;
            if (list != null) {
                this.aQh.clear();
                this.aQh.addAll(list);
                this.dDH.bV(new LinkedList(this.aQh));
            }
        }
    }

    private void aFe() {
        com.baidu.tbadk.util.n.a(new w(this, com.baidu.tbadk.core.b.a.ug().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())), new x(this));
    }

    private void aFf() {
        if (this.dDC != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dDC.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            com.baidu.tbadk.core.b.a.ug().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
        }
    }

    private boolean aFg() {
        return hn(true);
    }

    private boolean hn(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.uO().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dDA;
    }

    public void a(a aVar) {
        this.dDB = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFh() {
        long j = com.baidu.tbadk.core.sharedPref.b.uO().getLong("recommend_frs_guide_time", 0L);
        if (this.dDE != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dDE) {
                aT(1, 0);
            }
        }
    }

    private void aT(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        this.dDF = i;
        String str = null;
        if (i == 1) {
            str = TbadkCoreApplication.m411getInst().getString(t.j.recommend_frs_refresh_guide);
        } else if (i == 2) {
            if (i2 > 0) {
                str = String.format(TbadkCoreApplication.m411getInst().getString(t.j.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                str = TbadkCoreApplication.m411getInst().getString(t.j.recommend_frs_refresh_nodata);
            }
        } else if (i == 3) {
            str = TbadkCoreApplication.m411getInst().getString(t.j.recommend_frs_refresh_cache_invalid);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.YY == null) {
                this.YY = new TextView(this.cMk.getPageActivity());
                this.YY.setGravity(17);
                this.YY.setOnClickListener(this.dDN);
            }
            this.YY.setText(str);
            if (this.dDI != null) {
                if (this.YY.getParent() != null) {
                    this.dDI.removeView(this.YY);
                }
                if (this.YY.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.iZ()) {
                            int dimensionPixelSize = this.cMk.getResources().getDimensionPixelSize(t.e.ds20);
                            int dimensionPixelSize2 = this.cMk.getResources().getDimensionPixelSize(t.e.ds40);
                            this.YY.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.YY.setTextSize(0, this.cMk.getResources().getDimensionPixelSize(t.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.uO().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            ar.k(this.YY, t.f.bg_home_float);
                            ar.j((View) this.YY, t.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.cMk.getResources().getDimensionPixelSize(t.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.YY.setPadding(0, 0, 0, 0);
                        this.YY.setTextSize(0, this.cMk.getResources().getDimensionPixelSize(t.e.fontsize24));
                        ar.k(this.YY, t.d.cp_link_tip_a_alpha80);
                        ar.j((View) this.YY, t.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.dDI.addView(this.YY, layoutParams);
                    if (i == 1) {
                        this.dDJ = 4000;
                    } else {
                        this.dDJ = 2000;
                    }
                    com.baidu.adp.lib.h.h.hr().removeCallbacks(this.cSv);
                    com.baidu.adp.lib.h.h.hr().postDelayed(this.cSv, this.dDJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.hr().removeCallbacks(this.cSv);
        if (this.YY != null && this.YY.getParent() != null) {
            this.YY.startAnimation(this.dDO);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ahv != null) {
            this.ahv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahv);
        }
    }

    public void aFi() {
        this.bfA = new com.baidu.tieba.tbadkCore.data.e("new_index", com.baidu.tieba.tbadkCore.data.e.dWy);
        this.bfA.aLU();
    }

    public void d(int i, List<com.baidu.adp.widget.ListView.u> list) {
        if (this.bfA != null) {
            if (i == 0) {
                this.bfA.aLU();
            }
            if (list != null && !list.isEmpty()) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < list.size()) {
                        com.baidu.adp.widget.ListView.u uVar = list.get(i3);
                        if (uVar instanceof com.baidu.tieba.card.a.d) {
                            int position = ((com.baidu.tieba.card.a.d) uVar).getPosition();
                            if (this.dDM.remove(Integer.toString(position))) {
                                this.bfA.ba(position, i3 + 1);
                            }
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void a(int i, BannerList bannerList) {
        if (i == 0) {
            this.dDM.clear();
        }
        if (bannerList != null && bannerList.app != null) {
            for (App app : bannerList.app) {
                this.dDM.add(app.pos_name);
            }
        }
    }

    public void nt(int i) {
        if ((this.bfA != null ? this.bfA.of(i) : -1) >= 0 && this.aXu != null && this.aXu.getData() != null && this.aXu.getData().size() > i) {
            this.bfA.og(i);
            com.baidu.adp.widget.ListView.u uVar = this.aXu.getData().get(i - 1);
            if (uVar != null && (uVar instanceof com.baidu.tieba.card.a.d)) {
                com.baidu.tieba.card.c.a((com.baidu.tieba.card.a.d) uVar, 1);
            }
        }
    }
}
