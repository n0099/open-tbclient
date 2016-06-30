package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fIa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fIa = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean asP;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fIa.mLayout;
        linearLayout.removeView(view);
        asP = this.fIa.asP();
        if (!asP) {
            this.fIa.asN();
        }
        aVar = this.fIa.fHZ;
        if (aVar != null) {
            aVar2 = this.fIa.fHZ;
            aVar2.a(view, view.getTag());
        }
    }
}
