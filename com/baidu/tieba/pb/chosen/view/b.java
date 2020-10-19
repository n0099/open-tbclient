package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes23.dex */
public class b {
    private TextView hkx;
    private View hnL;
    private HeadImageView kTC;
    private TbRichTextView kTD;
    private ViewStub kTE;
    private ImageView kTF;
    private c.a kTl;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.kTE = viewStub;
        this.kTl = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.kTE.inflate();
            this.kTC = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hkx = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.kTD = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.kTF = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hnL = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.kTD.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void to(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hkx, R.color.cp_cont_f, 1);
        ap.setImageResource(this.kTF, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hnL, R.color.cp_bg_line_c);
        if (this.kTD != null) {
            this.kTD.setTextColor(ap.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            to(false);
            return false;
        }
        initView();
        to(true);
        this.hkx.setText(user.name_show);
        this.kTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.kTl != null) {
                    b.this.kTl.Oz(String.valueOf(post.id));
                }
            }
        });
        this.kTC.startLoad(user.portrait, 12, false);
        this.kTD.setVisibility(0);
        this.kTD.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
