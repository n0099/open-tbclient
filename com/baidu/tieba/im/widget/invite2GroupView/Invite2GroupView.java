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
import com.baidu.tieba.i;
import com.baidu.tieba.im.data.InviteMsgData;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView alu;
    private TbImageView bJg;
    private TextView bJh;
    private TextView bJi;
    private InviteMsgData bJj;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(i.g.invite_to_group_view, this);
        setOrientation(1);
        this.alu = (TextView) findViewById(i.f.chat_title);
        this.bJg = (TbImageView) findViewById(i.f.chat_group_img);
        this.bJh = (TextView) findViewById(i.f.chat_group_desc);
        this.bJi = (TextView) findViewById(i.f.invite_btn);
        this.bJg.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.bJj = inviteMsgData;
        j(tbPageContext);
    }

    private void j(TbPageContext<?> tbPageContext) {
        this.bJi.setEnabled(true);
        this.bJi.setTag(String.valueOf(this.bJj.getGroupId()));
        this.bJi.setText(i.h.i_want_attent);
        this.bJi.setTextColor(getContext().getResources().getColor(i.c.cp_bg_line_d));
        this.bJi.setOnClickListener(new a(this));
        this.alu.setText(this.bJj.getTitle());
        this.bJg.setTag(this.bJj.getPortrait());
        this.bJg.d(this.bJj.getPortrait(), 10, false);
        this.bJh.setText(this.bJj.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.VS().J(String.valueOf(this.bJj.getGroupId()), 1) != null) {
            if (String.valueOf(this.bJj.getGroupId()).equals(this.bJi.getTag())) {
                this.bJi.setText(i.h.i_want_talk);
                this.bJi.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.Xc().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bJj.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
