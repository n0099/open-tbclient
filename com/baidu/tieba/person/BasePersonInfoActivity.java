package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bZa = {n.f.icon_pop_key_all_bg, n.f.icon_pop_key_f_bg, n.f.icon_pop_key_d_bg};
    private static final int[] bZb = {n.j.info_privacy_all, n.j.info_privacy_friend, n.j.info_privacy_hide};
    private static final int[] bZc = {1, 2, 3};
    private int[] bYT;
    private String bYV;
    private ImageView bYW;
    private FragmentTabHost bpf;
    private e cNc;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wy;
    private int bYS = -1;
    private int bYU = 0;
    private boolean mIsHost = false;
    private int cMZ = 0;
    protected boolean cNa = false;
    protected String cNb = "";
    HttpMessageListener cNd = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract e a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String aok();

    public abstract String aol();

    public abstract String aom();

    public abstract String aon();

    public abstract String aoo();

    public abstract String aos();

    public abstract int aot();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.activity_base_person_info);
        if (bundle != null) {
            this.wy = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.cMZ = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bYS = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.cNa = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cNb = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wy = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bYS = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.cNa = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cMZ = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cNb = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wy = this.wy == null ? "" : this.wy;
        if (this.wy.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bYV = getPageContext().getString(n.j.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bYV = getPageContext().getString(n.j.he);
                    break;
                case 2:
                    this.bYV = getPageContext().getString(n.j.she);
                    break;
                default:
                    this.bYV = getPageContext().getString(n.j.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wy)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.cNd);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(n.g.base_person_navigation_bar);
        if (this.cNa) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(n.j.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(n.j.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(aok(), this.bYV));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.cNa) {
            this.bYW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.as.c(this.bYW, bZa[com.baidu.tbadk.core.a.h.bn(aot()) - 1]);
            this.bYW.setOnClickListener(new d(this));
        }
        this.bYT = new int[]{0, 1};
        this.cNc = a(this, this.mIsHost);
        this.bpf = (FragmentTabHost) findViewById(n.g.base_person_tab_host);
        this.bpf.setup(getSupportFragmentManager());
        this.bpf.setTabWidgetBackgroundColor(getResources().getColor(n.d.maintab_bg));
        this.bpf.setOnPageChangeListener(this);
        this.bpf.reset();
        abk();
        if (this.mIsHost) {
            this.bpf.getTabWrapper().setVisibility(8);
        }
        this.bpf.setCurrentTab(this.bYS);
    }

    private void abk() {
        if (this.cNc != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.cNc.getItem(i2);
                int iV = this.cNc.iV(i2);
                String aol = aol();
                if (iV == 1) {
                    aol = aom();
                }
                if (item != null) {
                    a(item, iV, aol);
                }
            }
            this.bpf.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aaa = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.axk = n.d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(n.e.fontsize32));
            cVar.ZZ = fragmentTabIndicator;
            this.bpf.a(cVar);
        }
    }

    public void ax(int i, int i2) {
        if (!this.mIsHost && this.cNc != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bpf.cf(0).ZZ;
            if (i <= 0) {
                fragmentTabIndicator.setText(aol());
            } else {
                fragmentTabIndicator.setText(String.format(aon(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bpf.cf(1).ZZ;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(aom());
            } else {
                fragmentTabIndicator2.setText(String.format(aoo(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wy;
    }

    public int getSex() {
        return this.mSex;
    }

    public String abm() {
        return this.bYV;
    }

    public boolean abn() {
        return this.mIsHost;
    }

    public boolean aop() {
        return this.cNa;
    }

    public int abl() {
        return this.bYS == 0 ? 0 : 1;
    }

    public int aoq() {
        return this.cMZ;
    }

    public String aor() {
        return this.cNb;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.cNa && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bYS);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.cMZ);
        if (this.cNa && this.requestCode != 23011) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.bYS) {
            this.bYS = i;
            if (!this.mIsHost && this.bYT[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), aos(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bpf.onChangeSkinType(i);
        if (this.cNc != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.cNc.getCount()) {
                    Fragment item = this.cNc.getItem(i3);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).onChangeSkinType(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
