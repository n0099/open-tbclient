package com.baidu.tieba.write.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.m;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumTabSelectedView extends LinearLayout {
    private TabLayout iVK;
    private TabLayout.OnTabSelectedListener jvq;
    private BaseActivity mActivity;
    private ImageView mIconView;
    private TextView mTitleView;
    private FrsTabItemData nEn;
    private View.OnClickListener nEo;

    public ForumTabSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvq = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.1
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nEn = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    ((FrsTabItemData) tab.getTag()).isSelected = false;
                    ForumTabSelectedView.this.setTabColorUnSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    if (frsTabItemData.isSelected) {
                        frsTabItemData.isSelected = false;
                        ForumTabSelectedView.this.nEn = null;
                        ForumTabSelectedView.this.setTabColorUnSelected(tab);
                        return;
                    }
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nEn = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }
        };
        this.nEo = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.2
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
        this.jvq = new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.1
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nEn = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    ((FrsTabItemData) tab.getTag()).isSelected = false;
                    ForumTabSelectedView.this.setTabColorUnSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                    FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                    if (frsTabItemData.isSelected) {
                        frsTabItemData.isSelected = false;
                        ForumTabSelectedView.this.nEn = null;
                        ForumTabSelectedView.this.setTabColorUnSelected(tab);
                        return;
                    }
                    frsTabItemData.isSelected = true;
                    ForumTabSelectedView.this.nEn = frsTabItemData;
                    ForumTabSelectedView.this.setTabColorSelected(tab);
                }
            }
        };
        this.nEo = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.ForumTabSelectedView.2
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
        dRV();
        dRW();
        cBj();
    }

    private void dRV() {
        this.mTitleView = new TextView(getContext());
        this.mTitleView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mTitleView.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds36));
        this.mTitleView.setText(R.string.forum_tab_select_title);
        this.mTitleView.setOnClickListener(this.nEo);
        addView(this.mTitleView);
    }

    private void dRW() {
        this.mIconView = new ImageView(getContext());
        int dimens = l.getDimens(getContext(), R.dimen.tbds31);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.setMargins(l.getDimens(getContext(), R.dimen.tbds10), 0, 0, 0);
        this.mIconView.setLayoutParams(layoutParams);
        this.mIconView.setOnClickListener(this.nEo);
        addView(this.mIconView);
    }

    private void cBj() {
        this.iVK = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.forum_tab_select_layout, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(l.getDimens(getContext(), R.dimen.tbds10), 0, 0, 0);
        this.iVK.setLayoutParams(layoutParams);
        addView(this.iVK);
        this.iVK.setOnTabSelectedListener(this.jvq);
    }

    public FrsTabItemData getSelectedTabItemData() {
        if (this.nEn == null || !this.nEn.isSelected) {
            return null;
        }
        return this.nEn;
    }

    public void setData(FrsTabInfoData frsTabInfoData) {
        if (frsTabInfoData == null || y.isEmpty(frsTabInfoData.tabList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(frsTabInfoData.tabList, this.iVK, frsTabInfoData.selectedTabId);
    }

    private void a(List<FrsTabItemData> list, TabLayout tabLayout, int i) {
        tabLayout.removeAllTabs();
        int min = Math.min(list.size(), 10);
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
                            b bVar = new b();
                            bVar.pV(dimens3);
                            bVar.pW(dimens4);
                            bVar.qa(R.color.cp_cont_j);
                            tBSpecificationBtn.setConfig(bVar);
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
        ap.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
        if (tabLayout != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tabAt.getCustomView();
                        tBSpecificationBtn.bqd();
                        b bVar = (b) tBSpecificationBtn.getStyleConfig();
                        if (tabAt.isSelected()) {
                            bVar.pY(R.color.cp_link_tip_a);
                        } else {
                            bVar.qa(R.color.cp_cont_j);
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
            ((b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pY(R.color.cp_link_tip_a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).qa(R.color.cp_cont_j);
        }
    }

    public void setActivity(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    public void onChangeSkinType(int i) {
        b(this.iVK);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_j);
        this.mIconView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_post_section12, ap.getColor(R.color.cp_cont_g), WebPManager.ResourceStateType.NORMAL));
    }
}
