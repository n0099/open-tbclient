package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {
    private SettingTextSwitchView cel;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        initUI();
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        if (this.cel != null) {
            this.cel.setSwitchStateChangeListener(aVar);
        }
    }

    private void initUI() {
        setOrientation(1);
        inflate(getContext(), n.h.p2ptalk_setting_detail_view, this);
        this.cel = (SettingTextSwitchView) findViewById(n.g.sv_person_msg_notify);
        as.j(this.cel.getView(), n.d.square_list_middle_bg_n);
    }

    public void dX(boolean z) {
        if (z) {
            this.cel.L(false);
        } else {
            this.cel.M(false);
        }
    }
}
