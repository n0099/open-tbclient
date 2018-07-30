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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView bSR;
    private View efM;
    private HeadImageView frG;
    private TbRichTextView frH;
    private ViewStub frI;
    private ImageView frJ;
    private c.a fro;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.frI = viewStub;
        this.fro = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.frI.inflate();
            this.frG = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.bSR = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.frH = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.frJ = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.efM = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.frH.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jm(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.c(this.bSR, d.C0140d.cp_cont_f, 1);
        am.c(this.frJ, d.f.btn_comment_list);
        am.j(this.efM, d.C0140d.cp_bg_line_b);
        if (this.frH != null) {
            this.frH.setTextColor(am.getColor(d.C0140d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jm(false);
            return false;
        }
        initView();
        jm(true);
        this.bSR.setText(user.name_show);
        this.frJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.fro != null) {
                    b.this.fro.qV(String.valueOf(post.id));
                }
            }
        });
        this.frG.startLoad(user.portrait, 12, false);
        this.frH.setVisibility(0);
        this.frH.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
