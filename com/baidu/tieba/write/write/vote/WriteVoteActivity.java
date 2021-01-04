package com.baidu.tieba.write.write.vote;

import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
/* loaded from: classes8.dex */
public class WriteVoteActivity extends SuspendedActivity {
    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        return new b(getPageContext(), linearLayout, navigationBar);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bIm() {
    }
}
