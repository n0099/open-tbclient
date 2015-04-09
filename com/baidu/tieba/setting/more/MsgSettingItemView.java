package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class MsgSettingItemView extends LinearLayout {
    private View bhQ;
    private TextView ccg;
    private BdSwitchView cch;

    public MsgSettingItemView(Context context) {
        super(context);
        init(context);
    }

    public MsgSettingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.msg_setting_item_view, this, true);
        this.ccg = (TextView) findViewById(com.baidu.tieba.v.setting_text);
        this.cch = (BdSwitchView) findViewById(com.baidu.tieba.v.setting_switch);
        com.baidu.adp.lib.util.n.a(context, this.cch, 10, 10, 10, 10);
        this.bhQ = findViewById(com.baidu.tieba.v.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.ccg.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.ccg.setText(i);
        }
    }

    public void mb() {
        this.cch.mb();
    }

    public void ma() {
        this.cch.ma();
    }

    public void lZ() {
        this.cch.lZ();
    }

    public void lY() {
        this.cch.lY();
    }

    public boolean hZ() {
        return this.cch.hZ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.bhQ.setVisibility(0);
        } else {
            this.bhQ.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cch;
    }

    public void setOnSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        this.cch.setOnSwitchStateChangeListener(bVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().X(i == 1);
        tbPageContext.getLayoutMode().h(this);
        this.cch.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle));
        com.baidu.tbadk.core.util.ba.j(this, com.baidu.tieba.s.cp_bg_line_d);
    }
}
