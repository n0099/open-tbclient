package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private TextView aLp;
    private d.a cBM;
    private HeadImageView cCe;
    private TbRichTextView cCf;
    private ViewStub cCg;
    private ImageView cCh;
    private View line;
    private View rootView;

    public b(ViewStub viewStub, d.a aVar) {
        this.cCg = viewStub;
        this.cBM = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.cCg.inflate();
            this.cCe = (HeadImageView) this.rootView.findViewById(n.g.chosen_pb_comment_head);
            this.aLp = (TextView) this.rootView.findViewById(n.g.chosen_pb_comment_name);
            this.cCf = (TbRichTextView) this.rootView.findViewById(n.g.chosen_pb_comment_content);
            this.cCh = (ImageView) this.rootView.findViewById(n.g.chosen_pb_comment_reply);
            this.line = this.rootView.findViewById(n.g.chosen_pb_comment_line);
            this.cCf.setTextSize(TbConfig.getContentSize());
            tr();
        }
    }

    public void eN(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void tr() {
        as.b(this.aLp, n.d.cp_cont_f, 1);
        as.c(this.cCh, n.f.btn_comment_list);
        as.j(this.line, n.d.cp_bg_line_b);
        if (this.cCf != null) {
            this.cCf.setTextColor(as.getColor(n.d.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            eN(false);
            return false;
        }
        initView();
        eN(true);
        this.aLp.setText(user.name_show);
        this.cCh.setOnClickListener(new c(this, post));
        this.cCe.d(user.portrait, 12, false);
        this.cCf.setVisibility(0);
        this.cCf.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
