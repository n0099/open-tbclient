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
    private TextView fsL;
    private View fvG;
    private HeadImageView iAG;
    private TbRichTextView iAH;
    private ViewStub iAI;
    private ImageView iAJ;
    private c.a iAp;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.iAI = viewStub;
        this.iAp = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.iAI.inflate();
            this.iAG = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.fsL = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.iAH = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.iAJ = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.fvG = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.iAH.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void pq(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fsL, R.color.cp_cont_f, 1);
        am.setImageResource(this.iAJ, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.fvG, R.color.cp_bg_line_c);
        if (this.iAH != null) {
            this.iAH.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            pq(false);
            return false;
        }
        initView();
        pq(true);
        this.fsL.setText(user.name_show);
        this.iAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.iAp != null) {
                    b.this.iAp.FF(String.valueOf(post.id));
                }
            }
        });
        this.iAG.startLoad(user.portrait, 12, false);
        this.iAH.setVisibility(0);
        this.iAH.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
