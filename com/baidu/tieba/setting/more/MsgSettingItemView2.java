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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MsgSettingItemView2 extends LinearLayout {
    private View MF;
    private CheckBox dow;

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
        LayoutInflater.from(context).inflate(n.g.msg_setting_item_view2, (ViewGroup) this, true);
        this.dow = (CheckBox) findViewById(n.f.setting_check_view);
        this.MF = findViewById(n.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dow.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.dow.setText(i);
        }
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.MF.setVisibility(0);
        } else {
            this.MF.setVisibility(8);
        }
    }

    public CheckBox getSwitchView() {
        return this.dow;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().af(i == 1);
        tbPageContext.getLayoutMode().k(this);
        com.baidu.tbadk.core.util.as.j(this, n.c.cp_bg_line_d);
    }
}
