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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSearchMessage;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.list.RelevanceItemListFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class RelevanceItemSearchView implements ViewPager.OnPageChangeListener, com.baidu.tbadk.suspended.a {
    private final LinearLayout fAp;
    private final NavigationBar glZ;
    private ImageView iPC;
    private EditText ohA;
    private final RelevanceItemSearchActivity ohv;
    private TbTabLayout ohw;
    private CustomViewPager ohx;
    private FragmentAdapter ohy;
    private View ohz;
    private String[] ohu = {"游戏", "数码"};
    private List<a> ohB = new ArrayList();
    private CustomMessageListener ogu = new CustomMessageListener(2921522) { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                RelevanceItemSearchView.this.ohv.hideLoadingView(RelevanceItemSearchView.this.fAp);
                if (!x.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                    if (!Arrays.equals(RelevanceItemSearchView.this.ohu, strArr)) {
                        RelevanceItemSearchView.this.ohu = strArr;
                        RelevanceItemSearchView.this.initData();
                    }
                }
            }
        }
    };

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fAp = linearLayout;
        this.glZ = navigationBar;
        this.ohv = relevanceItemSearchActivity;
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.ogu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        String[] strArr;
        this.ohB.clear();
        this.ohw.removeAllTabs();
        for (String str : this.ohu) {
            this.ohw.a(this.ohw.qN());
            a aVar = new a();
            aVar.ohE = new RelevanceItemListFragment();
            aVar.ohE.setCategory(str);
            aVar.title = str;
            this.ohB.add(aVar);
        }
        this.ohy.setData(this.ohB);
    }

    private void initUI() {
        LayoutInflater.from(this.fAp.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.fAp, true);
        this.ohv.showLoadingView(this.fAp);
        ebi();
        bIk();
        cSF();
        initViewPager();
    }

    private void ebi() {
        this.ohz = this.fAp.findViewById(R.id.search_container);
        this.iPC = (ImageView) this.fAp.findViewById(R.id.search_icon);
        this.ohA = (EditText) this.fAp.findViewById(R.id.search_text);
        this.ohA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RelevanceItemSearchView.this.ebj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebj() {
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.ohA.getText().toString()));
    }

    private void initViewPager() {
        this.ohx = (CustomViewPager) this.fAp.findViewById(R.id.viewpager);
        this.ohx.addOnPageChangeListener(this);
        this.ohx.setViewPagerScroll(0);
        this.ohy = new FragmentAdapter(this.ohv.getSupportFragmentManager());
        this.ohx.setAdapter(this.ohy);
        this.ohw.setupWithViewPager(this.ohx);
    }

    private void cSF() {
        this.ohw = (TbTabLayout) this.fAp.findViewById(R.id.tablayout);
        this.ohw.setTabTextSize(l.getDimens(this.ohv, R.dimen.tbds46));
        this.ohw.setSelectedTabTextSize(l.getDimens(this.ohv, R.dimen.tbds52));
        this.ohw.setSelectedIndicatorBottomMargin(l.getDimens(this.ohv, R.dimen.tbds11));
    }

    private void bIk() {
        this.glZ.setCenterTextTitle(this.fAp.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.glZ.getLayoutParams();
        layoutParams.height = l.getDimens(this.fAp.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.getDimens(this.fAp.getContext(), R.dimen.tbds15);
    }

    public EditText ebk() {
        return this.ohA;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIg() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIh() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sY(int i) {
        SvgManager.bwq().a(this.iPC, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.ohA, R.color.CAM_X0109);
        ao.setBackgroundResource(this.ohz, R.drawable.enter_forum_search_bg);
        SvgManager.bwq().a(this.iPC, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        if (i == 2) {
            this.ohA.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
        } else {
            this.ohA.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
        ao.setNavbarTitleColor(this.ohA, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.ohw.setTabTextColors(ao.getColor(R.color.CAM_X0108), ao.getColor(R.color.CAM_X0105));
        this.ohw.setSelectedTabTextBlod(true);
        this.ohw.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0302));
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bIi() {
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ogu);
    }

    /* loaded from: classes8.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<a> gzV;
        private Long ohD;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gzV = new ArrayList();
        }

        public void setData(List<a> list) {
            this.ohD = Long.valueOf(System.currentTimeMillis());
            this.gzV.clear();
            if (!x.isEmpty(list)) {
                this.gzV.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gzV.get(i);
            if (aVar != null) {
                return aVar.ohE;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gzV.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gzV.get(i);
            return aVar != null ? aVar.title : "";
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return super.getItemId(i) + this.ohD.longValue();
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        public RelevanceItemListFragment ohE;
        public String title;

        public a() {
        }
    }
}
