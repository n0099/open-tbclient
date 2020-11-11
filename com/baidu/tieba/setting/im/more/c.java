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
    private View.OnClickListener aFV;
    private LinearLayout ixn;
    private View mBack;
    private TbSettingTextTipView mFA;
    private a mFB;
    private TbSettingTextTipView mFp;
    private TbSettingTextTipView mFq;
    private TbSettingTextTipView mFr;
    private TbSettingTextTipView mFs;
    private TbSettingTextTipView mFt;
    private View mFu;
    private TbSettingTextTipView mFv;
    private TbSettingTextTipView mFw;
    private SecretSettingActivity mFx;
    private View mFy;
    private String[] mFz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes26.dex */
    public interface a {
        void dDh();

        void dDi();

        void dDj();

        void dDk();

        void dDl();

        void dDm();

        void dDn();

        void dDo();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mFB != null) {
                    if (view == c.this.mBack) {
                        c.this.mFB.onBackPressed();
                    } else if (view == c.this.mFp) {
                        c.this.mFB.dDh();
                    } else if (view == c.this.mFq) {
                        c.this.mFB.dDi();
                    } else if (view == c.this.mFs) {
                        c.this.mFB.dDk();
                    } else if (view == c.this.mFw) {
                        c.this.mFB.dDj();
                    } else if (view == c.this.mFt) {
                        c.this.mFB.dDl();
                    } else if (view == c.this.mFv) {
                        c.this.mFB.dDm();
                    } else if (view == c.this.mFA) {
                        c.this.mFB.dDn();
                    } else if (view == c.this.mFr) {
                        c.this.mFB.dDo();
                    }
                }
            }
        };
        this.mFx = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mFx.getLayoutMode().setNightMode(i == 1);
        this.mFx.getLayoutMode().onModeChanged(this.ixn);
        this.mNavigationBar.onChangeSkinType(this.mFx.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.ixn = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mFp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mFq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mFr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mFw = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mFs = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mFt = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mFv = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mFu = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aFV);
        this.mFp.setOnClickListener(this.aFV);
        this.mFt.setOnClickListener(this.aFV);
        this.mFw.setOnClickListener(this.aFV);
        this.mFq.setOnClickListener(this.aFV);
        this.mFr.setOnClickListener(this.aFV);
        this.mFs.setOnClickListener(this.aFV);
        this.mFv.setOnClickListener(this.aFV);
        this.mFy = this.mFx.findViewById(R.id.privacy_setting_container);
        this.mFz = this.mFx.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mFw.setVisibility(0);
        } else {
            this.mFw.setVisibility(8);
        }
        this.mFA = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mFA.setOnClickListener(this.aFV);
        UserData bAY = com.baidu.tbadk.getUserInfo.b.bAW().bAY();
        if (bAY != null && bAY.getBazhuGradeData() != null && !StringUtils.isNull(bAY.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bAY.getBazhuGradeData().getLevel())) {
            this.mFr.setVisibility(0);
        } else {
            this.mFr.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mFB = aVar;
    }

    public void dDp() {
        this.mFp.recycle();
    }

    public void wP(boolean z) {
        if (z) {
            this.mFy.setVisibility(0);
        } else {
            this.mFy.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mFu.setVisibility(0);
            this.mFv.setVisibility(0);
            return;
        }
        this.mFu.setVisibility(8);
        this.mFv.setVisibility(8);
    }

    public void bJ(String str, int i) {
        int i2 = i - 1;
        if (this.mFz != null && i2 < this.mFz.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mFq.setTip(this.mFz[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mFw.setTip(this.mFz[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mFs.setTip(this.mFz[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mFv.setTip(this.mFx.getString(R.string.all_person));
                } else {
                    this.mFv.setTip(this.mFz[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dm(com.baidu.tbadk.core.sharedPref.b.bqh().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bqh().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mFz != null) {
            int length = this.mFz.length;
            int dDc = aVar.dDc() - 1;
            if (dDc < length && dDc >= 0) {
                this.mFw.setTip(this.mFz[dDc]);
            }
            int dDa = aVar.dDa() - 1;
            if (dDa < length && dDa >= 0) {
                this.mFq.setTip(this.mFz[dDa]);
            }
            int dDb = aVar.dDb() - 1;
            if (dDb < length && dDb >= 0) {
                this.mFs.setTip(this.mFz[dDb]);
            }
            int dDe = aVar.dDe() - 1;
            if (dDe < length && dDe >= 0) {
                if (dDe == 0) {
                    this.mFv.setTip(this.mFx.getString(R.string.all_person));
                } else {
                    this.mFv.setTip(this.mFz[dDe]);
                }
            }
            dm(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dm(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mFr.setTip(this.mFx.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mFr.setTip(this.mFx.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mFr.setTip(this.mFx.getString(R.string.mark_tip_outside));
        } else {
            this.mFr.setTip(this.mFx.getString(R.string.mark_tip_all));
        }
    }
}
