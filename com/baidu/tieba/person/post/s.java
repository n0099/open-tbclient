package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class s extends a {
    View aaQ;
    TripleTbImageView bHI;
    View bHJ;
    LinearLayout bHK;
    LiveBroadcastCard bHL;
    TextView bqW;
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
        this.mContentView = view.findViewById(com.baidu.tieba.w.item_content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
        this.bqW = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.bHI = (TripleTbImageView) view.findViewById(com.baidu.tieba.w.images);
        this.bHJ = view.findViewById(com.baidu.tieba.w.post_line);
        this.bHK = (LinearLayout) view.findViewById(com.baidu.tieba.w.person_post_item_live_card);
        this.bHL = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.w.person_post_item_feed_item_card);
        this.aaQ = view.findViewById(com.baidu.tieba.w.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void cl(int i) {
        super.cl(i);
        ax.b(this.mTitle, com.baidu.tieba.t.cp_cont_b, 1);
        ax.b(this.bqW, com.baidu.tieba.t.cp_cont_f, 1);
        ax.i(this.bHJ, com.baidu.tieba.t.cp_bg_line_b);
    }
}
