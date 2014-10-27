package com.baidu.tieba.person.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] bfw;
    private static final int[] bfx;
    private static final int[] bfy;
    private String bDs;
    private f bDt;
    private int[] bfo;
    private String bfq;
    private ImageView bfs;
    private FragmentTabHost bfz;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bfn = -1;
    int bfp = 0;
    private boolean bfr = false;
    private View Js = null;
    HttpMessageListener bDu = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        bfw = new int[]{com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
        bfx = new int[]{com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
        bfy = new int[]{1, 2, 3};
    }

    public static void a(Context context, String str, int i, String str2) {
        Intent intent = new Intent(context, PersonPostActivity.class);
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_portrait_url", str2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.baidu.adp.lib.util.j.fh()) {
            showToast(com.baidu.tieba.y.neterror);
        }
        setContentView(com.baidu.tieba.w.person_post_activity);
        this.bDs = getIntent().getStringExtra("key_portrait_url");
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bfq = getString(com.baidu.tieba.y.me);
            this.bfr = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
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
        if (this.mUid == null) {
            finish();
            return;
        }
        e(bundle);
        registerListener(this.bDu);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bDt != null) {
            int count = this.bDt.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bDt.getItem(i3);
                if (item instanceof t) {
                    ((t) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void e(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getString(com.baidu.tieba.y.person_post), this.bfq));
        this.Js = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.Js.setOnClickListener(new d(this));
        if (this.bfr) {
            this.bfs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            aw.c(this.bfs, bfw[com.baidu.tbadk.core.account.o.aL(4) - 1]);
            this.bfs.setOnClickListener(new e(this));
        }
        this.bfo = new int[]{0, 1};
        this.bDt = new f(this);
        this.bfz = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.bfz.setup(getSupportFragmentManager());
        this.bfz.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfz.setOnPageChangeListener(this);
        QQ();
        if (bundle != null) {
            this.bfn = bundle.getInt("CurrTabIndex");
        } else {
            this.bfn = 0;
        }
        this.bfz.setCurrentTab(this.bfn);
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

    private void QQ() {
        if (this.bDt != null) {
            int count = this.bDt.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bDt.getItem(i);
                int gf = this.bDt.gf(i);
                if (item != null) {
                    if (gf == 0) {
                        a(item, 0, String.format(getString(com.baidu.tieba.y.person_post_thread), this.bfq));
                    } else if (gf == 1) {
                        a(item, 1, String.format(getString(com.baidu.tieba.y.person_post_reply), this.bfq));
                    }
                }
            }
            this.bfz.initViewPager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public String getUid() {
        return this.mUid;
    }

    public String QS() {
        return this.bfq;
    }

    public String aaj() {
        return this.bDs;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bfn);
        super.onSaveInstanceState(bundle);
    }

    public String aak() {
        if (this.bfr) {
            return getString(com.baidu.tieba.y.person_post_lv_empty_host);
        }
        return String.format(getString(com.baidu.tieba.y.person_post_lv_empty_guest), QS());
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
            if (this.bfo[i] == 0) {
                TiebaStatic.eventStat(this, this.bfr ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bfo[i] == 1) {
                TiebaStatic.eventStat(this, this.bfr ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bfz.onChangeSkinType(i);
        aw.h(this.bfz, com.baidu.tieba.s.cp_bg_line_c);
        if (this.bDt != null) {
            int count = this.bDt.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bDt.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bDt != null) {
            t aal = this.bDt.aal();
            aa aao = aal != null ? aal.aao() : null;
            if (aao != null) {
                return aao.ER();
            }
            return null;
        }
        return null;
    }
}
