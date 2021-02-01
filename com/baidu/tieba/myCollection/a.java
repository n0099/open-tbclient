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
/* loaded from: classes8.dex */
public class a {
    private final NavigationBar iJz;
    private final TextView lwq;
    private final FragmentTabHost lwr;
    private Fragment lwt;
    private final NoNetworkView lwu;
    private CollectTabActivity lwv;
    private List mTabDataList;
    private int lws = -1;
    private boolean lww = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.EM(i);
            a.this.uc(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int dhl() {
        return this.lws;
    }

    public Fragment dhm() {
        return this.lwt;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.lwv = collectTabActivity;
        this.lwr = (FragmentTabHost) this.lwv.findViewById(R.id.tab_host);
        this.lwr.setup(this.lwv.getSupportFragmentManager());
        this.lwr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iJz = (NavigationBar) this.lwv.findViewById(R.id.navigation_bar);
        this.lwu = (NoNetworkView) this.lwv.findViewById(R.id.view_no_network);
        this.iJz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iJz.setCenterTextTitle(this.lwv.getPageContext().getString(R.string.my_mark));
        this.lwq = (TextView) this.iJz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.lwv).findViewById(R.id.right_textview);
        this.lwq.setText(R.string.edit);
        this.lwq.setOnClickListener(this.lwv);
        this.iJz.onChangeSkinType(this.lwv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView dhn() {
        return this.lwq;
    }

    @SuppressLint({"ResourceAsColor"})
    public void uc(boolean z) {
        int i = -1;
        if (this.lwt instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.lwt;
            if (!collectFragment.bkP()) {
                z = false;
            }
            ud(collectFragment.bkP());
            i = collectFragment.getType();
        }
        this.lww = z;
        this.lwq.setText(this.lww ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.lwq, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.lwq, this.lww ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.lww);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean dho() {
        return this.lww;
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.lwr.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.lwv.getPageContext().getPageActivity()));
                }
            }
            this.lwr.initViewPager(0);
            this.lwr.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.lwr.getFragmentTabWidget().setVisibility(8);
            }
            EM(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EM(int i) {
        FragmentTabHost.b ot = this.lwr.ot(i);
        this.lws = ot.mType;
        this.lwt = ot.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.lwv.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eZk = fragmentTabIndicator;
            bVar2.eZl = bVar;
            this.lwr.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.lwr.onChangeSkinType(i);
        if (this.lwr.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.lwr.getTabWrapper().setVisibility(8);
            } else {
                this.lwr.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.lwq, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iJz.onChangeSkinType(this.lwv.getPageContext(), i);
        this.lwu.onChangeSkinType(this.lwv.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void ud(boolean z) {
        this.lwq.setEnabled(z);
        if (!z) {
            this.lwq.setText(R.string.edit);
            ap.setNavbarTitleColor(this.lwq, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
