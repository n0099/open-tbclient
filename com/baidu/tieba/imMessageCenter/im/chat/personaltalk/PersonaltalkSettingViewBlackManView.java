package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView dcB;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), u.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.dcB = (TextView) findViewById(u.g.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(u.j.he);
                break;
            case 2:
                string = getResources().getString(u.j.she);
                break;
            default:
                string = getResources().getString(u.j.it);
                break;
        }
        this.dcB.setText(getResources().getString(u.j.in_black_desc_1, string));
    }
}
