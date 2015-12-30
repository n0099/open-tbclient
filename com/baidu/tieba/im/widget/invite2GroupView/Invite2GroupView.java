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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView ahk;
    private TbImageView ccG;
    private TextView ccH;
    private TextView ccI;
    private InviteMsgData ccJ;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(n.h.invite_to_group_view, this);
        setOrientation(1);
        this.ahk = (TextView) findViewById(n.g.chat_title);
        this.ccG = (TbImageView) findViewById(n.g.chat_group_img);
        this.ccH = (TextView) findViewById(n.g.chat_group_desc);
        this.ccI = (TextView) findViewById(n.g.invite_btn);
        this.ccG.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.ccJ = inviteMsgData;
        k(tbPageContext);
    }

    private void k(TbPageContext<?> tbPageContext) {
        this.ccI.setEnabled(true);
        this.ccI.setTag(String.valueOf(this.ccJ.getGroupId()));
        this.ccI.setText(n.j.i_want_attent);
        this.ccI.setTextColor(getContext().getResources().getColor(n.d.cp_bg_line_d));
        this.ccI.setOnClickListener(new a(this));
        this.ahk.setText(this.ccJ.getTitle());
        this.ccG.setTag(this.ccJ.getPortrait());
        this.ccG.d(this.ccJ.getPortrait(), 10, false);
        this.ccH.setText(this.ccJ.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.aay().O(String.valueOf(this.ccJ.getGroupId()), 1) != null) {
            if (String.valueOf(this.ccJ.getGroupId()).equals(this.ccI.getTag())) {
                this.ccI.setText(n.j.i_want_talk);
                this.ccI.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.abL().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.ccJ.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
