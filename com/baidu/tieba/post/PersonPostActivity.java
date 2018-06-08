package com.baidu.tieba.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.PersonPolymericActivityStatic;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
/* loaded from: classes3.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, VoiceManager.c, b, d {
    private FragmentTabHost aoi;
    private NoNetworkView btu;
    protected VoiceManager dhB;
    private int[] erY;
    private String esa;
    private RelativeLayout gel;
    private ImageView gem;
    private ImageView gen;
    private PersonPostAdapter gep;
    private NavigationBar mNavigationBar;
    private String mPortraitUrl;
    private int mSex;
    private int mSkinType;
    private String mUid;
    private int bDW = -1;
    int erZ = 0;
    private boolean isHost = false;
    private View aAn = null;
    private final CustomMessageListener geq = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.post.PersonPostActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    ay.zG().c(PersonPostActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bjS();
        if (!com.baidu.adp.lib.util.j.jD()) {
            showToast(d.k.neterror);
        }
        setContentView(d.i.person_post_activity);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onCreate(getPageContext());
        }
        this.mPortraitUrl = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.esa = getPageContext().getString(d.k.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.esa = getPageContext().getString(d.k.he);
                    break;
                case 2:
                    this.esa = getPageContext().getString(d.k.she);
                    break;
                default:
                    this.esa = getPageContext().getString(d.k.ta);
                    break;
            }
        }
        TbadkCoreApplication.isMyLive = false;
        if (this.mUid == null) {
            finish();
        } else {
            r(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gep != null) {
            int count = this.gep.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.gep.getItem(i3);
                if (item instanceof PersonThreadFragment) {
                    ((PersonThreadFragment) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void r(Bundle bundle) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.text_post));
        this.aAn = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.aAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.finish();
            }
        });
        this.gel = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.person_post_naviagtion_bar_recycle_bin, (View.OnClickListener) null);
        this.gel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonPostActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.post.PersonPostActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonPostActivity.this.lD(false);
                ay.zG().c(PersonPostActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/pmc"});
            }
        });
        this.gem = (ImageView) this.gel.findViewById(d.g.iv_recycle_bin);
        this.gen = (ImageView) this.gel.findViewById(d.g.iv_recycle_bin_red_tip);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false)) {
            this.gen.setVisibility(0);
        } else {
            this.gen.setVisibility(8);
        }
        this.btu = (NoNetworkView) findViewById(d.g.person_post_no_network_view);
        this.erY = new int[]{0, 1};
        this.gep = new PersonPostAdapter(this);
        this.aoi = (FragmentTabHost) findViewById(d.g.tab_host);
        this.aoi.setup(getSupportFragmentManager());
        this.aoi.setOnPageChangeListener(this);
        this.aoi.setTabWidgetViewHeight((int) getResources().getDimension(d.e.ds100));
        this.aoi.getFragmentTabWidget().setDviderRectWidth(com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds64));
        RO();
        ((RelativeLayout.LayoutParams) this.aoi.getTabWrapper().getLayoutParams()).setMargins(0, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds88), 0, 0);
        if (bundle != null) {
            this.bDW = bundle.getInt("CurrTabIndex");
        } else {
            this.bDW = 0;
        }
        this.aoi.setCurrentTab(this.bDW);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.anN = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aQD = d.C0141d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            bVar.anM = fragmentTabIndicator;
            this.aoi.a(bVar);
        }
    }

    private void RO() {
        if (this.gep != null) {
            int count = this.gep.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.gep.getItem(i);
                int of = this.gep.of(i);
                if (item != null) {
                    if (of == 0) {
                        a(item, 0, getPageContext().getString(d.k.person_post_thread_new));
                    } else if (of == 1) {
                        a(item, 1, getPageContext().getString(d.k.reply));
                    }
                }
            }
            this.aoi.xT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().registerListener(this.geq);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.geq);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
        try {
            PersonPolymericActivityStatic.bjS();
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String aLf() {
        return this.esa;
    }

    public String getPortraitUrl() {
        return this.mPortraitUrl;
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bDW);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onSaveInstanceState(getPageContext().getPageActivity());
        }
        super.onSaveInstanceState(bundle);
    }

    public String bmo() {
        if (this.isHost) {
            return getPageContext().getString(d.k.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(d.k.person_post_lv_empty_guest), aLf());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bDW) {
            this.bDW = i;
            if (this.erY[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.erY[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.btu.onChangeSkinType(getPageContext(), i);
        this.aoi.setNeedShowThemeStyle(false);
        this.aoi.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.aoi.onChangeSkinType(i);
        al.a(this.gem, d.f.icon_recycle_bin_w, d.f.icon_recycle_bin);
        this.gen.setImageDrawable(al.v(i, d.f.person_center_red_tip_shape));
        if (this.gep != null) {
            int count = this.gep.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.gep.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.gep != null) {
            PersonThreadFragment bmp = this.gep.bmp();
            h bms = bmp != null ? bmp.bms() : null;
            if (bms == null || bms.bmz() == null) {
                return null;
            }
            return bms.bmz().getPreLoadHandle();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    private void bjS() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aN("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.post.d
    public void bmn() {
        if (this.gep != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gep.getCount()) {
                    if (this.gep.getItem(i2) instanceof c) {
                        ((c) this.gep.getItem(i2)).bmm();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.post.b
    public void lD(boolean z) {
        if (this.gen != null) {
            if (z && this.gen.getVisibility() == 8) {
                this.gen.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), true);
            } else if (!z && this.gen.getVisibility() == 0) {
                this.gen.setVisibility(8);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
            }
        }
    }
}
