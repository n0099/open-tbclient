package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView bsW;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), com.baidu.tieba.r.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.bsW = (TextView) findViewById(com.baidu.tieba.q.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(com.baidu.tieba.t.he);
                break;
            case 2:
                string = getResources().getString(com.baidu.tieba.t.she);
                break;
            default:
                string = getResources().getString(com.baidu.tieba.t.it);
                break;
        }
        this.bsW.setText(getResources().getString(com.baidu.tieba.t.in_black_desc_1, string));
    }
}
