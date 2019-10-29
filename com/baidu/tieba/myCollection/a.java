package com.baidu.tieba.myCollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private final NavigationBar fcw;
    private final TextView hzu;
    private final FragmentTabHost hzv;
    private Fragment hzx;
    private final NoNetworkView hzy;
    private CollectTabActivity hzz;
    private List mTabDataList;
    private int hzw = -1;
    private boolean hzA = false;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.myCollection.a.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.vZ(i);
            a.this.nq(false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public int bNs() {
        return this.hzw;
    }

    public Fragment bNt() {
        return this.hzx;
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        FrameLayout.LayoutParams layoutParams;
        this.hzz = collectTabActivity;
        this.hzv = (FragmentTabHost) this.hzz.findViewById(R.id.tab_host);
        this.hzv.setup(this.hzz.getSupportFragmentManager());
        this.hzv.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fcw = (NavigationBar) this.hzz.findViewById(R.id.navigation_bar);
        this.hzy = (NoNetworkView) this.hzz.findViewById(R.id.view_no_network);
        this.fcw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fcw.setCenterTextTitle(this.hzz.getPageContext().getString(R.string.my_mark));
        this.fcw.showBottomLine();
        this.hzu = (TextView) this.fcw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.hzz).findViewById(R.id.right_textview);
        this.hzu.setText(R.string.edit);
        this.hzu.setOnClickListener(this.hzz);
        View bottomLine = this.fcw.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.hzz.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.hzz.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setBackgroundColor(this.hzz.getResources().getColor(R.color.cp_cont_c));
            bottomLine.setLayoutParams(layoutParams);
        }
        this.fcw.showBottomLine();
        this.fcw.onChangeSkinType(this.hzz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView bNu() {
        return this.hzu;
    }

    @SuppressLint({"ResourceAsColor"})
    public void nq(boolean z) {
        int i = -1;
        if (this.hzx instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) this.hzx;
            if (!collectFragment.agm()) {
                z = false;
            }
            nr(collectFragment.agm());
            i = collectFragment.getType();
        }
        this.hzA = z;
        this.hzu.setText(this.hzA ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            am.setNavbarTitleColor(this.hzu, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            am.setNavbarTitleColor(this.hzu, this.hzA ? R.color.cp_link_tip_a : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.hzA);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }

    public boolean bNv() {
        return this.hzA;
    }

    public void au(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mTabDataList = arrayList;
            this.hzv.reset();
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.tbadk.mainTab.b bVar = arrayList.get(i);
                if (bVar != null && bVar.isAvailable()) {
                    a(bVar, (FragmentTabIndicator) bVar.cB(this.hzz.getPageContext().getPageActivity()));
                }
            }
            this.hzv.initViewPager(0);
            this.hzv.setCurrentTab(0);
            if (arrayList.size() == 1) {
                this.hzv.getFragmentTabWidget().setVisibility(8);
            }
            vZ(0);
        }
    }

    private int getTabCount() {
        return v.getCount(this.mTabDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ(int i) {
        FragmentTabHost.b im = this.hzv.im(i);
        this.hzw = im.mType;
        this.hzx = im.mContentFragment;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mainTab.c avz = bVar.avz();
        if (avz != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mContentFragment = avz.frag;
            bVar2.mType = avz.type;
            fragmentTabIndicator.setText(avz.textResId);
            fragmentTabIndicator.setTextSize(0, this.hzz.getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.cim = fragmentTabIndicator;
            bVar2.cin = bVar;
            this.hzv.a(bVar2);
        }
    }

    public void onChangeSkinType(int i) {
        this.hzv.onChangeSkinType(i);
        if (this.hzv.getTabWrapper() != null) {
            if (getTabCount() <= 1) {
                this.hzv.getTabWrapper().setVisibility(8);
            } else {
                this.hzv.getTabWrapper().setVisibility(0);
            }
        }
        am.setNavbarTitleColor(this.hzu, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.fcw.onChangeSkinType(this.hzz.getPageContext(), i);
        this.hzy.onChangeSkinType(this.hzz.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void nr(boolean z) {
        this.hzu.setEnabled(z);
        if (!z) {
            this.hzu.setText(R.string.edit);
            am.setNavbarTitleColor(this.hzu, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }
}
