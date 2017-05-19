package com.baidu.tieba.play;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements v.a {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.eSq = cVar;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        View view;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        c.InterfaceC0076c interfaceC0076c;
        View view2;
        ImageView imageView;
        TextView textView;
        View view3;
        String str;
        TbPageContext tbPageContext;
        String str2;
        String str3;
        v.a aVar;
        v.a aVar2;
        View view4;
        ImageView imageView2;
        TextView textView2;
        View view5;
        c.InterfaceC0076c interfaceC0076c2;
        this.eSq.dqP = false;
        this.eSq.dqU = 0;
        this.eSq.awk();
        view = this.eSq.dqB;
        view.setVisibility(0);
        progressBar = this.eSq.eSe;
        progressBar.setVisibility(8);
        progressBar2 = this.eSq.eSe;
        progressBar3 = this.eSq.eSe;
        progressBar2.setProgress(progressBar3.getMax());
        interfaceC0076c = this.eSq.eSm;
        if (interfaceC0076c != null) {
            interfaceC0076c2 = this.eSq.eSm;
            interfaceC0076c2.iS(false);
        }
        if (this.eSq.cCa) {
            view4 = this.eSq.dqH;
            view4.setVisibility(0);
            imageView2 = this.eSq.dqN;
            imageView2.setVisibility(0);
            textView2 = this.eSq.dqO;
            textView2.setVisibility(0);
            view5 = this.eSq.eSf;
            view5.setVisibility(8);
        } else {
            view2 = this.eSq.dqH;
            view2.setVisibility(8);
            imageView = this.eSq.dqN;
            imageView.setVisibility(8);
            textView = this.eSq.dqO;
            textView.setVisibility(8);
            view3 = this.eSq.eSf;
            view3.setVisibility(8);
        }
        this.eSq.eSg.setVisibility(0);
        str = this.eSq.esR;
        if (TextUtils.isEmpty(str)) {
            this.eSq.eSh.setVisibility(8);
            this.eSq.eSi.setVisibility(8);
        } else {
            this.eSq.eSh.setVisibility(0);
            this.eSq.eSi.setVisibility(0);
            TextView textView3 = this.eSq.eSi;
            tbPageContext = this.eSq.aat;
            StringBuilder sb = new StringBuilder(String.valueOf(tbPageContext.getString(w.l.video_play_nextvideo)));
            str2 = this.eSq.esR;
            textView3.setText(sb.append(str2).toString());
        }
        az aWM = az.aWM();
        str3 = this.eSq.mVideoUrl;
        aWM.remove(str3);
        aVar = this.eSq.eSj;
        if (aVar != null) {
            aVar2 = this.eSq.eSj;
            aVar2.onCompletion(vVar);
        }
        this.eSq.akp = 3;
        this.eSq.aTy.setRecoveryState(3);
    }
}
