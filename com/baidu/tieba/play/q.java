package com.baidu.tieba.play;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar) {
        this.eSu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        c.e eVar;
        c.e eVar2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        c.f fVar;
        String str;
        c.f fVar2;
        c.d dVar;
        c.d dVar2;
        int id = view.getId();
        view2 = this.eSu.aNh;
        if (id != view2.getId()) {
            if (view.getId() != this.eSu.aNc.getId()) {
                int id2 = view.getId();
                imageView = this.eSu.dvl;
                if (id2 != imageView.getId()) {
                    if (view.getId() != this.eSu.eSo.getId()) {
                        if (view.getId() == this.eSu.eSn.getId()) {
                            fVar = this.eSu.eSt;
                            if (fVar != null) {
                                fVar2 = this.eSu.eSt;
                                fVar2.aPM();
                            }
                            c cVar = this.eSu;
                            str = this.eSu.aOm;
                            cVar.startPlay(str);
                            return;
                        }
                        int id3 = view.getId();
                        imageView2 = this.eSu.dvm;
                        if (id3 == imageView2.getId()) {
                            if (this.eSu.cFI) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11714"));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11710"));
                            }
                            this.eSu.azp();
                            return;
                        }
                        int id4 = view.getId();
                        imageView3 = this.eSu.dvt;
                        if (id4 == imageView3.getId()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11713"));
                            this.eSu.azp();
                            return;
                        } else if (view.getId() != this.eSu.dvf.getId() || !this.eSu.dvu) {
                            return;
                        } else {
                            this.eSu.aYc();
                            return;
                        }
                    }
                    dVar = this.eSu.eSs;
                    if (dVar != null) {
                        dVar2 = this.eSu.eSs;
                        dVar2.aPL();
                        return;
                    }
                    return;
                }
            }
            if (!com.baidu.adp.lib.util.i.gk()) {
                tbPageContext = this.eSu.Fp;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.eSu.Fp;
                com.baidu.adp.lib.util.k.m(pageActivity, tbPageContext2.getString(r.l.neterror));
                return;
            } else if (!this.eSu.aMY.isPlaying()) {
                if (this.eSu.dvu) {
                    this.eSu.amW();
                    eVar = this.eSu.etz;
                    if (eVar != null) {
                        eVar2 = this.eSu.etz;
                        eVar2.aPK();
                        return;
                    }
                    return;
                }
                this.eSu.aYb();
                return;
            } else {
                this.eSu.pausePlay();
                return;
            }
        }
        this.eSu.aYb();
    }
}
