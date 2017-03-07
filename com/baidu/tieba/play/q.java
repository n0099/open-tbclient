package com.baidu.tieba.play;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar) {
        this.eWb = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        c.f fVar;
        String str;
        c.f fVar2;
        c.d dVar;
        c.d dVar2;
        int id = view.getId();
        view2 = this.eWb.aSU;
        if (id != view2.getId()) {
            if (view.getId() != this.eWb.aSP.getId()) {
                int id2 = view.getId();
                imageView = this.eWb.dxL;
                if (id2 != imageView.getId()) {
                    if (view.getId() != this.eWb.eVS.getId()) {
                        if (view.getId() == this.eWb.eVR.getId()) {
                            fVar = this.eWb.eVZ;
                            if (fVar != null) {
                                fVar2 = this.eWb.eVZ;
                                fVar2.aPp();
                            }
                            c cVar = this.eWb;
                            str = this.eWb.aTZ;
                            cVar.startPlay(str);
                            return;
                        }
                        int id3 = view.getId();
                        imageView2 = this.eWb.dxM;
                        if (id3 == imageView2.getId()) {
                            if (this.eWb.cHf) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11714"));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11710"));
                            }
                            this.eWb.ayM();
                            return;
                        }
                        int id4 = view.getId();
                        imageView3 = this.eWb.dxR;
                        if (id4 == imageView3.getId()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11713"));
                            this.eWb.ayM();
                            return;
                        } else if (view.getId() != this.eWb.dxF.getId() || !this.eWb.dxS) {
                            return;
                        } else {
                            this.eWb.aXF();
                            return;
                        }
                    }
                    dVar = this.eWb.eVY;
                    if (dVar != null) {
                        dVar2 = this.eWb.eVY;
                        dVar2.aPo();
                        return;
                    }
                    return;
                }
            }
            this.eWb.aPl();
            return;
        }
        this.eWb.aXE();
    }
}
