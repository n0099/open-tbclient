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
    private View.OnClickListener aKT;
    private LinearLayout aPS;
    private TbSettingTextTipView cvE;
    private TbSettingTextTipView cvF;
    private TbSettingTextTipView cvG;
    private TbSettingTextTipView cvH;
    private View cvI;
    private TbSettingTextTipView cvJ;
    private MsgSettingItemView cvK;
    private TextView cvL;
    private MsgSettingItemView cvM;
    private View cvN;
    private TbSettingTextTipView cvO;
    private SecretSettingActivity cvP;
    private View cvQ;
    private String[] cvR;
    private BdSwitchView.a cvS;
    private a cvT;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void akA();

        void akB();

        void akC();

        void akD();

        void akE();

        void akz();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aKT = new j(this);
        this.cvS = new k(this);
        this.cvP = secretSettingActivity;
        secretSettingActivity.setContentView(i.g.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cvP.getLayoutMode().ad(i == 1);
        this.cvP.getLayoutMode().k(this.aPS);
        this.mNavigationBar.onChangeSkinType(this.cvP.getPageContext(), i);
        this.cvK.onChangeSkinType(this.cvP.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.aPS = (LinearLayout) secretSettingActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(i.C0057i.secretSetting_title));
        this.cvE = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.black_address_list);
        this.cvF = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_bar);
        this.cvJ = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_group);
        this.cvI = secretSettingActivity.findViewById(i.f.divide_line_under_privacy_attention_group);
        this.cvG = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_forum);
        this.cvH = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.user_mute_list);
        this.mBack.setOnClickListener(this.aKT);
        this.cvE.setOnClickListener(this.aKT);
        this.cvH.setOnClickListener(this.aKT);
        this.cvJ.setOnClickListener(this.aKT);
        this.cvF.setOnClickListener(this.aKT);
        this.cvG.setOnClickListener(this.aKT);
        this.cvQ = this.cvP.findViewById(i.f.privacy_setting_container);
        this.cvR = this.cvP.getResources().getStringArray(i.b.privacy_setting_config);
        this.cvK = (MsgSettingItemView) this.cvP.findViewById(i.f.sv_shared_location);
        this.cvK.setLineVisibility(false);
        this.cvK.setText(i.C0057i.privacy_setting_shared_location);
        this.cvK.setOnSwitchStateChangeListener(this.cvS);
        this.cvM = (MsgSettingItemView) this.cvP.findViewById(i.f.sv_voicelogin_setting);
        this.cvN = this.cvP.findViewById(i.f.divide_line_voicelogin);
        this.cvO = (TbSettingTextTipView) this.cvP.findViewById(i.f.voicelogin_again);
        this.cvL = (TextView) this.cvP.findViewById(i.f.voicelogin_setting_title);
        this.cvO.setOnClickListener(this.aKT);
        this.cvM.setText(i.C0057i.privacy_setting_voicelogin);
        this.cvM.setTipText(i.C0057i.privacy_setting_voicelogin_tip);
        this.cvM.setOnSwitchStateChangeListener(this.cvS);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.cvJ.setVisibility(0);
            this.cvI.setVisibility(0);
            return;
        }
        this.cvJ.setVisibility(8);
        this.cvI.setVisibility(8);
    }

    public void a(a aVar) {
        this.cvT = aVar;
    }

    public void akF() {
        this.cvE.recycle();
    }

    public void eV(boolean z) {
        this.cvN.setVisibility(z ? 0 : 8);
        this.cvO.setVisibility(z ? 0 : 8);
    }

    public void eW(boolean z) {
        if (z) {
            this.cvQ.setVisibility(0);
        } else {
            this.cvQ.setVisibility(8);
        }
    }

    public void Y(String str, int i) {
        int i2 = i - 1;
        if (this.cvR != null && i2 < this.cvR.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.cvF.setTip(this.cvR[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.cvG.setTip(this.cvR[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.cvJ.setTip(this.cvR[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.cvR != null) {
            int length = this.cvR.length;
            int Ac = aVar.Ac() - 1;
            if (Ac < length && Ac >= 0) {
                this.cvJ.setTip(this.cvR[Ac]);
            }
            int akr = aVar.akr() - 1;
            if (akr < length && akr >= 0) {
                this.cvF.setTip(this.cvR[akr]);
            }
            int akp = aVar.akp() - 1;
            if (akp < length && akp >= 0) {
                this.cvG.setTip(this.cvR[akp]);
            }
            eX(aVar.aks());
        }
    }

    public void eX(boolean z) {
        if (z) {
            this.cvK.getSwitchView().mB();
        } else {
            this.cvK.getSwitchView().mC();
        }
    }

    public void eY(boolean z) {
        this.cvM.setVisibility(z ? 0 : 8);
        this.cvL.setVisibility(z ? 0 : 8);
    }

    public void eZ(boolean z) {
        if (z) {
            this.cvM.getSwitchView().mB();
        } else {
            this.cvM.getSwitchView().mC();
        }
    }

    public boolean akG() {
        return this.cvK.getSwitchView().hz();
    }
}
