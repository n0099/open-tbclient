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
    private TextView cgI;
    private TextView cgJ;
    private BdSwitchView cgK;

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
        this.cgI = (TextView) findViewById(com.baidu.tieba.q.setting_text);
        this.cgJ = (TextView) findViewById(com.baidu.tieba.q.setting_tip);
        this.cgK = (BdSwitchView) findViewById(com.baidu.tieba.q.setting_switch);
        com.baidu.adp.lib.util.n.a(context, this.cgK, 10, 10, 10, 10);
        this.Mb = findViewById(com.baidu.tieba.q.bottom_line_ll);
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cgI.setText(str);
    }

    public void setText(int i) {
        if (i != 0) {
            this.cgI.setText(i);
        }
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.cgJ.setVisibility(0);
        this.cgJ.setText(str);
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.cgJ.setVisibility(0);
            this.cgJ.setText(i);
        }
    }

    public void mu() {
        this.cgK.mu();
    }

    public void mt() {
        this.cgK.mt();
    }

    public void ms() {
        this.cgK.ms();
    }

    public void mr() {
        this.cgK.mr();
    }

    public boolean hJ() {
        return this.cgK.hJ();
    }

    public void setLineVisibility(boolean z) {
        if (z) {
            this.Mb.setVisibility(0);
        } else {
            this.Mb.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cgK;
    }

    public void setOnSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        this.cgK.setOnSwitchStateChangeListener(bVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().j(this);
        this.cgK.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle));
        com.baidu.tbadk.core.util.ay.j(this, com.baidu.tieba.n.cp_bg_line_d);
    }
}
