package com.baidu.tieba.person.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bGh = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bGi = {i.h.info_privacy_all, i.h.info_privacy_friend, i.h.info_privacy_hide};
    private static final int[] bGj = {1, 2, 3};
    private int[] bGa;
    private String bGc;
    private ImageView bGd;
    private FragmentTabHost beK;
    private String csN;
    private f csO;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String wq;
    private int bFZ = -1;
    int bGb = 0;
    private boolean isHost = false;
    private View mBack = null;
    HttpMessageListener csP = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.i.iN()) {
            showToast(i.h.neterror);
        }
        setContentView(i.g.person_post_activity);
        this.csN = getIntent().getStringExtra(PersonPostActivityConfig.KEY_PORTRAIT_URL);
        this.wq = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.wq = this.wq == null ? "" : this.wq;
        if (this.wq.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bGc = getPageContext().getString(i.h.me);
            this.isHost = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.bGc = getPageContext().getString(i.h.he);
                    break;
                case 2:
                    this.bGc = getPageContext().getString(i.h.she);
                    break;
                default:
                    this.bGc = getPageContext().getString(i.h.ta);
                    break;
            }
        }
        if (this.wq == null) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.csP);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.csO != null) {
            int count = this.csO.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.csO.getItem(i3);
                if (item instanceof u) {
                    ((u) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getPageContext().getString(i.h.person_post), this.bGc));
        this.mBack = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.mBack.setOnClickListener(new d(this));
        if (this.isHost) {
            this.bGd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            an.c(this.bGd, bGh[com.baidu.tbadk.core.a.h.br(4) - 1]);
            this.bGd.setOnClickListener(new e(this));
        }
        this.bGa = new int[]{0, 1};
        this.csO = new f(this);
        this.beK = (FragmentTabHost) findViewById(i.f.tab_host);
        this.beK.setup(getSupportFragmentManager());
        this.beK.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.beK.setOnPageChangeListener(this);
        WY();
        if (bundle != null) {
            this.bFZ = bundle.getInt("CurrTabIndex");
        } else {
            this.bFZ = 0;
        }
        this.beK.setCurrentTab(this.bFZ);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YK = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.atC = i.c.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YJ = fragmentTabIndicator;
            this.beK.a(bVar);
        }
    }

    private void WY() {
        if (this.csO != null) {
            int count = this.csO.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.csO.getItem(i);
                int hI = this.csO.hI(i);
                if (item != null) {
                    if (hI == 0) {
                        a(item, 0, String.format(getPageContext().getString(i.h.person_post_thread), this.bGc));
                    } else if (hI == 1) {
                        a(item, 1, String.format(getPageContext().getString(i.h.person_post_reply), this.bGc));
                    }
                }
            }
            this.beK.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public String getUid() {
        return this.wq;
    }

    public String Xa() {
        return this.bGc;
    }

    public String getPortraitUrl() {
        return this.csN;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bFZ);
        super.onSaveInstanceState(bundle);
    }

    public String ajx() {
        if (this.isHost) {
            return getPageContext().getString(i.h.person_post_lv_empty_host);
        }
        return String.format(getPageContext().getString(i.h.person_post_lv_empty_guest), Xa());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bFZ) {
            this.bFZ = i;
            if (this.bGa[i] == 0) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bGa[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), this.isHost ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.beK.onChangeSkinType(i);
        an.i(this.beK, i.c.cp_bg_line_c);
        if (this.csO != null) {
            int count = this.csO.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.csO.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.csO != null) {
            u ajy = this.csO.ajy();
            ab ajD = ajy != null ? ajy.ajD() : null;
            if (ajD != null) {
                return ajD.getBdListView();
            }
            return null;
        }
        return null;
    }
}
