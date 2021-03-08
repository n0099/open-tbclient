package com.baidu.tieba.myCollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private final NavigationBar iLw;
    private final TextView lyH;
    private final FragmentTabHost lyI;
    private Fragment lyK;
    private final NoNetworkView lyL;
    private CollectTabActivity lyM;
    private List mTabDataList;
    private int lyJ = -1;
    private boolean lyN = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.EP(i);
            a.this.uc(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int dhB() {
        return this.lyJ;
    }

    public Fragment dhC() {
        return this.lyK;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.lyM = collectTabActivity;
        this.lyI = (FragmentTabHost) this.lyM.findViewById(R.id.tab_host);
        this.lyI.setup(this.lyM.getSupportFragmentManager());
        this.lyI.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iLw = (NavigationBar) this.lyM.findViewById(R.id.navigation_bar);
        this.lyL = (NoNetworkView) this.lyM.findViewById(R.id.view_no_network);
        this.iLw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iLw.setCenterTextTitle(this.lyM.getPageContext().getString(R.string.my_mark));
        this.lyH = (TextView) this.iLw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.lyM).findViewById(R.id.right_textview);
        this.lyH.setText(R.string.edit);
        this.lyH.setOnClickListener(this.lyM);
        this.iLw.onChangeSkinType(this.lyM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView dhD() {
        return this.lyH;
    }

    @SuppressLint({"ResourceAsColor"})
    public void uc(boolean z) {
        int i = -1;
        if (this.lyK instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.lyK;
            if (!collectFragment.bkR()) {
                z = false;
            }
            ud(collectFragment.bkR());
            i = collectFragment.getType();
        }
        this.lyN = z;
        this.lyH.setText(this.lyN ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.lyH, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.lyH, this.lyN ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.lyN);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean dhE() {
        return this.lyN;
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.lyI.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.lyM.getPageContext().getPageActivity()));
                }
            }
            this.lyI.initViewPager(0);
            this.lyI.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.lyI.getFragmentTabWidget().setVisibility(8);
            }
            EP(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP(int i) {
        FragmentTabHost.b ou = this.lyI.ou(i);
        this.lyJ = ou.mType;
        this.lyK = ou.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.lyM.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.faJ = fragmentTabIndicator;
            bVar2.faK = bVar;
            this.lyI.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.lyI.onChangeSkinType(i);
        if (this.lyI.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.lyI.getTabWrapper().setVisibility(8);
            } else {
                this.lyI.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.lyH, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iLw.onChangeSkinType(this.lyM.getPageContext(), i);
        this.lyL.onChangeSkinType(this.lyM.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void ud(boolean z) {
        this.lyH.setEnabled(z);
        if (!z) {
            this.lyH.setText(R.string.edit);
            ap.setNavbarTitleColor(this.lyH, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
