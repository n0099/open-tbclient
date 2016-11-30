package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList gnJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.gnJ = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean aAK;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.gnJ.mLayout;
        linearLayout.removeView(view);
        aAK = this.gnJ.aAK();
        if (!aAK) {
            this.gnJ.aAI();
        }
        aVar = this.gnJ.gnI;
        if (aVar != null) {
            aVar2 = this.gnJ.gnI;
            aVar2.a(view, view.getTag());
        }
    }
}
