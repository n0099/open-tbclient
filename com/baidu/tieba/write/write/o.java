package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList eLJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.eLJ = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean aku;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.eLJ.cvF;
        linearLayout.removeView(view);
        aku = this.eLJ.aku();
        if (!aku) {
            this.eLJ.aks();
        }
        aVar = this.eLJ.eLI;
        if (aVar != null) {
            aVar2 = this.eLJ.eLI;
            aVar2.a(view, view.getTag());
        }
    }
}
