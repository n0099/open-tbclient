package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private FragmentTabHost bWN;
    private int[] eKJ;
    private String eKL;
    private ImageView eKM;
    private a gkm;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    protected int requestCode;
    private static final int[] eKQ = {d.f.icon_pop_key_all_bg, d.f.icon_pop_key_f_bg, d.f.icon_pop_key_d_bg};
    private static final int[] gkl = {d.f.icon_pop_key_all_bg_w, d.f.icon_pop_key_f_bg_w, d.f.icon_pop_key_d_bg_w};
    private static final int[] eKS = {d.j.info_privacy_all, d.j.info_privacy_friend, d.j.info_privacy_hide};
    private static final int[] eKT = {1, 2, 3};
    private int cla = -1;
    private int eKK = 0;
    private boolean mIsHost = false;
    private int gki = 0;
    protected boolean gkj = false;
    protected String gkk = "";
    HttpMessageListener gkn = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.f.at(BasePersonInfoActivity.this.biY(), BasePersonInfoActivity.eKT[BasePersonInfoActivity.this.eKK]);
                    aj.a(BasePersonInfoActivity.this.eKM, BasePersonInfoActivity.gkl[BasePersonInfoActivity.this.eKK], BasePersonInfoActivity.eKQ[BasePersonInfoActivity.this.eKK]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.eKS[BasePersonInfoActivity.this.eKK]), d.f.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(d.j.neterror));
        }
    };

    public abstract a a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String biP();

    public abstract String biQ();

    public abstract String biR();

    public abstract String biS();

    public abstract String biT();

    public abstract String biX();

    public abstract int biY();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.gki = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.cla = bundle.getInt("key_current_tab", 0);
            this.requestCode = bundle.getInt("tb_request_code", 0);
            this.gkj = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.gkk = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.cla = getIntent().getIntExtra("key_current_tab", 0);
            this.requestCode = getIntent().getIntExtra("tb_request_code", 0);
            this.gkj = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.gki = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.gkk = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.eKL = getPageContext().getString(d.j.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.eKL = getPageContext().getString(d.j.he);
                    break;
                case 2:
                    this.eKL = getPageContext().getString(d.j.she);
                    break;
                default:
                    this.eKL = getPageContext().getString(d.j.ta);
                    break;
            }
        }
        if (com.baidu.adp.lib.util.k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        t(bundle);
        registerListener(this.gkn);
    }

    private void t(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.base_person_navigation_bar);
        if (this.gkj) {
            if (this.requestCode == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(biP(), this.eKL));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.gkj && BasePersonInfoActivity.this.requestCode != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.e(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.requestCode != 23003 && !this.gkj) {
            this.eKM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_privacy, (View.OnClickListener) null);
            aj.a(this.eKM, gkl[com.baidu.tbadk.core.a.f.eB(biY()) - 1], eKQ[com.baidu.tbadk.core.a.f.eB(biY()) - 1]);
            this.eKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.eKK = com.baidu.tbadk.core.a.f.eB(BasePersonInfoActivity.this.biY()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.biY()) {
                        case 2:
                            str = "like";
                            break;
                        case 3:
                            str = "group";
                            break;
                        case 4:
                            str = "post";
                            break;
                        case 5:
                            str = "friend";
                            break;
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                    httpMessage.addParam("opt", str);
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.eKK + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.eKJ = new int[]{0, 1};
        this.gkm = a(this, this.mIsHost);
        this.bWN = (FragmentTabHost) findViewById(d.g.base_person_tab_host);
        this.bWN.setup(getSupportFragmentManager());
        this.bWN.setTabWidgetBackgroundColor(getResources().getColor(d.C0141d.common_color_10002));
        this.bWN.setOnPageChangeListener(this);
        this.bWN.reset();
        VQ();
        if (this.mIsHost) {
            this.bWN.getTabWrapper().setVisibility(8);
        }
        this.bWN.setCurrentTab(this.cla);
    }

    private void VQ() {
        if (this.gkm != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.gkm.getItem(i2);
                int qx = this.gkm.qx(i2);
                String biQ = biQ();
                if (qx == 1) {
                    biQ = biR();
                }
                if (item != null) {
                    a(item, qx, biQ);
                }
            }
            this.bWN.fw(3);
        }
    }

    public NavigationBar avj() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            cVar.aUn = fragment;
            cVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.bxF = d.C0141d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(l.t(getActivity(), d.e.ds88));
            cVar.aUm = fragmentTabIndicator;
            this.bWN.a(cVar);
        }
    }

    public void ce(int i, int i2) {
        if (!this.mIsHost && this.gkm != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.bWN.fz(0).aUm;
            if (i <= 0) {
                fragmentTabIndicator.setText(biQ());
            } else {
                fragmentTabIndicator.setText(String.format(biS(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.bWN.fz(1).aUm;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(biR());
            } else {
                fragmentTabIndicator2.setText(String.format(biT(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aLo() {
        return this.eKL;
    }

    public boolean aLp() {
        return this.mIsHost;
    }

    public boolean biU() {
        return this.gkj;
    }

    public int aLn() {
        return this.cla == 0 ? 0 : 1;
    }

    public int biV() {
        return this.gki;
    }

    public String biW() {
        return this.gkk;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.gkj && this.requestCode != 23011) {
                com.baidu.tbadk.core.e.b.e(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.cla);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.gki);
        if (this.gkj && this.requestCode != 23011) {
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
        if (i >= 0 && i < 2 && i != this.cla) {
            this.cla = i;
            if (!this.mIsHost && this.eKJ[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), biX(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bWN.onChangeSkinType(i);
        if (this.gkm != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.gkm.getCount()) {
                    Fragment item = this.gkm.getItem(i3);
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
