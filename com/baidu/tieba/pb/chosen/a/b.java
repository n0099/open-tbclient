package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private TextView aII;
    private d.a bYQ;
    private HeadImageView bZk;
    private TbRichTextView bZl;
    private ViewStub bZm;
    private ImageView bZn;
    private View line;
    private View rootView;

    public b(ViewStub viewStub, d.a aVar) {
        this.bZm = viewStub;
        this.bYQ = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.bZm.inflate();
            this.bZk = (HeadImageView) this.rootView.findViewById(i.f.chosen_pb_comment_head);
            this.aII = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_name);
            this.bZl = (TbRichTextView) this.rootView.findViewById(i.f.chosen_pb_comment_content);
            this.bZn = (ImageView) this.rootView.findViewById(i.f.chosen_pb_comment_reply);
            this.line = this.rootView.findViewById(i.f.chosen_pb_comment_line);
            this.bZl.setTextSize(TbConfig.getContentSize());
            ta();
        }
    }

    public void dY(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void ta() {
        al.b(this.aII, i.c.cp_cont_f, 1);
        al.c(this.bZn, i.e.btn_comment_list);
        al.j(this.line, i.c.cp_bg_line_b);
        if (this.bZl != null) {
            this.bZl.setTextColor(al.getColor(i.c.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            dY(false);
            return false;
        }
        initView();
        dY(true);
        this.aII.setText(user.name_show);
        this.bZn.setOnClickListener(new c(this, post));
        this.bZk.d(user.portrait, 12, false);
        this.bZl.setVisibility(0);
        this.bZl.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
