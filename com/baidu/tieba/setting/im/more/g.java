package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.q;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.g<SecretSettingActivity> {
    private View.OnClickListener aBz;
    private LinearLayout axr;
    private j bZB;
    private TbSettingTextTipView bZI;
    private TbSettingTextTipView bZJ;
    private TbSettingTextTipView bZK;
    private View bZL;
    private TbSettingTextTipView bZM;
    private MsgSettingItemView bZN;
    private SecretSettingActivity bZO;
    private View bZP;
    private String[] bZQ;
    private com.baidu.adp.widget.BdSwitchView.b bZR;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aBz = new h(this);
        this.bZR = new i(this);
        this.bZO = secretSettingActivity;
        secretSettingActivity.setContentView(w.secret_setting_activity);
        d(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bZO.getLayoutMode().X(i == 1);
        this.bZO.getLayoutMode().h(this.axr);
        this.mNavigationBar.onChangeSkinType(this.bZO.getPageContext(), i);
        this.bZN.onChangeSkinType(this.bZO.getPageContext(), i);
    }

    private void d(SecretSettingActivity secretSettingActivity) {
        this.axr = (LinearLayout) secretSettingActivity.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(y.secretSetting_title));
        this.bZI = (TbSettingTextTipView) secretSettingActivity.findViewById(v.black_address_list);
        this.bZJ = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_bar);
        this.bZM = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_group);
        this.bZL = secretSettingActivity.findViewById(v.divide_line_under_privacy_attention_group);
        this.bZK = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_forum);
        this.mBack.setOnClickListener(this.aBz);
        this.bZI.setOnClickListener(this.aBz);
        this.bZM.setOnClickListener(this.aBz);
        this.bZJ.setOnClickListener(this.aBz);
        this.bZK.setOnClickListener(this.aBz);
        this.bZP = this.bZO.findViewById(v.privacy_setting_container);
        this.bZQ = this.bZO.getResources().getStringArray(q.privacy_setting_config);
        this.bZN = (MsgSettingItemView) this.bZO.findViewById(v.sv_shared_location);
        this.bZN.setText(y.privacy_setting_shared_location);
        this.bZN.setOnSwitchStateChangeListener(this.bZR);
        this.bZN.setLineVisibility(false);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.bZM.setVisibility(0);
            this.bZL.setVisibility(0);
            return;
        }
        this.bZM.setVisibility(8);
        this.bZL.setVisibility(8);
    }

    public void a(j jVar) {
        this.bZB = jVar;
    }

    public void agu() {
        this.bZI.recycle();
    }

    public void en(boolean z) {
        if (z) {
            this.bZP.setVisibility(0);
        } else {
            this.bZP.setVisibility(8);
        }
    }

    public void T(String str, int i) {
        int i2 = i - 1;
        if (this.bZQ != null && i2 < this.bZQ.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.bZJ.setTip(this.bZQ[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.bZK.setTip(this.bZQ[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.bZM.setTip(this.bZQ[i2]);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.bZQ != null) {
            int length = this.bZQ.length;
            int ye = aVar.ye() - 1;
            if (ye < length && ye >= 0) {
                this.bZM.setTip(this.bZQ[ye]);
            }
            int agn = aVar.agn() - 1;
            if (agn < length && agn >= 0) {
                this.bZJ.setTip(this.bZQ[agn]);
            }
            int agl = aVar.agl() - 1;
            if (agl < length && agl >= 0) {
                this.bZK.setTip(this.bZQ[agl]);
            }
            eo(aVar.ago());
        }
    }

    public void eo(boolean z) {
        if (z) {
            this.bZN.getSwitchView().lY();
        } else {
            this.bZN.getSwitchView().lZ();
        }
    }

    public boolean agv() {
        return this.bZN.getSwitchView().hZ();
    }
}
