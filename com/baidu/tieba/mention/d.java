package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.FeedData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ c bnx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bnx = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar = (k) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = kVar.getItemId(i);
        if (itemId == -1) {
            this.bnx.refresh();
        } else if (itemId != -2) {
            FeedData feedData = (FeedData) kVar.getItem(i);
            if (feedData != null) {
                this.bnx.a(feedData);
            }
        } else {
            this.bnx.SN();
        }
    }
}
