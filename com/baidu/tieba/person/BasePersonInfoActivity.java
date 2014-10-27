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
    private static final int[] bfw = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] bfx = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] bfy = {1, 2, 3};
    private int JV;
    private d bAO;
    private int[] bfo;
    private String bfq;
    private ImageView bfs;
    private FragmentTabHost bfz;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bfn = -1;
    private int bfp = 0;
    private boolean mIsHost = false;
    private boolean bAN = false;
    HttpMessageListener bAP = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract String Zp();

    public abstract String Zq();

    public abstract String Zr();

    public abstract String Zs();

    public abstract String Zt();

    public abstract String Zv();

    public abstract int Zw();

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bfn = bundle.getInt("key_current_tab", 0);
            this.JV = bundle.getInt("tb_request_code", 0);
            this.bAN = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bfn = getIntent().getIntExtra("key_current_tab", 0);
            this.JV = getIntent().getIntExtra("tb_request_code", 0);
            this.bAN = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bfq = getString(com.baidu.tieba.y.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bfq = getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.bfq = getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.bfq = getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.l.aA(this.mUid)) {
            finish();
            return;
        }
        e(bundle);
        registerListener(this.bAP);
    }

    private void e(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.base_person_navigation_bar);
        if (this.bAN) {
            this.mNavigationBar.setTitleText(com.baidu.tieba.y.share_choose_bar_title);
        } else {
            this.mNavigationBar.setTitleText(String.format(Zp(), this.bfq));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.JV != 23003 && !this.bAN) {
            this.bfs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.aw.c(this.bfs, bfw[com.baidu.tbadk.core.account.o.aL(Zw()) - 1]);
            this.bfs.setOnClickListener(new c(this));
        }
        this.bfo = new int[]{0, 1};
        this.bAO = a(this, this.mIsHost);
        this.bfz = (FragmentTabHost) findViewById(com.baidu.tieba.v.base_person_tab_host);
        this.bfz.setup(getSupportFragmentManager());
        this.bfz.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfz.setOnPageChangeListener(this);
        this.bfz.reset();
        QQ();
        if (this.mIsHost) {
            this.bfz.getFragmentTabWidget().setVisibility(8);
        }
        this.bfz.setCurrentTab(this.bfn);
    }

    private void QQ() {
        if (this.bAO != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.bAO.getItem(i2);
                int gf = this.bAO.gf(i2);
                String Zq = Zq();
                if (gf == 1) {
                    Zq = Zr();
                }
                if (item != null) {
                    a(item, gf, Zq);
                }
            }
            this.bfz.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.Cy = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.VN = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.Cx = fragmentTabIndicator;
            this.bfz.a(bVar);
        }
    }

    public void P(int i, int i2) {
        if (!this.mIsHost && this.bAO != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bfz.bk(0).Cx;
            if (i <= 0) {
                fragmentTabIndicator.setText(Zq());
            } else {
                fragmentTabIndicator.setText(String.format(Zs(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bfz.bk(1).Cx;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(Zr());
            } else {
                fragmentTabIndicator2.setText(String.format(Zt(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String QS() {
        return this.bfq;
    }

    public boolean Ax() {
        return this.mIsHost;
    }

    public boolean Zu() {
        return this.bAN;
    }

    public int QR() {
        return this.bfn == 0 ? 0 : 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.bAN) {
                com.baidu.tbadk.core.b.b.a(this, Constants.MEDIA_INFO, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bfn);
        if (this.bAN) {
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
        if (i >= 0 && i < 2 && i != this.bfn) {
            this.bfn = i;
            if (!this.mIsHost && this.bfo[i] == 1) {
                TiebaStatic.eventStat(this, Zv(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bfz.onChangeSkinType(i);
        if (this.bAO != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.bAO.getCount()) {
                    Fragment item = this.bAO.getItem(i3);
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
