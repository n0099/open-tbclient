package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aju;
    private LinearLayout flz;
    private TbSettingTextTipView iSR;
    private TbSettingTextTipView iSS;
    private TbSettingTextTipView iST;
    private TbSettingTextTipView iSU;
    private View iSV;
    private TbSettingTextTipView iSW;
    private TbSettingTextTipView iSX;
    private SecretSettingActivity iSY;
    private View iSZ;
    private String[] iTa;
    private TbSettingTextTipView iTb;
    private a iTc;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void cim();

        void cin();

        void cio();

        void cip();

        void ciq();

        void cir();

        void cis();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iTc != null) {
                    if (view == c.this.mBack) {
                        c.this.iTc.onBackPressed();
                    } else if (view == c.this.iSR) {
                        c.this.iTc.cim();
                    } else if (view == c.this.iSS) {
                        c.this.iTc.cin();
                    } else if (view == c.this.iST) {
                        c.this.iTc.cip();
                    } else if (view == c.this.iSX) {
                        c.this.iTc.cio();
                    } else if (view == c.this.iSU) {
                        c.this.iTc.ciq();
                    } else if (view == c.this.iSW) {
                        c.this.iTc.cir();
                    } else if (view == c.this.iTb) {
                        c.this.iTc.cis();
                    }
                }
            }
        };
        this.iSY = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iSY.getLayoutMode().setNightMode(i == 1);
        this.iSY.getLayoutMode().onModeChanged(this.flz);
        this.mNavigationBar.onChangeSkinType(this.iSY.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.flz = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iSR = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iSS = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iSX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iST = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iSU = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iSW = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iSV = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aju);
        this.iSR.setOnClickListener(this.aju);
        this.iSU.setOnClickListener(this.aju);
        this.iSX.setOnClickListener(this.aju);
        this.iSS.setOnClickListener(this.aju);
        this.iST.setOnClickListener(this.aju);
        this.iSW.setOnClickListener(this.aju);
        this.iSZ = this.iSY.findViewById(R.id.privacy_setting_container);
        this.iTa = this.iSY.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iSX.setVisibility(0);
        } else {
            this.iSX.setVisibility(8);
        }
        this.iTb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iTb.setOnClickListener(this.aju);
    }

    public void a(a aVar) {
        this.iTc = aVar;
    }

    public void cit() {
        this.iSR.recycle();
    }

    public void qn(boolean z) {
        if (z) {
            this.iSZ.setVisibility(0);
        } else {
            this.iSZ.setVisibility(8);
        }
        if (d.ft().af("reply_private_setting_switch") == 1) {
            this.iSV.setVisibility(0);
            this.iSW.setVisibility(0);
            return;
        }
        this.iSV.setVisibility(8);
        this.iSW.setVisibility(8);
    }

    public void bj(String str, int i) {
        int i2 = i - 1;
        if (this.iTa != null && i2 < this.iTa.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iSS.setTip(this.iTa[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.iSX.setTip(this.iTa[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iST.setTip(this.iTa[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iSW.setTip(this.iSY.getString(R.string.all_person));
                } else {
                    this.iSW.setTip(this.iTa[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iTa != null) {
            int length = this.iTa.length;
            int cih = aVar.cih() - 1;
            if (cih < length && cih >= 0) {
                this.iSX.setTip(this.iTa[cih]);
            }
            int cig = aVar.cig() - 1;
            if (cig < length && cig >= 0) {
                this.iSS.setTip(this.iTa[cig]);
            }
            int atz = aVar.atz() - 1;
            if (atz < length && atz >= 0) {
                this.iST.setTip(this.iTa[atz]);
            }
            int cij = aVar.cij() - 1;
            if (cij < length && cij >= 0) {
                if (cij == 0) {
                    this.iSW.setTip(this.iSY.getString(R.string.all_person));
                } else {
                    this.iSW.setTip(this.iTa[cij]);
                }
            }
        }
    }
}
