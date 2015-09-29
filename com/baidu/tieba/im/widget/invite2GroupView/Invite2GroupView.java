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
import com.baidu.tieba.i;
import com.baidu.tieba.im.data.InviteMsgData;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView alt;
    private TbImageView bIV;
    private TextView bIW;
    private TextView bIX;
    private InviteMsgData bIY;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(i.g.invite_to_group_view, this);
        setOrientation(1);
        this.alt = (TextView) findViewById(i.f.chat_title);
        this.bIV = (TbImageView) findViewById(i.f.chat_group_img);
        this.bIW = (TextView) findViewById(i.f.chat_group_desc);
        this.bIX = (TextView) findViewById(i.f.invite_btn);
        this.bIV.setIsRound(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.bIY = inviteMsgData;
        j(tbPageContext);
    }

    private void j(TbPageContext<?> tbPageContext) {
        this.bIX.setEnabled(true);
        this.bIX.setTag(String.valueOf(this.bIY.getGroupId()));
        this.bIX.setText(i.h.i_want_attent);
        this.bIX.setTextColor(getContext().getResources().getColor(i.c.cp_bg_line_d));
        this.bIX.setOnClickListener(new a(this));
        this.alt.setText(this.bIY.getTitle());
        this.bIV.setTag(this.bIY.getPortrait());
        this.bIV.d(this.bIY.getPortrait(), 10, false);
        this.bIW.setText(this.bIY.getNotice());
        setOnClickListener(new b(this, tbPageContext));
        if (com.baidu.tieba.im.memorycache.b.VW().J(String.valueOf(this.bIY.getGroupId()), 1) != null) {
            if (String.valueOf(this.bIY.getGroupId()).equals(this.bIX.getTag())) {
                this.bIX.setText(i.h.i_want_talk);
                this.bIX.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.c.Xg().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bIY.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this, tbPageContext));
    }
}
