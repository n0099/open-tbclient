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
    private TextView auQ;
    private TbImageView diY;
    private TextView diZ;
    private TextView dja;
    private InviteMsgData djb;

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
        this.auQ = (TextView) findViewById(w.h.chat_title);
        this.diY = (TbImageView) findViewById(w.h.chat_group_img);
        this.diZ = (TextView) findViewById(w.h.chat_group_desc);
        this.dja = (TextView) findViewById(w.h.invite_btn);
        this.diY.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.djb = inviteMsgData;
        t(tbPageContext);
    }

    private void t(TbPageContext<?> tbPageContext) {
        this.dja.setEnabled(true);
        this.dja.setTag(String.valueOf(this.djb.getGroupId()));
        this.dja.setText(w.l.i_want_attent);
        this.dja.setTextColor(getContext().getResources().getColor(w.e.cp_bg_line_d));
        this.dja.setOnClickListener(new a(this));
        this.auQ.setText(this.djb.getTitle());
        this.diY.setTag(this.djb.getPortrait());
        this.diY.c(this.djb.getPortrait(), 10, false);
        this.diZ.setText(this.djb.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.atd().Y(String.valueOf(this.djb.getGroupId()), 1) != null) {
            if (String.valueOf(this.djb.getGroupId()).equals(this.dja.getTag())) {
                this.dja.setText(w.l.i_want_talk);
                this.dja.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.aux().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.djb.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
