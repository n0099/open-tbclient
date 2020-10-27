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
    private NavigationBar fOZ;
    private BdSwitchView.a mDL;
    private e<?> mDT;
    private TextView mDU;
    private TextView mDV;
    private BdSwitchView mDW;
    private TextView mDX;
    private TextView mDY;
    private BdSwitchView mDZ;
    private boolean mEa;
    private boolean mEb;
    private View rootView;

    public a(e<PrivacyMarkActivity> eVar, int i) {
        super(eVar);
        this.mDL = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mDW) {
                    a.this.mEb = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mDT.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mDZ) {
                    a.this.mEa = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mDT.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new aq("c14003").dR("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", view != a.this.mDW ? 2 : 1));
            }
        };
        this.mDT = eVar;
        F(eVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void F(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.fOZ = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.fOZ.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.fOZ.showBottomLine();
        this.fOZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mDU = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mDV = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mDW = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mDX = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mDY = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mDZ = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mDU.setText(R.string.mark_show_inside);
        this.mDV.setText(R.string.mark_show_everywhere);
        this.mDX.setText(R.string.mark_show_outside);
        this.mDY.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mDZ.turnOffNoCallback();
        } else {
            this.mDZ.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mDW.turnOffNoCallback();
        } else {
            this.mDW.turnOnNoCallback();
        }
        this.mEa = i2 != 3;
        this.mEb = i3 != 3;
        this.mDW.setOnSwitchStateChangeListener(this.mDL);
        this.mDZ.setOnSwitchStateChangeListener(this.mDL);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mDU, R.color.cp_cont_b);
        ap.setViewTextColor(this.mDV, R.color.cp_cont_d);
        ap.setViewTextColor(this.mDX, R.color.cp_cont_b);
        ap.setViewTextColor(this.mDY, R.color.cp_cont_d);
        this.fOZ.onChangeSkinType(this.mDT, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dDe() {
        this.mEb = !this.mEb;
        if (this.mEb) {
            this.mDW.turnOnNoCallback();
        } else {
            this.mDW.turnOffNoCallback();
        }
    }

    public void dDf() {
        this.mEa = !this.mEa;
        if (this.mEa) {
            this.mDZ.turnOnNoCallback();
        } else {
            this.mDZ.turnOffNoCallback();
        }
    }
}
