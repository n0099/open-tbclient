package com.baidu.tieba.media;

import android.view.View;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ MediaDownloadHelper a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MediaDownloadHelper mediaDownloadHelper) {
        this.a = mediaDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        View.OnClickListener onClickListener;
        this.a.g = MediaDownloadHelper.DOWNLOAD_STAT.DOWNLOADING;
        aVar = this.a.a;
        onClickListener = this.a.h;
        aVar.b(onClickListener);
        this.a.g();
    }
}
