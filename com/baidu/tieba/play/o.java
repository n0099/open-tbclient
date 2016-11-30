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
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.ffA = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        c.InterfaceC0076c interfaceC0076c;
        c.InterfaceC0076c interfaceC0076c2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        int id = view.getId();
        view2 = this.ffA.aON;
        if (id != view2.getId()) {
            if (view.getId() != this.ffA.aOI.getId()) {
                int id2 = view.getId();
                imageView = this.ffA.feR;
                if (id2 != imageView.getId()) {
                    int id3 = view.getId();
                    imageView2 = this.ffA.feS;
                    if (id3 == imageView2.getId()) {
                        if (this.ffA.cTv) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11714"));
                        } else {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11710"));
                        }
                        this.ffA.bct();
                        return;
                    }
                    int id4 = view.getId();
                    imageView3 = this.ffA.feY;
                    if (id4 == imageView3.getId()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11713"));
                        this.ffA.bct();
                        return;
                    } else if (view.getId() == this.ffA.feN.getId()) {
                        if (this.ffA.feZ || this.ffA.cTv) {
                            this.ffA.bcG();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                tbPageContext = this.ffA.Gf;
                Activity pageActivity = tbPageContext.getPageActivity();
                tbPageContext2 = this.ffA.Gf;
                com.baidu.adp.lib.util.k.m(pageActivity, tbPageContext2.getString(r.j.neterror));
                return;
            } else if (!this.ffA.aOE.isPlaying()) {
                if (this.ffA.feZ) {
                    this.ffA.LQ();
                    interfaceC0076c = this.ffA.aST;
                    if (interfaceC0076c != null) {
                        interfaceC0076c2 = this.ffA.aST;
                        interfaceC0076c2.Mb();
                        return;
                    }
                    return;
                }
                this.ffA.performPlay();
                return;
            } else {
                this.ffA.pausePlay();
                return;
            }
        }
        this.ffA.performPlay();
    }
}
