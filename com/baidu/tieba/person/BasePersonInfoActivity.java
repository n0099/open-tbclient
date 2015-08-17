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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bBQ = {i.e.icon_pop_key_all, i.e.icon_pop_key_f, i.e.icon_pop_key_d};
    private static final int[] bBR = {i.C0057i.info_privacy_all, i.C0057i.info_privacy_friend, i.C0057i.info_privacy_hide};
    private static final int[] bBS = {1, 2, 3};
    private int[] bBJ;
    private String bBL;
    private ImageView bBM;
    private FragmentTabHost bdl;
    private d chu;
    private NavigationBar mNavigationBar;
    private int mSex;
    protected int requestCode;
    private String wr;
    private int bBI = -1;
    private int bBK = 0;
    private boolean mIsHost = false;
    private int chr = 0;
    protected boolean chs = false;
    protected String cht = "";
    HttpMessageListener chv = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String afF();

    public abstract String afG();

    public abstract String afH();

    public abstract String afI();

    public abstract String afJ();

    public abstract String afN();

    public abstract int afO();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.activity_base_person_info);
        if (bundle != null) {
            this.wr = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.chr = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bBI = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.chs = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.cht = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.wr = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bBI = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.chs = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.chr = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cht = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.wr = this.wr == null ? "" : this.wr;
        if (this.wr.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.bBL = getPageContext().getString(i.C0057i.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.bBL = getPageContext().getString(i.C0057i.he);
                    break;
                case 2:
                    this.bBL = getPageContext().getString(i.C0057i.she);
                    break;
                default:
                    this.bBL = getPageContext().getString(i.C0057i.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.j.isEmpty(this.wr)) {
            finish();
            return;
        }
        initUI(bundle);
        registerListener(this.chv);
    }

    private void initUI(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.base_person_navigation_bar);
        if (this.chs) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setTitleText(i.C0057i.live_choose_bar);
            } else {
                this.mNavigationBar.setTitleText(i.C0057i.share_choose_bar_title);
            }
        } else {
            this.mNavigationBar.setTitleText(String.format(afF(), this.bBL));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        if (this.mIsHost && this.requestCode != 23003 && !this.chs) {
            this.bBM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.al.c(this.bBM, bBQ[com.baidu.tbadk.core.a.h.br(afO()) - 1]);
            this.bBM.setOnClickListener(new c(this));
        }
        this.bBJ = new int[]{0, 1};
        this.chu = a(this, this.mIsHost);
        this.bdl = (FragmentTabHost) findViewById(i.f.base_person_tab_host);
        this.bdl.setup(getSupportFragmentManager());
        this.bdl.setTabWidgetBackgroundColor(getResources().getColor(i.c.maintab_bg));
        this.bdl.setOnPageChangeListener(this);
        this.bdl.reset();
        VW();
        if (this.mIsHost) {
            this.bdl.getTabWrapper().setVisibility(8);
        }
        this.bdl.setCurrentTab(this.bBI);
    }

    private void VW() {
        if (this.chu != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.chu.getItem(i2);
                int hf = this.chu.hf(i2);
                String afG = afG();
                if (hf == 1) {
                    afG = afH();
                }
                if (item != null) {
                    a(item, hf, afG);
                }
            }
            this.bdl.initViewPager();
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.YD = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.auG = i.c.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(i.d.fontsize32));
            bVar.YC = fragmentTabIndicator;
            this.bdl.a(bVar);
        }
    }

    public void ag(int i, int i2) {
        if (!this.mIsHost && this.chu != null) {
            FragmentTabIndicator fragmentTabIndicator = this.bdl.bY(0).YC;
            if (i <= 0) {
                fragmentTabIndicator.setText(afG());
            } else {
                fragmentTabIndicator.setText(String.format(afI(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.bdl.bY(1).YC;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(afH());
            } else {
                fragmentTabIndicator2.setText(String.format(afJ(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.wr;
    }

    public int getSex() {
        return this.mSex;
    }

    public String VY() {
        return this.bBL;
    }

    public boolean VZ() {
        return this.mIsHost;
    }

    public boolean afK() {
        return this.chs;
    }

    public int VX() {
        return this.bBI == 0 ? 0 : 1;
    }

    public int afL() {
        return this.chr;
    }

    public String afM() {
        return this.cht;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.chs && this.requestCode != 23011) {
                com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bBI);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.chr);
        if (this.chs && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bBI) {
            this.bBI = i;
            if (!this.mIsHost && this.bBJ[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), afN(), "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bdl.onChangeSkinType(i);
        if (this.chu != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.chu.getCount()) {
                    Fragment item = this.chu.getItem(i3);
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
