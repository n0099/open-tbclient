package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private TextView aHY;
    private d.a cfd;
    private HeadImageView cfu;
    private TbRichTextView cfv;
    private ViewStub cfw;
    private ImageView cfx;
    private View line;
    private View rootView;

    public b(ViewStub viewStub, d.a aVar) {
        this.cfw = viewStub;
        this.cfd = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.cfw.inflate();
            this.cfu = (HeadImageView) this.rootView.findViewById(i.f.chosen_pb_comment_head);
            this.aHY = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_name);
            this.cfv = (TbRichTextView) this.rootView.findViewById(i.f.chosen_pb_comment_content);
            this.cfx = (ImageView) this.rootView.findViewById(i.f.chosen_pb_comment_reply);
            this.line = this.rootView.findViewById(i.f.chosen_pb_comment_line);
            this.cfv.setTextSize(TbConfig.getContentSize());
            tc();
        }
    }

    public void ek(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void tc() {
        an.b(this.aHY, i.c.cp_cont_f, 1);
        an.c(this.cfx, i.e.btn_comment_list);
        an.j(this.line, i.c.cp_bg_line_b);
        if (this.cfv != null) {
            this.cfv.setTextColor(an.getColor(i.c.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ek(false);
            return false;
        }
        initView();
        ek(true);
        this.aHY.setText(user.name_show);
        this.cfx.setOnClickListener(new c(this, post));
        this.cfu.d(user.portrait, 12, false);
        this.cfv.setVisibility(0);
        this.cfv.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
