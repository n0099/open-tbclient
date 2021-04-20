package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17906e;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        LinearLayout.inflate(getContext(), R.layout.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.f17906e = (TextView) findViewById(R.id.black_man_text);
    }

    public void setSex(int i) {
        String string;
        if (i == 1) {
            string = getResources().getString(R.string.he);
        } else if (i != 2) {
            string = getResources().getString(R.string.ta);
        } else {
            string = getResources().getString(R.string.she);
        }
        this.f17906e.setText(getResources().getString(R.string.in_black_desc_1, string));
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        a();
    }
}
