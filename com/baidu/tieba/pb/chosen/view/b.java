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
/* loaded from: classes5.dex */
public class b {
    private View enc;
    private TextView euc;
    private HeadImageView hGB;
    private TbRichTextView hGC;
    private ViewStub hGD;
    private ImageView hGE;
    private c.a hGk;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hGD = viewStub;
        this.hGk = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hGD.inflate();
            this.hGB = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.euc = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hGC = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hGE = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.enc = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hGC.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void nZ(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.f(this.euc, R.color.cp_cont_f, 1);
        am.c(this.hGE, (int) R.drawable.btn_comment_list);
        am.l(this.enc, R.color.cp_bg_line_b);
        if (this.hGC != null) {
            this.hGC.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            nZ(false);
            return false;
        }
        initView();
        nZ(true);
        this.euc.setText(user.name_show);
        this.hGE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hGk != null) {
                    b.this.hGk.BG(String.valueOf(post.id));
                }
            }
        });
        this.hGB.startLoad(user.portrait, 12, false);
        this.hGC.setVisibility(0);
        this.hGC.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
