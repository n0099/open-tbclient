package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.groupInfo.aa;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView QK;
    private HeadImageView bkn;
    private TextView bko;
    private Button bkp;
    private InviteMsgData bkq;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ek().inflate(getContext(), w.invite_to_group_view, this);
        setOrientation(1);
        this.QK = (TextView) findViewById(v.chat_title);
        this.bkn = (HeadImageView) findViewById(v.chat_group_img);
        this.bko = (TextView) findViewById(v.chat_group_desc);
        this.bkp = (Button) findViewById(v.invite_btn);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(InviteMsgData inviteMsgData) {
        this.bkq = inviteMsgData;
        nx();
    }

    private void nx() {
        this.bkp.setEnabled(true);
        this.bkp.setTag(String.valueOf(this.bkq.getGroupId()));
        this.bkp.setText(y.i_want_attent);
        this.bkp.setTextColor(getContext().getResources().getColor(s.group_info_bottom_text));
        this.bkp.setOnClickListener(new a(this));
        this.QK.setText(this.bkq.getTitle());
        this.bkn.setTag(this.bkq.getPortrait());
        this.bkn.c(this.bkq.getPortrait(), 10, false);
        this.bko.setText(this.bkq.getNotice());
        setOnClickListener(new b(this));
        if (com.baidu.tieba.im.memorycache.c.PN().B(String.valueOf(this.bkq.getGroupId()), 1) != null) {
            if (String.valueOf(this.bkq.getGroupId()).equals(this.bkp.getTag())) {
                this.bkp.setText(y.i_want_talk);
                this.bkp.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        aa.Pe().a(TbadkApplication.getCurrentAccount(), String.valueOf(this.bkq.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this));
    }
}
