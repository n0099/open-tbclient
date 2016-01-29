package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<SecretSettingActivity> {
    private View.OnClickListener aTD;
    private View ajk;
    private LinearLayout baO;
    private TbSettingTextTipView dIA;
    private TbSettingTextTipView dIB;
    private View dIC;
    private TbSettingTextTipView dID;
    private MsgSettingItemView dIE;
    private TextView dIF;
    private MsgSettingItemView dIG;
    private View dIH;
    private TbSettingTextTipView dII;
    private SecretSettingActivity dIJ;
    private View dIK;
    private String[] dIL;
    private BdSwitchView.a dIM;
    private a dIN;
    private TbSettingTextTipView dIy;
    private TbSettingTextTipView dIz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void aGs();

        void aGt();

        void aGu();

        void aGv();

        void aGw();

        void aGx();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aTD = new j(this);
        this.dIM = new k(this);
        this.dIJ = secretSettingActivity;
        secretSettingActivity.setContentView(t.h.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.dIJ.getLayoutMode().ac(i == 1);
        this.dIJ.getLayoutMode().x(this.baO);
        this.mNavigationBar.onChangeSkinType(this.dIJ.getPageContext(), i);
        this.dIE.d(this.dIJ.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.baO = (LinearLayout) secretSettingActivity.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(t.g.view_navigation_bar);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(t.j.secretSetting_title));
        this.dIy = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.black_address_list);
        this.dIz = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.privacy_attention_bar);
        this.dID = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.privacy_attention_group);
        this.dIC = secretSettingActivity.findViewById(t.g.divide_line_under_privacy_attention_group);
        this.dIA = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.privacy_attention_forum);
        this.dIB = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.user_mute_list);
        this.ajk.setOnClickListener(this.aTD);
        this.dIy.setOnClickListener(this.aTD);
        this.dIB.setOnClickListener(this.aTD);
        this.dID.setOnClickListener(this.aTD);
        this.dIz.setOnClickListener(this.aTD);
        this.dIA.setOnClickListener(this.aTD);
        this.dIK = this.dIJ.findViewById(t.g.privacy_setting_container);
        this.dIL = this.dIJ.getResources().getStringArray(t.b.privacy_setting_config);
        this.dIE = (MsgSettingItemView) this.dIJ.findViewById(t.g.sv_shared_location);
        this.dIE.setLineVisibility(false);
        this.dIE.setText(t.j.privacy_setting_shared_location);
        this.dIE.setOnSwitchStateChangeListener(this.dIM);
        this.dIG = (MsgSettingItemView) this.dIJ.findViewById(t.g.sv_voicelogin_setting);
        this.dIH = this.dIJ.findViewById(t.g.divide_line_voicelogin);
        this.dII = (TbSettingTextTipView) this.dIJ.findViewById(t.g.voicelogin_again);
        this.dIF = (TextView) this.dIJ.findViewById(t.g.voicelogin_setting_title);
        this.dII.setOnClickListener(this.aTD);
        this.dIG.setText(t.j.privacy_setting_voicelogin);
        this.dIG.setTipText(t.j.privacy_setting_voicelogin_tip);
        this.dIG.setOnSwitchStateChangeListener(this.dIM);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.dID.setVisibility(0);
            this.dIC.setVisibility(0);
            return;
        }
        this.dID.setVisibility(8);
        this.dIC.setVisibility(8);
    }

    public void a(a aVar) {
        this.dIN = aVar;
    }

    public void aGy() {
        this.dIy.recycle();
    }

    public void hs(boolean z) {
        this.dIH.setVisibility(z ? 0 : 8);
        this.dII.setVisibility(z ? 0 : 8);
    }

    public void ht(boolean z) {
        if (z) {
            this.dIK.setVisibility(0);
        } else {
            this.dIK.setVisibility(8);
        }
    }

    public void ak(String str, int i) {
        int i2 = i - 1;
        if (this.dIL != null && i2 < this.dIL.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.dIz.setTip(this.dIL[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.dIA.setTip(this.dIL[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.dID.setTip(this.dIL[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.dIL != null) {
            int length = this.dIL.length;
            int Cd = aVar.Cd() - 1;
            if (Cd < length && Cd >= 0) {
                this.dID.setTip(this.dIL[Cd]);
            }
            int aGk = aVar.aGk() - 1;
            if (aGk < length && aGk >= 0) {
                this.dIz.setTip(this.dIL[aGk]);
            }
            int aGi = aVar.aGi() - 1;
            if (aGi < length && aGi >= 0) {
                this.dIA.setTip(this.dIL[aGi]);
            }
            hu(aVar.aGl());
        }
    }

    public void hu(boolean z) {
        if (z) {
            this.dIE.getSwitchView().mq();
        } else {
            this.dIE.getSwitchView().mr();
        }
    }

    public void hv(boolean z) {
        this.dIG.setVisibility(z ? 0 : 8);
        this.dIF.setVisibility(z ? 0 : 8);
    }

    public void hw(boolean z) {
        if (z) {
            this.dIG.getSwitchView().mq();
        } else {
            this.dIG.getSwitchView().mr();
        }
    }

    public boolean aGz() {
        return this.dIE.getSwitchView().hI();
    }
}
