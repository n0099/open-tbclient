package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList gkf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.gkf = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean axa;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.gkf.mLayout;
        linearLayout.removeView(view);
        axa = this.gkf.axa();
        if (!axa) {
            this.gkf.awY();
        }
        aVar = this.gkf.gke;
        if (aVar != null) {
            aVar2 = this.gkf.gke;
            aVar2.b(view, view.getTag());
        }
    }
}
