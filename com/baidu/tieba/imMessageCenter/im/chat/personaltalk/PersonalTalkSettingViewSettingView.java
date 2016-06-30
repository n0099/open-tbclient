package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView cZC;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        nl();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        nl();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.cZC != null) {
            this.cZC.setSwitchStateChangeListener(aVar);
        }
    }

    private void nl() {
        setOrientation(1);
        inflate(getContext(), u.h.p2ptalk_setting_detail_view, this);
        this.cZC = (SettingTextSwitchView) findViewById(u.g.sv_person_msg_notify);
        av.l(this.cZC.getView(), u.d.common_color_10163);
    }

    public void fQ(boolean z) {
        if (z) {
            this.cZC.K(false);
        } else {
            this.cZC.L(false);
        }
    }
}
