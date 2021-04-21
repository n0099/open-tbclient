package com.baidu.tieba.video.cloudmusic;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.j0.q3.i.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CloudMusicActivity extends BaseFragmentActivity implements d {
    public c mCloudMusicPageAdapter;
    public List<BaseFragment> mFragments;
    public d.b.j0.q3.i.c mICloudMusicPresenter;
    public NavigationBar mNavigationBar;
    public final CustomMessageListener mNetworkChangedMessageListener = new a(2000994);
    public NoDataView mNoDataView;
    public NoNetworkView mNoNetworkView;
    public View mRootView;
    public CommonPagerSlidingTabStrip mTabStrip;
    public List<String> mTitles;
    public BdBaseViewPager mViewPager;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.z() && CloudMusicActivity.this.mICloudMusicPresenter != null) {
                CloudMusicActivity.this.mICloudMusicPresenter.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudMusicActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends FragmentPagerAdapter {
        public c(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (ListUtils.isEmpty(CloudMusicActivity.this.mFragments)) {
                return 0;
            }
            return CloudMusicActivity.this.mFragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (ListUtils.isEmpty(CloudMusicActivity.this.mFragments) || CloudMusicActivity.this.mFragments.size() <= i) {
                return null;
            }
            CloudMusicListFragment cloudMusicListFragment = (CloudMusicListFragment) CloudMusicActivity.this.mFragments.get(i);
            new d.b.j0.q3.i.a(new CloudMusicListModel(CloudMusicActivity.this.getPageContext()), cloudMusicListFragment);
            return cloudMusicListFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return ListUtils.isEmpty(CloudMusicActivity.this.mTitles) ? "" : (CharSequence) CloudMusicActivity.this.mTitles.get(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // d.b.j0.q3.i.d
    public void displayLoading(boolean z) {
        View view;
        if (z && (view = this.mRootView) != null) {
            showLoadingView(view, false, l.g(getPageContext().getPageActivity(), R.dimen.ds400));
        } else {
            hideLoadingView(this.mRootView);
        }
    }

    @Override // d.b.j0.q3.i.d
    public void displayNoDataView(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().k(i == 1);
        CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.mTabStrip;
        if (commonPagerSlidingTabStrip != null) {
            commonPagerSlidingTabStrip.n(i);
        }
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_cloud_music);
        new d.b.j0.q3.i.b(new CloudMusicModel(getPageContext()), this);
        this.mRootView = findViewById(R.id.cloud_music_activity_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.no_network_view);
        this.mNoNetworkView = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.music_cloud)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (j.A()) {
            this.mNoNetworkView.setVisibility(8);
        } else {
            this.mNoNetworkView.setVisibility(0);
        }
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getPageContext().getPageActivity(), R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_data_text), null);
        this.mNoDataView = a2;
        a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) findViewById(R.id.cloud_music_nav);
        this.mTabStrip = commonPagerSlidingTabStrip;
        commonPagerSlidingTabStrip.k(l.g(getPageContext().getPageActivity(), R.dimen.ds30), l.g(getPageContext().getPageActivity(), R.dimen.ds24), l.g(getPageContext().getPageActivity(), R.dimen.ds16), l.g(getPageContext().getPageActivity(), R.dimen.ds24), l.g(getPageContext().getPageActivity(), R.dimen.ds20), l.g(getPageContext().getPageActivity(), R.dimen.ds4), l.g(getPageContext().getPageActivity(), R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
        BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.cloud_music_view_pager);
        this.mViewPager = bdBaseViewPager;
        bdBaseViewPager.setOffscreenPageLimit(2);
        c cVar = new c(getSupportFragmentManager());
        this.mCloudMusicPageAdapter = cVar;
        this.mViewPager.setAdapter(cVar);
        this.mTabStrip.setViewPager(this.mViewPager);
        registerListener(this.mNetworkChangedMessageListener);
        d.b.j0.q3.i.c cVar2 = this.mICloudMusicPresenter;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mICloudMusicPresenter.cancelLoadData();
        MusicPlayer.c().f();
        d.b.j0.q3.j.f.a.h().d();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicPlayer.c().d();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        d.b.j0.q3.j.f.a.h().e();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicPlayer.c().g();
    }

    @Override // d.b.j0.q3.i.d
    public void setPresenter(d.b.j0.q3.i.c cVar) {
        this.mICloudMusicPresenter = cVar;
    }

    @Override // d.b.j0.q3.i.d
    public void showCloudMusicWithTagData(CloudMusicData cloudMusicData) {
        this.mFragments = new ArrayList(cloudMusicData.tag_list.size());
        this.mTitles = new ArrayList(cloudMusicData.tag_list.size());
        for (int i = 0; i < cloudMusicData.tag_list.size(); i++) {
            this.mTitles.add(cloudMusicData.tag_list.get(i).name);
            this.mFragments.add(CloudMusicListFragment.G0(cloudMusicData.music_tag_list.get(i)));
        }
        this.mCloudMusicPageAdapter.notifyDataSetChanged();
        this.mTabStrip.m();
    }
}
