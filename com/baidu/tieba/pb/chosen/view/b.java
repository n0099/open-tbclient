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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class b {
    private View eil;
    private TextView epd;
    private HeadImageView hAj;
    private TbRichTextView hAk;
    private ViewStub hAl;
    private ImageView hAm;
    private c.a hzS;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hAl = viewStub;
        this.hzS = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hAl.inflate();
            this.hAj = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.epd = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hAk = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hAm = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.eil = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hAk.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void nK(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.f(this.epd, R.color.cp_cont_f, 1);
        al.c(this.hAm, (int) R.drawable.btn_comment_list);
        al.l(this.eil, R.color.cp_bg_line_b);
        if (this.hAk != null) {
            this.hAk.setTextColor(al.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            nK(false);
            return false;
        }
        initView();
        nK(true);
        this.epd.setText(user.name_show);
        this.hAm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hzS != null) {
                    b.this.hzS.AS(String.valueOf(post.id));
                }
            }
        });
        this.hAj.startLoad(user.portrait, 12, false);
        this.hAk.setVisibility(0);
        this.hAk.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
