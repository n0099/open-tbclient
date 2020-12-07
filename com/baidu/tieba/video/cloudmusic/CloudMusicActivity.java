package com.baidu.tieba.video.cloudmusic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class CloudMusicActivity extends BaseFragmentActivity implements c.b {
    private List<String> fHC;
    private BdBaseViewPager fhx;
    private NoNetworkView grd;
    private CommonPagerSlidingTabStrip iKy;
    private List<BaseFragment> mFragments;
    private NavigationBar mNavigationBar;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && CloudMusicActivity.this.nBC != null) {
                CloudMusicActivity.this.nBC.dTW();
            }
        }
    };
    private NoDataView mNoDataView;
    private View mRootView;
    private c.a nBC;
    private a nBD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_cloud_music);
        new b(new CloudMusicModel(getPageContext()), this);
        this.mRootView = findViewById(R.id.cloud_music_activity_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.grd = (NoNetworkView) findViewById(R.id.no_network_view);
        this.grd.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.music_cloud)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudMusicActivity.this.finish();
            }
        });
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.grd.setVisibility(8);
        } else {
            this.grd.setVisibility(0);
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds200)), NoDataViewFactory.d.qP(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iKy = (CommonPagerSlidingTabStrip) findViewById(R.id.cloud_music_nav);
        this.iKy.a(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds30), l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16), l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), l.getDimens(getPageContext().getPageActivity(), R.dimen.ds20), l.getDimens(getPageContext().getPageActivity(), R.dimen.ds4), l.getDimens(getPageContext().getPageActivity(), R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
        this.fhx = (BdBaseViewPager) findViewById(R.id.cloud_music_view_pager);
        this.fhx.setOffscreenPageLimit(2);
        this.nBD = new a(getSupportFragmentManager());
        this.fhx.setAdapter(this.nBD);
        this.iKy.setViewPager(this.fhx);
        registerListener(this.mNetworkChangedMessageListener);
        if (this.nBC != null) {
            this.nBC.dTW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iKy != null) {
            this.iKy.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void a(c.a aVar) {
        this.nBC = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void yD(boolean z) {
        if (z && this.mRootView != null) {
            showLoadingView(this.mRootView, false, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds400));
        } else {
            hideLoadingView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void a(CloudMusicData cloudMusicData) {
        this.mFragments = new ArrayList(cloudMusicData.tag_list.size());
        this.fHC = new ArrayList(cloudMusicData.tag_list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cloudMusicData.tag_list.size()) {
                this.fHC.add(cloudMusicData.tag_list.get(i2).name);
                this.mFragments.add(CloudMusicListFragment.a(cloudMusicData.music_tag_list.get(i2)));
                i = i2 + 1;
            } else {
                this.nBD.notifyDataSetChanged();
                this.iKy.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void yE(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dUA().dUB();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicPlayer.dTX().dTY();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicPlayer.dTX().dTZ();
    }

    /* loaded from: classes23.dex */
    private class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (!y.isEmpty(CloudMusicActivity.this.mFragments)) {
                return CloudMusicActivity.this.mFragments.size();
            }
            return 0;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (!y.isEmpty(CloudMusicActivity.this.mFragments) && CloudMusicActivity.this.mFragments.size() > i) {
                CloudMusicListFragment cloudMusicListFragment = (CloudMusicListFragment) CloudMusicActivity.this.mFragments.get(i);
                new com.baidu.tieba.video.cloudmusic.a(new CloudMusicListModel(CloudMusicActivity.this.getPageContext()), cloudMusicListFragment);
                return cloudMusicListFragment;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (!y.isEmpty(CloudMusicActivity.this.fHC)) {
                return (CharSequence) CloudMusicActivity.this.fHC.get(i);
            }
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nBC.cFg();
        MusicPlayer.dTX().bhc();
        com.baidu.tieba.video.editvideo.model.a.dUA().dUC();
    }
}
