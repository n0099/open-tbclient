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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.list.RelevanceItemListFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class RelevanceItemSearchView implements ViewPager.OnPageChangeListener, com.baidu.tbadk.suspended.a {
    private final LinearLayout fxX;
    private final NavigationBar gjF;
    private ImageView iQD;
    private final RelevanceItemSearchActivity omH;
    private TbTabLayout omI;
    private CustomViewPager omJ;
    private FragmentAdapter omK;
    private View omL;
    private EditText omM;
    private String[] omG = {"游戏", "数码"};
    private List<a> omN = new ArrayList();
    private CustomMessageListener olG = new CustomMessageListener(2921522) { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                RelevanceItemSearchView.this.omH.hideLoadingView(RelevanceItemSearchView.this.fxX);
                if (!y.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                    if (!Arrays.equals(RelevanceItemSearchView.this.omG, strArr)) {
                        RelevanceItemSearchView.this.omG = strArr;
                        RelevanceItemSearchView.this.initData();
                    }
                }
            }
        }
    };

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fxX = linearLayout;
        this.gjF = navigationBar;
        this.omH = relevanceItemSearchActivity;
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.olG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        String[] strArr;
        this.omN.clear();
        this.omI.removeAllTabs();
        for (String str : this.omG) {
            this.omI.a(this.omI.qL());
            a aVar = new a();
            aVar.omQ = new RelevanceItemListFragment();
            aVar.omQ.setCategory(str);
            aVar.title = str;
            this.omN.add(aVar);
        }
        this.omK.setData(this.omN);
    }

    private void initUI() {
        LayoutInflater.from(this.fxX.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.fxX, true);
        this.omH.showLoadingView(this.fxX);
        dZC();
        bEL();
        cQL();
        initViewPager();
    }

    private void dZC() {
        this.omL = this.fxX.findViewById(R.id.search_container);
        this.iQD = (ImageView) this.fxX.findViewById(R.id.search_icon);
        this.omM = (EditText) this.fxX.findViewById(R.id.search_text);
        this.omM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RelevanceItemSearchView.this.dZD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZD() {
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.omM.getText().toString()));
    }

    private void initViewPager() {
        this.omJ = (CustomViewPager) this.fxX.findViewById(R.id.viewpager);
        this.omJ.addOnPageChangeListener(this);
        this.omJ.setViewPagerScroll(0);
        this.omK = new FragmentAdapter(this.omH.getSupportFragmentManager());
        this.omJ.setAdapter(this.omK);
        this.omI.setupWithViewPager(this.omJ);
    }

    private void cQL() {
        this.omI = (TbTabLayout) this.fxX.findViewById(R.id.tablayout);
        this.omI.setTabTextSize(l.getDimens(this.omH, R.dimen.tbds46));
        this.omI.setSelectedTabTextSize(l.getDimens(this.omH, R.dimen.tbds52));
        this.omI.setSelectedIndicatorBottomMargin(l.getDimens(this.omH, R.dimen.tbds11));
    }

    private void bEL() {
        this.gjF.setCenterTextTitle(this.fxX.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjF.getLayoutParams();
        layoutParams.height = l.getDimens(this.fxX.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.getDimens(this.fxX.getContext(), R.dimen.tbds15);
    }

    public EditText dZE() {
        return this.omM;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEH() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEI() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rx(int i) {
        SvgManager.bsR().a(this.iQD, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.omM, R.color.CAM_X0109);
        ap.setBackgroundResource(this.omL, R.drawable.enter_forum_search_bg);
        SvgManager.bsR().a(this.iQD, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        if (i == 2) {
            this.omM.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.omM.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        ap.setNavbarTitleColor(this.omM, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.omI.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.omI.setSelectedTabTextBlod(true);
        this.omI.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
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
        MessageManager.getInstance().unRegisterListener(this.olG);
    }

    /* loaded from: classes8.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<a> gxY;
        private Long omP;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gxY = new ArrayList();
        }

        public void setData(List<a> list) {
            this.omP = Long.valueOf(System.currentTimeMillis());
            this.gxY.clear();
            if (!y.isEmpty(list)) {
                this.gxY.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gxY.get(i);
            if (aVar != null) {
                return aVar.omQ;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gxY.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gxY.get(i);
            return aVar != null ? aVar.title : "";
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return super.getItemId(i) + this.omP.longValue();
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        public RelevanceItemListFragment omQ;
        public String title;

        public a() {
        }
    }
}
