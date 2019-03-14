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
    private TextView dAX;
    private View dYo;
    private c.a hiM;
    private HeadImageView hjd;
    private TbRichTextView hje;
    private ViewStub hjf;
    private ImageView hjg;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hjf = viewStub;
        this.hiM = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hjf.inflate();
            this.hjd = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.dAX = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.hje = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.hjg = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.dYo = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.hje.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void mV(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.d(this.dAX, d.C0277d.cp_cont_f, 1);
        al.c(this.hjg, d.f.btn_comment_list);
        al.l(this.dYo, d.C0277d.cp_bg_line_b);
        if (this.hje != null) {
            this.hje.setTextColor(al.getColor(d.C0277d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            mV(false);
            return false;
        }
        initView();
        mV(true);
        this.dAX.setText(user.name_show);
        this.hjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hiM != null) {
                    b.this.hiM.zD(String.valueOf(post.id));
                }
            }
        });
        this.hjd.startLoad(user.portrait, 12, false);
        this.hje.setVisibility(0);
        this.hje.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
