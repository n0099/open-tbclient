package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class s extends a {
    TextView JM;
    View UI;
    TripleTbImageView bDW;
    View bDX;
    LinearLayout bDY;
    LiveBroadcastCard bDZ;
    TextView bmf;
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
    public s(View view) {
        super(view);
        this.mContentView = view.findViewById(com.baidu.tieba.v.item_content);
        this.JM = (TextView) view.findViewById(com.baidu.tieba.v.title);
        this.bmf = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.bDW = (TripleTbImageView) view.findViewById(com.baidu.tieba.v.images);
        this.bDX = view.findViewById(com.baidu.tieba.v.post_line);
        this.bDY = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_post_item_live_card);
        this.bDZ = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.person_post_item_feed_item_card);
        this.UI = view.findViewById(com.baidu.tieba.v.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void bM(int i) {
        super.bM(i);
        aw.b(this.JM, com.baidu.tieba.s.cp_cont_b, 1);
        aw.b(this.bmf, com.baidu.tieba.s.cp_cont_f, 1);
        aw.h(this.bDX, com.baidu.tieba.s.cp_bg_line_b);
    }
}
