package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView Xo;
    private HeadImageView bra;
    private TextView brb;
    private Button brc;
    private InviteMsgData brd;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ei().inflate(getContext(), x.invite_to_group_view, this);
        setOrientation(1);
        this.Xo = (TextView) findViewById(w.chat_title);
        this.bra = (HeadImageView) findViewById(w.chat_group_img);
        this.brb = (TextView) findViewById(w.chat_group_desc);
        this.brc = (Button) findViewById(w.invite_btn);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.brd = inviteMsgData;
        e(tbPageContext);
    }

    private void e(TbPageContext<?> tbPageContext) {
        this.brc.setEnabled(true);
        this.brc.setTag(String.valueOf(this.brd.getGroupId()));
        this.brc.setText(z.i_want_attent);
        this.brc.setTextColor(getContext().getResources().getColor(t.cp_bg_line_d));
        this.brc.setOnClickListener(new a(this));
        this.Xo.setText(this.brd.getTitle());
        this.bra.setTag(this.brd.getPortrait());
        this.bra.d(this.brd.getPortrait(), 10, false);
        this.brb.setText(this.brd.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.c.QO().H(String.valueOf(this.brd.getGroupId()), 1) != null) {
            if (String.valueOf(this.brd.getGroupId()).equals(this.brc.getTag())) {
                this.brc.setText(z.i_want_talk);
                this.brc.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.Tr().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.brd.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
