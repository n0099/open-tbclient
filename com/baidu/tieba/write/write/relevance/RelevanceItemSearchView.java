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
/* loaded from: classes7.dex */
public class RelevanceItemSearchView implements ViewPager.OnPageChangeListener, com.baidu.tbadk.suspended.a {
    private final LinearLayout fzw;
    private final NavigationBar glw;
    private ImageView iSA;
    private final RelevanceItemSearchActivity opn;
    private TbTabLayout opo;
    private CustomViewPager opp;
    private FragmentAdapter opq;
    private View opr;
    private EditText ops;
    private String[] opm = {"游戏", "数码"};
    private List<a> opu = new ArrayList();
    private CustomMessageListener oom = new CustomMessageListener(2921522) { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemUpdatedMessage)) {
                EvaluateRelevanceItemUpdatedMessage evaluateRelevanceItemUpdatedMessage = (EvaluateRelevanceItemUpdatedMessage) customResponsedMessage;
                RelevanceItemSearchView.this.opn.hideLoadingView(RelevanceItemSearchView.this.fzw);
                if (!y.isEmpty(evaluateRelevanceItemUpdatedMessage.tabs)) {
                    String[] strArr = (String[]) evaluateRelevanceItemUpdatedMessage.tabs.toArray(new String[0]);
                    if (!Arrays.equals(RelevanceItemSearchView.this.opm, strArr)) {
                        RelevanceItemSearchView.this.opm = strArr;
                        RelevanceItemSearchView.this.initData();
                    }
                }
            }
        }
    };

    public RelevanceItemSearchView(RelevanceItemSearchActivity relevanceItemSearchActivity, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.fzw = linearLayout;
        this.glw = navigationBar;
        this.opn = relevanceItemSearchActivity;
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.oom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        String[] strArr;
        this.opu.clear();
        this.opo.removeAllTabs();
        for (String str : this.opm) {
            this.opo.a(this.opo.qL());
            a aVar = new a();
            aVar.opx = new RelevanceItemListFragment();
            aVar.opx.setCategory(str);
            aVar.title = str;
            this.opu.add(aVar);
        }
        this.opq.setData(this.opu);
    }

    private void initUI() {
        LayoutInflater.from(this.fzw.getContext()).inflate(R.layout.relevance_item_search_view, (ViewGroup) this.fzw, true);
        this.opn.showLoadingView(this.fzw);
        dZS();
        bEP();
        cQZ();
        initViewPager();
    }

    private void dZS() {
        this.opr = this.fzw.findViewById(R.id.search_container);
        this.iSA = (ImageView) this.fzw.findViewById(R.id.search_icon);
        this.ops = (EditText) this.fzw.findViewById(R.id.search_text);
        this.ops.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.relevance.RelevanceItemSearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RelevanceItemSearchView.this.dZT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZT() {
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSearchMessage(this.ops.getText().toString()));
    }

    private void initViewPager() {
        this.opp = (CustomViewPager) this.fzw.findViewById(R.id.viewpager);
        this.opp.addOnPageChangeListener(this);
        this.opp.setViewPagerScroll(0);
        this.opq = new FragmentAdapter(this.opn.getSupportFragmentManager());
        this.opp.setAdapter(this.opq);
        this.opo.setupWithViewPager(this.opp);
    }

    private void cQZ() {
        this.opo = (TbTabLayout) this.fzw.findViewById(R.id.tablayout);
        this.opo.setTabTextSize(l.getDimens(this.opn, R.dimen.tbds46));
        this.opo.setSelectedTabTextSize(l.getDimens(this.opn, R.dimen.tbds52));
        this.opo.setSelectedIndicatorBottomMargin(l.getDimens(this.opn, R.dimen.tbds11));
    }

    private void bEP() {
        this.glw.setCenterTextTitle(this.fzw.getResources().getString(R.string.releavance_item_category));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.glw.getLayoutParams();
        layoutParams.height = l.getDimens(this.fzw.getContext(), R.dimen.tbds60);
        layoutParams.topMargin = l.getDimens(this.fzw.getContext(), R.dimen.tbds15);
    }

    public EditText dZU() {
        return this.ops;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEL() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rz(int i) {
        SvgManager.bsU().a(this.iSA, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.ops, R.color.CAM_X0109);
        ap.setBackgroundResource(this.opr, R.drawable.enter_forum_search_bg);
        SvgManager.bsU().a(this.iSA, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        if (i == 2) {
            this.ops.setHintTextColor(ap.getColor(R.color.s_navbar_title_color));
        } else {
            this.ops.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        }
        ap.setNavbarTitleColor(this.ops, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.opo.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.opo.setSelectedTabTextBlod(true);
        this.opo.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEN() {
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
        MessageManager.getInstance().unRegisterListener(this.oom);
    }

    /* loaded from: classes7.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<a> gzV;
        private Long opw;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gzV = new ArrayList();
        }

        public void setData(List<a> list) {
            this.opw = Long.valueOf(System.currentTimeMillis());
            this.gzV.clear();
            if (!y.isEmpty(list)) {
                this.gzV.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gzV.get(i);
            if (aVar != null) {
                return aVar.opx;
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
            return super.getItemId(i) + this.opw.longValue();
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public RelevanceItemListFragment opx;
        public String title;

        public a() {
        }
    }
}
