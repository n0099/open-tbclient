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
/* loaded from: classes7.dex */
public class a extends d<PrivacyMarkActivity> {
    private NavigationBar ghr;
    private TextView mZA;
    private TextView mZB;
    private BdSwitchView mZC;
    private boolean mZD;
    private boolean mZE;
    private BdSwitchView.a mZo;
    private f<?> mZw;
    private TextView mZx;
    private TextView mZy;
    private BdSwitchView mZz;
    private View rootView;

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.mZo = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mZz) {
                    a.this.mZE = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mZw.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mZC) {
                    a.this.mZD = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mZw.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new aq("c14003").dW("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", view != a.this.mZz ? 2 : 1));
            }
        };
        this.mZw = fVar;
        P(fVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void P(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.ghr = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.ghr.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.ghr.showBottomLine();
        this.ghr.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mZx = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mZy = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mZz = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mZA = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mZB = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mZC = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mZx.setText(R.string.mark_show_inside);
        this.mZy.setText(R.string.mark_show_everywhere);
        this.mZA.setText(R.string.mark_show_outside);
        this.mZB.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mZC.turnOffNoCallback();
        } else {
            this.mZC.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mZz.turnOffNoCallback();
        } else {
            this.mZz.turnOnNoCallback();
        }
        this.mZD = i2 != 3;
        this.mZE = i3 != 3;
        this.mZz.setOnSwitchStateChangeListener(this.mZo);
        this.mZC.setOnSwitchStateChangeListener(this.mZo);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mZx, R.color.CAM_X0105);
        ao.setViewTextColor(this.mZy, R.color.CAM_X0109);
        ao.setViewTextColor(this.mZA, R.color.CAM_X0105);
        ao.setViewTextColor(this.mZB, R.color.CAM_X0109);
        this.ghr.onChangeSkinType(this.mZw, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dGF() {
        this.mZE = !this.mZE;
        if (this.mZE) {
            this.mZz.turnOnNoCallback();
        } else {
            this.mZz.turnOffNoCallback();
        }
    }

    public void dGG() {
        this.mZD = !this.mZD;
        if (this.mZD) {
            this.mZC.turnOnNoCallback();
        } else {
            this.mZC.turnOffNoCallback();
        }
    }
}
