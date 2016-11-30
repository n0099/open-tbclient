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
    private boolean bOz;
    private CustomMessageListener bSN = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private com.baidu.tieba.personCenter.f.b eLE;
    private g eLF;
    private com.baidu.tieba.e.a eLN;

    public a(TbPageContext tbPageContext, com.baidu.tieba.personCenter.f.b bVar, g gVar) {
        this.eLE = bVar;
        this.eLF = gVar;
        this.eLN = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.eLE.a(this);
        tbPageContext.registerListener(this.bSN);
    }

    public m aUU() {
        return this.eLN;
    }

    @Override // com.baidu.tieba.model.a
    public void SN() {
        this.eLE.Ff();
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
        this.eLF.JO();
        if (aVar == null) {
            if (!this.bOz) {
                this.eLF.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
                return;
            }
            return;
        }
        this.bOz = true;
        this.eLF.b(aVar);
    }

    public boolean hasData() {
        return this.bOz;
    }
}
