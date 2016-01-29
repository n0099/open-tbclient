package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.chosen.a.d;
import com.baidu.tieba.t;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private View aHm;
    private TextView aMu;
    private View azA;
    private HeadImageView cIJ;
    private TbRichTextView cIK;
    private ViewStub cIL;
    private ImageView cIM;
    private d.a cIs;

    public b(ViewStub viewStub, d.a aVar) {
        this.cIL = viewStub;
        this.cIs = aVar;
    }

    private void initView() {
        if (this.azA == null) {
            this.azA = this.cIL.inflate();
            this.cIJ = (HeadImageView) this.azA.findViewById(t.g.chosen_pb_comment_head);
            this.aMu = (TextView) this.azA.findViewById(t.g.chosen_pb_comment_name);
            this.cIK = (TbRichTextView) this.azA.findViewById(t.g.chosen_pb_comment_content);
            this.cIM = (ImageView) this.azA.findViewById(t.g.chosen_pb_comment_reply);
            this.aHm = this.azA.findViewById(t.g.chosen_pb_comment_line);
            this.cIK.setTextSize(TbConfig.getContentSize());
            uv();
        }
    }

    public void fb(boolean z) {
        if (this.azA != null) {
            this.azA.setVisibility(z ? 0 : 8);
        }
    }

    public void uv() {
        ar.b(this.aMu, t.d.cp_cont_f, 1);
        ar.c(this.cIM, t.f.btn_comment_list);
        ar.l(this.aHm, t.d.cp_bg_line_b);
        if (this.cIK != null) {
            this.cIK.setTextColor(ar.getColor(t.d.cp_cont_b));
        }
    }

    public boolean a(Context context, Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            fb(false);
            return false;
        }
        initView();
        fb(true);
        this.aMu.setText(user.name_show);
        this.cIM.setOnClickListener(new c(this, post));
        this.cIJ.d(user.portrait, 12, false);
        this.cIK.setVisibility(0);
        this.cIK.setText(TbRichTextView.b(context, post.content, false));
        return true;
    }
}
