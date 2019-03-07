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
    private View bVY;
    private View.OnClickListener dJa;
    private LinearLayout eLG;
    private TbSettingTextTipView iqP;
    private TbSettingTextTipView iqQ;
    private TbSettingTextTipView iqR;
    private TbSettingTextTipView iqS;
    private View iqT;
    private TbSettingTextTipView iqU;
    private View iqV;
    private TbSettingTextTipView iqW;
    private SecretSettingActivity iqX;
    private View iqY;
    private String[] iqZ;
    private TbSettingTextTipView ira;
    private a irb;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void bYA();

        void bYB();

        void bYC();

        void bYD();

        void bYE();

        void bYy();

        void bYz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.irb != null) {
                    if (view == c.this.bVY) {
                        c.this.irb.onBackPressed();
                    } else if (view == c.this.iqP) {
                        c.this.irb.bYy();
                    } else if (view == c.this.iqQ) {
                        c.this.irb.bYz();
                    } else if (view == c.this.iqR) {
                        c.this.irb.bYB();
                    } else if (view == c.this.iqW) {
                        c.this.irb.bYA();
                    } else if (view == c.this.iqS) {
                        c.this.irb.bYC();
                    } else if (view == c.this.iqU) {
                        c.this.irb.bYD();
                    } else if (view == c.this.ira) {
                        c.this.irb.bYE();
                    }
                }
            }
        };
        this.iqX = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iqX.getLayoutMode().setNightMode(i == 1);
        this.iqX.getLayoutMode().onModeChanged(this.eLG);
        this.mNavigationBar.onChangeSkinType(this.iqX.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.eLG = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.iqP = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.iqQ = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.iqW = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.iqV = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.iqR = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.iqS = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.iqU = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.iqT = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.bVY.setOnClickListener(this.dJa);
        this.iqP.setOnClickListener(this.dJa);
        this.iqS.setOnClickListener(this.dJa);
        this.iqW.setOnClickListener(this.dJa);
        this.iqQ.setOnClickListener(this.dJa);
        this.iqR.setOnClickListener(this.dJa);
        this.iqU.setOnClickListener(this.dJa);
        this.iqY = this.iqX.findViewById(d.g.privacy_setting_container);
        this.iqZ = this.iqX.getResources().getStringArray(d.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iqW.setVisibility(0);
            this.iqV.setVisibility(0);
        } else {
            this.iqW.setVisibility(8);
            this.iqV.setVisibility(8);
        }
        this.ira = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_permission);
        this.ira.setOnClickListener(this.dJa);
    }

    public void a(a aVar) {
        this.irb = aVar;
    }

    public void bYF() {
        this.iqP.recycle();
    }

    public void pv(boolean z) {
        if (z) {
            this.iqY.setVisibility(0);
        } else {
            this.iqY.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("reply_private_setting_switch") == 1) {
            this.iqT.setVisibility(0);
            this.iqU.setVisibility(0);
            return;
        }
        this.iqT.setVisibility(8);
        this.iqU.setVisibility(8);
    }

    public void bp(String str, int i) {
        int i2 = i - 1;
        if (this.iqZ != null && i2 < this.iqZ.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iqQ.setTip(this.iqZ[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iqW.setTip(this.iqZ[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iqR.setTip(this.iqZ[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iqU.setTip(this.iqX.getString(d.j.all_person));
                } else {
                    this.iqU.setTip(this.iqZ[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iqZ != null) {
            int length = this.iqZ.length;
            int bYt = aVar.bYt() - 1;
            if (bYt < length && bYt >= 0) {
                this.iqW.setTip(this.iqZ[bYt]);
            }
            int bYs = aVar.bYs() - 1;
            if (bYs < length && bYs >= 0) {
                this.iqQ.setTip(this.iqZ[bYs]);
            }
            int alt = aVar.alt() - 1;
            if (alt < length && alt >= 0) {
                this.iqR.setTip(this.iqZ[alt]);
            }
            int bYv = aVar.bYv() - 1;
            if (bYv < length && bYv >= 0) {
                if (bYv == 0) {
                    this.iqU.setTip(this.iqX.getString(d.j.all_person));
                } else {
                    this.iqU.setTip(this.iqZ[bYv]);
                }
            }
        }
    }
}
