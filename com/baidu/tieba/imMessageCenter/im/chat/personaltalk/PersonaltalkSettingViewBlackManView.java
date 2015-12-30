package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView cem;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), n.h.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.cem = (TextView) findViewById(n.g.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(n.j.he);
                break;
            case 2:
                string = getResources().getString(n.j.she);
                break;
            default:
                string = getResources().getString(n.j.it);
                break;
        }
        this.cem.setText(getResources().getString(n.j.in_black_desc_1, string));
    }
}
