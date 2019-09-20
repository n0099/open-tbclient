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
    private View eoV;
    private TextView evT;
    private c.a hIY;
    private HeadImageView hJp;
    private TbRichTextView hJq;
    private ViewStub hJr;
    private ImageView hJs;
    private View rootView;

    public b(ViewStub viewStub, c.a aVar) {
        this.hJr = viewStub;
        this.hIY = aVar;
    }

    private void initView() {
        if (this.rootView == null) {
            this.rootView = this.hJr.inflate();
            this.hJp = (HeadImageView) this.rootView.findViewById(R.id.chosen_pb_comment_head);
            this.evT = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_name);
            this.hJq = (TbRichTextView) this.rootView.findViewById(R.id.chosen_pb_comment_content);
            this.hJs = (ImageView) this.rootView.findViewById(R.id.chosen_pb_comment_reply);
            this.eoV = this.rootView.findViewById(R.id.chosen_pb_comment_line);
            this.hJq.setTextSize(TbConfig.getContentSize());
            onChangeSkinType();
        }
    }

    public void od(boolean z) {
        if (this.rootView != null) {
            this.rootView.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType() {
        am.f(this.evT, R.color.cp_cont_f, 1);
        am.c(this.hJs, (int) R.drawable.btn_comment_list);
        am.l(this.eoV, R.color.cp_bg_line_c);
        if (this.hJq != null) {
            this.hJq.setTextColor(am.getColor(R.color.cp_cont_b));
        }
    }

    public boolean a(Context context, final Post post, User user) {
        if (post == null || user == null || post.content == null || post.content.isEmpty()) {
            od(false);
            return false;
        }
        initView();
        od(true);
        this.evT.setText(user.name_show);
        this.hJs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (post != null && post.id != null && b.this.hIY != null) {
                    b.this.hIY.Cg(String.valueOf(post.id));
                }
            }
        });
        this.hJp.startLoad(user.portrait, 12, false);
        this.hJq.setVisibility(0);
        this.hJq.setText(TbRichTextView.a(context, post.content, false));
        return true;
    }
}
