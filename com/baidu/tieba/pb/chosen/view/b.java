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
    private View dXL;
    private TextView eeA;
    private HeadImageView hiQ;
    private TbRichTextView hiR;
    private ViewStub hiS;
    private ImageView hiT;
    private c.a hiz;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hiS = viewStub;
        this.hiz = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hiS.inflate();
            this.hiQ = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.eeA = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.hiR = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.hiT = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.dXL = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.hiR.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void mV(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.d(this.eeA, d.C0277d.cp_cont_f, 1);
        al.c(this.hiT, d.f.btn_comment_list);
        al.l(this.dXL, d.C0277d.cp_bg_line_b);
        if (this.hiR != null) {
            this.hiR.setTextColor(al.getColor(d.C0277d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            mV(false);
            return false;
        }
        initView();
        mV(true);
        this.eeA.setText(user.name_show);
        this.hiT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hiz != null) {
                    b.this.hiz.zC(String.valueOf(post.id));
                }
            }
        });
        this.hiQ.startLoad(user.portrait, 12, false);
        this.hiR.setVisibility(0);
        this.hiR.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
