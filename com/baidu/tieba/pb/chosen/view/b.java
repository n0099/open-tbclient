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
/* loaded from: classes22.dex */
public class b {
    private TextView gVA;
    private View gYK;
    private c.a kEa;
    private HeadImageView kEr;
    private TbRichTextView kEs;
    private ViewStub kEt;
    private ImageView kEu;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.kEt = viewStub;
        this.kEa = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.kEt.inflate();
            this.kEr = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.gVA = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.kEs = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.kEu = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gYK = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.kEs.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void sH(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.gVA, R.color.cp_cont_f, 1);
        ap.setImageResource(this.kEu, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.gYK, R.color.cp_bg_line_c);
        if (this.kEs != null) {
            this.kEs.setTextColor(ap.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            sH(false);
            return false;
        }
        initView();
        sH(true);
        this.gVA.setText(user.name_show);
        this.kEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.kEa != null) {
                    b.this.kEa.NK(String.valueOf(post.id));
                }
            }
        });
        this.kEr.startLoad(user.portrait, 12, false);
        this.kEs.setVisibility(0);
        this.kEs.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
