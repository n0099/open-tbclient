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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private TextView bRW;
    private View ebW;
    private c.a frc;
    private HeadImageView fru;
    private TbRichTextView frv;
    private ViewStub frw;
    private ImageView frx;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.frw = viewStub;
        this.frc = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.frw.inflate();
            this.fru = (HeadImageView) this.rootView.findViewById(d.g.chosen_pb_comment_head);
            this.bRW = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_name);
            this.frv = (TbRichTextView) this.rootView.findViewById(d.g.chosen_pb_comment_content);
            this.frx = (ImageView) this.rootView.findViewById(d.g.chosen_pb_comment_reply);
            this.ebW = this.rootView.findViewById(d.g.chosen_pb_comment_line);
            this.frv.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void jA(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.c(this.bRW, d.C0142d.cp_cont_f, 1);
        am.c(this.frx, d.f.btn_comment_list);
        am.j(this.ebW, d.C0142d.cp_bg_line_b);
        if (this.frv != null) {
            this.frv.setTextColor(am.getColor(d.C0142d.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            jA(false);
            return false;
        }
        initView();
        jA(true);
        this.bRW.setText(user.name_show);
        this.frx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.frc != null) {
                    b.this.frc.rc(String.valueOf(post.id));
                }
            }
        });
        this.fru.startLoad(user.portrait, 12, false);
        this.frv.setVisibility(0);
        this.frv.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
