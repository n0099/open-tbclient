package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView ahr;
    private TextView boA;
    private InviteMsgData boB;
    private TbImageView boy;
    private TextView boz;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), w.invite_to_group_view, this);
        setOrientation(1);
        this.ahr = (TextView) findViewById(v.chat_title);
        this.boy = (TbImageView) findViewById(v.chat_group_img);
        this.boz = (TextView) findViewById(v.chat_group_desc);
        this.boA = (TextView) findViewById(v.invite_btn);
        this.boy.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.boB = inviteMsgData;
        h(tbPageContext);
    }

    private void h(TbPageContext<?> tbPageContext) {
        this.boA.setEnabled(true);
        this.boA.setTag(String.valueOf(this.boB.getGroupId()));
        this.boA.setText(y.i_want_attent);
        this.boA.setTextColor(getContext().getResources().getColor(s.cp_bg_line_d));
        this.boA.setOnClickListener(new a(this));
        this.ahr.setText(this.boB.getTitle());
        this.boy.setTag(this.boB.getPortrait());
        this.boy.c(this.boB.getPortrait(), 10, false);
        this.boz.setText(this.boB.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.c.Sd().D(String.valueOf(this.boB.getGroupId()), 1) != null) {
            if (String.valueOf(this.boB.getGroupId()).equals(this.boA.getTag())) {
                this.boA.setText(y.i_want_talk);
                this.boA.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.Tn().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.boB.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
