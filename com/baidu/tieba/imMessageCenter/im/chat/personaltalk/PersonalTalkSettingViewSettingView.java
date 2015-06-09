package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView bsW;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        if (this.bsW != null) {
            this.bsW.setSwitchStateChangeListener(bVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), com.baidu.tieba.r.p2ptalk_setting_detail_view, this);
        this.bsW = (SettingTextSwitchView) findViewById(com.baidu.tieba.q.sv_person_msg_notify);
        ay.j(this.bsW.getView(), com.baidu.tieba.n.square_list_middle_bg_n);
    }

    public void ds(boolean z) {
        if (z) {
            this.bsW.N(false);
        } else {
            this.bsW.O(false);
        }
    }
}
