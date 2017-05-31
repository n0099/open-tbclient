package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h exs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.exs = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        pbActivity = this.exs.elf;
        pbActivity.aat();
    }
}
