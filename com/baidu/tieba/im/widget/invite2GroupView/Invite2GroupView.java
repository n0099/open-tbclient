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
    private TextView HO;
    private TbImageView dmC;
    private TextView dmD;
    private InviteMsgData dmE;
    private TextView title;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(t.h.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(t.g.chat_title);
        this.dmC = (TbImageView) findViewById(t.g.chat_group_img);
        this.dmD = (TextView) findViewById(t.g.chat_group_desc);
        this.HO = (TextView) findViewById(t.g.invite_btn);
        this.dmC.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dmE = inviteMsgData;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.HO.setEnabled(true);
        this.HO.setTag(String.valueOf(this.dmE.getGroupId()));
        this.HO.setText(t.j.i_want_attent);
        this.HO.setTextColor(getContext().getResources().getColor(t.d.cp_bg_line_d));
        this.HO.setOnClickListener(new a(this));
        this.title.setText(this.dmE.getTitle());
        this.dmC.setTag(this.dmE.getPortrait());
        this.dmC.c(this.dmE.getPortrait(), 10, false);
        this.dmD.setText(this.dmE.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.auN().ah(String.valueOf(this.dmE.getGroupId()), 1) != null) {
            if (String.valueOf(this.dmE.getGroupId()).equals(this.HO.getTag())) {
                this.HO.setText(t.j.i_want_talk);
                this.HO.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.awh().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dmE.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
