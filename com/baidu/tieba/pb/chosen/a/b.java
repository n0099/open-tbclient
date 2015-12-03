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
    private TextView aJR;
    private ImageView cyA;
    private d.a cyf;
    private HeadImageView cyx;
    private TbRichTextView cyy;
    private ViewStub cyz;
    private View line;
    private View rootView;

    public b(ViewStub viewStub, d.a aVar) {
        this.cyz = viewStub;
        this.cyf = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.cyz.inflate();
            this.cyx = (HeadImageView) this.rootView.findViewById(n.f.chosen_pb_comment_head);
            this.aJR = (TextView) this.rootView.findViewById(n.f.chosen_pb_comment_name);
            this.cyy = (TbRichTextView) this.rootView.findViewById(n.f.chosen_pb_comment_content);
            this.cyA = (ImageView) this.rootView.findViewById(n.f.chosen_pb_comment_reply);
            this.line = this.rootView.findViewById(n.f.chosen_pb_comment_line);
            this.cyy.setTextSize(TbConfig.getContentSize());
            tH();
        }
    }

    public void eO(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void tH() {
        as.b(this.aJR, n.c.cp_cont_f, 1);
        as.c(this.cyA, n.e.btn_comment_list);
        as.j(this.line, n.c.cp_bg_line_b);
        if (this.cyy != null) {
            this.cyy.setTextColor(as.getColor(n.c.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            eO(false);
            return false;
        }
        initView();
        eO(true);
        this.aJR.setText(user.name_show);
        this.cyA.setOnClickListener(new c(this, post));
        this.cyx.d(user.portrait, 12, false);
        this.cyy.setVisibility(0);
        this.cyy.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
