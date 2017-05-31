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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView auE;
    private TbImageView diw;
    private TextView dix;
    private TextView diy;
    private InviteMsgData diz;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(w.j.invite_to_group_view, this);
        setOrientation(1);
        this.auE = (TextView) findViewById(w.h.chat_title);
        this.diw = (TbImageView) findViewById(w.h.chat_group_img);
        this.dix = (TextView) findViewById(w.h.chat_group_desc);
        this.diy = (TextView) findViewById(w.h.invite_btn);
        this.diw.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.diz = inviteMsgData;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.diy.setEnabled(true);
        this.diy.setTag(String.valueOf(this.diz.getGroupId()));
        this.diy.setText(w.l.i_want_attent);
        this.diy.setTextColor(getContext().getResources().getColor(w.e.cp_bg_line_d));
        this.diy.setOnClickListener(new a(this));
        this.auE.setText(this.diz.getTitle());
        this.diw.setTag(this.diz.getPortrait());
        this.diw.c(this.diz.getPortrait(), 10, false);
        this.dix.setText(this.diz.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.aqX().Z(String.valueOf(this.diz.getGroupId()), 1) != null) {
            if (String.valueOf(this.diz.getGroupId()).equals(this.diy.getTag())) {
                this.diy.setText(w.l.i_want_talk);
                this.diy.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.asp().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.diz.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
