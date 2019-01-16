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
    private View cKO;
    private TextView clZ;
    private HeadImageView fSP;
    private TbRichTextView fSQ;
    private ViewStub fSR;
    private ImageView fSS;
    private c.a fSy;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fSR = viewStub;
        this.fSy = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fSR.inflate();
            this.fSP = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.clZ = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fSQ = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fSS = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.cKO = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fSQ.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void ku(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.clZ, e.d.cp_cont_f, 1);
        al.c(this.fSS, e.f.btn_comment_list);
        al.j(this.cKO, e.d.cp_bg_line_b);
        if (this.fSQ != null) {
            this.fSQ.setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ku(false);
            return false;
        }
        initView();
        ku(true);
        this.clZ.setText(user.name_show);
        this.fSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fSy != null) {
                    b.this.fSy.tb(String.valueOf(post.id));
                }
            }
        });
        this.fSP.startLoad(user.portrait, 12, false);
        this.fSQ.setVisibility(0);
        this.fSQ.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
