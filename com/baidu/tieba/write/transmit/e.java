package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ TransmitForumActivity ghI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TransmitForumActivity transmitForumActivity) {
        this.ghI = transmitForumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        String dh;
        if (view != null) {
            int id = view.getId();
            textView = this.ghI.gho;
            if (id == textView.getId()) {
                ArrayList<TransmitForumData> bsV = this.ghI.bsV();
                Intent intent = new Intent();
                dh = this.ghI.dh(bsV);
                intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, dh);
                this.ghI.setResult(-1, intent);
                this.ghI.bsX();
                return;
            }
            int id2 = view.getId();
            view2 = this.ghI.dyF;
            if (id2 != view2.getId()) {
                int id3 = view.getId();
                view3 = this.ghI.cUK;
                if (id3 != view3.getId()) {
                    return;
                }
            }
            this.ghI.setResult(0);
            this.ghI.bsX();
        }
    }
}
