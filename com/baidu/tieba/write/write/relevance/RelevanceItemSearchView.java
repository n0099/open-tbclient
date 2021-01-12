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
/* loaded from: classes7.dex */
public class RelevanceItemSearchView implements ViewPager.OnPageChangeListener, com.baidu.tbadk.suspended.a {
    private final LinearLayout fvH;
    private final NavigationBar ghr;
    private ImageView iKV;
    private final RelevanceItemSearchActivity ocO;
    private TbTabLayout ocP;
    private CustomViewPager ocQ;
    private FragmentAdapter ocR;
    private View ocS;
    private EditText ocT;
    private String[] ocN = {"游戏", "数码"};
    private List<a> ocU = new ArrayList();
    private CustomMessageListener obM = new CustomMessageListener(2921522) { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                RelevanceItemSearchView.this.ocO.hideLoadingView(RelevanceItemSearchView.this.fvH);
                if (!x.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                    if (!Arrays.equals(RelevanceItemSearchView.this.ocN, strArr)) {
                        RelevanceItemSearchView.this.ocN = strArr;
                        RelevanceItemSearchView.this.initData();
                    }
                }
            }
        }
    };

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fvH = linearLayout;
        this.ghr = navigationBar;
        this.ocO = relevanceItemSearchActivity;
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.obM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        String[] strArr;
        this.ocU.clear();
        this.ocP.removeAllTabs();
        for (String str : this.ocN) {
            this.ocP.a(this.ocP.qN());
            a aVar = new a();
            aVar.ocX = new RelevanceItemListFragment();
            aVar.ocX.setCategory(str);
            aVar.title = str;
            this.ocU.add(aVar);
        }
        this.ocR.setData(this.ocU);
    }

    private void initUI() {
        LayoutInflater.from(this.fvH.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.fvH, true);
        this.ocO.showLoadingView(this.fvH);
        dXr();
        bEt();
        cOO();
        initViewPager();
    }

    private void dXr() {
        this.ocS = this.fvH.findViewById(R.id.search_container);
        this.iKV = (ImageView) this.fvH.findViewById(R.id.search_icon);
        this.ocT = (EditText) this.fvH.findViewById(R.id.search_text);
        this.ocT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RelevanceItemSearchView.this.dXs();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXs() {
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.ocT.getText().toString()));
    }

    private void initViewPager() {
        this.ocQ = (CustomViewPager) this.fvH.findViewById(R.id.viewpager);
        this.ocQ.addOnPageChangeListener(this);
        this.ocQ.setViewPagerScroll(0);
        this.ocR = new FragmentAdapter(this.ocO.getSupportFragmentManager());
        this.ocQ.setAdapter(this.ocR);
        this.ocP.setupWithViewPager(this.ocQ);
    }

    private void cOO() {
        this.ocP = (TbTabLayout) this.fvH.findViewById(R.id.tablayout);
        this.ocP.setTabTextSize(l.getDimens(this.ocO, R.dimen.tbds46));
        this.ocP.setSelectedTabTextSize(l.getDimens(this.ocO, R.dimen.tbds52));
        this.ocP.setSelectedIndicatorBottomMargin(l.getDimens(this.ocO, R.dimen.tbds11));
    }

    private void bEt() {
        this.ghr.setCenterTextTitle(this.fvH.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghr.getLayoutParams();
        layoutParams.height = l.getDimens(this.fvH.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.getDimens(this.fvH.getContext(), R.dimen.tbds15);
    }

    public EditText dXt() {
        return this.ocT;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEp() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEq() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rs(int i) {
        SvgManager.bsx().a(this.iKV, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.ocT, R.color.CAM_X0109);
        ao.setBackgroundResource(this.ocS, R.drawable.enter_forum_search_bg);
        SvgManager.bsx().a(this.iKV, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        if (i == 2) {
            this.ocT.setHintTextColor(ao.getColor(R.color.s_navbar_title_color));
        } else {
            this.ocT.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
        ao.setNavbarTitleColor(this.ocT, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.ocP.setTabTextColors(ao.getColor(R.color.CAM_X0108), ao.getColor(R.color.CAM_X0105));
        this.ocP.setSelectedTabTextBlod(true);
        this.ocP.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0302));
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEr() {
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
        MessageManager.getInstance().unRegisterListener(this.obM);
    }

    /* loaded from: classes7.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<a> gvo;
        private Long ocW;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gvo = new ArrayList();
        }

        public void setData(List<a> list) {
            this.ocW = Long.valueOf(System.currentTimeMillis());
            this.gvo.clear();
            if (!x.isEmpty(list)) {
                this.gvo.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gvo.get(i);
            if (aVar != null) {
                return aVar.ocX;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gvo.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gvo.get(i);
            return aVar != null ? aVar.title : "";
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return super.getItemId(i) + this.ocW.longValue();
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public RelevanceItemListFragment ocX;
        public String title;

        public a() {
        }
    }
}
