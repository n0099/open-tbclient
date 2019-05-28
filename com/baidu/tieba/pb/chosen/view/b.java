package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class b {
    private View eim;
    private TextView epe;
    private HeadImageView hAm;
    private TbRichTextView hAn;
    private ViewStub hAo;
    private ImageView hAp;
    private c.a hzV;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hAo = viewStub;
        this.hzV = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hAo.inflate();
            this.hAm = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.epe = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hAn = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hAp = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.eim = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hAn.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void nK(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.f(this.epe, R.color.cp_cont_f, 1);
        al.c(this.hAp, (int) R.drawable.btn_comment_list);
        al.l(this.eim, R.color.cp_bg_line_b);
        if (this.hAn != null) {
            this.hAn.setTextColor(al.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            nK(false);
            return false;
        }
        initView();
        nK(true);
        this.epe.setText(user.name_show);
        this.hAp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hzV != null) {
                    b.this.hzV.AS(String.valueOf(post.id));
                }
            }
        });
        this.hAm.startLoad(user.portrait, 12, false);
        this.hAn.setVisibility(0);
        this.hAn.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
