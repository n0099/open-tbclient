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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2179a;

    private i(ImageActivity imageActivity) {
        this.f2179a = imageActivity;
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
        this.f2179a.f = intent.getBooleanExtra("hasnext", false);
        this.f2179a.g = intent.getStringExtra("nexttitle");
        this.f2179a.c = intent.getStringArrayListExtra(SocialConstants.PARAM_URL);
        this.f2179a.e = intent.getIntExtra("count", -1);
        int intExtra = intent.getIntExtra("index", -1);
        multiImageView = this.f2179a.m;
        arrayList = this.f2179a.c;
        multiImageView.setUrlData(arrayList);
        multiImageView2 = this.f2179a.m;
        str = this.f2179a.g;
        multiImageView2.setNextTitle(str);
        multiImageView3 = this.f2179a.m;
        z = this.f2179a.f;
        multiImageView3.setHasNext(z);
        if (intExtra >= 0) {
            this.f2179a.d = intExtra;
            multiImageView4 = this.f2179a.m;
            g = this.f2179a.g();
            multiImageView4.a(g, false);
        }
    }
}
