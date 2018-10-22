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
    private TbSettingTextTipView gML;
    private TbSettingTextTipView gMM;
    private TbSettingTextTipView gMN;
    private TbSettingTextTipView gMO;
    private View gMP;
    private TbSettingTextTipView gMQ;
    private View gMR;
    private TbSettingTextTipView gMS;
    private SecretSettingActivity gMT;
    private View gMU;
    private String[] gMV;
    private TbSettingTextTipView gMW;
    private a gMX;
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
                if (c.this.gMX != null) {
                    if (view == c.this.aIE) {
                        c.this.gMX.onBackPressed();
                    } else if (view == c.this.gML) {
                        c.this.gMX.buZ();
                    } else if (view == c.this.gMM) {
                        c.this.gMX.bva();
                    } else if (view == c.this.gMN) {
                        c.this.gMX.bvc();
                    } else if (view == c.this.gMS) {
                        c.this.gMX.bvb();
                    } else if (view == c.this.gMO) {
                        c.this.gMX.bvd();
                    } else if (view == c.this.gMQ) {
                        c.this.gMX.bve();
                    } else if (view == c.this.gMW) {
                        c.this.gMX.bvf();
                    }
                }
            }
        };
        this.gMT = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.gMT.getLayoutMode().setNightMode(i == 1);
        this.gMT.getLayoutMode().onModeChanged(this.dnj);
        this.mNavigationBar.onChangeSkinType(this.gMT.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dnj = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gML = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gMM = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gMS = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gMR = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gMN = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gMO = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gMQ = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gMP = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.aIE.setOnClickListener(this.coI);
        this.gML.setOnClickListener(this.coI);
        this.gMO.setOnClickListener(this.coI);
        this.gMS.setOnClickListener(this.coI);
        this.gMM.setOnClickListener(this.coI);
        this.gMN.setOnClickListener(this.coI);
        this.gMQ.setOnClickListener(this.coI);
        this.gMU = this.gMT.findViewById(e.g.privacy_setting_container);
        this.gMV = this.gMT.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gMS.setVisibility(0);
            this.gMR.setVisibility(0);
        } else {
            this.gMS.setVisibility(8);
            this.gMR.setVisibility(8);
        }
        this.gMW = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gMW.setOnClickListener(this.coI);
    }

    public void a(a aVar) {
        this.gMX = aVar;
    }

    public void bvg() {
        this.gML.recycle();
    }

    public void mE(boolean z) {
        if (z) {
            this.gMU.setVisibility(0);
        } else {
            this.gMU.setVisibility(8);
        }
        if (d.iR().aO("reply_private_setting_switch") == 1) {
            this.gMP.setVisibility(0);
            this.gMQ.setVisibility(0);
            return;
        }
        this.gMP.setVisibility(8);
        this.gMQ.setVisibility(8);
    }

    public void aR(String str, int i) {
        int i2 = i - 1;
        if (this.gMV != null && i2 < this.gMV.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gMM.setTip(this.gMV[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gMS.setTip(this.gMV[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gMN.setTip(this.gMV[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gMQ.setTip(this.gMT.getString(e.j.all_person));
                } else {
                    this.gMQ.setTip(this.gMV[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gMV != null) {
            int length = this.gMV.length;
            int buU = aVar.buU() - 1;
            if (buU < length && buU >= 0) {
                this.gMS.setTip(this.gMV[buU]);
            }
            int buT = aVar.buT() - 1;
            if (buT < length && buT >= 0) {
                this.gMM.setTip(this.gMV[buT]);
            }
            int Kl = aVar.Kl() - 1;
            if (Kl < length && Kl >= 0) {
                this.gMN.setTip(this.gMV[Kl]);
            }
            int buW = aVar.buW() - 1;
            if (buW < length && buW >= 0) {
                if (buW == 0) {
                    this.gMQ.setTip(this.gMT.getString(e.j.all_person));
                } else {
                    this.gMQ.setTip(this.gMV[buW]);
                }
            }
        }
    }
}
