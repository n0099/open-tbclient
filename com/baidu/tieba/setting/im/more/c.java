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
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aFf;
    private LinearLayout irq;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView mzn;
    private TbSettingTextTipView mzo;
    private TbSettingTextTipView mzp;
    private TbSettingTextTipView mzq;
    private TbSettingTextTipView mzr;
    private View mzs;
    private TbSettingTextTipView mzt;
    private TbSettingTextTipView mzu;
    private SecretSettingActivity mzv;
    private View mzw;
    private String[] mzx;
    private TbSettingTextTipView mzy;
    private a mzz;

    /* loaded from: classes26.dex */
    public interface a {
        void dAF();

        void dAG();

        void dAH();

        void dAI();

        void dAJ();

        void dAK();

        void dAL();

        void dAM();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mzz != null) {
                    if (view == c.this.mBack) {
                        c.this.mzz.onBackPressed();
                    } else if (view == c.this.mzn) {
                        c.this.mzz.dAF();
                    } else if (view == c.this.mzo) {
                        c.this.mzz.dAG();
                    } else if (view == c.this.mzq) {
                        c.this.mzz.dAI();
                    } else if (view == c.this.mzu) {
                        c.this.mzz.dAH();
                    } else if (view == c.this.mzr) {
                        c.this.mzz.dAJ();
                    } else if (view == c.this.mzt) {
                        c.this.mzz.dAK();
                    } else if (view == c.this.mzy) {
                        c.this.mzz.dAL();
                    } else if (view == c.this.mzp) {
                        c.this.mzz.dAM();
                    }
                }
            }
        };
        this.mzv = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mzv.getLayoutMode().setNightMode(i == 1);
        this.mzv.getLayoutMode().onModeChanged(this.irq);
        this.mNavigationBar.onChangeSkinType(this.mzv.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.irq = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mzn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mzo = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mzp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mzu = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mzq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mzr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mzt = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mzs = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aFf);
        this.mzn.setOnClickListener(this.aFf);
        this.mzr.setOnClickListener(this.aFf);
        this.mzu.setOnClickListener(this.aFf);
        this.mzo.setOnClickListener(this.aFf);
        this.mzp.setOnClickListener(this.aFf);
        this.mzq.setOnClickListener(this.aFf);
        this.mzt.setOnClickListener(this.aFf);
        this.mzw = this.mzv.findViewById(R.id.privacy_setting_container);
        this.mzx = this.mzv.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mzu.setVisibility(0);
        } else {
            this.mzu.setVisibility(8);
        }
        this.mzy = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mzy.setOnClickListener(this.aFf);
        UserData byz = com.baidu.tbadk.getUserInfo.b.byx().byz();
        if (byz != null && byz.getBazhuGradeData() != null && !StringUtils.isNull(byz.getBazhuGradeData().getDesc()) && !StringUtils.isNull(byz.getBazhuGradeData().getLevel())) {
            this.mzp.setVisibility(0);
        } else {
            this.mzp.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mzz = aVar;
    }

    public void dAN() {
        this.mzn.recycle();
    }

    public void wG(boolean z) {
        if (z) {
            this.mzw.setVisibility(0);
        } else {
            this.mzw.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mzs.setVisibility(0);
            this.mzt.setVisibility(0);
            return;
        }
        this.mzs.setVisibility(8);
        this.mzt.setVisibility(8);
    }

    public void bH(String str, int i) {
        int i2 = i - 1;
        if (this.mzx != null && i2 < this.mzx.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mzo.setTip(this.mzx[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mzu.setTip(this.mzx[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mzq.setTip(this.mzx[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mzt.setTip(this.mzv.getString(R.string.all_person));
                } else {
                    this.mzt.setTip(this.mzx[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dk(com.baidu.tbadk.core.sharedPref.b.bnH().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bnH().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mzx != null) {
            int length = this.mzx.length;
            int dAA = aVar.dAA() - 1;
            if (dAA < length && dAA >= 0) {
                this.mzu.setTip(this.mzx[dAA]);
            }
            int dAy = aVar.dAy() - 1;
            if (dAy < length && dAy >= 0) {
                this.mzo.setTip(this.mzx[dAy]);
            }
            int dAz = aVar.dAz() - 1;
            if (dAz < length && dAz >= 0) {
                this.mzq.setTip(this.mzx[dAz]);
            }
            int dAC = aVar.dAC() - 1;
            if (dAC < length && dAC >= 0) {
                if (dAC == 0) {
                    this.mzt.setTip(this.mzv.getString(R.string.all_person));
                } else {
                    this.mzt.setTip(this.mzx[dAC]);
                }
            }
            dk(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dk(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mzp.setTip(this.mzv.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mzp.setTip(this.mzv.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mzp.setTip(this.mzv.getString(R.string.mark_tip_outside));
        } else {
            this.mzp.setTip(this.mzv.getString(R.string.mark_tip_all));
        }
    }
}
