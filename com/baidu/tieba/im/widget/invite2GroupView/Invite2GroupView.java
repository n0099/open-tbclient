package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView Xl;
    private HeadImageView bqZ;
    private TextView bra;
    private Button brb;
    private InviteMsgData brc;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ei().inflate(getContext(), x.invite_to_group_view, this);
        setOrientation(1);
        this.Xl = (TextView) findViewById(w.chat_title);
        this.bqZ = (HeadImageView) findViewById(w.chat_group_img);
        this.bra = (TextView) findViewById(w.chat_group_desc);
        this.brb = (Button) findViewById(w.invite_btn);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.brc = inviteMsgData;
        e(tbPageContext);
    }

    private void e(TbPageContext<?> tbPageContext) {
        this.brb.setEnabled(true);
        this.brb.setTag(String.valueOf(this.brc.getGroupId()));
        this.brb.setText(z.i_want_attent);
        this.brb.setTextColor(getContext().getResources().getColor(t.cp_bg_line_d));
        this.brb.setOnClickListener(new a(this));
        this.Xl.setText(this.brc.getTitle());
        this.bqZ.setTag(this.brc.getPortrait());
        this.bqZ.d(this.brc.getPortrait(), 10, false);
        this.bra.setText(this.brc.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.c.QJ().H(String.valueOf(this.brc.getGroupId()), 1) != null) {
            if (String.valueOf(this.brc.getGroupId()).equals(this.brb.getTag())) {
                this.brb.setText(z.i_want_talk);
                this.brb.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.Tm().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.brc.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
