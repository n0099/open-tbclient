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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.f;
import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CloudMusicActivity extends BaseFragmentActivity implements c.b {
    private BdBaseViewPager azN;
    private NoNetworkView bvB;
    private CommonPagerSlidingTabStrip daV;
    private List<String> daZ;
    private c.a hcn;
    private a hco;
    private List<BaseFragment> mFragments;
    private NavigationBar mNavigationBar;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jE() && CloudMusicActivity.this.hcn != null) {
                CloudMusicActivity.this.hcn.bAv();
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
        setContentView(f.h.activity_cloud_music);
        new b(new CloudMusicModel(getPageContext()), this);
        this.mRootView = findViewById(f.g.cloud_music_activity_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navigation_bar);
        this.bvB = (NoNetworkView) findViewById(f.g.no_network_view);
        this.bvB.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        am.h(this.mNavigationBar.setCenterTextTitle(getString(f.j.music_cloud)), f.d.cp_cont_b);
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.icon_nav_close, f.C0146f.icon_nav_close_w);
        am.c(this.mNavigationBar.getBackImageView(), f.C0146f.icon_nav_close);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudMusicActivity.this.finish();
            }
        });
        if (j.js()) {
            this.bvB.setVisibility(8);
        } else {
            this.bvB.setVisibility(0);
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getPageContext().getPageActivity(), f.e.ds200)), NoDataViewFactory.d.dt(f.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.daV = (CommonPagerSlidingTabStrip) findViewById(f.g.cloud_music_nav);
        this.daV.a(l.f(getPageContext().getPageActivity(), f.e.ds30), l.f(getPageContext().getPageActivity(), f.e.ds24), l.f(getPageContext().getPageActivity(), f.e.ds16), l.f(getPageContext().getPageActivity(), f.e.ds24), l.f(getPageContext().getPageActivity(), f.e.ds20), l.f(getPageContext().getPageActivity(), f.e.ds4), l.f(getPageContext().getPageActivity(), f.e.ds64), f.d.cp_cont_j, f.d.cp_cont_b);
        this.azN = (BdBaseViewPager) findViewById(f.g.cloud_music_view_pager);
        this.azN.setOffscreenPageLimit(2);
        this.hco = new a(getSupportFragmentManager());
        this.azN.setAdapter(this.hco);
        this.daV.setViewPager(this.azN);
        registerListener(this.mNetworkChangedMessageListener);
        if (this.hcn != null) {
            this.hcn.bAv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.daV != null) {
            this.daV.onChangeSkinType(i);
        }
        am.j(this.mRootView, f.d.cp_bg_line_d);
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
        this.hcn = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void mQ(boolean z) {
        if (z && this.mRootView != null) {
            showLoadingView(this.mRootView, false, l.f(getPageContext().getPageActivity(), f.e.ds400));
        } else {
            hideLoadingView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void a(CloudMusicData cloudMusicData) {
        this.mFragments = new ArrayList(cloudMusicData.tag_list.size());
        this.daZ = new ArrayList(cloudMusicData.tag_list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cloudMusicData.tag_list.size()) {
                this.daZ.add(cloudMusicData.tag_list.get(i2).name);
                this.mFragments.add(CloudMusicListFragment.a(cloudMusicData.music_tag_list.get(i2)));
                i = i2 + 1;
            } else {
                this.hco.notifyDataSetChanged();
                this.daV.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void mR(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBf().bBg();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicPlayer.bAw().bAx();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicPlayer.bAw().bAy();
    }

    /* loaded from: classes2.dex */
    private class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (!w.z(CloudMusicActivity.this.mFragments)) {
                return CloudMusicActivity.this.mFragments.size();
            }
            return 0;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (!w.z(CloudMusicActivity.this.mFragments) && CloudMusicActivity.this.mFragments.size() > i) {
                CloudMusicListFragment cloudMusicListFragment = (CloudMusicListFragment) CloudMusicActivity.this.mFragments.get(i);
                new com.baidu.tieba.video.cloudmusic.a(new CloudMusicListModel(CloudMusicActivity.this.getPageContext()), cloudMusicListFragment);
                return cloudMusicListFragment;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (!w.z(CloudMusicActivity.this.daZ)) {
                return (CharSequence) CloudMusicActivity.this.daZ.get(i);
            }
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hcn.awr();
        MusicPlayer.bAw().bko();
        com.baidu.tieba.video.editvideo.model.a.bBf().bBh();
    }
}
