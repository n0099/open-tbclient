package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ AtListActivity fYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtListActivity atListActivity) {
        this.fYZ = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.fYZ.fYV;
        textView.setVisibility(8);
        view2 = this.fYZ.dkV;
        view2.setVisibility(8);
        view3 = this.fYZ.dkU;
        view3.setVisibility(0);
        this.fYZ.dhk.requestFocus();
    }
}
