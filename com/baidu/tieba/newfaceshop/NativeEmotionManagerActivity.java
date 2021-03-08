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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements a.InterfaceC0819a<Boolean> {
    private BdBaseViewPager fqq;
    private TextView iYf;
    private CommonPagerSlidingTabStrip iZI;
    private LinearLayout iZJ;
    private FragmentPagerAdapter iZK;
    private BaseFragment lCc;
    private View lCd;
    private int lCe;
    private MyEmotionManagerFragment lCf;
    private SingleThreadEmotionFragment lCg;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> eyj = new ArrayList(2);
    private List<String> fQk = new ArrayList(2);
    private boolean lCh = true;
    private int lCi = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.emotion_native_manager_activity);
        init();
    }

    private void init() {
        this.lCe = getIntent().getIntExtra(NativeEmotionManagerActivityConfig.KEY, 0);
        this.iZJ = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fQk.add("我的表情");
        this.lCf = new MyEmotionManagerFragment();
        this.lCf.a(this);
        this.eyj.add(this.lCf);
        if (this.lCe == 1) {
            this.fQk.add("单吧表情");
            this.lCg = new SingleThreadEmotionFragment();
            this.eyj.add(this.lCg);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iYf = new TextView(getPageContext().getPageActivity());
        this.iYf.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iYf.setClickable(true);
        this.iYf.setLayoutParams(layoutParams);
        this.iYf.setText(R.string.emotion_manage_edit);
        this.iYf.setOnClickListener(this);
        ap.setViewTextColor(this.iYf, R.color.CAM_X0302);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_manager_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iYf, (View.OnClickListener) null);
        this.lCd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_manager_bar, (View.OnClickListener) null);
        this.iZI = (CommonPagerSlidingTabStrip) this.mNavigationBar.findViewById(R.id.emotion_manager_nav);
        this.iZI.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds8), l.getDimens(this, R.dimen.ds68), R.color.CAM_X0107, R.color.CAM_X0105);
        this.fqq = (BdBaseViewPager) findViewById(R.id.emotion_manager_viewpager);
        this.fqq.setmDisallowSlip(true);
        this.fqq.setOffscreenPageLimit(1);
        this.iZK = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.1
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!y.isEmpty(NativeEmotionManagerActivity.this.eyj) && NativeEmotionManagerActivity.this.eyj.size() > i) {
                    return (Fragment) NativeEmotionManagerActivity.this.eyj.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!y.isEmpty(NativeEmotionManagerActivity.this.eyj)) {
                    return NativeEmotionManagerActivity.this.eyj.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!y.isEmpty(NativeEmotionManagerActivity.this.fQk)) {
                    return (CharSequence) NativeEmotionManagerActivity.this.fQk.get(i);
                }
                return "";
            }
        };
        this.fqq.setAdapter(this.iZK);
        this.iZI.setViewPager(this.fqq);
        this.iZI.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.2
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                if (NativeEmotionManagerActivity.this.iYf != null) {
                    NativeEmotionManagerActivity.this.lCi = i;
                    NativeEmotionManagerActivity.this.diA();
                }
            }
        });
        this.lCc = new CreateNewEmotionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NativeEmotionManagerActivityConfig.KEY, this.lCe);
        this.lCc.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.emotion_manager_create_new_emotion, this.lCc).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diA() {
        if (this.lCi == 0 && this.lCh) {
            this.iYf.setVisibility(0);
        } else {
            this.iYf.setVisibility(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iZI != null) {
            this.iZI.onChangeSkinType(i);
        }
        if (this.iYf != null) {
            ap.setViewTextColor(this.iYf, R.color.CAM_X0302, i);
        }
        if (this.iZJ != null) {
            ap.setBackgroundColor(this.iZJ, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iYf) {
            boolean z = !com.baidu.tieba.newfaceshop.nativemotionmanager.a.djh().bLg();
            com.baidu.tieba.newfaceshop.nativemotionmanager.a.djh().sV(z);
            if (z) {
                this.iYf.setText(R.string.emotion_manage_finish);
            } else {
                this.iYf.setText(R.string.emotion_manage_edit);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.b.a.InterfaceC0819a
    /* renamed from: q */
    public void onUpdate(Boolean bool) {
        if (bool != null) {
            this.lCh = bool.booleanValue();
            diA();
        }
    }
}
