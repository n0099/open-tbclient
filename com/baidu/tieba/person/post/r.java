package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class r extends a {
    View abo;
    TripleTbImageView bJt;
    View bJu;
    LinearLayout bJv;
    LiveBroadcastCard bJw;
    TextView bst;
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
    public r(View view) {
        super(view, r0.getPageContext());
        BaseFragmentActivity baseFragmentActivity;
        baseFragmentActivity = p.mActivity;
        this.mContentView = view.findViewById(com.baidu.tieba.w.item_content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
        this.bst = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.bJt = (TripleTbImageView) view.findViewById(com.baidu.tieba.w.images);
        this.bJu = view.findViewById(com.baidu.tieba.w.post_line);
        this.bJv = (LinearLayout) view.findViewById(com.baidu.tieba.w.person_post_item_live_card);
        this.bJw = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.w.person_post_item_feed_item_card);
        this.abo = view.findViewById(com.baidu.tieba.w.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void cs(int i) {
        super.cs(i);
        bc.b(this.mTitle, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bst, com.baidu.tieba.t.cp_cont_f, 1);
        bc.i(this.bJu, com.baidu.tieba.t.cp_bg_line_b);
    }
}
