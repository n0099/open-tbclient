package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
final class n extends a {
    public ReplyLinearLayout g;
    public TextView h;
    private View i;
    private View j;

    public n(View view) {
        super(view);
        this.g = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.a.h.content_container);
        this.h = (TextView) view.findViewById(com.baidu.tieba.a.h.original_post_title);
        this.i = view.findViewById(com.baidu.tieba.a.h.reply_top_line);
        this.j = view.findViewById(com.baidu.tieba.a.h.reply_bottom_line);
        this.h.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public final void a(int i) {
        super.a(i);
        ba.f((View) this.h, com.baidu.tieba.a.e.cp_bg_line_e);
        ba.a(this.h, com.baidu.tieba.a.e.cp_cont_b, 1);
        ba.f(this.i, com.baidu.tieba.a.e.cp_bg_line_b);
        ba.f(this.j, com.baidu.tieba.a.e.cp_bg_line_b);
    }
}
