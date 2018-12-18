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
    private View aMU;
    private View.OnClickListener csN;
    private LinearLayout duP;
    private TbSettingTextTipView gVa;
    private TbSettingTextTipView gVb;
    private TbSettingTextTipView gVc;
    private TbSettingTextTipView gVd;
    private View gVe;
    private TbSettingTextTipView gVf;
    private View gVg;
    private TbSettingTextTipView gVh;
    private SecretSettingActivity gVi;
    private View gVj;
    private String[] gVk;
    private TbSettingTextTipView gVl;
    private a gVm;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void bwn();

        void bwo();

        void bwp();

        void bwq();

        void bwr();

        void bws();

        void bwt();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gVm != null) {
                    if (view == c.this.aMU) {
                        c.this.gVm.onBackPressed();
                    } else if (view == c.this.gVa) {
                        c.this.gVm.bwn();
                    } else if (view == c.this.gVb) {
                        c.this.gVm.bwo();
                    } else if (view == c.this.gVc) {
                        c.this.gVm.bwq();
                    } else if (view == c.this.gVh) {
                        c.this.gVm.bwp();
                    } else if (view == c.this.gVd) {
                        c.this.gVm.bwr();
                    } else if (view == c.this.gVf) {
                        c.this.gVm.bws();
                    } else if (view == c.this.gVl) {
                        c.this.gVm.bwt();
                    }
                }
            }
        };
        this.gVi = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.gVi.getLayoutMode().setNightMode(i == 1);
        this.gVi.getLayoutMode().onModeChanged(this.duP);
        this.mNavigationBar.onChangeSkinType(this.gVi.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.duP = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gVa = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gVb = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gVh = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gVg = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gVc = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gVd = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gVf = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gVe = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.aMU.setOnClickListener(this.csN);
        this.gVa.setOnClickListener(this.csN);
        this.gVd.setOnClickListener(this.csN);
        this.gVh.setOnClickListener(this.csN);
        this.gVb.setOnClickListener(this.csN);
        this.gVc.setOnClickListener(this.csN);
        this.gVf.setOnClickListener(this.csN);
        this.gVj = this.gVi.findViewById(e.g.privacy_setting_container);
        this.gVk = this.gVi.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gVh.setVisibility(0);
            this.gVg.setVisibility(0);
        } else {
            this.gVh.setVisibility(8);
            this.gVg.setVisibility(8);
        }
        this.gVl = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gVl.setOnClickListener(this.csN);
    }

    public void a(a aVar) {
        this.gVm = aVar;
    }

    public void bwu() {
        this.gVa.recycle();
    }

    public void mS(boolean z) {
        if (z) {
            this.gVj.setVisibility(0);
        } else {
            this.gVj.setVisibility(8);
        }
        if (d.iQ().aO("reply_private_setting_switch") == 1) {
            this.gVe.setVisibility(0);
            this.gVf.setVisibility(0);
            return;
        }
        this.gVe.setVisibility(8);
        this.gVf.setVisibility(8);
    }

    public void aS(String str, int i) {
        int i2 = i - 1;
        if (this.gVk != null && i2 < this.gVk.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gVb.setTip(this.gVk[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gVh.setTip(this.gVk[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gVc.setTip(this.gVk[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gVf.setTip(this.gVi.getString(e.j.all_person));
                } else {
                    this.gVf.setTip(this.gVk[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gVk != null) {
            int length = this.gVk.length;
            int bwi = aVar.bwi() - 1;
            if (bwi < length && bwi >= 0) {
                this.gVh.setTip(this.gVk[bwi]);
            }
            int bwh = aVar.bwh() - 1;
            if (bwh < length && bwh >= 0) {
                this.gVb.setTip(this.gVk[bwh]);
            }
            int LB = aVar.LB() - 1;
            if (LB < length && LB >= 0) {
                this.gVc.setTip(this.gVk[LB]);
            }
            int bwk = aVar.bwk() - 1;
            if (bwk < length && bwk >= 0) {
                if (bwk == 0) {
                    this.gVf.setTip(this.gVi.getString(e.j.all_person));
                } else {
                    this.gVf.setTip(this.gVk[bwk]);
                }
            }
        }
    }
}
