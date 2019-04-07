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
    private View bWb;
    private View.OnClickListener dIo;
    private LinearLayout eLo;
    private TbSettingTextTipView iqA;
    private SecretSettingActivity iqB;
    private View iqC;
    private String[] iqD;
    private TbSettingTextTipView iqE;
    private a iqF;
    private TbSettingTextTipView iqt;
    private TbSettingTextTipView iqu;
    private TbSettingTextTipView iqv;
    private TbSettingTextTipView iqw;
    private View iqx;
    private TbSettingTextTipView iqy;
    private View iqz;
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
        this.dIo = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iqF != null) {
                    if (view == c.this.bWb) {
                        c.this.iqF.onBackPressed();
                    } else if (view == c.this.iqt) {
                        c.this.iqF.bYx();
                    } else if (view == c.this.iqu) {
                        c.this.iqF.bYy();
                    } else if (view == c.this.iqv) {
                        c.this.iqF.bYA();
                    } else if (view == c.this.iqA) {
                        c.this.iqF.bYz();
                    } else if (view == c.this.iqw) {
                        c.this.iqF.bYB();
                    } else if (view == c.this.iqy) {
                        c.this.iqF.bYC();
                    } else if (view == c.this.iqE) {
                        c.this.iqF.bYD();
                    }
                }
            }
        };
        this.iqB = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iqB.getLayoutMode().setNightMode(i == 1);
        this.iqB.getLayoutMode().onModeChanged(this.eLo);
        this.mNavigationBar.onChangeSkinType(this.iqB.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.eLo = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.iqt = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.iqu = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.iqA = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.iqz = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.iqv = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.iqw = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.iqy = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.iqx = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.bWb.setOnClickListener(this.dIo);
        this.iqt.setOnClickListener(this.dIo);
        this.iqw.setOnClickListener(this.dIo);
        this.iqA.setOnClickListener(this.dIo);
        this.iqu.setOnClickListener(this.dIo);
        this.iqv.setOnClickListener(this.dIo);
        this.iqy.setOnClickListener(this.dIo);
        this.iqC = this.iqB.findViewById(d.g.privacy_setting_container);
        this.iqD = this.iqB.getResources().getStringArray(d.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iqA.setVisibility(0);
            this.iqz.setVisibility(0);
        } else {
            this.iqA.setVisibility(8);
            this.iqz.setVisibility(8);
        }
        this.iqE = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_permission);
        this.iqE.setOnClickListener(this.dIo);
    }

    public void a(a aVar) {
        this.iqF = aVar;
    }

    public void bYE() {
        this.iqt.recycle();
    }

    public void pv(boolean z) {
        if (z) {
            this.iqC.setVisibility(0);
        } else {
            this.iqC.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("reply_private_setting_switch") == 1) {
            this.iqx.setVisibility(0);
            this.iqy.setVisibility(0);
            return;
        }
        this.iqx.setVisibility(8);
        this.iqy.setVisibility(8);
    }

    public void bp(String str, int i) {
        int i2 = i - 1;
        if (this.iqD != null && i2 < this.iqD.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iqu.setTip(this.iqD[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iqA.setTip(this.iqD[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iqv.setTip(this.iqD[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iqy.setTip(this.iqB.getString(d.j.all_person));
                } else {
                    this.iqy.setTip(this.iqD[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iqD != null) {
            int length = this.iqD.length;
            int bYs = aVar.bYs() - 1;
            if (bYs < length && bYs >= 0) {
                this.iqA.setTip(this.iqD[bYs]);
            }
            int bYr = aVar.bYr() - 1;
            if (bYr < length && bYr >= 0) {
                this.iqu.setTip(this.iqD[bYr]);
            }
            int alp = aVar.alp() - 1;
            if (alp < length && alp >= 0) {
                this.iqv.setTip(this.iqD[alp]);
            }
            int bYu = aVar.bYu() - 1;
            if (bYu < length && bYu >= 0) {
                if (bYu == 0) {
                    this.iqy.setTip(this.iqB.getString(d.j.all_person));
                } else {
                    this.iqy.setTip(this.iqD[bYu]);
                }
            }
        }
    }
}
