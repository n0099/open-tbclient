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
    private TextView chf;
    private View euY;
    private HeadImageView fGM;
    private TbRichTextView fGN;
    private ViewStub fGO;
    private ImageView fGP;
    private c.a fGv;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fGO = viewStub;
        this.fGv = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fGO.inflate();
            this.fGM = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.chf = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fGN = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fGP = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.euY = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fGN.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void ke(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.chf, e.d.cp_cont_f, 1);
        al.c(this.fGP, e.f.btn_comment_list);
        al.j(this.euY, e.d.cp_bg_line_b);
        if (this.fGN != null) {
            this.fGN.setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ke(false);
            return false;
        }
        initView();
        ke(true);
        this.chf.setText(user.name_show);
        this.fGP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fGv != null) {
                    b.this.fGv.se(String.valueOf(post.id));
                }
            }
        });
        this.fGM.startLoad(user.portrait, 12, false);
        this.fGN.setVisibility(0);
        this.fGN.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
