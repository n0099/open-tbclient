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
    private TextView anH;
    private TbImageView bFj;
    private TextView bFk;
    private TextView bFl;
    private InviteMsgData bFm;

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
        this.anH = (TextView) findViewById(i.f.chat_title);
        this.bFj = (TbImageView) findViewById(i.f.chat_group_img);
        this.bFk = (TextView) findViewById(i.f.chat_group_desc);
        this.bFl = (TextView) findViewById(i.f.invite_btn);
        this.bFj.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.bFm = inviteMsgData;
        j(tbPageContext);
    }

    private void j(TbPageContext<?> tbPageContext) {
        this.bFl.setEnabled(true);
        this.bFl.setTag(String.valueOf(this.bFm.getGroupId()));
        this.bFl.setText(i.C0057i.i_want_attent);
        this.bFl.setTextColor(getContext().getResources().getColor(i.c.cp_bg_line_d));
        this.bFl.setOnClickListener(new a(this));
        this.anH.setText(this.bFm.getTitle());
        this.bFj.setTag(this.bFm.getPortrait());
        this.bFj.d(this.bFm.getPortrait(), 10, false);
        this.bFk.setText(this.bFm.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.Vl().G(String.valueOf(this.bFm.getGroupId()), 1) != null) {
            if (String.valueOf(this.bFm.getGroupId()).equals(this.bFl.getTag())) {
                this.bFl.setText(i.C0057i.i_want_talk);
                this.bFl.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.Wv().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bFm.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
