package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class t extends a {
    TextView JN;
    View UM;
    TripleTbImageView bEk;
    View bEl;
    LinearLayout bEm;
    LiveBroadcastCard bEn;
    TextView bmt;
    View mContentView;

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
    public t(View view) {
        super(view);
        this.mContentView = view.findViewById(com.baidu.tieba.v.item_content);
        this.JN = (TextView) view.findViewById(com.baidu.tieba.v.title);
        this.bmt = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.bEk = (TripleTbImageView) view.findViewById(com.baidu.tieba.v.images);
        this.bEl = view.findViewById(com.baidu.tieba.v.post_line);
        this.bEm = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_post_item_live_card);
        this.bEn = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.person_post_item_feed_item_card);
        this.UM = view.findViewById(com.baidu.tieba.v.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void bM(int i) {
        super.bM(i);
        aw.b(this.JN, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bmt, com.baidu.tieba.s.cp_cont_f, 1);
        aw.h(this.bEl, com.baidu.tieba.s.cp_bg_line_b);
    }
}
