package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bfK = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] bfL = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] bfM = {1, 2, 3};
    private int JW;
    private d bBc;
    private int[] bfC;
    private String bfE;
    private ImageView bfG;
    private FragmentTabHost bfN;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bfB = -1;
    private int bfD = 0;
    private boolean mIsHost = false;
    private boolean bBb = false;
    HttpMessageListener bBd = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract String Zs();

    public abstract String Zt();

    public abstract String Zu();

    public abstract String Zv();

    public abstract String Zw();

    public abstract String Zy();

    public abstract int Zz();

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bfB = bundle.getInt("key_current_tab", 0);
            this.JW = bundle.getInt("tb_request_code", 0);
            this.bBb = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bfB = getIntent().getIntExtra("key_current_tab", 0);
            this.JW = getIntent().getIntExtra("tb_request_code", 0);
            this.bBb = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bfE = getString(com.baidu.tieba.y.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bfE = getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.bfE = getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.bfE = getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.l.aA(this.mUid)) {
            finish();
            return;
        }
        e(bundle);
        registerListener(this.bBd);
    }

    private void e(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.base_person_navigation_bar);
        if (this.bBb) {
            this.mNavigationBar.setTitleText(com.baidu.tieba.y.share_choose_bar_title);
        } else {
            this.mNavigationBar.setTitleText(String.format(Zs(), this.bfE));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.JW != 23003 && !this.bBb) {
            this.bfG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.aw.c(this.bfG, bfK[com.baidu.tbadk.core.account.o.aL(Zz()) - 1]);
            this.bfG.setOnClickListener(new c(this));
        }
        this.bfC = new int[]{0, 1};
        this.bBc = a(this, this.mIsHost);
        this.bfN = (FragmentTabHost) findViewById(com.baidu.tieba.v.base_person_tab_host);
        this.bfN.setup(getSupportFragmentManager());
        this.bfN.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfN.setOnPageChangeListener(this);
        this.bfN.reset();
        QT();
        if (this.mIsHost) {
            this.bfN.getFragmentTabWidget().setVisibility(8);
        }
        this.bfN.setCurrentTab(this.bfB);
    }

    private void QT() {
        if (this.bBc != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.bBc.getItem(i2);
                int gf = this.bBc.gf(i2);
                String Zt = Zt();
                if (gf == 1) {
                    Zt = Zu();
                }
                if (item != null) {
                    a(item, gf, Zt);
                }
            }
            this.bfN.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.Cz = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.VR = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.Cy = fragmentTabIndicator;
            this.bfN.a(bVar);
        }
    }

    public void P(int i, int i2) {
        if (!this.mIsHost && this.bBc != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bfN.bk(0).Cy;
            if (i <= 0) {
                fragmentTabIndicator.setText(Zt());
            } else {
                fragmentTabIndicator.setText(String.format(Zv(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bfN.bk(1).Cy;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(Zu());
            } else {
                fragmentTabIndicator2.setText(String.format(Zw(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String QV() {
        return this.bfE;
    }

    public boolean Az() {
        return this.mIsHost;
    }

    public boolean Zx() {
        return this.bBb;
    }

    public int QU() {
        return this.bfB == 0 ? 0 : 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.bBb) {
                com.baidu.tbadk.core.b.b.a(this, Constants.MEDIA_INFO, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bfB);
        if (this.bBb) {
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
        if (i >= 0 && i < 2 && i != this.bfB) {
            this.bfB = i;
            if (!this.mIsHost && this.bfC[i] == 1) {
                TiebaStatic.eventStat(this, Zy(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bfN.onChangeSkinType(i);
        if (this.bBc != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.bBc.getCount()) {
                    Fragment item = this.bBc.getItem(i3);
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
