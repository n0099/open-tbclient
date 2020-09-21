package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
/* loaded from: classes25.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aBS;
    private LinearLayout hPT;
    private TbSettingTextTipView lXg;
    private TbSettingTextTipView lXh;
    private TbSettingTextTipView lXi;
    private TbSettingTextTipView lXj;
    private TbSettingTextTipView lXk;
    private View lXl;
    private TbSettingTextTipView lXm;
    private TbSettingTextTipView lXn;
    private SecretSettingActivity lXo;
    private View lXp;
    private String[] lXq;
    private TbSettingTextTipView lXr;
    private a lXs;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes25.dex */
    public interface a {
        void dtM();

        void dtN();

        void dtO();

        void dtP();

        void dtQ();

        void dtR();

        void dtS();

        void dtT();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.lXs != null) {
                    if (view == c.this.mBack) {
                        c.this.lXs.onBackPressed();
                    } else if (view == c.this.lXg) {
                        c.this.lXs.dtM();
                    } else if (view == c.this.lXh) {
                        c.this.lXs.dtN();
                    } else if (view == c.this.lXj) {
                        c.this.lXs.dtP();
                    } else if (view == c.this.lXn) {
                        c.this.lXs.dtO();
                    } else if (view == c.this.lXk) {
                        c.this.lXs.dtQ();
                    } else if (view == c.this.lXm) {
                        c.this.lXs.dtR();
                    } else if (view == c.this.lXr) {
                        c.this.lXs.dtS();
                    } else if (view == c.this.lXi) {
                        c.this.lXs.dtT();
                    }
                }
            }
        };
        this.lXo = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.lXo.getLayoutMode().setNightMode(i == 1);
        this.lXo.getLayoutMode().onModeChanged(this.hPT);
        this.mNavigationBar.onChangeSkinType(this.lXo.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.hPT = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.lXg = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.lXh = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.lXi = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.lXn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.lXj = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.lXk = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.lXm = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.lXl = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aBS);
        this.lXg.setOnClickListener(this.aBS);
        this.lXk.setOnClickListener(this.aBS);
        this.lXn.setOnClickListener(this.aBS);
        this.lXh.setOnClickListener(this.aBS);
        this.lXi.setOnClickListener(this.aBS);
        this.lXj.setOnClickListener(this.aBS);
        this.lXm.setOnClickListener(this.aBS);
        this.lXp = this.lXo.findViewById(R.id.privacy_setting_container);
        this.lXq = this.lXo.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.lXn.setVisibility(0);
        } else {
            this.lXn.setVisibility(8);
        }
        this.lXr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.lXr.setOnClickListener(this.aBS);
        UserData btW = com.baidu.tbadk.getUserInfo.b.btU().btW();
        if (btW != null && btW.getBazhuGradeData() != null && !StringUtils.isNull(btW.getBazhuGradeData().getDesc()) && !StringUtils.isNull(btW.getBazhuGradeData().getLevel())) {
            this.lXi.setVisibility(0);
        } else {
            this.lXi.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.lXs = aVar;
    }

    public void dtU() {
        this.lXg.recycle();
    }

    public void vI(boolean z) {
        if (z) {
            this.lXp.setVisibility(0);
        } else {
            this.lXp.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.lXl.setVisibility(0);
            this.lXm.setVisibility(0);
            return;
        }
        this.lXl.setVisibility(8);
        this.lXm.setVisibility(8);
    }

    public void bF(String str, int i) {
        int i2 = i - 1;
        if (this.lXq != null && i2 < this.lXq.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.lXh.setTip(this.lXq[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.lXn.setTip(this.lXq[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.lXj.setTip(this.lXq[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.lXm.setTip(this.lXo.getString(R.string.all_person));
                } else {
                    this.lXm.setTip(this.lXq[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                di(com.baidu.tbadk.core.sharedPref.b.bjf().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bjf().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.lXq != null) {
            int length = this.lXq.length;
            int dtH = aVar.dtH() - 1;
            if (dtH < length && dtH >= 0) {
                this.lXn.setTip(this.lXq[dtH]);
            }
            int dtF = aVar.dtF() - 1;
            if (dtF < length && dtF >= 0) {
                this.lXh.setTip(this.lXq[dtF]);
            }
            int dtG = aVar.dtG() - 1;
            if (dtG < length && dtG >= 0) {
                this.lXj.setTip(this.lXq[dtG]);
            }
            int dtJ = aVar.dtJ() - 1;
            if (dtJ < length && dtJ >= 0) {
                if (dtJ == 0) {
                    this.lXm.setTip(this.lXo.getString(R.string.all_person));
                } else {
                    this.lXm.setTip(this.lXq[dtJ]);
                }
            }
            di(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void di(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.lXi.setTip(this.lXo.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.lXi.setTip(this.lXo.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.lXi.setTip(this.lXo.getString(R.string.mark_tip_outside));
        } else {
            this.lXi.setTip(this.lXo.getString(R.string.mark_tip_all));
        }
    }
}
