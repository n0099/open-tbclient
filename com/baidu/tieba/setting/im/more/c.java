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
    private TbSettingTextTipView lwC;
    private TbSettingTextTipView lwD;
    private View lwE;
    private TbSettingTextTipView lwF;
    private TbSettingTextTipView lwG;
    private SecretSettingActivity lwH;
    private View lwI;
    private String[] lwJ;
    private TbSettingTextTipView lwK;
    private a lwL;
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
                if (c.this.lwL != null) {
                    if (view == c.this.mBack) {
                        c.this.lwL.onBackPressed();
                    } else if (view == c.this.lwA) {
                        c.this.lwL.deD();
                    } else if (view == c.this.lwB) {
                        c.this.lwL.deE();
                    } else if (view == c.this.lwC) {
                        c.this.lwL.deG();
                    } else if (view == c.this.lwG) {
                        c.this.lwL.deF();
                    } else if (view == c.this.lwD) {
                        c.this.lwL.deH();
                    } else if (view == c.this.lwF) {
                        c.this.lwL.deI();
                    } else if (view == c.this.lwK) {
                        c.this.lwL.deJ();
                    }
                }
            }
        };
        this.lwH = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.lwH.getLayoutMode().setNightMode(i == 1);
        this.lwH.getLayoutMode().onModeChanged(this.hvx);
        this.mNavigationBar.onChangeSkinType(this.lwH.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.hvx = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.lwA = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.lwB = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.lwG = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.lwC = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.lwD = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.lwF = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.lwE = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.awi);
        this.lwA.setOnClickListener(this.awi);
        this.lwD.setOnClickListener(this.awi);
        this.lwG.setOnClickListener(this.awi);
        this.lwB.setOnClickListener(this.awi);
        this.lwC.setOnClickListener(this.awi);
        this.lwF.setOnClickListener(this.awi);
        this.lwI = this.lwH.findViewById(R.id.privacy_setting_container);
        this.lwJ = this.lwH.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.lwG.setVisibility(0);
        } else {
            this.lwG.setVisibility(8);
        }
        this.lwK = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.lwK.setOnClickListener(this.awi);
    }

    public void a(a aVar) {
        this.lwL = aVar;
    }

    public void deK() {
        this.lwA.recycle();
    }

    public void uJ(boolean z) {
        if (z) {
            this.lwI.setVisibility(0);
        } else {
            this.lwI.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.lwE.setVisibility(0);
            this.lwF.setVisibility(0);
            return;
        }
        this.lwE.setVisibility(8);
        this.lwF.setVisibility(8);
    }

    public void bA(String str, int i) {
        int i2 = i - 1;
        if (this.lwJ != null && i2 < this.lwJ.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.lwB.setTip(this.lwJ[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.lwG.setTip(this.lwJ[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.lwC.setTip(this.lwJ[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.lwF.setTip(this.lwH.getString(R.string.all_person));
                } else {
                    this.lwF.setTip(this.lwJ[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.lwJ != null) {
            int length = this.lwJ.length;
            int dey = aVar.dey() - 1;
            if (dey < length && dey >= 0) {
                this.lwG.setTip(this.lwJ[dey]);
            }
            int dew = aVar.dew() - 1;
            if (dew < length && dew >= 0) {
                this.lwB.setTip(this.lwJ[dew]);
            }
            int dex = aVar.dex() - 1;
            if (dex < length && dex >= 0) {
                this.lwC.setTip(this.lwJ[dex]);
            }
            int deA = aVar.deA() - 1;
            if (deA < length && deA >= 0) {
                if (deA == 0) {
                    this.lwF.setTip(this.lwH.getString(R.string.all_person));
                } else {
                    this.lwF.setTip(this.lwJ[deA]);
                }
            }
        }
    }
}
