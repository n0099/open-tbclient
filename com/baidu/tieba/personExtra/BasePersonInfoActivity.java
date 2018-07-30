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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private int[] ezI;
    private String ezK;
    private ImageView ezL;
    protected int ezO;
    private BasePersonInfoAdapter fVK;
    private NavigationBar mNavigationBar;
    private int mSex;
    private FragmentTabHost mTabHost;
    private String mUid;
    private static final int[] ezQ = {d.f.icon_pop_key_all_bg, d.f.icon_pop_key_f_bg, d.f.icon_pop_key_d_bg};
    private static final int[] fVJ = {d.f.icon_pop_key_all_bg_w, d.f.icon_pop_key_f_bg_w, d.f.icon_pop_key_d_bg_w};
    private static final int[] ezS = {d.j.info_privacy_all, d.j.info_privacy_friend, d.j.info_privacy_hide};
    private static final int[] ezT = {1, 2, 3};
    private int bGI = -1;
    private int ezJ = 0;
    private boolean mIsHost = false;
    private int fVG = 0;
    protected boolean fVH = false;
    protected String fVI = "";
    HttpMessageListener fVL = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.isSuccess()) {
                if (httpResponsedMessage.getError() == 0) {
                    com.baidu.tbadk.core.a.e.t(BasePersonInfoActivity.this.bhZ(), BasePersonInfoActivity.ezT[BasePersonInfoActivity.this.ezJ]);
                    am.a(BasePersonInfoActivity.this.ezL, BasePersonInfoActivity.fVJ[BasePersonInfoActivity.this.ezJ], BasePersonInfoActivity.ezQ[BasePersonInfoActivity.this.ezJ]);
                    BasePersonInfoActivity.this.showToastWithIcon(BasePersonInfoActivity.this.getPageContext().getString(BasePersonInfoActivity.ezS[BasePersonInfoActivity.this.ezJ]), d.f.icon_toast_info);
                    return;
                }
                BasePersonInfoActivity.this.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            BasePersonInfoActivity.this.showToast(BasePersonInfoActivity.this.getPageContext().getString(d.j.neterror));
        }
    };

    public abstract BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String bhQ();

    public abstract String bhR();

    public abstract String bhS();

    public abstract String bhT();

    public abstract String bhU();

    public abstract String bhY();

    public abstract int bhZ();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.activity_base_person_info);
        if (bundle != null) {
            this.mUid = bundle.getString("key_uid");
            this.mSex = bundle.getInt("key_sex", 0);
            this.fVG = bundle.getInt(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.bGI = bundle.getInt("key_current_tab", 0);
            this.ezO = bundle.getInt("tb_request_code", 0);
            this.fVH = bundle.getBoolean(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fVI = bundle.getString(PersonBarActivityConfig.BAR_ID);
        } else if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("key_uid");
            this.mSex = getIntent().getIntExtra("key_sex", 0);
            this.bGI = getIntent().getIntExtra("key_current_tab", 0);
            this.ezO = getIntent().getIntExtra("tb_request_code", 0);
            this.fVH = getIntent().getBooleanExtra(PersonBarActivityConfig.IS_CHOOSE_BAR_MODE, false);
            this.fVG = getIntent().getIntExtra(PersonBarActivityConfig.LIKE_BARS_COUNT, 0);
            this.fVI = getIntent().getStringExtra(PersonBarActivityConfig.BAR_ID);
        } else {
            finish();
        }
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.ezK = getPageContext().getString(d.j.me);
            this.mIsHost = true;
        } else {
            this.mIsHost = false;
            switch (this.mSex) {
                case 1:
                    this.ezK = getPageContext().getString(d.j.he);
                    break;
                case 2:
                    this.ezK = getPageContext().getString(d.j.she);
                    break;
                default:
                    this.ezK = getPageContext().getString(d.j.ta);
                    break;
            }
        }
        if (k.isEmpty(this.mUid)) {
            finish();
            return;
        }
        r(bundle);
        registerListener(this.fVL);
    }

    private void r(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.base_person_navigation_bar);
        if (this.fVH) {
            if (this.ezO == 23011) {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.live_choose_bar));
            } else {
                this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.share_choose_bar_title));
            }
        } else {
            this.mNavigationBar.setCenterTextTitle(String.format(bhQ(), this.ezK));
        }
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BasePersonInfoActivity.this.fVH && BasePersonInfoActivity.this.ezO != 23011) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
                    com.baidu.tbadk.core.e.b.c(BasePersonInfoActivity.this.getPageContext().getPageActivity(), 200, false);
                }
                BasePersonInfoActivity.this.finish();
            }
        });
        if (this.mIsHost && this.ezO != 23003 && !this.fVH) {
            this.ezL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_privacy, (View.OnClickListener) null);
            am.a(this.ezL, fVJ[com.baidu.tbadk.core.a.e.bC(bhZ()) - 1], ezQ[com.baidu.tbadk.core.a.e.bC(bhZ()) - 1]);
            this.ezL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.BasePersonInfoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BasePersonInfoActivity.this.ezJ = com.baidu.tbadk.core.a.e.bC(BasePersonInfoActivity.this.bhZ()) % 3;
                    String str = "";
                    switch (BasePersonInfoActivity.this.bhZ()) {
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
                    httpMessage.addParam("val", String.valueOf(BasePersonInfoActivity.this.ezJ + 1));
                    BasePersonInfoActivity.this.sendMessage(httpMessage);
                }
            });
        }
        this.ezI = new int[]{0, 1};
        this.fVK = a(this, this.mIsHost);
        this.mTabHost = (FragmentTabHost) findViewById(d.g.base_person_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetBackgroundColor(getResources().getColor(d.C0140d.common_color_10002));
        this.mTabHost.setOnPageChangeListener(this);
        this.mTabHost.reset();
        initTabSpec();
        if (this.mIsHost) {
            this.mTabHost.getTabWrapper().setVisibility(8);
        }
        this.mTabHost.setCurrentTab(this.bGI);
    }

    private void initTabSpec() {
        if (this.fVK != null) {
            int i = this.mIsHost ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.fVK.getItem(i2);
                int oA = this.fVK.oA(i2);
                String bhR = bhR();
                if (oA == 1) {
                    bhR = bhS();
                }
                if (item != null) {
                    a(item, oA, bhR);
                }
            }
            this.mTabHost.cA(3);
        }
    }

    public NavigationBar Vf() {
        return this.mNavigationBar;
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.anO = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.aRz = d.C0140d.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(d.e.fontsize32));
            fragmentTabIndicator.setMinimumHeight(l.f(getActivity(), d.e.ds88));
            bVar.anN = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    public void bi(int i, int i2) {
        if (!this.mIsHost && this.fVK != null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.mTabHost.cD(0).anN;
            if (i <= 0) {
                fragmentTabIndicator.setText(bhR());
            } else {
                fragmentTabIndicator.setText(String.format(bhT(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.mTabHost.cD(1).anN;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(bhS());
            } else {
                fragmentTabIndicator2.setText(String.format(bhU(), Integer.valueOf(i2)));
            }
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public int getSex() {
        return this.mSex;
    }

    public String aMM() {
        return this.ezK;
    }

    public boolean aMN() {
        return this.mIsHost;
    }

    public boolean bhV() {
        return this.fVH;
    }

    public int aML() {
        return this.bGI == 0 ? 0 : 1;
    }

    public int bhW() {
        return this.fVG;
    }

    public String bhX() {
        return this.fVI;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.fVH && this.ezO != 23011) {
                com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bGI);
        bundle.putInt(PersonBarActivityConfig.LIKE_BARS_COUNT, this.fVG);
        if (this.fVH && this.ezO != 23011) {
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
        if (i >= 0 && i < 2 && i != this.bGI) {
            this.bGI = i;
            if (!this.mIsHost && this.ezI[i] == 1) {
                TiebaStatic.eventStat(getPageContext().getContext(), bhY(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
        if (this.fVK != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.fVK.getCount()) {
                    Fragment item = this.fVK.getItem(i3);
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
