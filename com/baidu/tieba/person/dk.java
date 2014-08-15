package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class dk extends com.baidu.adp.base.f {
    View a;
    TextView b;
    TextView c;

    public dk(BaseFragmentActivity baseFragmentActivity, View.OnClickListener onClickListener) {
        super(baseFragmentActivity);
        a(baseFragmentActivity, onClickListener);
    }

    private void a(Context context, View.OnClickListener onClickListener) {
        this.a = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.person_info_more_view, (ViewGroup) null);
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.u.person_info_more_view_item_friend);
        this.b.setOnClickListener(onClickListener);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.u.person_info_more_view_item_black);
        this.c.setOnClickListener(onClickListener);
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        if (z2) {
            this.c.setText(com.baidu.tieba.x.remove_block_chat);
        } else {
            this.c.setText(com.baidu.tieba.x.block_chat_message);
        }
    }

    public View a() {
        return this.a;
    }

    public View b() {
        return this.b;
    }

    public View c() {
        return this.c;
    }
}
