package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class MsgSettingItemView2 extends LinearLayout {
    private CheckBox mYs;

    public MsgSettingItemView2(Context context) {
        super(context);
        init(context);
    }

    public MsgSettingItemView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.msg_setting_item_view2, (ViewGroup) this, true);
        this.mYs = (CheckBox) findViewById(R.id.setting_check_view);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.mYs.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.mYs.setText(i);
        }
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public CheckBox getSwitchView() {
        return this.mYs;
    }
}
