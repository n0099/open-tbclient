package com.baidu.tieba.write;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.gdS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridLayout gridLayout;
        TbImageView tbImageView;
        e eVar = this.gdS;
        gridLayout = this.gdS.gdK;
        tbImageView = this.gdS.gdJ;
        eVar.d(gridLayout, tbImageView);
    }
}
