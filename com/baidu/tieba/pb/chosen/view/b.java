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
    private View euX;
    private HeadImageView fGL;
    private TbRichTextView fGM;
    private ViewStub fGN;
    private ImageView fGO;
    private c.a fGu;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fGN = viewStub;
        this.fGu = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fGN.inflate();
            this.fGL = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.chf = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fGM = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fGO = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.euX = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fGM.setTextSize(TbConfig.getContentSize());
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
        al.c(this.fGO, e.f.btn_comment_list);
        al.j(this.euX, e.d.cp_bg_line_b);
        if (this.fGM != null) {
            this.fGM.setTextColor(al.getColor(e.d.cp_cont_b));
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
        this.fGO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fGu != null) {
                    b.this.fGu.se(String.valueOf(post.id));
                }
            }
        });
        this.fGL.startLoad(user.portrait, 12, false);
        this.fGM.setVisibility(0);
        this.fGM.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
