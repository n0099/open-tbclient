package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.base.d;
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
/* loaded from: classes7.dex */
public class c extends d<SecretSettingActivity> {
    private View.OnClickListener aCu;
    private LinearLayout iQA;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView mUH;
    private TbSettingTextTipView mUI;
    private TbSettingTextTipView mUJ;
    private TbSettingTextTipView mUL;
    private TbSettingTextTipView mUM;
    private View mUN;
    private TbSettingTextTipView mUO;
    private TbSettingTextTipView mUP;
    private SecretSettingActivity mUQ;
    private View mUR;
    private String[] mUS;
    private TbSettingTextTipView mUT;
    private a mUU;

    /* loaded from: classes7.dex */
    public interface a {
        void dDW();

        void dDX();

        void dDY();

        void dDZ();

        void dEa();

        void dEb();

        void dEc();

        void dEd();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mUU != null) {
                    if (view == c.this.mBack) {
                        c.this.mUU.onBackPressed();
                    } else if (view == c.this.mUH) {
                        c.this.mUU.dDW();
                    } else if (view == c.this.mUI) {
                        c.this.mUU.dDX();
                    } else if (view == c.this.mUL) {
                        c.this.mUU.dDZ();
                    } else if (view == c.this.mUP) {
                        c.this.mUU.dDY();
                    } else if (view == c.this.mUM) {
                        c.this.mUU.dEa();
                    } else if (view == c.this.mUO) {
                        c.this.mUU.dEb();
                    } else if (view == c.this.mUT) {
                        c.this.mUU.dEc();
                    } else if (view == c.this.mUJ) {
                        c.this.mUU.dEd();
                    }
                }
            }
        };
        this.mUQ = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mUQ.getLayoutMode().setNightMode(i == 1);
        this.mUQ.getLayoutMode().onModeChanged(this.iQA);
        this.mNavigationBar.onChangeSkinType(this.mUQ.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iQA = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mUH = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mUI = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mUJ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mUP = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mUL = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mUM = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mUO = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mUN = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aCu);
        this.mUH.setOnClickListener(this.aCu);
        this.mUM.setOnClickListener(this.aCu);
        this.mUP.setOnClickListener(this.aCu);
        this.mUI.setOnClickListener(this.aCu);
        this.mUJ.setOnClickListener(this.aCu);
        this.mUL.setOnClickListener(this.aCu);
        this.mUO.setOnClickListener(this.aCu);
        this.mUR = this.mUQ.findViewById(R.id.privacy_setting_container);
        this.mUS = this.mUQ.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mUP.setVisibility(0);
        } else {
            this.mUP.setVisibility(8);
        }
        this.mUT = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mUT.setOnClickListener(this.aCu);
        UserData bCs = com.baidu.tbadk.getUserInfo.b.bCq().bCs();
        if (bCs != null && bCs.getBazhuGradeData() != null && !StringUtils.isNull(bCs.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bCs.getBazhuGradeData().getLevel())) {
            this.mUJ.setVisibility(0);
        } else {
            this.mUJ.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mUU = aVar;
    }

    public void dEe() {
        this.mUH.recycle();
    }

    public void xt(boolean z) {
        if (z) {
            this.mUR.setVisibility(0);
        } else {
            this.mUR.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mUN.setVisibility(0);
            this.mUO.setVisibility(0);
            return;
        }
        this.mUN.setVisibility(8);
        this.mUO.setVisibility(8);
    }

    public void bT(String str, int i) {
        int i2 = i - 1;
        if (this.mUS != null && i2 < this.mUS.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mUI.setTip(this.mUS[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mUP.setTip(this.mUS[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mUL.setTip(this.mUS[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mUO.setTip(this.mUQ.getString(R.string.all_person));
                } else {
                    this.mUO.setTip(this.mUS[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dn(com.baidu.tbadk.core.sharedPref.b.brx().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.brx().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mUS != null) {
            int length = this.mUS.length;
            int dDR = aVar.dDR() - 1;
            if (dDR < length && dDR >= 0) {
                this.mUP.setTip(this.mUS[dDR]);
            }
            int dDP = aVar.dDP() - 1;
            if (dDP < length && dDP >= 0) {
                this.mUI.setTip(this.mUS[dDP]);
            }
            int dDQ = aVar.dDQ() - 1;
            if (dDQ < length && dDQ >= 0) {
                this.mUL.setTip(this.mUS[dDQ]);
            }
            int dDT = aVar.dDT() - 1;
            if (dDT < length && dDT >= 0) {
                if (dDT == 0) {
                    this.mUO.setTip(this.mUQ.getString(R.string.all_person));
                } else {
                    this.mUO.setTip(this.mUS[dDT]);
                }
            }
            dn(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dn(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mUJ.setTip(this.mUQ.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mUJ.setTip(this.mUQ.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mUJ.setTip(this.mUQ.getString(R.string.mark_tip_outside));
        } else {
            this.mUJ.setTip(this.mUQ.getString(R.string.mark_tip_all));
        }
    }
}
