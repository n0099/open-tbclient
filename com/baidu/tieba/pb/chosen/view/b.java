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
    private TextView fXT;
    private View gba;
    private HeadImageView jmA;
    private TbRichTextView jmB;
    private ViewStub jmC;
    private ImageView jmD;
    private c.a jmi;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.jmC = viewStub;
        this.jmi = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.jmC.inflate();
            this.jmA = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.fXT = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.jmB = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.jmD = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gba = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.jmB.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void qA(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fXT, R.color.cp_cont_f, 1);
        am.setImageResource(this.jmD, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.gba, R.color.cp_bg_line_c);
        if (this.jmB != null) {
            this.jmB.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            qA(false);
            return false;
        }
        initView();
        qA(true);
        this.fXT.setText(user.name_show);
        this.jmD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.jmi != null) {
                    b.this.jmi.Hn(String.valueOf(post.id));
                }
            }
        });
        this.jmA.startLoad(user.portrait, 12, false);
        this.jmB.setVisibility(0);
        this.jmB.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
