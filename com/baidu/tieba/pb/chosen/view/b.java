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
    private TextView hCp;
    private View hFD;
    private c.a llG;
    private HeadImageView llX;
    private TbRichTextView llY;
    private ViewStub llZ;
    private ImageView lma;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.llZ = viewStub;
        this.llG = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.llZ.inflate();
            this.llX = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hCp = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.llY = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lma = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hFD = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.llY.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void tO(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hCp, R.color.cp_cont_f, 1);
        ap.setImageResource(this.lma, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hFD, R.color.cp_bg_line_c);
        if (this.llY != null) {
            this.llY.setTextColor(ap.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            tO(false);
            return false;
        }
        initView();
        tO(true);
        this.hCp.setText(user.name_show);
        this.lma.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.llG != null) {
                    b.this.llG.Po(String.valueOf(post.id));
                }
            }
        });
        this.llX.startLoad(user.portrait, 12, false);
        this.llY.setVisibility(0);
        this.llY.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
