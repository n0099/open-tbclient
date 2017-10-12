package com.baidu.tieba.personCenter.view;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private Bundle eZW;
    private g fbt;
    private List<com.baidu.adp.widget.ListView.f> fbu;
    private TbPageContext mG;

    public f(TbPageContext tbPageContext, Bundle bundle) {
        this.mG = tbPageContext;
        this.eZW = bundle;
        this.fbt = new g(tbPageContext);
    }

    public void initView() {
        this.mG.getPageActivity().setContentView(d.j.person_center_more_layout);
        this.fbt.X(this.mG.getPageActivity().findViewById(d.h.person_more_layout));
        aVx();
        this.fbt.setData(this.fbu);
    }

    private void aVx() {
        this.fbu = new ArrayList();
        com.baidu.tieba.personCenter.c.e eVar = new com.baidu.tieba.personCenter.c.e();
        eVar.title = this.mG.getString(d.l.consumption_records);
        eVar.type = 13;
        if (this.eZW != null) {
            eVar.cRz = this.eZW.getString(PersonMoreActivityConfig.CONSUME_RECORD, null);
        }
        this.fbu.add(eVar);
        if (this.eZW != null) {
            String string = this.eZW.getString(PersonMoreActivityConfig.FUN_NAME, null);
            if (!StringUtils.isNull(string)) {
                com.baidu.tieba.personCenter.c.e eVar2 = new com.baidu.tieba.personCenter.c.e();
                eVar2.title = this.mG.getString(d.l.fun);
                eVar2.type = 35;
                eVar2.cRz = string;
                this.fbu.add(eVar2);
            }
        }
        if (this.eZW != null) {
            String string2 = this.eZW.getString(PersonMoreActivityConfig.LOVE_BEAN_NAME, null);
            if (!StringUtils.isNull(string2)) {
                com.baidu.tieba.personCenter.c.e eVar3 = new com.baidu.tieba.personCenter.c.e();
                eVar3.title = this.mG.getString(d.l.love_bean);
                eVar3.type = 36;
                eVar3.cRz = string2;
                this.fbu.add(eVar3);
            }
        }
        com.baidu.tieba.personCenter.c.e eVar4 = new com.baidu.tieba.personCenter.c.e();
        eVar4.title = this.mG.getString(d.l.book_shel);
        eVar4.type = 30;
        if (this.eZW != null) {
            String string3 = this.eZW.getString(PersonMoreActivityConfig.BOOK_SHELF, null);
            if (!StringUtils.isNull(string3)) {
                eVar4.cRz = string3;
            }
            this.fbu.add(eVar4);
        }
    }
}
