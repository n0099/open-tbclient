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
    private static final int[] bfK;
    private static final int[] bfL;
    private static final int[] bfM;
    private String bDG;
    private f bDH;
    private int[] bfC;
    private String bfE;
    private ImageView bfG;
    private FragmentTabHost bfN;
    private NavigationBar mNavigationBar;
    private int mSex;
    private String mUid;
    private int bfB = -1;
    int bfD = 0;
    private boolean bfF = false;
    private View Jt = null;
    HttpMessageListener bDI = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        bfK = new int[]{com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
        bfL = new int[]{com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
        bfM = new int[]{1, 2, 3};
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
        this.bDG = getIntent().getStringExtra("key_portrait_url");
        this.mUid = getIntent().getStringExtra("key_uid");
        this.mSex = getIntent().getIntExtra("key_sex", 0);
        this.mUid = this.mUid == null ? "" : this.mUid;
        if (this.mUid.equals(TbadkApplication.getCurrentAccount())) {
            this.bfE = getString(com.baidu.tieba.y.me);
            this.bfF = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
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
        if (this.mUid == null) {
            finish();
            return;
        }
        e(bundle);
        registerListener(this.bDI);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bDH != null) {
            int count = this.bDH.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.bDH.getItem(i3);
                if (item instanceof u) {
                    ((u) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void e(Bundle bundle) {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(String.format(getString(com.baidu.tieba.y.person_post), this.bfE));
        this.Jt = (View) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.Jt.setOnClickListener(new d(this));
        if (this.bfF) {
            this.bfG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            aw.c(this.bfG, bfK[com.baidu.tbadk.core.account.o.aL(4) - 1]);
            this.bfG.setOnClickListener(new e(this));
        }
        this.bfC = new int[]{0, 1};
        this.bDH = new f(this);
        this.bfN = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.bfN.setup(getSupportFragmentManager());
        this.bfN.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfN.setOnPageChangeListener(this);
        QT();
        if (bundle != null) {
            this.bfB = bundle.getInt("CurrTabIndex");
        } else {
            this.bfB = 0;
        }
        this.bfN.setCurrentTab(this.bfB);
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

    private void QT() {
        if (this.bDH != null) {
            int count = this.bDH.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bDH.getItem(i);
                int gf = this.bDH.gf(i);
                if (item != null) {
                    if (gf == 0) {
                        a(item, 0, String.format(getString(com.baidu.tieba.y.person_post_thread), this.bfE));
                    } else if (gf == 1) {
                        a(item, 1, String.format(getString(com.baidu.tieba.y.person_post_reply), this.bfE));
                    }
                }
            }
            this.bfN.initViewPager();
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

    public String QV() {
        return this.bfE;
    }

    public String aal() {
        return this.bDG;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.bfB);
        super.onSaveInstanceState(bundle);
    }

    public String aam() {
        if (this.bfF) {
            return getString(com.baidu.tieba.y.person_post_lv_empty_host);
        }
        return String.format(getString(com.baidu.tieba.y.person_post_lv_empty_guest), QV());
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
            if (this.bfC[i] == 0) {
                TiebaStatic.eventStat(this, this.bfF ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.bfC[i] == 1) {
                TiebaStatic.eventStat(this, this.bfF ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bfN.onChangeSkinType(i);
        aw.h(this.bfN, com.baidu.tieba.s.cp_bg_line_c);
        if (this.bDH != null) {
            int count = this.bDH.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bDH.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView onGetPreLoadListView() {
        if (this.bDH != null) {
            u aan = this.bDH.aan();
            ab aaq = aan != null ? aan.aaq() : null;
            if (aaq != null) {
                return aaq.ET();
            }
            return null;
        }
        return null;
    }
}
