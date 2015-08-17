package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n bVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bVW = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SingleMentionActivity singleMentionActivity;
        SingleMentionActivity singleMentionActivity2;
        SingleMentionActivity singleMentionActivity3;
        singleMentionActivity = this.bVW.bVG;
        View currentFocus = singleMentionActivity.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            singleMentionActivity3 = this.bVW.bVG;
            com.baidu.adp.lib.util.k.c(singleMentionActivity3.getActivity(), currentFocus);
        }
        singleMentionActivity2 = this.bVW.bVG;
        singleMentionActivity2.getActivity().finish();
    }
}
