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
    private View.OnClickListener aJY;
    private LinearLayout aPc;
    private TbSettingTextTipView cLb;
    private TbSettingTextTipView cLc;
    private TbSettingTextTipView cLd;
    private TbSettingTextTipView cLe;
    private View cLf;
    private TbSettingTextTipView cLg;
    private MsgSettingItemView cLh;
    private TextView cLi;
    private MsgSettingItemView cLj;
    private View cLk;
    private TbSettingTextTipView cLl;
    private SecretSettingActivity cLm;
    private View cLn;
    private String[] cLo;
    private BdSwitchView.a cLp;
    private a cLq;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void aqY();

        void aqZ();

        void ara();

        void arb();

        void arc();

        void ard();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aJY = new j(this);
        this.cLp = new k(this);
        this.cLm = secretSettingActivity;
        secretSettingActivity.setContentView(i.g.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cLm.getLayoutMode().ad(i == 1);
        this.cLm.getLayoutMode().k(this.aPc);
        this.mNavigationBar.onChangeSkinType(this.cLm.getPageContext(), i);
        this.cLh.onChangeSkinType(this.cLm.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.aPc = (LinearLayout) secretSettingActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(i.h.secretSetting_title));
        this.cLb = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.black_address_list);
        this.cLc = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_bar);
        this.cLg = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_group);
        this.cLf = secretSettingActivity.findViewById(i.f.divide_line_under_privacy_attention_group);
        this.cLd = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_forum);
        this.cLe = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.user_mute_list);
        this.mBack.setOnClickListener(this.aJY);
        this.cLb.setOnClickListener(this.aJY);
        this.cLe.setOnClickListener(this.aJY);
        this.cLg.setOnClickListener(this.aJY);
        this.cLc.setOnClickListener(this.aJY);
        this.cLd.setOnClickListener(this.aJY);
        this.cLn = this.cLm.findViewById(i.f.privacy_setting_container);
        this.cLo = this.cLm.getResources().getStringArray(i.b.privacy_setting_config);
        this.cLh = (MsgSettingItemView) this.cLm.findViewById(i.f.sv_shared_location);
        this.cLh.setLineVisibility(false);
        this.cLh.setText(i.h.privacy_setting_shared_location);
        this.cLh.setOnSwitchStateChangeListener(this.cLp);
        this.cLj = (MsgSettingItemView) this.cLm.findViewById(i.f.sv_voicelogin_setting);
        this.cLk = this.cLm.findViewById(i.f.divide_line_voicelogin);
        this.cLl = (TbSettingTextTipView) this.cLm.findViewById(i.f.voicelogin_again);
        this.cLi = (TextView) this.cLm.findViewById(i.f.voicelogin_setting_title);
        this.cLl.setOnClickListener(this.aJY);
        this.cLj.setText(i.h.privacy_setting_voicelogin);
        this.cLj.setTipText(i.h.privacy_setting_voicelogin_tip);
        this.cLj.setOnSwitchStateChangeListener(this.cLp);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.cLg.setVisibility(0);
            this.cLf.setVisibility(0);
            return;
        }
        this.cLg.setVisibility(8);
        this.cLf.setVisibility(8);
    }

    public void a(a aVar) {
        this.cLq = aVar;
    }

    public void are() {
        this.cLb.recycle();
    }

    public void fR(boolean z) {
        this.cLk.setVisibility(z ? 0 : 8);
        this.cLl.setVisibility(z ? 0 : 8);
    }

    public void fS(boolean z) {
        if (z) {
            this.cLn.setVisibility(0);
        } else {
            this.cLn.setVisibility(8);
        }
    }

    public void ac(String str, int i) {
        int i2 = i - 1;
        if (this.cLo != null && i2 < this.cLo.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.cLc.setTip(this.cLo[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.cLd.setTip(this.cLo[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.cLg.setTip(this.cLo[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.cLo != null) {
            int length = this.cLo.length;
            int Aa = aVar.Aa() - 1;
            if (Aa < length && Aa >= 0) {
                this.cLg.setTip(this.cLo[Aa]);
            }
            int aqQ = aVar.aqQ() - 1;
            if (aqQ < length && aqQ >= 0) {
                this.cLc.setTip(this.cLo[aqQ]);
            }
            int aqO = aVar.aqO() - 1;
            if (aqO < length && aqO >= 0) {
                this.cLd.setTip(this.cLo[aqO]);
            }
            fT(aVar.aqR());
        }
    }

    public void fT(boolean z) {
        if (z) {
            this.cLh.getSwitchView().mz();
        } else {
            this.cLh.getSwitchView().mA();
        }
    }

    public void fU(boolean z) {
        this.cLj.setVisibility(z ? 0 : 8);
        this.cLi.setVisibility(z ? 0 : 8);
    }

    public void fV(boolean z) {
        if (z) {
            this.cLj.getSwitchView().mz();
        } else {
            this.cLj.getSwitchView().mA();
        }
    }

    public boolean arf() {
        return this.cLh.getSwitchView().hx();
    }
}
