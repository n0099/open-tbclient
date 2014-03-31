package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.groupInfo.aa;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.j;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView a;
    private HeadImageView b;
    private TextView c;
    private Button d;
    private InviteMsgData e;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public Invite2GroupView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(i.invite_to_group_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(h.chat_title);
        this.b = (HeadImageView) findViewById(h.chat_group_img);
        this.c = (TextView) findViewById(h.chat_group_desc);
        this.d = (Button) findViewById(h.invite_btn);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public final void setData(InviteMsgData inviteMsgData) {
        this.e = inviteMsgData;
        this.d.setEnabled(true);
        this.d.setTag(String.valueOf(this.e.getGroupId()));
        this.d.setText(j.i_want_attent);
        this.d.setTextColor(getContext().getResources().getColor(com.baidu.tieba.im.e.group_info_bottom_text));
        this.d.setOnClickListener(new a(this));
        this.a.setText(this.e.getTitle());
        this.b.setTag(this.e.getPortrait());
        this.c.setText(this.e.getNotice());
        setOnClickListener(new b(this));
        if (com.baidu.tieba.im.b.e.a(String.valueOf(this.e.getGroupId())) == null) {
            aa.a().a(TbadkApplication.E(), String.valueOf(this.e.getGroupId()), 60000L, new d(this));
        } else if (String.valueOf(this.e.getGroupId()).equals(this.d.getTag())) {
            this.d.setText(j.i_want_talk);
            this.d.setOnClickListener(new c(this));
        }
    }
}
