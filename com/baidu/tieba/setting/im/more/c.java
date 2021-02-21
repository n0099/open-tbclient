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
/* loaded from: classes8.dex */
public class c extends d<SecretSettingActivity> {
    private View.OnClickListener aEh;
    private LinearLayout iWv;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView neQ;
    private TbSettingTextTipView neR;
    private TbSettingTextTipView neS;
    private TbSettingTextTipView neT;
    private TbSettingTextTipView neU;
    private View neV;
    private TbSettingTextTipView neW;
    private TbSettingTextTipView neX;
    private SecretSettingActivity neY;
    private View neZ;
    private String[] nfa;
    private TbSettingTextTipView nfb;
    private TbSettingTextTipView nfc;
    private a nfd;

    /* loaded from: classes8.dex */
    public interface a {
        void dGo();

        void dGp();

        void dGq();

        void dGr();

        void dGs();

        void dGt();

        void dGu();

        void dGv();

        void dGw();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.nfd != null) {
                    if (view == c.this.mBack) {
                        c.this.nfd.onBackPressed();
                    } else if (view == c.this.neQ) {
                        c.this.nfd.dGo();
                    } else if (view == c.this.neR) {
                        c.this.nfd.dGp();
                    } else if (view == c.this.neT) {
                        c.this.nfd.dGr();
                    } else if (view == c.this.neX) {
                        c.this.nfd.dGq();
                    } else if (view == c.this.neU) {
                        c.this.nfd.dGs();
                    } else if (view == c.this.neW) {
                        c.this.nfd.dGt();
                    } else if (view == c.this.nfb) {
                        c.this.nfd.dGu();
                    } else if (view == c.this.neS) {
                        c.this.nfd.dGv();
                    } else if (view == c.this.nfc) {
                        c.this.nfd.dGw();
                    }
                }
            }
        };
        this.neY = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.neY.getLayoutMode().setNightMode(i == 1);
        this.neY.getLayoutMode().onModeChanged(this.iWv);
        this.mNavigationBar.onChangeSkinType(this.neY.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iWv = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.neQ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.neR = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.neS = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.neX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.neT = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.neU = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.neW = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.neV = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aEh);
        this.neQ.setOnClickListener(this.aEh);
        this.neU.setOnClickListener(this.aEh);
        this.neX.setOnClickListener(this.aEh);
        this.neR.setOnClickListener(this.aEh);
        this.neS.setOnClickListener(this.aEh);
        this.neT.setOnClickListener(this.aEh);
        this.neW.setOnClickListener(this.aEh);
        this.neZ = this.neY.findViewById(R.id.privacy_setting_container);
        this.nfa = this.neY.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.neX.setVisibility(0);
        } else {
            this.neX.setVisibility(8);
        }
        this.nfb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.nfb.setOnClickListener(this.aEh);
        this.nfc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_forbidden_forum);
        this.nfc.setOnClickListener(this.aEh);
        UserData bCK = com.baidu.tbadk.getUserInfo.b.bCI().bCK();
        if (bCK != null && bCK.getBazhuGradeData() != null && !StringUtils.isNull(bCK.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bCK.getBazhuGradeData().getLevel())) {
            this.neS.setVisibility(0);
        } else {
            this.neS.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.nfd = aVar;
    }

    public void dGx() {
        this.neQ.recycle();
    }

    public void xM(boolean z) {
        if (z) {
            this.neZ.setVisibility(0);
        } else {
            this.neZ.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.neV.setVisibility(0);
            this.neW.setVisibility(0);
            return;
        }
        this.neV.setVisibility(8);
        this.neW.setVisibility(8);
    }

    public void bT(String str, int i) {
        int i2 = i - 1;
        if (this.nfa != null && i2 < this.nfa.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.neR.setTip(this.nfa[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.neX.setTip(this.nfa[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.neT.setTip(this.nfa[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.neW.setTip(this.neY.getString(R.string.all_person));
                } else {
                    this.neW.setTip(this.nfa[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dl(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.brQ().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.nfa != null) {
            int length = this.nfa.length;
            int dGj = aVar.dGj() - 1;
            if (dGj < length && dGj >= 0) {
                this.neX.setTip(this.nfa[dGj]);
            }
            int dGh = aVar.dGh() - 1;
            if (dGh < length && dGh >= 0) {
                this.neR.setTip(this.nfa[dGh]);
            }
            int dGi = aVar.dGi() - 1;
            if (dGi < length && dGi >= 0) {
                this.neT.setTip(this.nfa[dGi]);
            }
            int dGl = aVar.dGl() - 1;
            if (dGl < length && dGl >= 0) {
                if (dGl == 0) {
                    this.neW.setTip(this.neY.getString(R.string.all_person));
                } else {
                    this.neW.setTip(this.nfa[dGl]);
                }
            }
            dl(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dl(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.neS.setTip(this.neY.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.neS.setTip(this.neY.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.neS.setTip(this.neY.getString(R.string.mark_tip_outside));
        } else {
            this.neS.setTip(this.neY.getString(R.string.mark_tip_all));
        }
    }
}
