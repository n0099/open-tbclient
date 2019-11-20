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
    private TextView evA;
    private View eyu;
    private c.a hGM;
    private HeadImageView hHd;
    private TbRichTextView hHe;
    private ViewStub hHf;
    private ImageView hHg;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hHf = viewStub;
        this.hGM = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hHf.inflate();
            this.hHd = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.evA = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hHe = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hHg = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.eyu = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hHe.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void nN(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.evA, R.color.cp_cont_f, 1);
        am.setImageResource(this.hHg, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.eyu, R.color.cp_bg_line_c);
        if (this.hHe != null) {
            this.hHe.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            nN(false);
            return false;
        }
        initView();
        nN(true);
        this.evA.setText(user.name_show);
        this.hHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hGM != null) {
                    b.this.hGM.Az(String.valueOf(post.id));
                }
            }
        });
        this.hHd.startLoad(user.portrait, 12, false);
        this.hHe.setVisibility(0);
        this.hHe.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
