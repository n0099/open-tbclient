package com.baidu.tieba.myCollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
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
/* loaded from: classes23.dex */
public class a {
    private final NavigationBar iln;
    private final TextView lad;
    private final FragmentTabHost lae;
    private Fragment lag;
    private final NoNetworkView lah;
    private CollectTabActivity lai;
    private List mTabDataList;
    private int laf = -1;
    private boolean laj = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.Ft(i);
            a.this.tq(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int dec() {
        return this.laf;
    }

    public Fragment ded() {
        return this.lag;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.lai = collectTabActivity;
        this.lae = (FragmentTabHost) this.lai.findViewById(R.id.tab_host);
        this.lae.setup(this.lai.getSupportFragmentManager());
        this.lae.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iln = (NavigationBar) this.lai.findViewById(R.id.navigation_bar);
        this.lah = (NoNetworkView) this.lai.findViewById(R.id.view_no_network);
        this.iln.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iln.setCenterTextTitle(this.lai.getPageContext().getString(R.string.my_mark));
        this.lad = (TextView) this.iln.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.lai).findViewById(R.id.right_textview);
        this.lad.setText(R.string.edit);
        this.lad.setOnClickListener(this.lai);
        this.iln.onChangeSkinType(this.lai.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView dee() {
        return this.lad;
    }

    @SuppressLint({"ResourceAsColor"})
    public void tq(boolean z) {
        int i = -1;
        if (this.lag instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.lag;
            if (!collectFragment.biH()) {
                z = false;
            }
            tr(collectFragment.biH());
            i = collectFragment.getType();
        }
        this.laj = z;
        this.lad.setText(this.laj ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            ap.setNavbarTitleColor(this.lad, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            ap.setNavbarTitleColor(this.lad, this.laj ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.laj);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean def() {
        return this.laj;
    }

    public void aV(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.lae.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.lai.getPageContext().getPageActivity()));
                }
            }
            this.lae.initViewPager(0);
            this.lae.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.lae.getFragmentTabWidget().setVisibility(8);
            }
            Ft(0);
        }
    }

    private int getTabCount() {
        return y.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft(int i) {
        FragmentTabHost.b pk = this.lae.pk(i);
        this.laf = pk.mType;
        this.lag = pk.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = fragmentTabStructure.frag;
            bVar2.mType = fragmentTabStructure.type;
            fragmentTabIndicator.setText(fragmentTabStructure.textResId);
            fragmentTabIndicator.setTextSize(0, this.lai.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.eKr = fragmentTabIndicator;
            bVar2.eKs = bVar;
            this.lae.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.lae.onChangeSkinType(i);
        if (this.lae.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.lae.getTabWrapper().setVisibility(8);
            } else {
                this.lae.getTabWrapper().setVisibility(0);
            }
        }
        ap.setNavbarTitleColor(this.lad, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.iln.onChangeSkinType(this.lai.getPageContext(), i);
        this.lah.onChangeSkinType(this.lai.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void tr(boolean z) {
        this.lad.setEnabled(z);
        if (!z) {
            this.lad.setText(R.string.edit);
            ap.setNavbarTitleColor(this.lad, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
