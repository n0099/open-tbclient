package com.baidu.tieba.person;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity bBe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BasePersonInfoActivity basePersonInfoActivity) {
        this.bBe = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bBe.bBb;
        if (z) {
            com.baidu.tbadk.core.b.b.a(this.bBe, Constants.MEDIA_INFO, false);
        }
        this.bBe.finish();
    }
}
