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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
/* loaded from: classes7.dex */
public class a extends d<PrivacyMarkActivity> {
    private NavigationBar glw;
    private BdSwitchView.a nlB;
    private f<?> nlJ;
    private TextView nlK;
    private TextView nlL;
    private BdSwitchView nlM;
    private TextView nlN;
    private TextView nlO;
    private BdSwitchView nlP;
    private boolean nlQ;
    private boolean nlR;
    private View rootView;

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.nlB = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.nlM) {
                    a.this.nlR = switchState == BdSwitchView.SwitchState.ON;
                    a.this.nlJ.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.nlP) {
                    a.this.nlQ = switchState == BdSwitchView.SwitchState.ON;
                    a.this.nlJ.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new ar("c14003").dR("uid", TbadkCoreApplication.getCurrentAccount()).aq("obj_type", view != a.this.nlM ? 2 : 1));
            }
        };
        this.nlJ = fVar;
        P(fVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void P(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.glw = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.glw.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.glw.showBottomLine();
        this.glw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nlK = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.nlL = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.nlM = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.nlN = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.nlO = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.nlP = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.nlK.setText(R.string.mark_show_inside);
        this.nlL.setText(R.string.mark_show_everywhere);
        this.nlN.setText(R.string.mark_show_outside);
        this.nlO.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.nlP.turnOffNoCallback();
        } else {
            this.nlP.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.nlM.turnOffNoCallback();
        } else {
            this.nlM.turnOnNoCallback();
        }
        this.nlQ = i2 != 3;
        this.nlR = i3 != 3;
        this.nlM.setOnSwitchStateChangeListener(this.nlB);
        this.nlP.setOnSwitchStateChangeListener(this.nlB);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nlK, R.color.CAM_X0105);
        ap.setViewTextColor(this.nlL, R.color.CAM_X0109);
        ap.setViewTextColor(this.nlN, R.color.CAM_X0105);
        ap.setViewTextColor(this.nlO, R.color.CAM_X0109);
        this.glw.onChangeSkinType(this.nlJ, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dJg() {
        this.nlR = !this.nlR;
        if (this.nlR) {
            this.nlM.turnOnNoCallback();
        } else {
            this.nlM.turnOffNoCallback();
        }
    }

    public void dJh() {
        this.nlQ = !this.nlQ;
        if (this.nlQ) {
            this.nlP.turnOnNoCallback();
        } else {
            this.nlP.turnOffNoCallback();
        }
    }
}
