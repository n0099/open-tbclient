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
    private View.OnClickListener aDw;
    private LinearLayout aIr;
    private l cdT;
    private TbSettingTextTipView cec;
    private TbSettingTextTipView ced;
    private TbSettingTextTipView cee;
    private View cef;
    private TbSettingTextTipView ceg;
    private MsgSettingItemView ceh;
    private TextView cei;
    private MsgSettingItemView cej;
    private View cek;
    private TbSettingTextTipView cel;
    private SecretSettingActivity cem;
    private View cen;
    private String[] ceo;
    private com.baidu.adp.widget.BdSwitchView.b cep;
    private View mBack;
    private NavigationBar mNavigationBar;

    public i(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aDw = new j(this);
        this.cep = new k(this);
        this.cem = secretSettingActivity;
        secretSettingActivity.setContentView(r.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cem.getLayoutMode().ab(i == 1);
        this.cem.getLayoutMode().j(this.aIr);
        this.mNavigationBar.onChangeSkinType(this.cem.getPageContext(), i);
        this.ceh.onChangeSkinType(this.cem.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.aIr = (LinearLayout) secretSettingActivity.findViewById(q.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(t.secretSetting_title));
        this.cec = (TbSettingTextTipView) secretSettingActivity.findViewById(q.black_address_list);
        this.ced = (TbSettingTextTipView) secretSettingActivity.findViewById(q.privacy_attention_bar);
        this.ceg = (TbSettingTextTipView) secretSettingActivity.findViewById(q.privacy_attention_group);
        this.cef = secretSettingActivity.findViewById(q.divide_line_under_privacy_attention_group);
        this.cee = (TbSettingTextTipView) secretSettingActivity.findViewById(q.privacy_attention_forum);
        this.mBack.setOnClickListener(this.aDw);
        this.cec.setOnClickListener(this.aDw);
        this.ceg.setOnClickListener(this.aDw);
        this.ced.setOnClickListener(this.aDw);
        this.cee.setOnClickListener(this.aDw);
        this.cen = this.cem.findViewById(q.privacy_setting_container);
        this.ceo = this.cem.getResources().getStringArray(com.baidu.tieba.l.privacy_setting_config);
        this.ceh = (MsgSettingItemView) this.cem.findViewById(q.sv_shared_location);
        this.ceh.setText(t.privacy_setting_shared_location);
        this.ceh.setOnSwitchStateChangeListener(this.cep);
        this.cej = (MsgSettingItemView) this.cem.findViewById(q.sv_voicelogin_setting);
        this.cek = this.cem.findViewById(q.divide_line_voicelogin);
        this.cel = (TbSettingTextTipView) this.cem.findViewById(q.voicelogin_again);
        this.cei = (TextView) this.cem.findViewById(q.voicelogin_setting_title);
        this.cel.setOnClickListener(this.aDw);
        this.cej.setText(t.privacy_setting_voicelogin);
        this.cej.setTipText(t.privacy_setting_voicelogin_tip);
        this.cej.setOnSwitchStateChangeListener(this.cep);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.ceg.setVisibility(0);
            this.cef.setVisibility(0);
            return;
        }
        this.ceg.setVisibility(8);
        this.cef.setVisibility(8);
    }

    public void a(l lVar) {
        this.cdT = lVar;
    }

    public void aio() {
        this.cec.recycle();
    }

    public void eD(boolean z) {
        this.cek.setVisibility(z ? 0 : 8);
        this.cel.setVisibility(z ? 0 : 8);
    }

    public void eE(boolean z) {
        if (z) {
            this.cen.setVisibility(0);
        } else {
            this.cen.setVisibility(8);
        }
    }

    public void U(String str, int i) {
        int i2 = i - 1;
        if (this.ceo != null && i2 < this.ceo.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.ced.setTip(this.ceo[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.cee.setTip(this.ceo[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.ceg.setTip(this.ceo[i2]);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.ceo != null) {
            int length = this.ceo.length;
            int yS = aVar.yS() - 1;
            if (yS < length && yS >= 0) {
                this.ceg.setTip(this.ceo[yS]);
            }
            int aid = aVar.aid() - 1;
            if (aid < length && aid >= 0) {
                this.ced.setTip(this.ceo[aid]);
            }
            int aib = aVar.aib() - 1;
            if (aib < length && aib >= 0) {
                this.cee.setTip(this.ceo[aib]);
            }
            eF(aVar.aie());
        }
    }

    public void eF(boolean z) {
        if (z) {
            this.ceh.getSwitchView().mr();
        } else {
            this.ceh.getSwitchView().ms();
        }
    }

    public void eG(boolean z) {
        this.cej.setVisibility(z ? 0 : 8);
        this.cei.setVisibility(z ? 0 : 8);
    }

    public void eH(boolean z) {
        if (z) {
            this.cej.getSwitchView().mr();
        } else {
            this.cej.getSwitchView().ms();
        }
    }

    public boolean aip() {
        return this.ceh.getSwitchView().hJ();
    }
}
