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
    private NavigationBar fGE;
    private BdSwitchView.a mrg;
    private e<?> mro;
    private TextView mrp;
    private TextView mrq;
    private BdSwitchView mrr;
    private TextView mrs;
    private TextView mrt;
    private BdSwitchView mru;
    private boolean mrv;
    private boolean mrw;
    private View rootView;

    public a(e<PrivacyMarkActivity> eVar, int i) {
        super(eVar);
        this.mrg = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.privacy.a.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == a.this.mrr) {
                    a.this.mrw = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mro.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == a.this.mru) {
                    a.this.mrv = switchState == BdSwitchView.SwitchState.ON;
                    a.this.mro.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new aq("c14003").dK("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", view != a.this.mrr ? 2 : 1));
            }
        };
        this.mro = eVar;
        F(eVar.getPageActivity(), i);
        onChangeSkinType();
    }

    private void F(Context context, int i) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
        this.fGE = (NavigationBar) this.rootView.findViewById(R.id.navigation_bar);
        this.fGE.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
        this.fGE.showBottomLine();
        this.fGE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mrp = (TextView) this.rootView.findViewById(R.id.inside_text);
        this.mrq = (TextView) this.rootView.findViewById(R.id.inside_desc);
        this.mrr = (BdSwitchView) this.rootView.findViewById(R.id.inside_switch);
        this.mrs = (TextView) this.rootView.findViewById(R.id.outside_text);
        this.mrt = (TextView) this.rootView.findViewById(R.id.outside_desc);
        this.mru = (BdSwitchView) this.rootView.findViewById(R.id.outside_switch);
        this.mrp.setText(R.string.mark_show_inside);
        this.mrq.setText(R.string.mark_show_everywhere);
        this.mrs.setText(R.string.mark_show_outside);
        this.mrt.setText(R.string.mark_show_somewhere);
        int i2 = i & 3;
        int i3 = (i >> 2) & 3;
        if (i2 == 3) {
            this.mru.turnOffNoCallback();
        } else {
            this.mru.turnOnNoCallback();
        }
        if (i3 == 3) {
            this.mrr.turnOffNoCallback();
        } else {
            this.mrr.turnOnNoCallback();
        }
        this.mrv = i2 != 3;
        this.mrw = i3 != 3;
        this.mrr.setOnSwitchStateChangeListener(this.mrg);
        this.mru.setOnSwitchStateChangeListener(this.mrg);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mrp, R.color.cp_cont_b);
        ap.setViewTextColor(this.mrq, R.color.cp_cont_d);
        ap.setViewTextColor(this.mrs, R.color.cp_cont_b);
        ap.setViewTextColor(this.mrt, R.color.cp_cont_d);
        this.fGE.onChangeSkinType(this.mro, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.rootView;
    }

    public void dzW() {
        this.mrw = !this.mrw;
        if (this.mrw) {
            this.mrr.turnOnNoCallback();
        } else {
            this.mrr.turnOffNoCallback();
        }
    }

    public void dzX() {
        this.mrv = !this.mrv;
        if (this.mrv) {
            this.mru.turnOnNoCallback();
        } else {
            this.mru.turnOffNoCallback();
        }
    }
}
