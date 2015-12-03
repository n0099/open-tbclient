package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView cal;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), n.g.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.cal = (TextView) findViewById(n.f.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(n.i.he);
                break;
            case 2:
                string = getResources().getString(n.i.she);
                break;
            default:
                string = getResources().getString(n.i.it);
                break;
        }
        this.cal.setText(getResources().getString(n.i.in_black_desc_1, string));
    }
}
