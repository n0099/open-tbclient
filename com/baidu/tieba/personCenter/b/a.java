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
    private boolean bLG;
    private CustomMessageListener bPQ = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private com.baidu.tieba.personCenter.f.b eFf;
    private g eFg;
    private com.baidu.tieba.e.a eFo;

    public a(TbPageContext tbPageContext, com.baidu.tieba.personCenter.f.b bVar, g gVar) {
        this.eFf = bVar;
        this.eFg = gVar;
        this.eFo = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.eFf.a(this);
        tbPageContext.registerListener(this.bPQ);
    }

    public m aSN() {
        return this.eFo;
    }

    @Override // com.baidu.tieba.model.a
    public void RL() {
        this.eFf.Fa();
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
    }

    @Override // com.baidu.tieba.model.a
    public boolean hasMoreData() {
        return false;
    }

    @Override // com.baidu.tieba.personCenter.f.a
    public void a(com.baidu.tieba.personCenter.c.a aVar) {
        this.eFg.JE();
        if (aVar == null) {
            if (!this.bLG) {
                this.eFg.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
                return;
            }
            return;
        }
        this.bLG = true;
        this.eFg.b(aVar);
    }

    public boolean hasData() {
        return this.bLG;
    }
}
