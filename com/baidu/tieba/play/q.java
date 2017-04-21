package com.baidu.tieba.play;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar) {
        this.eWq = cVar;
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
        view2 = this.eWq.aTl;
        if (id != view2.getId()) {
            if (view.getId() != this.eWq.aTg.getId()) {
                int id2 = view.getId();
                imageView = this.eWq.dww;
                if (id2 != imageView.getId()) {
                    if (view.getId() != this.eWq.eWh.getId()) {
                        if (view.getId() == this.eWq.eWg.getId()) {
                            fVar = this.eWq.eWo;
                            if (fVar != null) {
                                fVar2 = this.eWq.eWo;
                                fVar2.aQz();
                            }
                            c cVar = this.eWq;
                            str = this.eWq.mVideoUrl;
                            cVar.startPlay(str);
                            return;
                        }
                        int id3 = view.getId();
                        imageView2 = this.eWq.dwx;
                        if (id3 == imageView2.getId()) {
                            if (this.eWq.cHV) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11714"));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11710"));
                            }
                            this.eWq.azr();
                            return;
                        }
                        int id4 = view.getId();
                        imageView3 = this.eWq.dwE;
                        if (id4 == imageView3.getId()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11713"));
                            this.eWq.azr();
                            return;
                        } else if (view.getId() != this.eWq.dwp.getId() || !this.eWq.dwG) {
                            return;
                        } else {
                            this.eWq.aYP();
                            return;
                        }
                    }
                    dVar = this.eWq.eWn;
                    if (dVar != null) {
                        dVar2 = this.eWq.eWn;
                        dVar2.aQy();
                        return;
                    }
                    return;
                }
            }
            this.eWq.aQv();
            return;
        }
        this.eWq.aYO();
    }
}
