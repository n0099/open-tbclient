package com.baidu.tieba.setting.privacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
/* loaded from: classes25.dex */
public class a extends c<PrivacyMarkActivity> {
    private NavigationBar fUw;
    private e<?> mKE;
    private TextView mKF;
    private TextView mKG;
    private BdSwitchView mKH;
    private TextView mKI;
    private TextView mKJ;
    private BdSwitchView mKK;
    private boolean mKL;
    private boolean mKM;
    private BdSwitchView.a mKw;
    private View rootView;

    public a(e<PrivacyMarkActivity> eVar, int i) {
        super(eVar);
        this.mKw = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mKH) {
                    a.this.mKM = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mKE.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mKK) {
                    a.this.mKL = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mKE.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new ar("c14003").dR("uid", TbadkCoreApplication.getCurrentAccount()).ak("obj_type", view != a.this.mKH ? 2 : 1));
            }
        };
        this.mKE = eVar;
        F(eVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void F(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.fUw = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.fUw.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.fUw.showBottomLine();
        this.fUw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mKF = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mKG = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mKH = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mKI = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mKJ = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mKK = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mKF.setText(R.string.mark_show_inside);
        this.mKG.setText(R.string.mark_show_everywhere);
        this.mKI.setText(R.string.mark_show_outside);
        this.mKJ.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mKK.turnOffNoCallback();
        } else {
            this.mKK.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mKH.turnOffNoCallback();
        } else {
            this.mKH.turnOnNoCallback();
        }
        this.mKL = i2 != 3;
        this.mKM = i3 != 3;
        this.mKH.setOnSwitchStateChangeListener(this.mKw);
        this.mKK.setOnSwitchStateChangeListener(this.mKw);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mKF, R.color.CAM_X0105);
        ap.setViewTextColor(this.mKG, R.color.CAM_X0109);
        ap.setViewTextColor(this.mKI, R.color.CAM_X0105);
        ap.setViewTextColor(this.mKJ, R.color.CAM_X0109);
        this.fUw.onChangeSkinType(this.mKE, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dFu() {
        this.mKM = !this.mKM;
        if (this.mKM) {
            this.mKH.turnOnNoCallback();
        } else {
            this.mKH.turnOffNoCallback();
        }
    }

    public void dFv() {
        this.mKL = !this.mKL;
        if (this.mKL) {
            this.mKK.turnOnNoCallback();
        } else {
            this.mKK.turnOffNoCallback();
        }
    }
}
