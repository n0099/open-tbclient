package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView dit;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.dit != null) {
            this.dit.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), w.j.p2ptalk_setting_detail_view, this);
        this.dit = (SettingTextSwitchView) findViewById(w.h.sv_person_msg_notify);
        aq.k(this.dit.getView(), w.e.common_color_10163);
    }

    public void gq(boolean z) {
        if (z) {
            this.dit.P(false);
        } else {
            this.dit.Q(false);
        }
    }
}
