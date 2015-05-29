package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView aiA;
    private TbImageView bru;
    private TextView brv;
    private TextView brw;
    private InviteMsgData brx;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), r.invite_to_group_view, this);
        setOrientation(1);
        this.aiA = (TextView) findViewById(q.chat_title);
        this.bru = (TbImageView) findViewById(q.chat_group_img);
        this.brv = (TextView) findViewById(q.chat_group_desc);
        this.brw = (TextView) findViewById(q.invite_btn);
        this.bru.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.brx = inviteMsgData;
        h(tbPageContext);
    }

    private void h(TbPageContext<?> tbPageContext) {
        this.brw.setEnabled(true);
        this.brw.setTag(String.valueOf(this.brx.getGroupId()));
        this.brw.setText(t.i_want_attent);
        this.brw.setTextColor(getContext().getResources().getColor(n.cp_bg_line_d));
        this.brw.setOnClickListener(new a(this));
        this.aiA.setText(this.brx.getTitle());
        this.bru.setTag(this.brx.getPortrait());
        this.bru.c(this.brx.getPortrait(), 10, false);
        this.brv.setText(this.brx.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.c.TD().D(String.valueOf(this.brx.getGroupId()), 1) != null) {
            if (String.valueOf(this.brx.getGroupId()).equals(this.brw.getTag())) {
                this.brw.setText(t.i_want_talk);
                this.brw.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.UN().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.brx.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
