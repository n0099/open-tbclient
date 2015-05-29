package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g<SecretSettingActivity> {
    private View.OnClickListener aDv;
    private LinearLayout aIq;
    private l cdS;
    private TbSettingTextTipView ceb;
    private TbSettingTextTipView cec;
    private TbSettingTextTipView ced;
    private View cee;
    private TbSettingTextTipView cef;
    private MsgSettingItemView ceg;
    private TextView ceh;
    private MsgSettingItemView cei;
    private View cej;
    private TbSettingTextTipView cek;
    private SecretSettingActivity cel;
    private View cem;
    private String[] cen;
    private com.baidu.adp.widget.BdSwitchView.b ceo;
    private View mBack;
    private NavigationBar mNavigationBar;

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aDv = new j(this);
        this.ceo = new k(this);
        this.cel = secretSettingActivity;
        secretSettingActivity.setContentView(r.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cel.getLayoutMode().ab(i == 1);
        this.cel.getLayoutMode().j(this.aIq);
        this.mNavigationBar.onChangeSkinType(this.cel.getPageContext(), i);
        this.ceg.onChangeSkinType(this.cel.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.aIq = (LinearLayout) secretSettingActivity.findViewById(q.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(t.secretSetting_title));
        this.ceb = (TbSettingTextTipView) secretSettingActivity.findViewById(q.black_address_list);
        this.cec = (TbSettingTextTipView) secretSettingActivity.findViewById(q.privacy_attention_bar);
        this.cef = (TbSettingTextTipView) secretSettingActivity.findViewById(q.privacy_attention_group);
        this.cee = secretSettingActivity.findViewById(q.divide_line_under_privacy_attention_group);
        this.ced = (TbSettingTextTipView) secretSettingActivity.findViewById(q.privacy_attention_forum);
        this.mBack.setOnClickListener(this.aDv);
        this.ceb.setOnClickListener(this.aDv);
        this.cef.setOnClickListener(this.aDv);
        this.cec.setOnClickListener(this.aDv);
        this.ced.setOnClickListener(this.aDv);
        this.cem = this.cel.findViewById(q.privacy_setting_container);
        this.cen = this.cel.getResources().getStringArray(com.baidu.tieba.l.privacy_setting_config);
        this.ceg = (MsgSettingItemView) this.cel.findViewById(q.sv_shared_location);
        this.ceg.setText(t.privacy_setting_shared_location);
        this.ceg.setOnSwitchStateChangeListener(this.ceo);
        this.cei = (MsgSettingItemView) this.cel.findViewById(q.sv_voicelogin_setting);
        this.cej = this.cel.findViewById(q.divide_line_voicelogin);
        this.cek = (TbSettingTextTipView) this.cel.findViewById(q.voicelogin_again);
        this.ceh = (TextView) this.cel.findViewById(q.voicelogin_setting_title);
        this.cek.setOnClickListener(this.aDv);
        this.cei.setText(t.privacy_setting_voicelogin);
        this.cei.setTipText(t.privacy_setting_voicelogin_tip);
        this.cei.setOnSwitchStateChangeListener(this.ceo);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.cef.setVisibility(0);
            this.cee.setVisibility(0);
            return;
        }
        this.cef.setVisibility(8);
        this.cee.setVisibility(8);
    }

    public void a(l lVar) {
        this.cdS = lVar;
    }

    public void ain() {
        this.ceb.recycle();
    }

    public void eD(boolean z) {
        this.cej.setVisibility(z ? 0 : 8);
        this.cek.setVisibility(z ? 0 : 8);
    }

    public void eE(boolean z) {
        if (z) {
            this.cem.setVisibility(0);
        } else {
            this.cem.setVisibility(8);
        }
    }

    public void U(String str, int i) {
        int i2 = i - 1;
        if (this.cen != null && i2 < this.cen.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.cec.setTip(this.cen[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.ced.setTip(this.cen[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.cef.setTip(this.cen[i2]);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.cen != null) {
            int length = this.cen.length;
            int yR = aVar.yR() - 1;
            if (yR < length && yR >= 0) {
                this.cef.setTip(this.cen[yR]);
            }
            int aic = aVar.aic() - 1;
            if (aic < length && aic >= 0) {
                this.cec.setTip(this.cen[aic]);
            }
            int aia = aVar.aia() - 1;
            if (aia < length && aia >= 0) {
                this.ced.setTip(this.cen[aia]);
            }
            eF(aVar.aid());
        }
    }

    public void eF(boolean z) {
        if (z) {
            this.ceg.getSwitchView().mr();
        } else {
            this.ceg.getSwitchView().ms();
        }
    }

    public void eG(boolean z) {
        this.cei.setVisibility(z ? 0 : 8);
        this.ceh.setVisibility(z ? 0 : 8);
    }

    public void eH(boolean z) {
        if (z) {
            this.cei.getSwitchView().mr();
        } else {
            this.cei.getSwitchView().ms();
        }
    }

    public boolean aio() {
        return this.ceg.getSwitchView().hJ();
    }
}
