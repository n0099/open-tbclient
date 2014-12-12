package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
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
    private static final int[] biX = {com.baidu.tieba.v.icon_pop_key_all, com.baidu.tieba.v.icon_pop_key_f, com.baidu.tieba.v.icon_pop_key_d};
    private static final int[] biY = {com.baidu.tieba.z.info_privacy_all, com.baidu.tieba.z.info_privacy_friend, com.baidu.tieba.z.info_privacy_hide};
    private static final int[] biZ = {1, 2, 3};
    private FragmentTabHost aIf;
    private d bEQ;
    private int[] biP;
    private String biR;
    private ImageView biT;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int requestCode;
    private int biO = -1;
    private int biQ = 0;
    private boolean mIsHost = false;
    private int bEO = 0;
    private boolean bEP = false;
    HttpMessageListener bER = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract String ZM();

    public abstract String ZN();

    public abstract String ZO();

    public abstract String ZP();

    public abstract String ZQ();

    public abstract String ZT();

    public abstract int ZU();

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.bEO = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.biO = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.bEP = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.biO = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.bEP = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.bEO = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.biR = getPageContext().getString(com.baidu.tieba.z.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.biR = getPageContext().getString(com.baidu.tieba.z.he);
                    break;
                case 2:
                    this.biR = getPageContext().getString(com.baidu.tieba.z.she);
                    break;
                default:
                    this.biR = getPageContext().getString(com.baidu.tieba.z.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.bER);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.base_person_navigation_bar);
        if (this.bEP) {
            this.mNavigationBar.setTitleText(com.baidu.tieba.z.share_choose_bar_title);
        } else {
            this.mNavigationBar.setTitleText(String.format(ZM(), this.biR));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.bEP) {
            this.biT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.ax.c(this.biT, biX[com.baidu.tbadk.core.account.o.bh(ZU()) - 1]);
            this.biT.setOnClickListener(new c(this));
        }
        this.biP = new int[]{0, 1};
        this.bEQ = a(this, this.mIsHost);
        this.aIf = (FragmentTabHost) findViewById(com.baidu.tieba.w.base_person_tab_host);
        this.aIf.setup(getSupportFragmentManager());
        this.aIf.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.t.maintab_bg));
        this.aIf.setOnPageChangeListener(this);
        this.aIf.reset();
        Rs();
        if (this.mIsHost) {
            this.aIf.getFragmentTabWidget().setVisibility(8);
        }
        this.aIf.setCurrentTab(this.biO);
    }

    private void Rs() {
        if (this.bEQ != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.bEQ.getItem(i2);
                int go = this.bEQ.go(i2);
                String ZN = ZN();
                if (go == 1) {
                    ZN = ZO();
                }
                if (item != null) {
                    a(item, go, ZN);
                }
            }
            this.aIf.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.GI = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.abR = com.baidu.tieba.t.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.u.fontsize32));
            bVar.GH = fragmentTabIndicator;
            this.aIf.a(bVar);
        }
    }

    public void X(int i, int i2) {
        if (!this.mIsHost && this.bEQ != null) {
            FragmentTabIndicator fragmentTabIndicator = this.aIf.bH(0).GH;
            if (i <= 0) {
                fragmentTabIndicator.setText(ZN());
            } else {
                fragmentTabIndicator.setText(String.format(ZP(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.aIf.bH(1).GH;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(ZO());
            } else {
                fragmentTabIndicator2.setText(String.format(ZQ(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String Ru() {
        return this.biR;
    }

    public boolean Rv() {
        return this.mIsHost;
    }

    public boolean ZR() {
        return this.bEP;
    }

    public int Rt() {
        return this.biO == 0 ? 0 : 1;
    }

    public int ZS() {
        return this.bEO;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.bEP) {
                com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
                MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.biO);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.bEO);
        if (this.bEP) {
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
        if (i >= 0 && i < 2 && i != this.biO) {
            this.biO = i;
            if (!this.mIsHost && this.biP[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), ZT(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aIf.onChangeSkinType(i);
        if (this.bEQ != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.bEQ.getCount()) {
                    Fragment item = this.bEQ.getItem(i3);
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
