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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
/* loaded from: classes26.dex */
public class a extends c<PrivacyMarkActivity> {
    private NavigationBar fUP;
    private BdSwitchView.a mJN;
    private e<?> mJV;
    private TextView mJW;
    private TextView mJX;
    private BdSwitchView mJY;
    private TextView mJZ;
    private TextView mKa;
    private BdSwitchView mKb;
    private boolean mKc;
    private boolean mKd;
    private View rootView;

    public a(e<PrivacyMarkActivity> eVar, int i) {
        super(eVar);
        this.mJN = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mJY) {
                    a.this.mKd = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mJV.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mKb) {
                    a.this.mKc = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mJV.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new aq("c14003").dR("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", view != a.this.mJY ? 2 : 1));
            }
        };
        this.mJV = eVar;
        F(eVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void F(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.fUP = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.fUP.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.fUP.showBottomLine();
        this.fUP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mJW = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mJX = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mJY = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mJZ = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mKa = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mKb = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mJW.setText(R.string.mark_show_inside);
        this.mJX.setText(R.string.mark_show_everywhere);
        this.mJZ.setText(R.string.mark_show_outside);
        this.mKa.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mKb.turnOffNoCallback();
        } else {
            this.mKb.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mJY.turnOffNoCallback();
        } else {
            this.mJY.turnOnNoCallback();
        }
        this.mKc = i2 != 3;
        this.mKd = i3 != 3;
        this.mJY.setOnSwitchStateChangeListener(this.mJN);
        this.mKb.setOnSwitchStateChangeListener(this.mJN);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mJW, R.color.cp_cont_b);
        ap.setViewTextColor(this.mJX, R.color.cp_cont_d);
        ap.setViewTextColor(this.mJZ, R.color.cp_cont_b);
        ap.setViewTextColor(this.mKa, R.color.cp_cont_d);
        this.fUP.onChangeSkinType(this.mJV, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dFG() {
        this.mKd = !this.mKd;
        if (this.mKd) {
            this.mJY.turnOnNoCallback();
        } else {
            this.mJY.turnOffNoCallback();
        }
    }

    public void dFH() {
        this.mKc = !this.mKc;
        if (this.mKc) {
            this.mKb.turnOnNoCallback();
        } else {
            this.mKb.turnOffNoCallback();
        }
    }
}
