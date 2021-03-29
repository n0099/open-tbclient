package com.baidu.tieba.write.write.relevance;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSearchMessage;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.list.RelevanceItemListFragment;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class RelevanceItemSearchView implements d.b.h0.t0.a, ViewPager.OnPageChangeListener {

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22571f;

    /* renamed from: g  reason: collision with root package name */
    public final NavigationBar f22572g;

    /* renamed from: h  reason: collision with root package name */
    public final RelevanceItemSearchActivity f22573h;
    public TbTabLayout i;
    public CustomViewPager j;
    public FragmentAdapter k;
    public View l;
    public EditText m;
    public ImageView n;

    /* renamed from: e  reason: collision with root package name */
    public String[] f22570e = {"游戏", "数码"};
    public List<c> o = new ArrayList();
    public CustomMessageListener p = new a(2921522);

    /* loaded from: classes5.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f22574a;

        /* renamed from: b  reason: collision with root package name */
        public Long f22575b;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f22574a = new ArrayList();
        }

        public void c(List<c> list) {
            this.f22575b = Long.valueOf(System.currentTimeMillis());
            this.f22574a.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f22574a.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f22574a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            c cVar = this.f22574a.get(i);
            if (cVar != null) {
                return cVar.f22578a;
            }
            return null;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return super.getItemId(i) + this.f22575b.longValue();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            c cVar = this.f22574a.get(i);
            return cVar != null ? cVar.f22579b : "";
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                return;
            }
            EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
            RelevanceItemSearchView.this.f22573h.hideLoadingView(RelevanceItemSearchView.this.f22571f);
            if (ListUtils.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                return;
            }
            String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
            if (Arrays.equals(RelevanceItemSearchView.this.f22570e, strArr)) {
                return;
            }
            RelevanceItemSearchView.this.f22570e = strArr;
            RelevanceItemSearchView.this.i();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            RelevanceItemSearchView.this.g();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelevanceItemListFragment f22578a;

        /* renamed from: b  reason: collision with root package name */
        public String f22579b;

        public c(RelevanceItemSearchView relevanceItemSearchView) {
        }
    }

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f22571f = linearLayout;
        this.f22572g = navigationBar;
        this.f22573h = relevanceItemSearchActivity;
        n();
        j();
        i();
    }

    public final void g() {
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.m.getText().toString()));
    }

    @Override // d.b.h0.t0.a
    public Intent getResultIntent() {
        return null;
    }

    public EditText h() {
        return this.m;
    }

    public final void i() {
        String[] strArr;
        this.o.clear();
        this.i.B();
        for (String str : this.f22570e) {
            this.i.d(this.i.z());
            c cVar = new c(this);
            RelevanceItemListFragment relevanceItemListFragment = new RelevanceItemListFragment();
            cVar.f22578a = relevanceItemListFragment;
            relevanceItemListFragment.J0(str);
            cVar.f22579b = str;
            this.o.add(cVar);
        }
        this.k.c(this.o);
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewTop() {
        return false;
    }

    public final void j() {
        MessageManager.getInstance().registerListener(this.p);
    }

    public final void k() {
        this.f22572g.setCenterTextTitle(this.f22571f.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22572g.getLayoutParams();
        layoutParams.height = l.g(this.f22571f.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.g(this.f22571f.getContext(), R.dimen.tbds15);
    }

    public final void l() {
        this.l = this.f22571f.findViewById(R.id.search_container);
        this.n = (ImageView) this.f22571f.findViewById(R.id.search_icon);
        EditText editText = (EditText) this.f22571f.findViewById(R.id.search_text);
        this.m = editText;
        editText.addTextChangedListener(new b());
    }

    public final void m() {
        TbTabLayout tbTabLayout = (TbTabLayout) this.f22571f.findViewById(R.id.tablayout);
        this.i = tbTabLayout;
        tbTabLayout.setTabTextSize(l.g(this.f22573h, R.dimen.tbds46));
        this.i.setSelectedTabTextSize(l.g(this.f22573h, R.dimen.tbds52));
        this.i.setSelectedIndicatorBottomMargin(l.g(this.f22573h, R.dimen.tbds11));
    }

    public final void n() {
        LayoutInflater.from(this.f22571f.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.f22571f, true);
        this.f22573h.showLoadingView(this.f22571f);
        l();
        k();
        m();
        o();
    }

    public final void o() {
        CustomViewPager customViewPager = (CustomViewPager) this.f22571f.findViewById(R.id.viewpager);
        this.j = customViewPager;
        customViewPager.addOnPageChangeListener(this);
        this.j.setViewPagerScroll(0);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f22573h.getSupportFragmentManager());
        this.k = fragmentAdapter;
        this.j.setAdapter(fragmentAdapter);
        this.i.setupWithViewPager(this.j);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // d.b.h0.t0.a
    public void onViewChangeSkinType(int i) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.l, R.drawable.enter_forum_search_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        if (i == 2) {
            this.m.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.m, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
        this.i.setSelectedTabTextBlod(true);
        this.i.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
    }

    public void p() {
        MessageManager.getInstance().unRegisterListener(this.p);
    }
}
