package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends a {
    private View bGM;
    private View bGN;
    public ReplyLinearLayout bRF;
    public TextView bRG;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(View view) {
        super(view, r0);
        TbPageContext tbPageContext;
        tbPageContext = g.XG;
        this.bRF = (ReplyLinearLayout) view.findViewById(com.baidu.tieba.v.content_container);
        this.bRG = (TextView) view.findViewById(com.baidu.tieba.v.original_post_title);
        this.bGM = view.findViewById(com.baidu.tieba.v.reply_top_line);
        this.bGN = view.findViewById(com.baidu.tieba.v.reply_bottom_line);
        this.bRG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.person.post.a
    public void ct(int i) {
        super.ct(i);
        ba.i((View) this.bRG, com.baidu.tieba.s.cp_bg_line_e);
        ba.b(this.bRG, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i(this.bGM, com.baidu.tieba.s.cp_bg_line_b);
        ba.i(this.bGN, com.baidu.tieba.s.cp_bg_line_b);
    }
}
