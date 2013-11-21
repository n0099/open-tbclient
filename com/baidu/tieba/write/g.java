package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.util.UtilHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.f2691a = atListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        EditText editText;
        kVar = this.f2691a.i;
        MetaData metaData = (MetaData) kVar.getItem(i);
        if (metaData != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", metaData.getName_show());
            bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, metaData.getName());
            bundle.putString(LocaleUtil.INDONESIAN, metaData.getId());
            bundle.putString("portrait", metaData.getPortrait());
            intent.putExtras(bundle);
            AtListActivity atListActivity = this.f2691a;
            editText = this.f2691a.b;
            UtilHelper.a(atListActivity, editText);
            this.f2691a.setResult(-1, intent);
            this.f2691a.finish();
        }
    }
}
