package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView ctp;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        pU();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        pU();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.ctp != null) {
            this.ctp.setSwitchStateChangeListener(aVar);
        }
    }

    private void pU() {
        setOrientation(1);
        inflate(getContext(), t.h.p2ptalk_setting_detail_view, this);
        this.ctp = (SettingTextSwitchView) findViewById(t.g.sv_person_msg_notify);
        at.l(this.ctp.getView(), t.d.square_list_middle_bg_n);
    }

    public void eA(boolean z) {
        if (z) {
            this.ctp.K(false);
        } else {
            this.ctp.L(false);
        }
    }
}
