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
    private View.OnClickListener aNE;
    private LinearLayout aUy;
    private String[] dlA;
    private BdSwitchView.a dlB;
    private a dlC;
    private TbSettingTextTipView dln;
    private TbSettingTextTipView dlo;
    private TbSettingTextTipView dlp;
    private TbSettingTextTipView dlq;
    private View dlr;
    private TbSettingTextTipView dls;
    private MsgSettingItemView dlt;
    private TextView dlu;
    private MsgSettingItemView dlv;
    private View dlw;
    private TbSettingTextTipView dlx;
    private SecretSettingActivity dly;
    private View dlz;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void axe();

        void axf();

        void axg();

        void axh();

        void axi();

        void axj();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aNE = new j(this);
        this.dlB = new k(this);
        this.dly = secretSettingActivity;
        secretSettingActivity.setContentView(n.g.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.dly.getLayoutMode().af(i == 1);
        this.dly.getLayoutMode().k(this.aUy);
        this.mNavigationBar.onChangeSkinType(this.dly.getPageContext(), i);
        this.dlt.onChangeSkinType(this.dly.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.aUy = (LinearLayout) secretSettingActivity.findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(n.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(n.i.secretSetting_title));
        this.dln = (TbSettingTextTipView) secretSettingActivity.findViewById(n.f.black_address_list);
        this.dlo = (TbSettingTextTipView) secretSettingActivity.findViewById(n.f.privacy_attention_bar);
        this.dls = (TbSettingTextTipView) secretSettingActivity.findViewById(n.f.privacy_attention_group);
        this.dlr = secretSettingActivity.findViewById(n.f.divide_line_under_privacy_attention_group);
        this.dlp = (TbSettingTextTipView) secretSettingActivity.findViewById(n.f.privacy_attention_forum);
        this.dlq = (TbSettingTextTipView) secretSettingActivity.findViewById(n.f.user_mute_list);
        this.mBack.setOnClickListener(this.aNE);
        this.dln.setOnClickListener(this.aNE);
        this.dlq.setOnClickListener(this.aNE);
        this.dls.setOnClickListener(this.aNE);
        this.dlo.setOnClickListener(this.aNE);
        this.dlp.setOnClickListener(this.aNE);
        this.dlz = this.dly.findViewById(n.f.privacy_setting_container);
        this.dlA = this.dly.getResources().getStringArray(n.b.privacy_setting_config);
        this.dlt = (MsgSettingItemView) this.dly.findViewById(n.f.sv_shared_location);
        this.dlt.setLineVisibility(false);
        this.dlt.setText(n.i.privacy_setting_shared_location);
        this.dlt.setOnSwitchStateChangeListener(this.dlB);
        this.dlv = (MsgSettingItemView) this.dly.findViewById(n.f.sv_voicelogin_setting);
        this.dlw = this.dly.findViewById(n.f.divide_line_voicelogin);
        this.dlx = (TbSettingTextTipView) this.dly.findViewById(n.f.voicelogin_again);
        this.dlu = (TextView) this.dly.findViewById(n.f.voicelogin_setting_title);
        this.dlx.setOnClickListener(this.aNE);
        this.dlv.setText(n.i.privacy_setting_voicelogin);
        this.dlv.setTipText(n.i.privacy_setting_voicelogin_tip);
        this.dlv.setOnSwitchStateChangeListener(this.dlB);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.dls.setVisibility(0);
            this.dlr.setVisibility(0);
            return;
        }
        this.dls.setVisibility(8);
        this.dlr.setVisibility(8);
    }

    public void a(a aVar) {
        this.dlC = aVar;
    }

    public void axk() {
        this.dln.recycle();
    }

    public void gK(boolean z) {
        this.dlw.setVisibility(z ? 0 : 8);
        this.dlx.setVisibility(z ? 0 : 8);
    }

    public void gL(boolean z) {
        if (z) {
            this.dlz.setVisibility(0);
        } else {
            this.dlz.setVisibility(8);
        }
    }

    public void ah(String str, int i) {
        int i2 = i - 1;
        if (this.dlA != null && i2 < this.dlA.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.dlo.setTip(this.dlA[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.dlp.setTip(this.dlA[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.dls.setTip(this.dlA[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.dlA != null) {
            int length = this.dlA.length;
            int AX = aVar.AX() - 1;
            if (AX < length && AX >= 0) {
                this.dls.setTip(this.dlA[AX]);
            }
            int awW = aVar.awW() - 1;
            if (awW < length && awW >= 0) {
                this.dlo.setTip(this.dlA[awW]);
            }
            int awU = aVar.awU() - 1;
            if (awU < length && awU >= 0) {
                this.dlp.setTip(this.dlA[awU]);
            }
            gM(aVar.awX());
        }
    }

    public void gM(boolean z) {
        if (z) {
            this.dlt.getSwitchView().mE();
        } else {
            this.dlt.getSwitchView().mF();
        }
    }

    public void gN(boolean z) {
        this.dlv.setVisibility(z ? 0 : 8);
        this.dlu.setVisibility(z ? 0 : 8);
    }

    public void gO(boolean z) {
        if (z) {
            this.dlv.getSwitchView().mE();
        } else {
            this.dlv.getSwitchView().mF();
        }
    }

    public boolean axl() {
        return this.dlt.getSwitchView().hA();
    }
}
