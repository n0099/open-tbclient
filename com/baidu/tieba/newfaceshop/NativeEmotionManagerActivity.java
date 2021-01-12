package com.baidu.tieba.newfaceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.newfaceshop.nativemotionmanager.CreateNewEmotionFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements a.InterfaceC0811a<Boolean> {
    private BdBaseViewPager fmy;
    private TextView iQB;
    private CommonPagerSlidingTabStrip iSe;
    private LinearLayout iSf;
    private FragmentPagerAdapter iSg;
    private BaseFragment lrH;
    private View lrI;
    private int lrJ;
    private MyEmotionManagerFragment lrK;
    private SingleThreadEmotionFragment lrL;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> euA = new ArrayList(2);
    private List<String> fMx = new ArrayList(2);
    private boolean lrM = true;
    private int lrN = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.emotion_native_manager_activity);
        init();
    }

    private void init() {
        this.lrJ = getIntent().getIntExtra(NativeEmotionManagerActivityConfig.KEY, 0);
        this.iSf = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fMx.add("我的表情");
        this.lrK = new MyEmotionManagerFragment();
        this.lrK.a(this);
        this.euA.add(this.lrK);
        if (this.lrJ == 1) {
            this.fMx.add("单吧表情");
            this.lrL = new SingleThreadEmotionFragment();
            this.euA.add(this.lrL);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iQB = new TextView(getPageContext().getPageActivity());
        this.iQB.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iQB.setClickable(true);
        this.iQB.setLayoutParams(layoutParams);
        this.iQB.setText(R.string.emotion_manage_edit);
        this.iQB.setOnClickListener(this);
        ao.setViewTextColor(this.iQB, R.color.CAM_X0302);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_manager_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iQB, (View.OnClickListener) null);
        this.lrI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_manager_bar, (View.OnClickListener) null);
        this.iSe = (CommonPagerSlidingTabStrip) this.mNavigationBar.findViewById(R.id.emotion_manager_nav);
        this.iSe.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds8), l.getDimens(this, R.dimen.ds68), R.color.CAM_X0107, R.color.CAM_X0105);
        this.fmy = (BdBaseViewPager) findViewById(R.id.emotion_manager_viewpager);
        this.fmy.setmDisallowSlip(true);
        this.fmy.setOffscreenPageLimit(1);
        this.iSg = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.1
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!x.isEmpty(NativeEmotionManagerActivity.this.euA) && NativeEmotionManagerActivity.this.euA.size() > i) {
                    return (Fragment) NativeEmotionManagerActivity.this.euA.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!x.isEmpty(NativeEmotionManagerActivity.this.euA)) {
                    return NativeEmotionManagerActivity.this.euA.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!x.isEmpty(NativeEmotionManagerActivity.this.fMx)) {
                    return (CharSequence) NativeEmotionManagerActivity.this.fMx.get(i);
                }
                return "";
            }
        };
        this.fmy.setAdapter(this.iSg);
        this.iSe.setViewPager(this.fmy);
        this.iSe.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.2
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                if (NativeEmotionManagerActivity.this.iQB != null) {
                    NativeEmotionManagerActivity.this.lrN = i;
                    NativeEmotionManagerActivity.this.dgj();
                }
            }
        });
        this.lrH = new CreateNewEmotionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NativeEmotionManagerActivityConfig.KEY, this.lrJ);
        this.lrH.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.emotion_manager_create_new_emotion, this.lrH).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgj() {
        if (this.lrN == 0 && this.lrM) {
            this.iQB.setVisibility(0);
        } else {
            this.iQB.setVisibility(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iSe != null) {
            this.iSe.onChangeSkinType(i);
        }
        if (this.iQB != null) {
            ao.setViewTextColor(this.iQB, R.color.CAM_X0302, i);
        }
        if (this.iSf != null) {
            ao.setBackgroundColor(this.iSf, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iQB) {
            boolean z = !com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().bKD();
            com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().sI(z);
            if (z) {
                this.iQB.setText(R.string.emotion_manage_finish);
            } else {
                this.iQB.setText(R.string.emotion_manage_edit);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.b.a.InterfaceC0811a
    /* renamed from: r */
    public void onUpdate(Boolean bool) {
        if (bool != null) {
            this.lrM = bool.booleanValue();
            dgj();
        }
    }
}
