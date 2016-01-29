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
    private TextView Ox;
    private TextView apm;
    private TbImageView chg;
    private TextView chh;
    private InviteMsgData chi;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qD();
    }

    public Invite2GroupView(Context context) {
        super(context);
        qD();
    }

    private void qD() {
        LayoutInflater.from(getContext()).inflate(t.h.invite_to_group_view, this);
        setOrientation(1);
        this.apm = (TextView) findViewById(t.g.chat_title);
        this.chg = (TbImageView) findViewById(t.g.chat_group_img);
        this.chh = (TextView) findViewById(t.g.chat_group_desc);
        this.Ox = (TextView) findViewById(t.g.invite_btn);
        this.chg.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.chi = inviteMsgData;
        k(tbPageContext);
    }

    private void k(TbPageContext<?> tbPageContext) {
        this.Ox.setEnabled(true);
        this.Ox.setTag(String.valueOf(this.chi.getGroupId()));
        this.Ox.setText(t.j.i_want_attent);
        this.Ox.setTextColor(getContext().getResources().getColor(t.d.cp_bg_line_d));
        this.Ox.setOnClickListener(new a(this));
        this.apm.setText(this.chi.getTitle());
        this.chg.setTag(this.chi.getPortrait());
        this.chg.d(this.chi.getPortrait(), 10, false);
        this.chh.setText(this.chi.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.ady().P(String.valueOf(this.chi.getGroupId()), 1) != null) {
            if (String.valueOf(this.chi.getGroupId()).equals(this.Ox.getTag())) {
                this.Ox.setText(t.j.i_want_talk);
                this.Ox.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.aeR().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.chi.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
