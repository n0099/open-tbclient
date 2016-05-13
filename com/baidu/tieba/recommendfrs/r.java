package com.baidu.tieba.recommendfrs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.baidu.tieba.c.a;
import com.baidu.tieba.frs.fh;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class r {
    private View acg;
    private boolean bKq;
    private final com.baidu.adp.base.h<?> bLj;
    private final BdTypeListView bej;
    private com.baidu.tieba.tbadkCore.data.f bgl;
    private int dYA;
    private final Animation dYC;
    private final TranslateAnimation dYD;
    public com.baidu.tieba.recommendfrs.control.m dYj;
    private final long dYl;
    private DataRes.Builder dYn;
    private final com.baidu.tieba.recommendfrs.personalize.a.ad dYr;
    private final FrameLayout dYs;
    private final com.baidu.tieba.recommendfrs.control.a.a dYu;
    private ScrollFragmentTabHost dYv;
    private ViewGroup dYw;
    private View.OnTouchListener dYx;
    private com.baidu.tieba.c.a dYy;
    private a dYm = null;
    private final List<com.baidu.adp.widget.ListView.v> aZH = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cFu = false;
    private long dYo = 0;
    private int dYp = 1;
    private int dYq = 0;
    private TextView SF = null;
    private int dYt = 2000;
    public com.baidu.tbadk.performanceLog.m dYi = null;
    private boolean bkf = false;
    private boolean dYz = false;
    private AbsListView.OnScrollListener yW = new s(this);
    private View.OnTouchListener aFz = new aa(this);
    private a.InterfaceC0052a aVe = new ab(this);
    private Runnable dpt = new ac(this);
    private View.OnClickListener dYB = new ad(this);
    private final CustomMessageListener dYE = new ae(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener dYF = new af(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener dYG = new ag(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener dYH = new ah(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener dYI = new t(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener adt = new u(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener adW = new v(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    /* loaded from: classes.dex */
    public interface a {
        void I(int i, int i2, int i3);

        void aT(int i, int i2);

        void ci(List<TagInfo> list);

        void onError(int i, String str);

        void onSuccess();
    }

    public void a(com.baidu.tieba.recommendfrs.control.m mVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        this.dYj = mVar;
        this.dYw = viewGroup;
        this.dYx = onTouchListener;
    }

    public void RS() {
        if (this.dYj != null) {
            this.dYj.iN(true);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dYv = scrollFragmentTabHost;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            if (this.SF != null && this.SF.getParent() != null && this.SF.getVisibility() != 8) {
                i2 = (i2 - this.SF.getMeasuredHeight()) - bc(this.SF);
            }
            oo(i2);
        }
    }

    private void oo(int i) {
        if (this.acg != null && this.acg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.acg.getLayoutParams();
            layoutParams.height = i;
            this.acg.setLayoutParams(layoutParams);
        }
    }

    private int bc(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rm() {
        if (this.bej != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bej.getChildCount()) {
                    View childAt = this.bej.getChildAt(this.bkf ? (this.bej.getChildCount() - 1) - i2 : i2);
                    if (childAt.getTag() instanceof fh) {
                        ((fh) childAt.getTag()).Kb();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void cU(boolean z) {
        if (this.bej != null) {
            if (z) {
                aMh();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bej.getChildCount()) {
                    View childAt = this.bej.getChildAt(this.bkf ? (this.bej.getChildCount() - 1) - i2 : i2);
                    if (childAt.getTag() instanceof fh) {
                        if (z) {
                            ((fh) childAt.getTag()).RG();
                        } else {
                            ((fh) childAt.getTag()).RH();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public r(com.baidu.adp.base.h<?> hVar, BdTypeListView bdTypeListView, View view, com.baidu.tieba.recommendfrs.personalize.a.ad adVar, FrameLayout frameLayout) {
        this.bLj = hVar;
        this.bej = bdTypeListView;
        this.acg = view;
        this.bej.setOnTouchListener(this.aFz);
        this.dYy = new com.baidu.tieba.c.a();
        this.dYy.a(this.aVe);
        this.dYs = frameLayout;
        this.dYr = adVar;
        this.dYu = new com.baidu.tieba.recommendfrs.control.a.a();
        this.dYl = com.baidu.tbadk.core.sharedPref.b.sR().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.yW);
        this.dYC = AnimationUtils.loadAnimation(hVar.getPageActivity(), t.a.fade_out);
        this.dYC.setAnimationListener(new w(this));
        this.dYD = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.ds56), 0.0f);
        this.dYD.setDuration(400L);
        this.dYD.setAnimationListener(new x(this));
        aMj();
    }

    private boolean Po() {
        return com.baidu.tbadk.core.sharedPref.b.sR().getBoolean(aLY(), true);
    }

    private void aLX() {
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean(aLY(), false);
    }

    private String aLY() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void update() {
        if (com.baidu.tieba.recommendfrs.a.aLQ().ol(1) == -1) {
            com.baidu.tieba.recommendfrs.a.aLQ().u(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        if (this.aZH.size() == 0 && !this.cFu && !Po()) {
            apQ();
        } else {
            aMb();
        }
    }

    public void aLZ() {
        if (this.dYz) {
            if (this.bKq && this.dYq > 0) {
                if (iJ(false)) {
                    aU(3, this.dYq);
                } else if (this.dYA > 0) {
                    aU(2, this.dYq);
                }
            } else if (!this.bKq && this.dYq == 0) {
                aU(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.sR().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dYz = false;
            this.bKq = false;
            this.dYA = 0;
        }
    }

    public void Pp() {
        if (!isLoading() && this.dYm != null) {
            aMd();
            this.mPn++;
            setIsLoading(true);
            this.dYm.I(this.mPn, (this.dYn == null || this.dYn.thread_list == null) ? 0 : this.dYn.thread_list.size(), 0);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.bej.k(2000L);
            com.baidu.tbadk.core.sharedPref.b.sR().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dYn == null || this.dYn.thread_list == null) ? 0 : this.dYn.thread_list.size();
        if (i != 0 || dataRes == null || !a(z, dataRes)) {
            this.dYz = false;
            if (this.aZH.size() > 0) {
                if (this.dYm != null) {
                    this.dYm.onError(1, str);
                    return;
                }
                return;
            } else if (this.dYm != null) {
                this.dYm.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aLX();
        if (this.dYm != null) {
            this.dYm.onSuccess();
        }
        this.dYz = true;
        this.bKq = z;
        this.dYA = size;
        aMe();
    }

    public void iI(boolean z) {
        if (z) {
            this.dYr.notifyDataSetChanged();
        }
        if (!aMa()) {
            aMg();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.dpt);
        if (this.dYi != null) {
            this.dYi.onDestroy();
        }
    }

    public boolean aMa() {
        if (iJ(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("close_new_user_guide_tip", false)) {
                iK(true);
            }
            aMi();
            if (this.bej != null) {
                this.bej.setSelection(0);
                this.bej.jy();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aMb() {
        if (this.dYm != null) {
            this.dYm.aT((this.dYn == null || this.dYn.thread_list == null || aMf()) ? 0 : this.dYn.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cFu = true;
        if (dataRes != null) {
            if (a(true, dataRes) && !aMf()) {
                if (this.dYm != null) {
                    this.dYm.onSuccess();
                }
                aMg();
                return;
            }
            aMb();
            return;
        }
        aMb();
    }

    private void aMc() {
        boolean z;
        boolean z2;
        if (this.dYn != null) {
            if (this.dYn.age_sex != null) {
                if (this.dYn.age_sex.sex_tag != null && this.dYn.age_sex.sex_tag.size() > 0) {
                    Iterator<TagStruct> it = this.dYn.age_sex.sex_tag.iterator();
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
                        jVar.dZY = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, jVar));
                    }
                }
                if (this.dYn.age_sex.age_tag != null && this.dYn.age_sex.age_tag.size() > 0) {
                    Iterator<TagStruct> it2 = this.dYn.age_sex.age_tag.iterator();
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
                        jVar2.dZY = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, jVar2));
                    }
                }
            }
            if (this.dYn.age_sex == null && this.dYn.interestion != null && this.dYn.interestion.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TagStruct tagStruct : this.dYn.interestion) {
                    if (tagStruct != null && !StringUtils.isNull(tagStruct.tag_name) && tagStruct.selected.intValue() == 1) {
                        arrayList.add(tagStruct.tag_name);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            }
        }
    }

    private boolean a(boolean z, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list = null;
        if (dataRes != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.dYo = dataRes.sug_seconds.intValue() * 1000;
            if (z && aMf()) {
                this.dYn = null;
            }
            int size = z ? 0 : this.aZH.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.aZH.clear();
            com.baidu.tieba.recommendfrs.control.a.d a2 = this.dYu.a(this.dYn, builder, z ? 0 : 1);
            if (a2 != null) {
                List<com.baidu.adp.widget.ListView.v> list2 = a2.bfT;
                this.dYq = a2.dZm;
                list = list2;
            }
            if (list != null) {
                this.aZH.addAll(list);
                a(z ? 0 : 1, list, size);
            }
            if (this.dYn == null) {
                this.dYn = builder;
            }
            aMc();
            if (dataRes.tag_list != null && dataRes.tag_list.size() > 0 && this.dYm != null) {
                ArrayList arrayList = new ArrayList(dataRes.tag_list);
                TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, 0);
                if (tagInfo == null || tagInfo.tag_type.intValue() != 1) {
                    TagInfo.Builder builder2 = new TagInfo.Builder();
                    builder2.tag_code = 0L;
                    builder2.tag_type = 1;
                    builder2.tag_name = this.bLj.getString(t.j.default_personalized_name);
                    arrayList.add(0, builder2.build(true));
                }
                for (int size2 = arrayList.size() - 1; size2 > 0; size2--) {
                    TagInfo tagInfo2 = (TagInfo) com.baidu.tbadk.core.util.y.c(arrayList, size2);
                    if (tagInfo2 != null && tagInfo2.tag_type.intValue() == 1) {
                        arrayList.remove(size2);
                    }
                }
                this.dYm.ci(arrayList);
            }
            if (this.aZH.size() != 0) {
                LinkedList linkedList = new LinkedList(this.aZH);
                this.dYr.setFromCDN(dataRes.is_new_url.intValue() == 1);
                this.dYr.co(linkedList);
                r1 = true;
            }
            com.baidu.tieba.recommendfrs.a.aLQ().s(System.currentTimeMillis() - currentTimeMillis, 1);
            long ol = com.baidu.tieba.recommendfrs.a.aLQ().ol(1);
            if (ol > 0) {
                com.baidu.tieba.recommendfrs.a.aLQ().t(System.currentTimeMillis() - ol, 1);
                com.baidu.tieba.recommendfrs.a.aLQ().u(0L, 1);
            }
        }
        return r1;
    }

    private void aMd() {
        int aMr = this.dYu.aMr() - 40;
        if (com.baidu.tbadk.core.util.y.r(this.aZH) >= aMr) {
            com.baidu.tieba.recommendfrs.control.a.d a2 = this.dYu.a(this.dYn, null, 1, aMr);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.bfT : null;
            if (list != null) {
                this.aZH.clear();
                this.aZH.addAll(list);
                this.dYr.co(new LinkedList(this.aZH));
            }
        }
    }

    private void apQ() {
        com.baidu.tbadk.util.t.a(new y(this, com.baidu.tbadk.core.b.a.rS().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())), new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMe() {
        if (this.dYn != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dYn.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            try {
                com.baidu.tbadk.core.b.a.rS().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).f("0", builder.build(true).toByteArray());
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean aMf() {
        return iJ(true);
    }

    private boolean iJ(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.sR().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dYl;
    }

    public void a(a aVar) {
        this.dYm = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMg() {
        long j = com.baidu.tbadk.core.sharedPref.b.sR().getLong("recommend_frs_guide_time", 0L);
        if (this.dYo != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dYo) {
                aU(1, 0);
            }
        }
    }

    private void aU(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.dYv != null && this.dYv.aol()) {
            aMh();
        } else if (this.dYv == null || this.dYv.getCurrentItem() <= 0) {
            this.dYp = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.m11getInst().getString(t.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.m11getInst().getString(t.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.m11getInst().getString(t.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.m11getInst().getString(t.j.recommend_frs_refresh_cache_invalid);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.SF == null) {
                    this.SF = new TextView(this.bLj.getPageActivity());
                    this.SF.setGravity(17);
                    this.SF.setOnClickListener(this.dYB);
                    oo(this.dYw.getMeasuredHeight());
                }
                aMh();
                if (this.dYw != null && this.SF.getParent() == null) {
                    if (i == 1) {
                        if (com.baidu.adp.lib.util.i.fq()) {
                            int dimensionPixelSize = this.bLj.getResources().getDimensionPixelSize(t.e.ds20);
                            int dimensionPixelSize2 = this.bLj.getResources().getDimensionPixelSize(t.e.ds40);
                            this.SF.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.SF.setTextSize(0, this.bLj.getResources().getDimensionPixelSize(t.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.sR().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            at.k(this.SF, t.f.bg_home_float);
                            at.j((View) this.SF, t.d.cp_link_tip_a);
                            layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds8);
                        } else {
                            return;
                        }
                    } else {
                        this.SF.setPadding(0, 0, 0, 0);
                        this.SF.setTextSize(0, this.bLj.getResources().getDimensionPixelSize(t.e.fontsize24));
                        at.k(this.SF, t.d.cp_link_tip_a_alpha80);
                        at.j((View) this.SF, t.d.cp_cont_g);
                        layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds56));
                        layoutParams.gravity = 49;
                    }
                    this.dYw.addView(this.SF, layoutParams);
                    this.SF.setText(str);
                    this.SF.setVisibility(0);
                    if (i == 1) {
                        this.dYt = 4000;
                    } else {
                        this.dYt = 2000;
                    }
                    com.baidu.adp.lib.h.h.dL().removeCallbacks(this.dpt);
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.dpt, this.dYt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.dpt);
        if (this.SF != null && this.SF.getParent() != null) {
            this.SF.startAnimation(this.dYC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMh() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.dpt);
        if (this.SF != null) {
            this.SF.clearAnimation();
            if (this.SF.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.SF.getParent()).removeView(this.SF);
            }
            this.SF.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iK(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("close_new_user_guide_tip", true);
        if (this.dYn != null && this.dYn.age_sex != null) {
            this.dYn.age_sex = null;
            if (z) {
                aMe();
            }
        }
        if (this.aZH != null && this.aZH.size() > 0 && (this.aZH.get(0) instanceof com.baidu.tieba.recommendfrs.data.k)) {
            this.aZH.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, null));
        this.dYr.co(new ArrayList(this.aZH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMi() {
        if (this.dYn != null && this.dYn.interestion != null) {
            this.dYn.interestion = null;
            aMe();
        }
        if (this.aZH != null && this.aZH.size() > 0 && (this.aZH.get(0) instanceof com.baidu.tieba.recommendfrs.data.i)) {
            this.aZH.remove(0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, null));
        this.dYr.co(new ArrayList(this.aZH));
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.adt != null) {
                this.adt.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.adt);
            }
            if (this.dYE != null) {
                this.dYE.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dYE);
            }
            if (this.dYF != null) {
                this.dYF.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dYF);
            }
            if (this.dYG != null) {
                this.dYG.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dYG);
            }
            if (this.dYH != null) {
                this.dYH.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dYH);
            }
            this.dYI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dYI);
            this.adW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.adW);
        }
    }

    public void aMj() {
        this.bgl = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.bgl.aTw();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bgl != null) {
            if (i == 0) {
                this.bgl.aTw();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.esq;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.a.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bgl.aY(i3, i7 + 1);
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

    public void op(int i) {
        int pj = this.bgl != null ? this.bgl.pj(i) : -1;
        if (pj >= 0 && this.bej != null && this.bej.getData() != null && this.bej.getData().size() > i) {
            this.bgl.pk(i);
            com.baidu.adp.widget.ListView.v vVar = this.bej.getData().get(i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.card.a.d)) {
                com.baidu.tieba.card.e.a((com.baidu.tieba.card.a.d) vVar, 1);
            } else {
                com.baidu.tieba.card.e.L(1, pj);
            }
        }
    }
}
