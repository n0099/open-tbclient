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
    private TextView ahz;
    private TbImageView boO;
    private TextView boP;
    private TextView boQ;
    private InviteMsgData boR;

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
        this.ahz = (TextView) findViewById(v.chat_title);
        this.boO = (TbImageView) findViewById(v.chat_group_img);
        this.boP = (TextView) findViewById(v.chat_group_desc);
        this.boQ = (TextView) findViewById(v.invite_btn);
        this.boO.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.boR = inviteMsgData;
        h(tbPageContext);
    }

    private void h(TbPageContext<?> tbPageContext) {
        this.boQ.setEnabled(true);
        this.boQ.setTag(String.valueOf(this.boR.getGroupId()));
        this.boQ.setText(y.i_want_attent);
        this.boQ.setTextColor(getContext().getResources().getColor(s.cp_bg_line_d));
        this.boQ.setOnClickListener(new a(this));
        this.ahz.setText(this.boR.getTitle());
        this.boO.setTag(this.boR.getPortrait());
        this.boO.c(this.boR.getPortrait(), 10, false);
        this.boP.setText(this.boR.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.c.Sq().D(String.valueOf(this.boR.getGroupId()), 1) != null) {
            if (String.valueOf(this.boR.getGroupId()).equals(this.boQ.getTag())) {
                this.boQ.setText(y.i_want_talk);
                this.boQ.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.TA().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.boR.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
