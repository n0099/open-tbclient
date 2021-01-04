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
    private c.a lEE;
    private HeadImageView lEV;
    private TbRichTextView lEW;
    private ViewStub lEX;
    private ImageView lEY;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lEX = viewStub;
        this.lEE = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lEX.inflate();
            this.lEV = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hYe = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lEW = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lEY = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.ibo = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lEW.setTextSize(TbConfig.getContentSize());
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
        ao.setImageResource(this.lEY, R.drawable.btn_comment_list);
        ao.setBackgroundColor(this.ibo, R.color.CAM_X0204);
        if (this.lEW != null) {
            this.lEW.setTextColor(ao.getColor(R.color.CAM_X0105));
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
        this.lEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lEE != null) {
                    b.this.lEE.Py(String.valueOf(post.id));
                }
            }
        });
        this.lEV.startLoad(user.portrait, 12, false);
        this.lEW.setVisibility(0);
        this.lEW.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
