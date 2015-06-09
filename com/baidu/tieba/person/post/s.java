package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class s extends a {
    View So;
    TextView bFP;
    TripleTbImageView bUB;
    View bUC;
    LinearLayout bUD;
    LiveBroadcastCard bUE;
    View mContentView;
    TextView mTitle;

    @Override // com.baidu.tieba.person.post.a
    public /* bridge */ /* synthetic */ void a(PersonPostModel.PostList postList, boolean z, String str) {
        super.a(postList, z, str);
    }

    @Override // com.baidu.tieba.person.post.a
    public /* bridge */ /* synthetic */ void a(b bVar) {
        super.a(bVar);
    }

    @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(View view, TbPageContext<?> tbPageContext) {
        super(view, tbPageContext);
        this.mContentView = view.findViewById(com.baidu.tieba.q.item_content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.title);
        this.bFP = (TextView) view.findViewById(com.baidu.tieba.q.content);
        this.bUB = (TripleTbImageView) view.findViewById(com.baidu.tieba.q.images);
        this.bUC = view.findViewById(com.baidu.tieba.q.post_line);
        this.bUD = (LinearLayout) view.findViewById(com.baidu.tieba.q.person_post_item_live_card);
        this.bUE = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.q.person_post_item_feed_item_card);
        this.So = view.findViewById(com.baidu.tieba.q.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void cy(int i) {
        super.cy(i);
        ay.b(this.mTitle, com.baidu.tieba.n.cp_cont_b, 1);
        ay.b(this.bFP, com.baidu.tieba.n.cp_cont_f, 1);
        ay.i(this.bUC, com.baidu.tieba.n.cp_bg_line_b);
    }
}
