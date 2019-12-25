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
/* loaded from: classes7.dex */
public class b {
    private TextView fmZ;
    private View fpV;
    private c.a iuQ;
    private HeadImageView ivh;
    private TbRichTextView ivi;
    private ViewStub ivj;
    private ImageView ivk;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.ivj = viewStub;
        this.iuQ = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.ivj.inflate();
            this.ivh = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.fmZ = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.ivi = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.ivk = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.fpV = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.ivi.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void pb(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fmZ, R.color.cp_cont_f, 1);
        am.setImageResource(this.ivk, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.fpV, R.color.cp_bg_line_c);
        if (this.ivi != null) {
            this.ivi.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            pb(false);
            return false;
        }
        initView();
        pb(true);
        this.fmZ.setText(user.name_show);
        this.ivk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.iuQ != null) {
                    b.this.iuQ.Fg(String.valueOf(post.id));
                }
            }
        });
        this.ivh.startLoad(user.portrait, 12, false);
        this.ivi.setVisibility(0);
        this.ivi.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
