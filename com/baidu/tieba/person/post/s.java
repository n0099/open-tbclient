package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class s extends a {
    View axS;
    TripleTbImageView bRT;
    View bRU;
    LinearLayout bRV;
    LiveBroadcastCard bRW;
    TextView byT;
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
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s(View view) {
        super(view, r0.getPageContext());
        BaseFragmentActivity baseFragmentActivity;
        baseFragmentActivity = q.mActivity;
        this.mContentView = view.findViewById(com.baidu.tieba.v.item_content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.title);
        this.byT = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.bRT = (TripleTbImageView) view.findViewById(com.baidu.tieba.v.images);
        this.bRU = view.findViewById(com.baidu.tieba.v.post_line);
        this.bRV = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_post_item_live_card);
        this.bRW = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.person_post_item_feed_item_card);
        this.axS = view.findViewById(com.baidu.tieba.v.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void ct(int i) {
        super.ct(i);
        ba.b(this.mTitle, com.baidu.tieba.s.cp_cont_b, 1);
        ba.b(this.byT, com.baidu.tieba.s.cp_cont_f, 1);
        ba.i(this.bRU, com.baidu.tieba.s.cp_bg_line_b);
    }
}
