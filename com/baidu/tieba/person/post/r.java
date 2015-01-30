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
    View abr;
    TripleTbImageView bJu;
    View bJv;
    LinearLayout bJw;
    LiveBroadcastCard bJx;
    TextView bsu;
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
        this.bsu = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.bJu = (TripleTbImageView) view.findViewById(com.baidu.tieba.w.images);
        this.bJv = view.findViewById(com.baidu.tieba.w.post_line);
        this.bJw = (LinearLayout) view.findViewById(com.baidu.tieba.w.person_post_item_live_card);
        this.bJx = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.w.person_post_item_feed_item_card);
        this.abr = view.findViewById(com.baidu.tieba.w.person_post_thread_item_divider_1);
    }

    @Override // com.baidu.tieba.person.post.a
    public void cs(int i) {
        super.cs(i);
        bc.b(this.mTitle, com.baidu.tieba.t.cp_cont_b, 1);
        bc.b(this.bsu, com.baidu.tieba.t.cp_cont_f, 1);
        bc.i(this.bJv, com.baidu.tieba.t.cp_bg_line_b);
    }
}
