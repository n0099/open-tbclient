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
    private static String[] ofQ = {"游戏", "数码"};
    private final LinearLayout fqI;
    private final NavigationBar gcI;
    private ImageView iDq;
    private final RelevanceItemSearchActivity ofR;
    private TbTabLayout ofS;
    private CustomViewPager ofT;
    private FragmentAdapter ofU;
    private View ofV;
    private EditText ofW;
    private List<a> ofX = new ArrayList();
    private CustomMessageListener oeh = new CustomMessageListener(2921522) { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                RelevanceItemSearchView.this.ofR.hideLoadingView(RelevanceItemSearchView.this.fqI);
                if (!y.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    String[] unused = RelevanceItemSearchView.ofQ = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                    RelevanceItemSearchView.this.initData();
                }
            }
        }
    };

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fqI = linearLayout;
        this.gcI = navigationBar;
        this.ofR = relevanceItemSearchActivity;
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.oeh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        String[] strArr;
        this.ofX.clear();
        for (String str : ofQ) {
            this.ofS.a(this.ofS.rl());
            a aVar = new a();
            aVar.ofZ = new RelevanceItemListFragment();
            aVar.ofZ.setCategory(str);
            aVar.title = str;
            this.ofX.add(aVar);
        }
        this.ofU.setData(this.ofX);
    }

    private void initUI() {
        LayoutInflater.from(this.fqI.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.fqI, true);
        this.ofR.showLoadingView(this.fqI);
        ecn();
        bFP();
        cPz();
        initViewPager();
    }

    private void ecn() {
        this.ofV = this.fqI.findViewById(R.id.search_container);
        this.iDq = (ImageView) this.fqI.findViewById(R.id.search_icon);
        this.ofW = (EditText) this.fqI.findViewById(R.id.search_text);
        this.ofW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RelevanceItemSearchView.this.eco();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eco() {
        for (a aVar : this.ofX) {
            aVar.ofZ.g(this.ofW.getText());
        }
    }

    private void initViewPager() {
        this.ofT = (CustomViewPager) this.fqI.findViewById(R.id.viewpager);
        this.ofT.addOnPageChangeListener(this);
        this.ofT.setViewPagerScroll(0);
        this.ofU = new FragmentAdapter(this.ofR.getSupportFragmentManager());
        this.ofT.setAdapter(this.ofU);
        this.ofS.setupWithViewPager(this.ofT);
    }

    private void cPz() {
        this.ofS = (TbTabLayout) this.fqI.findViewById(R.id.tablayout);
        this.ofS.setTabTextSize(l.getDimens(this.ofR, R.dimen.tbds46));
        this.ofS.setSelectedTabTextSize(l.getDimens(this.ofR, R.dimen.tbds52));
        this.ofS.setSelectedIndicatorBottomMargin(l.getDimens(this.ofR, R.dimen.tbds11));
    }

    private void bFP() {
        this.gcI.setCenterTextTitle(this.fqI.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gcI.getLayoutParams();
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
        SvgManager.btW().a(this.iDq, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.ofW, R.color.CAM_X0109);
        ap.setBackgroundResource(this.ofV, R.drawable.enter_forum_search_bg);
        SvgManager.btW().a(this.iDq, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        if (i == 2) {
            this.ofW.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.ofW.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        ap.setNavbarTitleColor(this.ofW, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.ofS.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.ofS.setSelectedTabTextBlod(true);
        this.ofS.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
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
        MessageManager.getInstance().unRegisterListener(this.oeh);
    }

    /* loaded from: classes3.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gpy;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gpy = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gpy.clear();
            if (!y.isEmpty(list)) {
                this.gpy.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gpy.get(i);
            if (aVar != null) {
                return aVar.ofZ;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gpy.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gpy.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public RelevanceItemListFragment ofZ;
        public String title;

        public a() {
        }
    }
}
