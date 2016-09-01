package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList gdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.gdV = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ayp;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.gdV.mLayout;
        linearLayout.removeView(view);
        ayp = this.gdV.ayp();
        if (!ayp) {
            this.gdV.ayn();
        }
        aVar = this.gdV.gdU;
        if (aVar != null) {
            aVar2 = this.gdV.gdU;
            aVar2.a(view, view.getTag());
        }
    }
}
