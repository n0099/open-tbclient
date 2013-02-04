package com.baidu.tieba.recommend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.as;
import com.baidu.tieba.c.aa;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        l lVar = (l) ((ListView) adapterView).getAdapter();
        long itemId = lVar.getItemId(i);
        if (itemId == -1) {
            i3 = this.a.d;
            if (i3 > 1) {
                GuessActivity guessActivity = this.a;
                i4 = guessActivity.d;
                guessActivity.d = i4 - 1;
                this.a.c = 2;
                this.a.p();
            }
        } else if (itemId == -2) {
            GuessActivity guessActivity2 = this.a;
            i2 = guessActivity2.d;
            guessActivity2.d = i2 + 1;
            this.a.c = 1;
            this.a.p();
        } else {
            as asVar = (as) lVar.getItem(i);
            if (asVar != null) {
                String k = asVar.k();
                if (k == null || k.equals("")) {
                    z = false;
                } else {
                    new Thread(new h(this, k)).start();
                }
                aa aj = TiebaApplication.a().aj();
                if (aj != null && !aj.b(asVar.b())) {
                    aj.a(asVar.b());
                }
                lVar.notifyDataSetChanged();
                PbActivity.a(this.a, asVar.b(), asVar.m(), z);
            }
        }
    }
}
