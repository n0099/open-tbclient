package com.baidu.tieba.media;

import android.view.View;
import com.baidu.tieba.media.MediaDownloadHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ MediaDownloadHelper a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MediaDownloadHelper mediaDownloadHelper) {
        this.a = mediaDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        this.a.g = MediaDownloadHelper.DOWNLOAD_STAT.STOP;
        aVar = this.a.a;
        aVar.h();
    }
}
