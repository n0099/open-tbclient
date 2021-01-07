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
/* loaded from: classes8.dex */
public class b {
    private TextView hYe;
    private View ibo;
    private c.a lED;
    private HeadImageView lEU;
    private TbRichTextView lEV;
    private ViewStub lEW;
    private ImageView lEX;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lEW = viewStub;
        this.lED = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lEW.inflate();
            this.lEU = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hYe = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lEV = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lEX = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.ibo = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lEV.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void uu(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.hYe, R.color.CAM_X0106, 1);
        ao.setImageResource(this.lEX, R.drawable.btn_comment_list);
        ao.setBackgroundColor(this.ibo, R.color.CAM_X0204);
        if (this.lEV != null) {
            this.lEV.setTextColor(ao.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            uu(false);
            return false;
        }
        initView();
        uu(true);
        this.hYe.setText(user.name_show);
        this.lEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lED != null) {
                    b.this.lED.Px(String.valueOf(post.id));
                }
            }
        });
        this.lEU.startLoad(user.portrait, 12, false);
        this.lEV.setVisibility(0);
        this.lEV.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
