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
    private TextView gmQ;
    private View gpZ;
    private c.a jCJ;
    private HeadImageView jDa;
    private TbRichTextView jDb;
    private ViewStub jDc;
    private ImageView jDd;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.jDc = viewStub;
        this.jCJ = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.jDc.inflate();
            this.jDa = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.gmQ = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.jDb = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.jDd = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gpZ = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.jDb.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void qX(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gmQ, R.color.cp_cont_f, 1);
        am.setImageResource(this.jDd, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.gpZ, R.color.cp_bg_line_c);
        if (this.jDb != null) {
            this.jDb.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            qX(false);
            return false;
        }
        initView();
        qX(true);
        this.gmQ.setText(user.name_show);
        this.jDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.jCJ != null) {
                    b.this.jCJ.IZ(String.valueOf(post.id));
                }
            }
        });
        this.jDa.startLoad(user.portrait, 12, false);
        this.jDb.setVisibility(0);
        this.jDb.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
