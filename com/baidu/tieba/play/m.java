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
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.eWq = cVar;
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
        this.eWq.dwG = false;
        this.eWq.dwL = 0;
        this.eWq.azn();
        view = this.eWq.dws;
        view.setVisibility(0);
        progressBar = this.eWq.eWe;
        progressBar.setVisibility(8);
        progressBar2 = this.eWq.eWe;
        progressBar3 = this.eWq.eWe;
        progressBar2.setProgress(progressBar3.getMax());
        interfaceC0070c = this.eWq.eWm;
        if (interfaceC0070c != null) {
            interfaceC0070c2 = this.eWq.eWm;
            interfaceC0070c2.jn(false);
        }
        if (this.eWq.cHV) {
            view4 = this.eWq.dwy;
            view4.setVisibility(0);
            imageView2 = this.eWq.dwE;
            imageView2.setVisibility(0);
            textView2 = this.eWq.dwF;
            textView2.setVisibility(0);
            view5 = this.eWq.eWf;
            view5.setVisibility(8);
        } else {
            view2 = this.eWq.dwy;
            view2.setVisibility(8);
            imageView = this.eWq.dwE;
            imageView.setVisibility(8);
            textView = this.eWq.dwF;
            textView.setVisibility(8);
            view3 = this.eWq.eWf;
            view3.setVisibility(8);
        }
        this.eWq.eWg.setVisibility(0);
        str = this.eWq.exh;
        if (TextUtils.isEmpty(str)) {
            this.eWq.eWh.setVisibility(8);
            this.eWq.eWi.setVisibility(8);
        } else {
            this.eWq.eWh.setVisibility(0);
            this.eWq.eWi.setVisibility(0);
            TextView textView3 = this.eWq.eWi;
            tbPageContext = this.eWq.aaY;
            StringBuilder sb = new StringBuilder(String.valueOf(tbPageContext.getString(w.l.video_play_nextvideo)));
            str2 = this.eWq.exh;
            textView3.setText(sb.append(str2).toString());
        }
        az aZn = az.aZn();
        str3 = this.eWq.mVideoUrl;
        aZn.remove(str3);
        aVar = this.eWq.eWj;
        if (aVar != null) {
            aVar2 = this.eWq.eWj;
            aVar2.onCompletion(vVar);
        }
        this.eWq.akS = 3;
        this.eWq.aTd.setRecoveryState(3);
    }
}
