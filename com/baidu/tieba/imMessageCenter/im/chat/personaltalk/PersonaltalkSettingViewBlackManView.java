package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView gMD;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), R.layout.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.gMD = (TextView) findViewById(R.id.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(R.string.he);
                break;
            case 2:
                string = getResources().getString(R.string.she);
                break;
            default:
                string = getResources().getString(R.string.ta);
                break;
        }
        this.gMD.setText(getResources().getString(R.string.in_black_desc_1, string));
    }
}
