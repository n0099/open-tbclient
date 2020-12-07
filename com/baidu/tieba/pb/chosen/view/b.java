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
    private TextView hLB;
    private View hOR;
    private HeadImageView lzN;
    private TbRichTextView lzO;
    private ViewStub lzP;
    private ImageView lzQ;
    private c.a lzw;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lzP = viewStub;
        this.lzw = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lzP.inflate();
            this.lzN = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hLB = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lzO = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lzQ = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hOR = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lzO.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void ut(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hLB, R.color.CAM_X0106, 1);
        ap.setImageResource(this.lzQ, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hOR, R.color.CAM_X0204);
        if (this.lzO != null) {
            this.lzO.setTextColor(ap.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            ut(false);
            return false;
        }
        initView();
        ut(true);
        this.hLB.setText(user.name_show);
        this.lzQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lzw != null) {
                    b.this.lzw.PS(String.valueOf(post.id));
                }
            }
        });
        this.lzN.startLoad(user.portrait, 12, false);
        this.lzO.setVisibility(0);
        this.lzO.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
