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
    private TextView hXS;
    private View hhX;
    private c.a lIL;
    private HeadImageView lJc;
    private TbRichTextView lJd;
    private ViewStub lJe;
    private ImageView lJf;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lJe = viewStub;
        this.lIL = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lJe.inflate();
            this.lJc = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hXS = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lJd = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lJf = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hhX = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lJd.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void uD(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hXS, R.color.CAM_X0106, 1);
        ap.setImageResource(this.lJf, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hhX, R.color.CAM_X0204);
        if (this.lJd != null) {
            this.lJd.setTextColor(ap.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            uD(false);
            return false;
        }
        initView();
        uD(true);
        this.hXS.setText(user.name_show);
        this.lJf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lIL != null) {
                    b.this.lIL.Ph(String.valueOf(post.id));
                }
            }
        });
        this.lJc.startLoad(user.portrait, 12, false);
        this.lJd.setVisibility(0);
        this.lJd.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
