package com.baidu.tieba.media;

import android.view.View;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaDownloadHelper f1834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MediaDownloadHelper mediaDownloadHelper) {
        this.f1834a = mediaDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        this.f1834a.g = MediaDownloadHelper.DOWNLOAD_STAT.STOP;
        aVar = this.f1834a.f1821a;
        aVar.h();
    }
}
