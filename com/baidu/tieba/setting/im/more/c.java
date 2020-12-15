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
    private View.OnClickListener aGQ;
    private LinearLayout iIW;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView mTQ;
    private TbSettingTextTipView mTR;
    private TbSettingTextTipView mTS;
    private TbSettingTextTipView mTT;
    private TbSettingTextTipView mTU;
    private View mTV;
    private TbSettingTextTipView mTW;
    private TbSettingTextTipView mTX;
    private SecretSettingActivity mTY;
    private View mTZ;
    private String[] mUb;
    private TbSettingTextTipView mUc;
    private a mUd;

    /* loaded from: classes26.dex */
    public interface a {
        void dHX();

        void dHY();

        void dHZ();

        void dIa();

        void dIb();

        void dIc();

        void dId();

        void dIe();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mUd != null) {
                    if (view == c.this.mBack) {
                        c.this.mUd.onBackPressed();
                    } else if (view == c.this.mTQ) {
                        c.this.mUd.dHX();
                    } else if (view == c.this.mTR) {
                        c.this.mUd.dHY();
                    } else if (view == c.this.mTT) {
                        c.this.mUd.dIa();
                    } else if (view == c.this.mTX) {
                        c.this.mUd.dHZ();
                    } else if (view == c.this.mTU) {
                        c.this.mUd.dIb();
                    } else if (view == c.this.mTW) {
                        c.this.mUd.dIc();
                    } else if (view == c.this.mUc) {
                        c.this.mUd.dId();
                    } else if (view == c.this.mTS) {
                        c.this.mUd.dIe();
                    }
                }
            }
        };
        this.mTY = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mTY.getLayoutMode().setNightMode(i == 1);
        this.mTY.getLayoutMode().onModeChanged(this.iIW);
        this.mNavigationBar.onChangeSkinType(this.mTY.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iIW = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mTQ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mTR = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mTS = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mTX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mTT = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mTU = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mTW = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mTV = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aGQ);
        this.mTQ.setOnClickListener(this.aGQ);
        this.mTU.setOnClickListener(this.aGQ);
        this.mTX.setOnClickListener(this.aGQ);
        this.mTR.setOnClickListener(this.aGQ);
        this.mTS.setOnClickListener(this.aGQ);
        this.mTT.setOnClickListener(this.aGQ);
        this.mTW.setOnClickListener(this.aGQ);
        this.mTZ = this.mTY.findViewById(R.id.privacy_setting_container);
        this.mUb = this.mTY.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mTX.setVisibility(0);
        } else {
            this.mTX.setVisibility(8);
        }
        this.mUc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mUc.setOnClickListener(this.aGQ);
        UserData bDQ = com.baidu.tbadk.getUserInfo.b.bDO().bDQ();
        if (bDQ != null && bDQ.getBazhuGradeData() != null && !StringUtils.isNull(bDQ.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bDQ.getBazhuGradeData().getLevel())) {
            this.mTS.setVisibility(0);
        } else {
            this.mTS.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mUd = aVar;
    }

    public void dIf() {
        this.mTQ.recycle();
    }

    public void xw(boolean z) {
        if (z) {
            this.mTZ.setVisibility(0);
        } else {
            this.mTZ.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mTV.setVisibility(0);
            this.mTW.setVisibility(0);
            return;
        }
        this.mTV.setVisibility(8);
        this.mTW.setVisibility(8);
    }

    public void bL(String str, int i) {
        int i2 = i - 1;
        if (this.mUb != null && i2 < this.mUb.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mTR.setTip(this.mUb[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mTX.setTip(this.mUb[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mTT.setTip(this.mUb[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mTW.setTip(this.mTY.getString(R.string.all_person));
                } else {
                    this.mTW.setTip(this.mUb[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dr(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bsO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mUb != null) {
            int length = this.mUb.length;
            int dHS = aVar.dHS() - 1;
            if (dHS < length && dHS >= 0) {
                this.mTX.setTip(this.mUb[dHS]);
            }
            int dHQ = aVar.dHQ() - 1;
            if (dHQ < length && dHQ >= 0) {
                this.mTR.setTip(this.mUb[dHQ]);
            }
            int dHR = aVar.dHR() - 1;
            if (dHR < length && dHR >= 0) {
                this.mTT.setTip(this.mUb[dHR]);
            }
            int dHU = aVar.dHU() - 1;
            if (dHU < length && dHU >= 0) {
                if (dHU == 0) {
                    this.mTW.setTip(this.mTY.getString(R.string.all_person));
                } else {
                    this.mTW.setTip(this.mUb[dHU]);
                }
            }
            dr(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dr(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mTS.setTip(this.mTY.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mTS.setTip(this.mTY.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mTS.setTip(this.mTY.getString(R.string.mark_tip_outside));
        } else {
            this.mTS.setTip(this.mTY.getString(R.string.mark_tip_all));
        }
    }
}
