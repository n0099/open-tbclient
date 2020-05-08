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
    private TextView fXY;
    private View gbf;
    private HeadImageView jmE;
    private TbRichTextView jmF;
    private ViewStub jmG;
    private ImageView jmH;
    private c.a jmm;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.jmG = viewStub;
        this.jmm = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.jmG.inflate();
            this.jmE = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.fXY = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.jmF = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.jmH = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gbf = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.jmF.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void qA(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fXY, R.color.cp_cont_f, 1);
        am.setImageResource(this.jmH, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.gbf, R.color.cp_bg_line_c);
        if (this.jmF != null) {
            this.jmF.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            qA(false);
            return false;
        }
        initView();
        qA(true);
        this.fXY.setText(user.name_show);
        this.jmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.jmm != null) {
                    b.this.jmm.Hq(String.valueOf(post.id));
                }
            }
        });
        this.jmE.startLoad(user.portrait, 12, false);
        this.jmF.setVisibility(0);
        this.jmF.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
