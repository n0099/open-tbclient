package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView ffw;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), e.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.ffw = (TextView) findViewById(e.g.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(e.j.he);
                break;
            case 2:
                string = getResources().getString(e.j.she);
                break;
            default:
                string = getResources().getString(e.j.ta);
                break;
        }
        this.ffw.setText(getResources().getString(e.j.in_black_desc_1, string));
    }
}
