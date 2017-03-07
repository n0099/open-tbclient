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
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.eWb = cVar;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        View view;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        c.InterfaceC0071c interfaceC0071c;
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
        c.InterfaceC0071c interfaceC0071c2;
        this.eWb.dxS = false;
        this.eWb.dxX = 0;
        this.eWb.ayI();
        view = this.eWb.bXQ;
        view.setVisibility(0);
        progressBar = this.eWb.eVP;
        progressBar.setVisibility(8);
        progressBar2 = this.eWb.eVP;
        progressBar3 = this.eWb.eVP;
        progressBar2.setProgress(progressBar3.getMax());
        interfaceC0071c = this.eWb.eVX;
        if (interfaceC0071c != null) {
            interfaceC0071c2 = this.eWb.eVX;
            interfaceC0071c2.je(false);
        }
        if (this.eWb.cHf) {
            view4 = this.eWb.dxx;
            view4.setVisibility(0);
            imageView2 = this.eWb.dxR;
            imageView2.setVisibility(0);
            textView2 = this.eWb.bXS;
            textView2.setVisibility(0);
            view5 = this.eWb.eVQ;
            view5.setVisibility(8);
        } else {
            view2 = this.eWb.dxx;
            view2.setVisibility(8);
            imageView = this.eWb.dxR;
            imageView.setVisibility(8);
            textView = this.eWb.bXS;
            textView.setVisibility(8);
            view3 = this.eWb.eVQ;
            view3.setVisibility(8);
        }
        this.eWb.eVR.setVisibility(0);
        str = this.eWb.ewL;
        if (TextUtils.isEmpty(str)) {
            this.eWb.eVS.setVisibility(8);
            this.eWb.eVT.setVisibility(8);
        } else {
            this.eWb.eVS.setVisibility(0);
            this.eWb.eVT.setVisibility(0);
            TextView textView3 = this.eWb.eVT;
            tbPageContext = this.eWb.aaI;
            StringBuilder sb = new StringBuilder(String.valueOf(tbPageContext.getString(w.l.video_play_nextvideo)));
            str2 = this.eWb.ewL;
            textView3.setText(sb.append(str2).toString());
        }
        az aYd = az.aYd();
        str3 = this.eWb.aTZ;
        aYd.remove(str3);
        aVar = this.eWb.eVU;
        if (aVar != null) {
            aVar2 = this.eWb.eVU;
            aVar2.onCompletion(vVar);
        }
        this.eWb.akD = 3;
        this.eWb.aSL.setRecoveryState(3);
    }
}
