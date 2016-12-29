package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fCm = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean aug;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fCm.mLayout;
        linearLayout.removeView(view);
        aug = this.fCm.aug();
        if (!aug) {
            this.fCm.aue();
        }
        aVar = this.fCm.fCl;
        if (aVar != null) {
            aVar2 = this.fCm.fCl;
            aVar2.a(view, view.getTag());
        }
    }
}
