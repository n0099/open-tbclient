package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n caz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.caz = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SingleMentionActivity singleMentionActivity;
        SingleMentionActivity singleMentionActivity2;
        SingleMentionActivity singleMentionActivity3;
        singleMentionActivity = this.caz.caj;
        View currentFocus = singleMentionActivity.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            singleMentionActivity3 = this.caz.caj;
            com.baidu.adp.lib.util.k.c(singleMentionActivity3.getActivity(), currentFocus);
        }
        singleMentionActivity2 = this.caz.caj;
        singleMentionActivity2.getActivity().finish();
    }
}
