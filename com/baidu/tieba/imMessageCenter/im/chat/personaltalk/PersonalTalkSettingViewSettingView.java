package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView kGB;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.kGB != null) {
            this.kGB.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), R.layout.p2ptalk_setting_detail_view, this);
        this.kGB = (SettingTextSwitchView) findViewById(R.id.sv_person_msg_notify);
        ao.setBackgroundColor(this.kGB.getView(), R.color.common_color_10163);
    }

    public void sY(boolean z) {
        if (z) {
            this.kGB.turnOn(false);
        } else {
            this.kGB.turnOff(false);
        }
    }
}
