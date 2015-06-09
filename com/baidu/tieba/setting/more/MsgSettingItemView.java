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
    private View Mb;
    private TextView cgJ;
    private TextView cgK;
    private BdSwitchView cgL;

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
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.msg_setting_item_view, this, true);
        this.cgJ = (TextView) findViewById(com.baidu.tieba.q.setting_text);
        this.cgK = (TextView) findViewById(com.baidu.tieba.q.setting_tip);
        this.cgL = (BdSwitchView) findViewById(com.baidu.tieba.q.setting_switch);
        com.baidu.adp.lib.util.n.a(context, this.cgL, 10, 10, 10, 10);
        this.Mb = findViewById(com.baidu.tieba.q.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cgJ.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cgJ.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cgK.setVisibility(0);
        this.cgK.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.cgK.setVisibility(0);
            this.cgK.setText(i);
        }
    }

    public void mu() {
        this.cgL.mu();
    }

    public void mt() {
        this.cgL.mt();
    }

    public void ms() {
        this.cgL.ms();
    }

    public void mr() {
        this.cgL.mr();
    }

    public boolean hJ() {
        return this.cgL.hJ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mb.setVisibility(0);
        } else {
            this.Mb.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cgL;
    }

    public void setOnSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        this.cgL.setOnSwitchStateChangeListener(bVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().j(this);
        this.cgL.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle));
        com.baidu.tbadk.core.util.ay.j(this, com.baidu.tieba.n.cp_bg_line_d);
    }
}
