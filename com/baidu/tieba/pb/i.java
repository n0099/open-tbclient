package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BroadcastReceiver {
    final /* synthetic */ ImageActivity a;

    private i(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ImageActivity imageActivity, d dVar) {
        this(imageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MultiImageView multiImageView;
        ArrayList<String> arrayList;
        MultiImageView multiImageView2;
        String str;
        MultiImageView multiImageView3;
        boolean z;
        MultiImageView multiImageView4;
        int g;
        this.a.f = intent.getBooleanExtra("hasnext", false);
        this.a.g = intent.getStringExtra("nexttitle");
        this.a.c = intent.getStringArrayListExtra(SocialConstants.PARAM_URL);
        this.a.e = intent.getIntExtra("count", -1);
        int intExtra = intent.getIntExtra("index", -1);
        multiImageView = this.a.m;
        arrayList = this.a.c;
        multiImageView.setUrlData(arrayList);
        multiImageView2 = this.a.m;
        str = this.a.g;
        multiImageView2.setNextTitle(str);
        multiImageView3 = this.a.m;
        z = this.a.f;
        multiImageView3.setHasNext(z);
        if (intExtra >= 0) {
            this.a.d = intExtra;
            multiImageView4 = this.a.m;
            g = this.a.g();
            multiImageView4.a(g, false);
        }
    }
}
