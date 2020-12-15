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
/* loaded from: classes26.dex */
public class a extends c<PrivacyMarkActivity> {
    private NavigationBar gcI;
    private BdSwitchView.a mYA;
    private e<?> mYI;
    private TextView mYJ;
    private TextView mYK;
    private BdSwitchView mYL;
    private TextView mYM;
    private TextView mYN;
    private BdSwitchView mYO;
    private boolean mYP;
    private boolean mYQ;
    private View rootView;

    public a(e<PrivacyMarkActivity> eVar, int i) {
        super(eVar);
        this.mYA = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mYL) {
                    a.this.mYQ = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mYI.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mYO) {
                    a.this.mYP = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mYI.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new ar("c14003").dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", view != a.this.mYL ? 2 : 1));
            }
        };
        this.mYI = eVar;
        O(eVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void O(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.gcI = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.gcI.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.gcI.showBottomLine();
        this.gcI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mYJ = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mYK = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mYL = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mYM = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mYN = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mYO = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mYJ.setText(R.string.mark_show_inside);
        this.mYK.setText(R.string.mark_show_everywhere);
        this.mYM.setText(R.string.mark_show_outside);
        this.mYN.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mYO.turnOffNoCallback();
        } else {
            this.mYO.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mYL.turnOffNoCallback();
        } else {
            this.mYL.turnOnNoCallback();
        }
        this.mYP = i2 != 3;
        this.mYQ = i3 != 3;
        this.mYL.setOnSwitchStateChangeListener(this.mYA);
        this.mYO.setOnSwitchStateChangeListener(this.mYA);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mYJ, R.color.CAM_X0105);
        ap.setViewTextColor(this.mYK, R.color.CAM_X0109);
        ap.setViewTextColor(this.mYM, R.color.CAM_X0105);
        ap.setViewTextColor(this.mYN, R.color.CAM_X0109);
        this.gcI.onChangeSkinType(this.mYI, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dKH() {
        this.mYQ = !this.mYQ;
        if (this.mYQ) {
            this.mYL.turnOnNoCallback();
        } else {
            this.mYL.turnOffNoCallback();
        }
    }

    public void dKI() {
        this.mYP = !this.mYP;
        if (this.mYP) {
            this.mYO.turnOnNoCallback();
        } else {
            this.mYO.turnOffNoCallback();
        }
    }
}
