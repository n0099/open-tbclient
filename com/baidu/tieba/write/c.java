package com.baidu.tieba.write;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        AtListActivity atListActivity;
        BdListView bdListView;
        AtListActivity atListActivity2;
        AtSelectFriendList atSelectFriendList;
        atListActivity = this.a.a;
        bdListView = atListActivity.d;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && aVar != null) {
            aVar.a(imageView);
            imageView.setTag(null);
        }
        atListActivity2 = this.a.a;
        atSelectFriendList = atListActivity2.e;
        com.baidu.tbadk.core.util.bp.a((ViewGroup) atSelectFriendList, false, (com.baidu.tbadk.core.util.br) new d(this, str, aVar));
    }
}
