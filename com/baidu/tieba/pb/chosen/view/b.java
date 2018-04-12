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
    private TextView bGp;
    private View dLN;
    private c.a faK;
    private HeadImageView fbb;
    private TbRichTextView fbc;
    private ViewStub fbd;
    private ImageView fbe;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fbd = viewStub;
        this.faK = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fbd.inflate();
            this.fbb = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.bGp = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.fbc = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.fbe = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.dLN = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.fbc.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jk(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ak.c(this.bGp, d.C0126d.cp_cont_f, 1);
        ak.c(this.fbe, d.f.btn_comment_list);
        ak.j(this.dLN, d.C0126d.cp_bg_line_b);
        if (this.fbc != null) {
            this.fbc.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jk(false);
            return false;
        }
        initView();
        jk(true);
        this.bGp.setText(user.name_show);
        this.fbe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (post != null && post.id != null && b.this.faK != null) {
                    b.this.faK.qm(String.valueOf(post.id));
                }
            }
        });
        this.fbb.startLoad(user.portrait, 12, false);
        this.fbc.setVisibility(0);
        this.fbc.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
