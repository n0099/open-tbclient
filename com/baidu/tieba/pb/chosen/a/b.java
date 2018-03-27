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
    private TextView cql;
    private View erb;
    private c.a fGf;
    private HeadImageView fGw;
    private TbRichTextView fGx;
    private ViewStub fGy;
    private ImageView fGz;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fGy = viewStub;
        this.fGf = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fGy.inflate();
            this.fGw = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.cql = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.fGx = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.fGz = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.erb = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.fGx.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jO(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.cql, d.C0141d.cp_cont_f, 1);
        aj.c(this.fGz, d.f.btn_comment_list);
        aj.t(this.erb, d.C0141d.cp_bg_line_b);
        if (this.fGx != null) {
            this.fGx.setTextColor(aj.getColor(d.C0141d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jO(false);
            return false;
        }
        initView();
        jO(true);
        this.cql.setText(user.name_show);
        this.fGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fGf != null) {
                    b.this.fGf.qg(String.valueOf(post.id));
                }
            }
        });
        this.fGw.startLoad(user.portrait, 12, false);
        this.fGx.setVisibility(0);
        this.fGx.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
