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
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements a.InterfaceC0812a<Boolean> {
    private BdBaseViewPager foQ;
    private TextView iWi;
    private CommonPagerSlidingTabStrip iXL;
    private LinearLayout iXM;
    private FragmentPagerAdapter iXN;
    private BaseFragment lzM;
    private View lzN;
    private int lzO;
    private MyEmotionManagerFragment lzP;
    private SingleThreadEmotionFragment lzQ;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> ewG = new ArrayList(2);
    private List<String> fOK = new ArrayList(2);
    private boolean lzR = true;
    private int lzS = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.emotion_native_manager_activity);
        init();
    }

    private void init() {
        this.lzO = getIntent().getIntExtra(NativeEmotionManagerActivityConfig.KEY, 0);
        this.iXM = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fOK.add("我的表情");
        this.lzP = new MyEmotionManagerFragment();
        this.lzP.a(this);
        this.ewG.add(this.lzP);
        if (this.lzO == 1) {
            this.fOK.add("单吧表情");
            this.lzQ = new SingleThreadEmotionFragment();
            this.ewG.add(this.lzQ);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iWi = new TextView(getPageContext().getPageActivity());
        this.iWi.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iWi.setClickable(true);
        this.iWi.setLayoutParams(layoutParams);
        this.iWi.setText(R.string.emotion_manage_edit);
        this.iWi.setOnClickListener(this);
        ap.setViewTextColor(this.iWi, R.color.CAM_X0302);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_manager_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iWi, (View.OnClickListener) null);
        this.lzN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_manager_bar, (View.OnClickListener) null);
        this.iXL = (CommonPagerSlidingTabStrip) this.mNavigationBar.findViewById(R.id.emotion_manager_nav);
        this.iXL.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds8), l.getDimens(this, R.dimen.ds68), R.color.CAM_X0107, R.color.CAM_X0105);
        this.foQ = (BdBaseViewPager) findViewById(R.id.emotion_manager_viewpager);
        this.foQ.setmDisallowSlip(true);
        this.foQ.setOffscreenPageLimit(1);
        this.iXN = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.1
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
        this.foQ.setAdapter(this.iXN);
        this.iXL.setViewPager(this.foQ);
        this.iXL.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.baidu.tieba.newfaceshop.NativeEmotionManagerActivity.2
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                if (NativeEmotionManagerActivity.this.iWi != null) {
                    NativeEmotionManagerActivity.this.lzS = i;
                    NativeEmotionManagerActivity.this.dik();
                }
            }
        });
        this.lzM = new CreateNewEmotionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NativeEmotionManagerActivityConfig.KEY, this.lzO);
        this.lzM.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.emotion_manager_create_new_emotion, this.lzM).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dik() {
        if (this.lzS == 0 && this.lzR) {
            this.iWi.setVisibility(0);
        } else {
            this.iWi.setVisibility(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iXL != null) {
            this.iXL.onChangeSkinType(i);
        }
        if (this.iWi != null) {
            ap.setViewTextColor(this.iWi, R.color.CAM_X0302, i);
        }
        if (this.iXM != null) {
            ap.setBackgroundColor(this.iXM, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iWi) {
            boolean z = !com.baidu.tieba.newfaceshop.nativemotionmanager.a.diR().bKX();
            com.baidu.tieba.newfaceshop.nativemotionmanager.a.diR().sV(z);
            if (z) {
                this.iWi.setText(R.string.emotion_manage_finish);
            } else {
                this.iWi.setText(R.string.emotion_manage_edit);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.b.a.InterfaceC0812a
    /* renamed from: q */
    public void onUpdate(Boolean bool) {
        if (bool != null) {
            this.lzR = bool.booleanValue();
            dik();
        }
    }
}
