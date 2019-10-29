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
    private TextView ewr;
    private View ezl;
    private c.a hHD;
    private HeadImageView hHU;
    private TbRichTextView hHV;
    private ViewStub hHW;
    private ImageView hHX;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hHW = viewStub;
        this.hHD = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hHW.inflate();
            this.hHU = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.ewr = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hHV = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hHX = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.ezl = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hHV.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void nN(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.ewr, R.color.cp_cont_f, 1);
        am.setImageResource(this.hHX, R.drawable.btn_comment_list);
        am.setBackgroundColor(this.ezl, R.color.cp_bg_line_c);
        if (this.hHV != null) {
            this.hHV.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            nN(false);
            return false;
        }
        initView();
        nN(true);
        this.ewr.setText(user.name_show);
        this.hHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hHD != null) {
                    b.this.hHD.Az(String.valueOf(post.id));
                }
            }
        });
        this.hHU.startLoad(user.portrait, 12, false);
        this.hHV.setVisibility(0);
        this.hHV.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
