package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends a {
    public ReplyLinearLayout bHs;
    public TextView bHt;
    private View bHu;
    private View bHv;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(View view) {
        super(view, r0);
        TbPageContext tbPageContext;
        tbPageContext = g.Me;
        this.bHs = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.w.content_container);
        this.bHt = (TextView) view.findViewById(com.baidu.tieba.w.original_post_title);
        this.bHu = view.findViewById(com.baidu.tieba.w.reply_top_line);
        this.bHv = view.findViewById(com.baidu.tieba.w.reply_bottom_line);
        this.bHt.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void cl(int i) {
        super.cl(i);
        ax.i((View) this.bHt, com.baidu.tieba.t.cp_bg_line_e);
        ax.b(this.bHt, com.baidu.tieba.t.cp_cont_b, 1);
        ax.i(this.bHu, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(this.bHv, com.baidu.tieba.t.cp_bg_line_b);
    }
}
