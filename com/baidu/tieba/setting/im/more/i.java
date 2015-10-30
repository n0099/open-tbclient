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
import com.baidu.tieba.i;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<SecretSettingActivity> {
    private View.OnClickListener aKj;
    private LinearLayout aPn;
    private TbSettingTextTipView cLA;
    private TbSettingTextTipView cLB;
    private TbSettingTextTipView cLC;
    private TbSettingTextTipView cLD;
    private View cLE;
    private TbSettingTextTipView cLF;
    private MsgSettingItemView cLG;
    private TextView cLH;
    private MsgSettingItemView cLI;
    private View cLJ;
    private TbSettingTextTipView cLK;
    private SecretSettingActivity cLL;
    private View cLM;
    private String[] cLN;
    private BdSwitchView.a cLO;
    private a cLP;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void ara();

        void arb();

        void arc();

        void ard();

        void are();

        void arf();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aKj = new j(this);
        this.cLO = new k(this);
        this.cLL = secretSettingActivity;
        secretSettingActivity.setContentView(i.g.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cLL.getLayoutMode().ad(i == 1);
        this.cLL.getLayoutMode().k(this.aPn);
        this.mNavigationBar.onChangeSkinType(this.cLL.getPageContext(), i);
        this.cLG.onChangeSkinType(this.cLL.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.aPn = (LinearLayout) secretSettingActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(i.h.secretSetting_title));
        this.cLA = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.black_address_list);
        this.cLB = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_bar);
        this.cLF = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_group);
        this.cLE = secretSettingActivity.findViewById(i.f.divide_line_under_privacy_attention_group);
        this.cLC = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_forum);
        this.cLD = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.user_mute_list);
        this.mBack.setOnClickListener(this.aKj);
        this.cLA.setOnClickListener(this.aKj);
        this.cLD.setOnClickListener(this.aKj);
        this.cLF.setOnClickListener(this.aKj);
        this.cLB.setOnClickListener(this.aKj);
        this.cLC.setOnClickListener(this.aKj);
        this.cLM = this.cLL.findViewById(i.f.privacy_setting_container);
        this.cLN = this.cLL.getResources().getStringArray(i.b.privacy_setting_config);
        this.cLG = (MsgSettingItemView) this.cLL.findViewById(i.f.sv_shared_location);
        this.cLG.setLineVisibility(false);
        this.cLG.setText(i.h.privacy_setting_shared_location);
        this.cLG.setOnSwitchStateChangeListener(this.cLO);
        this.cLI = (MsgSettingItemView) this.cLL.findViewById(i.f.sv_voicelogin_setting);
        this.cLJ = this.cLL.findViewById(i.f.divide_line_voicelogin);
        this.cLK = (TbSettingTextTipView) this.cLL.findViewById(i.f.voicelogin_again);
        this.cLH = (TextView) this.cLL.findViewById(i.f.voicelogin_setting_title);
        this.cLK.setOnClickListener(this.aKj);
        this.cLI.setText(i.h.privacy_setting_voicelogin);
        this.cLI.setTipText(i.h.privacy_setting_voicelogin_tip);
        this.cLI.setOnSwitchStateChangeListener(this.cLO);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.cLF.setVisibility(0);
            this.cLE.setVisibility(0);
            return;
        }
        this.cLF.setVisibility(8);
        this.cLE.setVisibility(8);
    }

    public void a(a aVar) {
        this.cLP = aVar;
    }

    public void arg() {
        this.cLA.recycle();
    }

    public void fR(boolean z) {
        this.cLJ.setVisibility(z ? 0 : 8);
        this.cLK.setVisibility(z ? 0 : 8);
    }

    public void fS(boolean z) {
        if (z) {
            this.cLM.setVisibility(0);
        } else {
            this.cLM.setVisibility(8);
        }
    }

    public void ac(String str, int i) {
        int i2 = i - 1;
        if (this.cLN != null && i2 < this.cLN.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.cLB.setTip(this.cLN[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.cLC.setTip(this.cLN[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.cLF.setTip(this.cLN[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.cLN != null) {
            int length = this.cLN.length;
            int zX = aVar.zX() - 1;
            if (zX < length && zX >= 0) {
                this.cLF.setTip(this.cLN[zX]);
            }
            int aqS = aVar.aqS() - 1;
            if (aqS < length && aqS >= 0) {
                this.cLB.setTip(this.cLN[aqS]);
            }
            int aqQ = aVar.aqQ() - 1;
            if (aqQ < length && aqQ >= 0) {
                this.cLC.setTip(this.cLN[aqQ]);
            }
            fT(aVar.aqT());
        }
    }

    public void fT(boolean z) {
        if (z) {
            this.cLG.getSwitchView().mz();
        } else {
            this.cLG.getSwitchView().mA();
        }
    }

    public void fU(boolean z) {
        this.cLI.setVisibility(z ? 0 : 8);
        this.cLH.setVisibility(z ? 0 : 8);
    }

    public void fV(boolean z) {
        if (z) {
            this.cLI.getSwitchView().mz();
        } else {
            this.cLI.getSwitchView().mA();
        }
    }

    public boolean arh() {
        return this.cLG.getSwitchView().hx();
    }
}
