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
    private View.OnClickListener aXp;
    private View ajA;
    private LinearLayout bfy;
    private TbSettingTextTipView eaS;
    private TbSettingTextTipView eaT;
    private TbSettingTextTipView eaU;
    private TbSettingTextTipView eaV;
    private View eaW;
    private TbSettingTextTipView eaX;
    private MsgSettingItemView eaY;
    private TextView eaZ;
    private MsgSettingItemView eba;
    private View ebb;
    private TbSettingTextTipView ebc;
    private SecretSettingActivity ebd;
    private View ebe;
    private String[] ebf;
    private BdSwitchView.a ebg;
    private a ebh;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void aNc();

        void aNd();

        void aNe();

        void aNf();

        void aNg();

        void aNh();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aXp = new j(this);
        this.ebg = new k(this);
        this.ebd = secretSettingActivity;
        secretSettingActivity.setContentView(t.h.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ebd.getLayoutMode().ab(i == 1);
        this.ebd.getLayoutMode().x(this.bfy);
        this.mNavigationBar.onChangeSkinType(this.ebd.getPageContext(), i);
        this.eaY.d(this.ebd.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.bfy = (LinearLayout) secretSettingActivity.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(t.g.view_navigation_bar);
        this.ajA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(t.j.secretSetting_title));
        this.eaS = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.black_address_list);
        this.eaT = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.privacy_attention_bar);
        this.eaX = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.privacy_attention_group);
        this.eaW = secretSettingActivity.findViewById(t.g.divide_line_under_privacy_attention_group);
        this.eaU = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.privacy_attention_forum);
        this.eaV = (TbSettingTextTipView) secretSettingActivity.findViewById(t.g.user_mute_list);
        this.ajA.setOnClickListener(this.aXp);
        this.eaS.setOnClickListener(this.aXp);
        this.eaV.setOnClickListener(this.aXp);
        this.eaX.setOnClickListener(this.aXp);
        this.eaT.setOnClickListener(this.aXp);
        this.eaU.setOnClickListener(this.aXp);
        this.ebe = this.ebd.findViewById(t.g.privacy_setting_container);
        this.ebf = this.ebd.getResources().getStringArray(t.b.privacy_setting_config);
        this.eaY = (MsgSettingItemView) this.ebd.findViewById(t.g.sv_shared_location);
        this.eaY.setLineVisibility(false);
        this.eaY.setText(t.j.privacy_setting_shared_location);
        this.eaY.setOnSwitchStateChangeListener(this.ebg);
        this.eba = (MsgSettingItemView) this.ebd.findViewById(t.g.sv_voicelogin_setting);
        this.ebb = this.ebd.findViewById(t.g.divide_line_voicelogin);
        this.ebc = (TbSettingTextTipView) this.ebd.findViewById(t.g.voicelogin_again);
        this.eaZ = (TextView) this.ebd.findViewById(t.g.voicelogin_setting_title);
        this.ebc.setOnClickListener(this.aXp);
        this.eba.setText(t.j.privacy_setting_voicelogin);
        this.eba.setTipText(t.j.privacy_setting_voicelogin_tip);
        this.eba.setOnSwitchStateChangeListener(this.ebg);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.eaX.setVisibility(0);
            this.eaW.setVisibility(0);
            return;
        }
        this.eaX.setVisibility(8);
        this.eaW.setVisibility(8);
    }

    public void a(a aVar) {
        this.ebh = aVar;
    }

    public void aNi() {
        this.eaS.recycle();
    }

    public void ig(boolean z) {
        this.ebb.setVisibility(z ? 0 : 8);
        this.ebc.setVisibility(z ? 0 : 8);
    }

    public void ih(boolean z) {
        if (z) {
            this.ebe.setVisibility(0);
        } else {
            this.ebe.setVisibility(8);
        }
    }

    public void as(String str, int i) {
        int i2 = i - 1;
        if (this.ebf != null && i2 < this.ebf.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.eaT.setTip(this.ebf[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.eaU.setTip(this.ebf[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.eaX.setTip(this.ebf[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.ebf != null) {
            int length = this.ebf.length;
            int CI = aVar.CI() - 1;
            if (CI < length && CI >= 0) {
                this.eaX.setTip(this.ebf[CI]);
            }
            int aMU = aVar.aMU() - 1;
            if (aMU < length && aMU >= 0) {
                this.eaT.setTip(this.ebf[aMU]);
            }
            int aMS = aVar.aMS() - 1;
            if (aMS < length && aMS >= 0) {
                this.eaU.setTip(this.ebf[aMS]);
            }
            ii(aVar.aMV());
        }
    }

    public void ii(boolean z) {
        if (z) {
            this.eaY.getSwitchView().mi();
        } else {
            this.eaY.getSwitchView().mj();
        }
    }

    public void ij(boolean z) {
        this.eba.setVisibility(z ? 0 : 8);
        this.eaZ.setVisibility(z ? 0 : 8);
    }

    public void ik(boolean z) {
        if (z) {
            this.eba.getSwitchView().mi();
        } else {
            this.eba.getSwitchView().mj();
        }
    }

    public boolean aNj() {
        return this.eaY.getSwitchView().hO();
    }
}
