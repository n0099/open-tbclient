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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView HQ;
    private TbImageView dtI;
    private TextView dtJ;
    private InviteMsgData dtK;
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
        LayoutInflater.from(getContext()).inflate(r.h.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(r.g.chat_title);
        this.dtI = (TbImageView) findViewById(r.g.chat_group_img);
        this.dtJ = (TextView) findViewById(r.g.chat_group_desc);
        this.HQ = (TextView) findViewById(r.g.invite_btn);
        this.dtI.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dtK = inviteMsgData;
        w(tbPageContext);
    }

    private void w(TbPageContext<?> tbPageContext) {
        this.HQ.setEnabled(true);
        this.HQ.setTag(String.valueOf(this.dtK.getGroupId()));
        this.HQ.setText(r.j.i_want_attent);
        this.HQ.setTextColor(getContext().getResources().getColor(r.d.cp_bg_line_d));
        this.HQ.setOnClickListener(new a(this));
        this.title.setText(this.dtK.getTitle());
        this.dtI.setTag(this.dtK.getPortrait());
        this.dtI.c(this.dtK.getPortrait(), 10, false);
        this.dtJ.setText(this.dtK.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.axj().ah(String.valueOf(this.dtK.getGroupId()), 1) != null) {
            if (String.valueOf(this.dtK.getGroupId()).equals(this.HQ.getTag())) {
                this.HQ.setText(r.j.i_want_talk);
                this.HQ.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.ayD().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dtK.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
