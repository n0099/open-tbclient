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
    private TextView hBW;
    private View hFk;
    private c.a llW;
    private HeadImageView lmn;
    private TbRichTextView lmo;
    private ViewStub lmp;
    private ImageView lmq;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lmp = viewStub;
        this.llW = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lmp.inflate();
            this.lmn = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hBW = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lmo = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lmq = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hFk = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lmo.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void tR(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hBW, R.color.CAM_X0106, 1);
        ap.setImageResource(this.lmq, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hFk, R.color.CAM_X0204);
        if (this.lmo != null) {
            this.lmo.setTextColor(ap.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            tR(false);
            return false;
        }
        initView();
        tR(true);
        this.hBW.setText(user.name_show);
        this.lmq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.llW != null) {
                    b.this.llW.OK(String.valueOf(post.id));
                }
            }
        });
        this.lmn.startLoad(user.portrait, 12, false);
        this.lmo.setVisibility(0);
        this.lmo.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
