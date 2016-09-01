package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        axVar = this.evy.evl;
        if (axVar != null) {
            axVar2 = this.evy.evl;
            axVar2.Fa();
        }
    }
}
