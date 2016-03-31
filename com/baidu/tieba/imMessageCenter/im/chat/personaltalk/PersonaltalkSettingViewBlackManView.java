package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView ctq;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        pU();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        pU();
    }

    private void pU() {
        inflate(getContext(), t.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.ctq = (TextView) findViewById(t.g.black_man_text);
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
        this.ctq.setText(getResources().getString(t.j.in_black_desc_1, string));
    }
}
