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
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class RelevanceItemSearchView implements d.a.n0.t0.a, ViewPager.OnPageChangeListener {

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22311f;

    /* renamed from: g  reason: collision with root package name */
    public final NavigationBar f22312g;

    /* renamed from: h  reason: collision with root package name */
    public final RelevanceItemSearchActivity f22313h;

    /* renamed from: i  reason: collision with root package name */
    public TbTabLayout f22314i;
    public CustomViewPager j;
    public FragmentAdapter k;
    public View l;
    public EditText m;
    public ImageView n;

    /* renamed from: e  reason: collision with root package name */
    public String[] f22310e = {"游戏", "数码"};
    public List<c> o = new ArrayList();
    public CustomMessageListener p = new a(2921522);

    /* loaded from: classes5.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f22315a;

        /* renamed from: b  reason: collision with root package name */
        public Long f22316b;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f22315a = new ArrayList();
        }

        public void c(List<c> list) {
            this.f22316b = Long.valueOf(System.currentTimeMillis());
            this.f22315a.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f22315a.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f22315a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            c cVar = this.f22315a.get(i2);
            if (cVar != null) {
                return cVar.f22319a;
            }
            return null;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i2) {
            return super.getItemId(i2) + this.f22316b.longValue();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            c cVar = this.f22315a.get(i2);
            return cVar != null ? cVar.f22320b : "";
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                return;
            }
            EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
            RelevanceItemSearchView.this.f22313h.hideLoadingView(RelevanceItemSearchView.this.f22311f);
            if (ListUtils.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                return;
            }
            String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
            if (Arrays.equals(RelevanceItemSearchView.this.f22310e, strArr)) {
                return;
            }
            RelevanceItemSearchView.this.f22310e = strArr;
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
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelevanceItemListFragment f22319a;

        /* renamed from: b  reason: collision with root package name */
        public String f22320b;

        public c(RelevanceItemSearchView relevanceItemSearchView) {
        }
    }

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f22311f = linearLayout;
        this.f22312g = navigationBar;
        this.f22313h = relevanceItemSearchActivity;
        n();
        j();
        i();
    }

    public final void g() {
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.m.getText().toString()));
    }

    @Override // d.a.n0.t0.a
    public Intent getResultIntent() {
        return null;
    }

    public EditText h() {
        return this.m;
    }

    public final void i() {
        String[] strArr;
        this.o.clear();
        this.f22314i.B();
        for (String str : this.f22310e) {
            this.f22314i.d(this.f22314i.z());
            c cVar = new c(this);
            RelevanceItemListFragment relevanceItemListFragment = new RelevanceItemListFragment();
            cVar.f22319a = relevanceItemListFragment;
            relevanceItemListFragment.L0(str);
            cVar.f22320b = str;
            this.o.add(cVar);
        }
        this.k.c(this.o);
    }

    @Override // d.a.n0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.a.n0.t0.a
    public boolean isOnViewTop() {
        return false;
    }

    public final void j() {
        MessageManager.getInstance().registerListener(this.p);
    }

    public final void k() {
        this.f22312g.setCenterTextTitle(this.f22311f.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22312g.getLayoutParams();
        layoutParams.height = l.g(this.f22311f.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.g(this.f22311f.getContext(), R.dimen.tbds15);
    }

    public final void l() {
        this.l = this.f22311f.findViewById(R.id.search_container);
        this.n = (ImageView) this.f22311f.findViewById(R.id.search_icon);
        EditText editText = (EditText) this.f22311f.findViewById(R.id.search_text);
        this.m = editText;
        editText.addTextChangedListener(new b());
    }

    public final void m() {
        TbTabLayout tbTabLayout = (TbTabLayout) this.f22311f.findViewById(R.id.tablayout);
        this.f22314i = tbTabLayout;
        tbTabLayout.setTabTextSize(l.g(this.f22313h, R.dimen.tbds46));
        this.f22314i.setSelectedTabTextSize(l.g(this.f22313h, R.dimen.tbds52));
        this.f22314i.setSelectedIndicatorBottomMargin(l.g(this.f22313h, R.dimen.tbds11));
    }

    public final void n() {
        LayoutInflater.from(this.f22311f.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.f22311f, true);
        this.f22313h.showLoadingView(this.f22311f);
        l();
        k();
        m();
        o();
    }

    public final void o() {
        CustomViewPager customViewPager = (CustomViewPager) this.f22311f.findViewById(R.id.viewpager);
        this.j = customViewPager;
        customViewPager.addOnPageChangeListener(this);
        this.j.setViewPagerScroll(0);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f22313h.getSupportFragmentManager());
        this.k = fragmentAdapter;
        this.j.setAdapter(fragmentAdapter);
        this.f22314i.setupWithViewPager(this.j);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
    }

    @Override // d.a.n0.t0.a
    public void onViewChangeSkinType(int i2) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.l, R.drawable.enter_forum_search_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        if (i2 == 2) {
            this.m.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.m, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f22314i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
        this.f22314i.setSelectedTabTextBlod(true);
        this.f22314i.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
    }

    public void p() {
        MessageManager.getInstance().unRegisterListener(this.p);
    }
}
