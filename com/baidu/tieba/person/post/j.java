package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends a {
    public ReplyLinearLayout bUk;
    public TextView bUl;
    private View bUm;
    private View bUn;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(View view) {
        super(view, r0);
        TbPageContext tbPageContext;
        tbPageContext = g.Yt;
        this.bUk = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.q.content_container);
        this.bUl = (TextView) view.findViewById(com.baidu.tieba.q.original_post_title);
        this.bUm = view.findViewById(com.baidu.tieba.q.reply_top_line);
        this.bUn = view.findViewById(com.baidu.tieba.q.reply_bottom_line);
        this.bUl.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void cy(int i) {
        super.cy(i);
        ay.i((View) this.bUl, com.baidu.tieba.n.cp_bg_line_e);
        ay.b(this.bUl, com.baidu.tieba.n.cp_cont_b, 1);
        ay.i(this.bUm, com.baidu.tieba.n.cp_bg_line_b);
        ay.i(this.bUn, com.baidu.tieba.n.cp_bg_line_b);
    }
}
