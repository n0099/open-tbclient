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
    private NavigationBar gjT;
    private f<?> njF;
    private TextView njG;
    private TextView njH;
    private BdSwitchView njI;
    private TextView njJ;
    private TextView njK;
    private BdSwitchView njL;
    private boolean njM;
    private boolean njN;
    private BdSwitchView.a njx;
    private View rootView;

    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        this.njx = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.njI) {
                    a.this.njN = switchState == BdSwitchView.SwitchState.ON;
                    a.this.njF.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.njL) {
                    a.this.njM = switchState == BdSwitchView.SwitchState.ON;
                    a.this.njF.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new ar("c14003").dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_type", view != a.this.njI ? 2 : 1));
            }
        };
        this.njF = fVar;
        P(fVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void P(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.gjT = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.gjT.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.gjT.showBottomLine();
        this.gjT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.njG = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.njH = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.njI = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.njJ = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.njK = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.njL = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.njG.setText(R.string.mark_show_inside);
        this.njH.setText(R.string.mark_show_everywhere);
        this.njJ.setText(R.string.mark_show_outside);
        this.njK.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.njL.turnOffNoCallback();
        } else {
            this.njL.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.njI.turnOffNoCallback();
        } else {
            this.njI.turnOnNoCallback();
        }
        this.njM = i2 != 3;
        this.njN = i3 != 3;
        this.njI.setOnSwitchStateChangeListener(this.njx);
        this.njL.setOnSwitchStateChangeListener(this.njx);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.njG, R.color.CAM_X0105);
        ap.setViewTextColor(this.njH, R.color.CAM_X0109);
        ap.setViewTextColor(this.njJ, R.color.CAM_X0105);
        ap.setViewTextColor(this.njK, R.color.CAM_X0109);
        this.gjT.onChangeSkinType(this.njF, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dIY() {
        this.njN = !this.njN;
        if (this.njN) {
            this.njI.turnOnNoCallback();
        } else {
            this.njI.turnOffNoCallback();
        }
    }

    public void dIZ() {
        this.njM = !this.njM;
        if (this.njM) {
            this.njL.turnOnNoCallback();
        } else {
            this.njL.turnOffNoCallback();
        }
    }
}
