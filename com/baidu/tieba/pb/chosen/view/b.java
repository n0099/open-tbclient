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
    private TextView chp;
    private View ewr;
    private c.a fHT;
    private HeadImageView fIk;
    private TbRichTextView fIl;
    private ViewStub fIm;
    private ImageView fIn;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fIm = viewStub;
        this.fHT = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fIm.inflate();
            this.fIk = (HeadImageView) this.rootView.findViewById(e.g.chosen_pb_comment_head);
            this.chp = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_name);
            this.fIl = (TbRichTextView) this.rootView.findViewById(e.g.chosen_pb_comment_content);
            this.fIn = (ImageView) this.rootView.findViewById(e.g.chosen_pb_comment_reply);
            this.ewr = this.rootView.findViewById(e.g.chosen_pb_comment_line);
            this.fIl.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void ko(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.chp, e.d.cp_cont_f, 1);
        al.c(this.fIn, e.f.btn_comment_list);
        al.j(this.ewr, e.d.cp_bg_line_b);
        if (this.fIl != null) {
            this.fIl.setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ko(false);
            return false;
        }
        initView();
        ko(true);
        this.chp.setText(user.name_show);
        this.fIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fHT != null) {
                    b.this.fHT.sf(String.valueOf(post.id));
                }
            }
        });
        this.fIk.startLoad(user.portrait, 12, false);
        this.fIl.setVisibility(0);
        this.fIl.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
