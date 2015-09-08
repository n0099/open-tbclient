package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private TextView aIV;
    private d.a bZK;
    private HeadImageView cae;
    private TbRichTextView caf;
    private ViewStub cag;
    private ImageView cah;
    private View line;
    private View rootView;

    public b(ViewStub viewStub, d.a aVar) {
        this.cag = viewStub;
        this.bZK = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.cag.inflate();
            this.cae = (HeadImageView) this.rootView.findViewById(i.f.chosen_pb_comment_head);
            this.aIV = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_name);
            this.caf = (TbRichTextView) this.rootView.findViewById(i.f.chosen_pb_comment_content);
            this.cah = (ImageView) this.rootView.findViewById(i.f.chosen_pb_comment_reply);
            this.line = this.rootView.findViewById(i.f.chosen_pb_comment_line);
            this.caf.setTextSize(TbConfig.getContentSize());
            tf();
        }
    }

    public void ef(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void tf() {
        al.b(this.aIV, i.c.cp_cont_f, 1);
        al.c(this.cah, i.e.btn_comment_list);
        al.i(this.line, i.c.cp_bg_line_b);
        if (this.caf != null) {
            this.caf.setTextColor(al.getColor(i.c.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ef(false);
            return false;
        }
        initView();
        ef(true);
        this.aIV.setText(user.name_show);
        this.cah.setOnClickListener(new c(this, post));
        this.cae.d(user.portrait, 12, false);
        this.caf.setVisibility(0);
        this.caf.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
