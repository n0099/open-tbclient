package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView EU;
    private TbImageView csI;
    private TextView csJ;
    private InviteMsgData csK;
    private TextView title;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        nq();
    }

    public Invite2GroupView(Context context) {
        super(context);
        nq();
    }

    private void nq() {
        LayoutInflater.from(getContext()).inflate(t.h.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(t.g.chat_title);
        this.csI = (TbImageView) findViewById(t.g.chat_group_img);
        this.csJ = (TextView) findViewById(t.g.chat_group_desc);
        this.EU = (TextView) findViewById(t.g.invite_btn);
        this.csI.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.csK = inviteMsgData;
        l(tbPageContext);
    }

    private void l(TbPageContext<?> tbPageContext) {
        this.EU.setEnabled(true);
        this.EU.setTag(String.valueOf(this.csK.getGroupId()));
        this.EU.setText(t.j.i_want_attent);
        this.EU.setTextColor(getContext().getResources().getColor(t.d.cp_bg_line_d));
        this.EU.setOnClickListener(new a(this));
        this.title.setText(this.csK.getTitle());
        this.csI.setTag(this.csK.getPortrait());
        this.csI.c(this.csK.getPortrait(), 10, false);
        this.csJ.setText(this.csK.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.agY().aa(String.valueOf(this.csK.getGroupId()), 1) != null) {
            if (String.valueOf(this.csK.getGroupId()).equals(this.EU.getTag())) {
                this.EU.setText(t.j.i_want_talk);
                this.EU.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.air().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.csK.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
