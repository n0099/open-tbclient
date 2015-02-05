package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends a {
    public ReplyLinearLayout bJd;
    public TextView bJe;
    private View bJf;
    private View bJg;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i(View view) {
        super(view, r0);
        TbPageContext tbPageContext;
        tbPageContext = f.Mx;
        this.bJd = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.w.content_container);
        this.bJe = (TextView) view.findViewById(com.baidu.tieba.w.original_post_title);
        this.bJf = view.findViewById(com.baidu.tieba.w.reply_top_line);
        this.bJg = view.findViewById(com.baidu.tieba.w.reply_bottom_line);
        this.bJe.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void cs(int i) {
        super.cs(i);
        bc.i((View) this.bJe, com.baidu.tieba.t.cp_bg_line_e);
        bc.b(this.bJe, com.baidu.tieba.t.cp_cont_b, 1);
        bc.i(this.bJf, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bJg, com.baidu.tieba.t.cp_bg_line_b);
    }
}
