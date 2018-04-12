package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class MsgSettingItemView2 extends LinearLayout {
    private CheckBox gjF;
    private View mBottomLine;

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
        LayoutInflater.from(context).inflate(d.i.msg_setting_item_view2, (ViewGroup) this, true);
        this.gjF = (CheckBox) findViewById(d.g.setting_check_view);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.gjF.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.gjF.setText(i);
        }
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    public CheckBox getSwitchView() {
        return this.gjF;
    }
}
