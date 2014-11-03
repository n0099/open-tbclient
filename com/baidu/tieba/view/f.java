package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout bRc;
    private final /* synthetic */ MediaData bRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.bRc = commonImageLayout;
        this.bRd = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.bRc.mContext;
        com.baidu.tbadk.browser.a.i(context, this.bRd.getVideoUrl());
    }
}
