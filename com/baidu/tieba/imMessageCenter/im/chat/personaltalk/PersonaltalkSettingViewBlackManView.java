package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView dPn;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), d.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.dPn = (TextView) findViewById(d.g.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(d.j.he);
                break;
            case 2:
                string = getResources().getString(d.j.she);
                break;
            default:
                string = getResources().getString(d.j.ta);
                break;
        }
        this.dPn.setText(getResources().getString(d.j.in_black_desc_1, string));
    }
}
