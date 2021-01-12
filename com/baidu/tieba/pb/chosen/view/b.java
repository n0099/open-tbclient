package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.view.c;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes7.dex */
public class b {
    private TextView hTx;
    private View hWH;
    private HeadImageView lAp;
    private TbRichTextView lAq;
    private ViewStub lAr;
    private ImageView lAs;
    private c.a lzY;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lAr = viewStub;
        this.lzY = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lAr.inflate();
            this.lAp = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hTx = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lAq = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lAs = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hWH = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lAq.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void uq(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.hTx, R.color.CAM_X0106, 1);
        ao.setImageResource(this.lAs, R.drawable.btn_comment_list);
        ao.setBackgroundColor(this.hWH, R.color.CAM_X0204);
        if (this.lAq != null) {
            this.lAq.setTextColor(ao.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            uq(false);
            return false;
        }
        initView();
        uq(true);
        this.hTx.setText(user.name_show);
        this.lAs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lzY != null) {
                    b.this.lzY.Op(String.valueOf(post.id));
                }
            }
        });
        this.lAp.startLoad(user.portrait, 12, false);
        this.lAq.setVisibility(0);
        this.lAq.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
