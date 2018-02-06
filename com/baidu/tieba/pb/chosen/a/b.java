package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.a.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView cqu;
    private View eqX;
    private c.a fGa;
    private HeadImageView fGr;
    private TbRichTextView fGs;
    private ViewStub fGt;
    private ImageView fGu;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fGt = viewStub;
        this.fGa = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fGt.inflate();
            this.fGr = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.cqu = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.fGs = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.fGu = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.eqX = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.fGs.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jJ(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.cqu, d.C0140d.cp_cont_f, 1);
        aj.c(this.fGu, d.f.btn_comment_list);
        aj.t(this.eqX, d.C0140d.cp_bg_line_b);
        if (this.fGs != null) {
            this.fGs.setTextColor(aj.getColor(d.C0140d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jJ(false);
            return false;
        }
        initView();
        jJ(true);
        this.cqu.setText(user.name_show);
        this.fGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fGa != null) {
                    b.this.fGa.qg(String.valueOf(post.id));
                }
            }
        });
        this.fGr.startLoad(user.portrait, 12, false);
        this.fGs.setVisibility(0);
        this.fGs.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
