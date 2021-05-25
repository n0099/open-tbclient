package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class MsgSettingItemView2 extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f20453e;

    public MsgSettingItemView2(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.msg_setting_item_view2, (ViewGroup) this, true);
        this.f20453e = (CheckBox) findViewById(R.id.setting_check_view);
    }

    public CheckBox getSwitchView() {
        return this.f20453e;
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.f20453e.setText(str);
    }

    public MsgSettingItemView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setText(int i2) {
        if (i2 != 0) {
            this.f20453e.setText(i2);
        }
    }
}
