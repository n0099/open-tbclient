package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView jmP;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.jmP != null) {
            this.jmP.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), R.layout.p2ptalk_setting_detail_view, this);
        this.jmP = (SettingTextSwitchView) findViewById(R.id.sv_person_msg_notify);
        ao.setBackgroundColor(this.jmP.getView(), R.color.common_color_10163);
    }

    public void qz(boolean z) {
        if (z) {
            this.jmP.turnOn(false);
        } else {
            this.jmP.turnOff(false);
        }
    }
}
