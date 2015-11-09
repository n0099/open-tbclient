package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView bLh;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), i.g.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.bLh = (TextView) findViewById(i.f.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(i.h.he);
                break;
            case 2:
                string = getResources().getString(i.h.she);
                break;
            default:
                string = getResources().getString(i.h.it);
                break;
        }
        this.bLh.setText(getResources().getString(i.h.in_black_desc_1, string));
    }
}
