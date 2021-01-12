package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.m;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
/* loaded from: classes7.dex */
public class ForumTabSelectedView extends LinearLayout {
    private TabLayout.OnTabSelectedListener jYx;
    private TabLayout jxP;
    private BaseActivity mActivity;
    private int mBgColor;
    private ImageView mIconView;
    private TextView mTitleView;
    private FrsTabItemData nXw;
    private View.OnClickListener nXx;

    public ForumTabSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBgColor = R.color.CAM_X0202;
        this.jYx = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nXw = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    ((FrsTabItemData) tab.getTag()).isSelected = false;
                    ForumTabSelectedView.this.setTabColorUnSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    if (frsTabItemData.isSelected) {
                        frsTabItemData.isSelected = false;
                        ForumTabSelectedView.this.nXw = null;
                        ForumTabSelectedView.this.setTabColorUnSelected(tab);
                        return;
                    }
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nXw = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }
        };
        this.nXx = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumTabSelectedView.this.mActivity != null) {
                    l.hideSoftKeyPad(ForumTabSelectedView.this.getContext(), ForumTabSelectedView.this);
                    m.a(ForumTabSelectedView.this.mActivity, ForumTabSelectedView.this.mActivity.getPageContext());
                }
            }
        };
        initUI();
    }

    public ForumTabSelectedView(Context context) {
        super(context);
        this.mBgColor = R.color.CAM_X0202;
        this.jYx = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nXw = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    ((FrsTabItemData) tab.getTag()).isSelected = false;
                    ForumTabSelectedView.this.setTabColorUnSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    if (frsTabItemData.isSelected) {
                        frsTabItemData.isSelected = false;
                        ForumTabSelectedView.this.nXw = null;
                        ForumTabSelectedView.this.setTabColorUnSelected(tab);
                        return;
                    }
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nXw = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }
        };
        this.nXx = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumTabSelectedView.this.mActivity != null) {
                    l.hideSoftKeyPad(ForumTabSelectedView.this.getContext(), ForumTabSelectedView.this);
                    m.a(ForumTabSelectedView.this.mActivity, ForumTabSelectedView.this.mActivity.getPageContext());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(0);
        setGravity(16);
        dVh();
        dVi();
        cHL();
    }

    private void dVh() {
        this.mTitleView = new EMTextView(getContext());
        this.mTitleView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        c.bv(this.mTitleView).nW(R.dimen.T_X08);
        this.mTitleView.setText(R.string.forum_tab_select_title);
        this.mTitleView.setOnClickListener(this.nXx);
        addView(this.mTitleView);
    }

    private void dVi() {
        this.mIconView = new ImageView(getContext());
        int dimens = l.getDimens(getContext(), R.dimen.tbds31);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.setMargins(l.getDimens(getContext(), R.dimen.M_W_X002), 0, 0, 0);
        this.mIconView.setLayoutParams(layoutParams);
        this.mIconView.setOnClickListener(this.nXx);
        addView(this.mIconView);
    }

    private void cHL() {
        this.jxP = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.forum_tab_select_layout, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(l.getDimens(getContext(), R.dimen.M_W_X002), 0, 0, 0);
        this.jxP.setLayoutParams(layoutParams);
        addView(this.jxP);
        this.jxP.setOnTabSelectedListener(this.jYx);
    }

    public FrsTabItemData getSelectedTabItemData() {
        if (this.nXw == null || !this.nXw.isSelected) {
            return null;
        }
        return this.nXw;
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        if (frsTabInfoData == null || x.isEmpty(frsTabInfoData.tabList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(frsTabInfoData.tabList, this.jxP, frsTabInfoData.selectedTabId);
    }

    private void a(List<FrsTabItemData> list, TabLayout tabLayout, int i) {
        tabLayout.removeAllTabs();
        tabLayout.setTabRippleColorResource(R.color.transparent);
        int min = Math.min(list.size(), 10);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i2 = 0; i2 < tabCount; i2++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout != null) {
            int dimens = l.getDimens(getContext(), R.dimen.M_W_X002);
            l.getDimens(getContext(), R.dimen.tbds25);
            int dimens2 = l.getDimens(getContext(), R.dimen.M_W_X006);
            int dimens3 = l.getDimens(getContext(), R.dimen.M_H_X003);
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
                            b bVar = new b();
                            bVar.pJ(dimens2);
                            bVar.pK(dimens3);
                            if (frsTabItemData.tabId == 505) {
                                bVar.pO(R.color.CAM_X0302);
                            } else {
                                bVar.pO(R.color.CAM_X0107);
                            }
                            tBSpecificationBtn.setConfig(bVar);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(dimens, 0, dimens, 0);
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
            int dimens4 = l.getDimens(getContext(), R.dimen.M_W_X004);
            linearLayout.setPadding(dimens4, 0, dimens4, 0);
        }
    }

    private void b(TabLayout tabLayout) {
        ao.setBackgroundColor(tabLayout, this.mBgColor);
        if (tabLayout != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tabAt.getCustomView();
                        tBSpecificationBtn.btV();
                        b bVar = (b) tBSpecificationBtn.getStyleConfig();
                        if (tabAt.isSelected()) {
                            bVar.pM(R.color.CAM_X0302);
                        } else if (a(tabAt)) {
                            bVar.pO(R.color.CAM_X0302);
                        } else {
                            bVar.pO(R.color.CAM_X0107);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private boolean a(TabLayout.Tab tab) {
        if (tab == null || !(tab.getTag() instanceof FrsTabItemData)) {
            return false;
        }
        return ((FrsTabItemData) tab.getTag()).tabId == 505;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pM(R.color.CAM_X0302);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            b bVar = (b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (!a(tab)) {
                bVar.pO(R.color.CAM_X0107);
            }
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    public void onChangeSkinType(int i) {
        b(this.jxP);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0107);
        this.mIconView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_post_section12, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
    }

    public void setBgColor(int i) {
        if (i != 0) {
            this.mBgColor = i;
        }
    }
}
