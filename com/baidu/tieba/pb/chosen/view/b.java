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
    private View cJd;
    private TextView clh;
    private c.a fOJ;
    private HeadImageView fPa;
    private TbRichTextView fPb;
    private ViewStub fPc;
    private ImageView fPd;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fPc = viewStub;
        this.fOJ = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fPc.inflate();
            this.fPa = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.clh = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fPb = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fPd = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.cJd = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fPb.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void kr(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.clh, e.d.cp_cont_f, 1);
        al.c(this.fPd, e.f.btn_comment_list);
        al.j(this.cJd, e.d.cp_bg_line_b);
        if (this.fPb != null) {
            this.fPb.setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            kr(false);
            return false;
        }
        initView();
        kr(true);
        this.clh.setText(user.name_show);
        this.fPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fOJ != null) {
                    b.this.fOJ.sI(String.valueOf(post.id));
                }
            }
        });
        this.fPa.startLoad(user.portrait, 12, false);
        this.fPb.setVisibility(0);
        this.fPb.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
