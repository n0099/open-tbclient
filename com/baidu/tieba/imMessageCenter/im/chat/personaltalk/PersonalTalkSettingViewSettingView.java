package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView bsV;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        if (this.bsV != null) {
            this.bsV.setSwitchStateChangeListener(bVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), com.baidu.tieba.r.p2ptalk_setting_detail_view, this);
        this.bsV = (SettingTextSwitchView) findViewById(com.baidu.tieba.q.sv_person_msg_notify);
        ay.j(this.bsV.getView(), com.baidu.tieba.n.square_list_middle_bg_n);
    }

    public void ds(boolean z) {
        if (z) {
            this.bsV.N(false);
        } else {
            this.bsV.O(false);
        }
    }
}
