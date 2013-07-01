package com.baidu.tieba.media;

import android.view.View;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaDownloadHelper f962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MediaDownloadHelper mediaDownloadHelper) {
        this.f962a = mediaDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        View.OnClickListener onClickListener;
        this.f962a.g = MediaDownloadHelper.DOWNLOAD_STAT.PAUSE;
        aVar = this.f962a.f951a;
        onClickListener = this.f962a.i;
        aVar.a(onClickListener);
    }
}
