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
import com.baidu.tieba.n;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<SecretSettingActivity> {
    private View.OnClickListener aRw;
    private LinearLayout aYz;
    private MsgSettingItemView dsA;
    private TextView dsB;
    private MsgSettingItemView dsC;
    private View dsD;
    private TbSettingTextTipView dsE;
    private SecretSettingActivity dsF;
    private View dsG;
    private String[] dsH;
    private BdSwitchView.a dsI;
    private a dsJ;
    private TbSettingTextTipView dsu;
    private TbSettingTextTipView dsv;
    private TbSettingTextTipView dsw;
    private TbSettingTextTipView dsx;
    private View dsy;
    private TbSettingTextTipView dsz;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void azl();

        void azm();

        void azn();

        void azo();

        void azp();

        void azq();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aRw = new j(this);
        this.dsI = new k(this);
        this.dsF = secretSettingActivity;
        secretSettingActivity.setContentView(n.h.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.dsF.getLayoutMode().ac(i == 1);
        this.dsF.getLayoutMode().k(this.aYz);
        this.mNavigationBar.onChangeSkinType(this.dsF.getPageContext(), i);
        this.dsA.onChangeSkinType(this.dsF.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.aYz = (LinearLayout) secretSettingActivity.findViewById(n.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(n.g.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(n.j.secretSetting_title));
        this.dsu = (TbSettingTextTipView) secretSettingActivity.findViewById(n.g.black_address_list);
        this.dsv = (TbSettingTextTipView) secretSettingActivity.findViewById(n.g.privacy_attention_bar);
        this.dsz = (TbSettingTextTipView) secretSettingActivity.findViewById(n.g.privacy_attention_group);
        this.dsy = secretSettingActivity.findViewById(n.g.divide_line_under_privacy_attention_group);
        this.dsw = (TbSettingTextTipView) secretSettingActivity.findViewById(n.g.privacy_attention_forum);
        this.dsx = (TbSettingTextTipView) secretSettingActivity.findViewById(n.g.user_mute_list);
        this.mBack.setOnClickListener(this.aRw);
        this.dsu.setOnClickListener(this.aRw);
        this.dsx.setOnClickListener(this.aRw);
        this.dsz.setOnClickListener(this.aRw);
        this.dsv.setOnClickListener(this.aRw);
        this.dsw.setOnClickListener(this.aRw);
        this.dsG = this.dsF.findViewById(n.g.privacy_setting_container);
        this.dsH = this.dsF.getResources().getStringArray(n.b.privacy_setting_config);
        this.dsA = (MsgSettingItemView) this.dsF.findViewById(n.g.sv_shared_location);
        this.dsA.setLineVisibility(false);
        this.dsA.setText(n.j.privacy_setting_shared_location);
        this.dsA.setOnSwitchStateChangeListener(this.dsI);
        this.dsC = (MsgSettingItemView) this.dsF.findViewById(n.g.sv_voicelogin_setting);
        this.dsD = this.dsF.findViewById(n.g.divide_line_voicelogin);
        this.dsE = (TbSettingTextTipView) this.dsF.findViewById(n.g.voicelogin_again);
        this.dsB = (TextView) this.dsF.findViewById(n.g.voicelogin_setting_title);
        this.dsE.setOnClickListener(this.aRw);
        this.dsC.setText(n.j.privacy_setting_voicelogin);
        this.dsC.setTipText(n.j.privacy_setting_voicelogin_tip);
        this.dsC.setOnSwitchStateChangeListener(this.dsI);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.dsz.setVisibility(0);
            this.dsy.setVisibility(0);
            return;
        }
        this.dsz.setVisibility(8);
        this.dsy.setVisibility(8);
    }

    public void a(a aVar) {
        this.dsJ = aVar;
    }

    public void azr() {
        this.dsu.recycle();
    }

    public void gS(boolean z) {
        this.dsD.setVisibility(z ? 0 : 8);
        this.dsE.setVisibility(z ? 0 : 8);
    }

    public void gT(boolean z) {
        if (z) {
            this.dsG.setVisibility(0);
        } else {
            this.dsG.setVisibility(8);
        }
    }

    public void ai(String str, int i) {
        int i2 = i - 1;
        if (this.dsH != null && i2 < this.dsH.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.dsv.setTip(this.dsH[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.dsw.setTip(this.dsH[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.dsz.setTip(this.dsH[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.dsH != null) {
            int length = this.dsH.length;
            int AN = aVar.AN() - 1;
            if (AN < length && AN >= 0) {
                this.dsz.setTip(this.dsH[AN]);
            }
            int azd = aVar.azd() - 1;
            if (azd < length && azd >= 0) {
                this.dsv.setTip(this.dsH[azd]);
            }
            int azb = aVar.azb() - 1;
            if (azb < length && azb >= 0) {
                this.dsw.setTip(this.dsH[azb]);
            }
            gU(aVar.aze());
        }
    }

    public void gU(boolean z) {
        if (z) {
            this.dsA.getSwitchView().mc();
        } else {
            this.dsA.getSwitchView().md();
        }
    }

    public void gV(boolean z) {
        this.dsC.setVisibility(z ? 0 : 8);
        this.dsB.setVisibility(z ? 0 : 8);
    }

    public void gW(boolean z) {
        if (z) {
            this.dsC.getSwitchView().mc();
        } else {
            this.dsC.getSwitchView().md();
        }
    }

    public boolean azs() {
        return this.dsA.getSwitchView().hA();
    }
}
