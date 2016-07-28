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
    private TextView FB;
    private TbImageView daU;
    private TextView daV;
    private InviteMsgData daW;
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
        LayoutInflater.from(getContext()).inflate(u.h.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(u.g.chat_title);
        this.daU = (TbImageView) findViewById(u.g.chat_group_img);
        this.daV = (TextView) findViewById(u.g.chat_group_desc);
        this.FB = (TextView) findViewById(u.g.invite_btn);
        this.daU.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.daW = inviteMsgData;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.FB.setEnabled(true);
        this.FB.setTag(String.valueOf(this.daW.getGroupId()));
        this.FB.setText(u.j.i_want_attent);
        this.FB.setTextColor(getContext().getResources().getColor(u.d.cp_bg_line_d));
        this.FB.setOnClickListener(new a(this));
        this.title.setText(this.daW.getTitle());
        this.daU.setTag(this.daW.getPortrait());
        this.daU.c(this.daW.getPortrait(), 10, false);
        this.daV.setText(this.daW.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.apZ().ah(String.valueOf(this.daW.getGroupId()), 1) != null) {
            if (String.valueOf(this.daW.getGroupId()).equals(this.FB.getTag())) {
                this.FB.setText(u.j.i_want_talk);
                this.FB.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.art().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.daW.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
