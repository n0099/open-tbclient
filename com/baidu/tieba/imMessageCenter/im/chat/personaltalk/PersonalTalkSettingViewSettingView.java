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
    private SettingTextSwitchView cun;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        nq();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        nq();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.cun != null) {
            this.cun.setSwitchStateChangeListener(aVar);
        }
    }

    private void nq() {
        setOrientation(1);
        inflate(getContext(), t.h.p2ptalk_setting_detail_view, this);
        this.cun = (SettingTextSwitchView) findViewById(t.g.sv_person_msg_notify);
        at.l(this.cun.getView(), t.d.square_list_middle_bg_n);
    }

    public void fc(boolean z) {
        if (z) {
            this.cun.K(false);
        } else {
            this.cun.L(false);
        }
    }
}
