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
    private LinearLayout geu;
    private TbSettingTextTipView jQZ;
    private TbSettingTextTipView jRa;
    private TbSettingTextTipView jRb;
    private TbSettingTextTipView jRc;
    private View jRd;
    private TbSettingTextTipView jRe;
    private TbSettingTextTipView jRf;
    private SecretSettingActivity jRg;
    private View jRh;
    private String[] jRi;
    private TbSettingTextTipView jRj;
    private a jRk;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cEW();

        void cEX();

        void cEY();

        void cEZ();

        void cFa();

        void cFb();

        void cFc();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.jRk != null) {
                    if (view == c.this.mBack) {
                        c.this.jRk.onBackPressed();
                    } else if (view == c.this.jQZ) {
                        c.this.jRk.cEW();
                    } else if (view == c.this.jRa) {
                        c.this.jRk.cEX();
                    } else if (view == c.this.jRb) {
                        c.this.jRk.cEZ();
                    } else if (view == c.this.jRf) {
                        c.this.jRk.cEY();
                    } else if (view == c.this.jRc) {
                        c.this.jRk.cFa();
                    } else if (view == c.this.jRe) {
                        c.this.jRk.cFb();
                    } else if (view == c.this.jRj) {
                        c.this.jRk.cFc();
                    }
                }
            }
        };
        this.jRg = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.jRg.getLayoutMode().setNightMode(i == 1);
        this.jRg.getLayoutMode().onModeChanged(this.geu);
        this.mNavigationBar.onChangeSkinType(this.jRg.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.geu = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.jQZ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.jRa = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.jRf = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.jRb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.jRc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.jRe = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.jRd = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.auX);
        this.jQZ.setOnClickListener(this.auX);
        this.jRc.setOnClickListener(this.auX);
        this.jRf.setOnClickListener(this.auX);
        this.jRa.setOnClickListener(this.auX);
        this.jRb.setOnClickListener(this.auX);
        this.jRe.setOnClickListener(this.auX);
        this.jRh = this.jRg.findViewById(R.id.privacy_setting_container);
        this.jRi = this.jRg.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.jRf.setVisibility(0);
        } else {
            this.jRf.setVisibility(8);
        }
        this.jRj = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.jRj.setOnClickListener(this.auX);
    }

    public void a(a aVar) {
        this.jRk = aVar;
    }

    public void cFd() {
        this.jQZ.recycle();
    }

    public void sl(boolean z) {
        if (z) {
            this.jRh.setVisibility(0);
        } else {
            this.jRh.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.jRd.setVisibility(0);
            this.jRe.setVisibility(0);
            return;
        }
        this.jRd.setVisibility(8);
        this.jRe.setVisibility(8);
    }

    public void bs(String str, int i) {
        int i2 = i - 1;
        if (this.jRi != null && i2 < this.jRi.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.jRa.setTip(this.jRi[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.jRf.setTip(this.jRi[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.jRb.setTip(this.jRi[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.jRe.setTip(this.jRg.getString(R.string.all_person));
                } else {
                    this.jRe.setTip(this.jRi[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.jRi != null) {
            int length = this.jRi.length;
            int cER = aVar.cER() - 1;
            if (cER < length && cER >= 0) {
                this.jRf.setTip(this.jRi[cER]);
            }
            int cEP = aVar.cEP() - 1;
            if (cEP < length && cEP >= 0) {
                this.jRa.setTip(this.jRi[cEP]);
            }
            int cEQ = aVar.cEQ() - 1;
            if (cEQ < length && cEQ >= 0) {
                this.jRb.setTip(this.jRi[cEQ]);
            }
            int cET = aVar.cET() - 1;
            if (cET < length && cET >= 0) {
                if (cET == 0) {
                    this.jRe.setTip(this.jRg.getString(R.string.all_person));
                } else {
                    this.jRe.setTip(this.jRi[cET]);
                }
            }
        }
    }
}
