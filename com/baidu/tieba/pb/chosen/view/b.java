package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView bGo;
    private View dLK;
    private c.a faH;
    private HeadImageView faY;
    private TbRichTextView faZ;
    private ViewStub fba;
    private ImageView fbb;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.fba = viewStub;
        this.faH = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.fba.inflate();
            this.faY = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.bGo = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.faZ = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.fbb = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.dLK = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.faZ.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jk(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ak.c(this.bGo, d.C0126d.cp_cont_f, 1);
        ak.c(this.fbb, d.f.btn_comment_list);
        ak.j(this.dLK, d.C0126d.cp_bg_line_b);
        if (this.faZ != null) {
            this.faZ.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jk(false);
            return false;
        }
        initView();
        jk(true);
        this.bGo.setText(user.name_show);
        this.fbb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (post != null && post.id != null && b.this.faH != null) {
                    b.this.faH.qm(String.valueOf(post.id));
                }
            }
        });
        this.faY.startLoad(user.portrait, 12, false);
        this.faZ.setVisibility(0);
        this.faZ.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
