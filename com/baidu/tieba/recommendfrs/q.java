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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class q {
    private final com.baidu.adp.base.h<?> bLb;
    private final BdTypeListView bcd;
    private com.baidu.tieba.tbadkCore.data.f bkl;
    private final Animation dVB;
    private final TranslateAnimation dVC;
    private DataRes.Builder dVs;
    private final com.baidu.tieba.recommendfrs.personalize.a.ad dVw;
    private final FrameLayout dVx;
    private a dVr = null;
    private final List<com.baidu.adp.widget.ListView.u> aTc = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cFC = false;
    private long dVt = 0;
    private int dVu = 1;
    private int dVv = 0;
    private TextView Xr = null;
    private int dVy = 2000;
    public com.baidu.tbadk.performanceLog.m dVo = null;
    private AbsListView.OnScrollListener IE = new r(this);
    private Runnable dnb = new x(this);
    private View.OnClickListener dVA = new y(this);
    private final CustomMessageListener dVD = new z(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener dVE = new aa(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener dVF = new ab(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener dVG = new ac(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener dVH = new ad(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener ahA = new ae(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener ahZ = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final com.baidu.tieba.recommendfrs.control.a.a dVz = new com.baidu.tieba.recommendfrs.control.a.a();
    private final long dVq = com.baidu.tbadk.core.sharedPref.b.vk().getLong("recommend_frs_cache_time", 43200) * 1000;

    /* loaded from: classes.dex */
    public interface a {
        void J(int i, int i2, int i3);

        void aS(int i, int i2);

        void cg(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();
    }

    public q(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, com.baidu.tieba.recommendfrs.personalize.a.ad adVar, FrameLayout frameLayout) {
        this.bLb = hVar;
        this.bcd = bdTypeListView;
        this.dVx = frameLayout;
        this.dVw = adVar;
        bdTypeListView.setOnScrollListener(this.IE);
        this.dVB = AnimationUtils.loadAnimation(hVar.getPageActivity(), t.a.fade_out);
        this.dVB.setAnimationListener(new t(this));
        this.dVC = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds56), 0.0f);
        this.dVC.setDuration(400L);
        this.dVC.setAnimationListener(new u(this));
        aMa();
    }

    private boolean Qp() {
        return com.baidu.tbadk.core.sharedPref.b.vk().getBoolean(aLR(), true);
    }

    private void aLQ() {
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean(aLR(), false);
    }

    private String aLR() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.recommendfrs.a.aLJ().ow(1) == -1) {
            com.baidu.tieba.recommendfrs.a.aLJ().t(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        if (this.aTc.size() == 0 && !this.cFC && !Qp()) {
            apI();
        } else {
            aLT();
        }
    }

    public void Qq() {
        if (!isLoading() && this.dVr != null) {
            aLV();
            this.mPn++;
            setIsLoading(true);
            this.dVr.J(this.mPn, (this.dVs == null || this.dVs.thread_list == null) ? 0 : this.dVs.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.bcd.nj();
            com.baidu.tbadk.core.sharedPref.b.vk().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dVs == null || this.dVs.thread_list == null) ? 0 : this.dVs.thread_list.size();
        if (i != 0 || dataRes == null || !a(z, dataRes)) {
            if (this.aTc.size() > 0) {
                if (this.dVr != null) {
                    this.dVr.onError(1, str);
                    return;
                }
                return;
            } else if (this.dVr != null) {
                this.dVr.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aLQ();
        if (this.dVr != null) {
            this.dVr.onSuccess();
        }
        if (z && this.dVv > 0) {
            if (hZ(false)) {
                aT(3, this.dVv);
            } else if (size > 0) {
                aT(2, this.dVv);
            }
        } else if (!z && this.dVv == 0) {
            aT(2, 0);
        }
        com.baidu.tbadk.core.sharedPref.b.vk().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
        aLW();
    }

    public void hY(boolean z) {
        if (z) {
            this.dVw.notifyDataSetChanged();
        }
        if (!aLS()) {
            aLY();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.dnb);
        if (this.dVo != null) {
            this.dVo.onDestroy();
        }
    }

    public boolean aLS() {
        if (hZ(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("close_new_user_guide_tip", false)) {
                ia(true);
            }
            aLZ();
            if (this.bcd != null) {
                this.bcd.setSelection(0);
                this.bcd.nk();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aLT() {
        if (this.dVr != null) {
            this.dVr.aS((this.dVs == null || this.dVs.thread_list == null || aLX()) ? 0 : this.dVs.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cFC = true;
        if (dataRes != null) {
            if (a(true, dataRes) && !aLX()) {
                if (this.dVr != null) {
                    this.dVr.onSuccess();
                }
                aLY();
                return;
            }
            aLT();
            return;
        }
        aLT();
    }

    private void aLU() {
        boolean z;
        boolean z2;
        if (this.dVs != null) {
            if (this.dVs.age_sex != null) {
                if (this.dVs.age_sex.sex_tag != null && this.dVs.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.dVs.age_sex.sex_tag.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        TagStruct next = it.next();
                        if (next != null && !StringUtils.isNull(next.tag_name) && next.selected.intValue() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, com.baidu.tieba.recommendfrs.data.j.a(next)));
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        com.baidu.tieba.recommendfrs.data.j jVar = new com.baidu.tieba.recommendfrs.data.j();
                        jVar.dWO = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, jVar));
                    }
                }
                if (this.dVs.age_sex.age_tag != null && this.dVs.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.dVs.age_sex.age_tag.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        TagStruct next2 = it2.next();
                        if (next2 != null && !StringUtils.isNull(next2.tag_name) && next2.selected.intValue() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, com.baidu.tieba.recommendfrs.data.j.a(next2)));
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        com.baidu.tieba.recommendfrs.data.j jVar2 = new com.baidu.tieba.recommendfrs.data.j();
                        jVar2.dWO = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, jVar2));
                    }
                }
            }
            if (this.dVs.age_sex == null && this.dVs.interestion != null && this.dVs.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.dVs.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private boolean a(boolean z, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.u> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.dVt = dataRes.sug_seconds.intValue() * 1000;
            if (z && aLX()) {
                this.dVs = null;
            }
            int size = z ? 0 : this.aTc.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aTc.clear();
            com.baidu.tieba.recommendfrs.control.a.d a2 = this.dVz.a(this.dVs, builder, z ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.u> list2 = a2.bjU;
                this.dVv = a2.dWc;
                list = list2;
            }
            if (list != null) {
                this.aTc.addAll(list);
                a(z ? 0 : 1, list, size);
            }
            if (this.dVs == null) {
                this.dVs = builder;
            }
            aLU();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.dVr != null) {
                ArrayList arrayList = new ArrayList(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.b(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.bLb.getString(t.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.y.b(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                this.dVr.cg(arrayList);
            }
            if (this.aTc.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aTc);
                this.dVw.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.dVw.cm(linkedList);
                r1 = true;
            }
            com.baidu.tieba.recommendfrs.a.aLJ().r(System.currentTimeMillis() - currentTimeMillis, 1);
            long ow = com.baidu.tieba.recommendfrs.a.aLJ().ow(1);
            if (ow > 0) {
                com.baidu.tieba.recommendfrs.a.aLJ().s(System.currentTimeMillis() - ow, 1);
                com.baidu.tieba.recommendfrs.a.aLJ().t(0L, 1);
            }
        }
        return r1;
    }

    private void aLV() {
        int aMd = this.dVz.aMd() - 40;
        if (com.baidu.tbadk.core.util.y.p(this.aTc) >= aMd) {
            com.baidu.tieba.recommendfrs.control.a.d a2 = this.dVz.a(this.dVs, null, 1, aMd);
            List<com.baidu.adp.widget.ListView.u> list = a2 != null ? a2.bjU : null;
            if (list != null) {
                this.aTc.clear();
                this.aTc.addAll(list);
                this.dVw.cm(new LinkedList(this.aTc));
            }
        }
    }

    private void apI() {
        com.baidu.tbadk.util.q.a(new v(this, com.baidu.tbadk.core.b.a.um().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())), new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLW() {
        if (this.dVs != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dVs.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            try {
                com.baidu.tbadk.core.b.a.um().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).f("0", builder.build(true).toByteArray());
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean aLX() {
        return hZ(true);
    }

    private boolean hZ(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.vk().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dVq;
    }

    public void a(a aVar) {
        this.dVr = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLY() {
        long j = com.baidu.tbadk.core.sharedPref.b.vk().getLong("recommend_frs_guide_time", 0L);
        if (this.dVt != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dVt) {
                aT(1, 0);
            }
        }
    }

    private void aT(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        this.dVu = i;
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
            if (this.Xr == null) {
                this.Xr = new TextView(this.bLb.getPageActivity());
                this.Xr.setGravity(17);
                this.Xr.setOnClickListener(this.dVA);
            }
            this.Xr.setText(str);
            if (this.dVx != null) {
                if (this.Xr.getParent() != null) {
                    this.dVx.removeView(this.Xr);
                }
                if (this.Xr.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.jf()) {
                            int dimensionPixelSize = this.bLb.getResources().getDimensionPixelSize(t.e.ds20);
                            int dimensionPixelSize2 = this.bLb.getResources().getDimensionPixelSize(t.e.ds40);
                            this.Xr.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.Xr.setTextSize(0, this.bLb.getResources().getDimensionPixelSize(t.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.vk().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            at.k(this.Xr, t.f.bg_home_float);
                            at.j((View) this.Xr, t.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.bLb.getResources().getDimensionPixelSize(t.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.Xr.setPadding(0, 0, 0, 0);
                        this.Xr.setTextSize(0, this.bLb.getResources().getDimensionPixelSize(t.e.fontsize24));
                        at.k(this.Xr, t.d.cp_link_tip_a_alpha80);
                        at.j((View) this.Xr, t.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.dVx.addView(this.Xr, layoutParams);
                    if (i == 1) {
                        this.dVy = 4000;
                    } else {
                        this.dVy = 2000;
                    }
                    com.baidu.adp.lib.h.h.hx().removeCallbacks(this.dnb);
                    com.baidu.adp.lib.h.h.hx().postDelayed(this.dnb, this.dVy);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.dnb);
        if (this.Xr != null && this.Xr.getParent() != null) {
            this.Xr.startAnimation(this.dVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("close_new_user_guide_tip", true);
        if (this.dVs != null && this.dVs.age_sex != null) {
            this.dVs.age_sex = null;
            if (z) {
                aLW();
            }
        }
        if (this.aTc != null && this.aTc.size() > 0 && (this.aTc.get(0) instanceof com.baidu.tieba.recommendfrs.data.k)) {
            this.aTc.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        this.dVw.cm(new ArrayList(this.aTc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLZ() {
        if (this.dVs != null && this.dVs.interestion != null) {
            this.dVs.interestion = null;
            aLW();
        }
        if (this.aTc != null && this.aTc.size() > 0 && (this.aTc.get(0) instanceof com.baidu.tieba.recommendfrs.data.i)) {
            this.aTc.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        this.dVw.cm(new ArrayList(this.aTc));
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ahA != null) {
                this.ahA.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ahA);
            }
            if (this.dVD != null) {
                this.dVD.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dVD);
            }
            if (this.dVE != null) {
                this.dVE.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dVE);
            }
            if (this.dVF != null) {
                this.dVF.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dVF);
            }
            if (this.dVG != null) {
                this.dVG.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dVG);
            }
            this.dVH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dVH);
            this.ahZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahZ);
        }
    }

    public void aMa() {
        this.bkl = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.bkl.aSP();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.u> list, int i2) {
        int i3;
        int i4;
        if (this.bkl != null) {
            if (i == 0) {
                this.bkl.aSP();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.epg;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.a.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bkl.aY(i3, i7 + 1);
                            }
                            i6++;
                        }
                    } else {
                        i4 = i5;
                    }
                    i7++;
                    i6 = i6;
                    i5 = i4;
                }
            }
        }
    }

    public void oy(int i) {
        int po = this.bkl != null ? this.bkl.po(i) : -1;
        if (po >= 0 && this.bcd != null && this.bcd.getData() != null && this.bcd.getData().size() > i) {
            this.bkl.pp(i);
            com.baidu.adp.widget.ListView.u uVar = this.bcd.getData().get(i);
            if (uVar != null && (uVar instanceof com.baidu.tieba.card.a.d)) {
                com.baidu.tieba.card.c.a((com.baidu.tieba.card.a.d) uVar, 1);
            } else {
                com.baidu.tieba.card.c.K(1, po);
            }
        }
    }
}
