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
    private TextView gRS;
    private View gVd;
    private c.a kvB;
    private HeadImageView kvS;
    private TbRichTextView kvT;
    private ViewStub kvU;
    private ImageView kvV;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.kvU = viewStub;
        this.kvB = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.kvU.inflate();
            this.kvS = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.gRS = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.kvT = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.kvV = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.gVd = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.kvT.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void sz(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.gRS, R.color.cp_cont_f, 1);
        ap.setImageResource(this.kvV, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.gVd, R.color.cp_bg_line_c);
        if (this.kvT != null) {
            this.kvT.setTextColor(ap.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            sz(false);
            return false;
        }
        initView();
        sz(true);
        this.gRS.setText(user.name_show);
        this.kvV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.kvB != null) {
                    b.this.kvB.Ni(String.valueOf(post.id));
                }
            }
        });
        this.kvS.startLoad(user.portrait, 12, false);
        this.kvT.setVisibility(0);
        this.kvT.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
