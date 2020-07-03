package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes10.dex */
public class b {
    private View gCZ;
    private TextView gzP;
    private HeadImageView jXQ;
    private TbRichTextView jXR;
    private ViewStub jXS;
    private ImageView jXT;
    private c.a jXz;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.jXS = viewStub;
        this.jXz = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.jXS.inflate();
            this.jXQ = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.gzP = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.jXR = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.jXT = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gCZ = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.jXR.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void rl(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.gzP, R.color.cp_cont_f, 1);
        an.setImageResource(this.jXT, R.drawable.btn_comment_list);
        an.setBackgroundColor(this.gCZ, R.color.cp_bg_line_c);
        if (this.jXR != null) {
            this.jXR.setTextColor(an.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            rl(false);
            return false;
        }
        initView();
        rl(true);
        this.gzP.setText(user.name_show);
        this.jXT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.jXz != null) {
                    b.this.jXz.JC(String.valueOf(post.id));
                }
            }
        });
        this.jXQ.startLoad(user.portrait, 12, false);
        this.jXR.setVisibility(0);
        this.jXR.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
