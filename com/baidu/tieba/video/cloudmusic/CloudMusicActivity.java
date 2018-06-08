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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CloudMusicActivity extends BaseFragmentActivity implements c.b {
    private BdBaseViewPager azf;
    private NoNetworkView btu;
    private CommonPagerSlidingTabStrip daf;
    private List<String> daj;
    private c.a gWU;
    private a gWV;
    private List<BaseFragment> mFragments;
    private NavigationBar mNavigationBar;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jD() && CloudMusicActivity.this.gWU != null) {
                CloudMusicActivity.this.gWU.bBi();
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
        setContentView(d.i.activity_cloud_music);
        new b(new CloudMusicModel(getPageContext()), this);
        this.mRootView = findViewById(d.g.cloud_music_activity_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.btu = (NoNetworkView) findViewById(d.g.no_network_view);
        this.btu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        al.h(this.mNavigationBar.setCenterTextTitle(getString(d.k.music_cloud)), d.C0141d.cp_cont_b);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_nav_close, d.f.icon_nav_close_w);
        al.c(this.mNavigationBar.getBackImageView(), d.f.icon_nav_close);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudMusicActivity.this.finish();
            }
        });
        if (j.jr()) {
            this.btu.setVisibility(8);
        } else {
            this.btu.setVisibility(0);
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getPageContext().getPageActivity(), d.e.ds200)), NoDataViewFactory.d.dr(d.k.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.daf = (CommonPagerSlidingTabStrip) findViewById(d.g.cloud_music_nav);
        this.daf.a(l.e(getPageContext().getPageActivity(), d.e.ds30), l.e(getPageContext().getPageActivity(), d.e.ds24), l.e(getPageContext().getPageActivity(), d.e.ds16), l.e(getPageContext().getPageActivity(), d.e.ds24), l.e(getPageContext().getPageActivity(), d.e.ds20), l.e(getPageContext().getPageActivity(), d.e.ds4), l.e(getPageContext().getPageActivity(), d.e.ds64), d.C0141d.cp_cont_j, d.C0141d.cp_cont_b);
        this.azf = (BdBaseViewPager) findViewById(d.g.cloud_music_view_pager);
        this.azf.setOffscreenPageLimit(2);
        this.gWV = new a(getSupportFragmentManager());
        this.azf.setAdapter(this.gWV);
        this.daf.setViewPager(this.azf);
        registerListener(this.mNetworkChangedMessageListener);
        if (this.gWU != null) {
            this.gWU.bBi();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.daf != null) {
            this.daf.onChangeSkinType(i);
        }
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
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
        this.gWU = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void mW(boolean z) {
        if (z && this.mRootView != null) {
            showLoadingView(this.mRootView, false, l.e(getPageContext().getPageActivity(), d.e.ds400));
        } else {
            hideLoadingView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void a(CloudMusicData cloudMusicData) {
        this.mFragments = new ArrayList(cloudMusicData.tag_list.size());
        this.daj = new ArrayList(cloudMusicData.tag_list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cloudMusicData.tag_list.size()) {
                this.daj.add(cloudMusicData.tag_list.get(i2).name);
                this.mFragments.add(CloudMusicListFragment.a(cloudMusicData.music_tag_list.get(i2)));
                i = i2 + 1;
            } else {
                this.gWV.notifyDataSetChanged();
                this.daf.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.b
    public void mX(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBS().bBT();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicPlayer.bBj().bBk();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicPlayer.bBj().bBl();
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
            if (!w.z(CloudMusicActivity.this.daj)) {
                return (CharSequence) CloudMusicActivity.this.daj.get(i);
            }
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gWU.avk();
        MusicPlayer.bBj().blv();
        com.baidu.tieba.video.editvideo.model.a.bBS().bBU();
    }
}
