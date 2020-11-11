package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView krQ;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.krQ != null) {
            this.krQ.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), R.layout.p2ptalk_setting_detail_view, this);
        this.krQ = (SettingTextSwitchView) findViewById(R.id.sv_person_msg_notify);
        ap.setBackgroundColor(this.krQ.getView(), R.color.common_color_10163);
    }

    public void sw(boolean z) {
        if (z) {
            this.krQ.turnOn(false);
        } else {
            this.krQ.turnOff(false);
        }
    }
}
