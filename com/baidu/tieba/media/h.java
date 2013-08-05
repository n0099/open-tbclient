package com.baidu.tieba.media;

import android.view.View;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaDownloadHelper f1275a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MediaDownloadHelper mediaDownloadHelper) {
        this.f1275a = mediaDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        View.OnClickListener onClickListener;
        this.f1275a.g = MediaDownloadHelper.DOWNLOAD_STAT.PAUSE;
        aVar = this.f1275a.f1264a;
        onClickListener = this.f1275a.i;
        aVar.a(onClickListener);
    }
}
