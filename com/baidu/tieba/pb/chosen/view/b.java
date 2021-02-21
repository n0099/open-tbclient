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
/* loaded from: classes8.dex */
public class b {
    private TextView hYg;
    private View him;
    private c.a lIZ;
    private HeadImageView lJq;
    private TbRichTextView lJr;
    private ViewStub lJs;
    private ImageView lJt;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lJs = viewStub;
        this.lIZ = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lJs.inflate();
            this.lJq = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hYg = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lJr = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lJt = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.him = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lJr.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void uD(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hYg, R.color.CAM_X0106, 1);
        ap.setImageResource(this.lJt, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.him, R.color.CAM_X0204);
        if (this.lJr != null) {
            this.lJr.setTextColor(ap.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            uD(false);
            return false;
        }
        initView();
        uD(true);
        this.hYg.setText(user.name_show);
        this.lJt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lIZ != null) {
                    b.this.lIZ.Pi(String.valueOf(post.id));
                }
            }
        });
        this.lJq.startLoad(user.portrait, 12, false);
        this.lJr.setVisibility(0);
        this.lJr.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
