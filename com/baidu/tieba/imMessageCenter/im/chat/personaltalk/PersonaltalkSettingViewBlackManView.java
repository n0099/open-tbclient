package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView ciL;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qD();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        qD();
    }

    private void qD() {
        inflate(getContext(), t.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.ciL = (TextView) findViewById(t.g.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(t.j.he);
                break;
            case 2:
                string = getResources().getString(t.j.she);
                break;
            default:
                string = getResources().getString(t.j.it);
                break;
        }
        this.ciL.setText(getResources().getString(t.j.in_black_desc_1, string));
    }
}
