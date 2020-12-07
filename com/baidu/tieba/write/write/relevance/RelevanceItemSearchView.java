package com.baidu.tieba.write.write.relevance;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.list.RelevanceItemListFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class RelevanceItemSearchView implements ViewPager.OnPageChangeListener, com.baidu.tbadk.suspended.a {
    private static String[] ofO = {"游戏", "数码"};
    private final LinearLayout fqI;
    private final NavigationBar gcG;
    private ImageView iDo;
    private final RelevanceItemSearchActivity ofP;
    private TbTabLayout ofQ;
    private CustomViewPager ofR;
    private FragmentAdapter ofS;
    private View ofT;
    private EditText ofU;
    private List<a> ofV = new ArrayList();
    private CustomMessageListener oef = new CustomMessageListener(2921522) { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                RelevanceItemSearchView.this.ofP.hideLoadingView(RelevanceItemSearchView.this.fqI);
                if (!y.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    String[] unused = RelevanceItemSearchView.ofO = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                    RelevanceItemSearchView.this.initData();
                }
            }
        }
    };

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fqI = linearLayout;
        this.gcG = navigationBar;
        this.ofP = relevanceItemSearchActivity;
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.oef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        String[] strArr;
        this.ofV.clear();
        for (String str : ofO) {
            this.ofQ.a(this.ofQ.rl());
            a aVar = new a();
            aVar.ofX = new RelevanceItemListFragment();
            aVar.ofX.setCategory(str);
            aVar.title = str;
            this.ofV.add(aVar);
        }
        this.ofS.setData(this.ofV);
    }

    private void initUI() {
        LayoutInflater.from(this.fqI.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.fqI, true);
        this.ofP.showLoadingView(this.fqI);
        ecm();
        bFP();
        cPy();
        initViewPager();
    }

    private void ecm() {
        this.ofT = this.fqI.findViewById(R.id.search_container);
        this.iDo = (ImageView) this.fqI.findViewById(R.id.search_icon);
        this.ofU = (EditText) this.fqI.findViewById(R.id.search_text);
        this.ofU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RelevanceItemSearchView.this.ecn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecn() {
        for (a aVar : this.ofV) {
            aVar.ofX.g(this.ofU.getText());
        }
    }

    private void initViewPager() {
        this.ofR = (CustomViewPager) this.fqI.findViewById(R.id.viewpager);
        this.ofR.addOnPageChangeListener(this);
        this.ofR.setViewPagerScroll(0);
        this.ofS = new FragmentAdapter(this.ofP.getSupportFragmentManager());
        this.ofR.setAdapter(this.ofS);
        this.ofQ.setupWithViewPager(this.ofR);
    }

    private void cPy() {
        this.ofQ = (TbTabLayout) this.fqI.findViewById(R.id.tablayout);
        this.ofQ.setTabTextSize(l.getDimens(this.ofP, R.dimen.tbds46));
        this.ofQ.setSelectedTabTextSize(l.getDimens(this.ofP, R.dimen.tbds52));
        this.ofQ.setSelectedIndicatorBottomMargin(l.getDimens(this.ofP, R.dimen.tbds11));
    }

    private void bFP() {
        this.gcG.setCenterTextTitle(this.fqI.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gcG.getLayoutParams();
        layoutParams.height = l.getDimens(this.fqI.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.getDimens(this.fqI.getContext(), R.dimen.tbds15);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFL() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
        SvgManager.btW().a(this.iDo, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.ofU, R.color.CAM_X0109);
        ap.setBackgroundResource(this.ofT, R.drawable.enter_forum_search_bg);
        SvgManager.btW().a(this.iDo, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        if (i == 2) {
            this.ofU.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.ofU.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        ap.setNavbarTitleColor(this.ofU, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.ofQ.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.ofQ.setSelectedTabTextBlod(true);
        this.ofQ.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return null;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.oef);
    }

    /* loaded from: classes3.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gpw;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gpw = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gpw.clear();
            if (!y.isEmpty(list)) {
                this.gpw.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gpw.get(i);
            if (aVar != null) {
                return aVar.ofX;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gpw.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gpw.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public RelevanceItemListFragment ofX;
        public String title;

        public a() {
        }
    }
}
