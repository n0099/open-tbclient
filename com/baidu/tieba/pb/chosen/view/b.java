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
    private View cKP;
    private TextView cma;
    private HeadImageView fSQ;
    private TbRichTextView fSR;
    private ViewStub fSS;
    private ImageView fST;
    private c.a fSz;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fSS = viewStub;
        this.fSz = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fSS.inflate();
            this.fSQ = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.cma = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fSR = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fST = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.cKP = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fSR.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void ku(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.cma, e.d.cp_cont_f, 1);
        al.c(this.fST, e.f.btn_comment_list);
        al.j(this.cKP, e.d.cp_bg_line_b);
        if (this.fSR != null) {
            this.fSR.setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ku(false);
            return false;
        }
        initView();
        ku(true);
        this.cma.setText(user.name_show);
        this.fST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fSz != null) {
                    b.this.fSz.tb(String.valueOf(post.id));
                }
            }
        });
        this.fSQ.startLoad(user.portrait, 12, false);
        this.fSR.setVisibility(0);
        this.fSR.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
