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
    private TextView fsM;
    private View fvH;
    private HeadImageView iAI;
    private TbRichTextView iAJ;
    private ViewStub iAK;
    private ImageView iAL;
    private c.a iAr;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.iAK = viewStub;
        this.iAr = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.iAK.inflate();
            this.iAI = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.fsM = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.iAJ = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.iAL = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.fvH = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.iAJ.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void pq(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fsM, R.color.cp_cont_f, 1);
        am.setImageResource(this.iAL, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.fvH, R.color.cp_bg_line_c);
        if (this.iAJ != null) {
            this.iAJ.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            pq(false);
            return false;
        }
        initView();
        pq(true);
        this.fsM.setText(user.name_show);
        this.iAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.iAr != null) {
                    b.this.iAr.FF(String.valueOf(post.id));
                }
            }
        });
        this.iAI.startLoad(user.portrait, 12, false);
        this.iAJ.setVisibility(0);
        this.iAJ.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
