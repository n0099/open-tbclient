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
/* loaded from: classes25.dex */
public class a extends c<PrivacyMarkActivity> {
    private NavigationBar fuv;
    private BdSwitchView.a mbC;
    private e<?> mbK;
    private TextView mbL;
    private TextView mbM;
    private BdSwitchView mbN;
    private TextView mbO;
    private TextView mbP;
    private BdSwitchView mbQ;
    private boolean mbR;
    private boolean mbS;
    private View rootView;

    public a(e<PrivacyMarkActivity> eVar, int i) {
        super(eVar);
        this.mbC = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mbN) {
                    a.this.mbS = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mbK.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mbQ) {
                    a.this.mbR = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mbK.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new aq("c14003").dF("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", view != a.this.mbN ? 2 : 1));
            }
        };
        this.mbK = eVar;
        F(eVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void F(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.fuv = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.fuv.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.fuv.showBottomLine();
        this.fuv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mbL = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mbM = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mbN = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mbO = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mbP = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mbQ = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mbL.setText(R.string.mark_show_inside);
        this.mbM.setText(R.string.mark_show_everywhere);
        this.mbO.setText(R.string.mark_show_outside);
        this.mbP.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mbQ.turnOffNoCallback();
        } else {
            this.mbQ.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mbN.turnOffNoCallback();
        } else {
            this.mbN.turnOnNoCallback();
        }
        this.mbR = i2 != 3;
        this.mbS = i3 != 3;
        this.mbN.setOnSwitchStateChangeListener(this.mbC);
        this.mbQ.setOnSwitchStateChangeListener(this.mbC);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mbL, R.color.cp_cont_b);
        ap.setViewTextColor(this.mbM, R.color.cp_cont_d);
        ap.setViewTextColor(this.mbO, R.color.cp_cont_b);
        ap.setViewTextColor(this.mbP, R.color.cp_cont_d);
        this.fuv.onChangeSkinType(this.mbK, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dwl() {
        this.mbS = !this.mbS;
        if (this.mbS) {
            this.mbN.turnOnNoCallback();
        } else {
            this.mbN.turnOffNoCallback();
        }
    }

    public void dwm() {
        this.mbR = !this.mbR;
        if (this.mbR) {
            this.mbQ.turnOnNoCallback();
        } else {
            this.mbQ.turnOffNoCallback();
        }
    }
}
