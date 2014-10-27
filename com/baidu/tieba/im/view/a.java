package com.baidu.tieba.im.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ ChatterboxDialog bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatterboxDialog chatterboxDialog) {
        this.bjf = chatterboxDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ChatterboxEditDialog chatterboxEditDialog;
        String str;
        ChatterboxEditDialog chatterboxEditDialog2;
        String str2;
        ChatterboxEditDialog chatterboxEditDialog3;
        chatterboxEditDialog = this.bjf.mChatterboxEditDialog;
        str = this.bjf.mSelectedText;
        chatterboxEditDialog.setSelectText(str);
        chatterboxEditDialog2 = this.bjf.mChatterboxEditDialog;
        str2 = this.bjf.mSelectedContent;
        chatterboxEditDialog2.setSelectedContent(str2);
        chatterboxEditDialog3 = this.bjf.mChatterboxEditDialog;
        chatterboxEditDialog3.show();
        this.bjf.cancel();
    }
}
