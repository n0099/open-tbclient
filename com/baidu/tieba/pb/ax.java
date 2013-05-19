package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ax implements View.OnLongClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        bl blVar;
        DialogInterface.OnClickListener onClickListener;
        this.a.c = (com.baidu.tieba.a.aq) view.getTag(R.id.tag_clip_board);
        if (this.a.c != null) {
            blVar = this.a.o;
            onClickListener = this.a.H;
            blVar.a(onClickListener);
        }
        return true;
    }
}
