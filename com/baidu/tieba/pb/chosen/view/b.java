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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class b {
    private View enk;
    private TextView euj;
    private c.a hHc;
    private HeadImageView hHt;
    private TbRichTextView hHu;
    private ViewStub hHv;
    private ImageView hHw;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hHv = viewStub;
        this.hHc = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hHv.inflate();
            this.hHt = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.euj = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hHu = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hHw = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.enk = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hHu.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void nZ(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.f(this.euj, R.color.cp_cont_f, 1);
        am.c(this.hHw, (int) R.drawable.btn_comment_list);
        am.l(this.enk, R.color.cp_bg_line_b);
        if (this.hHu != null) {
            this.hHu.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            nZ(false);
            return false;
        }
        initView();
        nZ(true);
        this.euj.setText(user.name_show);
        this.hHw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hHc != null) {
                    b.this.hHc.BH(String.valueOf(post.id));
                }
            }
        });
        this.hHt.startLoad(user.portrait, 12, false);
        this.hHu.setVisibility(0);
        this.hHu.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
