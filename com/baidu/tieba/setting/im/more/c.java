package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener awi;
    private LinearLayout hvx;
    private TbSettingTextTipView lwA;
    private TbSettingTextTipView lwB;
    private View lwC;
    private TbSettingTextTipView lwD;
    private TbSettingTextTipView lwE;
    private SecretSettingActivity lwF;
    private View lwG;
    private String[] lwH;
    private TbSettingTextTipView lwI;
    private a lwJ;
    private TbSettingTextTipView lwy;
    private TbSettingTextTipView lwz;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes20.dex */
    public interface a {
        void deD();

        void deE();

        void deF();

        void deG();

        void deH();

        void deI();

        void deJ();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.lwJ != null) {
                    if (view == c.this.mBack) {
                        c.this.lwJ.onBackPressed();
                    } else if (view == c.this.lwy) {
                        c.this.lwJ.deD();
                    } else if (view == c.this.lwz) {
                        c.this.lwJ.deE();
                    } else if (view == c.this.lwA) {
                        c.this.lwJ.deG();
                    } else if (view == c.this.lwE) {
                        c.this.lwJ.deF();
                    } else if (view == c.this.lwB) {
                        c.this.lwJ.deH();
                    } else if (view == c.this.lwD) {
                        c.this.lwJ.deI();
                    } else if (view == c.this.lwI) {
                        c.this.lwJ.deJ();
                    }
                }
            }
        };
        this.lwF = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.lwF.getLayoutMode().setNightMode(i == 1);
        this.lwF.getLayoutMode().onModeChanged(this.hvx);
        this.mNavigationBar.onChangeSkinType(this.lwF.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.hvx = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.lwy = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.lwz = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.lwE = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.lwA = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.lwB = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.lwD = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.lwC = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.awi);
        this.lwy.setOnClickListener(this.awi);
        this.lwB.setOnClickListener(this.awi);
        this.lwE.setOnClickListener(this.awi);
        this.lwz.setOnClickListener(this.awi);
        this.lwA.setOnClickListener(this.awi);
        this.lwD.setOnClickListener(this.awi);
        this.lwG = this.lwF.findViewById(R.id.privacy_setting_container);
        this.lwH = this.lwF.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.lwE.setVisibility(0);
        } else {
            this.lwE.setVisibility(8);
        }
        this.lwI = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.lwI.setOnClickListener(this.awi);
    }

    public void a(a aVar) {
        this.lwJ = aVar;
    }

    public void deK() {
        this.lwy.recycle();
    }

    public void uJ(boolean z) {
        if (z) {
            this.lwG.setVisibility(0);
        } else {
            this.lwG.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.lwC.setVisibility(0);
            this.lwD.setVisibility(0);
            return;
        }
        this.lwC.setVisibility(8);
        this.lwD.setVisibility(8);
    }

    public void bA(String str, int i) {
        int i2 = i - 1;
        if (this.lwH != null && i2 < this.lwH.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.lwz.setTip(this.lwH[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.lwE.setTip(this.lwH[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.lwA.setTip(this.lwH[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.lwD.setTip(this.lwF.getString(R.string.all_person));
                } else {
                    this.lwD.setTip(this.lwH[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.lwH != null) {
            int length = this.lwH.length;
            int dey = aVar.dey() - 1;
            if (dey < length && dey >= 0) {
                this.lwE.setTip(this.lwH[dey]);
            }
            int dew = aVar.dew() - 1;
            if (dew < length && dew >= 0) {
                this.lwz.setTip(this.lwH[dew]);
            }
            int dex = aVar.dex() - 1;
            if (dex < length && dex >= 0) {
                this.lwA.setTip(this.lwH[dex]);
            }
            int deA = aVar.deA() - 1;
            if (deA < length && deA >= 0) {
                if (deA == 0) {
                    this.lwD.setTip(this.lwF.getString(R.string.all_person));
                } else {
                    this.lwD.setTip(this.lwH[deA]);
                }
            }
        }
    }
}
