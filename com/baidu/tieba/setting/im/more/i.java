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
    private View.OnClickListener aJd;
    private LinearLayout aPv;
    private TbSettingTextTipView cMW;
    private TbSettingTextTipView cMX;
    private TbSettingTextTipView cMY;
    private TbSettingTextTipView cMZ;
    private View cNa;
    private TbSettingTextTipView cNb;
    private MsgSettingItemView cNc;
    private TextView cNd;
    private MsgSettingItemView cNe;
    private View cNf;
    private TbSettingTextTipView cNg;
    private SecretSettingActivity cNh;
    private View cNi;
    private String[] cNj;
    private BdSwitchView.a cNk;
    private a cNl;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void arG();

        void arH();

        void arI();

        void arJ();

        void arK();

        void arL();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aJd = new j(this);
        this.cNk = new k(this);
        this.cNh = secretSettingActivity;
        secretSettingActivity.setContentView(i.g.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cNh.getLayoutMode().ad(i == 1);
        this.cNh.getLayoutMode().k(this.aPv);
        this.mNavigationBar.onChangeSkinType(this.cNh.getPageContext(), i);
        this.cNc.onChangeSkinType(this.cNh.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.aPv = (LinearLayout) secretSettingActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(i.h.secretSetting_title));
        this.cMW = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.black_address_list);
        this.cMX = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_bar);
        this.cNb = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_group);
        this.cNa = secretSettingActivity.findViewById(i.f.divide_line_under_privacy_attention_group);
        this.cMY = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_forum);
        this.cMZ = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.user_mute_list);
        this.mBack.setOnClickListener(this.aJd);
        this.cMW.setOnClickListener(this.aJd);
        this.cMZ.setOnClickListener(this.aJd);
        this.cNb.setOnClickListener(this.aJd);
        this.cMX.setOnClickListener(this.aJd);
        this.cMY.setOnClickListener(this.aJd);
        this.cNi = this.cNh.findViewById(i.f.privacy_setting_container);
        this.cNj = this.cNh.getResources().getStringArray(i.b.privacy_setting_config);
        this.cNc = (MsgSettingItemView) this.cNh.findViewById(i.f.sv_shared_location);
        this.cNc.setLineVisibility(false);
        this.cNc.setText(i.h.privacy_setting_shared_location);
        this.cNc.setOnSwitchStateChangeListener(this.cNk);
        this.cNe = (MsgSettingItemView) this.cNh.findViewById(i.f.sv_voicelogin_setting);
        this.cNf = this.cNh.findViewById(i.f.divide_line_voicelogin);
        this.cNg = (TbSettingTextTipView) this.cNh.findViewById(i.f.voicelogin_again);
        this.cNd = (TextView) this.cNh.findViewById(i.f.voicelogin_setting_title);
        this.cNg.setOnClickListener(this.aJd);
        this.cNe.setText(i.h.privacy_setting_voicelogin);
        this.cNe.setTipText(i.h.privacy_setting_voicelogin_tip);
        this.cNe.setOnSwitchStateChangeListener(this.cNk);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.cNb.setVisibility(0);
            this.cNa.setVisibility(0);
            return;
        }
        this.cNb.setVisibility(8);
        this.cNa.setVisibility(8);
    }

    public void a(a aVar) {
        this.cNl = aVar;
    }

    public void arM() {
        this.cMW.recycle();
    }

    public void fU(boolean z) {
        this.cNf.setVisibility(z ? 0 : 8);
        this.cNg.setVisibility(z ? 0 : 8);
    }

    public void fV(boolean z) {
        if (z) {
            this.cNi.setVisibility(0);
        } else {
            this.cNi.setVisibility(8);
        }
    }

    public void ac(String str, int i) {
        int i2 = i - 1;
        if (this.cNj != null && i2 < this.cNj.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.cMX.setTip(this.cNj[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.cMY.setTip(this.cNj[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.cNb.setTip(this.cNj[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.cNj != null) {
            int length = this.cNj.length;
            int Ac = aVar.Ac() - 1;
            if (Ac < length && Ac >= 0) {
                this.cNb.setTip(this.cNj[Ac]);
            }
            int ary = aVar.ary() - 1;
            if (ary < length && ary >= 0) {
                this.cMX.setTip(this.cNj[ary]);
            }
            int arw = aVar.arw() - 1;
            if (arw < length && arw >= 0) {
                this.cMY.setTip(this.cNj[arw]);
            }
            fW(aVar.arz());
        }
    }

    public void fW(boolean z) {
        if (z) {
            this.cNc.getSwitchView().mA();
        } else {
            this.cNc.getSwitchView().mB();
        }
    }

    public void fX(boolean z) {
        this.cNe.setVisibility(z ? 0 : 8);
        this.cNd.setVisibility(z ? 0 : 8);
    }

    public void fY(boolean z) {
        if (z) {
            this.cNe.getSwitchView().mA();
        } else {
            this.cNe.getSwitchView().mB();
        }
    }

    public boolean arN() {
        return this.cNc.getSwitchView().hy();
    }
}
