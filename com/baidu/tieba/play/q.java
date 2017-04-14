package com.baidu.tieba.play;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar) {
        this.eUa = cVar;
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
        view2 = this.eUa.aTj;
        if (id != view2.getId()) {
            if (view.getId() != this.eUa.aTe.getId()) {
                int id2 = view.getId();
                imageView = this.eUa.duf;
                if (id2 != imageView.getId()) {
                    if (view.getId() != this.eUa.eTR.getId()) {
                        if (view.getId() == this.eUa.eTQ.getId()) {
                            fVar = this.eUa.eTY;
                            if (fVar != null) {
                                fVar2 = this.eUa.eTY;
                                fVar2.aPy();
                            }
                            c cVar = this.eUa;
                            str = this.eUa.mVideoUrl;
                            cVar.startPlay(str);
                            return;
                        }
                        int id3 = view.getId();
                        imageView2 = this.eUa.dug;
                        if (id3 == imageView2.getId()) {
                            if (this.eUa.cFE) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11714"));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11710"));
                            }
                            this.eUa.ayq();
                            return;
                        }
                        int id4 = view.getId();
                        imageView3 = this.eUa.dun;
                        if (id4 == imageView3.getId()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11713"));
                            this.eUa.ayq();
                            return;
                        } else if (view.getId() != this.eUa.dtY.getId() || !this.eUa.dup) {
                            return;
                        } else {
                            this.eUa.aXO();
                            return;
                        }
                    }
                    dVar = this.eUa.eTX;
                    if (dVar != null) {
                        dVar2 = this.eUa.eTX;
                        dVar2.aPx();
                        return;
                    }
                    return;
                }
            }
            this.eUa.aPu();
            return;
        }
        this.eUa.aXN();
    }
}
