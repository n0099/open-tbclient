package com.baidu.tieba.play;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar) {
        this.eSq = cVar;
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
        view2 = this.eSq.aTG;
        if (id != view2.getId()) {
            if (view.getId() != this.eSq.aTB.getId()) {
                int id2 = view.getId();
                imageView = this.eSq.dqF;
                if (id2 != imageView.getId()) {
                    if (view.getId() != this.eSq.eSh.getId()) {
                        if (view.getId() == this.eSq.eSg.getId()) {
                            fVar = this.eSq.eSo;
                            if (fVar != null) {
                                fVar2 = this.eSq.eSo;
                                fVar2.aNQ();
                            }
                            c cVar = this.eSq;
                            str = this.eSq.mVideoUrl;
                            cVar.startPlay(str);
                            return;
                        }
                        int id3 = view.getId();
                        imageView2 = this.eSq.dqG;
                        if (id3 == imageView2.getId()) {
                            if (this.eSq.cCa) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11714"));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11710"));
                            }
                            this.eSq.awo();
                            return;
                        }
                        int id4 = view.getId();
                        imageView3 = this.eSq.dqN;
                        if (id4 == imageView3.getId()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11713"));
                            this.eSq.awo();
                            return;
                        } else if (view.getId() != this.eSq.dqy.getId() || !this.eSq.dqP) {
                            return;
                        } else {
                            this.eSq.aWo();
                            return;
                        }
                    }
                    dVar = this.eSq.eSn;
                    if (dVar != null) {
                        dVar2 = this.eSq.eSn;
                        dVar2.aNP();
                        return;
                    }
                    return;
                }
            }
            this.eSq.aNM();
            return;
        }
        this.eSq.aWn();
    }
}
