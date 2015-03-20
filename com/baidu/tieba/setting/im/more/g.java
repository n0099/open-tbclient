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
    private View.OnClickListener aBr;
    private LinearLayout axj;
    private View bZA;
    private String[] bZB;
    private com.baidu.adp.widget.BdSwitchView.b bZC;
    private j bZm;
    private TbSettingTextTipView bZt;
    private TbSettingTextTipView bZu;
    private TbSettingTextTipView bZv;
    private View bZw;
    private TbSettingTextTipView bZx;
    private MsgSettingItemView bZy;
    private SecretSettingActivity bZz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aBr = new h(this);
        this.bZC = new i(this);
        this.bZz = secretSettingActivity;
        secretSettingActivity.setContentView(w.secret_setting_activity);
        d(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bZz.getLayoutMode().X(i == 1);
        this.bZz.getLayoutMode().h(this.axj);
        this.mNavigationBar.onChangeSkinType(this.bZz.getPageContext(), i);
        this.bZy.onChangeSkinType(this.bZz.getPageContext(), i);
    }

    private void d(SecretSettingActivity secretSettingActivity) {
        this.axj = (LinearLayout) secretSettingActivity.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(y.secretSetting_title));
        this.bZt = (TbSettingTextTipView) secretSettingActivity.findViewById(v.black_address_list);
        this.bZu = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_bar);
        this.bZx = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_group);
        this.bZw = secretSettingActivity.findViewById(v.divide_line_under_privacy_attention_group);
        this.bZv = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_forum);
        this.mBack.setOnClickListener(this.aBr);
        this.bZt.setOnClickListener(this.aBr);
        this.bZx.setOnClickListener(this.aBr);
        this.bZu.setOnClickListener(this.aBr);
        this.bZv.setOnClickListener(this.aBr);
        this.bZA = this.bZz.findViewById(v.privacy_setting_container);
        this.bZB = this.bZz.getResources().getStringArray(q.privacy_setting_config);
        this.bZy = (MsgSettingItemView) this.bZz.findViewById(v.sv_shared_location);
        this.bZy.setText(y.privacy_setting_shared_location);
        this.bZy.setOnSwitchStateChangeListener(this.bZC);
        this.bZy.setLineVisibility(false);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.bZx.setVisibility(0);
            this.bZw.setVisibility(0);
            return;
        }
        this.bZx.setVisibility(8);
        this.bZw.setVisibility(8);
    }

    public void a(j jVar) {
        this.bZm = jVar;
    }

    public void agf() {
        this.bZt.recycle();
    }

    public void ep(boolean z) {
        if (z) {
            this.bZA.setVisibility(0);
        } else {
            this.bZA.setVisibility(8);
        }
    }

    public void T(String str, int i) {
        int i2 = i - 1;
        if (this.bZB != null && i2 < this.bZB.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.bZu.setTip(this.bZB[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.bZv.setTip(this.bZB[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.bZx.setTip(this.bZB[i2]);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.bZB != null) {
            int length = this.bZB.length;
            int xY = aVar.xY() - 1;
            if (xY < length && xY >= 0) {
                this.bZx.setTip(this.bZB[xY]);
            }
            int afY = aVar.afY() - 1;
            if (afY < length && afY >= 0) {
                this.bZu.setTip(this.bZB[afY]);
            }
            int afW = aVar.afW() - 1;
            if (afW < length && afW >= 0) {
                this.bZv.setTip(this.bZB[afW]);
            }
            eq(aVar.afZ());
        }
    }

    public void eq(boolean z) {
        if (z) {
            this.bZy.getSwitchView().lY();
        } else {
            this.bZy.getSwitchView().lZ();
        }
    }

    public boolean agg() {
        return this.bZy.getSwitchView().hZ();
    }
}
