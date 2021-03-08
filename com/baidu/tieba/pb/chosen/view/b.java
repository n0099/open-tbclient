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
/* loaded from: classes7.dex */
public class b {
    private TextView hZP;
    private View hjV;
    private c.a lLb;
    private HeadImageView lLs;
    private TbRichTextView lLt;
    private ViewStub lLu;
    private ImageView lLv;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.lLu = viewStub;
        this.lLb = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.lLu.inflate();
            this.lLs = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.hZP = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.lLt = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.lLv = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.hjV = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.lLt.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void uD(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hZP, R.color.CAM_X0106, 1);
        ap.setImageResource(this.lLv, R.drawable.btn_comment_list);
        ap.setBackgroundColor(this.hjV, R.color.CAM_X0204);
        if (this.lLt != null) {
            this.lLt.setTextColor(ap.getColor(R.color.CAM_X0105));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            uD(false);
            return false;
        }
        initView();
        uD(true);
        this.hZP.setText(user.name_show);
        this.lLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.lLb != null) {
                    b.this.lLb.Po(String.valueOf(post.id));
                }
            }
        });
        this.lLs.startLoad(user.portrait, 12, false);
        this.lLt.setVisibility(0);
        this.lLt.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
