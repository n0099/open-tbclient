package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.MetaData;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.f1931a = atListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        k kVar;
        kVar = this.f1931a.l;
        MetaData metaData = (MetaData) kVar.getItem(i);
        if (metaData != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", metaData.getName_show());
            bundle.putString("name", metaData.getName());
            bundle.putString(LocaleUtil.INDONESIAN, metaData.getId());
            bundle.putString("portrait", metaData.getPortrait());
            intent.putExtras(bundle);
            this.f1931a.setResult(-1, intent);
            this.f1931a.finish();
        }
    }
}
