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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CloudMusicActivity extends BaseFragmentActivity implements d.b {
    private NoNetworkView bga;
    private BdBaseViewPager ckB;
    private CommonPagerSlidingTabStrip ckE;
    private List<String> ckI;
    private d.a gtZ;
    private List<BaseFragment> gua;
    private a gub;
    private NavigationBar mNavigationBar;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.hh() && CloudMusicActivity.this.gtZ != null) {
                CloudMusicActivity.this.gtZ.bvx();
            }
        }
    };
    private f mNoDataView;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.activity_cloud_music);
        new c(new CloudMusicModel(getPageContext()), this);
        this.mRootView = findViewById(d.h.cloud_music_activity_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.navigation_bar);
        this.bga = (NoNetworkView) findViewById(d.h.no_network_view);
        this.bga.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        aj.i(this.mNavigationBar.setCenterTextTitle(getString(d.l.music_cloud)), d.e.cp_cont_b);
        this.mNavigationBar.setmBackImageViewBg(d.g.icon_nav_close, d.g.icon_nav_close_w);
        aj.c(this.mNavigationBar.getBackImageView(), d.g.icon_nav_close);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudMusicActivity.this.finish();
            }
        });
        if (j.gV()) {
            this.bga.setVisibility(8);
        } else {
            this.bga.setVisibility(0);
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getPageContext().getPageActivity(), d.f.ds200)), NoDataViewFactory.d.dq(d.l.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ckE = (CommonPagerSlidingTabStrip) findViewById(d.h.cloud_music_nav);
        this.ckE.a(l.f(getPageContext().getPageActivity(), d.f.ds30), l.f(getPageContext().getPageActivity(), d.f.ds24), l.f(getPageContext().getPageActivity(), d.f.ds16), l.f(getPageContext().getPageActivity(), d.f.ds24), l.f(getPageContext().getPageActivity(), d.f.ds20), l.f(getPageContext().getPageActivity(), d.f.ds4), l.f(getPageContext().getPageActivity(), d.f.ds64), d.e.cp_cont_j, d.e.cp_cont_b);
        this.ckB = (BdBaseViewPager) findViewById(d.h.cloud_music_view_pager);
        this.ckB.setOffscreenPageLimit(2);
        this.gub = new a(getSupportFragmentManager());
        this.ckB.setAdapter(this.gub);
        this.ckE.setViewPager(this.ckB);
        registerListener(this.mNetworkChangedMessageListener);
        if (this.gtZ != null) {
            this.gtZ.bvx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().ai(i == 1);
        if (this.ckE != null) {
            this.ckE.onChangeSkinType(i);
        }
        aj.k(this.mRootView, d.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.gtZ = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mY(boolean z) {
        if (z && this.mRootView != null) {
            showLoadingView(this.mRootView, false, l.f(getPageContext().getPageActivity(), d.f.ds400));
        } else {
            hideLoadingView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(CloudMusicData cloudMusicData) {
        this.gua = new ArrayList(cloudMusicData.tag_list.size());
        this.ckI = new ArrayList(cloudMusicData.tag_list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cloudMusicData.tag_list.size()) {
                this.ckI.add(cloudMusicData.tag_list.get(i2).name);
                this.gua.add(com.baidu.tieba.video.cloudmusic.a.a(cloudMusicData.music_tag_list.get(i2)));
                i = i2 + 1;
            } else {
                this.gub.notifyDataSetChanged();
                this.ckE.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mZ(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bvS().bvT();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicPlayer.bvy().bvz();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicPlayer.bvy().bvA();
    }

    /* loaded from: classes2.dex */
    private class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (!v.u(CloudMusicActivity.this.gua)) {
                return CloudMusicActivity.this.gua.size();
            }
            return 0;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (!v.u(CloudMusicActivity.this.gua) && CloudMusicActivity.this.gua.size() > i) {
                com.baidu.tieba.video.cloudmusic.a aVar = (com.baidu.tieba.video.cloudmusic.a) CloudMusicActivity.this.gua.get(i);
                new b(new CloudMusicListModel(CloudMusicActivity.this.getPageContext()), aVar);
                return aVar;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (!v.u(CloudMusicActivity.this.ckI)) {
                return (CharSequence) CloudMusicActivity.this.ckI.get(i);
            }
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gtZ.aiD();
        MusicPlayer.bvy().bem();
        com.baidu.tieba.video.editvideo.model.a.bvS().bvU();
    }
}
