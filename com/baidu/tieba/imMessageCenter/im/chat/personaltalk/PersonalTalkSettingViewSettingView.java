package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView eVb;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.eVb != null) {
            this.eVb.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), e.h.p2ptalk_setting_detail_view, this);
        this.eVb = (SettingTextSwitchView) findViewById(e.g.sv_person_msg_notify);
        al.j(this.eVb.getView(), e.d.common_color_10163);
    }

    public void iZ(boolean z) {
        if (z) {
            this.eVb.ar(false);
        } else {
            this.eVb.as(false);
        }
    }
}
