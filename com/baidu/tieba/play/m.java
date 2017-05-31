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
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.fbb = cVar;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        View view;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        c.InterfaceC0078c interfaceC0078c;
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
        c.InterfaceC0078c interfaceC0078c2;
        this.fbb.dwh = false;
        this.fbb.dwm = 0;
        this.fbb.axd();
        view = this.fbb.dvT;
        view.setVisibility(0);
        progressBar = this.fbb.faO;
        progressBar.setVisibility(8);
        progressBar2 = this.fbb.faO;
        progressBar3 = this.fbb.faO;
        progressBar2.setProgress(progressBar3.getMax());
        interfaceC0078c = this.fbb.faW;
        if (interfaceC0078c != null) {
            interfaceC0078c2 = this.fbb.faW;
            interfaceC0078c2.jl(false);
        }
        if (this.fbb.cHz) {
            view4 = this.fbb.dvZ;
            view4.setVisibility(0);
            imageView2 = this.fbb.dwf;
            imageView2.setVisibility(0);
            textView2 = this.fbb.dwg;
            textView2.setVisibility(0);
            view5 = this.fbb.faP;
            view5.setVisibility(8);
        } else {
            view2 = this.fbb.dvZ;
            view2.setVisibility(8);
            imageView = this.fbb.dwf;
            imageView.setVisibility(8);
            textView = this.fbb.dwg;
            textView.setVisibility(8);
            view3 = this.fbb.faP;
            view3.setVisibility(8);
        }
        if (this.fbb.bCE != null && this.fbb.bCE.getDuration() <= 150000) {
            this.fbb.faQ.setVisibility(0);
        } else {
            this.fbb.ky(false);
        }
        ba aYd = ba.aYd();
        str = this.fbb.mVideoUrl;
        aYd.remove(str);
        aVar = this.fbb.faT;
        if (aVar != null) {
            aVar2 = this.fbb.faT;
            aVar2.onCompletion(vVar);
        }
        this.fbb.akf = 3;
        this.fbb.bCE.setRecoveryState(3);
        if (!this.fbb.cHz && this.fbb.bCE != null && this.fbb.bCE.getDuration() <= 150000) {
            fVar = this.fbb.faY;
            if (fVar != null) {
                fVar2 = this.fbb.faY;
                fVar2.aOZ();
            }
            c cVar = this.fbb;
            str2 = this.fbb.mVideoUrl;
            cVar.startPlay(str2);
        }
    }
}
