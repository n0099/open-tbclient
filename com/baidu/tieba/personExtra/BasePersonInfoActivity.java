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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private FragmentTabHost aoi;
    private int[] erY;
    private String esa;
    private ImageView esb;
    protected int ese;
    private BasePersonInfoAdapter fRv;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private static final int[] esg = {d.f.icon_pop_key_all_bg, d.f.icon_pop_key_f_bg, d.f.icon_pop_key_d_bg};
    private static final int[] fRu = {d.f.icon_pop_key_all_bg_w, d.f.icon_pop_key_f_bg_w, d.f.icon_pop_key_d_bg_w};
    private static final int[] esi = {d.k.info_privacy_all, d.k.info_privacy_friend, d.k.info_privacy_hide};
    private static final int[] esj = {1, 2, 3};
    private int bDW = -1;
    private int erZ = 0;
    private boolean mIsHost = false;
    private int fRr = 0;
    protected boolean fRs = false;
    protected String fRt = "";
    HttpMessageListener fRw = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.f.t(BasePersonInfoActivity.this.bja(), BasePersonInfoActivity.esj[BasePersonInfoActivity.this.erZ]);
                    al.a(BasePersonInfoActivity.this.esb, BasePersonInfoActivity.fRu[BasePersonInfoActivity.this.erZ], BasePersonInfoActivity.esg[BasePersonInfoActivity.this.erZ]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.esi[BasePersonInfoActivity.this.erZ]), d.f.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(d.k.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String biR();

    public abstract String biS();

    public abstract String biT();

    public abstract String biU();

    public abstract String biV();

    public abstract String biZ();

    public abstract int bja();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.fRr = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bDW = bundle.getInt("key_current_tab", 0);
            this.ese = bundle.getInt("tb_request_code", 0);
            this.fRs = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fRt = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bDW = getIntent().getIntExtra("key_current_tab", 0);
            this.ese = getIntent().getIntExtra("tb_request_code", 0);
            this.fRs = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fRr = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.fRt = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.esa = getPageContext().getString(d.k.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
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
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        r(bundle);
        registerListener(this.fRw);
    }

    private void r(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.base_person_navigation_bar);
        if (this.fRs) {
            if (this.ese == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(biR(), this.esa));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.fRs && BasePersonInfoActivity.this.ese != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.c(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.ese != 23003 && !this.fRs) {
            this.esb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_privacy, (View.OnClickListener) null);
            al.a(this.esb, fRu[com.baidu.tbadk.core.a.f.bB(bja()) - 1], esg[com.baidu.tbadk.core.a.f.bB(bja()) - 1]);
            this.esb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.erZ = com.baidu.tbadk.core.a.f.bB(BasePersonInfoActivity.this.bja()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.bja()) {
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
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.erZ + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.erY = new int[]{0, 1};
        this.fRv = a(this, this.mIsHost);
        this.aoi = (FragmentTabHost) findViewById(d.g.base_person_tab_host);
        this.aoi.setup(getSupportFragmentManager());
        this.aoi.setTabWidgetBackgroundColor(getResources().getColor(d.C0141d.common_color_10002));
        this.aoi.setOnPageChangeListener(this);
        this.aoi.reset();
        RO();
        if (this.mIsHost) {
            this.aoi.getTabWrapper().setVisibility(8);
        }
        this.aoi.setCurrentTab(this.bDW);
    }

    private void RO() {
        if (this.fRv != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.fRv.getItem(i2);
                int of = this.fRv.of(i2);
                String biS = biS();
                if (of == 1) {
                    biS = biT();
                }
                if (item != null) {
                    a(item, of, biS);
                }
            }
            this.aoi.cx(3);
        }
    }

    public NavigationBar UB() {
        return this.mNavigationBar;
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
            fragmentTabIndicator.setMinimumHeight(l.e(getActivity(), d.e.ds88));
            bVar.anM = fragmentTabIndicator;
            this.aoi.a(bVar);
        }
    }

    public void bh(int i, int i2) {
        if (!this.mIsHost && this.fRv != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.aoi.cA(0).anM;
            if (i <= 0) {
                fragmentTabIndicator.setText(biS());
            } else {
                fragmentTabIndicator.setText(String.format(biU(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.aoi.cA(1).anM;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(biT());
            } else {
                fragmentTabIndicator2.setText(String.format(biV(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aLf() {
        return this.esa;
    }

    public boolean aLg() {
        return this.mIsHost;
    }

    public boolean biW() {
        return this.fRs;
    }

    public int aLe() {
        return this.bDW == 0 ? 0 : 1;
    }

    public int biX() {
        return this.fRr;
    }

    public String biY() {
        return this.fRt;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.fRs && this.ese != 23011) {
                com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bDW);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.fRr);
        if (this.fRs && this.ese != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bDW) {
            this.bDW = i;
            if (!this.mIsHost && this.erY[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), biZ(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aoi.onChangeSkinType(i);
        if (this.fRv != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.fRv.getCount()) {
                    Fragment item = this.fRv.getItem(i3);
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
