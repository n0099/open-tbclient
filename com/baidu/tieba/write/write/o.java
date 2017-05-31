package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fZg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fZg = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ats;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fZg.mLayout;
        linearLayout.removeView(view);
        ats = this.fZg.ats();
        if (!ats) {
            this.fZg.atq();
        }
        aVar = this.fZg.fZf;
        if (aVar != null) {
            aVar2 = this.fZg.fZf;
            aVar2.b(view, view.getTag());
        }
    }
}
