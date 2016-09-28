package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList ggf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.ggf = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ayN;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.ggf.mLayout;
        linearLayout.removeView(view);
        ayN = this.ggf.ayN();
        if (!ayN) {
            this.ggf.ayL();
        }
        aVar = this.ggf.gge;
        if (aVar != null) {
            aVar2 = this.ggf.gge;
            aVar2.a(view, view.getTag());
        }
    }
}
