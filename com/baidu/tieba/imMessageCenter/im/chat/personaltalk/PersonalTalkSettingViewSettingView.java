package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView dKx;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.dKx != null) {
            this.dKx.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), d.j.p2ptalk_setting_detail_view, this);
        this.dKx = (SettingTextSwitchView) findViewById(d.h.sv_person_msg_notify);
        aj.k(this.dKx.getView(), d.e.common_color_10163);
    }

    public void hf(boolean z) {
        if (z) {
            this.dKx.Q(false);
        } else {
            this.dKx.R(false);
        }
    }
}
