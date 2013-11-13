package com.baidu.tieba.media;

import android.view.View;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaDownloadHelper f1833a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MediaDownloadHelper mediaDownloadHelper) {
        this.f1833a = mediaDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        View.OnClickListener onClickListener;
        this.f1833a.g = MediaDownloadHelper.DOWNLOAD_STAT.DOWNLOADING;
        aVar = this.f1833a.f1821a;
        onClickListener = this.f1833a.h;
        aVar.b(onClickListener);
        this.f1833a.g();
    }
}
