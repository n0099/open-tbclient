package com.baidu.tieba.write.transmit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectForumActivity ghv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectForumActivity selectForumActivity) {
        this.ghv = selectForumActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        boolean bsR;
        list = this.ghv.mDataList;
        TransmitForumData transmitForumData = (TransmitForumData) list.get(i);
        if (transmitForumData != null && transmitForumData.ghN) {
            this.ghv.showToast(w.l.cur_forum_can_not_cancel);
            return;
        }
        CheckBox checkBox = (CheckBox) view.findViewById(w.h.transmit_check_box);
        boolean isChecked = checkBox.isChecked();
        bsR = this.ghv.bsR();
        if (!isChecked && bsR) {
            this.ghv.showToast(w.l.transmit_max_commit);
            return;
        }
        checkBox.setChecked(!checkBox.isChecked());
        if (transmitForumData != null) {
            transmitForumData.aaP = checkBox.isChecked();
        }
        this.ghv.bsU();
        this.ghv.a(transmitForumData);
    }
}
