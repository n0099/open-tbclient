package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View aIE;
    private View.OnClickListener coI;
    private LinearLayout dnj;
    private TbSettingTextTipView gMK;
    private TbSettingTextTipView gML;
    private TbSettingTextTipView gMM;
    private TbSettingTextTipView gMN;
    private View gMO;
    private TbSettingTextTipView gMP;
    private View gMQ;
    private TbSettingTextTipView gMR;
    private SecretSettingActivity gMS;
    private View gMT;
    private String[] gMU;
    private TbSettingTextTipView gMV;
    private a gMW;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void buZ();

        void bva();

        void bvb();

        void bvc();

        void bvd();

        void bve();

        void bvf();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gMW != null) {
                    if (view == c.this.aIE) {
                        c.this.gMW.onBackPressed();
                    } else if (view == c.this.gMK) {
                        c.this.gMW.buZ();
                    } else if (view == c.this.gML) {
                        c.this.gMW.bva();
                    } else if (view == c.this.gMM) {
                        c.this.gMW.bvc();
                    } else if (view == c.this.gMR) {
                        c.this.gMW.bvb();
                    } else if (view == c.this.gMN) {
                        c.this.gMW.bvd();
                    } else if (view == c.this.gMP) {
                        c.this.gMW.bve();
                    } else if (view == c.this.gMV) {
                        c.this.gMW.bvf();
                    }
                }
            }
        };
        this.gMS = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.gMS.getLayoutMode().setNightMode(i == 1);
        this.gMS.getLayoutMode().onModeChanged(this.dnj);
        this.mNavigationBar.onChangeSkinType(this.gMS.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dnj = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gMK = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gML = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gMR = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gMQ = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gMM = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gMN = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gMP = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gMO = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.aIE.setOnClickListener(this.coI);
        this.gMK.setOnClickListener(this.coI);
        this.gMN.setOnClickListener(this.coI);
        this.gMR.setOnClickListener(this.coI);
        this.gML.setOnClickListener(this.coI);
        this.gMM.setOnClickListener(this.coI);
        this.gMP.setOnClickListener(this.coI);
        this.gMT = this.gMS.findViewById(e.g.privacy_setting_container);
        this.gMU = this.gMS.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gMR.setVisibility(0);
            this.gMQ.setVisibility(0);
        } else {
            this.gMR.setVisibility(8);
            this.gMQ.setVisibility(8);
        }
        this.gMV = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gMV.setOnClickListener(this.coI);
    }

    public void a(a aVar) {
        this.gMW = aVar;
    }

    public void bvg() {
        this.gMK.recycle();
    }

    public void mE(boolean z) {
        if (z) {
            this.gMT.setVisibility(0);
        } else {
            this.gMT.setVisibility(8);
        }
        if (d.iR().aO("reply_private_setting_switch") == 1) {
            this.gMO.setVisibility(0);
            this.gMP.setVisibility(0);
            return;
        }
        this.gMO.setVisibility(8);
        this.gMP.setVisibility(8);
    }

    public void aR(String str, int i) {
        int i2 = i - 1;
        if (this.gMU != null && i2 < this.gMU.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gML.setTip(this.gMU[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gMR.setTip(this.gMU[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gMM.setTip(this.gMU[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gMP.setTip(this.gMS.getString(e.j.all_person));
                } else {
                    this.gMP.setTip(this.gMU[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gMU != null) {
            int length = this.gMU.length;
            int buU = aVar.buU() - 1;
            if (buU < length && buU >= 0) {
                this.gMR.setTip(this.gMU[buU]);
            }
            int buT = aVar.buT() - 1;
            if (buT < length && buT >= 0) {
                this.gML.setTip(this.gMU[buT]);
            }
            int Kl = aVar.Kl() - 1;
            if (Kl < length && Kl >= 0) {
                this.gMM.setTip(this.gMU[Kl]);
            }
            int buW = aVar.buW() - 1;
            if (buW < length && buW >= 0) {
                if (buW == 0) {
                    this.gMP.setTip(this.gMS.getString(e.j.all_person));
                } else {
                    this.gMP.setTip(this.gMU[buW]);
                }
            }
        }
    }
}
