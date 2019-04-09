package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View bWc;
    private View.OnClickListener dIp;
    private LinearLayout eLp;
    private View iqA;
    private TbSettingTextTipView iqB;
    private SecretSettingActivity iqC;
    private View iqD;
    private String[] iqE;
    private TbSettingTextTipView iqF;
    private a iqG;
    private TbSettingTextTipView iqu;
    private TbSettingTextTipView iqv;
    private TbSettingTextTipView iqw;
    private TbSettingTextTipView iqx;
    private View iqy;
    private TbSettingTextTipView iqz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void bYA();

        void bYB();

        void bYC();

        void bYD();

        void bYx();

        void bYy();

        void bYz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dIp = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iqG != null) {
                    if (view == c.this.bWc) {
                        c.this.iqG.onBackPressed();
                    } else if (view == c.this.iqu) {
                        c.this.iqG.bYx();
                    } else if (view == c.this.iqv) {
                        c.this.iqG.bYy();
                    } else if (view == c.this.iqw) {
                        c.this.iqG.bYA();
                    } else if (view == c.this.iqB) {
                        c.this.iqG.bYz();
                    } else if (view == c.this.iqx) {
                        c.this.iqG.bYB();
                    } else if (view == c.this.iqz) {
                        c.this.iqG.bYC();
                    } else if (view == c.this.iqF) {
                        c.this.iqG.bYD();
                    }
                }
            }
        };
        this.iqC = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iqC.getLayoutMode().setNightMode(i == 1);
        this.iqC.getLayoutMode().onModeChanged(this.eLp);
        this.mNavigationBar.onChangeSkinType(this.iqC.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.eLp = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.iqu = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.iqv = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.iqB = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.iqA = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.iqw = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.iqx = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.iqz = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.iqy = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.bWc.setOnClickListener(this.dIp);
        this.iqu.setOnClickListener(this.dIp);
        this.iqx.setOnClickListener(this.dIp);
        this.iqB.setOnClickListener(this.dIp);
        this.iqv.setOnClickListener(this.dIp);
        this.iqw.setOnClickListener(this.dIp);
        this.iqz.setOnClickListener(this.dIp);
        this.iqD = this.iqC.findViewById(d.g.privacy_setting_container);
        this.iqE = this.iqC.getResources().getStringArray(d.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iqB.setVisibility(0);
            this.iqA.setVisibility(0);
        } else {
            this.iqB.setVisibility(8);
            this.iqA.setVisibility(8);
        }
        this.iqF = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_permission);
        this.iqF.setOnClickListener(this.dIp);
    }

    public void a(a aVar) {
        this.iqG = aVar;
    }

    public void bYE() {
        this.iqu.recycle();
    }

    public void pv(boolean z) {
        if (z) {
            this.iqD.setVisibility(0);
        } else {
            this.iqD.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("reply_private_setting_switch") == 1) {
            this.iqy.setVisibility(0);
            this.iqz.setVisibility(0);
            return;
        }
        this.iqy.setVisibility(8);
        this.iqz.setVisibility(8);
    }

    public void bp(String str, int i) {
        int i2 = i - 1;
        if (this.iqE != null && i2 < this.iqE.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iqv.setTip(this.iqE[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iqB.setTip(this.iqE[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iqw.setTip(this.iqE[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iqz.setTip(this.iqC.getString(d.j.all_person));
                } else {
                    this.iqz.setTip(this.iqE[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iqE != null) {
            int length = this.iqE.length;
            int bYs = aVar.bYs() - 1;
            if (bYs < length && bYs >= 0) {
                this.iqB.setTip(this.iqE[bYs]);
            }
            int bYr = aVar.bYr() - 1;
            if (bYr < length && bYr >= 0) {
                this.iqv.setTip(this.iqE[bYr]);
            }
            int alp = aVar.alp() - 1;
            if (alp < length && alp >= 0) {
                this.iqw.setTip(this.iqE[alp]);
            }
            int bYu = aVar.bYu() - 1;
            if (bYu < length && bYu >= 0) {
                if (bYu == 0) {
                    this.iqz.setTip(this.iqC.getString(d.j.all_person));
                } else {
                    this.iqz.setTip(this.iqE[bYu]);
                }
            }
        }
    }
}
