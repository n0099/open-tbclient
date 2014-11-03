package com.baidu.tieba.im.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ ChatterboxDialog bjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatterboxDialog chatterboxDialog) {
        this.bjt = chatterboxDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ChatterboxEditDialog chatterboxEditDialog;
        String str;
        ChatterboxEditDialog chatterboxEditDialog2;
        String str2;
        ChatterboxEditDialog chatterboxEditDialog3;
        chatterboxEditDialog = this.bjt.mChatterboxEditDialog;
        str = this.bjt.mSelectedText;
        chatterboxEditDialog.setSelectText(str);
        chatterboxEditDialog2 = this.bjt.mChatterboxEditDialog;
        str2 = this.bjt.mSelectedContent;
        chatterboxEditDialog2.setSelectedContent(str2);
        chatterboxEditDialog3 = this.bjt.mChatterboxEditDialog;
        chatterboxEditDialog3.show();
        this.bjt.cancel();
    }
}
