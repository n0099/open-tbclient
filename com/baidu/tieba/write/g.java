package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.cloudsdk.social.core.SocialConstants;
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        EditText editText;
        kVar = this.a.i;
        MetaData metaData = (MetaData) kVar.getItem(i);
        if (metaData != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", metaData.getName_show());
            bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, metaData.getName());
            bundle.putString("id", metaData.getId());
            bundle.putString("portrait", metaData.getPortrait());
            intent.putExtras(bundle);
            AtListActivity atListActivity = this.a;
            editText = this.a.b;
            com.baidu.adp.lib.h.g.a(atListActivity, editText);
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
