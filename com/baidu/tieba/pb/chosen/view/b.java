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
/* loaded from: classes10.dex */
public class b {
    private TextView gnb;
    private View gqk;
    private c.a jDP;
    private HeadImageView jEg;
    private TbRichTextView jEh;
    private ViewStub jEi;
    private ImageView jEj;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.jEi = viewStub;
        this.jDP = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.jEi.inflate();
            this.jEg = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.gnb = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.jEh = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.jEj = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gqk = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.jEh.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void qX(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gnb, R.color.cp_cont_f, 1);
        am.setImageResource(this.jEj, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.gqk, R.color.cp_bg_line_c);
        if (this.jEh != null) {
            this.jEh.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            qX(false);
            return false;
        }
        initView();
        qX(true);
        this.gnb.setText(user.name_show);
        this.jEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.jDP != null) {
                    b.this.jDP.Ja(String.valueOf(post.id));
                }
            }
        });
        this.jEg.startLoad(user.portrait, 12, false);
        this.jEh.setVisibility(0);
        this.jEh.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
