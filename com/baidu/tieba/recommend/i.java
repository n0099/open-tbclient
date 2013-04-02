package com.baidu.tieba.recommend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.c.ab;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        n nVar = (n) ((ListView) adapterView).getAdapter();
        long itemId = nVar.getItemId(i);
        if (itemId == -1) {
            i3 = this.a.e;
            if (i3 > 1) {
                GuessActivity guessActivity = this.a;
                i4 = guessActivity.e;
                guessActivity.e = i4 - 1;
                this.a.d = 2;
                this.a.q();
            }
        } else if (itemId == -2) {
            GuessActivity guessActivity2 = this.a;
            i2 = guessActivity2.e;
            guessActivity2.e = i2 + 1;
            this.a.d = 1;
            this.a.q();
        } else {
            ax axVar = (ax) nVar.getItem(i);
            if (axVar != null) {
                String k = axVar.k();
                if (k == null || k.equals("")) {
                    z = false;
                } else {
                    new Thread(new j(this, k)).start();
                }
                ab ap = TiebaApplication.b().ap();
                if (ap != null && !ap.b(axVar.b())) {
                    ap.a(axVar.b());
                }
                nVar.notifyDataSetChanged();
                PbActivity.a(this.a, axVar.b(), axVar.m(), z);
            }
        }
    }
}
