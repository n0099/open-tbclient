package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n cao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.cao = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SingleMentionActivity singleMentionActivity;
        SingleMentionActivity singleMentionActivity2;
        SingleMentionActivity singleMentionActivity3;
        singleMentionActivity = this.cao.bZY;
        View currentFocus = singleMentionActivity.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            singleMentionActivity3 = this.cao.bZY;
            com.baidu.adp.lib.util.k.c(singleMentionActivity3.getActivity(), currentFocus);
        }
        singleMentionActivity2 = this.cao.bZY;
        singleMentionActivity2.getActivity().finish();
    }
}
