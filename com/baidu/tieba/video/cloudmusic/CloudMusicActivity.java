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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.e;
import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CloudMusicActivity extends BaseFragmentActivity implements c.b {
    private BdBaseViewPager aIn;
    private NoNetworkView bKI;
    private CommonPagerSlidingTabStrip dpZ;
    private List<String> dqc;
    private c.a htf;
    private a htg;
    private List<BaseFragment> mFragments;
    private NavigationBar mNavigationBar;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV() && CloudMusicActivity.this.htf != null) {
                CloudMusicActivity.this.htf.bFX();
            }
        }
    };
    private NoDataView mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.activity_cloud_music);
        new b(new CloudMusicModel(getPageContext()), this);
        this.mRootView = findViewById(e.g.cloud_music_activity_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.bKI = (NoNetworkView) findViewById(e.g.no_network_view);
        this.bKI.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        al.h(this.mNavigationBar.setCenterTextTitle(getString(e.j.music_cloud)), e.d.cp_cont_b);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_nav_close, e.f.icon_nav_close_w);
        al.c(this.mNavigationBar.getBackImageView(), e.f.icon_nav_close);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudMusicActivity.this.finish();
            }
        });
        if (j.kK()) {
            this.bKI.setVisibility(8);
        } else {
            this.bKI.setVisibility(0);
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getPageContext().getPageActivity(), e.C0200e.ds200)), NoDataViewFactory.d.ec(e.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dpZ = (CommonPagerSlidingTabStrip) findViewById(e.g.cloud_music_nav);
        this.dpZ.a(l.h(getPageContext().getPageActivity(), e.C0200e.ds30), l.h(getPageContext().getPageActivity(), e.C0200e.ds24), l.h(getPageContext().getPageActivity(), e.C0200e.ds16), l.h(getPageContext().getPageActivity(), e.C0200e.ds24), l.h(getPageContext().getPageActivity(), e.C0200e.ds20), l.h(getPageContext().getPageActivity(), e.C0200e.ds4), l.h(getPageContext().getPageActivity(), e.C0200e.ds64), e.d.cp_cont_j, e.d.cp_cont_b);
        this.aIn = (BdBaseViewPager) findViewById(e.g.cloud_music_view_pager);
        this.aIn.setOffscreenPageLimit(2);
        this.htg = new a(getSupportFragmentManager());
        this.aIn.setAdapter(this.htg);
        this.dpZ.setViewPager(this.aIn);
        registerListener(this.mNetworkChangedMessageListener);
        if (this.htf != null) {
            this.htf.bFX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.dpZ != null) {
            this.dpZ.onChangeSkinType(i);
        }
        al.j(this.mRootView, e.d.cp_bg_line_d);
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
        this.htf = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void nS(boolean z) {
        if (z && this.mRootView != null) {
            showLoadingView(this.mRootView, false, l.h(getPageContext().getPageActivity(), e.C0200e.ds400));
        } else {
            hideLoadingView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void a(CloudMusicData cloudMusicData) {
        this.mFragments = new ArrayList(cloudMusicData.tag_list.size());
        this.dqc = new ArrayList(cloudMusicData.tag_list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cloudMusicData.tag_list.size()) {
                this.dqc.add(cloudMusicData.tag_list.get(i2).name);
                this.mFragments.add(CloudMusicListFragment.a(cloudMusicData.music_tag_list.get(i2)));
                i = i2 + 1;
            } else {
                this.htg.notifyDataSetChanged();
                this.dpZ.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void nT(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bGH().bGI();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicPlayer.bFY().bFZ();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicPlayer.bFY().bGa();
    }

    /* loaded from: classes5.dex */
    private class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (!v.I(CloudMusicActivity.this.mFragments)) {
                return CloudMusicActivity.this.mFragments.size();
            }
            return 0;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (!v.I(CloudMusicActivity.this.mFragments) && CloudMusicActivity.this.mFragments.size() > i) {
                CloudMusicListFragment cloudMusicListFragment = (CloudMusicListFragment) CloudMusicActivity.this.mFragments.get(i);
                new com.baidu.tieba.video.cloudmusic.a(new CloudMusicListModel(CloudMusicActivity.this.getPageContext()), cloudMusicListFragment);
                return cloudMusicListFragment;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (!v.I(CloudMusicActivity.this.dqc)) {
                return (CharSequence) CloudMusicActivity.this.dqc.get(i);
            }
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.htf.aBt();
        MusicPlayer.bFY().TD();
        com.baidu.tieba.video.editvideo.model.a.bGH().bGJ();
    }
}
