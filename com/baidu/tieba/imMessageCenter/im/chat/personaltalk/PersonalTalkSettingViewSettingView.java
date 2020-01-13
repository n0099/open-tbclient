package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView hKp;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.hKp != null) {
            this.hKp.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), R.layout.p2ptalk_setting_detail_view, this);
        this.hKp = (SettingTextSwitchView) findViewById(R.id.sv_person_msg_notify);
        am.setBackgroundColor(this.hKp.getView(), R.color.common_color_10163);
    }

    public void nZ(boolean z) {
        if (z) {
            this.hKp.turnOn(false);
        } else {
            this.hKp.turnOff(false);
        }
    }
}
