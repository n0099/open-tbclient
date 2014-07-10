package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout a;
    private final /* synthetic */ MediaData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.a = commonImageLayout;
        this.b = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.o;
        com.baidu.tbadk.browser.a.a(context, this.b.getVideoUrl());
    }
}
