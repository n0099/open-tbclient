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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class MsgSettingItemView2 extends LinearLayout {
    private View Mo;
    private CheckBox cQa;

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
        LayoutInflater.from(context).inflate(i.g.msg_setting_item_view2, (ViewGroup) this, true);
        this.cQa = (CheckBox) findViewById(i.f.setting_check_view);
        this.Mo = findViewById(i.f.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cQa.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cQa.setText(i);
        }
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mo.setVisibility(0);
        } else {
            this.Mo.setVisibility(8);
        }
    }

    public CheckBox getSwitchView() {
        return this.cQa;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
        com.baidu.tbadk.core.util.an.j(this, i.c.cp_bg_line_d);
    }
}
