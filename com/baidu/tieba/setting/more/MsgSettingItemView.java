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
    private View bhA;
    private TextView cbR;
    private BdSwitchView cbS;

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
        this.cbR = (TextView) findViewById(com.baidu.tieba.v.setting_text);
        this.cbS = (BdSwitchView) findViewById(com.baidu.tieba.v.setting_switch);
        com.baidu.adp.lib.util.n.a(context, this.cbS, 10, 10, 10, 10);
        this.bhA = findViewById(com.baidu.tieba.v.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cbR.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cbR.setText(i);
        }
    }

    public void mb() {
        this.cbS.mb();
    }

    public void ma() {
        this.cbS.ma();
    }

    public void lZ() {
        this.cbS.lZ();
    }

    public void lY() {
        this.cbS.lY();
    }

    public boolean hZ() {
        return this.cbS.hZ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.bhA.setVisibility(0);
        } else {
            this.bhA.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cbS;
    }

    public void setOnSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        this.cbS.setOnSwitchStateChangeListener(bVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().X(i == 1);
        tbPageContext.getLayoutMode().h(this);
        this.cbS.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle));
        com.baidu.tbadk.core.util.ba.j(this, com.baidu.tieba.s.cp_bg_line_d);
    }
}
