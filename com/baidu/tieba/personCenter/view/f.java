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
    private Bundle eZI;
    private g fbf;
    private List<com.baidu.adp.widget.ListView.f> fbg;
    private TbPageContext mH;

    public f(TbPageContext tbPageContext, Bundle bundle) {
        this.mH = tbPageContext;
        this.eZI = bundle;
        this.fbf = new g(tbPageContext);
    }

    public void initView() {
        this.mH.getPageActivity().setContentView(d.j.person_center_more_layout);
        this.fbf.X(this.mH.getPageActivity().findViewById(d.h.person_more_layout));
        aVs();
        this.fbf.setData(this.fbg);
    }

    private void aVs() {
        this.fbg = new ArrayList();
        com.baidu.tieba.personCenter.c.e eVar = new com.baidu.tieba.personCenter.c.e();
        eVar.title = this.mH.getString(d.l.consumption_records);
        eVar.type = 13;
        if (this.eZI != null) {
            eVar.cRn = this.eZI.getString(PersonMoreActivityConfig.CONSUME_RECORD, null);
        }
        this.fbg.add(eVar);
        if (this.eZI != null) {
            String string = this.eZI.getString(PersonMoreActivityConfig.FUN_NAME, null);
            if (!StringUtils.isNull(string)) {
                com.baidu.tieba.personCenter.c.e eVar2 = new com.baidu.tieba.personCenter.c.e();
                eVar2.title = this.mH.getString(d.l.fun);
                eVar2.type = 35;
                eVar2.cRn = string;
                this.fbg.add(eVar2);
            }
        }
        if (this.eZI != null) {
            String string2 = this.eZI.getString(PersonMoreActivityConfig.LOVE_BEAN_NAME, null);
            if (!StringUtils.isNull(string2)) {
                com.baidu.tieba.personCenter.c.e eVar3 = new com.baidu.tieba.personCenter.c.e();
                eVar3.title = this.mH.getString(d.l.love_bean);
                eVar3.type = 36;
                eVar3.cRn = string2;
                this.fbg.add(eVar3);
            }
        }
        com.baidu.tieba.personCenter.c.e eVar4 = new com.baidu.tieba.personCenter.c.e();
        eVar4.title = this.mH.getString(d.l.book_shel);
        eVar4.type = 30;
        if (this.eZI != null) {
            String string3 = this.eZI.getString(PersonMoreActivityConfig.BOOK_SHELF, null);
            if (!StringUtils.isNull(string3)) {
                eVar4.cRn = string3;
            }
            this.fbg.add(eVar4);
        }
    }
}
