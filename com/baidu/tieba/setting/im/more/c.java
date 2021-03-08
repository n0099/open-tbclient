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
    private View.OnClickListener aFH;
    private LinearLayout iYe;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView ngU;
    private TbSettingTextTipView ngV;
    private TbSettingTextTipView ngW;
    private TbSettingTextTipView ngX;
    private TbSettingTextTipView ngY;
    private View ngZ;
    private TbSettingTextTipView nha;
    private TbSettingTextTipView nhb;
    private SecretSettingActivity nhc;
    private View nhd;
    private String[] nhe;
    private TbSettingTextTipView nhf;
    private TbSettingTextTipView nhg;
    private a nhh;

    /* loaded from: classes7.dex */
    public interface a {
        void dGA();

        void dGB();

        void dGC();

        void dGD();

        void dGE();

        void dGw();

        void dGx();

        void dGy();

        void dGz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.nhh != null) {
                    if (view == c.this.mBack) {
                        c.this.nhh.onBackPressed();
                    } else if (view == c.this.ngU) {
                        c.this.nhh.dGw();
                    } else if (view == c.this.ngV) {
                        c.this.nhh.dGx();
                    } else if (view == c.this.ngX) {
                        c.this.nhh.dGz();
                    } else if (view == c.this.nhb) {
                        c.this.nhh.dGy();
                    } else if (view == c.this.ngY) {
                        c.this.nhh.dGA();
                    } else if (view == c.this.nha) {
                        c.this.nhh.dGB();
                    } else if (view == c.this.nhf) {
                        c.this.nhh.dGC();
                    } else if (view == c.this.ngW) {
                        c.this.nhh.dGD();
                    } else if (view == c.this.nhg) {
                        c.this.nhh.dGE();
                    }
                }
            }
        };
        this.nhc = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.nhc.getLayoutMode().setNightMode(i == 1);
        this.nhc.getLayoutMode().onModeChanged(this.iYe);
        this.mNavigationBar.onChangeSkinType(this.nhc.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iYe = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.ngU = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.ngV = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.ngW = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.nhb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.ngX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.ngY = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.nha = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.ngZ = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aFH);
        this.ngU.setOnClickListener(this.aFH);
        this.ngY.setOnClickListener(this.aFH);
        this.nhb.setOnClickListener(this.aFH);
        this.ngV.setOnClickListener(this.aFH);
        this.ngW.setOnClickListener(this.aFH);
        this.ngX.setOnClickListener(this.aFH);
        this.nha.setOnClickListener(this.aFH);
        this.nhd = this.nhc.findViewById(R.id.privacy_setting_container);
        this.nhe = this.nhc.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.nhb.setVisibility(0);
        } else {
            this.nhb.setVisibility(8);
        }
        this.nhf = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.nhf.setOnClickListener(this.aFH);
        this.nhg = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_forbidden_forum);
        this.nhg.setOnClickListener(this.aFH);
        UserData bCN = com.baidu.tbadk.getUserInfo.b.bCL().bCN();
        if (bCN != null && bCN.getBazhuGradeData() != null && !StringUtils.isNull(bCN.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bCN.getBazhuGradeData().getLevel())) {
            this.ngW.setVisibility(0);
        } else {
            this.ngW.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.nhh = aVar;
    }

    public void dGF() {
        this.ngU.recycle();
    }

    public void xM(boolean z) {
        if (z) {
            this.nhd.setVisibility(0);
        } else {
            this.nhd.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.ngZ.setVisibility(0);
            this.nha.setVisibility(0);
            return;
        }
        this.ngZ.setVisibility(8);
        this.nha.setVisibility(8);
    }

    public void bT(String str, int i) {
        int i2 = i - 1;
        if (this.nhe != null && i2 < this.nhe.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.ngV.setTip(this.nhe[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.nhb.setTip(this.nhe[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.ngX.setTip(this.nhe[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.nha.setTip(this.nhc.getString(R.string.all_person));
                } else {
                    this.nha.setTip(this.nhe[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dl(com.baidu.tbadk.core.sharedPref.b.brR().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.brR().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.nhe != null) {
            int length = this.nhe.length;
            int dGr = aVar.dGr() - 1;
            if (dGr < length && dGr >= 0) {
                this.nhb.setTip(this.nhe[dGr]);
            }
            int dGp = aVar.dGp() - 1;
            if (dGp < length && dGp >= 0) {
                this.ngV.setTip(this.nhe[dGp]);
            }
            int dGq = aVar.dGq() - 1;
            if (dGq < length && dGq >= 0) {
                this.ngX.setTip(this.nhe[dGq]);
            }
            int dGt = aVar.dGt() - 1;
            if (dGt < length && dGt >= 0) {
                if (dGt == 0) {
                    this.nha.setTip(this.nhc.getString(R.string.all_person));
                } else {
                    this.nha.setTip(this.nhe[dGt]);
                }
            }
            dl(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dl(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.ngW.setTip(this.nhc.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.ngW.setTip(this.nhc.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.ngW.setTip(this.nhc.getString(R.string.mark_tip_outside));
        } else {
            this.ngW.setTip(this.nhc.getString(R.string.mark_tip_all));
        }
    }
}
