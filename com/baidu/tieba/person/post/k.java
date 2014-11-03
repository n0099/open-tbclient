package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
class k extends a {
    public ReplyLinearLayout bDT;
    public TextView bDU;
    private View bDV;
    private View bDW;

    public k(View view) {
        super(view);
        this.bDT = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.v.content_container);
        this.bDU = (TextView) view.findViewById(com.baidu.tieba.v.original_post_title);
        this.bDV = view.findViewById(com.baidu.tieba.v.reply_top_line);
        this.bDW = view.findViewById(com.baidu.tieba.v.reply_bottom_line);
        this.bDU.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void bM(int i) {
        super.bM(i);
        aw.h((View) this.bDU, com.baidu.tieba.s.cp_bg_line_e);
        aw.b(this.bDU, com.baidu.tieba.s.cp_cont_b, 1);
        aw.h(this.bDV, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bDW, com.baidu.tieba.s.cp_bg_line_b);
    }
}
