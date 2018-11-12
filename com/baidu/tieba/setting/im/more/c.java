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
    private View aJu;
    private View.OnClickListener coU;
    private LinearLayout dop;
    private TbSettingTextTipView gOk;
    private TbSettingTextTipView gOl;
    private TbSettingTextTipView gOm;
    private TbSettingTextTipView gOn;
    private View gOo;
    private TbSettingTextTipView gOp;
    private View gOq;
    private TbSettingTextTipView gOr;
    private SecretSettingActivity gOs;
    private View gOt;
    private String[] gOu;
    private TbSettingTextTipView gOv;
    private a gOw;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void buA();

        void buB();

        void buv();

        void buw();

        void bux();

        void buy();

        void buz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gOw != null) {
                    if (view == c.this.aJu) {
                        c.this.gOw.onBackPressed();
                    } else if (view == c.this.gOk) {
                        c.this.gOw.buv();
                    } else if (view == c.this.gOl) {
                        c.this.gOw.buw();
                    } else if (view == c.this.gOm) {
                        c.this.gOw.buy();
                    } else if (view == c.this.gOr) {
                        c.this.gOw.bux();
                    } else if (view == c.this.gOn) {
                        c.this.gOw.buz();
                    } else if (view == c.this.gOp) {
                        c.this.gOw.buA();
                    } else if (view == c.this.gOv) {
                        c.this.gOw.buB();
                    }
                }
            }
        };
        this.gOs = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.gOs.getLayoutMode().setNightMode(i == 1);
        this.gOs.getLayoutMode().onModeChanged(this.dop);
        this.mNavigationBar.onChangeSkinType(this.gOs.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dop = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gOk = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gOl = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gOr = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gOq = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gOm = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gOn = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gOp = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gOo = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.aJu.setOnClickListener(this.coU);
        this.gOk.setOnClickListener(this.coU);
        this.gOn.setOnClickListener(this.coU);
        this.gOr.setOnClickListener(this.coU);
        this.gOl.setOnClickListener(this.coU);
        this.gOm.setOnClickListener(this.coU);
        this.gOp.setOnClickListener(this.coU);
        this.gOt = this.gOs.findViewById(e.g.privacy_setting_container);
        this.gOu = this.gOs.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gOr.setVisibility(0);
            this.gOq.setVisibility(0);
        } else {
            this.gOr.setVisibility(8);
            this.gOq.setVisibility(8);
        }
        this.gOv = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gOv.setOnClickListener(this.coU);
    }

    public void a(a aVar) {
        this.gOw = aVar;
    }

    public void buC() {
        this.gOk.recycle();
    }

    public void mP(boolean z) {
        if (z) {
            this.gOt.setVisibility(0);
        } else {
            this.gOt.setVisibility(8);
        }
        if (d.iQ().aO("reply_private_setting_switch") == 1) {
            this.gOo.setVisibility(0);
            this.gOp.setVisibility(0);
            return;
        }
        this.gOo.setVisibility(8);
        this.gOp.setVisibility(8);
    }

    public void aR(String str, int i) {
        int i2 = i - 1;
        if (this.gOu != null && i2 < this.gOu.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gOl.setTip(this.gOu[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gOr.setTip(this.gOu[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gOm.setTip(this.gOu[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gOp.setTip(this.gOs.getString(e.j.all_person));
                } else {
                    this.gOp.setTip(this.gOu[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gOu != null) {
            int length = this.gOu.length;
            int buq = aVar.buq() - 1;
            if (buq < length && buq >= 0) {
                this.gOr.setTip(this.gOu[buq]);
            }
            int bup = aVar.bup() - 1;
            if (bup < length && bup >= 0) {
                this.gOl.setTip(this.gOu[bup]);
            }
            int Kx = aVar.Kx() - 1;
            if (Kx < length && Kx >= 0) {
                this.gOm.setTip(this.gOu[Kx]);
            }
            int bus = aVar.bus() - 1;
            if (bus < length && bus >= 0) {
                if (bus == 0) {
                    this.gOp.setTip(this.gOs.getString(e.j.all_person));
                } else {
                    this.gOp.setTip(this.gOu[bus]);
                }
            }
        }
    }
}
