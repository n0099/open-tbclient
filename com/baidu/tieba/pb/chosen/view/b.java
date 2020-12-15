package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes23.dex */
public class b {
    private TextView hLD;
    private View hOT;
    private HeadImageView lzP;
    private TbRichTextView lzQ;
    private ViewStub lzR;
    private ImageView lzS;
    private c.a lzy;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lzR = viewStub;
        this.lzy = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lzR.inflate();
            this.lzP = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hLD = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lzQ = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lzS = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hOT = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lzQ.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void ut(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hLD, R.color.CAM_X0106, 1);
        ap.setImageResource(this.lzS, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hOT, R.color.CAM_X0204);
        if (this.lzQ != null) {
            this.lzQ.setTextColor(ap.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ut(false);
            return false;
        }
        initView();
        ut(true);
        this.hLD.setText(user.name_show);
        this.lzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lzy != null) {
                    b.this.lzy.PS(String.valueOf(post.id));
                }
            }
        });
        this.lzP.startLoad(user.portrait, 12, false);
        this.lzQ.setVisibility(0);
        this.lzQ.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
