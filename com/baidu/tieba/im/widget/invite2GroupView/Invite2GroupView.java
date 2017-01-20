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
    private TextView GZ;
    private TextView apd;
    private TbImageView dfR;
    private TextView dfS;
    private InviteMsgData dfT;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(r.j.invite_to_group_view, this);
        setOrientation(1);
        this.apd = (TextView) findViewById(r.h.chat_title);
        this.dfR = (TbImageView) findViewById(r.h.chat_group_img);
        this.dfS = (TextView) findViewById(r.h.chat_group_desc);
        this.GZ = (TextView) findViewById(r.h.invite_btn);
        this.dfR.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dfT = inviteMsgData;
        s(tbPageContext);
    }

    private void s(TbPageContext<?> tbPageContext) {
        this.GZ.setEnabled(true);
        this.GZ.setTag(String.valueOf(this.dfT.getGroupId()));
        this.GZ.setText(r.l.i_want_attent);
        this.GZ.setTextColor(getContext().getResources().getColor(r.e.cp_bg_line_d));
        this.GZ.setOnClickListener(new a(this));
        this.apd.setText(this.dfT.getTitle());
        this.dfR.setTag(this.dfT.getPortrait());
        this.dfR.c(this.dfT.getPortrait(), 10, false);
        this.dfS.setText(this.dfT.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.asO().af(String.valueOf(this.dfT.getGroupId()), 1) != null) {
            if (String.valueOf(this.dfT.getGroupId()).equals(this.GZ.getTag())) {
                this.GZ.setText(r.l.i_want_talk);
                this.GZ.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.aui().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dfT.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
