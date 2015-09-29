package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private TextView aHN;
    private d.a ceS;
    private HeadImageView cfj;
    private TbRichTextView cfk;
    private ViewStub cfl;
    private ImageView cfm;
    private View line;
    private View rootView;

    public b(ViewStub viewStub, d.a aVar) {
        this.cfl = viewStub;
        this.ceS = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.cfl.inflate();
            this.cfj = (HeadImageView) this.rootView.findViewById(i.f.chosen_pb_comment_head);
            this.aHN = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_name);
            this.cfk = (TbRichTextView) this.rootView.findViewById(i.f.chosen_pb_comment_content);
            this.cfm = (ImageView) this.rootView.findViewById(i.f.chosen_pb_comment_reply);
            this.line = this.rootView.findViewById(i.f.chosen_pb_comment_line);
            this.cfk.setTextSize(TbConfig.getContentSize());
            tc();
        }
    }

    public void ek(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void tc() {
        am.b(this.aHN, i.c.cp_cont_f, 1);
        am.c(this.cfm, i.e.btn_comment_list);
        am.j(this.line, i.c.cp_bg_line_b);
        if (this.cfk != null) {
            this.cfk.setTextColor(am.getColor(i.c.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ek(false);
            return false;
        }
        initView();
        ek(true);
        this.aHN.setText(user.name_show);
        this.cfm.setOnClickListener(new c(this, post));
        this.cfj.d(user.portrait, 12, false);
        this.cfk.setVisibility(0);
        this.cfk.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
