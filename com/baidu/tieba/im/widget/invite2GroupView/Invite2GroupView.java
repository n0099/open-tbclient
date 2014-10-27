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
import com.baidu.tieba.im.groupInfo.z;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView QG;
    private HeadImageView bjZ;
    private TextView bka;
    private Button bkb;
    private InviteMsgData bkc;

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
        this.QG = (TextView) findViewById(v.chat_title);
        this.bjZ = (HeadImageView) findViewById(v.chat_group_img);
        this.bka = (TextView) findViewById(v.chat_group_desc);
        this.bkb = (Button) findViewById(v.invite_btn);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(InviteMsgData inviteMsgData) {
        this.bkc = inviteMsgData;
        nx();
    }

    private void nx() {
        this.bkb.setEnabled(true);
        this.bkb.setTag(String.valueOf(this.bkc.getGroupId()));
        this.bkb.setText(y.i_want_attent);
        this.bkb.setTextColor(getContext().getResources().getColor(s.group_info_bottom_text));
        this.bkb.setOnClickListener(new a(this));
        this.QG.setText(this.bkc.getTitle());
        this.bjZ.setTag(this.bkc.getPortrait());
        this.bjZ.c(this.bkc.getPortrait(), 10, false);
        this.bka.setText(this.bkc.getNotice());
        setOnClickListener(new b(this));
        if (com.baidu.tieba.im.memorycache.c.PK().B(String.valueOf(this.bkc.getGroupId()), 1) != null) {
            if (String.valueOf(this.bkc.getGroupId()).equals(this.bkb.getTag())) {
                this.bkb.setText(y.i_want_talk);
                this.bkb.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        z.Pb().a(TbadkApplication.getCurrentAccount(), String.valueOf(this.bkc.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this));
    }
}
