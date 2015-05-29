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
    private View Mb;
    private CheckBox cgL;

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
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.msg_setting_item_view2, this, true);
        this.cgL = (CheckBox) findViewById(com.baidu.tieba.q.setting_check_view);
        this.Mb = findViewById(com.baidu.tieba.q.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cgL.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cgL.setText(i);
        }
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mb.setVisibility(0);
        } else {
            this.Mb.setVisibility(8);
        }
    }

    public CheckBox getSwitchView() {
        return this.cgL;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().j(this);
        com.baidu.tbadk.core.util.ay.j(this, com.baidu.tieba.n.cp_bg_line_d);
    }
}
