package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f1645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.f1645a = aqVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        if (bVar != null) {
            bdListView = this.f1645a.b;
            View findViewWithTag = bdListView.findViewWithTag(str);
            if (findViewWithTag != null) {
                findViewWithTag.invalidate();
            }
        }
    }
}
