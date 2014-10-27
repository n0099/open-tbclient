package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout bQN;
    private final /* synthetic */ MediaData bQO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.bQN = commonImageLayout;
        this.bQO = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.bQN.mContext;
        com.baidu.tbadk.browser.a.i(context, this.bQO.getVideoUrl());
    }
}
