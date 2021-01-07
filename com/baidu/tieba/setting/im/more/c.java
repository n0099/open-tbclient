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
    private TbSettingTextTipView mZn;
    private TbSettingTextTipView mZo;
    private TbSettingTextTipView mZp;
    private TbSettingTextTipView mZq;
    private TbSettingTextTipView mZr;
    private View mZs;
    private TbSettingTextTipView mZt;
    private TbSettingTextTipView mZu;
    private SecretSettingActivity mZv;
    private View mZw;
    private String[] mZx;
    private TbSettingTextTipView mZy;
    private a mZz;

    /* loaded from: classes8.dex */
    public interface a {
        void dHO();

        void dHP();

        void dHQ();

        void dHR();

        void dHS();

        void dHT();

        void dHU();

        void dHV();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mZz != null) {
                    if (view == c.this.mBack) {
                        c.this.mZz.onBackPressed();
                    } else if (view == c.this.mZn) {
                        c.this.mZz.dHO();
                    } else if (view == c.this.mZo) {
                        c.this.mZz.dHP();
                    } else if (view == c.this.mZq) {
                        c.this.mZz.dHR();
                    } else if (view == c.this.mZu) {
                        c.this.mZz.dHQ();
                    } else if (view == c.this.mZr) {
                        c.this.mZz.dHS();
                    } else if (view == c.this.mZt) {
                        c.this.mZz.dHT();
                    } else if (view == c.this.mZy) {
                        c.this.mZz.dHU();
                    } else if (view == c.this.mZp) {
                        c.this.mZz.dHV();
                    }
                }
            }
        };
        this.mZv = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mZv.getLayoutMode().setNightMode(i == 1);
        this.mZv.getLayoutMode().onModeChanged(this.iVh);
        this.mNavigationBar.onChangeSkinType(this.mZv.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.iVh = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mZn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mZo = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mZp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mZu = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mZq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mZr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mZt = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mZs = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aHh);
        this.mZn.setOnClickListener(this.aHh);
        this.mZr.setOnClickListener(this.aHh);
        this.mZu.setOnClickListener(this.aHh);
        this.mZo.setOnClickListener(this.aHh);
        this.mZp.setOnClickListener(this.aHh);
        this.mZq.setOnClickListener(this.aHh);
        this.mZt.setOnClickListener(this.aHh);
        this.mZw = this.mZv.findViewById(R.id.privacy_setting_container);
        this.mZx = this.mZv.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mZu.setVisibility(0);
        } else {
            this.mZu.setVisibility(8);
        }
        this.mZy = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mZy.setOnClickListener(this.aHh);
        UserData bGl = com.baidu.tbadk.getUserInfo.b.bGj().bGl();
        if (bGl != null && bGl.getBazhuGradeData() != null && !StringUtils.isNull(bGl.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bGl.getBazhuGradeData().getLevel())) {
            this.mZp.setVisibility(0);
        } else {
            this.mZp.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mZz = aVar;
    }

    public void dHW() {
        this.mZn.recycle();
    }

    public void xx(boolean z) {
        if (z) {
            this.mZw.setVisibility(0);
        } else {
            this.mZw.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mZs.setVisibility(0);
            this.mZt.setVisibility(0);
            return;
        }
        this.mZs.setVisibility(8);
        this.mZt.setVisibility(8);
    }

    public void bS(String str, int i) {
        int i2 = i - 1;
        if (this.mZx != null && i2 < this.mZx.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mZo.setTip(this.mZx[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mZu.setTip(this.mZx[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mZq.setTip(this.mZx[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mZt.setTip(this.mZv.getString(R.string.all_person));
                } else {
                    this.mZt.setTip(this.mZx[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                dn(com.baidu.tbadk.core.sharedPref.b.bvr().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.bvr().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mZx != null) {
            int length = this.mZx.length;
            int dHJ = aVar.dHJ() - 1;
            if (dHJ < length && dHJ >= 0) {
                this.mZu.setTip(this.mZx[dHJ]);
            }
            int dHH = aVar.dHH() - 1;
            if (dHH < length && dHH >= 0) {
                this.mZo.setTip(this.mZx[dHH]);
            }
            int dHI = aVar.dHI() - 1;
            if (dHI < length && dHI >= 0) {
                this.mZq.setTip(this.mZx[dHI]);
            }
            int dHL = aVar.dHL() - 1;
            if (dHL < length && dHL >= 0) {
                if (dHL == 0) {
                    this.mZt.setTip(this.mZv.getString(R.string.all_person));
                } else {
                    this.mZt.setTip(this.mZx[dHL]);
                }
            }
            dn(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void dn(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mZp.setTip(this.mZv.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mZp.setTip(this.mZv.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mZp.setTip(this.mZv.getString(R.string.mark_tip_outside));
        } else {
            this.mZp.setTip(this.mZv.getString(R.string.mark_tip_all));
        }
    }
}
