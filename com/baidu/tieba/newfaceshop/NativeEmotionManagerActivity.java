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
/* loaded from: classes9.dex */
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements a.InterfaceC0828a<Boolean> {
    private BdBaseViewPager fri;
    private TextView iVi;
    private CommonPagerSlidingTabStrip iWL;
    private LinearLayout iWM;
    private FragmentPagerAdapter iWN;
    private BaseFragment lwn;
    private View lwo;
    private int lwp;
    private MyEmotionManagerFragment lwq;
    private SingleThreadEmotionFragment lwr;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> ezp = new ArrayList(2);
    private List<String> fRe = new ArrayList(2);
    private boolean lws = true;
    private int lwt = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.emotion_native_manager_activity);
        init();
    }

    private void init() {
        this.lwp = getIntent().getIntExtra(NativeEmotionManagerActivityConfig.KEY, 0);
        this.iWM = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fRe.add("我的表情");
        this.lwq = new MyEmotionManagerFragment();
        this.lwq.a(this);
        this.ezp.add(this.lwq);
        if (this.lwp == 1) {
            this.fRe.add("单吧表情");
            this.lwr = new SingleThreadEmotionFragment();
            this.ezp.add(this.lwr);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iVi = new TextView(getPageContext().getPageActivity());
        this.iVi.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iVi.setClickable(true);
        this.iVi.setLayoutParams(layoutParams);
        this.iVi.setText(R.string.emotion_manage_edit);
        this.iVi.setOnClickListener(this);
        ao.setViewTextColor(this.iVi, R.color.CAM_X0302);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_manager_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iVi, (View.OnClickListener) null);
        this.lwo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_manager_bar, (View.OnClickListener) null);
        this.iWL = (CommonPagerSlidingTabStrip) this.mNavigationBar.findViewById(R.id.emotion_manager_nav);
        this.iWL.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds8), l.getDimens(this, R.dimen.ds68), R.color.CAM_X0107, R.color.CAM_X0105);
        this.fri = (BdBaseViewPager) findViewById(R.id.emotion_manager_viewpager);
        this.fri.setmDisallowSlip(true);
        this.fri.setOffscreenPageLimit(1);
        this.iWN = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.1
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!x.isEmpty(NativeEmotionManagerActivity.this.ezp) && NativeEmotionManagerActivity.this.ezp.size() > i) {
                    return (Fragment) NativeEmotionManagerActivity.this.ezp.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!x.isEmpty(NativeEmotionManagerActivity.this.ezp)) {
                    return NativeEmotionManagerActivity.this.ezp.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!x.isEmpty(NativeEmotionManagerActivity.this.fRe)) {
                    return (CharSequence) NativeEmotionManagerActivity.this.fRe.get(i);
                }
                return "";
            }
        };
        this.fri.setAdapter(this.iWN);
        this.iWL.setViewPager(this.fri);
        this.iWL.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.2
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                if (NativeEmotionManagerActivity.this.iVi != null) {
                    NativeEmotionManagerActivity.this.lwt = i;
                    NativeEmotionManagerActivity.this.dkb();
                }
            }
        });
        this.lwn = new CreateNewEmotionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NativeEmotionManagerActivityConfig.KEY, this.lwp);
        this.lwn.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.emotion_manager_create_new_emotion, this.lwn).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkb() {
        if (this.lwt == 0 && this.lws) {
            this.iVi.setVisibility(0);
        } else {
            this.iVi.setVisibility(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iWL != null) {
            this.iWL.onChangeSkinType(i);
        }
        if (this.iVi != null) {
            ao.setViewTextColor(this.iVi, R.color.CAM_X0302, i);
        }
        if (this.iWM != null) {
            ao.setBackgroundColor(this.iWM, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iVi) {
            boolean z = !com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().bOv();
            com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().sM(z);
            if (z) {
                this.iVi.setText(R.string.emotion_manage_finish);
            } else {
                this.iVi.setText(R.string.emotion_manage_edit);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.b.a.InterfaceC0828a
    /* renamed from: r */
    public void onUpdate(Boolean bool) {
        if (bool != null) {
            this.lws = bool.booleanValue();
            dkb();
        }
    }
}
