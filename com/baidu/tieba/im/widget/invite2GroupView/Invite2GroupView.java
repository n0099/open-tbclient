package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.groupInfo.aa;
import com.baidu.tieba.o;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
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
        LayoutInflater.from(getContext()).inflate(s.invite_to_group_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(r.chat_title);
        this.b = (HeadImageView) findViewById(r.chat_group_img);
        this.c = (TextView) findViewById(r.chat_group_desc);
        this.d = (Button) findViewById(r.invite_btn);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(InviteMsgData inviteMsgData) {
        this.e = inviteMsgData;
        b();
    }

    private void b() {
        this.d.setEnabled(true);
        this.d.setTag(String.valueOf(this.e.getGroupId()));
        this.d.setText(u.i_want_attent);
        this.d.setTextColor(getContext().getResources().getColor(o.group_info_bottom_text));
        this.d.setOnClickListener(new a(this));
        this.a.setText(this.e.getTitle());
        this.b.setTag(this.e.getPortrait());
        this.c.setText(this.e.getNotice());
        setOnClickListener(new b(this));
        if (com.baidu.tieba.im.b.e.a(String.valueOf(this.e.getGroupId())) != null) {
            if (String.valueOf(this.e.getGroupId()).equals(this.d.getTag())) {
                this.d.setText(u.i_want_talk);
                this.d.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        aa.a().a(TbadkApplication.getCurrentAccount(), String.valueOf(this.e.getGroupId()), TbConfig.USE_TIME_INTERVAL, new d(this));
    }
}
