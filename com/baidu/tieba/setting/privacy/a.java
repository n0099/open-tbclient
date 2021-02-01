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
/* loaded from: classes8.dex */
public class a extends d<PrivacyMarkActivity> {
    private NavigationBar gjF;
    private BdSwitchView.a niX;
    private f<?> njf;
    private TextView njg;
    private TextView njh;
    private BdSwitchView nji;
    private TextView njj;
    private TextView njk;
    private BdSwitchView njl;
    private boolean njm;
    private boolean njn;
    private View rootView;

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.niX = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.nji) {
                    a.this.njn = switchState == BdSwitchView.SwitchState.ON;
                    a.this.njf.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.njl) {
                    a.this.njm = switchState == BdSwitchView.SwitchState.ON;
                    a.this.njf.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new ar("c14003").dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_type", view != a.this.nji ? 2 : 1));
            }
        };
        this.njf = fVar;
        P(fVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void P(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.gjF = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.gjF.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.gjF.showBottomLine();
        this.gjF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.njg = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.njh = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.nji = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.njj = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.njk = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.njl = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.njg.setText(R.string.mark_show_inside);
        this.njh.setText(R.string.mark_show_everywhere);
        this.njj.setText(R.string.mark_show_outside);
        this.njk.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.njl.turnOffNoCallback();
        } else {
            this.njl.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.nji.turnOffNoCallback();
        } else {
            this.nji.turnOnNoCallback();
        }
        this.njm = i2 != 3;
        this.njn = i3 != 3;
        this.nji.setOnSwitchStateChangeListener(this.niX);
        this.njl.setOnSwitchStateChangeListener(this.niX);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.njg, R.color.CAM_X0105);
        ap.setViewTextColor(this.njh, R.color.CAM_X0109);
        ap.setViewTextColor(this.njj, R.color.CAM_X0105);
        ap.setViewTextColor(this.njk, R.color.CAM_X0109);
        this.gjF.onChangeSkinType(this.njf, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dIQ() {
        this.njn = !this.njn;
        if (this.njn) {
            this.nji.turnOnNoCallback();
        } else {
            this.nji.turnOffNoCallback();
        }
    }

    public void dIR() {
        this.njm = !this.njm;
        if (this.njm) {
            this.njl.turnOnNoCallback();
        } else {
            this.njl.turnOffNoCallback();
        }
    }
}
