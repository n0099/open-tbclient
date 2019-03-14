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
    private View bVZ;
    private View.OnClickListener dIW;
    private LinearLayout eLC;
    private TbSettingTextTipView iqJ;
    private TbSettingTextTipView iqK;
    private TbSettingTextTipView iqL;
    private TbSettingTextTipView iqM;
    private View iqN;
    private TbSettingTextTipView iqO;
    private View iqP;
    private TbSettingTextTipView iqQ;
    private SecretSettingActivity iqR;
    private View iqS;
    private String[] iqT;
    private TbSettingTextTipView iqU;
    private a iqV;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void bYB();

        void bYC();

        void bYD();

        void bYE();

        void bYF();

        void bYG();

        void bYH();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iqV != null) {
                    if (view == c.this.bVZ) {
                        c.this.iqV.onBackPressed();
                    } else if (view == c.this.iqJ) {
                        c.this.iqV.bYB();
                    } else if (view == c.this.iqK) {
                        c.this.iqV.bYC();
                    } else if (view == c.this.iqL) {
                        c.this.iqV.bYE();
                    } else if (view == c.this.iqQ) {
                        c.this.iqV.bYD();
                    } else if (view == c.this.iqM) {
                        c.this.iqV.bYF();
                    } else if (view == c.this.iqO) {
                        c.this.iqV.bYG();
                    } else if (view == c.this.iqU) {
                        c.this.iqV.bYH();
                    }
                }
            }
        };
        this.iqR = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iqR.getLayoutMode().setNightMode(i == 1);
        this.iqR.getLayoutMode().onModeChanged(this.eLC);
        this.mNavigationBar.onChangeSkinType(this.iqR.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.eLC = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.iqJ = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.iqK = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.iqQ = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.iqP = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.iqL = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.iqM = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.iqO = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.iqN = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.bVZ.setOnClickListener(this.dIW);
        this.iqJ.setOnClickListener(this.dIW);
        this.iqM.setOnClickListener(this.dIW);
        this.iqQ.setOnClickListener(this.dIW);
        this.iqK.setOnClickListener(this.dIW);
        this.iqL.setOnClickListener(this.dIW);
        this.iqO.setOnClickListener(this.dIW);
        this.iqS = this.iqR.findViewById(d.g.privacy_setting_container);
        this.iqT = this.iqR.getResources().getStringArray(d.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iqQ.setVisibility(0);
            this.iqP.setVisibility(0);
        } else {
            this.iqQ.setVisibility(8);
            this.iqP.setVisibility(8);
        }
        this.iqU = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_permission);
        this.iqU.setOnClickListener(this.dIW);
    }

    public void a(a aVar) {
        this.iqV = aVar;
    }

    public void bYI() {
        this.iqJ.recycle();
    }

    public void pv(boolean z) {
        if (z) {
            this.iqS.setVisibility(0);
        } else {
            this.iqS.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("reply_private_setting_switch") == 1) {
            this.iqN.setVisibility(0);
            this.iqO.setVisibility(0);
            return;
        }
        this.iqN.setVisibility(8);
        this.iqO.setVisibility(8);
    }

    public void bp(String str, int i) {
        int i2 = i - 1;
        if (this.iqT != null && i2 < this.iqT.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iqK.setTip(this.iqT[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iqQ.setTip(this.iqT[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iqL.setTip(this.iqT[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iqO.setTip(this.iqR.getString(d.j.all_person));
                } else {
                    this.iqO.setTip(this.iqT[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iqT != null) {
            int length = this.iqT.length;
            int bYw = aVar.bYw() - 1;
            if (bYw < length && bYw >= 0) {
                this.iqQ.setTip(this.iqT[bYw]);
            }
            int bYv = aVar.bYv() - 1;
            if (bYv < length && bYv >= 0) {
                this.iqK.setTip(this.iqT[bYv]);
            }
            int als = aVar.als() - 1;
            if (als < length && als >= 0) {
                this.iqL.setTip(this.iqT[als]);
            }
            int bYy = aVar.bYy() - 1;
            if (bYy < length && bYy >= 0) {
                if (bYy == 0) {
                    this.iqO.setTip(this.iqR.getString(d.j.all_person));
                } else {
                    this.iqO.setTip(this.iqT[bYy]);
                }
            }
        }
    }
}
