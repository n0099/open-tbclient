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
    private LinearLayout iIU;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView mTO;
    private TbSettingTextTipView mTP;
    private TbSettingTextTipView mTQ;
    private TbSettingTextTipView mTR;
    private TbSettingTextTipView mTS;
    private View mTT;
    private TbSettingTextTipView mTU;
    private TbSettingTextTipView mTV;
    private SecretSettingActivity mTW;
    private View mTX;
    private String[] mTY;
    private TbSettingTextTipView mTZ;
    private a mUb;

    /* loaded from: classes26.dex */
    public interface a {
        void dHW();

        void dHX();

        void dHY();

        void dHZ();

        void dIa();

        void dIb();

        void dIc();

        void dId();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mUb != null) {
                    if (view == c.this.mBack) {
                        c.this.mUb.onBackPressed();
                    } else if (view == c.this.mTO) {
                        c.this.mUb.dHW();
                    } else if (view == c.this.mTP) {
                        c.this.mUb.dHX();
                    } else if (view == c.this.mTR) {
                        c.this.mUb.dHZ();
                    } else if (view == c.this.mTV) {
                        c.this.mUb.dHY();
                    } else if (view == c.this.mTS) {
                        c.this.mUb.dIa();
                    } else if (view == c.this.mTU) {
                        c.this.mUb.dIb();
                    } else if (view == c.this.mTZ) {
                        c.this.mUb.dIc();
                    } else if (view == c.this.mTQ) {
                        c.this.mUb.dId();
                    }
                }
            }
        };
        this.mTW = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mTW.getLayoutMode().setNightMode(i == 1);
        this.mTW.getLayoutMode().onModeChanged(this.iIU);
        this.mNavigationBar.onChangeSkinType(this.mTW.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iIU = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mTO = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mTP = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mTQ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mTV = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mTR = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mTS = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mTU = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mTT = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aGQ);
        this.mTO.setOnClickListener(this.aGQ);
        this.mTS.setOnClickListener(this.aGQ);
        this.mTV.setOnClickListener(this.aGQ);
        this.mTP.setOnClickListener(this.aGQ);
        this.mTQ.setOnClickListener(this.aGQ);
        this.mTR.setOnClickListener(this.aGQ);
        this.mTU.setOnClickListener(this.aGQ);
        this.mTX = this.mTW.findViewById(R.id.privacy_setting_container);
        this.mTY = this.mTW.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mTV.setVisibility(0);
        } else {
            this.mTV.setVisibility(8);
        }
        this.mTZ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mTZ.setOnClickListener(this.aGQ);
        UserData bDQ = com.baidu.tbadk.getUserInfo.b.bDO().bDQ();
        if (bDQ != null && bDQ.getBazhuGradeData() != null && !StringUtils.isNull(bDQ.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bDQ.getBazhuGradeData().getLevel())) {
            this.mTQ.setVisibility(0);
        } else {
            this.mTQ.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mUb = aVar;
    }

    public void dIe() {
        this.mTO.recycle();
    }

    public void xw(boolean z) {
        if (z) {
            this.mTX.setVisibility(0);
        } else {
            this.mTX.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mTT.setVisibility(0);
            this.mTU.setVisibility(0);
            return;
        }
        this.mTT.setVisibility(8);
        this.mTU.setVisibility(8);
    }

    public void bL(String str, int i) {
        int i2 = i - 1;
        if (this.mTY != null && i2 < this.mTY.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mTP.setTip(this.mTY[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mTV.setTip(this.mTY[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mTR.setTip(this.mTY[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mTU.setTip(this.mTW.getString(R.string.all_person));
                } else {
                    this.mTU.setTip(this.mTY[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dr(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bsO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mTY != null) {
            int length = this.mTY.length;
            int dHR = aVar.dHR() - 1;
            if (dHR < length && dHR >= 0) {
                this.mTV.setTip(this.mTY[dHR]);
            }
            int dHP = aVar.dHP() - 1;
            if (dHP < length && dHP >= 0) {
                this.mTP.setTip(this.mTY[dHP]);
            }
            int dHQ = aVar.dHQ() - 1;
            if (dHQ < length && dHQ >= 0) {
                this.mTR.setTip(this.mTY[dHQ]);
            }
            int dHT = aVar.dHT() - 1;
            if (dHT < length && dHT >= 0) {
                if (dHT == 0) {
                    this.mTU.setTip(this.mTW.getString(R.string.all_person));
                } else {
                    this.mTU.setTip(this.mTY[dHT]);
                }
            }
            dr(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dr(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mTQ.setTip(this.mTW.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mTQ.setTip(this.mTW.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mTQ.setTip(this.mTW.getString(R.string.mark_tip_outside));
        } else {
            this.mTQ.setTip(this.mTW.getString(R.string.mark_tip_all));
        }
    }
}
