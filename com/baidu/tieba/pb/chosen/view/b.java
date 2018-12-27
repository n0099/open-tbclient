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
    private View cKd;
    private TextView clo;
    private c.a fRB;
    private HeadImageView fRS;
    private TbRichTextView fRT;
    private ViewStub fRU;
    private ImageView fRV;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fRU = viewStub;
        this.fRB = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fRU.inflate();
            this.fRS = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.clo = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fRT = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fRV = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.cKd = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fRT.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void ku(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.clo, e.d.cp_cont_f, 1);
        al.c(this.fRV, e.f.btn_comment_list);
        al.j(this.cKd, e.d.cp_bg_line_b);
        if (this.fRT != null) {
            this.fRT.setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ku(false);
            return false;
        }
        initView();
        ku(true);
        this.clo.setText(user.name_show);
        this.fRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fRB != null) {
                    b.this.fRB.sL(String.valueOf(post.id));
                }
            }
        });
        this.fRS.startLoad(user.portrait, 12, false);
        this.fRT.setVisibility(0);
        this.fRT.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
