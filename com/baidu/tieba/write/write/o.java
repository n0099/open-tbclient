package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fTg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fTg = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean avB;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fTg.mLayout;
        linearLayout.removeView(view);
        avB = this.fTg.avB();
        if (!avB) {
            this.fTg.avz();
        }
        aVar = this.fTg.fTf;
        if (aVar != null) {
            aVar2 = this.fTg.fTf;
            aVar2.a(view, view.getTag());
        }
    }
}
