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
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bku = {com.baidu.tieba.v.icon_pop_key_all, com.baidu.tieba.v.icon_pop_key_f, com.baidu.tieba.v.icon_pop_key_d};
    private static final int[] bkv = {com.baidu.tieba.z.info_privacy_all, com.baidu.tieba.z.info_privacy_friend, com.baidu.tieba.z.info_privacy_hide};
    private static final int[] bkw = {1, 2, 3};
    private FragmentTabHost aJp;
    private d bGB;
    private int[] bkm;
    private String bko;
    private ImageView bkq;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private int bkl = -1;
    private int bkn = 0;
    private boolean mIsHost = false;
    private int bGz = 0;
    private boolean bGA = false;
    HttpMessageListener bGC = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String aar();

    public abstract String aas();

    public abstract String aat();

    public abstract String aau();

    public abstract String aav();

    public abstract String aay();

    public abstract int aaz();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bGz = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bkl = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.bGA = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bkl = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.bGA = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.bGz = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bko = getPageContext().getString(com.baidu.tieba.z.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bko = getPageContext().getString(com.baidu.tieba.z.he);
                    break;
                case 2:
                    this.bko = getPageContext().getString(com.baidu.tieba.z.she);
                    break;
                default:
                    this.bko = getPageContext().getString(com.baidu.tieba.z.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bGC);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.base_person_navigation_bar);
        if (this.bGA) {
            this.mNavigationBar.setTitleText(com.baidu.tieba.z.share_choose_bar_title);
        } else {
            this.mNavigationBar.setTitleText(String.format(aar(), this.bko));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.bGA) {
            this.bkq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.bc.c(this.bkq, bku[com.baidu.tbadk.core.account.o.bm(aaz()) - 1]);
            this.bkq.setOnClickListener(new c(this));
        }
        this.bkm = new int[]{0, 1};
        this.bGB = a(this, this.mIsHost);
        this.aJp = (FragmentTabHost) findViewById(com.baidu.tieba.w.base_person_tab_host);
        this.aJp.setup(getSupportFragmentManager());
        this.aJp.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.t.maintab_bg));
        this.aJp.setOnPageChangeListener(this);
        this.aJp.reset();
        RO();
        if (this.mIsHost) {
            this.aJp.getFragmentTabWidget().setVisibility(8);
        }
        this.aJp.setCurrentTab(this.bkl);
    }

    private void RO() {
        if (this.bGB != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.bGB.getItem(i2);
                int gx = this.bGB.gx(i2);
                String aas = aas();
                if (gx == 1) {
                    aas = aat();
                }
                if (item != null) {
                    a(item, gx, aas);
                }
            }
            this.aJp.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GS = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.aco = com.baidu.tieba.t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize32));
            bVar.GR = fragmentTabIndicator;
            this.aJp.a(bVar);
        }
    }

    public void Y(int i, int i2) {
        if (!this.mIsHost && this.bGB != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aJp.bM(0).GR;
            if (i <= 0) {
                fragmentTabIndicator.setText(aas());
            } else {
                fragmentTabIndicator.setText(String.format(aau(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aJp.bM(1).GR;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(aat());
            } else {
                fragmentTabIndicator2.setText(String.format(aav(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String RQ() {
        return this.bko;
    }

    public boolean RR() {
        return this.mIsHost;
    }

    public boolean aaw() {
        return this.bGA;
    }

    public int RP() {
        return this.bkl == 0 ? 0 : 1;
    }

    public int aax() {
        return this.bGz;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.bGA) {
                com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), 200, false);
                MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bkl);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.bGz);
        if (this.bGA) {
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
        if (i >= 0 && i < 2 && i != this.bkl) {
            this.bkl = i;
            if (!this.mIsHost && this.bkm[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), aay(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aJp.onChangeSkinType(i);
        if (this.bGB != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.bGB.getCount()) {
                    Fragment item = this.bGB.getItem(i3);
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
