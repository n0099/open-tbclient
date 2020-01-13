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
/* loaded from: classes8.dex */
public class b {
    private TextView fqi;
    private View fte;
    private HeadImageView iyL;
    private TbRichTextView iyM;
    private ViewStub iyN;
    private ImageView iyO;
    private c.a iyu;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.iyN = viewStub;
        this.iyu = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.iyN.inflate();
            this.iyL = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.fqi = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.iyM = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.iyO = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.fte = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.iyM.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void pn(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fqi, R.color.cp_cont_f, 1);
        am.setImageResource(this.iyO, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.fte, R.color.cp_bg_line_c);
        if (this.iyM != null) {
            this.iyM.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            pn(false);
            return false;
        }
        initView();
        pn(true);
        this.fqi.setText(user.name_show);
        this.iyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.iyu != null) {
                    b.this.iyu.Fq(String.valueOf(post.id));
                }
            }
        });
        this.iyL.startLoad(user.portrait, 12, false);
        this.iyM.setVisibility(0);
        this.iyM.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
