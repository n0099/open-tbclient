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
/* loaded from: classes17.dex */
public class b {
    private TextView gRO;
    private View gUZ;
    private HeadImageView kvL;
    private TbRichTextView kvM;
    private ViewStub kvN;
    private ImageView kvO;
    private c.a kvu;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.kvN = viewStub;
        this.kvu = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.kvN.inflate();
            this.kvL = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.gRO = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.kvM = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.kvO = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gUZ = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.kvM.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void sx(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.gRO, R.color.cp_cont_f, 1);
        ap.setImageResource(this.kvO, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.gUZ, R.color.cp_bg_line_c);
        if (this.kvM != null) {
            this.kvM.setTextColor(ap.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            sx(false);
            return false;
        }
        initView();
        sx(true);
        this.gRO.setText(user.name_show);
        this.kvO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.kvu != null) {
                    b.this.kvu.Nh(String.valueOf(post.id));
                }
            }
        });
        this.kvL.startLoad(user.portrait, 12, false);
        this.kvM.setVisibility(0);
        this.kvM.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
