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
    private TextView aGS;
    private d.a cfE;
    private HeadImageView cfV;
    private TbRichTextView cfW;
    private ViewStub cfX;
    private ImageView cfY;
    private View line;
    private View rootView;

    public b(ViewStub viewStub, d.a aVar) {
        this.cfX = viewStub;
        this.cfE = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.cfX.inflate();
            this.cfV = (HeadImageView) this.rootView.findViewById(i.f.chosen_pb_comment_head);
            this.aGS = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_name);
            this.cfW = (TbRichTextView) this.rootView.findViewById(i.f.chosen_pb_comment_content);
            this.cfY = (ImageView) this.rootView.findViewById(i.f.chosen_pb_comment_reply);
            this.line = this.rootView.findViewById(i.f.chosen_pb_comment_line);
            this.cfW.setTextSize(TbConfig.getContentSize());
            tc();
        }
    }

    public void em(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void tc() {
        an.b(this.aGS, i.c.cp_cont_f, 1);
        an.c(this.cfY, i.e.btn_comment_list);
        an.j(this.line, i.c.cp_bg_line_b);
        if (this.cfW != null) {
            this.cfW.setTextColor(an.getColor(i.c.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            em(false);
            return false;
        }
        initView();
        em(true);
        this.aGS.setText(user.name_show);
        this.cfY.setOnClickListener(new c(this, post));
        this.cfV.d(user.portrait, 12, false);
        this.cfW.setVisibility(0);
        this.cfW.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
