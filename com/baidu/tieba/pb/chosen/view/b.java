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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView bPN;
    private View dYc;
    private HeadImageView fnA;
    private TbRichTextView fnB;
    private ViewStub fnC;
    private ImageView fnD;
    private c.a fnj;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fnC = viewStub;
        this.fnj = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fnC.inflate();
            this.fnA = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.bPN = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.fnB = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.fnD = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.dYc = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.fnB.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jr(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.c(this.bPN, d.C0141d.cp_cont_f, 1);
        al.c(this.fnD, d.f.btn_comment_list);
        al.j(this.dYc, d.C0141d.cp_bg_line_b);
        if (this.fnB != null) {
            this.fnB.setTextColor(al.getColor(d.C0141d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jr(false);
            return false;
        }
        initView();
        jr(true);
        this.bPN.setText(user.name_show);
        this.fnD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fnj != null) {
                    b.this.fnj.rd(String.valueOf(post.id));
                }
            }
        });
        this.fnA.startLoad(user.portrait, 12, false);
        this.fnB.setVisibility(0);
        this.fnB.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
