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
    private View.OnClickListener aHh;
    private LinearLayout iVh;
    private View mBack;
    private NavigationBar mNavigationBar;
    private a mZA;
    private TbSettingTextTipView mZo;
    private TbSettingTextTipView mZp;
    private TbSettingTextTipView mZq;
    private TbSettingTextTipView mZr;
    private TbSettingTextTipView mZs;
    private View mZt;
    private TbSettingTextTipView mZu;
    private TbSettingTextTipView mZv;
    private SecretSettingActivity mZw;
    private View mZx;
    private String[] mZy;
    private TbSettingTextTipView mZz;

    /* loaded from: classes8.dex */
    public interface a {
        void dHN();

        void dHO();

        void dHP();

        void dHQ();

        void dHR();

        void dHS();

        void dHT();

        void dHU();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mZA != null) {
                    if (view == c.this.mBack) {
                        c.this.mZA.onBackPressed();
                    } else if (view == c.this.mZo) {
                        c.this.mZA.dHN();
                    } else if (view == c.this.mZp) {
                        c.this.mZA.dHO();
                    } else if (view == c.this.mZr) {
                        c.this.mZA.dHQ();
                    } else if (view == c.this.mZv) {
                        c.this.mZA.dHP();
                    } else if (view == c.this.mZs) {
                        c.this.mZA.dHR();
                    } else if (view == c.this.mZu) {
                        c.this.mZA.dHS();
                    } else if (view == c.this.mZz) {
                        c.this.mZA.dHT();
                    } else if (view == c.this.mZq) {
                        c.this.mZA.dHU();
                    }
                }
            }
        };
        this.mZw = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mZw.getLayoutMode().setNightMode(i == 1);
        this.mZw.getLayoutMode().onModeChanged(this.iVh);
        this.mNavigationBar.onChangeSkinType(this.mZw.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iVh = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mZo = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mZp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mZq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mZv = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mZr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mZs = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mZu = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mZt = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aHh);
        this.mZo.setOnClickListener(this.aHh);
        this.mZs.setOnClickListener(this.aHh);
        this.mZv.setOnClickListener(this.aHh);
        this.mZp.setOnClickListener(this.aHh);
        this.mZq.setOnClickListener(this.aHh);
        this.mZr.setOnClickListener(this.aHh);
        this.mZu.setOnClickListener(this.aHh);
        this.mZx = this.mZw.findViewById(R.id.privacy_setting_container);
        this.mZy = this.mZw.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mZv.setVisibility(0);
        } else {
            this.mZv.setVisibility(8);
        }
        this.mZz = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mZz.setOnClickListener(this.aHh);
        UserData bGk = com.baidu.tbadk.getUserInfo.b.bGi().bGk();
        if (bGk != null && bGk.getBazhuGradeData() != null && !StringUtils.isNull(bGk.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bGk.getBazhuGradeData().getLevel())) {
            this.mZq.setVisibility(0);
        } else {
            this.mZq.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mZA = aVar;
    }

    public void dHV() {
        this.mZo.recycle();
    }

    public void xx(boolean z) {
        if (z) {
            this.mZx.setVisibility(0);
        } else {
            this.mZx.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mZt.setVisibility(0);
            this.mZu.setVisibility(0);
            return;
        }
        this.mZt.setVisibility(8);
        this.mZu.setVisibility(8);
    }

    public void bS(String str, int i) {
        int i2 = i - 1;
        if (this.mZy != null && i2 < this.mZy.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mZp.setTip(this.mZy[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mZv.setTip(this.mZy[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mZr.setTip(this.mZy[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mZu.setTip(this.mZw.getString(R.string.all_person));
                } else {
                    this.mZu.setTip(this.mZy[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dn(com.baidu.tbadk.core.sharedPref.b.bvq().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bvq().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mZy != null) {
            int length = this.mZy.length;
            int dHI = aVar.dHI() - 1;
            if (dHI < length && dHI >= 0) {
                this.mZv.setTip(this.mZy[dHI]);
            }
            int dHG = aVar.dHG() - 1;
            if (dHG < length && dHG >= 0) {
                this.mZp.setTip(this.mZy[dHG]);
            }
            int dHH = aVar.dHH() - 1;
            if (dHH < length && dHH >= 0) {
                this.mZr.setTip(this.mZy[dHH]);
            }
            int dHK = aVar.dHK() - 1;
            if (dHK < length && dHK >= 0) {
                if (dHK == 0) {
                    this.mZu.setTip(this.mZw.getString(R.string.all_person));
                } else {
                    this.mZu.setTip(this.mZy[dHK]);
                }
            }
            dn(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dn(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mZq.setTip(this.mZw.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mZq.setTip(this.mZw.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mZq.setTip(this.mZw.getString(R.string.mark_tip_outside));
        } else {
            this.mZq.setTip(this.mZw.getString(R.string.mark_tip_all));
        }
    }
}
