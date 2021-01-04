package com.baidu.tieba.setting.privacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
/* loaded from: classes8.dex */
public class a extends d<PrivacyMarkActivity> {
    private NavigationBar glZ;
    private BdSwitchView.a ndU;
    private f<?> nec;
    private TextView ned;
    private TextView nee;
    private BdSwitchView nef;
    private TextView neg;
    private TextView neh;
    private BdSwitchView nei;
    private boolean nej;
    private boolean nek;
    private View rootView;

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.ndU = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.nef) {
                    a.this.nek = switchState == BdSwitchView.SwitchState.ON;
                    a.this.nec.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.nei) {
                    a.this.nej = switchState == BdSwitchView.SwitchState.ON;
                    a.this.nec.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new aq("c14003").dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", view != a.this.nef ? 2 : 1));
            }
        };
        this.nec = fVar;
        P(fVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void P(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.glZ = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.glZ.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.glZ.showBottomLine();
        this.glZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ned = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.nee = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.nef = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.neg = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.neh = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.nei = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.ned.setText(R.string.mark_show_inside);
        this.nee.setText(R.string.mark_show_everywhere);
        this.neg.setText(R.string.mark_show_outside);
        this.neh.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.nei.turnOffNoCallback();
        } else {
            this.nei.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.nef.turnOffNoCallback();
        } else {
            this.nef.turnOnNoCallback();
        }
        this.nej = i2 != 3;
        this.nek = i3 != 3;
        this.nef.setOnSwitchStateChangeListener(this.ndU);
        this.nei.setOnSwitchStateChangeListener(this.ndU);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.ned, R.color.CAM_X0105);
        ao.setViewTextColor(this.nee, R.color.CAM_X0109);
        ao.setViewTextColor(this.neg, R.color.CAM_X0105);
        ao.setViewTextColor(this.neh, R.color.CAM_X0109);
        this.glZ.onChangeSkinType(this.nec, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dKw() {
        this.nek = !this.nek;
        if (this.nek) {
            this.nef.turnOnNoCallback();
        } else {
            this.nef.turnOffNoCallback();
        }
    }

    public void dKx() {
        this.nej = !this.nej;
        if (this.nej) {
            this.nei.turnOnNoCallback();
        } else {
            this.nei.turnOffNoCallback();
        }
    }
}
