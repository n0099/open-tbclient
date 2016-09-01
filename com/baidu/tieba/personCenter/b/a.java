package com.baidu.tieba.personCenter.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personCenter.g.g;
import com.baidu.tieba.t;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.model.a, com.baidu.tieba.personCenter.f.a {
    private boolean bLF;
    private CustomMessageListener bPX = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private com.baidu.tieba.personCenter.f.b eDc;
    private g eDd;
    private com.baidu.tieba.f.a eDl;

    public a(TbPageContext tbPageContext, com.baidu.tieba.personCenter.f.b bVar, g gVar) {
        this.eDc = bVar;
        this.eDd = gVar;
        this.eDl = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.eDc.a(this);
        tbPageContext.registerListener(this.bPX);
    }

    public m aSp() {
        return this.eDl;
    }

    @Override // com.baidu.tieba.model.a
    public void Rt() {
        this.eDc.Fa();
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
        this.eDd.Lb();
        if (aVar == null) {
            if (!this.bLF) {
                this.eDd.F(TbadkCoreApplication.m9getInst().getString(t.j.neterror), true);
                return;
            }
            return;
        }
        this.bLF = true;
        this.eDd.b(aVar);
    }

    public boolean hasData() {
        return this.bLF;
    }
}
