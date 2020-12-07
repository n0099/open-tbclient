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
    private NavigationBar gcG;
    private e<?> mYG;
    private TextView mYH;
    private TextView mYI;
    private BdSwitchView mYJ;
    private TextView mYK;
    private TextView mYL;
    private BdSwitchView mYM;
    private boolean mYN;
    private boolean mYO;
    private BdSwitchView.a mYy;
    private View rootView;

    public a(e<PrivacyMarkActivity> eVar, int i) {
        super(eVar);
        this.mYy = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mYJ) {
                    a.this.mYO = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mYG.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mYM) {
                    a.this.mYN = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mYG.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new ar("c14003").dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", view != a.this.mYJ ? 2 : 1));
            }
        };
        this.mYG = eVar;
        O(eVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void O(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.gcG = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.gcG.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.gcG.showBottomLine();
        this.gcG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mYH = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mYI = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mYJ = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mYK = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mYL = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mYM = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mYH.setText(R.string.mark_show_inside);
        this.mYI.setText(R.string.mark_show_everywhere);
        this.mYK.setText(R.string.mark_show_outside);
        this.mYL.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mYM.turnOffNoCallback();
        } else {
            this.mYM.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mYJ.turnOffNoCallback();
        } else {
            this.mYJ.turnOnNoCallback();
        }
        this.mYN = i2 != 3;
        this.mYO = i3 != 3;
        this.mYJ.setOnSwitchStateChangeListener(this.mYy);
        this.mYM.setOnSwitchStateChangeListener(this.mYy);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mYH, R.color.CAM_X0105);
        ap.setViewTextColor(this.mYI, R.color.CAM_X0109);
        ap.setViewTextColor(this.mYK, R.color.CAM_X0105);
        ap.setViewTextColor(this.mYL, R.color.CAM_X0109);
        this.gcG.onChangeSkinType(this.mYG, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dKG() {
        this.mYO = !this.mYO;
        if (this.mYO) {
            this.mYJ.turnOnNoCallback();
        } else {
            this.mYJ.turnOffNoCallback();
        }
    }

    public void dKH() {
        this.mYN = !this.mYN;
        if (this.mYN) {
            this.mYM.turnOnNoCallback();
        } else {
            this.mYM.turnOffNoCallback();
        }
    }
}
