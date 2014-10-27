package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.flist.ForumListActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ BarFolderFirstDirActivity bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.bLV = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        q qVar;
        cVar = this.bLV.bLR;
        ArrayList<q> adl = cVar.adl();
        if (adl != null && i < adl.size() && (qVar = adl.get(i)) != null) {
            ForumListActivity.c(this.bLV, qVar.auZ, qVar.ava, qVar.avb);
        }
    }
}
