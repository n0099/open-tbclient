package com.baidu.tieba.write.write.vote;

import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import d.a.n0.t0.a;
import d.a.o0.w3.u.p.b;
/* loaded from: classes5.dex */
public class WriteVoteActivity extends SuspendedActivity {
    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        return new b(getPageContext(), linearLayout, navigationBar);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
    }
}
