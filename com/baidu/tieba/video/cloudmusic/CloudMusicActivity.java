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
    private NoNetworkView blt;
    private BdBaseViewPager cAN;
    private CommonPagerSlidingTabStrip cAQ;
    private List<String> cAU;
    private d.a gNt;
    private List<BaseFragment> gNu;
    private a gNv;
    private NavigationBar mNavigationBar;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.hh() && CloudMusicActivity.this.gNt != null) {
                CloudMusicActivity.this.gNt.bAH();
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
        setContentView(d.h.activity_cloud_music);
        new c(new CloudMusicModel(getPageContext()), this);
        this.mRootView = findViewById(d.g.cloud_music_activity_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.blt = (NoNetworkView) findViewById(d.g.no_network_view);
        this.blt.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        aj.i(this.mNavigationBar.setCenterTextTitle(getString(d.j.music_cloud)), d.C0082d.cp_cont_b);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_nav_close, d.f.icon_nav_close_w);
        aj.c(this.mNavigationBar.getBackImageView(), d.f.icon_nav_close);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudMusicActivity.this.finish();
            }
        });
        if (j.gV()) {
            this.blt.setVisibility(8);
        } else {
            this.blt.setVisibility(0);
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getPageContext().getPageActivity(), d.e.ds200)), NoDataViewFactory.d.dq(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cAQ = (CommonPagerSlidingTabStrip) findViewById(d.g.cloud_music_nav);
        this.cAQ.a(l.f(getPageContext().getPageActivity(), d.e.ds30), l.f(getPageContext().getPageActivity(), d.e.ds24), l.f(getPageContext().getPageActivity(), d.e.ds16), l.f(getPageContext().getPageActivity(), d.e.ds24), l.f(getPageContext().getPageActivity(), d.e.ds20), l.f(getPageContext().getPageActivity(), d.e.ds4), l.f(getPageContext().getPageActivity(), d.e.ds64), d.C0082d.cp_cont_j, d.C0082d.cp_cont_b);
        this.cAN = (BdBaseViewPager) findViewById(d.g.cloud_music_view_pager);
        this.cAN.setOffscreenPageLimit(2);
        this.gNv = new a(getSupportFragmentManager());
        this.cAN.setAdapter(this.gNv);
        this.cAQ.setViewPager(this.cAN);
        registerListener(this.mNetworkChangedMessageListener);
        if (this.gNt != null) {
            this.gNt.bAH();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().ag(i == 1);
        if (this.cAQ != null) {
            this.cAQ.onChangeSkinType(i);
        }
        aj.k(this.mRootView, d.C0082d.cp_bg_line_d);
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
        this.gNt = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nA(boolean z) {
        if (z && this.mRootView != null) {
            showLoadingView(this.mRootView, false, l.f(getPageContext().getPageActivity(), d.e.ds400));
        } else {
            hideLoadingView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(CloudMusicData cloudMusicData) {
        this.gNu = new ArrayList(cloudMusicData.tag_list.size());
        this.cAU = new ArrayList(cloudMusicData.tag_list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cloudMusicData.tag_list.size()) {
                this.cAU.add(cloudMusicData.tag_list.get(i2).name);
                this.gNu.add(com.baidu.tieba.video.cloudmusic.a.a(cloudMusicData.music_tag_list.get(i2)));
                i = i2 + 1;
            } else {
                this.gNv.notifyDataSetChanged();
                this.cAQ.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nB(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBs().bBt();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicPlayer.bAI().bAJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicPlayer.bAI().bAK();
    }

    /* loaded from: classes2.dex */
    private class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (!v.w(CloudMusicActivity.this.gNu)) {
                return CloudMusicActivity.this.gNu.size();
            }
            return 0;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (!v.w(CloudMusicActivity.this.gNu) && CloudMusicActivity.this.gNu.size() > i) {
                com.baidu.tieba.video.cloudmusic.a aVar = (com.baidu.tieba.video.cloudmusic.a) CloudMusicActivity.this.gNu.get(i);
                new b(new CloudMusicListModel(CloudMusicActivity.this.getPageContext()), aVar);
                return aVar;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (!v.w(CloudMusicActivity.this.cAU)) {
                return (CharSequence) CloudMusicActivity.this.cAU.get(i);
            }
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gNt.amU();
        MusicPlayer.bAI().bjf();
        com.baidu.tieba.video.editvideo.model.a.bBs().bBu();
    }
}
