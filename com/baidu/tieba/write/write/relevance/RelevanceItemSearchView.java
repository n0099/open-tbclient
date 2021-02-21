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
    private final NavigationBar gjT;
    private ImageView iQR;
    private final RelevanceItemSearchActivity oni;
    private TbTabLayout onj;
    private CustomViewPager onk;
    private FragmentAdapter onl;
    private View onm;
    private EditText onn;
    private String[] onh = {"游戏", "数码"};
    private List<a> ono = new ArrayList();
    private CustomMessageListener omg = new CustomMessageListener(2921522) { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                RelevanceItemSearchView.this.oni.hideLoadingView(RelevanceItemSearchView.this.fxX);
                if (!y.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                    if (!Arrays.equals(RelevanceItemSearchView.this.onh, strArr)) {
                        RelevanceItemSearchView.this.onh = strArr;
                        RelevanceItemSearchView.this.initData();
                    }
                }
            }
        }
    };

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fxX = linearLayout;
        this.gjT = navigationBar;
        this.oni = relevanceItemSearchActivity;
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.omg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        String[] strArr;
        this.ono.clear();
        this.onj.removeAllTabs();
        for (String str : this.onh) {
            this.onj.a(this.onj.qL());
            a aVar = new a();
            aVar.onr = new RelevanceItemListFragment();
            aVar.onr.setCategory(str);
            aVar.title = str;
            this.ono.add(aVar);
        }
        this.onl.setData(this.ono);
    }

    private void initUI() {
        LayoutInflater.from(this.fxX.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.fxX, true);
        this.oni.showLoadingView(this.fxX);
        dZK();
        bEL();
        cQS();
        initViewPager();
    }

    private void dZK() {
        this.onm = this.fxX.findViewById(R.id.search_container);
        this.iQR = (ImageView) this.fxX.findViewById(R.id.search_icon);
        this.onn = (EditText) this.fxX.findViewById(R.id.search_text);
        this.onn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RelevanceItemSearchView.this.dZL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZL() {
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.onn.getText().toString()));
    }

    private void initViewPager() {
        this.onk = (CustomViewPager) this.fxX.findViewById(R.id.viewpager);
        this.onk.addOnPageChangeListener(this);
        this.onk.setViewPagerScroll(0);
        this.onl = new FragmentAdapter(this.oni.getSupportFragmentManager());
        this.onk.setAdapter(this.onl);
        this.onj.setupWithViewPager(this.onk);
    }

    private void cQS() {
        this.onj = (TbTabLayout) this.fxX.findViewById(R.id.tablayout);
        this.onj.setTabTextSize(l.getDimens(this.oni, R.dimen.tbds46));
        this.onj.setSelectedTabTextSize(l.getDimens(this.oni, R.dimen.tbds52));
        this.onj.setSelectedIndicatorBottomMargin(l.getDimens(this.oni, R.dimen.tbds11));
    }

    private void bEL() {
        this.gjT.setCenterTextTitle(this.fxX.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjT.getLayoutParams();
        layoutParams.height = l.getDimens(this.fxX.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.getDimens(this.fxX.getContext(), R.dimen.tbds15);
    }

    public EditText dZM() {
        return this.onn;
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
        SvgManager.bsR().a(this.iQR, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.onn, R.color.CAM_X0109);
        ap.setBackgroundResource(this.onm, R.drawable.enter_forum_search_bg);
        SvgManager.bsR().a(this.iQR, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        if (i == 2) {
            this.onn.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.onn.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        ap.setNavbarTitleColor(this.onn, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.onj.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.onj.setSelectedTabTextBlod(true);
        this.onj.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
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
        MessageManager.getInstance().unRegisterListener(this.omg);
    }

    /* loaded from: classes8.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<a> gym;
        private Long onq;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gym = new ArrayList();
        }

        public void setData(List<a> list) {
            this.onq = Long.valueOf(System.currentTimeMillis());
            this.gym.clear();
            if (!y.isEmpty(list)) {
                this.gym.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gym.get(i);
            if (aVar != null) {
                return aVar.onr;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gym.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gym.get(i);
            return aVar != null ? aVar.title : "";
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return super.getItemId(i) + this.onq.longValue();
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        public RelevanceItemListFragment onr;
        public String title;

        public a() {
        }
    }
}
