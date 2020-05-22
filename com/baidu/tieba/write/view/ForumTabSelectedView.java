package com.baidu.tieba.write.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.j;
import java.util.List;
/* loaded from: classes2.dex */
public class ForumTabSelectedView extends LinearLayout {
    private TabLayout hEP;
    private FrsTabItemData lVZ;
    private TabLayout.OnTabSelectedListener lWa;
    private View.OnClickListener lWb;
    private BaseActivity mActivity;
    private ImageView mIconView;
    private TextView mTitleView;

    public ForumTabSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lWa = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.1
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.lVZ = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                    Log.e("TabSelected", "onTabSelected-->tabName=" + frsTabItemData.name + ",isSelected=true");
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = false;
                    ForumTabSelectedView.this.setTabColorUnSelected(tab);
                    Log.e("TabSelected", "onTabUnselected-->tabName=" + frsTabItemData.name + ",isSelected=false");
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    if (frsTabItemData.isSelected) {
                        frsTabItemData.isSelected = false;
                        ForumTabSelectedView.this.lVZ = null;
                        ForumTabSelectedView.this.setTabColorUnSelected(tab);
                    } else {
                        frsTabItemData.isSelected = true;
                        ForumTabSelectedView.this.lVZ = frsTabItemData;
                        ForumTabSelectedView.this.setTabColorSelected(tab);
                    }
                    Log.e("TabSelected", "onTabReselected-->tabName=" + frsTabItemData.name + ",isSelected=" + frsTabItemData.isSelected);
                }
            }
        };
        this.lWb = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumTabSelectedView.this.mActivity != null) {
                    l.hideSoftKeyPad(ForumTabSelectedView.this.getContext(), ForumTabSelectedView.this);
                    j.a(ForumTabSelectedView.this.mActivity, ForumTabSelectedView.this.mActivity.getPageContext());
                }
            }
        };
        initUI();
    }

    public ForumTabSelectedView(Context context) {
        super(context);
        this.lWa = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.1
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.lVZ = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                    Log.e("TabSelected", "onTabSelected-->tabName=" + frsTabItemData.name + ",isSelected=true");
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = false;
                    ForumTabSelectedView.this.setTabColorUnSelected(tab);
                    Log.e("TabSelected", "onTabUnselected-->tabName=" + frsTabItemData.name + ",isSelected=false");
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    if (frsTabItemData.isSelected) {
                        frsTabItemData.isSelected = false;
                        ForumTabSelectedView.this.lVZ = null;
                        ForumTabSelectedView.this.setTabColorUnSelected(tab);
                    } else {
                        frsTabItemData.isSelected = true;
                        ForumTabSelectedView.this.lVZ = frsTabItemData;
                        ForumTabSelectedView.this.setTabColorSelected(tab);
                    }
                    Log.e("TabSelected", "onTabReselected-->tabName=" + frsTabItemData.name + ",isSelected=" + frsTabItemData.isSelected);
                }
            }
        };
        this.lWb = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumTabSelectedView.this.mActivity != null) {
                    l.hideSoftKeyPad(ForumTabSelectedView.this.getContext(), ForumTabSelectedView.this);
                    j.a(ForumTabSelectedView.this.mActivity, ForumTabSelectedView.this.mActivity.getPageContext());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(0);
        setGravity(16);
        dnK();
        dnL();
        bZO();
    }

    private void dnK() {
        this.mTitleView = new TextView(getContext());
        this.mTitleView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mTitleView.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds36));
        this.mTitleView.setText(R.string.forum_tab_select_title);
        addView(this.mTitleView);
    }

    private void dnL() {
        this.mIconView = new ImageView(getContext());
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.setMargins(l.getDimens(getContext(), R.dimen.tbds16), 0, 0, 0);
        this.mIconView.setLayoutParams(layoutParams);
        this.mIconView.setOnClickListener(this.lWb);
        addView(this.mIconView);
    }

    private void bZO() {
        this.hEP = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.forum_tab_select_layout, (ViewGroup) null);
        this.hEP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.hEP);
        this.hEP.setOnTabSelectedListener(this.lWa);
    }

    public FrsTabItemData getSelectedTabItemData() {
        if (this.lVZ == null || !this.lVZ.isSelected) {
            return null;
        }
        return this.lVZ;
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        if (frsTabInfoData == null || v.isEmpty(frsTabInfoData.tabList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(frsTabInfoData.tabList, this.hEP, frsTabInfoData.selectedTabId);
    }

    private void a(List<FrsTabItemData> list, TabLayout tabLayout, int i) {
        int min = Math.min(list.size(), 5);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i2 = 0; i2 < tabCount; i2++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds12);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds25);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds32);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds14);
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    View childAt = linearLayout.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setPadding(0, 0, 0, 0);
                    }
                }
                TabLayout.Tab tab = tabAt;
                FrsTabItemData frsTabItemData = list.get(i3);
                if (frsTabItemData != null) {
                    String str = frsTabItemData.name;
                    int i4 = frsTabItemData.tabId;
                    if (!TextUtils.isEmpty(str) && i4 >= 0) {
                        TBSpecificationBtn tBSpecificationBtn = null;
                        if (!(tab.getCustomView() instanceof TBSpecificationBtn)) {
                            tBSpecificationBtn = new TBSpecificationBtn(getContext());
                            c cVar = new c();
                            cVar.mg(dimens3);
                            cVar.mh(dimens4);
                            cVar.mk(R.color.cp_cont_j);
                            tBSpecificationBtn.setConfig(cVar);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(dimens, dimens2, dimens, dimens2);
                            tBSpecificationBtn.setLayoutParams(layoutParams);
                            tab.setCustomView(tBSpecificationBtn);
                        }
                        if (tBSpecificationBtn != null) {
                            tBSpecificationBtn.setText(str);
                        }
                        if (tab != null) {
                            tab.setTag(frsTabItemData);
                        }
                        if (i4 == i) {
                            tab.select();
                        }
                    }
                }
            }
            int dimens5 = l.getDimens(getContext(), R.dimen.tbds32);
            linearLayout.setPadding(dimens5, 0, dimens5, 0);
        }
    }

    private void b(TabLayout tabLayout) {
        am.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
        if (tabLayout != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        c cVar = (c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (tabAt.isSelected()) {
                            cVar.mi(R.color.cp_link_tip_a);
                        } else {
                            cVar.mk(R.color.cp_cont_j);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).mi(R.color.cp_link_tip_a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).mk(R.color.cp_cont_j);
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    public void onChangeSkinType(int i) {
        b(this.hEP);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_j);
        SvgManager.aUV().a(this.mIconView, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }
}
