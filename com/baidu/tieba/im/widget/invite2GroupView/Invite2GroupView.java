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
    private TextView OE;
    private TextView apE;
    private TbImageView crL;
    private TextView crM;
    private InviteMsgData crN;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        pU();
    }

    public Invite2GroupView(Context context) {
        super(context);
        pU();
    }

    private void pU() {
        LayoutInflater.from(getContext()).inflate(t.h.invite_to_group_view, this);
        setOrientation(1);
        this.apE = (TextView) findViewById(t.g.chat_title);
        this.crL = (TbImageView) findViewById(t.g.chat_group_img);
        this.crM = (TextView) findViewById(t.g.chat_group_desc);
        this.OE = (TextView) findViewById(t.g.invite_btn);
        this.crL.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.crN = inviteMsgData;
        k(tbPageContext);
    }

    private void k(TbPageContext<?> tbPageContext) {
        this.OE.setEnabled(true);
        this.OE.setTag(String.valueOf(this.crN.getGroupId()));
        this.OE.setText(t.j.i_want_attent);
        this.OE.setTextColor(getContext().getResources().getColor(t.d.cp_bg_line_d));
        this.OE.setOnClickListener(new a(this));
        this.apE.setText(this.crN.getTitle());
        this.crL.setTag(this.crN.getPortrait());
        this.crL.c(this.crN.getPortrait(), 10, false);
        this.crM.setText(this.crN.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.agR().W(String.valueOf(this.crN.getGroupId()), 1) != null) {
            if (String.valueOf(this.crN.getGroupId()).equals(this.OE.getTag())) {
                this.OE.setText(t.j.i_want_talk);
                this.OE.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.aik().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.crN.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
