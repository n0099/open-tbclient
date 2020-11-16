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
    private View.OnClickListener aEk;
    private LinearLayout iyc;
    private View mBack;
    private TbSettingTextTipView mFM;
    private TbSettingTextTipView mFN;
    private TbSettingTextTipView mFO;
    private TbSettingTextTipView mFP;
    private TbSettingTextTipView mFQ;
    private View mFR;
    private TbSettingTextTipView mFS;
    private TbSettingTextTipView mFT;
    private SecretSettingActivity mFU;
    private View mFV;
    private String[] mFW;
    private TbSettingTextTipView mFX;
    private a mFY;
    private NavigationBar mNavigationBar;

    /* loaded from: classes25.dex */
    public interface a {
        void dCL();

        void dCM();

        void dCN();

        void dCO();

        void dCP();

        void dCQ();

        void dCR();

        void dCS();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mFY != null) {
                    if (view == c.this.mBack) {
                        c.this.mFY.onBackPressed();
                    } else if (view == c.this.mFM) {
                        c.this.mFY.dCL();
                    } else if (view == c.this.mFN) {
                        c.this.mFY.dCM();
                    } else if (view == c.this.mFP) {
                        c.this.mFY.dCO();
                    } else if (view == c.this.mFT) {
                        c.this.mFY.dCN();
                    } else if (view == c.this.mFQ) {
                        c.this.mFY.dCP();
                    } else if (view == c.this.mFS) {
                        c.this.mFY.dCQ();
                    } else if (view == c.this.mFX) {
                        c.this.mFY.dCR();
                    } else if (view == c.this.mFO) {
                        c.this.mFY.dCS();
                    }
                }
            }
        };
        this.mFU = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mFU.getLayoutMode().setNightMode(i == 1);
        this.mFU.getLayoutMode().onModeChanged(this.iyc);
        this.mNavigationBar.onChangeSkinType(this.mFU.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iyc = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mFM = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mFN = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mFO = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mFT = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mFP = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mFQ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mFS = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mFR = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aEk);
        this.mFM.setOnClickListener(this.aEk);
        this.mFQ.setOnClickListener(this.aEk);
        this.mFT.setOnClickListener(this.aEk);
        this.mFN.setOnClickListener(this.aEk);
        this.mFO.setOnClickListener(this.aEk);
        this.mFP.setOnClickListener(this.aEk);
        this.mFS.setOnClickListener(this.aEk);
        this.mFV = this.mFU.findViewById(R.id.privacy_setting_container);
        this.mFW = this.mFU.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mFT.setVisibility(0);
        } else {
            this.mFT.setVisibility(8);
        }
        this.mFX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mFX.setOnClickListener(this.aEk);
        UserData bAo = com.baidu.tbadk.getUserInfo.b.bAm().bAo();
        if (bAo != null && bAo.getBazhuGradeData() != null && !StringUtils.isNull(bAo.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bAo.getBazhuGradeData().getLevel())) {
            this.mFO.setVisibility(0);
        } else {
            this.mFO.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mFY = aVar;
    }

    public void dCT() {
        this.mFM.recycle();
    }

    public void wS(boolean z) {
        if (z) {
            this.mFV.setVisibility(0);
        } else {
            this.mFV.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mFR.setVisibility(0);
            this.mFS.setVisibility(0);
            return;
        }
        this.mFR.setVisibility(8);
        this.mFS.setVisibility(8);
    }

    public void bI(String str, int i) {
        int i2 = i - 1;
        if (this.mFW != null && i2 < this.mFW.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mFN.setTip(this.mFW[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mFT.setTip(this.mFW[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mFP.setTip(this.mFW[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mFS.setTip(this.mFU.getString(R.string.all_person));
                } else {
                    this.mFS.setTip(this.mFW[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dm(com.baidu.tbadk.core.sharedPref.b.bpu().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bpu().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mFW != null) {
            int length = this.mFW.length;
            int dCG = aVar.dCG() - 1;
            if (dCG < length && dCG >= 0) {
                this.mFT.setTip(this.mFW[dCG]);
            }
            int dCE = aVar.dCE() - 1;
            if (dCE < length && dCE >= 0) {
                this.mFN.setTip(this.mFW[dCE]);
            }
            int dCF = aVar.dCF() - 1;
            if (dCF < length && dCF >= 0) {
                this.mFP.setTip(this.mFW[dCF]);
            }
            int dCI = aVar.dCI() - 1;
            if (dCI < length && dCI >= 0) {
                if (dCI == 0) {
                    this.mFS.setTip(this.mFU.getString(R.string.all_person));
                } else {
                    this.mFS.setTip(this.mFW[dCI]);
                }
            }
            dm(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dm(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mFO.setTip(this.mFU.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mFO.setTip(this.mFU.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mFO.setTip(this.mFU.getString(R.string.mark_tip_outside));
        } else {
            this.mFO.setTip(this.mFU.getString(R.string.mark_tip_all));
        }
    }
}
