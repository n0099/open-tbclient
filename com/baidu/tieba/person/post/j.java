package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends a {
    private View bGA;
    private View bGz;
    public ReplyLinearLayout bRp;
    public TextView bRq;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(View view) {
        super(view, r0);
        TbPageContext tbPageContext;
        tbPageContext = g.XE;
        this.bRp = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.v.content_container);
        this.bRq = (TextView) view.findViewById(com.baidu.tieba.v.original_post_title);
        this.bGz = view.findViewById(com.baidu.tieba.v.reply_top_line);
        this.bGA = view.findViewById(com.baidu.tieba.v.reply_bottom_line);
        this.bRq.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void ct(int i) {
        super.ct(i);
        ba.i((View) this.bRq, com.baidu.tieba.s.cp_bg_line_e);
        ba.b(this.bRq, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i(this.bGz, com.baidu.tieba.s.cp_bg_line_b);
        ba.i(this.bGA, com.baidu.tieba.s.cp_bg_line_b);
    }
}
