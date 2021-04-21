package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PersonalTalkSettingViewSettingView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public SettingTextSwitchView f17913e;

    public PersonalTalkSettingViewSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public void a(boolean z) {
        if (z) {
            this.f17913e.f(false);
        } else {
            this.f17913e.e(false);
        }
    }

    public final void b() {
        setOrientation(1);
        LinearLayout.inflate(getContext(), R.layout.p2ptalk_setting_detail_view, this);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) findViewById(R.id.sv_person_msg_notify);
        this.f17913e = settingTextSwitchView;
        SkinManager.setBackgroundColor(settingTextSwitchView.getView(), R.color.common_color_10163);
    }

    public void setSwitchStateChangeListener(BdSwitchView.b bVar) {
        SettingTextSwitchView settingTextSwitchView = this.f17913e;
        if (settingTextSwitchView != null) {
            settingTextSwitchView.setSwitchStateChangeListener(bVar);
        }
    }

    public PersonalTalkSettingViewSettingView(Context context) {
        super(context);
        b();
    }
}
