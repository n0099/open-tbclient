package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class k extends a {
    public ReplyLinearLayout g;
    public TextView h;
    private View i;
    private View j;

    public k(View view) {
        super(view);
        this.g = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.u.content_container);
        this.h = (TextView) view.findViewById(com.baidu.tieba.u.original_post_title);
        this.i = view.findViewById(com.baidu.tieba.u.reply_top_line);
        this.j = view.findViewById(com.baidu.tieba.u.reply_bottom_line);
        this.h.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void a(int i) {
        super.a(i);
        ay.f((View) this.h, com.baidu.tieba.r.cp_bg_line_e);
        ay.a(this.h, com.baidu.tieba.r.cp_cont_b, 1);
        ay.f(this.i, com.baidu.tieba.r.cp_bg_line_b);
        ay.f(this.j, com.baidu.tieba.r.cp_bg_line_b);
    }
}
