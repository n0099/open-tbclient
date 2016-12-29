package com.baidu.tieba.play;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ c eIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.eIS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        c.InterfaceC0070c interfaceC0070c;
        c.InterfaceC0070c interfaceC0070c2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        int id = view.getId();
        view2 = this.eIS.aOe;
        if (id != view2.getId()) {
            if (view.getId() != this.eIS.aNZ.getId()) {
                int id2 = view.getId();
                imageView = this.eIS.dnt;
                if (id2 != imageView.getId()) {
                    int id3 = view.getId();
                    imageView2 = this.eIS.eIr;
                    if (id3 == imageView2.getId()) {
                        if (this.eIS.cyE) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11714"));
                        } else {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11710"));
                        }
                        this.eIS.aWe();
                        return;
                    }
                    int id4 = view.getId();
                    imageView3 = this.eIS.eIx;
                    if (id4 == imageView3.getId()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11713"));
                        this.eIS.aWe();
                        return;
                    } else if (view.getId() == this.eIS.eIo.getId()) {
                        if (this.eIS.eIy || this.eIS.cyE) {
                            this.eIS.axO();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                tbPageContext = this.eIS.Gf;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.eIS.Gf;
                com.baidu.adp.lib.util.k.m(pageActivity, tbPageContext2.getString(r.j.neterror));
                return;
            } else if (!this.eIS.aNV.isPlaying()) {
                if (this.eIS.eIy) {
                    this.eIS.Lj();
                    interfaceC0070c = this.eIS.aSk;
                    if (interfaceC0070c != null) {
                        interfaceC0070c2 = this.eIS.aSk;
                        interfaceC0070c2.Lu();
                        return;
                    }
                    return;
                }
                this.eIS.performPlay();
                return;
            } else {
                this.eIS.pausePlay();
                return;
            }
        }
        this.eIS.performPlay();
    }
}
