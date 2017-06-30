package com.baidu.tieba.play;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar) {
        this.flr = cVar;
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
        view2 = this.flr.bDE;
        if (id != view2.getId()) {
            if (view.getId() != this.flr.bDA.getId()) {
                int id2 = view.getId();
                imageView = this.flr.dEK;
                if (id2 != imageView.getId()) {
                    if (view.getId() != this.flr.flh.getId()) {
                        if (view.getId() == this.flr.flg.getId()) {
                            fVar = this.flr.flo;
                            if (fVar != null) {
                                fVar2 = this.flr.flo;
                                fVar2.aSY();
                            }
                            c cVar = this.flr;
                            str = this.flr.mVideoUrl;
                            cVar.startPlay(str);
                            return;
                        }
                        int id3 = view.getId();
                        imageView2 = this.flr.dEL;
                        if (id3 == imageView2.getId()) {
                            if (this.flr.cPv) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11714"));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11710"));
                            }
                            this.flr.aBg();
                            return;
                        }
                        int id4 = view.getId();
                        imageView3 = this.flr.dES;
                        if (id4 == imageView3.getId()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11713"));
                            this.flr.aBg();
                            return;
                        }
                        return;
                    }
                    dVar = this.flr.fln;
                    if (dVar != null) {
                        dVar2 = this.flr.fln;
                        dVar2.aTc();
                        return;
                    }
                    return;
                }
            }
            this.flr.aSQ();
            return;
        }
        this.flr.bbP();
    }
}
