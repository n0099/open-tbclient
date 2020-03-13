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
    private TextView fsZ;
    private View fvU;
    private c.a iAD;
    private HeadImageView iAU;
    private TbRichTextView iAV;
    private ViewStub iAW;
    private ImageView iAX;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.iAW = viewStub;
        this.iAD = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.iAW.inflate();
            this.iAU = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.fsZ = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.iAV = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.iAX = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.fvU = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.iAV.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void pq(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fsZ, R.color.cp_cont_f, 1);
        am.setImageResource(this.iAX, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.fvU, R.color.cp_bg_line_c);
        if (this.iAV != null) {
            this.iAV.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            pq(false);
            return false;
        }
        initView();
        pq(true);
        this.fsZ.setText(user.name_show);
        this.iAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.iAD != null) {
                    b.this.iAD.FG(String.valueOf(post.id));
                }
            }
        });
        this.iAU.startLoad(user.portrait, 12, false);
        this.iAV.setVisibility(0);
        this.iAV.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
