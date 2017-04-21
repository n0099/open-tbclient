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
    private boolean bLC;
    private CustomMessageListener bPM = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private PersonCenterMode eCF;
    private g eCG;
    private com.baidu.tieba.f.a eCQ;

    public a(TbPageContext tbPageContext, PersonCenterMode personCenterMode, g gVar) {
        this.eCF = personCenterMode;
        this.eCG = gVar;
        this.eCQ = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.eCF.a(this);
        tbPageContext.registerListener(this.bPM);
    }

    public m aRr() {
        return this.eCQ;
    }

    @Override // com.baidu.tieba.model.a
    public void Ol() {
        this.eCF.FC();
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
    }

    @Override // com.baidu.tieba.model.a
    public boolean RR() {
        return false;
    }

    @Override // com.baidu.tieba.personCenter.mode.a
    public void a(com.baidu.tieba.personCenter.c.a aVar) {
        this.eCG.KC();
        if (aVar == null) {
            if (!this.bLC && TbadkCoreApplication.isLogin()) {
                this.eCG.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
                return;
            }
            return;
        }
        this.bLC = true;
        this.eCG.b(aVar);
    }

    public boolean hasData() {
        return this.bLC;
    }
}
