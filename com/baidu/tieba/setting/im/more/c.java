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
    private LinearLayout iWh;
    private View mBack;
    private NavigationBar mNavigationBar;
    private String[] neA;
    private TbSettingTextTipView neB;
    private TbSettingTextTipView neC;
    private a neD;
    private TbSettingTextTipView nep;
    private TbSettingTextTipView neq;
    private TbSettingTextTipView ner;
    private TbSettingTextTipView nes;
    private TbSettingTextTipView neu;
    private View nev;

    /* renamed from: new  reason: not valid java name */
    private TbSettingTextTipView f5new;
    private TbSettingTextTipView nex;
    private SecretSettingActivity ney;
    private View nez;

    /* loaded from: classes8.dex */
    public interface a {
        void dGg();

        void dGh();

        void dGi();

        void dGj();

        void dGk();

        void dGl();

        void dGm();

        void dGn();

        void dGo();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.neD != null) {
                    if (view == c.this.mBack) {
                        c.this.neD.onBackPressed();
                    } else if (view == c.this.nep) {
                        c.this.neD.dGg();
                    } else if (view == c.this.neq) {
                        c.this.neD.dGh();
                    } else if (view == c.this.nes) {
                        c.this.neD.dGj();
                    } else if (view == c.this.nex) {
                        c.this.neD.dGi();
                    } else if (view == c.this.neu) {
                        c.this.neD.dGk();
                    } else if (view == c.this.f5new) {
                        c.this.neD.dGl();
                    } else if (view == c.this.neB) {
                        c.this.neD.dGm();
                    } else if (view == c.this.ner) {
                        c.this.neD.dGn();
                    } else if (view == c.this.neC) {
                        c.this.neD.dGo();
                    }
                }
            }
        };
        this.ney = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.ney.getLayoutMode().setNightMode(i == 1);
        this.ney.getLayoutMode().onModeChanged(this.iWh);
        this.mNavigationBar.onChangeSkinType(this.ney.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iWh = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.nep = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.neq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.ner = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.nex = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.nes = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.neu = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.f5new = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.nev = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aEh);
        this.nep.setOnClickListener(this.aEh);
        this.neu.setOnClickListener(this.aEh);
        this.nex.setOnClickListener(this.aEh);
        this.neq.setOnClickListener(this.aEh);
        this.ner.setOnClickListener(this.aEh);
        this.nes.setOnClickListener(this.aEh);
        this.f5new.setOnClickListener(this.aEh);
        this.nez = this.ney.findViewById(R.id.privacy_setting_container);
        this.neA = this.ney.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.nex.setVisibility(0);
        } else {
            this.nex.setVisibility(8);
        }
        this.neB = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.neB.setOnClickListener(this.aEh);
        this.neC = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_forbidden_forum);
        this.neC.setOnClickListener(this.aEh);
        UserData bCK = com.baidu.tbadk.getUserInfo.b.bCI().bCK();
        if (bCK != null && bCK.getBazhuGradeData() != null && !StringUtils.isNull(bCK.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bCK.getBazhuGradeData().getLevel())) {
            this.ner.setVisibility(0);
        } else {
            this.ner.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.neD = aVar;
    }

    public void dGp() {
        this.nep.recycle();
    }

    public void xM(boolean z) {
        if (z) {
            this.nez.setVisibility(0);
        } else {
            this.nez.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.nev.setVisibility(0);
            this.f5new.setVisibility(0);
            return;
        }
        this.nev.setVisibility(8);
        this.f5new.setVisibility(8);
    }

    public void bT(String str, int i) {
        int i2 = i - 1;
        if (this.neA != null && i2 < this.neA.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.neq.setTip(this.neA[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.nex.setTip(this.neA[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.nes.setTip(this.neA[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.f5new.setTip(this.ney.getString(R.string.all_person));
                } else {
                    this.f5new.setTip(this.neA[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dk(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.brQ().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.neA != null) {
            int length = this.neA.length;
            int dGb = aVar.dGb() - 1;
            if (dGb < length && dGb >= 0) {
                this.nex.setTip(this.neA[dGb]);
            }
            int dFZ = aVar.dFZ() - 1;
            if (dFZ < length && dFZ >= 0) {
                this.neq.setTip(this.neA[dFZ]);
            }
            int dGa = aVar.dGa() - 1;
            if (dGa < length && dGa >= 0) {
                this.nes.setTip(this.neA[dGa]);
            }
            int dGd = aVar.dGd() - 1;
            if (dGd < length && dGd >= 0) {
                if (dGd == 0) {
                    this.f5new.setTip(this.ney.getString(R.string.all_person));
                } else {
                    this.f5new.setTip(this.neA[dGd]);
                }
            }
            dk(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dk(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.ner.setTip(this.ney.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.ner.setTip(this.ney.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.ner.setTip(this.ney.getString(R.string.mark_tip_outside));
        } else {
            this.ner.setTip(this.ney.getString(R.string.mark_tip_all));
        }
    }
}
