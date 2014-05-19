package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
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
        this.g = view.findViewById(com.baidu.tieba.r.item_content);
        this.h = (TextView) view.findViewById(com.baidu.tieba.r.title);
        this.i = (TextView) view.findViewById(com.baidu.tieba.r.content);
        this.j = (TripleTbImageView) view.findViewById(com.baidu.tieba.r.images);
        this.k = view.findViewById(com.baidu.tieba.r.post_line);
        this.l = (LinearLayout) view.findViewById(com.baidu.tieba.r.person_post_item_live_card);
        this.m = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.r.person_post_item_feed_item_card);
        this.n = view.findViewById(com.baidu.tieba.r.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void a(int i) {
        super.a(i);
        bc.a(this.h, com.baidu.tieba.o.cp_cont_b, 1);
        bc.a(this.i, com.baidu.tieba.o.cp_cont_f, 1);
        bc.f(this.k, com.baidu.tieba.o.cp_bg_line_b);
    }
}
