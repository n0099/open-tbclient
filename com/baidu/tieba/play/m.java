package com.baidu.tieba.play;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements v.a {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.flr = cVar;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        View view;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        c.InterfaceC0081c interfaceC0081c;
        View view2;
        ImageView imageView;
        TextView textView;
        View view3;
        String str;
        v.a aVar;
        c.f fVar;
        String str2;
        c.f fVar2;
        v.a aVar2;
        View view4;
        ImageView imageView2;
        TextView textView2;
        View view5;
        c.InterfaceC0081c interfaceC0081c2;
        this.flr.dEU = false;
        this.flr.dEZ = 0;
        this.flr.aBc();
        view = this.flr.dEG;
        view.setVisibility(0);
        progressBar = this.flr.fle;
        progressBar.setVisibility(8);
        progressBar2 = this.flr.fle;
        progressBar3 = this.flr.fle;
        progressBar2.setProgress(progressBar3.getMax());
        interfaceC0081c = this.flr.flm;
        if (interfaceC0081c != null) {
            interfaceC0081c2 = this.flr.flm;
            interfaceC0081c2.jJ(false);
        }
        if (this.flr.cPv) {
            view4 = this.flr.dEM;
            view4.setVisibility(0);
            imageView2 = this.flr.dES;
            imageView2.setVisibility(0);
            textView2 = this.flr.dET;
            textView2.setVisibility(0);
            view5 = this.flr.flf;
            view5.setVisibility(8);
        } else {
            view2 = this.flr.dEM;
            view2.setVisibility(8);
            imageView = this.flr.dES;
            imageView.setVisibility(8);
            textView = this.flr.dET;
            textView.setVisibility(8);
            view3 = this.flr.flf;
            view3.setVisibility(8);
        }
        if (this.flr.bDx != null && this.flr.bDx.getDuration() <= 150000) {
            this.flr.flg.setVisibility(0);
        } else {
            this.flr.kY(false);
        }
        ba bco = ba.bco();
        str = this.flr.mVideoUrl;
        bco.remove(str);
        aVar = this.flr.flj;
        if (aVar != null) {
            aVar2 = this.flr.flj;
            aVar2.onCompletion(vVar);
        }
        this.flr.akS = 3;
        this.flr.bDx.setRecoveryState(3);
        if (!this.flr.cPv && this.flr.bDx != null && this.flr.bDx.getDuration() <= 150000) {
            fVar = this.flr.flo;
            if (fVar != null) {
                fVar2 = this.flr.flo;
                fVar2.aSY();
            }
            c cVar = this.flr;
            str2 = this.flr.mVideoUrl;
            cVar.startPlay(str2);
        }
    }
}
