package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fKH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fKH = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean avm;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fKH.mLayout;
        linearLayout.removeView(view);
        avm = this.fKH.avm();
        if (!avm) {
            this.fKH.avk();
        }
        aVar = this.fKH.fKG;
        if (aVar != null) {
            aVar2 = this.fKH.fKG;
            aVar2.a(view, view.getTag());
        }
    }
}
