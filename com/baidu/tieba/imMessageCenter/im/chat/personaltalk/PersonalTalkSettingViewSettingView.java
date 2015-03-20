package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView bpW;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        if (this.bpW != null) {
            this.bpW.setSwitchStateChangeListener(bVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), com.baidu.tieba.w.p2ptalk_setting_detail_view, this);
        this.bpW = (SettingTextSwitchView) findViewById(com.baidu.tieba.v.sv_person_msg_notify);
    }

    public void di(boolean z) {
        if (z) {
            this.bpW.L(false);
        } else {
            this.bpW.M(false);
        }
    }
}
