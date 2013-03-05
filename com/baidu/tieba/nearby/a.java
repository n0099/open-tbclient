package com.baidu.tieba.nearby;

import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ NearbyForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NearbyForumActivity nearbyForumActivity) {
        this.a = nearbyForumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nearby_forum_node_layout /* 2131231199 */:
                String str = (String) view.getTag();
                if (com.baidu.tieba.c.af.d(str)) {
                    FrsActivity.a(this.a, str, "tb_suishoufa");
                    return;
                }
                return;
            case R.id.thread_count /* 2131231200 */:
            case R.id.div /* 2131231201 */:
            default:
                return;
            case R.id.like /* 2131231202 */:
                this.a.a((String) view.getTag(R.id.tag_nearby_forum_name), (String) view.getTag(R.id.tag_nearby_forum_id));
                return;
        }
    }
}
