package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class r extends a {
    View g;
    TextView h;
    TextView i;
    TripleTbImageView j;
    View k;
    LinearLayout l;
    LiveBroadcastCard m;
    View n;

    @Override // com.baidu.tieba.person.post.a
    public /* bridge */ /* synthetic */ void a(PersonPostModel.PostList postList, boolean z, String str) {
        super.a(postList, z, str);
    }

    @Override // com.baidu.tieba.person.post.a
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(View view) {
        super(view);
        this.g = view.findViewById(com.baidu.tieba.v.item_content);
        this.h = (TextView) view.findViewById(com.baidu.tieba.v.title);
        this.i = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.j = (TripleTbImageView) view.findViewById(com.baidu.tieba.v.images);
        this.k = view.findViewById(com.baidu.tieba.v.post_line);
        this.l = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_post_item_live_card);
        this.m = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.person_post_item_feed_item_card);
        this.n = view.findViewById(com.baidu.tieba.v.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void a(int i) {
        super.a(i);
        be.a(this.h, com.baidu.tieba.s.cp_cont_b, 1);
        be.a(this.i, com.baidu.tieba.s.cp_cont_f, 1);
        be.f(this.k, com.baidu.tieba.s.cp_bg_line_b);
    }
}
