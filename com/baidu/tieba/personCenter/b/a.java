package com.baidu.tieba.personCenter.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personCenter.f.g;
import com.baidu.tieba.personCenter.mode.PersonCenterMode;
import com.baidu.tieba.view.m;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.model.a, com.baidu.tieba.personCenter.mode.a {
    private boolean bJl;
    private CustomMessageListener bNv = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private com.baidu.tieba.f.a eAA;
    private PersonCenterMode eAp;
    private g eAq;

    public a(TbPageContext tbPageContext, PersonCenterMode personCenterMode, g gVar) {
        this.eAp = personCenterMode;
        this.eAq = gVar;
        this.eAA = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.eAp.a(this);
        tbPageContext.registerListener(this.bNv);
    }

    public m aQq() {
        return this.eAA;
    }

    @Override // com.baidu.tieba.model.a
    public void Oc() {
        this.eAp.FC();
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
    }

    @Override // com.baidu.tieba.model.a
    public boolean QP() {
        return false;
    }

    @Override // com.baidu.tieba.personCenter.mode.a
    public void a(com.baidu.tieba.personCenter.c.a aVar) {
        this.eAq.KC();
        if (aVar == null) {
            if (!this.bJl && TbadkCoreApplication.isLogin()) {
                this.eAq.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
                return;
            }
            return;
        }
        this.bJl = true;
        this.eAq.b(aVar);
    }

    public boolean hasData() {
        return this.bJl;
    }
}
