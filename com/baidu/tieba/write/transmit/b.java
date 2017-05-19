package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ TransmitForumActivity fOL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TransmitForumActivity transmitForumActivity) {
        this.fOL = transmitForumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        String cQ;
        if (view != null) {
            int id = view.getId();
            textView = this.fOL.fOD;
            if (id == textView.getId()) {
                ArrayList<TransmitForumData> bmY = this.fOL.bmY();
                Intent intent = new Intent();
                cQ = this.fOL.cQ(bmY);
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, cQ);
                this.fOL.setResult(-1, intent);
                this.fOL.bmZ();
                return;
            }
            int id2 = view.getId();
            view2 = this.fOL.eOf;
            if (id2 != view2.getId()) {
                int id3 = view.getId();
                view3 = this.fOL.cHp;
                if (id3 != view3.getId()) {
                    return;
                }
            }
            this.fOL.setResult(0);
            this.fOL.bmZ();
        }
    }
}
