package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView dse;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), w.j.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.dse = (TextView) findViewById(w.h.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(w.l.he);
                break;
            case 2:
                string = getResources().getString(w.l.she);
                break;
            default:
                string = getResources().getString(w.l.ta);
                break;
        }
        this.dse.setText(getResources().getString(w.l.in_black_desc_1, string));
    }
}
