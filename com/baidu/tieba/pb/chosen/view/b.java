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
    private TextView hws;
    private View hzG;
    private c.a lfK;
    private HeadImageView lgb;
    private TbRichTextView lgc;
    private ViewStub lgd;
    private ImageView lge;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lgd = viewStub;
        this.lfK = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lgd.inflate();
            this.lgb = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hws = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lgc = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lge = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hzG = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lgc.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void tF(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hws, R.color.cp_cont_f, 1);
        ap.setImageResource(this.lge, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hzG, R.color.cp_bg_line_c);
        if (this.lgc != null) {
            this.lgc.setTextColor(ap.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            tF(false);
            return false;
        }
        initView();
        tF(true);
        this.hws.setText(user.name_show);
        this.lge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lfK != null) {
                    b.this.lfK.OX(String.valueOf(post.id));
                }
            }
        });
        this.lgb.startLoad(user.portrait, 12, false);
        this.lgc.setVisibility(0);
        this.lgc.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
