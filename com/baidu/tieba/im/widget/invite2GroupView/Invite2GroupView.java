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
    private TbImageView brv;
    private TextView brw;
    private TextView brx;
    private InviteMsgData bry;

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
        this.brv = (TbImageView) findViewById(q.chat_group_img);
        this.brw = (TextView) findViewById(q.chat_group_desc);
        this.brx = (TextView) findViewById(q.invite_btn);
        this.brv.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.bry = inviteMsgData;
        h(tbPageContext);
    }

    private void h(TbPageContext<?> tbPageContext) {
        this.brx.setEnabled(true);
        this.brx.setTag(String.valueOf(this.bry.getGroupId()));
        this.brx.setText(t.i_want_attent);
        this.brx.setTextColor(getContext().getResources().getColor(n.cp_bg_line_d));
        this.brx.setOnClickListener(new a(this));
        this.aiA.setText(this.bry.getTitle());
        this.brv.setTag(this.bry.getPortrait());
        this.brv.c(this.bry.getPortrait(), 10, false);
        this.brw.setText(this.bry.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.c.TE().D(String.valueOf(this.bry.getGroupId()), 1) != null) {
            if (String.valueOf(this.bry.getGroupId()).equals(this.brx.getTag())) {
                this.brx.setText(t.i_want_talk);
                this.brx.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.UO().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bry.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
