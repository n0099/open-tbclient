package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class MsgSettingItemView2 extends LinearLayout {
    private View bhA;
    private CheckBox cbT;

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
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.msg_setting_item_view2, this, true);
        this.cbT = (CheckBox) findViewById(com.baidu.tieba.v.setting_check_view);
        this.bhA = findViewById(com.baidu.tieba.v.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cbT.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cbT.setText(i);
        }
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.bhA.setVisibility(0);
        } else {
            this.bhA.setVisibility(8);
        }
    }

    public CheckBox getSwitchView() {
        return this.cbT;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().X(i == 1);
        tbPageContext.getLayoutMode().h(this);
        com.baidu.tbadk.core.util.ba.j(this, com.baidu.tieba.s.cp_bg_line_d);
    }
}
