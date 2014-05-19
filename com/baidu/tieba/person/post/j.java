package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
class j extends a {
    public ReplyLinearLayout g;
    public TextView h;
    private View i;
    private View j;

    public j(View view) {
        super(view);
        this.g = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.r.content_container);
        this.h = (TextView) view.findViewById(com.baidu.tieba.r.original_post_title);
        this.i = view.findViewById(com.baidu.tieba.r.reply_top_line);
        this.j = view.findViewById(com.baidu.tieba.r.reply_bottom_line);
        this.h.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void a(int i) {
        super.a(i);
        bc.f((View) this.h, com.baidu.tieba.o.cp_bg_line_e);
        bc.a(this.h, com.baidu.tieba.o.cp_cont_b, 1);
        bc.f(this.i, com.baidu.tieba.o.cp_bg_line_b);
        bc.f(this.j, com.baidu.tieba.o.cp_bg_line_b);
    }
}
