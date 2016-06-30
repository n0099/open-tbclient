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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView Fb;
    private TbImageView cXX;
    private TextView cXY;
    private InviteMsgData cXZ;
    private TextView title;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        nl();
    }

    public Invite2GroupView(Context context) {
        super(context);
        nl();
    }

    private void nl() {
        LayoutInflater.from(getContext()).inflate(u.h.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(u.g.chat_title);
        this.cXX = (TbImageView) findViewById(u.g.chat_group_img);
        this.cXY = (TextView) findViewById(u.g.chat_group_desc);
        this.Fb = (TextView) findViewById(u.g.invite_btn);
        this.cXX.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.cXZ = inviteMsgData;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.Fb.setEnabled(true);
        this.Fb.setTag(String.valueOf(this.cXZ.getGroupId()));
        this.Fb.setText(u.j.i_want_attent);
        this.Fb.setTextColor(getContext().getResources().getColor(u.d.cp_bg_line_d));
        this.Fb.setOnClickListener(new a(this));
        this.title.setText(this.cXZ.getTitle());
        this.cXX.setTag(this.cXZ.getPortrait());
        this.cXX.c(this.cXZ.getPortrait(), 10, false);
        this.cXY.setText(this.cXZ.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.apn().ah(String.valueOf(this.cXZ.getGroupId()), 1) != null) {
            if (String.valueOf(this.cXZ.getGroupId()).equals(this.Fb.getTag())) {
                this.Fb.setText(u.j.i_want_talk);
                this.Fb.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.aqH().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cXZ.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
