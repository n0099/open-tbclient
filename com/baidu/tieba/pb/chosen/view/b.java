package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes17.dex */
public class b {
    private TextView gFm;
    private View gIw;
    private c.a kgb;
    private HeadImageView kgs;
    private TbRichTextView kgt;
    private ViewStub kgu;
    private ImageView kgv;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.kgu = viewStub;
        this.kgb = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.kgu.inflate();
            this.kgs = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.gFm = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.kgt = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.kgv = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gIw = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.kgt.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void rQ(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.gFm, R.color.cp_cont_f, 1);
        ao.setImageResource(this.kgv, R.drawable.btn_comment_list);
        ao.setBackgroundColor(this.gIw, R.color.cp_bg_line_c);
        if (this.kgt != null) {
            this.kgt.setTextColor(ao.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            rQ(false);
            return false;
        }
        initView();
        rQ(true);
        this.gFm.setText(user.name_show);
        this.kgv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.kgb != null) {
                    b.this.kgb.Ko(String.valueOf(post.id));
                }
            }
        });
        this.kgs.startLoad(user.portrait, 12, false);
        this.kgt.setVisibility(0);
        this.kgt.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
