package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.widget.AbsListView;
import android.widget.EditText;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ SearchLocationActivity eZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SearchLocationActivity searchLocationActivity) {
        this.eZt = searchLocationActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        EditText editText;
        if (i == 2 || i == 1) {
            Activity pageActivity = this.eZt.getPageContext().getPageActivity();
            editText = this.eZt.cLO;
            com.baidu.adp.lib.util.k.a(pageActivity, editText);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
