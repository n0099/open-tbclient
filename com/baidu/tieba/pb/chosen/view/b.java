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
    private HeadImageView hAn;
    private TbRichTextView hAo;
    private ViewStub hAp;
    private ImageView hAq;
    private c.a hzW;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hAp = viewStub;
        this.hzW = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hAp.inflate();
            this.hAn = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.epe = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hAo = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hAq = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.eim = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hAo.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void nL(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        al.f(this.epe, R.color.cp_cont_f, 1);
        al.c(this.hAq, (int) R.drawable.btn_comment_list);
        al.l(this.eim, R.color.cp_bg_line_b);
        if (this.hAo != null) {
            this.hAo.setTextColor(al.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            nL(false);
            return false;
        }
        initView();
        nL(true);
        this.epe.setText(user.name_show);
        this.hAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hzW != null) {
                    b.this.hzW.AU(String.valueOf(post.id));
                }
            }
        });
        this.hAn.startLoad(user.portrait, 12, false);
        this.hAo.setVisibility(0);
        this.hAo.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
