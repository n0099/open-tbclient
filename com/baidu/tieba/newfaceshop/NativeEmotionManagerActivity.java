package com.baidu.tieba.newfaceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.newfaceshop.nativemotionmanager.CreateNewEmotionFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment;
import com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class NativeEmotionManagerActivity extends BaseFragmentActivity implements d.b.j0.y1.h.c.a<Boolean> {
    public BaseFragment createEmotionFragment;
    public int isModerator;
    public FragmentPagerAdapter mAdapter;
    public View mBackImg;
    public LinearLayout mEmotionRootView;
    public TextView mManager;
    public NavigationBar mNavigationBar;
    public CommonPagerSlidingTabStrip mTabStrip;
    public BdBaseViewPager mViewPager;
    public MyEmotionManagerFragment myEmotionManagerFragment;
    public SingleThreadEmotionFragment singleThreadEmotionFragment;
    public List<BaseFragment> fragments = new ArrayList(2);
    public List<String> mTitles = new ArrayList(2);
    public boolean edaitButtonShowCtrl = true;
    public int fragmentPostion = 0;

    /* loaded from: classes3.dex */
    public class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (ListUtils.isEmpty(NativeEmotionManagerActivity.this.fragments)) {
                return 0;
            }
            return NativeEmotionManagerActivity.this.fragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (ListUtils.isEmpty(NativeEmotionManagerActivity.this.fragments) || NativeEmotionManagerActivity.this.fragments.size() <= i) {
                return null;
            }
            return (Fragment) NativeEmotionManagerActivity.this.fragments.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return ListUtils.isEmpty(NativeEmotionManagerActivity.this.mTitles) ? "" : (CharSequence) NativeEmotionManagerActivity.this.mTitles.get(i);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ViewPager.SimpleOnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            if (NativeEmotionManagerActivity.this.mManager == null) {
                return;
            }
            NativeEmotionManagerActivity.this.fragmentPostion = i;
            NativeEmotionManagerActivity.this.ctrlIfShowEditButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctrlIfShowEditButton() {
        if (this.fragmentPostion == 0 && this.edaitButtonShowCtrl) {
            this.mManager.setVisibility(0);
        } else {
            this.mManager.setVisibility(4);
        }
    }

    private void init() {
        this.isModerator = getIntent().getIntExtra(NativeEmotionManagerActivityConfig.KEY, 0);
        this.mEmotionRootView = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.mTitles.add("我的表情");
        MyEmotionManagerFragment myEmotionManagerFragment = new MyEmotionManagerFragment();
        this.myEmotionManagerFragment = myEmotionManagerFragment;
        myEmotionManagerFragment.K0(this);
        this.fragments.add(this.myEmotionManagerFragment);
        if (this.isModerator == 1) {
            this.mTitles.add("单吧表情");
            SingleThreadEmotionFragment singleThreadEmotionFragment = new SingleThreadEmotionFragment();
            this.singleThreadEmotionFragment = singleThreadEmotionFragment;
            this.fragments.add(singleThreadEmotionFragment);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(getPageContext().getPageActivity());
        this.mManager = textView;
        textView.setPadding(0, l.g(this, R.dimen.ds20), l.g(this, R.dimen.ds31), l.g(this, R.dimen.ds20));
        this.mManager.setClickable(true);
        this.mManager.setLayoutParams(layoutParams);
        this.mManager.setText(R.string.emotion_manage_edit);
        this.mManager.setOnClickListener(this);
        SkinManager.setViewTextColor(this.mManager, R.color.CAM_X0302);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_manager_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mManager, (View.OnClickListener) null);
        this.mBackImg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_manager_bar, (View.OnClickListener) null);
        CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) this.mNavigationBar.findViewById(R.id.emotion_manager_nav);
        this.mTabStrip = commonPagerSlidingTabStrip;
        commonPagerSlidingTabStrip.k(l.g(this, R.dimen.ds32), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds8), l.g(this, R.dimen.ds68), R.color.CAM_X0107, R.color.CAM_X0105);
        BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.emotion_manager_viewpager);
        this.mViewPager = bdBaseViewPager;
        bdBaseViewPager.setmDisallowSlip(true);
        this.mViewPager.setOffscreenPageLimit(1);
        a aVar = new a(getSupportFragmentManager());
        this.mAdapter = aVar;
        this.mViewPager.setAdapter(aVar);
        this.mTabStrip.setViewPager(this.mViewPager);
        this.mTabStrip.setOnPageChangeListener(new b());
        this.createEmotionFragment = new CreateNewEmotionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NativeEmotionManagerActivityConfig.KEY, this.isModerator);
        this.createEmotionFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.emotion_manager_create_new_emotion, this.createEmotionFragment).commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().k(i == 1);
        CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.mTabStrip;
        if (commonPagerSlidingTabStrip != null) {
            commonPagerSlidingTabStrip.n(i);
        }
        TextView textView = this.mManager;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
        }
        LinearLayout linearLayout = this.mEmotionRootView;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mManager) {
            boolean z = !d.b.j0.y1.h.a.b().a();
            d.b.j0.y1.h.a.b().d(z);
            if (z) {
                this.mManager.setText(R.string.emotion_manage_finish);
            } else {
                this.mManager.setText(R.string.emotion_manage_edit);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921310));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.emotion_native_manager_activity);
        init();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.y1.h.c.a
    public void onUpdate(Boolean bool) {
        if (bool == null) {
            return;
        }
        this.edaitButtonShowCtrl = bool.booleanValue();
        ctrlIfShowEditButton();
    }
}
