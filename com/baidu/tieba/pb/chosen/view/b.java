package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView bYF;
    private View enf;
    private c.a fyS;
    private HeadImageView fzj;
    private TbRichTextView fzk;
    private ViewStub fzl;
    private ImageView fzm;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fzl = viewStub;
        this.fyS = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fzl.inflate();
            this.fzj = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.bYF = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fzk = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fzm = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.enf = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fzk.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jN(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.bYF, e.d.cp_cont_f, 1);
        al.c(this.fzm, e.f.btn_comment_list);
        al.j(this.enf, e.d.cp_bg_line_b);
        if (this.fzk != null) {
            this.fzk.setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jN(false);
            return false;
        }
        initView();
        jN(true);
        this.bYF.setText(user.name_show);
        this.fzm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fyS != null) {
                    b.this.fyS.rE(String.valueOf(post.id));
                }
            }
        });
        this.fzj.startLoad(user.portrait, 12, false);
        this.fzk.setVisibility(0);
        this.fzk.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
