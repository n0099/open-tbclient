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
    private TextView HP;
    private TextView apY;
    private TbImageView cYC;
    private TextView cYD;
    private InviteMsgData cYE;

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
        this.apY = (TextView) findViewById(r.g.chat_title);
        this.cYC = (TbImageView) findViewById(r.g.chat_group_img);
        this.cYD = (TextView) findViewById(r.g.chat_group_desc);
        this.HP = (TextView) findViewById(r.g.invite_btn);
        this.cYC.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.cYE = inviteMsgData;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.HP.setEnabled(true);
        this.HP.setTag(String.valueOf(this.cYE.getGroupId()));
        this.HP.setText(r.j.i_want_attent);
        this.HP.setTextColor(getContext().getResources().getColor(r.d.cp_bg_line_d));
        this.HP.setOnClickListener(new a(this));
        this.apY.setText(this.cYE.getTitle());
        this.cYC.setTag(this.cYE.getPortrait());
        this.cYC.c(this.cYE.getPortrait(), 10, false);
        this.cYD.setText(this.cYE.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.arI().af(String.valueOf(this.cYE.getGroupId()), 1) != null) {
            if (String.valueOf(this.cYE.getGroupId()).equals(this.HP.getTag())) {
                this.HP.setText(r.j.i_want_talk);
                this.HP.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.atc().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cYE.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
