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
    private HeadImageView bpC;
    private TextView bpD;
    private Button bpE;
    private InviteMsgData bpF;
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
        com.baidu.adp.lib.g.b.ek().inflate(getContext(), x.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(w.chat_title);
        this.bpC = (HeadImageView) findViewById(w.chat_group_img);
        this.bpD = (TextView) findViewById(w.chat_group_desc);
        this.bpE = (Button) findViewById(w.invite_btn);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.bpF = inviteMsgData;
        d(tbPageContext);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.bpE.setEnabled(true);
        this.bpE.setTag(String.valueOf(this.bpF.getGroupId()));
        this.bpE.setText(z.i_want_attent);
        this.bpE.setTextColor(getContext().getResources().getColor(t.cp_bg_line_d));
        this.bpE.setOnClickListener(new a(this));
        this.title.setText(this.bpF.getTitle());
        this.bpC.setTag(this.bpF.getPortrait());
        this.bpC.d(this.bpF.getPortrait(), 10, false);
        this.bpD.setText(this.bpF.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.c.Qs().H(String.valueOf(this.bpF.getGroupId()), 1) != null) {
            if (String.valueOf(this.bpF.getGroupId()).equals(this.bpE.getTag())) {
                this.bpE.setText(z.i_want_talk);
                this.bpE.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.SV().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bpF.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
