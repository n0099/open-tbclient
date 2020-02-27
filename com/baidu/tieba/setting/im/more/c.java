package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener auX;
    private LinearLayout ges;
    private TbSettingTextTipView jQX;
    private TbSettingTextTipView jQY;
    private TbSettingTextTipView jQZ;
    private TbSettingTextTipView jRa;
    private View jRb;
    private TbSettingTextTipView jRc;
    private TbSettingTextTipView jRd;
    private SecretSettingActivity jRe;
    private View jRf;
    private String[] jRg;
    private TbSettingTextTipView jRh;
    private a jRi;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cEU();

        void cEV();

        void cEW();

        void cEX();

        void cEY();

        void cEZ();

        void cFa();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.jRi != null) {
                    if (view == c.this.mBack) {
                        c.this.jRi.onBackPressed();
                    } else if (view == c.this.jQX) {
                        c.this.jRi.cEU();
                    } else if (view == c.this.jQY) {
                        c.this.jRi.cEV();
                    } else if (view == c.this.jQZ) {
                        c.this.jRi.cEX();
                    } else if (view == c.this.jRd) {
                        c.this.jRi.cEW();
                    } else if (view == c.this.jRa) {
                        c.this.jRi.cEY();
                    } else if (view == c.this.jRc) {
                        c.this.jRi.cEZ();
                    } else if (view == c.this.jRh) {
                        c.this.jRi.cFa();
                    }
                }
            }
        };
        this.jRe = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.jRe.getLayoutMode().setNightMode(i == 1);
        this.jRe.getLayoutMode().onModeChanged(this.ges);
        this.mNavigationBar.onChangeSkinType(this.jRe.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.ges = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.jQX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.jQY = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.jRd = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.jQZ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.jRa = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.jRc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.jRb = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.auX);
        this.jQX.setOnClickListener(this.auX);
        this.jRa.setOnClickListener(this.auX);
        this.jRd.setOnClickListener(this.auX);
        this.jQY.setOnClickListener(this.auX);
        this.jQZ.setOnClickListener(this.auX);
        this.jRc.setOnClickListener(this.auX);
        this.jRf = this.jRe.findViewById(R.id.privacy_setting_container);
        this.jRg = this.jRe.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.jRd.setVisibility(0);
        } else {
            this.jRd.setVisibility(8);
        }
        this.jRh = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.jRh.setOnClickListener(this.auX);
    }

    public void a(a aVar) {
        this.jRi = aVar;
    }

    public void cFb() {
        this.jQX.recycle();
    }

    public void sl(boolean z) {
        if (z) {
            this.jRf.setVisibility(0);
        } else {
            this.jRf.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.jRb.setVisibility(0);
            this.jRc.setVisibility(0);
            return;
        }
        this.jRb.setVisibility(8);
        this.jRc.setVisibility(8);
    }

    public void bs(String str, int i) {
        int i2 = i - 1;
        if (this.jRg != null && i2 < this.jRg.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.jQY.setTip(this.jRg[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.jRd.setTip(this.jRg[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.jQZ.setTip(this.jRg[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.jRc.setTip(this.jRe.getString(R.string.all_person));
                } else {
                    this.jRc.setTip(this.jRg[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.jRg != null) {
            int length = this.jRg.length;
            int cEP = aVar.cEP() - 1;
            if (cEP < length && cEP >= 0) {
                this.jRd.setTip(this.jRg[cEP]);
            }
            int cEN = aVar.cEN() - 1;
            if (cEN < length && cEN >= 0) {
                this.jQY.setTip(this.jRg[cEN]);
            }
            int cEO = aVar.cEO() - 1;
            if (cEO < length && cEO >= 0) {
                this.jQZ.setTip(this.jRg[cEO]);
            }
            int cER = aVar.cER() - 1;
            if (cER < length && cER >= 0) {
                if (cER == 0) {
                    this.jRc.setTip(this.jRe.getString(R.string.all_person));
                } else {
                    this.jRc.setTip(this.jRg[cER]);
                }
            }
        }
    }
}
