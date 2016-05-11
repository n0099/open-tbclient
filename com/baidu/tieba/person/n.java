package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final /* synthetic */ String dvb;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.dvb = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.bDI.getVisibility() != 0) {
            String str2 = this.dvb;
            str = this.this$0.duT;
            if (!str2.equals(str)) {
                this.this$0.H(this.dvb, true);
                this.this$0.mo(this.dvb);
                this.this$0.duR = this.val$id;
            }
        }
    }
}
