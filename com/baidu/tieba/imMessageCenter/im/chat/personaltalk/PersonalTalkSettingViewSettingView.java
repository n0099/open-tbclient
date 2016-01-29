package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView ciK;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qD();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        qD();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.ciK != null) {
            this.ciK.setSwitchStateChangeListener(aVar);
        }
    }

    private void qD() {
        setOrientation(1);
        inflate(getContext(), t.h.p2ptalk_setting_detail_view, this);
        this.ciK = (SettingTextSwitchView) findViewById(t.g.sv_person_msg_notify);
        ar.l(this.ciK.getView(), t.d.square_list_middle_bg_n);
    }

    public void ee(boolean z) {
        if (z) {
            this.ciK.L(false);
        } else {
            this.ciK.M(false);
        }
    }
}
