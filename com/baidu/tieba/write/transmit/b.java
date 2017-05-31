package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ TransmitForumActivity fWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TransmitForumActivity transmitForumActivity) {
        this.fWH = transmitForumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        String cS;
        if (view != null) {
            int id = view.getId();
            textView = this.fWH.fWz;
            if (id == textView.getId()) {
                ArrayList<TransmitForumData> box = this.fWH.box();
                Intent intent = new Intent();
                cS = this.fWH.cS(box);
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, cS);
                this.fWH.setResult(-1, intent);
                this.fWH.boy();
                return;
            }
            int id2 = view.getId();
            view2 = this.fWH.eWQ;
            if (id2 != view2.getId()) {
                int id3 = view.getId();
                view3 = this.fWH.cMN;
                if (id3 != view3.getId()) {
                    return;
                }
            }
            this.fWH.setResult(0);
            this.fWH.boy();
        }
    }
}
