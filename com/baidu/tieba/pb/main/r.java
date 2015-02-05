package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class r implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.bAS.bAQ != null) {
            if (i == 0) {
                this.bAS.bAQ.az(this.bAS.getPageContext().getPageActivity());
                this.bAS.bAQ = null;
            } else if (i == 1) {
                this.bAS.a(this.bAS.bAQ);
            }
        }
    }
}
