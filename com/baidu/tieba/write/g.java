package com.baidu.tieba.write;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.MetaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        k kVar;
        kVar = this.a.k;
        MetaData metaData = (MetaData) kVar.getItem(i);
        if (metaData != null) {
            Intent intent = new Intent();
            intent.putExtra("name_show", metaData.getName_show());
            intent.putExtra("name", metaData.getName());
            intent.putExtra("id", metaData.getId());
            intent.putExtra("portrait", metaData.getPortrait());
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
