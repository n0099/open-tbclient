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
    private View MV;
    private CheckBox dvJ;

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
        LayoutInflater.from(context).inflate(n.h.msg_setting_item_view2, (ViewGroup) this, true);
        this.dvJ = (CheckBox) findViewById(n.g.setting_check_view);
        this.MV = findViewById(n.g.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.dvJ.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.dvJ.setText(i);
        }
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.MV.setVisibility(0);
        } else {
            this.MV.setVisibility(8);
        }
    }

    public CheckBox getSwitchView() {
        return this.dvJ;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ac(i == 1);
        tbPageContext.getLayoutMode().k(this);
        com.baidu.tbadk.core.util.as.j(this, n.d.cp_bg_line_d);
    }
}
