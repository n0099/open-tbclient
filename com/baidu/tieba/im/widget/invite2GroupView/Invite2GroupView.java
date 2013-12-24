package com.baidu.tieba.im.widget.invite2GroupView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
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
        LayoutInflater.from(getContext()).inflate(R.layout.invite_to_group_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(R.id.chat_title);
        this.b = (HeadImageView) findViewById(R.id.chat_group_img);
        this.c = (TextView) findViewById(R.id.chat_group_desc);
        this.d = (Button) findViewById(R.id.invite_btn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(InviteMsgData inviteMsgData) {
        this.e = inviteMsgData;
        b();
    }

    private void b() {
        this.d.setEnabled(true);
        this.d.setTag(String.valueOf(this.e.getGroupId()));
        this.d.setText(R.string.i_want_attent);
        this.d.setTextColor(getContext().getResources().getColor(R.color.group_info_bottom_text));
        this.d.setOnClickListener(new a(this));
        this.a.setText(this.e.getTitle());
        this.b.setTag(this.e.getPortrait());
        this.c.setText(this.e.getNotice());
        setOnClickListener(new b(this));
        ad.a().a(new c(this));
    }
}
