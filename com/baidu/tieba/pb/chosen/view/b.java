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
/* loaded from: classes5.dex */
public class b {
    private View dXM;
    private TextView eeB;
    private c.a hiA;
    private HeadImageView hiR;
    private TbRichTextView hiS;
    private ViewStub hiT;
    private ImageView hiU;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hiT = viewStub;
        this.hiA = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hiT.inflate();
            this.hiR = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.eeB = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.hiS = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.hiU = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.dXM = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.hiS.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void mV(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.d(this.eeB, d.C0277d.cp_cont_f, 1);
        al.c(this.hiU, d.f.btn_comment_list);
        al.l(this.dXM, d.C0277d.cp_bg_line_b);
        if (this.hiS != null) {
            this.hiS.setTextColor(al.getColor(d.C0277d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            mV(false);
            return false;
        }
        initView();
        mV(true);
        this.eeB.setText(user.name_show);
        this.hiU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hiA != null) {
                    b.this.hiA.zC(String.valueOf(post.id));
                }
            }
        });
        this.hiR.startLoad(user.portrait, 12, false);
        this.hiS.setVisibility(0);
        this.hiS.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
