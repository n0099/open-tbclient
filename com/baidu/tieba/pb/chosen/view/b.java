package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView bSQ;
    private View efJ;
    private TbRichTextView frA;
    private ViewStub frB;
    private ImageView frC;
    private c.a frh;
    private HeadImageView frz;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.frB = viewStub;
        this.frh = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.frB.inflate();
            this.frz = (HeadImageView) this.rootView.findViewById(f.g.chosen_pb_comment_head);
            this.bSQ = (TextView) this.rootView.findViewById(f.g.chosen_pb_comment_name);
            this.frA = (TbRichTextView) this.rootView.findViewById(f.g.chosen_pb_comment_content);
            this.frC = (ImageView) this.rootView.findViewById(f.g.chosen_pb_comment_reply);
            this.efJ = this.rootView.findViewById(f.g.chosen_pb_comment_line);
            this.frA.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jm(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.c(this.bSQ, f.d.cp_cont_f, 1);
        am.c(this.frC, f.C0146f.btn_comment_list);
        am.j(this.efJ, f.d.cp_bg_line_b);
        if (this.frA != null) {
            this.frA.setTextColor(am.getColor(f.d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jm(false);
            return false;
        }
        initView();
        jm(true);
        this.bSQ.setText(user.name_show);
        this.frC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.frh != null) {
                    b.this.frh.qY(String.valueOf(post.id));
                }
            }
        });
        this.frz.startLoad(user.portrait, 12, false);
        this.frA.setVisibility(0);
        this.frA.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
