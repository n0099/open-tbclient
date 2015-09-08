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
    private View.OnClickListener aLg;
    private LinearLayout aQg;
    private TbSettingTextTipView cEa;
    private TbSettingTextTipView cEb;
    private TbSettingTextTipView cEc;
    private TbSettingTextTipView cEd;
    private View cEe;
    private TbSettingTextTipView cEf;
    private MsgSettingItemView cEg;
    private TextView cEh;
    private MsgSettingItemView cEi;
    private View cEj;
    private TbSettingTextTipView cEk;
    private SecretSettingActivity cEl;
    private View cEm;
    private String[] cEn;
    private BdSwitchView.a cEo;
    private a cEp;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void aoG();

        void aoH();

        void aoI();

        void aoJ();

        void aoK();

        void aoL();

        void b(BdSwitchView.SwitchState switchState);

        void onBackPressed();
    }

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aLg = new j(this);
        this.cEo = new k(this);
        this.cEl = secretSettingActivity;
        secretSettingActivity.setContentView(i.g.secret_setting_activity);
        i(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cEl.getLayoutMode().ad(i == 1);
        this.cEl.getLayoutMode().k(this.aQg);
        this.mNavigationBar.onChangeSkinType(this.cEl.getPageContext(), i);
        this.cEg.onChangeSkinType(this.cEl.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.aQg = (LinearLayout) secretSettingActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(i.h.secretSetting_title));
        this.cEa = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.black_address_list);
        this.cEb = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_bar);
        this.cEf = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_group);
        this.cEe = secretSettingActivity.findViewById(i.f.divide_line_under_privacy_attention_group);
        this.cEc = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.privacy_attention_forum);
        this.cEd = (TbSettingTextTipView) secretSettingActivity.findViewById(i.f.user_mute_list);
        this.mBack.setOnClickListener(this.aLg);
        this.cEa.setOnClickListener(this.aLg);
        this.cEd.setOnClickListener(this.aLg);
        this.cEf.setOnClickListener(this.aLg);
        this.cEb.setOnClickListener(this.aLg);
        this.cEc.setOnClickListener(this.aLg);
        this.cEm = this.cEl.findViewById(i.f.privacy_setting_container);
        this.cEn = this.cEl.getResources().getStringArray(i.b.privacy_setting_config);
        this.cEg = (MsgSettingItemView) this.cEl.findViewById(i.f.sv_shared_location);
        this.cEg.setLineVisibility(false);
        this.cEg.setText(i.h.privacy_setting_shared_location);
        this.cEg.setOnSwitchStateChangeListener(this.cEo);
        this.cEi = (MsgSettingItemView) this.cEl.findViewById(i.f.sv_voicelogin_setting);
        this.cEj = this.cEl.findViewById(i.f.divide_line_voicelogin);
        this.cEk = (TbSettingTextTipView) this.cEl.findViewById(i.f.voicelogin_again);
        this.cEh = (TextView) this.cEl.findViewById(i.f.voicelogin_setting_title);
        this.cEk.setOnClickListener(this.aLg);
        this.cEi.setText(i.h.privacy_setting_voicelogin);
        this.cEi.setTipText(i.h.privacy_setting_voicelogin_tip);
        this.cEi.setOnSwitchStateChangeListener(this.cEo);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.cEf.setVisibility(0);
            this.cEe.setVisibility(0);
            return;
        }
        this.cEf.setVisibility(8);
        this.cEe.setVisibility(8);
    }

    public void a(a aVar) {
        this.cEp = aVar;
    }

    public void aoM() {
        this.cEa.recycle();
    }

    public void fG(boolean z) {
        this.cEj.setVisibility(z ? 0 : 8);
        this.cEk.setVisibility(z ? 0 : 8);
    }

    public void fH(boolean z) {
        if (z) {
            this.cEm.setVisibility(0);
        } else {
            this.cEm.setVisibility(8);
        }
    }

    public void aa(String str, int i) {
        int i2 = i - 1;
        if (this.cEn != null && i2 < this.cEn.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.cEb.setTip(this.cEn[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.cEc.setTip(this.cEn[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.cEf.setTip(this.cEn[i2]);
            }
        }
    }

    public void c(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.cEn != null) {
            int length = this.cEn.length;
            int Ap = aVar.Ap() - 1;
            if (Ap < length && Ap >= 0) {
                this.cEf.setTip(this.cEn[Ap]);
            }
            int aoy = aVar.aoy() - 1;
            if (aoy < length && aoy >= 0) {
                this.cEb.setTip(this.cEn[aoy]);
            }
            int aow = aVar.aow() - 1;
            if (aow < length && aow >= 0) {
                this.cEc.setTip(this.cEn[aow]);
            }
            fI(aVar.aoz());
        }
    }

    public void fI(boolean z) {
        if (z) {
            this.cEg.getSwitchView().my();
        } else {
            this.cEg.getSwitchView().mz();
        }
    }

    public void fJ(boolean z) {
        this.cEi.setVisibility(z ? 0 : 8);
        this.cEh.setVisibility(z ? 0 : 8);
    }

    public void fK(boolean z) {
        if (z) {
            this.cEi.getSwitchView().my();
        } else {
            this.cEi.getSwitchView().mz();
        }
    }

    public boolean aoN() {
        return this.cEg.getSwitchView().hw();
    }
}
