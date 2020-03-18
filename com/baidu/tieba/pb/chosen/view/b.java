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
/* loaded from: classes10.dex */
public class b {
    private TextView ftz;
    private View fwA;
    private c.a iCd;
    private HeadImageView iCu;
    private TbRichTextView iCv;
    private ViewStub iCw;
    private ImageView iCx;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.iCw = viewStub;
        this.iCd = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.iCw.inflate();
            this.iCu = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.ftz = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.iCv = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.iCx = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.fwA = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.iCv.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void pw(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.ftz, R.color.cp_cont_f, 1);
        am.setImageResource(this.iCx, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.fwA, R.color.cp_bg_line_c);
        if (this.iCv != null) {
            this.iCv.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            pw(false);
            return false;
        }
        initView();
        pw(true);
        this.ftz.setText(user.name_show);
        this.iCx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.iCd != null) {
                    b.this.iCd.FF(String.valueOf(post.id));
                }
            }
        });
        this.iCu.startLoad(user.portrait, 12, false);
        this.iCv.setVisibility(0);
        this.iCv.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
