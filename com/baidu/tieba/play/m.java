package com.baidu.tieba.play;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements v.a {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.eSu = cVar;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        View view;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        c.InterfaceC0072c interfaceC0072c;
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
        c.InterfaceC0072c interfaceC0072c2;
        this.eSu.dvu = false;
        this.eSu.dvz = 0;
        if (this.eSu.cFI) {
            this.eSu.azm();
        }
        view = this.eSu.bQI;
        view.setVisibility(0);
        progressBar = this.eSu.eSl;
        progressBar.setVisibility(8);
        progressBar2 = this.eSu.eSl;
        progressBar3 = this.eSu.eSl;
        progressBar2.setProgress(progressBar3.getMax());
        interfaceC0072c = this.eSu.eSr;
        if (interfaceC0072c != null) {
            interfaceC0072c2 = this.eSu.eSr;
            interfaceC0072c2.iZ(false);
        }
        if (this.eSu.cFI) {
            view4 = this.eSu.duX;
            view4.setVisibility(0);
            imageView2 = this.eSu.dvt;
            imageView2.setVisibility(0);
            textView2 = this.eSu.bQK;
            textView2.setVisibility(0);
            view5 = this.eSu.eSm;
            view5.setVisibility(8);
        } else {
            view2 = this.eSu.duX;
            view2.setVisibility(8);
            imageView = this.eSu.dvt;
            imageView.setVisibility(8);
            textView = this.eSu.bQK;
            textView.setVisibility(8);
            view3 = this.eSu.eSm;
            view3.setVisibility(8);
        }
        this.eSu.eSn.setVisibility(0);
        str = this.eSu.etw;
        if (TextUtils.isEmpty(str)) {
            this.eSu.eSo.setVisibility(8);
            this.eSu.eSp.setVisibility(8);
        } else {
            this.eSu.eSo.setVisibility(0);
            this.eSu.eSp.setVisibility(0);
            TextView textView3 = this.eSu.eSp;
            tbPageContext = this.eSu.Fp;
            StringBuilder sb = new StringBuilder(String.valueOf(tbPageContext.getString(r.l.video_play_nextvideo)));
            str2 = this.eSu.etw;
            textView3.setText(sb.append(str2).toString());
        }
        az aYy = az.aYy();
        str3 = this.eSu.aOm;
        aYy.remove(str3);
        aVar = this.eSu.dvq;
        if (aVar != null) {
            aVar2 = this.eSu.dvq;
            aVar2.onCompletion(vVar);
        }
        this.eSu.afl = 3;
        this.eSu.aMY.setRecoveryState(3);
    }
}
