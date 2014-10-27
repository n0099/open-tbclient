package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
class k extends a {
    public ReplyLinearLayout bDF;
    public TextView bDG;
    private View bDH;
    private View bDI;

    public k(View view) {
        super(view);
        this.bDF = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.v.content_container);
        this.bDG = (TextView) view.findViewById(com.baidu.tieba.v.original_post_title);
        this.bDH = view.findViewById(com.baidu.tieba.v.reply_top_line);
        this.bDI = view.findViewById(com.baidu.tieba.v.reply_bottom_line);
        this.bDG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void bM(int i) {
        super.bM(i);
        aw.h((View) this.bDG, com.baidu.tieba.s.cp_bg_line_e);
        aw.b(this.bDG, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bDH, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bDI, com.baidu.tieba.s.cp_bg_line_b);
    }
}
