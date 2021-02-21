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
/* loaded from: classes9.dex */
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements a.InterfaceC0813a<Boolean> {
    private BdBaseViewPager foQ;
    private TextView iWw;
    private CommonPagerSlidingTabStrip iXZ;
    private LinearLayout iYa;
    private FragmentPagerAdapter iYb;
    private BaseFragment lAa;
    private View lAb;
    private int lAc;
    private MyEmotionManagerFragment lAd;
    private SingleThreadEmotionFragment lAe;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> ewG = new ArrayList(2);
    private List<String> fOK = new ArrayList(2);
    private boolean lAf = true;
    private int lAg = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.emotion_native_manager_activity);
        init();
    }

    private void init() {
        this.lAc = getIntent().getIntExtra(NativeEmotionManagerActivityConfig.KEY, 0);
        this.iYa = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fOK.add("我的表情");
        this.lAd = new MyEmotionManagerFragment();
        this.lAd.a(this);
        this.ewG.add(this.lAd);
        if (this.lAc == 1) {
            this.fOK.add("单吧表情");
            this.lAe = new SingleThreadEmotionFragment();
            this.ewG.add(this.lAe);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iWw = new TextView(getPageContext().getPageActivity());
        this.iWw.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iWw.setClickable(true);
        this.iWw.setLayoutParams(layoutParams);
        this.iWw.setText(R.string.emotion_manage_edit);
        this.iWw.setOnClickListener(this);
        ap.setViewTextColor(this.iWw, R.color.CAM_X0302);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_manager_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iWw, (View.OnClickListener) null);
        this.lAb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_manager_bar, (View.OnClickListener) null);
        this.iXZ = (CommonPagerSlidingTabStrip) this.mNavigationBar.findViewById(R.id.emotion_manager_nav);
        this.iXZ.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds8), l.getDimens(this, R.dimen.ds68), R.color.CAM_X0107, R.color.CAM_X0105);
        this.foQ = (BdBaseViewPager) findViewById(R.id.emotion_manager_viewpager);
        this.foQ.setmDisallowSlip(true);
        this.foQ.setOffscreenPageLimit(1);
        this.iYb = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.1
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!y.isEmpty(NativeEmotionManagerActivity.this.ewG) && NativeEmotionManagerActivity.this.ewG.size() > i) {
                    return (Fragment) NativeEmotionManagerActivity.this.ewG.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!y.isEmpty(NativeEmotionManagerActivity.this.ewG)) {
                    return NativeEmotionManagerActivity.this.ewG.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!y.isEmpty(NativeEmotionManagerActivity.this.fOK)) {
                    return (CharSequence) NativeEmotionManagerActivity.this.fOK.get(i);
                }
                return "";
            }
        };
        this.foQ.setAdapter(this.iYb);
        this.iXZ.setViewPager(this.foQ);
        this.iXZ.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.2
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                if (NativeEmotionManagerActivity.this.iWw != null) {
                    NativeEmotionManagerActivity.this.lAg = i;
                    NativeEmotionManagerActivity.this.dir();
                }
            }
        });
        this.lAa = new CreateNewEmotionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NativeEmotionManagerActivityConfig.KEY, this.lAc);
        this.lAa.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.emotion_manager_create_new_emotion, this.lAa).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dir() {
        if (this.lAg == 0 && this.lAf) {
            this.iWw.setVisibility(0);
        } else {
            this.iWw.setVisibility(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iXZ != null) {
            this.iXZ.onChangeSkinType(i);
        }
        if (this.iWw != null) {
            ap.setViewTextColor(this.iWw, R.color.CAM_X0302, i);
        }
        if (this.iYa != null) {
            ap.setBackgroundColor(this.iYa, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iWw) {
            boolean z = !com.baidu.tieba.newfaceshop.nativemotionmanager.a.diY().bLc();
            com.baidu.tieba.newfaceshop.nativemotionmanager.a.diY().sV(z);
            if (z) {
                this.iWw.setText(R.string.emotion_manage_finish);
            } else {
                this.iWw.setText(R.string.emotion_manage_edit);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.b.a.InterfaceC0813a
    /* renamed from: q */
    public void onUpdate(Boolean bool) {
        if (bool != null) {
            this.lAf = bool.booleanValue();
            dir();
        }
    }
}
