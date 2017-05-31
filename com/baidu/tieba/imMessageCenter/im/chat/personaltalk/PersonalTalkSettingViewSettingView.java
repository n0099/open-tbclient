package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView dkh;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.dkh != null) {
            this.dkh.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), w.j.p2ptalk_setting_detail_view, this);
        this.dkh = (SettingTextSwitchView) findViewById(w.h.sv_person_msg_notify);
        aq.k(this.dkh.getView(), w.e.common_color_10163);
    }

    public void go(boolean z) {
        if (z) {
            this.dkh.P(false);
        } else {
            this.dkh.Q(false);
        }
    }
}
