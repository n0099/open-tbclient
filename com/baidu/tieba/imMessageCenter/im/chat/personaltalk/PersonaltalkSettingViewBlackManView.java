package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView eEL;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), f.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.eEL = (TextView) findViewById(f.g.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(f.j.he);
                break;
            case 2:
                string = getResources().getString(f.j.she);
                break;
            default:
                string = getResources().getString(f.j.ta);
                break;
        }
        this.eEL.setText(getResources().getString(f.j.in_black_desc_1, string));
    }
}
