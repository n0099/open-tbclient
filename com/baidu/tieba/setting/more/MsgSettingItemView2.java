package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgSettingItemView2 extends LinearLayout {
    private View Nu;
    private CheckBox een;

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
        LayoutInflater.from(context).inflate(t.h.msg_setting_item_view2, (ViewGroup) this, true);
        this.een = (CheckBox) findViewById(t.g.setting_check_view);
        this.Nu = findViewById(t.g.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.een.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.een.setText(i);
        }
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Nu.setVisibility(0);
        } else {
            this.Nu.setVisibility(8);
        }
    }

    public CheckBox getSwitchView() {
        return this.een;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().x(this);
        com.baidu.tbadk.core.util.at.l(this, t.d.cp_bg_line_d);
    }
}
