package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView dvo;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), r.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.dvo = (TextView) findViewById(r.g.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(r.j.he);
                break;
            case 2:
                string = getResources().getString(r.j.she);
                break;
            default:
                string = getResources().getString(r.j.it);
                break;
        }
        this.dvo.setText(getResources().getString(r.j.in_black_desc_1, string));
    }
}
