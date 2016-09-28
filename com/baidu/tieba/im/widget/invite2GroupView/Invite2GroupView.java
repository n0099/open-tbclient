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
    private TextView HO;
    private TbImageView dnZ;
    private TextView doa;
    private InviteMsgData dob;
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
        this.dnZ = (TbImageView) findViewById(r.g.chat_group_img);
        this.doa = (TextView) findViewById(r.g.chat_group_desc);
        this.HO = (TextView) findViewById(r.g.invite_btn);
        this.dnZ.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dob = inviteMsgData;
        u(tbPageContext);
    }

    private void u(TbPageContext<?> tbPageContext) {
        this.HO.setEnabled(true);
        this.HO.setTag(String.valueOf(this.dob.getGroupId()));
        this.HO.setText(r.j.i_want_attent);
        this.HO.setTextColor(getContext().getResources().getColor(r.d.cp_bg_line_d));
        this.HO.setOnClickListener(new a(this));
        this.title.setText(this.dob.getTitle());
        this.dnZ.setTag(this.dob.getPortrait());
        this.dnZ.c(this.dob.getPortrait(), 10, false);
        this.doa.setText(this.dob.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.avm().ah(String.valueOf(this.dob.getGroupId()), 1) != null) {
            if (String.valueOf(this.dob.getGroupId()).equals(this.HO.getTag())) {
                this.HO.setText(r.j.i_want_talk);
                this.HO.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.awG().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dob.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
