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
    private BdSwitchView.a ndT;
    private f<?> neb;
    private TextView nec;
    private TextView ned;
    private BdSwitchView nee;
    private TextView nef;
    private TextView neg;
    private BdSwitchView neh;
    private boolean nei;
    private boolean nej;
    private View rootView;

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.ndT = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.nee) {
                    a.this.nej = switchState == BdSwitchView.SwitchState.ON;
                    a.this.neb.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.neh) {
                    a.this.nei = switchState == BdSwitchView.SwitchState.ON;
                    a.this.neb.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new aq("c14003").dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", view != a.this.nee ? 2 : 1));
            }
        };
        this.neb = fVar;
        P(fVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void P(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.glZ = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.glZ.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.glZ.showBottomLine();
        this.glZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nec = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.ned = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.nee = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.nef = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.neg = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.neh = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.nec.setText(R.string.mark_show_inside);
        this.ned.setText(R.string.mark_show_everywhere);
        this.nef.setText(R.string.mark_show_outside);
        this.neg.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.neh.turnOffNoCallback();
        } else {
            this.neh.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.nee.turnOffNoCallback();
        } else {
            this.nee.turnOnNoCallback();
        }
        this.nei = i2 != 3;
        this.nej = i3 != 3;
        this.nee.setOnSwitchStateChangeListener(this.ndT);
        this.neh.setOnSwitchStateChangeListener(this.ndT);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.nec, R.color.CAM_X0105);
        ao.setViewTextColor(this.ned, R.color.CAM_X0109);
        ao.setViewTextColor(this.nef, R.color.CAM_X0105);
        ao.setViewTextColor(this.neg, R.color.CAM_X0109);
        this.glZ.onChangeSkinType(this.neb, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dKx() {
        this.nej = !this.nej;
        if (this.nej) {
            this.nee.turnOnNoCallback();
        } else {
            this.nee.turnOffNoCallback();
        }
    }

    public void dKy() {
        this.nei = !this.nei;
        if (this.nei) {
            this.neh.turnOnNoCallback();
        } else {
            this.neh.turnOffNoCallback();
        }
    }
}
