package com.baidu.tieba.play;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar) {
        this.fbb = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        int i;
        c.f fVar;
        String str;
        c.f fVar2;
        c.d dVar;
        c.d dVar2;
        int id = view.getId();
        view2 = this.fbb.bCL;
        if (id != view2.getId()) {
            if (view.getId() != this.fbb.bCH.getId()) {
                int id2 = view.getId();
                imageView = this.fbb.dvX;
                if (id2 != imageView.getId()) {
                    if (view.getId() != this.fbb.faR.getId()) {
                        if (view.getId() == this.fbb.faQ.getId()) {
                            fVar = this.fbb.faY;
                            if (fVar != null) {
                                fVar2 = this.fbb.faY;
                                fVar2.aOZ();
                            }
                            c cVar = this.fbb;
                            str = this.fbb.mVideoUrl;
                            cVar.startPlay(str);
                            return;
                        }
                        int id3 = view.getId();
                        imageView2 = this.fbb.dvY;
                        if (id3 == imageView2.getId()) {
                            if (this.fbb.cHz) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11714"));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11710"));
                            }
                            this.fbb.axh();
                            return;
                        }
                        int id4 = view.getId();
                        imageView3 = this.fbb.dwf;
                        if (id4 == imageView3.getId()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11713"));
                            this.fbb.axh();
                            return;
                        } else if (view.getId() == this.fbb.dvQ.getId() && this.fbb.dwh) {
                            i = this.fbb.akf;
                            if (i == 2) {
                                this.fbb.aOR();
                                return;
                            } else {
                                this.fbb.aXF();
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    dVar = this.fbb.faX;
                    if (dVar != null) {
                        dVar2 = this.fbb.faX;
                        dVar2.aPd();
                        return;
                    }
                    return;
                }
            }
            this.fbb.aOR();
            return;
        }
        this.fbb.aXE();
    }
}
