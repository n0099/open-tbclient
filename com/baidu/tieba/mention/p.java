package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n cba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.cba = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SingleMentionActivity singleMentionActivity;
        SingleMentionActivity singleMentionActivity2;
        SingleMentionActivity singleMentionActivity3;
        singleMentionActivity = this.cba.caK;
        View currentFocus = singleMentionActivity.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            singleMentionActivity3 = this.cba.caK;
            com.baidu.adp.lib.util.k.c(singleMentionActivity3.getActivity(), currentFocus);
        }
        singleMentionActivity2 = this.cba.caK;
        singleMentionActivity2.getActivity().finish();
    }
}
