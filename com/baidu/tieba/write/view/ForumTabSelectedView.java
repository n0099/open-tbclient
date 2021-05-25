package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.google.android.material.tabs.TabLayout;
import d.a.c.e.p.l;
import d.a.m0.r.u.c;
import d.a.n0.r0.m;
import java.util.List;
/* loaded from: classes5.dex */
public class ForumTabSelectedView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public FrsTabItemData f21914e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21915f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21916g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout f21917h;

    /* renamed from: i  reason: collision with root package name */
    public int f21918i;
    public TabLayout.OnTabSelectedListener j;
    public BaseActivity k;
    public View.OnClickListener l;

    /* loaded from: classes5.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            if (tab == null || !(tab.getTag() instanceof FrsTabItemData)) {
                return;
            }
            FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
            if (frsTabItemData.isSelected) {
                frsTabItemData.isSelected = false;
                ForumTabSelectedView.this.f21914e = null;
                ForumTabSelectedView.this.setTabColorUnSelected(tab);
                return;
            }
            frsTabItemData.isSelected = true;
            ForumTabSelectedView.this.f21914e = frsTabItemData;
            ForumTabSelectedView.this.setTabColorSelected(tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab == null || !(tab.getTag() instanceof FrsTabItemData)) {
                return;
            }
            FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
            frsTabItemData.isSelected = true;
            ForumTabSelectedView.this.f21914e = frsTabItemData;
            ForumTabSelectedView.this.setTabColorSelected(tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab == null || !(tab.getTag() instanceof FrsTabItemData)) {
                return;
            }
            ((FrsTabItemData) tab.getTag()).isSelected = false;
            ForumTabSelectedView.this.setTabColorUnSelected(tab);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForumTabSelectedView.this.k != null) {
                l.x(ForumTabSelectedView.this.getContext(), ForumTabSelectedView.this);
                m.b(ForumTabSelectedView.this.k, ForumTabSelectedView.this.k.getPageContext());
            }
        }
    }

    public ForumTabSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21918i = R.color.CAM_X0202;
        this.j = new a();
        this.l = new b();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        ((d.a.m0.r.f0.m.b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).q(R.color.CAM_X0302);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        d.a.m0.r.f0.m.b bVar = (d.a.m0.r.f0.m.b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
        if (j(tab)) {
            return;
        }
        bVar.r(R.color.CAM_X0107);
    }

    public final void e() {
        this.f21915f = new ImageView(getContext());
        int g2 = l.g(getContext(), R.dimen.tbds31);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.setMargins(l.g(getContext(), R.dimen.M_W_X002), 0, 0, 0);
        this.f21915f.setLayoutParams(layoutParams);
        this.f21915f.setOnClickListener(this.l);
        addView(this.f21915f);
    }

    public final void f(TabLayout tabLayout) {
        SkinManager.setBackgroundColor(tabLayout, this.f21918i);
        if (tabLayout != null) {
            for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tabAt.getCustomView();
                    tBSpecificationBtn.k();
                    d.a.m0.r.f0.m.b bVar = (d.a.m0.r.f0.m.b) tBSpecificationBtn.getStyleConfig();
                    if (tabAt.isSelected()) {
                        bVar.q(R.color.CAM_X0302);
                    } else if (j(tabAt)) {
                        bVar.r(R.color.CAM_X0302);
                    } else {
                        bVar.r(R.color.CAM_X0107);
                    }
                }
            }
        }
    }

    public final void g() {
        this.f21917h = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.forum_tab_select_layout, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(l.g(getContext(), R.dimen.M_W_X002), 0, 0, 0);
        this.f21917h.setLayoutParams(layoutParams);
        addView(this.f21917h);
        this.f21917h.setOnTabSelectedListener(this.j);
    }

    public FrsTabItemData getSelectedTabItemData() {
        FrsTabItemData frsTabItemData = this.f21914e;
        if (frsTabItemData == null || !frsTabItemData.isSelected) {
            return null;
        }
        return frsTabItemData;
    }

    public final void h() {
        this.f21916g = new EMTextView(getContext());
        this.f21916g.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        c.d(this.f21916g).w(R.dimen.T_X08);
        this.f21916g.setText(R.string.forum_tab_select_title);
        this.f21916g.setOnClickListener(this.l);
        addView(this.f21916g);
    }

    public final void i() {
        setOrientation(0);
        setGravity(16);
        h();
        e();
        g();
    }

    public final boolean j(TabLayout.Tab tab) {
        return tab != null && (tab.getTag() instanceof FrsTabItemData) && ((FrsTabItemData) tab.getTag()).tabId == 505;
    }

    public void k(int i2) {
        f(this.f21917h);
        SkinManager.setViewTextColor(this.f21916g, R.color.CAM_X0107);
        this.f21915f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_post_section12, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.google.android.material.tabs.TabLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final void l(List<FrsTabItemData> list, TabLayout tabLayout, int i2) {
        tabLayout.removeAllTabs();
        tabLayout.setTabRippleColorResource(R.color.transparent);
        int min = Math.min(list.size(), 10);
        ?? r3 = 0;
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i3 = 0; i3 < tabCount; i3++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout == null) {
            return;
        }
        int g2 = l.g(getContext(), R.dimen.M_W_X002);
        l.g(getContext(), R.dimen.tbds25);
        int g3 = l.g(getContext(), R.dimen.M_W_X006);
        int g4 = l.g(getContext(), R.dimen.M_H_X003);
        int i4 = 0;
        while (i4 < min) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i4);
            if (tabAt == null) {
                tabAt = tabLayout.newTab();
                tabLayout.addTab(tabAt, (boolean) r3);
                View childAt = linearLayout.getChildAt(i4);
                if (childAt != null) {
                    childAt.setPadding(r3, r3, r3, r3);
                }
            }
            FrsTabItemData frsTabItemData = list.get(i4);
            if (frsTabItemData != null) {
                String str = frsTabItemData.name;
                int i5 = frsTabItemData.tabId;
                if (!TextUtils.isEmpty(str) && i5 >= 0) {
                    TBSpecificationBtn tBSpecificationBtn = null;
                    if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        tBSpecificationBtn = new TBSpecificationBtn(getContext());
                        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
                        bVar.k(g3);
                        bVar.m(g4);
                        if (frsTabItemData.tabId == 505) {
                            bVar.r(R.color.CAM_X0302);
                        } else {
                            bVar.r(R.color.CAM_X0107);
                        }
                        tBSpecificationBtn.setConfig(bVar);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(g2, 0, g2, 0);
                        tBSpecificationBtn.setLayoutParams(layoutParams);
                        tabAt.setCustomView(tBSpecificationBtn);
                    }
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setText(str);
                    }
                    if (tabAt != null) {
                        tabAt.setTag(frsTabItemData);
                    }
                    if (i5 == i2) {
                        tabAt.select();
                    }
                    i4++;
                    r3 = 0;
                }
            }
            i4++;
            r3 = 0;
        }
        int g5 = l.g(getContext(), R.dimen.M_W_X004);
        linearLayout.setPadding(g5, 0, g5, 0);
    }

    public void setActivity(BaseActivity baseActivity) {
        this.k = baseActivity;
    }

    public void setBgColor(int i2) {
        if (i2 != 0) {
            this.f21918i = i2;
        }
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
            setVisibility(0);
            l(frsTabInfoData.tabList, this.f21917h, frsTabInfoData.selectedTabId);
            return;
        }
        setVisibility(8);
    }

    public ForumTabSelectedView(Context context) {
        super(context);
        this.f21918i = R.color.CAM_X0202;
        this.j = new a();
        this.l = new b();
        i();
    }
}
