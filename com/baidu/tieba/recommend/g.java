package com.baidu.tieba.recommend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.at;
import com.baidu.tieba.c.ab;
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
            i3 = this.a.e;
            if (i3 > 1) {
                GuessActivity guessActivity = this.a;
                i4 = guessActivity.e;
                guessActivity.e = i4 - 1;
                this.a.d = 2;
                this.a.r();
            }
        } else if (itemId == -2) {
            GuessActivity guessActivity2 = this.a;
            i2 = guessActivity2.e;
            guessActivity2.e = i2 + 1;
            this.a.d = 1;
            this.a.r();
        } else {
            at atVar = (at) lVar.getItem(i);
            if (atVar != null) {
                String k = atVar.k();
                if (k == null || k.equals("")) {
                    z = false;
                } else {
                    new Thread(new h(this, k)).start();
                }
                ab an = TiebaApplication.b().an();
                if (an != null && !an.b(atVar.b())) {
                    an.a(atVar.b());
                }
                lVar.notifyDataSetChanged();
                PbActivity.a(this.a, atVar.b(), atVar.m(), z);
            }
        }
    }
}
