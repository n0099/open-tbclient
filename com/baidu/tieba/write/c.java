package com.baidu.tieba.write;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ch;
import com.baidu.tieba.util.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        AtListActivity atListActivity;
        BdListView bdListView;
        AtListActivity atListActivity2;
        AtSelectFriendList atSelectFriendList;
        atListActivity = this.a.a;
        bdListView = atListActivity.d;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && bVar != null) {
            bVar.a(imageView);
            imageView.setTag(null);
        }
        atListActivity2 = this.a.a;
        atSelectFriendList = atListActivity2.e;
        ch.a((ViewGroup) atSelectFriendList, false, (cj) new d(this, str, bVar));
    }
}
