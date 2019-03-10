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
    private TbSettingTextTipView iqQ;
    private TbSettingTextTipView iqR;
    private TbSettingTextTipView iqS;
    private TbSettingTextTipView iqT;
    private View iqU;
    private TbSettingTextTipView iqV;
    private View iqW;
    private TbSettingTextTipView iqX;
    private SecretSettingActivity iqY;
    private View iqZ;
    private String[] ira;
    private TbSettingTextTipView irb;
    private a irc;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void bYA();

        void bYB();

        void bYC();

        void bYD();

        void bYE();

        void bYF();

        void bYz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.irc != null) {
                    if (view == c.this.bVY) {
                        c.this.irc.onBackPressed();
                    } else if (view == c.this.iqQ) {
                        c.this.irc.bYz();
                    } else if (view == c.this.iqR) {
                        c.this.irc.bYA();
                    } else if (view == c.this.iqS) {
                        c.this.irc.bYC();
                    } else if (view == c.this.iqX) {
                        c.this.irc.bYB();
                    } else if (view == c.this.iqT) {
                        c.this.irc.bYD();
                    } else if (view == c.this.iqV) {
                        c.this.irc.bYE();
                    } else if (view == c.this.irb) {
                        c.this.irc.bYF();
                    }
                }
            }
        };
        this.iqY = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iqY.getLayoutMode().setNightMode(i == 1);
        this.iqY.getLayoutMode().onModeChanged(this.eLG);
        this.mNavigationBar.onChangeSkinType(this.iqY.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.eLG = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.iqQ = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.iqR = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.iqX = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.iqW = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.iqS = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.iqT = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.iqV = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.iqU = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.bVY.setOnClickListener(this.dJa);
        this.iqQ.setOnClickListener(this.dJa);
        this.iqT.setOnClickListener(this.dJa);
        this.iqX.setOnClickListener(this.dJa);
        this.iqR.setOnClickListener(this.dJa);
        this.iqS.setOnClickListener(this.dJa);
        this.iqV.setOnClickListener(this.dJa);
        this.iqZ = this.iqY.findViewById(d.g.privacy_setting_container);
        this.ira = this.iqY.getResources().getStringArray(d.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iqX.setVisibility(0);
            this.iqW.setVisibility(0);
        } else {
            this.iqX.setVisibility(8);
            this.iqW.setVisibility(8);
        }
        this.irb = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_permission);
        this.irb.setOnClickListener(this.dJa);
    }

    public void a(a aVar) {
        this.irc = aVar;
    }

    public void bYG() {
        this.iqQ.recycle();
    }

    public void pv(boolean z) {
        if (z) {
            this.iqZ.setVisibility(0);
        } else {
            this.iqZ.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("reply_private_setting_switch") == 1) {
            this.iqU.setVisibility(0);
            this.iqV.setVisibility(0);
            return;
        }
        this.iqU.setVisibility(8);
        this.iqV.setVisibility(8);
    }

    public void bp(String str, int i) {
        int i2 = i - 1;
        if (this.ira != null && i2 < this.ira.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iqR.setTip(this.ira[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iqX.setTip(this.ira[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iqS.setTip(this.ira[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iqV.setTip(this.iqY.getString(d.j.all_person));
                } else {
                    this.iqV.setTip(this.ira[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.ira != null) {
            int length = this.ira.length;
            int bYu = aVar.bYu() - 1;
            if (bYu < length && bYu >= 0) {
                this.iqX.setTip(this.ira[bYu]);
            }
            int bYt = aVar.bYt() - 1;
            if (bYt < length && bYt >= 0) {
                this.iqR.setTip(this.ira[bYt]);
            }
            int alt = aVar.alt() - 1;
            if (alt < length && alt >= 0) {
                this.iqS.setTip(this.ira[alt]);
            }
            int bYw = aVar.bYw() - 1;
            if (bYw < length && bYw >= 0) {
                if (bYw == 0) {
                    this.iqV.setTip(this.iqY.getString(d.j.all_person));
                } else {
                    this.iqV.setTip(this.ira[bYw]);
                }
            }
        }
    }
}
