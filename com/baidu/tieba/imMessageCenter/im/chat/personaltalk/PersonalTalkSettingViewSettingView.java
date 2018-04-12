package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView ekJ;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.ekJ != null) {
            this.ekJ.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), d.i.p2ptalk_setting_detail_view, this);
        this.ekJ = (SettingTextSwitchView) findViewById(d.g.sv_person_msg_notify);
        ak.j(this.ekJ.getView(), d.C0126d.common_color_10163);
    }

    public void hG(boolean z) {
        if (z) {
            this.ekJ.T(false);
        } else {
            this.ekJ.U(false);
        }
    }
}
