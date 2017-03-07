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
    private boolean bJs;
    private CustomMessageListener bNG = new b(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private com.baidu.tieba.f.a eCD;
    private PersonCenterMode eCu;
    private g eCv;

    public a(TbPageContext tbPageContext, PersonCenterMode personCenterMode, g gVar) {
        this.eCu = personCenterMode;
        this.eCv = gVar;
        this.eCD = new com.baidu.tieba.personCenter.d.b(tbPageContext);
        this.eCu.a(this);
        tbPageContext.registerListener(this.bNG);
    }

    public m aQh() {
        return this.eCD;
    }

    @Override // com.baidu.tieba.model.a
    public void NE() {
        this.eCu.Fe();
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
    }

    @Override // com.baidu.tieba.model.a
    public boolean Qr() {
        return false;
    }

    @Override // com.baidu.tieba.personCenter.mode.a
    public void a(com.baidu.tieba.personCenter.c.a aVar) {
        this.eCv.Kc();
        if (aVar == null) {
            if (!this.bJs) {
                this.eCv.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
                return;
            }
            return;
        }
        this.bJs = true;
        this.eCv.b(aVar);
    }

    public boolean hasData() {
        return this.bJs;
    }
}
