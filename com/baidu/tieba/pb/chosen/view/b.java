package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView bHL;
    private View dMQ;
    private c.a fbO;
    private HeadImageView fcf;
    private TbRichTextView fcg;
    private ViewStub fch;
    private ImageView fci;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fch = viewStub;
        this.fbO = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fch.inflate();
            this.fcf = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.bHL = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.fcg = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.fci = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.dMQ = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.fcg.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jl(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ak.c(this.bHL, d.C0126d.cp_cont_f, 1);
        ak.c(this.fci, d.f.btn_comment_list);
        ak.j(this.dMQ, d.C0126d.cp_bg_line_b);
        if (this.fcg != null) {
            this.fcg.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jl(false);
            return false;
        }
        initView();
        jl(true);
        this.bHL.setText(user.name_show);
        this.fci.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (post != null && post.id != null && b.this.fbO != null) {
                    b.this.fbO.qp(String.valueOf(post.id));
                }
            }
        });
        this.fcf.startLoad(user.portrait, 12, false);
        this.fcg.setVisibility(0);
        this.fcg.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
