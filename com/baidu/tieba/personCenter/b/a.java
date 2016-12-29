package com.baidu.tieba.personCenter.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personCenter.g.g;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.model.a, com.baidu.tieba.personCenter.f.a {
    private boolean buE;
    private CustomMessageListener byX = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private com.baidu.tieba.personCenter.f.b epa;
    private g epb;
    private com.baidu.tieba.e.a epj;

    public a(TbPageContext tbPageContext, com.baidu.tieba.personCenter.f.b bVar, g gVar) {
        this.epa = bVar;
        this.epb = gVar;
        this.epj = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.epa.a(this);
        tbPageContext.registerListener(this.byX);
    }

    public m aOE() {
        return this.epj;
    }

    @Override // com.baidu.tieba.model.a
    public void Tj() {
        this.epa.EN();
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
    }

    @Override // com.baidu.tieba.model.a
    public boolean aEa() {
        return false;
    }

    @Override // com.baidu.tieba.personCenter.f.a
    public void a(com.baidu.tieba.personCenter.c.a aVar) {
        this.epb.Jj();
        if (aVar == null) {
            if (!this.buE) {
                this.epb.H(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
                return;
            }
            return;
        }
        this.buE = true;
        this.epb.b(aVar);
    }

    public boolean hasData() {
        return this.buE;
    }
}
