package com.baidu.tieba.personCenter.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personCenter.f.g;
import com.baidu.tieba.personCenter.mode.PersonCenterMode;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.model.a, com.baidu.tieba.personCenter.mode.a {
    private boolean bCl;
    private CustomMessageListener bGx = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private PersonCenterMode eyV;
    private g eyW;
    private com.baidu.tieba.g.a eze;

    public a(TbPageContext tbPageContext, PersonCenterMode personCenterMode, g gVar) {
        this.eyV = personCenterMode;
        this.eyW = gVar;
        this.eze = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.eyV.a(this);
        tbPageContext.registerListener(this.bGx);
    }

    public m aQE() {
        return this.eze;
    }

    @Override // com.baidu.tieba.model.a
    public void MR() {
        this.eyV.EH();
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
    }

    @Override // com.baidu.tieba.model.a
    public boolean Py() {
        return false;
    }

    @Override // com.baidu.tieba.personCenter.mode.a
    public void a(com.baidu.tieba.personCenter.c.a aVar) {
        this.eyW.Jx();
        if (aVar == null) {
            if (!this.bCl) {
                this.eyW.G(TbadkCoreApplication.m9getInst().getString(r.l.neterror), true);
                return;
            }
            return;
        }
        this.bCl = true;
        this.eyW.b(aVar);
    }

    public boolean hasData() {
        return this.bCl;
    }
}
