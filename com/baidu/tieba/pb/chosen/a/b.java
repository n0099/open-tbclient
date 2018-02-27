package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.a.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView cqi;
    private View eqL;
    private c.a fFP;
    private HeadImageView fGg;
    private TbRichTextView fGh;
    private ViewStub fGi;
    private ImageView fGj;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fGi = viewStub;
        this.fFP = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fGi.inflate();
            this.fGg = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.cqi = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.fGh = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.fGj = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.eqL = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.fGh.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jJ(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.cqi, d.C0141d.cp_cont_f, 1);
        aj.c(this.fGj, d.f.btn_comment_list);
        aj.t(this.eqL, d.C0141d.cp_bg_line_b);
        if (this.fGh != null) {
            this.fGh.setTextColor(aj.getColor(d.C0141d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jJ(false);
            return false;
        }
        initView();
        jJ(true);
        this.cqi.setText(user.name_show);
        this.fGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fFP != null) {
                    b.this.fFP.qg(String.valueOf(post.id));
                }
            }
        });
        this.fGg.startLoad(user.portrait, 12, false);
        this.fGh.setVisibility(0);
        this.fGh.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
