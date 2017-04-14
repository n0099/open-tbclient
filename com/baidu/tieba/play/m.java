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
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.eUa = cVar;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        View view;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        c.InterfaceC0070c interfaceC0070c;
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
        c.InterfaceC0070c interfaceC0070c2;
        this.eUa.dup = false;
        this.eUa.duu = 0;
        this.eUa.aym();
        view = this.eUa.dub;
        view.setVisibility(0);
        progressBar = this.eUa.eTO;
        progressBar.setVisibility(8);
        progressBar2 = this.eUa.eTO;
        progressBar3 = this.eUa.eTO;
        progressBar2.setProgress(progressBar3.getMax());
        interfaceC0070c = this.eUa.eTW;
        if (interfaceC0070c != null) {
            interfaceC0070c2 = this.eUa.eTW;
            interfaceC0070c2.jd(false);
        }
        if (this.eUa.cFE) {
            view4 = this.eUa.duh;
            view4.setVisibility(0);
            imageView2 = this.eUa.dun;
            imageView2.setVisibility(0);
            textView2 = this.eUa.duo;
            textView2.setVisibility(0);
            view5 = this.eUa.eTP;
            view5.setVisibility(8);
        } else {
            view2 = this.eUa.duh;
            view2.setVisibility(8);
            imageView = this.eUa.dun;
            imageView.setVisibility(8);
            textView = this.eUa.duo;
            textView.setVisibility(8);
            view3 = this.eUa.eTP;
            view3.setVisibility(8);
        }
        this.eUa.eTQ.setVisibility(0);
        str = this.eUa.euR;
        if (TextUtils.isEmpty(str)) {
            this.eUa.eTR.setVisibility(8);
            this.eUa.eTS.setVisibility(8);
        } else {
            this.eUa.eTR.setVisibility(0);
            this.eUa.eTS.setVisibility(0);
            TextView textView3 = this.eUa.eTS;
            tbPageContext = this.eUa.aaX;
            StringBuilder sb = new StringBuilder(String.valueOf(tbPageContext.getString(w.l.video_play_nextvideo)));
            str2 = this.eUa.euR;
            textView3.setText(sb.append(str2).toString());
        }
        az aYm = az.aYm();
        str3 = this.eUa.mVideoUrl;
        aYm.remove(str3);
        aVar = this.eUa.eTT;
        if (aVar != null) {
            aVar2 = this.eUa.eTT;
            aVar2.onCompletion(vVar);
        }
        this.eUa.akR = 3;
        this.eUa.aTb.setRecoveryState(3);
    }
}
